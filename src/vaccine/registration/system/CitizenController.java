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
import java.util.Optional;

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








    public int calculatePeople_ID() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("People.txt"));
        Integer id
                = reader.lines().map(line -> line.split("//"))
                        .map(data -> new PeopleRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]))
                        .reduce((first, second) -> second)
                        .get()
                        .People_ID();

        // FileController fc = new FileController();
        // fc.fileAccess("People.txt");
        //         System.out.println(fc.fileAccess("People.txt"));
        //.map(data -> new CitizenRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]));
//                
//                
//                
//                .map(data -> new CitizenRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]))
//                .reduce((first, second) -> second)
//                .get()
//                .People_ID();
        //read data to collection 
        // List<PeopleRecord> people = Files.lines(Paths.get("People.txt"))
        // .map(line -> line.split("//"))
        // .map(data -> new PeopleRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]))
        // .collect(Collectors.toList());
        return id + 1;
    }

}
