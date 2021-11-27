package vaccine.registration.system;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class CitizenClass extends PeopleClass {
   private String IC_Number;
   
    CitizenClass() {
        IC_Number = "";
    }
    //IC Number
    public String getIC_Number() {
        return IC_Number;
    }
    public void setIC_Number(String ic_number) {
        IC_Number = ic_number;
    }

    
    public void Register_Account() {
        String line;
        String[] line_array;
        try (PrintWriter register_citizen = new PrintWriter(new BufferedWriter(new FileWriter("People.txt", true)))) {
            try { 
                FileReader people_file = new FileReader("People.txt");
                BufferedReader people = new BufferedReader(people_file);
                // Check whether input ic and password is existing and matched in text file
                while ((line = people.readLine()) != null) {
                    line_array = line.split("//");
                    if (!line_array[4].equals(IC_Number)) {
                        Success_Save = true;
                    } else {
                        Success_Save = false;
                    }
                }
                if(Success_Save == true) {
                    //Insert data (not match)
                    register_citizen.append(People_ID + "//");
                    register_citizen.append(Name + "//");
                    register_citizen.append(Phone_Number + "//");
                    register_citizen.append(Nationality + "//");
                    register_citizen.append(IC_Number + "//");
                    register_citizen.append(Address + "//");
                    register_citizen.append(Password + "//");
                    register_citizen.print("\n");
                    register_citizen.close();
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
                if (line_array[3].equals("Malaysia") && line_array[4].equals(IC_Number) && line_array[6].equals(Password)) {
                    People_ID = Integer.parseInt(line_array[0]);
                    Auth = true;
                    Citizen = true;
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
                    IC_Number = line_array[4];
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
                                + IC_Number + "//" 
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
        try (PrintWriter edit_citizen = new PrintWriter(new BufferedWriter(new FileWriter("People.txt")))) {
            for (String new_data : temp_data) {
                edit_citizen.println(new_data);
            }
            edit_citizen.close();
            Success_Save = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    
}
