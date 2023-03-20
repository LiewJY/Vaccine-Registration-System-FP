package vaccine.registration.system;

import java.io.FileNotFoundException;
import java.io.IOException;

public class VaccineRegistrationSystem {

    // Main method to display login screen
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // PeopleController pc = new PeopleController();
        //System.out.println(pc.calculatePeople_ID());

        //         FileController fc = new FileController();
        // fc.fileAccess("People.txt");
        //         System.out.println(fc.fileAccess("People.txt").map(data -> new CitizenRecord(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5])));
//        CitizenController cc = new CitizenController();
//        //cc.View_Account(2);
//        System.out.println(cc.View_Account(1));


        Login login = new Login();
        login.setVisible(true);

    }
}
