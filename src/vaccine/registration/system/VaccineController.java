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
import java.util.stream.Collectors;

public class VaccineController {

    // Calculate vaccine ID
    public int calcualte_Vaccine_ID() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("Vaccine.txt"));
        Integer id
                = reader.lines().map(line -> line.split("//"))
                        .map(data -> new VaccineRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6])))
                        .reduce((first, second) -> second)
                        .get()
                        .Vaccine_ID();
        return id + 1;
    }

    // Add vaccine
    public boolean Add_Vaccine(VaccineRecord newVaccineRecord) throws IOException {
        boolean data_exist;
        PrintWriter add_vaccine = new PrintWriter(new BufferedWriter(new FileWriter("Vaccine.txt", true)));
        BufferedReader vaccine = new BufferedReader(new FileReader("Vaccine.txt"));
        data_exist
                = vaccine.lines()
                        .map(line -> line.split("//"))
                        .map(data -> new VaccineRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6])))
                        .anyMatch(vac -> vac.Center_ID() == newVaccineRecord.Center_ID() && vac.Vaccine_Batch_ID().equals(newVaccineRecord.Vaccine_Batch_ID()) && vac.Vaccine_Type().equals(newVaccineRecord.Vaccine_Type()) && vac.date().equals(newVaccineRecord.date()));

        if (!data_exist) {
            // Insert data (not match)
            add_vaccine.append(newVaccineRecord.Vaccine_ID() + "//" + newVaccineRecord.Vaccine_Batch_ID() + "//" + newVaccineRecord.Vaccine_Type() + "//" + newVaccineRecord.date() + "//" + newVaccineRecord.Expiration_Date() + "//" + newVaccineRecord.Second_Dose_Gap() + "//" + newVaccineRecord.Center_ID() + "//");
            add_vaccine.print("\n");
            add_vaccine.close();
            return true;
        }
        return false;
    }

    // View vaccine
    public List<VaccineRecord> View_Vaccine() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("Vaccine.txt"));
        return reader.lines()
                .map(line -> line.split("//"))
                .map(data -> new VaccineRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6])))
                .collect(Collectors.toList());
    }

    //edit vaccine
    public boolean Edit_Vaccine(VaccineRecord editVaccineRecord) throws IOException {
        List<VaccineRecord> vaccineList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Vaccine.txt"));
        vaccineList = bufferedReader.lines()
                .map(line -> line.split("//"))
                .map(data -> new VaccineRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6])))
                .collect(Collectors.toList());
        bufferedReader.close();

        // Update data
        boolean dataExist = vaccineList.stream()
                .anyMatch(vaccine -> vaccine.Vaccine_Batch_ID() == editVaccineRecord.Vaccine_Batch_ID() && vaccine.Center_ID() == editVaccineRecord.Center_ID() && vaccine.Vaccine_Type().equals(editVaccineRecord.Vaccine_Type()) && vaccine.date().equals(editVaccineRecord.date()));
        if (dataExist) {
            return false;
        } else {
            List<VaccineRecord> updateVaccineList = vaccineList.stream()
                    .map(vaccine -> {
                        if (vaccine.Vaccine_ID() == editVaccineRecord.Vaccine_ID()) {
                            return new VaccineRecord(editVaccineRecord.Vaccine_ID(), editVaccineRecord.Vaccine_Batch_ID(), editVaccineRecord.Vaccine_Type(), editVaccineRecord.date(), editVaccineRecord.Expiration_Date(), editVaccineRecord.Second_Dose_Gap(), editVaccineRecord.Center_ID());
                        } else {
                            return vaccine;
                        }
                    })
                    .collect(Collectors.toList());
            // Write data
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Vaccine.txt", false)));
            updateVaccineList.stream()
                    .forEach(vaccine -> {
                        printWriter.printf("%s//%s//%s//%s//%s//%s//%s//\n", vaccine.Vaccine_ID(), vaccine.Vaccine_Batch_ID(), vaccine.Vaccine_Type(), vaccine.date(), vaccine.Expiration_Date(), vaccine.Second_Dose_Gap(), vaccine.Center_ID());
                    });
            printWriter.close();
            return true;
        }
    }

    //remove vaccine
    public boolean Remove_Vaccine(int vaccine_id) throws IOException {
        List<VaccineRecord> vaccineList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Vaccine.txt"));
        vaccineList = bufferedReader.lines()
                .map(line -> line.split("//"))
                .map(data -> new VaccineRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6])))
                .filter(vac -> vac.Vaccine_ID() != vaccine_id)
                .collect(Collectors.toList());
        bufferedReader.close();
        // Write data
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Vaccine.txt", false)));
        vaccineList.stream()
                .forEach(vaccine -> {
                    printWriter.printf("%s//%s//%s//%s//%s//%s//%s//\n", vaccine.Vaccine_ID(), vaccine.Vaccine_Batch_ID(), vaccine.Vaccine_Type(), vaccine.date(), vaccine.Expiration_Date(), vaccine.Second_Dose_Gap(), vaccine.Center_ID());
                });
        printWriter.close();
        return true;

    }

}
