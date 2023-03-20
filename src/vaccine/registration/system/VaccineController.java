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
import java.io.PrintWriter;

/**
 *
 * @author liewjy
 */
public class VaccineController {

    // Calculate vaccine ID
    public int calcualte_Vaccine_ID() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("Vaccine.txt"));
        Integer id
                = reader.lines().map(line -> line.split("//"))
                        .map(data -> new VaccineRecord(Integer.parseInt(data[0]),data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6])))
                        .reduce((first, second) -> second)
                        .get()
                        .Vaccine_ID();
        return id + 1;
    }

  // Add vaccine
  public void Add_Vaccine(String center_id) {
    // String line;
    // String[] line_array;
    boolean data_exist = false;
    
  //  PrintWriter add_vaccine = new PrintWriter(new BufferedWriter(new FileWriter("Vaccine.txt", true)));


          //  FileReader vaccine_file = new FileReader("Vaccine.txt");
          //   BufferedReader vaccine = new BufferedReader(vaccine_file);
            
            // Check ID
            // while ((line = vaccine.readLine()) != null) {
            //     line_array = line.split("//");

            //     if (line_array[1].equals(Vaccine_Batch_ID) && line_array[2].equals(Vaccine_Type) && line_array[3].equals(date) && line_array[6].equals(center_id)){
            //         Success_Save = false;
            //         data_exist = true;
            //         break;
            //     } else {
            //         Success_Save = true;
            //         data_exist = false;
            //     }
            // }
            
            // if(data_exist == false) {                   
            //     // Insert data (not match)
            //     add_vaccine.append(Vaccine_ID + "//");
            //     add_vaccine.append(Vaccine_Batch_ID + "//");
            //     add_vaccine.append(Vaccine_Type + "//");
            //     add_vaccine.append(date + "//");
            //     add_vaccine.append(Expiration_Date + "//");
            //     add_vaccine.append(Second_Dose_Gap + "//");
            //     // Add center IF and name for the txt file
            //     add_vaccine.append(center_id + "//");
            //     add_vaccine.print("\n");
            //     add_vaccine.close();
            //     Success_Save = true;
            // }
        
}



}
