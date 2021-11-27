package vaccine.registration.system;

import java.io.*;
import javax.swing.*;

public class NonCitizenClass extends PeopleClass{
    String Passport_Number;
    
    NonCitizenClass() {
        Passport_Number = "";
    }
    //Passport Number
    public String getPassport_Number() {
        return Passport_Number;
    }
    public void setPassport_Number(String passport_number) {
        Passport_Number = passport_number;
    }
    
    
    public void Register_Account() {
        try (PrintWriter register_noncitizen = new PrintWriter(new BufferedWriter(new FileWriter("People.txt", true)))) {
            //Insert data
            register_noncitizen.print("\n");
            register_noncitizen.append(People_ID + "//");
            register_noncitizen.append(Name + "//");
            register_noncitizen.append(Phone_Number + "//");
            register_noncitizen.append(Nationality + "//");
            register_noncitizen.append(Passport_Number + "//");
            register_noncitizen.append(Address + "//");
            register_noncitizen.append(Password + "//");
            register_noncitizen.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void Login_Account() {
        try { 
            FileReader people_file = new FileReader("People.txt");
            BufferedReader people = new BufferedReader(people_file);

            String line;
            String[] line_array;

            // Check whether input ic and password is existing and matched in text file
            while ((line = people.readLine()) != null) {
                line_array = line.split("//");
                if (!line_array[3].equals("Malaysia") && line_array[4].equals(Passport_Number) && line_array[6].equals(Password)) {
                    People_ID = Integer.parseInt(line_array[0]);
                    Auth = true;
                    Citizen = false;
                }
            }
        } catch (IOException f) {
            JOptionPane.showMessageDialog(null, "Failed to login! Something went wrong, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void View_Account() {
        try { 
            FileReader people_file = new FileReader("People.txt");
            BufferedReader people = new BufferedReader(people_file);

            String line;
            String[] line_array;

            // Check whether input ic and password is existing and matched in text file\
            while ((line = people.readLine()) != null) {
                line_array = line.split("//");
                if (line_array[0].equals(String.valueOf(People_ID))) {
                    Name = line_array[1];
                    Phone_Number = line_array[2];
                    Nationality = line_array[3];
                    Passport_Number = line_array[4];
                    Address = line_array[5];
                }
            }
        } catch (IOException f) {
            JOptionPane.showMessageDialog(null, "Failed to login! Something went wrong, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
