package vaccine.registration.system;

import java.io.FileNotFoundException;
import java.io.IOException;

public class VaccineRegistrationSystem {

    // Main method to display login screen
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Login login = new Login();
        login.setVisible(true);

    }
}
