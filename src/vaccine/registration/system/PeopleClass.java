package vaccine.registration.system;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class PeopleClass {
    protected int People_ID;
    protected String Phone_Number, Name, Nationality, Address, Password;
    
    // For login function
    protected boolean Auth = false;
    protected boolean Citizen;
    
    // For register function
    protected boolean Success_Save = false;
    protected int count;

    PeopleClass() {
        People_ID = 1;
    }
    
    // People ID
    public int getPeople_ID() {
        return People_ID;
    }
    
    public void setPeople_ID(int people_id) {
        People_ID = people_id;
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
    
    public boolean getCitizen() {
        return Citizen;
    }
    
    // For save (register and edit)
    public boolean getSuccess_Save() {
        return Success_Save;
    }

    
    // Calculate People ID
    public void calculatePeople_ID() {
        String line;
        String[] line_array;
        String lastLine;
        
        try {
            FileReader people_file = new FileReader("People.txt");
            BufferedReader people = new BufferedReader(people_file);

            while ((line = people.readLine()) != null) {
                System.out.println(line);
                lastLine = line;
                line_array = lastLine.split("//");
                People_ID = Integer.parseInt(line_array[0]) + 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
