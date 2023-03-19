package vaccine.registration.system;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class CitizenClass extends PeopleClass {

    private String IC_Number;

    CitizenClass() {
        IC_Number = "";
    }

    // IC number
    public String getIC_Number() {
        return IC_Number;
    }

    public void setIC_Number(String ic_number) {
        IC_Number = ic_number;
    }

    // Register account
    public void Register_Account() {
        boolean data_exist;
        try (PrintWriter register_citizen = new PrintWriter(new BufferedWriter(new FileWriter("People.txt", true)))) {
            try {
                BufferedReader people = new BufferedReader(new FileReader("People.txt"));
                /*concept - lampda expresssion (map and filter) 
                hof - map filter 
            stream processsing - lines method return Stream<String>
                 */
                data_exist
                        = people.lines()
                                .map(line -> line.split("//"))
                                .anyMatch(line_element -> line_element[0].equals(String.valueOf(People_ID)) || line_element[4].equals(IC_Number));

                if (!data_exist) {
                    // Insert data (not match)
                    register_citizen.append(People_ID + "//" + Name + "//" + Phone_Number + "//" + Nationality + "//" + IC_Number + "//" + Address + "//" + Password + "//");
                    register_citizen.print("\n");
                    register_citizen.close();
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
        
        try {
            BufferedReader people = new BufferedReader(new FileReader("People.txt"));
            // Check whether input ic and password is existing and matched in text file
            /*concept - lampda expresssion (map and filter)
            stream processsing - lines method return Stream<String>
             */
            people.lines()
                    .map(line -> line.split("//"))
                    .filter(line_element -> line_element[3].equals("Malaysia") && line_element[4].equals(IC_Number) && line_element[6].equals(Password))
                    .findFirst()
                    .ifPresent(line_element -> {
                        People_ID = Integer.parseInt(line_element[0]);
                        Auth = true;
                        Citizen = true;
                    });
        } catch (IOException f) {
            f.printStackTrace();
        }
    }

    // View account
    public void View_Account() {
        try {
            BufferedReader people = new BufferedReader(new FileReader("People.txt"));
            // Check whether input ic and password is existing and matched in text file\            
            /*concept - lampda expresssion (map and filter)
            hof
            stream processsing - lines method return Stream<String>
             */
            people.lines()
                    .map(line -> line.split("//"))
                    .filter(line_element -> line_element[0].equals(String.valueOf(People_ID)))
                    .findFirst()
                    .ifPresent(line_element -> {
                        Name = line_element[1];
                        Phone_Number = line_element[2];
                        Nationality = line_element[3];
                        IC_Number = line_element[4];
                        Address = line_element[5];
                        Password = line_element[6];
                    });

        } catch (IOException v) {
            v.printStackTrace();
        }
    }

    // Edit account
    public void Edit_Account() {
        ArrayList<String> edit_citizen = new ArrayList<>();

        try {
            BufferedReader buffered_reader = new BufferedReader(new FileReader("People.txt"));

            String line;
            String[] line_array;
         while ((line = buffered_reader.readLine()) != null) {
                line_array = line.split("//");

                if (line_array[0].equals(String.valueOf(People_ID))) {
                    edit_citizen.add(People_ID + "//" + Name + "//" + Phone_Number + "//"
                            + Nationality + "//" + IC_Number + "//" + Address + "//" + Password + "//");
                } else {
                    edit_citizen.add(line);
                }
            }
            //file_reader.close();
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

                // Check not this id & is IC / passport same
                if (!line_array[0].equals(String.valueOf(People_ID)) && (line_array[4].equals(IC_Number))) {
                    data_exist = true;
                }
            }

            if (data_exist == true) {
                Success_Save = false;
            } else if (data_exist == false) {
                // Write and update data
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
        } catch (IOException e) {
            Success_Save = false;
        }
    }
}
