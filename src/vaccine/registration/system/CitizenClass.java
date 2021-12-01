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
                Success_Save = false;
                FileReader people_file = new FileReader("People.txt");
                BufferedReader people = new BufferedReader(people_file);
                // Check whether input ic and password is existing and matched in text file
                while ((line = people.readLine()) != null) {
                    line_array = line.split("//");
                    if (line_array[4].equals(IC_Number)) {
                        Success_Save = false;
                        break; 
                    } else {
                        Success_Save = true;
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
                    Password = line_array[6];
                }
            }
        } catch (IOException v) {
            v.printStackTrace();
        }
    }
    public void Edit_Account() {
        ArrayList<String> edit_citizen = new ArrayList<>();
        
        try {
            FileReader file_reader = new FileReader("People.txt");
            BufferedReader buffered_reader = new BufferedReader(file_reader);

            String line;
            String[] line_array;

            while ((line = buffered_reader.readLine()) != null) {
                line_array = line.split("//");
                System.out.println(line_array);
                //String testa = String.valueOf(People_ID);
                if (line_array[0].equals(String.valueOf(People_ID))) {
                    edit_citizen.add(People_ID + "//" + Name + "//" + Phone_Number + "//" 
                            + Nationality + "//" + IC_Number + "//" + Address + "//" + Password + "//");
                    System.out.println(edit_citizen);
                } else {
                    edit_citizen.add(line);
                    
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

            // Check people ic / passport
            while ((line = buffered_reader.readLine()) != null) {
                line_array = line.split("//");

                // this not this id check is ic / passport same
                if (!line_array[0].equals(String.valueOf(People_ID)) && (line_array[4].equals(IC_Number))) {
                    data_exist = true;
                    System.out.println(line_array[0] + "  " + line_array[4]);
                }
            }

            if (data_exist == true) {                    
                Success_Save = false;
            } else if (data_exist == false) {
                // Write and update  data
                try (PrintWriter print_writer = new PrintWriter("People.txt")) {
                    for (String new_data : edit_citizen) {
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
