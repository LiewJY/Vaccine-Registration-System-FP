package vaccine.registration.system;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.jpl7.Query;
import org.jpl7.Term;

public class VaccineRegistrationSystem {

    // Main method to display login screen
    public static void main(String[] args) throws FileNotFoundException, IOException {
       // String path = "src/vaccine/registration/system/prolog.pl";
//        System.setProperty("java.library.path", "lib/");
//        System.loadLibrary("jpl");
//        if (connect(path)) {
//
//        }
        Login login = new Login();
        login.setVisible(true);

    }

//    private static boolean connect(String path) {
//        String qs = "consult('" + path + "')";
//        Query q = new Query(qs);
//        boolean isConnect = q.hasSolution();
//        q.close();
//
//        return isConnect;
//
//    }

}
