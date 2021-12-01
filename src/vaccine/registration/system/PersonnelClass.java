package vaccine.registration.system;

import java.io.*;
import java.util.ArrayList;

public class PersonnelClass {
    private int Personnel_ID;
    private String Phone_Number, Name, Nationality, Address, Password, IC_Number;
    
    // For login function
    private boolean Auth = false;
    
    // For register and edit function
    private boolean Success_Save = false;
    
    // Data passing
    private ArrayList<String> People_Data = new ArrayList<>();
    
    PersonnelClass() {
        IC_Number = "";
    }
    
    // IC number
    public String getIC_Number() {
        return IC_Number;
    }
    
    public void setIC_Number(String ic_number) {
        IC_Number = ic_number;
    }
    
    // Personnel ID
    public int getPersonnel_ID() {
        return Personnel_ID;
    }
    
    public void setPersonnel_ID(int personnel_id) {
        Personnel_ID = personnel_id;
    }
    
    // Phone number
    public String getPhone_Number() {
        return Phone_Number;
    }
    
    public void setPhone_Number(String phone_number) {
        Phone_Number = phone_number;
    }
    
    // Name
    public String getName() {
        return Name;
    }
    
    public void setName(String name) {
        Name = name;
    }
    
    // Nationality
    public String getNationality() {
        return Nationality;
    }
    
    public void setNationality(String nationality) {
        Nationality = nationality;
    }
    
    // Address
    public String getAddress() {
        return Address;
    }
    
    public void setAddress(String address) {
        Address = address;
    }
    
    // Password
    public String getPassword() {
        return Password;
    }
    
    public void setPassword(String password) {
        Password = password;
    }
    
    // For login function
    public boolean getAuth() {
        return Auth;
    }
    
    // For save (register and edit)
    public boolean getSuccess_Save() {
        return Success_Save;
    }
    
    // Data passing
    public ArrayList<String> getPeople_Data() {
        return People_Data;
    }

    
    // Login account
    public void Login_Account() {
        String line;
        String[] line_array;
        
        try { 
            FileReader personnel_file = new FileReader("Personnel.txt");
            BufferedReader personnel = new BufferedReader(personnel_file);
            
            // Check whether input ic and password is existing and matched in text file
            while ((line = personnel.readLine()) != null) {
                line_array = line.split("//");
                
                if (line_array[3].equals("Malaysia") && line_array[4].equals(IC_Number) && line_array[6].equals(Password)) {
                    Personnel_ID = Integer.parseInt(line_array[0]);
                    Auth = true;
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
            FileReader personnel_file = new FileReader("Personnel.txt");
            BufferedReader personnel = new BufferedReader(personnel_file);
            
            // Check whether input ic and password is existing and matched in text file
            while ((line = personnel.readLine()) != null) {
                line_array = line.split("//");
                
                if (line_array[0].equals(String.valueOf(Personnel_ID))) {
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
    
    
    // Edit account
    public void Edit_Account() {
        String line;
        String[] line_array;
        ArrayList<String> temp_data = new ArrayList<>();
        
        try {
            FileReader personnel_file = new FileReader("Personnel.txt");
            BufferedReader personnel = new BufferedReader(personnel_file);
            
            // Edit line
             while ((line = personnel.readLine()) != null) {
                line_array = line.split("//");
                
                if (line_array[0].equals(String.valueOf(Personnel_ID))) {
                    // Insert data
                    temp_data.add(Personnel_ID + "//" 
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
            personnel.close();
           } catch (IOException c) {
            c.printStackTrace();
        }
        
        try (PrintWriter edit_citizen = new PrintWriter(new BufferedWriter(new FileWriter("Personnel.txt")))) {
            for (String new_data : temp_data) {
                edit_citizen.println(new_data);
            }
            edit_citizen.close();
            Success_Save = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    // View people
    public void View_People() {
        String line;
        People_Data = new ArrayList<>();
        
        try {
            FileReader people_file = new FileReader("People.txt");
            BufferedReader people = new BufferedReader(people_file);
            
            while ((line = people.readLine()) != null) {
               People_Data.add(line);
            }
            people_file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
}
