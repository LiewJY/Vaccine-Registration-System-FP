package vaccine.registration.system;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CenterClass {
    private String Center_Name, Center_Address, Center_Contact_Number, Vaccine_Type;
    private int Center_ID;
    
    // For add function
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
    
    // For save (add and edit) function
    public boolean getSuccess_Save() {
        return Success_Save;
    }
    
    // Data passing
    public ArrayList<String> getCenter_Data() {
        return Center_Data;
    }

    
    // Calculate center ID
    public void calculateCenter_ID() {
        String line;
        String[] line_array;
        String lastLine;
        
        try {
            FileReader center_file = new FileReader("Center.txt");
            BufferedReader center = new BufferedReader(center_file);

            while ((line = center.readLine()) != null) {
                lastLine = line;
                line_array = lastLine.split("//");
                Center_ID = Integer.parseInt(line_array[0]) + 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    // Add center
    public void Add_Center() {
        String line;
        String[] line_array;
        boolean data_exist = false;
        
        try (PrintWriter add_center = new PrintWriter(new BufferedWriter(new FileWriter("Center.txt", true)))) {
            try { 
                FileReader center_file = new FileReader("Center.txt");
                BufferedReader center = new BufferedReader(center_file);

                // Check ID
                while ((line = center.readLine()) != null) {
                    line_array = line.split("//");

                    if (line_array[1].equals(Center_Name)){
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
                    add_center.append(Center_ID + "//");
                    add_center.append(Center_Name + "//");
                    add_center.append(Center_Address + "//");
                    add_center.append(Center_Contact_Number + "//");
                    add_center.append(Vaccine_Type + "//");
                    add_center.print("\n");
                    add_center.close();
                    Success_Save = true;
                }
            } catch (IOException c) {
                c.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    // View center
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    // Edit Center
    public void Edit_Center() {
        ArrayList<String> edit_center = new ArrayList<>();
        
        try {
            FileReader file_reader = new FileReader("Center.txt");
            BufferedReader buffered_reader = new BufferedReader(file_reader);

            String line;
            String[] line_array;

            while ((line = buffered_reader.readLine()) != null) {
                line_array = line.split("//");
                
                if (line_array[0].equals(String.valueOf(Center_ID))) {
                    edit_center.add(Center_ID + "//" + Center_Name + "//" + Center_Address + "//" 
                            + Center_Contact_Number + "//" + line_array[4] + "//");
                } else {
                    edit_center.add(line);
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

            // Check center name
            while ((line = buffered_reader.readLine()) != null) {
                line_array = line.split("//");

                // Check not this ID & is center name same
                if (!line_array[0].equals(String.valueOf(Center_ID)) && (line_array[1].equals(Center_Name))) {
                    data_exist = true;
                }
            }

            if (data_exist == true) {                    
                Success_Save = false;
            } else if (data_exist == false) {
                // Write and update data
                try (PrintWriter print_writer = new PrintWriter("Center.txt")) {
                    for (String new_data : edit_center) {
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
    
    
    // Remove center
    public void Remove_Center() {
        String line;
        String[] line_array;
        ArrayList<String> temp_data = new ArrayList<>();
        
        try { 
            FileReader center_file = new FileReader("Center.txt");
            BufferedReader center = new BufferedReader(center_file);
            
            // Edit line
            while ((line = center.readLine()) != null) {
                line_array = line.split("//");
                if (line_array[0].equals(String.valueOf(Center_ID))) {
                    // Do nothing
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
