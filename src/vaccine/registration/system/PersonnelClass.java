package vaccine.registration.system;

import java.io.*;
import java.util.ArrayList;

public class PersonnelClass {
    private int Personnel_ID;
    private String Phone_Number, Name, Nationality, Address, Password, IC_Number;
    // for login function (no need to be in class diagram)
    private boolean Auth = false;
    
    // for register and edit function (no need to be in class diagram)
    private boolean Success_Save = false;
    
    // data passing no need to be in class diagram
    private ArrayList<String> People_Data = new ArrayList<>();
    
    PersonnelClass() {
        IC_Number = "";
    }
    //IC Number
    public String getIC_Number() {
        return IC_Number;
    }
    public void setIC_Number(String ic_number) {
        IC_Number = ic_number;
    }
    
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
    //Name
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    //Nationality
    public String getNationality() {
        return Nationality;
    }
    public void setNationality(String nationality) {
        Nationality = nationality;
    }
    //Address
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    //Password
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    
    // for login function (no need to be in class diagram)
    public boolean getAuth() {
        return Auth;
    }
    // for save (register and edit) function (no need to be in class diagram)
    public boolean getSuccess_Save() {
        return Success_Save;
    }
    
    // data passing no need to be in class diagram
    public ArrayList<String> getPeople_Data() {
        return People_Data;
    }

    
//    public void Register_Account() {
//        String line;
//        String[] line_array;
//        try (PrintWriter register_citizen = new PrintWriter(new BufferedWriter(new FileWriter("Personnel.txt", true)))) {
//            try { 
//                FileReader personnel_file = new FileReader("Personnel.txt");
//                BufferedReader personnel = new BufferedReader(personnel_file);
//                // Check whether input ic and password is existing and matched in text file
//                while ((line = personnel.readLine()) != null) {
//                    line_array = line.split("//");
//                    if (!line_array[4].equals(IC_Number)) {
//                        Success_Save = true;
//                    } else {
//                        Success_Save = false;
//                    }
//                }
//                if(Success_Save == true) {
//                    //Insert data (not match)
//                    register_citizen.print("\n");
//                    register_citizen.append(Personnel_ID + "//");
//                    register_citizen.append(Name + "//");
//                    register_citizen.append(Phone_Number + "//");
//                    register_citizen.append(Nationality + "//");
//                    register_citizen.append(IC_Number + "//");
//                    register_citizen.append(Address + "//");
//                    register_citizen.append(Password + "//");
//                    register_citizen.close();
//                }
//            } catch (IOException c) {
//                c.printStackTrace();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
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
    public void View_Account() {
        String line;
        String[] line_array;
        try { 
            FileReader personnel_file = new FileReader("Personnel.txt");
            BufferedReader personnel = new BufferedReader(personnel_file);
            // Check whether input ic and password is existing and matched in text file\
            while ((line = personnel.readLine()) != null) {
                line_array = line.split("//");
                if (line_array[0].equals(String.valueOf(Personnel_ID))) {
                    Name = line_array[1];
                    Phone_Number = line_array[2];
                    Nationality = line_array[3];
                    IC_Number = line_array[4];
                    Address = line_array[5];
                    System.out.println(Address);

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
                FileReader personnel_file = new FileReader("Personnel.txt");
                BufferedReader personnel = new BufferedReader(personnel_file);
                //edit line
                 while ((line = personnel.readLine()) != null) {
                    line_array = line.split("//");
                    if (line_array[0].equals(String.valueOf(Personnel_ID))) {
                        //Insert data
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
    
    public void View_People() {
        String line;
        try {
            FileReader people_file = new FileReader("People.txt");
            BufferedReader people = new BufferedReader(people_file);
            People_Data = new ArrayList<>();
        while ((line = people.readLine()) != null) {
           People_Data.add(line);
        }
        people_file.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
   
}
