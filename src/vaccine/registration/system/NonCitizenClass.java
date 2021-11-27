package vaccine.registration.system;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class NonCitizenClass extends PeopleClass{
    private String Passport_Number;
    
    NonCitizenClass() {
        Passport_Number = "";
    }
    //Passport Number
    public String getPassport_Number() {
        return Passport_Number;
    }
    public void setPassport_Number(String passport_number) {
        Passport_Number = passport_number;
    }
    public void Register_Account() {
        String line;
        String[] line_array;
        try (PrintWriter register_noncitizen = new PrintWriter(new BufferedWriter(new FileWriter("People.txt", true)))) {
            try { 
                FileReader people_file = new FileReader("People.txt");
                BufferedReader people = new BufferedReader(people_file);
                // Check whether input ic and password is existing and matched in text file
                while ((line = people.readLine()) != null) {
                    line_array = line.split("//");
                    if (!line_array[4].equals(Passport_Number)) {
                        Success_Save = true;
                    } else {
                        Success_Save = false;
                    }
                }
                if(Success_Save == true) {
                    //Insert data (not match)
                    register_noncitizen.print("\n");
                    register_noncitizen.append(People_ID + "//");
                    register_noncitizen.append(Name + "//");
                    register_noncitizen.append(Phone_Number + "//");
                    register_noncitizen.append(Nationality + "//");
                    register_noncitizen.append(Passport_Number + "//");
                    register_noncitizen.append(Address + "//");
                    register_noncitizen.append(Password + "//");
                    register_noncitizen.close();
                }
            } catch (IOException c) {
                c.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void Login_Account() {
        String line;
        String[] line_array;
        try { 
            FileReader people_file = new FileReader("People.txt");
            BufferedReader people = new BufferedReader(people_file);
            // Check whether input ic and password is existing and matched in text file
            while ((line = people.readLine()) != null) {
                line_array = line.split("//");
                if (!line_array[3].equals("Malaysia") && line_array[4].equals(Passport_Number) && line_array[6].equals(Password)) {
                    People_ID = Integer.parseInt(line_array[0]);
                    Auth = true;
                    Citizen = false;
                }
            }
        } catch (IOException f) {
            f.printStackTrace();        
        }
    }
    public void View_Account() {
        String line;
        String[] line_array;
        try { 
            FileReader people_file = new FileReader("People.txt");
            BufferedReader people = new BufferedReader(people_file);
            // Check whether input ic and password is existing and matched in text file\
            while ((line = people.readLine()) != null) {
                line_array = line.split("//");
                if (line_array[0].equals(String.valueOf(People_ID))) {
                    Name = line_array[1];
                    Phone_Number = line_array[2];
                    Nationality = line_array[3];
                    Passport_Number = line_array[4];
                    Address = line_array[5];
                }
            }
        } catch (IOException v) {
            v.printStackTrace();
        }
    }
    public void Edit_Account() {
            String line;
            String[] line_array;
            ArrayList<String> temp_data = new ArrayList<>();
            try { 
                FileReader people_file = new FileReader("People.txt");
                BufferedReader people = new BufferedReader(people_file);
                //edit line
                 while ((line = people.readLine()) != null) {
                    line_array = line.split("//");
                    if (line_array[0].equals(String.valueOf(People_ID))) {
                        //Insert data
                        temp_data.add(People_ID + "//" 
                                + Name + "//" 
                                + Phone_Number + "//" 
                                + Nationality + "//" 
                                + Passport_Number + "//" 
                                + Address + "//" 
                                + Password + "//");
                    } else {
                        temp_data.add(line);
                    }
                }
                people_file.close();
               } catch (IOException c) {
                c.printStackTrace();
            }
        try (PrintWriter edit_noncitizen = new PrintWriter(new BufferedWriter(new FileWriter("People.txt")))) {
            for (String new1_data : temp_data) {
                edit_noncitizen.println(new1_data);
            }
            edit_noncitizen.close();
            Success_Save = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
