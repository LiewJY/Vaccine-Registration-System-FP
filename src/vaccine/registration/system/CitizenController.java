/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccine.registration.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author liewjy
 */
public class CitizenController {

    //Login Account
    public AuthRecord Login_Account(String IC_Number, String Password) throws FileNotFoundException {
        BufferedReader citizen = new BufferedReader(new FileReader("People.txt"));
        Optional<CitizenRecord> row = citizen.lines().map(line -> line.split("//"))
                .map(data -> new CitizenRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]))
                .filter(person -> person.Nationality().equals("Malaysia") && person.IC_Number().equals(IC_Number) && person.Password().equals(Password)).findFirst();

        return new AuthRecord(row.isPresent(), row.isPresent() ? row.get().People_ID() : null, true);
    }

    // View account
    public Optional<CitizenRecord> View_Account(int People_ID) throws FileNotFoundException {
        BufferedReader citizen = new BufferedReader(new FileReader("People.txt"));

        return citizen.lines().map(line -> line.split("//"))
                .map(data -> new CitizenRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]))
                .filter(person -> person.People_ID() == People_ID)
                .findFirst();
    }

    //register
    public boolean Register_Account(CitizenRecord newCitizenRecord) throws IOException {
        boolean data_exist;
        PrintWriter register_citizen = new PrintWriter(new BufferedWriter(new FileWriter("People.txt", true)));
        BufferedReader people = new BufferedReader(new FileReader("People.txt"));
        data_exist
                = people.lines()
                        .map(line -> line.split("//"))
                        .map(data -> new CitizenRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]))
                        .anyMatch(person -> person.People_ID() == newCitizenRecord.People_ID() || person.IC_Number().equals(newCitizenRecord.IC_Number()));

        if (!data_exist) {
            // Insert data (not match)
            register_citizen.append(newCitizenRecord.People_ID() + "//" + newCitizenRecord.Name() + "//" + newCitizenRecord.Phone_Number() + "//" + newCitizenRecord.Nationality() + "//" + newCitizenRecord.IC_Number() + "//" + newCitizenRecord.Address() + "//" + newCitizenRecord.Password() + "//");
            register_citizen.print("\n");
            register_citizen.close();
            //Success_Save = true;
            return true;
        }
        return false;
    }

    //Edit account
    public boolean Edit_Account(CitizenRecord editCitizenRecord) throws IOException {
        List<CitizenRecord> citizenList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("People.txt"));
        citizenList = bufferedReader.lines()
                .map(line -> {
                    String[] data = line.split("//");
                    return new CitizenRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]);
                })
                .collect(Collectors.toList());
        bufferedReader.close();

        // Update data
        boolean dataExist = citizenList.stream()
                .anyMatch(citizen -> citizen.People_ID() == editCitizenRecord.People_ID() && citizen.IC_Number().equals(editCitizenRecord.IC_Number()));
        if (!dataExist) {
            return false;
        } else {
            List<CitizenRecord> updatedCitizenList = citizenList.stream()
                    .map(citizen -> {
                        if (citizen.People_ID() == editCitizenRecord.People_ID()) {
                            return new CitizenRecord(editCitizenRecord.People_ID(), editCitizenRecord.Name(), editCitizenRecord.Phone_Number(), editCitizenRecord.Nationality(), editCitizenRecord.IC_Number(), editCitizenRecord.Address(), editCitizenRecord.Password());
                        } else {
                            return citizen;
                        }
                    })
                    .collect(Collectors.toList());
            // Write data
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("People.txt", false)));
            updatedCitizenList.stream()
                    .forEach(citizen -> {
                        printWriter.printf("%s//%s//%s//%s//%s//%s//%s//\n", citizen.People_ID(), citizen.Name(), citizen.Phone_Number(), citizen.Nationality(), citizen.IC_Number(), citizen.Address(), citizen.Password());
                    });
            printWriter.close();
            return true;
        }

    }


}
