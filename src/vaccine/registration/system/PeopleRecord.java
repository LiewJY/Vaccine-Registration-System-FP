package vaccine.registration.system;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

record PeopleRecord(int People_ID, String Phone_Number, String Name, String Nationality, String Address, String Password) {

    public PeopleRecord withName(String newName) {
        return new PeopleRecord(People_ID, Phone_Number, newName, Nationality, Address, Password);
    }

    public PeopleRecord withPhoneNumber(String newPhone_Number) {
        return new PeopleRecord(People_ID, newPhone_Number, Name, Nationality, Address, Password);
    }

    public PeopleRecord withNationality(String newNationality) {
        return new PeopleRecord(People_ID, Phone_Number, Name, newNationality, Address, Password);
    }

    public PeopleRecord withAddress(String newAddress) {
        return new PeopleRecord(People_ID, Phone_Number, Name, Nationality, newAddress, Password);
    }

    public PeopleRecord withPassword(String newPassword) {
        return new PeopleRecord(People_ID, Phone_Number, Name, Nationality, Address, newPassword);
    }

}
