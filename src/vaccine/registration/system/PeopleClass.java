/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccine.registration.system;

import java.io.*;
import java.util.*;

/**
 *
 * @author liewj
 */
public class PeopleClass {
    protected int People_ID;
    protected String Phone_Number, Name, Nationality, Address, Password;
    
    PeopleClass() {
        People_ID = 1;
    }
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
    
    public void calculatePeople_ID() {
        String line;
        String[] line_array;
        String lastLine;
        try {
            FileReader people = new FileReader("People.txt");
            BufferedReader buffered_reader = new BufferedReader(people);

            while ((line = buffered_reader.readLine()) != null) 
            {
                System.out.println(line);
                lastLine = line;
                line_array = lastLine.split("//");
                People_ID = Integer.parseInt(line_array[0]) + 1;
                System.out.println(Integer.parseInt(line_array[0]) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    
}
