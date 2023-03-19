/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccine.registration.system;

/**
 *
 * @author liewjy
 */
record CitizenRecord(int People_ID, String Name, String Phone_Number, String Nationality, String IC_Number, String Address, String Password) {

    public CitizenRecord withName(String newName) {
        return new CitizenRecord(People_ID, Phone_Number, newName, Nationality, IC_Number, Address, Password);
    }

    public CitizenRecord withPhoneNumber(String newPhone_Number) {
        return new CitizenRecord(People_ID, newPhone_Number, Name, Nationality, IC_Number, Address, Password);
    }

    public CitizenRecord withNationality(String newNationality) {
        return new CitizenRecord(People_ID, Phone_Number, Name, newNationality, IC_Number, Address, Password);
    }

    public CitizenRecord withIcNumber(String newIcNumber) {
        return new CitizenRecord(People_ID, Phone_Number, Name, Nationality, newIcNumber, Address, Password);
    }

    public CitizenRecord withAddress(String newAddress) {
        return new CitizenRecord(People_ID, Phone_Number, Name, Nationality, IC_Number, newAddress, Password);
    }

    public CitizenRecord withPassword(String newPassword) {
        return new CitizenRecord(People_ID, Phone_Number, Name, Nationality, IC_Number, Address, newPassword);
    }

}
