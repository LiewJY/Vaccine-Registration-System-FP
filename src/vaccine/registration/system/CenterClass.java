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
//    public ArrayList<String> getCenter() {
//        return Get_Center;
//    }
 
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
                    if (!line_array[2].equals(Center_Name)){
                        Success_Save = true;
                    } else {
                        Success_Save = false;
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
                        //Insert data
                        temp_data.add(Center_ID + "//" 
                                + Center_Name + "//" 
                                + Center_Address + "//" 
                                + Center_Contact_Number + "//" 
                                + line_array[4] + "//");
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
        
//        public void Remove_Center() {
//        File old_file = new File("Center.txt");
//        File new_file = new File("Center_temp.txt");
//        
//        String line;
//        String line_array[];
//        
//        try {
//            FileWriter file_writer = new FileWriter(new_file, true);
//            BufferedWriter buffered_writer = new BufferedWriter(file_writer);
//            PrintWriter print_writer = new PrintWriter(buffered_writer);
//            
//            FileReader file_reader = new FileReader("Center.txt");
//            BufferedReader buffered_reader = new BufferedReader(file_reader);
//            
//            while ((line = buffered_reader.readLine()) != null) {
//                line_array = line.split("//d");
//                
//                // If input ID equals to line_array[0], the line will be ignored, other lines will be written to a new text file
//                if (!(line_array[0].equalsIgnoreCase(String.valueOf(Center_ID)))) {
//                    print_writer.println(line);
//                }
//            }
//            
//            print_writer.flush();
//            print_writer.close();
//            file_reader.close();
//            buffered_reader.close();
//            buffered_writer.close();
//            file_writer.close();
//            
//            old_file.delete();
//            File file = new File("Center.txt");
//            new_file.renameTo(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//        
//        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
