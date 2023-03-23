/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccine.registration.system;

import org.jpl7.Query;
import org.jpl7.Term;

/**
 *
 * @author liewj
 */
public class ChartController {

    String path = "src/vaccine/registration/system/prolog.pl";
    public String pendingOne() {
        if (connect(path)) {
            String qs = "count_pending_1_vaccine_records(VaccineRecords, Count).";
            Query q1 = new Query(qs);
            System.out.println("pending 1 " + q1.oneSolution().get("Count"));
            return q1.oneSolution().get("Count").toString();
        }
        return null;
    }

    public String CompletedOne() {
        if (connect(path)) {
            String qs = "count_completed_1_vaccine_records(VaccineRecords, Count).";
            Query q1 = new Query(qs);
            System.out.println("completed 1 " + q1.oneSolution().get("Count"));
            return q1.oneSolution().get("Count").toString();
        }
        return null;
    }
    
        public String pendingTwo() {
        if (connect(path)) {
            String qs = "count_pending_2_vaccine_records(VaccineRecords, Count).";
            Query q1 = new Query(qs);
            System.out.println("pending 2 " + q1.oneSolution().get("Count"));
            return q1.oneSolution().get("Count").toString();
        }
        return null;
    }

    public String CompletedTwo() {
        if (connect(path)) {
            String qs = "count_completed_2_vaccine_records(VaccineRecords, Count).";
            Query q1 = new Query(qs);
            System.out.println("completed 2 " + q1.oneSolution().get("Count"));
            return q1.oneSolution().get("Count").toString();
        }
        return null;
    }

    private static boolean connect(String path) {
        String qs = "consult('" + path + "')";
        Query q = new Query(qs);
        boolean isConnect = q.hasSolution();
        q.close();
        return isConnect;
    }
}
