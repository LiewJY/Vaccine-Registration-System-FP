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
import java.util.stream.Stream;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class CenterController {

    // Calculate center ID
    public int calculateCenter_ID() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("Center.txt"));
        Integer id
                = reader.lines().map(line -> line.split("//"))
                        .map(data -> new CenterRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]))
                        .reduce((first, second) -> second)
                        .get()
                        .Center_ID();
        return id + 1;
    }

    // Add center
    public boolean Add_Center(CenterRecord newCenterRecord) throws IOException {
        boolean data_exist;
        PrintWriter add_center = new PrintWriter(new BufferedWriter(new FileWriter("Center.txt", true)));
        BufferedReader center = new BufferedReader(new FileReader("Center.txt"));
        data_exist
                = center.lines()
                        .map(line -> line.split("//"))
                        .map(data -> new CenterRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]))
                        .anyMatch(location -> location.Center_Name().equals(newCenterRecord.Center_Name()));

        if (!data_exist) {
            // Insert data (not match)
            add_center.append(newCenterRecord.Center_ID() + "//" + newCenterRecord.Center_Name() + "//" + newCenterRecord.Center_Address() + "//" + newCenterRecord.Center_Contact_Number() + "//" + newCenterRecord.Vaccine_Type() + "//");
            add_center.print("\n");
            add_center.close();
            return true;
        }
        return false;
    }

    // View center
    public List<CenterRecord> View_Center() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("Center.txt"));

        return reader.lines()
                .map(line -> line.split("//"))
                .map(data -> new CenterRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]))
                .collect(Collectors.toList());
    }

    //edit center
    public boolean Edit_Center(CenterRecord editCenterRecord) throws IOException {
        List<CenterRecord> centerList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Center.txt"));
        centerList = bufferedReader.lines()
                .map(line -> {
                    String[] data = line.split("//");
                    return new CenterRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]);
                })
                .collect(Collectors.toList());
        bufferedReader.close();

        // Update data
        boolean dataExist = centerList.stream()
                .anyMatch(center -> center.Center_ID() == editCenterRecord.Center_ID() && center.Center_Name().equals(editCenterRecord.Center_Name()));
        if (!dataExist) {
            return false;
        } else {
            List<CenterRecord> updateCenterList = centerList.stream()
                    .map(center -> {
                        if (center.Center_ID() == editCenterRecord.Center_ID()) {
                            return new CenterRecord(editCenterRecord.Center_ID(), editCenterRecord.Center_Name(), editCenterRecord.Center_Address(), editCenterRecord.Center_Contact_Number(), editCenterRecord.Vaccine_Type());
                        } else {
                            return center;
                        }
                    })
                    .collect(Collectors.toList());
            // Write data
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Center.txt", false)));
            updateCenterList.stream()
                    .forEach(center -> {
                        printWriter.printf("%s//%s//%s//%s//%s//\n", center.Center_ID(), center.Center_Name(), center.Center_Address(), center.Center_Contact_Number(), center.Vaccine_Type());
                    });
            printWriter.close();
            return true;
        }
    }

    // Remove center
    public boolean Remove_Center(int center_id) throws IOException {
        List<CenterRecord> centerList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Center.txt"));
        centerList = bufferedReader.lines()
                .map(line -> {
                    String[] data = line.split("//");
                    return new CenterRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]);
                }).filter(center -> center.Center_ID() != center_id
        )
                .collect(Collectors.toList());
        bufferedReader.close();
        // Write data
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Center.txt", false)));
        centerList.stream()
                .forEach(center -> {
                    printWriter.printf("%s//%s//%s//%s//%s//\n", center.Center_ID(), center.Center_Name(), center.Center_Address(), center.Center_Contact_Number(), center.Vaccine_Type());
                });
        printWriter.close();
        return true;

    }

}
