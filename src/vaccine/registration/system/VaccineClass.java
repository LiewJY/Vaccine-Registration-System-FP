package vaccine.registration.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;


public class VaccineClass {
    private int  Vaccine_ID, Second_Dose_Gap;
    private String Vaccine_Batch_ID, Vaccine_Type;
    private String date, Expiration_Date;
    
    // for add function (no need to be in class diagram)
    protected boolean Success_Save = false;
    protected ArrayList<String> Vaccine_Data = new ArrayList<>();
    
    VaccineClass() {
        Vaccine_ID = 1;
    }
    public int getVaccine_ID() {
        return Vaccine_ID;
    }
    public void setVaccine_ID(int vaccine_id) {
        Vaccine_ID = vaccine_id;
    }
    
    public String getVaccine_Batch_ID() {
        return Vaccine_Batch_ID;
    }
    public void setVaccine_Batch_ID(String vaccine_batch_id) {
        Vaccine_Batch_ID = vaccine_batch_id;
    }
    public int getSecond_Dose_Gap() {
        return Second_Dose_Gap;
    }
    public void setSecond_Dose_Gap(int second_dose_gap) {
        Second_Dose_Gap = second_dose_gap;
    }

    public String getVaccine_Type() {
        return Vaccine_Type;
    }
    public void setVaccine_Type(String vaccine_type) {
        Vaccine_Type = vaccine_type;
    }
    public String getdate() {
        return date;
    }
    public void setdate(String date) {
        this.date = date;
    }
    public String getExpiration_Date() {
        return Expiration_Date;
    }
    public void setExpiration_Date(String expiration_date) {
        Expiration_Date = expiration_date;
    }
    // for save (add and edit) function (no need to be in class diagram)
    public boolean getSuccess_Save() {
        return Success_Save;
    }
    // data passing no need to be in class diagram
    public ArrayList<String> getVaccine_Data() {
        return Vaccine_Data;
    }
    
    
    public void calcualte_Vaccine_ID() {
        String line;
        String[] line_array;
        String lastLine;
        try {
            FileReader vaccine_file = new FileReader("Vaccine.txt");
            BufferedReader vaccine = new BufferedReader(vaccine_file);

            while ((line = vaccine.readLine()) != null) 
            {
                System.out.println(line);
                lastLine = line;
                line_array = lastLine.split("//");
                Vaccine_ID = Integer.parseInt(line_array[0]) + 1;
                System.out.println(Integer.parseInt(line_array[0]) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Add_Vaccine(String center_id) {
        String line;
        String[] line_array;
        try (PrintWriter add_vaccine = new PrintWriter(new BufferedWriter(new FileWriter("Vaccine.txt", true)))) {
            try { 
                FileReader vaccine_file = new FileReader("Vaccine.txt");
                BufferedReader vaccine = new BufferedReader(vaccine_file);
                // Check ID
                while ((line = vaccine.readLine()) != null) {
                    line_array = line.split("//");
                    if (!line_array[0].equals(Vaccine_Batch_ID) && !line_array[2].equals(Vaccine_Type) && !line_array[6].equals(center_id) ){
                        Success_Save = true;
                    } else {
                        Success_Save = false;
                    }
                }
                
                Success_Save = true;
                if(Success_Save == true) {                   
                    //Insert data (not match)
                    add_vaccine.append(Vaccine_ID + "//");
                    add_vaccine.append(Vaccine_Batch_ID + "//");
                    add_vaccine.append(Vaccine_Type + "//");
                    add_vaccine.append(date + "//");
                    add_vaccine.append(Expiration_Date + "//");
                    add_vaccine.append(Second_Dose_Gap + "//");
                    // add center id and name for the txt file
                    add_vaccine.append(center_id + "//");
                    add_vaccine.print("\n");
                    add_vaccine.close();
                }
            } catch (IOException c) {
                c.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void View_Vaccine() {
        String line;
        Vaccine_Data = new ArrayList<>();
        try {
            FileReader vaccine_file = new FileReader("Vaccine.txt");
            BufferedReader center = new BufferedReader(vaccine_file);
        while ((line = center.readLine()) != null) {
            Vaccine_Data.add(line);
        }
        vaccine_file.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void Edit_Vaccine(String center_id) {
            String line;
            String[] line_array;
            ArrayList<String> temp_data = new ArrayList<>();
            try { 
                FileReader vaccine_file = new FileReader("Vaccine.txt");
                BufferedReader vaccine = new BufferedReader(vaccine_file);
                //edit line
                 while ((line = vaccine.readLine()) != null) {
                    line_array = line.split("//");
                    if (line_array[0].equals(String.valueOf(Vaccine_ID))) {
                        //Insert data
                        temp_data.add(Vaccine_ID + "//" 
                                + Vaccine_Batch_ID  + "//" 
                                + Vaccine_Type  + "//" 
                                + date  + "//" 
                                + Expiration_Date   + "//" 
                                + Second_Dose_Gap   + "//" 
                                + center_id   + "//");
                    } else {
                        temp_data.add(line);
                    }
                }
                vaccine_file.close();
               } catch (IOException c) {
                c.printStackTrace();
            }
        try (PrintWriter edit_vaccine = new PrintWriter(new BufferedWriter(new FileWriter("Vaccine.txt")))) {
            for (String new_data : temp_data) {
                edit_vaccine.println(new_data);
            }
            edit_vaccine.close();
            Success_Save = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    public void Remove_Vaccine() {
            String line;
            String[] line_array;
            ArrayList<String> temp_data = new ArrayList<>();
            try { 
                FileReader vaccine_file = new FileReader("Vaccine.txt");
                BufferedReader vaccine = new BufferedReader(vaccine_file);
                //edit line
                 while ((line = vaccine.readLine()) != null) {
                    line_array = line.split("//");
                    if (line_array[0].equals(String.valueOf(Vaccine_ID))) {
                        //do nothing
                    } else {
                        temp_data.add(line);
                    }
                }
                vaccine_file.close();
               } catch (IOException c) {
                c.printStackTrace();
            }
        try (PrintWriter edit_vaccine = new PrintWriter(new BufferedWriter(new FileWriter("Vaccine.txt")))) {
            for (String new_data : temp_data) {
                edit_vaccine.println(new_data);
            }
            edit_vaccine.close();
            Success_Save = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        

    
    
    
    
    
    
}
