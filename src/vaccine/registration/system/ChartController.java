
package vaccine.registration.system;

import org.jpl7.Query;
import org.jpl7.Term;


public class ChartController {

    String path = "src/vaccine/registration/system/prolog.pl";
    public String pendingOne() {
        if (connect(path)) {
            String qs = "count_pending_1_vaccination_status_records(VaccinationStatusRecords, Count).";
            Query q1 = new Query(qs);
            return q1.oneSolution().get("Count").toString();
        }
        return null;
    }

    public String CompletedOne() {
        if (connect(path)) {
            String qs = "count_completed_1_vaccination_status_records(VaccinationStatusRecords, Count).";
            Query q1 = new Query(qs);
            return q1.oneSolution().get("Count").toString();
        }
        return null;
    }
    
        public String pendingTwo() {
        if (connect(path)) {
            String qs = "count_pending_2_vaccination_status_records(VaccinationStatusRecords, Count).";
            Query q1 = new Query(qs);
            return q1.oneSolution().get("Count").toString();
        }
        return null;
    }

    public String CompletedTwo() {
        if (connect(path)) {
            String qs = "count_completed_2_vaccination_status_records(VaccinationStatusRecords, Count).";
            Query q1 = new Query(qs);
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
