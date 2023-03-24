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

public class NonCitizenController {

    //Login Account
    public AuthRecord Login_Account(String Passport_Number, String Password) throws FileNotFoundException {
        BufferedReader nonCitizen = new BufferedReader(new FileReader("People.txt"));
        Optional<NonCitizenRecord> row = nonCitizen.lines().map(line -> line.split("//"))
                .map(data -> new NonCitizenRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]))
                .filter(person -> !person.Nationality().equals("Malaysia") && person.Passport_Number().equals(Passport_Number) && person.Password().equals(Passport_Number)).findFirst();

        return new AuthRecord(row.isPresent(), row.isPresent() ? row.get().People_ID() : null, false);
    }

    // View account
    public Optional<NonCitizenRecord> View_Account(int People_ID) throws FileNotFoundException {
        BufferedReader nonCitizen = new BufferedReader(new FileReader("People.txt"));

        return nonCitizen.lines().map(line -> line.split("//"))
                .map(data -> new NonCitizenRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]))
                .filter(person -> person.People_ID() == People_ID)
                .findFirst();
    }

    //register
    public boolean Register_Account(NonCitizenRecord newNonCitizenRecord) throws IOException {
        boolean data_exist;
        PrintWriter register_non_citizen = new PrintWriter(new BufferedWriter(new FileWriter("People.txt", true)));
        BufferedReader people = new BufferedReader(new FileReader("People.txt"));
        data_exist
                = people.lines()
                        .map(line -> line.split("//"))
                        .map(data -> new NonCitizenRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]))
                        .anyMatch(person -> person.People_ID() == newNonCitizenRecord.People_ID() || person.Passport_Number().equals(newNonCitizenRecord.Passport_Number()));

        if (!data_exist) {
            // Insert data (not match)
            register_non_citizen.append(newNonCitizenRecord.People_ID() + "//" + newNonCitizenRecord.Name() + "//" + newNonCitizenRecord.Phone_Number() + "//" + newNonCitizenRecord.Nationality() + "//" + newNonCitizenRecord.Passport_Number() + "//" + newNonCitizenRecord.Address() + "//" + newNonCitizenRecord.Password() + "//");
            register_non_citizen.print("\n");
            register_non_citizen.close();
            //Success_Save = true;
            return true;
        }
        return false;
    }

    //Edit account
    public boolean Edit_Account(NonCitizenRecord editNonCitizenRecord) throws IOException {
        List<NonCitizenRecord> nonCitizenList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("People.txt"));
        nonCitizenList = bufferedReader.lines()
                .map(line -> {
                    String[] data = line.split("//");
                    return new NonCitizenRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]);
                })
                .collect(Collectors.toList());
        bufferedReader.close();

        // Update data
        boolean dataExist = nonCitizenList.stream()
                .anyMatch(nonCitizen -> nonCitizen.People_ID() == editNonCitizenRecord.People_ID() && nonCitizen.Passport_Number().equals(editNonCitizenRecord.Passport_Number()));
        if (!dataExist) {
            return false;
        } else {
            List<NonCitizenRecord> updatedCitizenList = nonCitizenList.stream()
                    .map(nonCitizen -> {
                        if (nonCitizen.People_ID() == editNonCitizenRecord.People_ID()) {
                            return new NonCitizenRecord(editNonCitizenRecord.People_ID(), editNonCitizenRecord.Name(), editNonCitizenRecord.Phone_Number(), editNonCitizenRecord.Nationality(), editNonCitizenRecord.Passport_Number(), editNonCitizenRecord.Address(), editNonCitizenRecord.Password());
                        } else {
                            return nonCitizen;
                        }
                    })
                    .collect(Collectors.toList());
            // Write data
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("People.txt", false)));
            updatedCitizenList.stream()
                    .forEach(nonCitizen -> {
                        printWriter.printf("%s//%s//%s//%s//%s//%s//%s//\n", nonCitizen.People_ID(), nonCitizen.Name(), nonCitizen.Phone_Number(), nonCitizen.Nationality(), nonCitizen.Passport_Number(), nonCitizen.Address(), nonCitizen.Password());
                    });
            printWriter.close();
            return true;
        }

    }

}
