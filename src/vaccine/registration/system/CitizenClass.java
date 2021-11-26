package vaccine.registration.system;

import java.io.*;

public class CitizenClass extends PeopleClass {
    String IC_Number;
    
    CitizenClass() {
        IC_Number = "";
    }
    //IC Number
    public String getIC_Number() {
        return IC_Number;
    }
    public void setIC_Number(String ic_number) {
        IC_Number = ic_number;
    }
    
    
    public void Register_Account() {
    try (PrintWriter register_citizen = new PrintWriter(new BufferedWriter(new FileWriter("People.txt", true)))) {
        //Insert data
        register_citizen.print("\n");
        register_citizen.append(People_ID + "//");
        register_citizen.append(Name + "//");
        register_citizen.append(Phone_Number + "//");
        register_citizen.append(Nationality + "//");
        register_citizen.append(IC_Number + "//");
        register_citizen.append(Address + "//");
        register_citizen.append(Password + "//");
        register_citizen.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
