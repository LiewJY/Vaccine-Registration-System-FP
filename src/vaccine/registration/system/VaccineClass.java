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
    private int Vaccine_Batch_ID, Amount, Second_Dose_Gap;
    private String Vaccine_Type;
    private Date date, Expiration_Date;
    
    // for add function (no need to be in class diagram)
    protected boolean Success_Save = false;
    protected ArrayList<String> Vaccine_Data = new ArrayList<>();
    
    VaccineClass() {
        Vaccine_Batch_ID = 1;
    }
    public int getVaccine_Batch_ID() {
        return Vaccine_Batch_ID;
    }
    public void setVaccine_Batch_ID(int vaccine_batch_id) {
        Vaccine_Batch_ID = vaccine_batch_id;
    }
    public int getAmount() {
        return Amount;
    }
    public void setAmount(int amount) {
        Amount = amount;
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
    public Date getdate() {
        return date;
    }
    public void setdate(Date date) {
        this.date = date;
    }
    public Date getExpiration_Date() {
        return Expiration_Date;
    }
    public void setExpiration_Date(Date expiration_date) {
        Expiration_Date = expiration_date;
    }
    
    

    CenterClass center_class = new CenterClass();
    public void Add_Vaccine(int id, String name) {
        String line;
        String[] line_array;
        center_class.setCenter_ID(id);
        center_class.setCenter_Name(name);
        
        try (PrintWriter add_vaccine = new PrintWriter(new BufferedWriter(new FileWriter("Center.txt", true)))) {
            try { 
                FileReader center_file = new FileReader("Center.txt");
                BufferedReader center = new BufferedReader(center_file);
                // Check ID
                while ((line = center.readLine()) != null) {
                    line_array = line.split("//");
                    if (!line_array[0].equals(Vaccine_Batch_ID)){
                        Success_Save = true;
                    } else {
                        Success_Save = false;
                    }
                }
                if(Success_Save == true) {
                    //Insert data (not match)
                    add_vaccine.append(Vaccine_Batch_ID + "//");
                    add_vaccine.append(Vaccine_Type + "//");
                    add_vaccine.append(date + "//");
                    add_vaccine.append(Expiration_Date + "//");
                    add_vaccine.append(Amount + "//");
                    add_vaccine.append(Second_Dose_Gap + "//");
                    // add center id and name for the txt file
                    add_vaccine.append(center_class.getCenter_ID() + "//");
                    add_vaccine.append(center_class.getCenter_Name() + "//");
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

    
    
    
    
    
    
}
