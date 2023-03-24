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

public class PersonnelController {
    //Login Account

    public PersonnelAuthRecord Login_Account(String IC_Number, String Password) throws FileNotFoundException {
        BufferedReader personnel = new BufferedReader(new FileReader("Personnel.txt"));
        Optional<PersonnelRecord> row = personnel.lines().map(line -> line.split("//"))
                .map(data -> new PersonnelRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]))
                .filter(person -> person.Nationality().equals("Malaysia") && person.IC_Number().equals(IC_Number) && person.Password().equals(Password)).findFirst();

        return new PersonnelAuthRecord(row.isPresent(), row.isPresent() ? row.get().Personnel_ID() : null);
    }

    // View account
    public Optional<PersonnelRecord> View_Account(int Personnel_ID) throws FileNotFoundException {
        BufferedReader citizen = new BufferedReader(new FileReader("Personnel.txt"));

        return citizen.lines().map(line -> line.split("//"))
                .map(data -> new PersonnelRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]))
                .filter(person -> person.Personnel_ID() == Personnel_ID)
                .findFirst();
    }

    public boolean Edit_Account(PersonnelRecord editPersonnelRecord) throws IOException {
        List<PersonnelRecord> personnelList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Personnel.txt"));
        personnelList = bufferedReader.lines()
                .map(line -> {
                    String[] data = line.split("//");
                    return new PersonnelRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]);
                })
                .collect(Collectors.toList());
        bufferedReader.close();

        // Update data
        boolean dataExist = personnelList.stream()
                .anyMatch(personnel -> personnel.Personnel_ID() == editPersonnelRecord.Personnel_ID() && personnel.IC_Number().equals(editPersonnelRecord.IC_Number()));
        if (!dataExist) {
            return false;
        } else {
            List<PersonnelRecord> updatePersonnelList = personnelList.stream()
                    .map(personnel -> {
                        if (personnel.Personnel_ID() == editPersonnelRecord.Personnel_ID()) {
                            return new PersonnelRecord(editPersonnelRecord.Personnel_ID(), editPersonnelRecord.Name(), editPersonnelRecord.Phone_Number(), editPersonnelRecord.Nationality(), editPersonnelRecord.IC_Number(), editPersonnelRecord.Address(), editPersonnelRecord.Password());
                        } else {
                            return personnel;
                        }
                    })
                    .collect(Collectors.toList());
            // Write data
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Personnel.txt", false)));
            updatePersonnelList.stream()
                    .forEach(citizen -> {
                        printWriter.printf("%s//%s//%s//%s//%s//%s//%s//\n", citizen.Personnel_ID(), citizen.Name(), citizen.Phone_Number(), citizen.Nationality(), citizen.IC_Number(), citizen.Address(), citizen.Password());
                    });
            printWriter.close();
            return true;
        }

    }

    // View people
    public List<PeopleRecord> View_People() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("People.txt"));
        return reader.lines()
                .map(line -> line.split("//"))
                .map(data -> new PeopleRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]))
                .collect(Collectors.toList());
    }

}
