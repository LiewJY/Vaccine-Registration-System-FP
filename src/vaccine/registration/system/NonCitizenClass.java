package vaccine.registration.system;

import java.io.*;

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
}
