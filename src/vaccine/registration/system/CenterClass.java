package vaccine.registration.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CenterClass {
    private String Center_Name, Center_Address, Center_Contact_Number, Vaccine_Type;
    private int Center_ID;
    // for add function (no need to be in class diagram)
    protected boolean Success_Save = false;
    protected ArrayList<String> Center_Data = new ArrayList<>();
    protected ArrayList<String> Get_Center = new ArrayList<>();
    protected int count;
    
    CenterClass() {
        Center_ID = 1;
    }
    public int getCenter_ID() {
        return Center_ID;
    }
    public void setCenter_ID(int center_id) {
        Center_ID = center_id;
    }
    public void setCenter_Name(String center_name) {
        Center_Name = center_name;
    }
    public String getCenter_Name() {
        return Center_Name;
    }
    public String getCenter_Address() {
        return Center_Address;
    }
    public void setCenter_Address(String center_address) {
        Center_Address = center_address;
    }
    public String getCenter_Contact_Number() {
        return Center_Contact_Number;
    }
    public void setCenter_Contact_Number(String center_contact_number) {
        Center_Contact_Number = center_contact_number;
    }
    public String getVaccine_Type() {
        return Vaccine_Type;
    }
    public void setVaccine_Type(String vaccine_type) {
        Vaccine_Type = vaccine_type;
    }
    // for save (add and edit) function (no need to be in class diagram)
    public boolean getSuccess_Save() {
        return Success_Save;
    }
    // data passing no need to be in class diagram
    public ArrayList<String> getCenter_Data() {
        return Center_Data;
    }

    public void calculateCenter_ID() {
        String line;
        String[] line_array;
        String lastLine;
        try {
            FileReader center_file = new FileReader("Center.txt");
            BufferedReader center = new BufferedReader(center_file);

            while ((line = center.readLine()) != null) 
            {
                System.out.println(line);
                lastLine = line;
                line_array = lastLine.split("//");
                Center_ID = Integer.parseInt(line_array[0]) + 1;
                System.out.println(Integer.parseInt(line_array[0]) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Add_Center() {
        String line;
        String[] line_array;
        try (PrintWriter add_center = new PrintWriter(new BufferedWriter(new FileWriter("Center.txt", true)))) {
            try { 
                FileReader center_file = new FileReader("Center.txt");
                BufferedReader center = new BufferedReader(center_file);
                // Check whether input ic and password is existing and matched in text file
                while ((line = center.readLine()) != null) {
                    line_array = line.split("//");
                    if (line_array[1].equals(Center_Name)){
                        Success_Save = false;
                        break;
                    } else {
                        Success_Save = true;
                    }
                }
                if(Success_Save == true) {
                    //Insert data (not match)
                    add_center.append(Center_ID + "//");
                    add_center.append(Center_Name + "//");
                    add_center.append(Center_Address + "//");
                    add_center.append(Center_Contact_Number + "//");
                    add_center.append(Vaccine_Type + "//");
                    add_center.print("\n");
                    add_center.close();
                }
            } catch (IOException c) {
                c.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void View_Center() {
        String line;
        Center_Data = new ArrayList<>();
        try {
            FileReader center_file = new FileReader("Center.txt");
            BufferedReader center = new BufferedReader(center_file);
        while ((line = center.readLine()) != null) {
            Center_Data.add(line);
            
        }
        center_file.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void Edit_Center() {
        ArrayList<String> edit_staff_array = new ArrayList<>();
        
        try {
            FileReader file_reader = new FileReader("Center.txt");
            BufferedReader buffered_reader = new BufferedReader(file_reader);

            String line;
            String[] line_array;

            while ((line = buffered_reader.readLine()) != null) {
                line_array = line.split("//");
                System.out.println(line_array);
                if (line_array[0].equals(String.valueOf(Center_ID))) {
                    edit_staff_array.add(Center_ID + "//" + Center_Name + "//" + Center_Address + "//" 
                            + Center_Contact_Number + "//" + line_array[4] + "//");
                    System.out.println(edit_staff_array);
                } else {
                    edit_staff_array.add(line);
                    
                }
            }

            file_reader.close();
        } catch (IOException e) {
            Success_Save = false;
        }

        // Validation & write data
        try {
            FileReader file_reader = new FileReader("Center.txt");
            BufferedReader buffered_reader = new BufferedReader(file_reader);

            String line;
            String[] line_array;
            boolean data_exist = false;

            // Check people ic / passport
            while ((line = buffered_reader.readLine()) != null) {
                line_array = line.split("//");

                // this not this id check is ic / passport same
                if (!line_array[0].equals(String.valueOf(Center_ID)) && (line_array[1].equals(Center_Name))) {
                    data_exist = true;
                    System.out.println(line_array[0] + "  " + line_array[1]);
                }
            }

            if (data_exist == true) {                    
                Success_Save = false;
            } else if (data_exist == false) {
                // Write and update staff data
                try (PrintWriter print_writer = new PrintWriter("Center.txt")) {
                    for (String new_staff_data : edit_staff_array) {
                        print_writer.println(new_staff_data);
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
    
    
    
    
    public void Remove_Center() {
            String line;
            String[] line_array;
            ArrayList<String> temp_data = new ArrayList<>();
            try { 
                FileReader center_file = new FileReader("Center.txt");
                BufferedReader center = new BufferedReader(center_file);
                //edit line
                 while ((line = center.readLine()) != null) {
                    line_array = line.split("//");
                    if (line_array[0].equals(String.valueOf(Center_ID))) {
                        //do nothing
                    } else {
                        temp_data.add(line);
                    }
                }
                center_file.close();
               } catch (IOException c) {
                c.printStackTrace();
            }
        try (PrintWriter edit_center = new PrintWriter(new BufferedWriter(new FileWriter("Center.txt")))) {
            for (String new_data : temp_data) {
                edit_center.println(new_data);
            }
            edit_center.close();
            Success_Save = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    
    

    
}
