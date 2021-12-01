package vaccine.registration.system;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;


public class NonCitizenClass extends PeopleClass{
    private String Passport_Number;
    
    NonCitizenClass() {
        Passport_Number = "";
    }
    
    // Passport number
    public String getPassport_Number() {
        return Passport_Number;
    }
    
    public void setPassport_Number(String passport_number) {
        Passport_Number = passport_number;
    }
    
    
    // Register account
    public void Register_Account() {
        String line;
        String[] line_array;
        boolean data_exist = false;
        
        try (PrintWriter register_noncitizen = new PrintWriter(new BufferedWriter(new FileWriter("People.txt", true)))) {
            try { 
                FileReader people_file = new FileReader("People.txt");
                BufferedReader people = new BufferedReader(people_file);

                while ((line = people.readLine()) != null) {
                    line_array = line.split("//");

                    if (line_array[0].equals(String.valueOf(People_ID)) || line_array[4].equals(Passport_Number)) {
                        Success_Save = false;
                        data_exist = true;
                        break;
                    } else {
                        Success_Save = true;
                        data_exist = false;
                    }
                }
                
                if (data_exist == false) {
                    // Insert data (not match)
                    register_noncitizen.append(People_ID + "//");
                    register_noncitizen.append(Name + "//");
                    register_noncitizen.append(Phone_Number + "//");
                    register_noncitizen.append(Nationality + "//");
                    register_noncitizen.append(Passport_Number + "//");
                    register_noncitizen.append(Address + "//");
                    register_noncitizen.append(Password + "//");
                    register_noncitizen.print("\n");
                    register_noncitizen.close();
                    Success_Save = true;
                }
            } catch (IOException c) {
                c.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    // Login account
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
    
    
    // View account
    public void View_Account() {
        String line;
        String[] line_array;
        
        try { 
            FileReader people_file = new FileReader("People.txt");
            BufferedReader people = new BufferedReader(people_file);
            
            // Check whether input ic and password is existing and matched in text file
            while ((line = people.readLine()) != null) {
                line_array = line.split("//");
                
                if (line_array[0].equals(String.valueOf(People_ID))) {
                    Name = line_array[1];
                    Phone_Number = line_array[2];
                    Nationality = line_array[3];
                    Passport_Number = line_array[4];
                    Address = line_array[5];
                    Password = line_array[6];
                }
            }
        } catch (IOException v) {
            v.printStackTrace();
        }
    }
    
    
    // Edit account
    public void Edit_Account() {
        ArrayList<String> edit_non_citizen = new ArrayList<>();
        
        try {
            FileReader file_reader = new FileReader("People.txt");
            BufferedReader buffered_reader = new BufferedReader(file_reader);

            String line;
            String[] line_array;

            while ((line = buffered_reader.readLine()) != null) {
                line_array = line.split("//");
                if (line_array[0].equals(String.valueOf(People_ID))) {
                    edit_non_citizen.add(People_ID + "//" + Name + "//" + Phone_Number + "//" 
                            + Nationality + "//" + Passport_Number + "//" + Address + "//" + Password + "//");
                } else {
                    edit_non_citizen.add(line);
                }
            }
            file_reader.close();
        } catch (IOException e) {
            Success_Save = false;
        }

        // Validation & write data
        try {
            FileReader file_reader = new FileReader("People.txt");
            BufferedReader buffered_reader = new BufferedReader(file_reader);

            String line;
            String[] line_array;
            boolean data_exist = false;

            // Check people IC / passport
            while ((line = buffered_reader.readLine()) != null) {
                line_array = line.split("//");

                // Check not this ID & is IC / passport same
                if (!line_array[0].equals(String.valueOf(People_ID)) && (line_array[4].equals(Passport_Number))) {
                    data_exist = true;
                    System.out.println(line_array[0] + "  " + line_array[4]);
                }
            }

            if (data_exist == true) {                    
                Success_Save = false;
            } else if (data_exist == false) {
                // Write and update data
                try (PrintWriter print_writer = new PrintWriter("People.txt")) {
                    for (String new_data : edit_non_citizen) {
                        print_writer.println(new_data);
                    }
                    print_writer.close();
                    Success_Save = true;
                } catch (IOException e) {
                    Success_Save = false;
                }
            }
        } catch(IOException e) {
            Success_Save = false;
        }
    }
}
