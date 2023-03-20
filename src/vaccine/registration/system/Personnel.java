package vaccine.registration.system;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import java.text.*;
import java.util.Arrays;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Personnel extends javax.swing.JFrame {

    ValidationClass validation_class = new ValidationClass();
    PersonnelClass personnel_class = new PersonnelClass();
    //CitizenClass citizen_class = new CitizenClass();
    NonCitizenClass noncitizen_class = new NonCitizenClass();
    CenterClass center_class = new CenterClass();
    VaccineClass vaccine_class = new VaccineClass();
    AppointmentClass appointment_class = new AppointmentClass();
    PeopleClass people_class = new PeopleClass();

    // For formatting date
    SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();

    //for functional 
    CitizenController cc = new CitizenController();
    int People_ID;

    // Personnel form
    public Personnel() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
    }

    public Personnel(int personnel_id) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
        personnel_class.setPersonnel_ID(personnel_id);
    }

    // Clear input fields
    public void Clear() {
        // Edit account 
        txt_edit_name.setText("");
        txt_edit_phone_number.setText("");
        txt_edit_nationality.setText("");
        txt_edit_ic_passport_number.setText("");
        txt_edit_address.setText("");
        txt_edit_password.setText("");
        txt_edit_confirm_password.setText("");

        // Register people
        txt_register_people_name.setText("");
        txt_register_people_phone_number.setText("");
        cbo_register_people_nationality.setSelectedIndex(-1);
        txt_register_people_ic_passport_number.setText("");
        txt_register_people_address.setText("");
        txt_register_people_password.setText("");
        txt_register_people_confirm_password.setText("");

        // Edit people
        txt_edit_people_name.setText("");
        txt_edit_people_phone_number.setText("");
        cbo_edit_people_nationality.setSelectedIndex(-1);
        txt_edit_people_ic_passport_number.setText("");
        txt_edit_people_address.setText("");
        txt_edit_people_password.setText("");
        txt_edit_people_confirm_password.setText("");

        // Register appointment
        txt_register_vaccination_appointments_ic_passport_number.setText("");
        txt_register_vaccination_appointments_select_date.setCalendar(null);
        cbo_register_vaccination_appointments_select_time.setSelectedIndex(-1);
        lbl_register_vaccination_appointments_vaccine_type.setText("");

        // Edit appointment
        txt_edit_vaccination_appointments_ic_passport_number.setText("");
        txt_edit_vaccination_appointments_select_date.setCalendar(null);
        cbo_edit_vaccination_appointments_select_time.setSelectedIndex(-1);
        lbl_edit_vaccination_appointments_vaccine_type.setText("");

        // Add center
        txt_add_center_name.setText("");
        txt_add_center_address.setText("");
        txt_add_center_contact_number.setText("");
        cbo_add_center_vaccine_type.setSelectedIndex(-1);

        // Edit center
        lbl_edit_center_id.setText("");
        txt_edit_center_name.setText("");
        txt_edit_center_address.setText("");
        txt_edit_center_contact_number.setText("");
        lbl_edit_center_vaccine_type.setText("");

        // Add vaccine
        txt_add_vaccine_batch_id.setText("");
        cbo_add_vaccine_type.setSelectedIndex(-1);
        txt_add_vaccine_date.setCalendar(null);
        txt_add_vaccine_expiration_date.setCalendar(null);
        cbo_add_vaccine_center_name.setSelectedIndex(-1);
        lbl_add_vaccine_second_dose_gap.setText("");

        // Edit vaccine
        txt_edit_vaccine_batch_id.setText("");
        cbo_edit_vaccine_type.setSelectedIndex(-1);
        txt_edit_vaccine_date.setCalendar(null);
        txt_edit_vaccine_expiration_date.setCalendar(null);
        cbo_edit_vaccine_center_name.setSelectedIndex(-1);
        lbl_edit_vaccine_second_dose_gap.setText("");
    }

    // Get all country listing
    public String[] getCountries() {
        String[] countries = new String[Locale.getISOCountries().length];
        String[] countryCodes = Locale.getISOCountries();
        for (int i = 0; i < countryCodes.length; i++) {
            Locale obj = new Locale("", countryCodes[i]);
            countries[i] = obj.getDisplayCountry();
        }
        Arrays.sort(countries);
        return countries;
    }

    // View + hide pannel
    public void View_Personnel() {
        // Insert data
        personnel_class.View_Account();
        lbl_view_name.setText(personnel_class.getName());
        lbl_view_phone_number.setText(personnel_class.getPhone_Number());
        lbl_view_nationality.setText(personnel_class.getNationality());
        lbl_view_ic_passport_number.setText(personnel_class.getIC_Number());
        lbl_view_address.setText(personnel_class.getAddress());

        // Hide pannel
        pnl_view_account.setVisible(true);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
    }

    // View people
    public void View_People() {
        // Populate country in nationality
        DefaultComboBoxModel cbo = new DefaultComboBoxModel();

        for (String rowValue : getCountries()) {
            cbo.addElement(rowValue);
        }

        cbo_register_people_nationality.setModel(cbo);
        cbo_register_people_nationality.setSelectedIndex(-1);
        cbo_edit_people_nationality.setModel(cbo);
        cbo_edit_people_nationality.setSelectedIndex(-1);

        // Disable button no selected row
        btn_people_edit.setEnabled(false);

        // Set column
        personnel_class.View_People();

        String columns[] = {"People ID", "Name", "Phone Number", "Nationality", "IC / Passport Number", "Address", "Password"};

        DefaultTableModel people_table_model = (DefaultTableModel) tbl_view_people.getModel();
        people_table_model.setColumnIdentifiers(columns);

        // Remove password column
        tbl_view_people.removeColumn(tbl_view_people.getColumnModel().getColumn(0));
        tbl_view_people.removeColumn(tbl_view_people.getColumnModel().getColumn(5));

        tbl_view_people.setModel(people_table_model);
        people_table_model.setRowCount(0);

        // Loop and display data
        for (int i = 0; i < personnel_class.getPeople_Data().size(); i++) {
            String[] data = personnel_class.getPeople_Data().get(i).split("//");
            people_table_model.addRow(data);
        }

        // Get data of selected row
        tbl_view_people.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btn_people_edit.setEnabled(true);
                int rows = tbl_view_people.getSelectedRow();
                int row = tbl_view_people.convertRowIndexToModel(rows);

                // Populte to edit pannel
                if (people_table_model.getValueAt(row, 3).toString().equals("Malaysia")) {
                    People_ID = Integer.parseInt(people_table_model.getValueAt(row, 0).toString());
                } else {
                    noncitizen_class.setPeople_ID(Integer.parseInt(people_table_model.getValueAt(row, 0).toString()));
                }

                txt_edit_people_name.setText(people_table_model.getValueAt(row, 1).toString());
                txt_edit_people_phone_number.setText(people_table_model.getValueAt(row, 2).toString());
                cbo_edit_people_nationality.setSelectedItem(people_table_model.getValueAt(row, 3).toString());
                txt_edit_people_ic_passport_number.setText(people_table_model.getValueAt(row, 4).toString());
                txt_edit_people_address.setText(people_table_model.getValueAt(row, 5).toString());
                txt_edit_people_password.setText(people_table_model.getValueAt(row, 6).toString());
                txt_edit_people_confirm_password.setText(people_table_model.getValueAt(row, 6).toString());
            }
        });

        // Hide pannel
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(true);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
        Clear();
    }

    // View center
    public void View_Center() {
        // Disable button no selected row
        btn_vaccination_center_edit.setEnabled(false);
        btn_vaccination_center_remove.setEnabled(false);

        // Load data
        center_class.View_Center();

        // Set column
        String columns[] = {"Center ID", "Center Name", "Center Address", "Contact Number", "Vaccine Type"};

        DefaultTableModel center_table_model = (DefaultTableModel) tbl_view_vaccination_center.getModel();
        center_table_model.setColumnIdentifiers(columns);

        // Remove ID column
        tbl_view_vaccination_center.removeColumn(tbl_view_vaccination_center.getColumnModel().getColumn(0));

        tbl_view_vaccination_center.setModel(center_table_model);
        center_table_model.setRowCount(0);

        // Loop and display data
        for (int i = 0; i < center_class.getCenter_Data().size(); i++) {
            String[] data = center_class.getCenter_Data().get(i).split("//");
            center_table_model.addRow(data);
        }

        // Get data of selected row
        tbl_view_vaccination_center.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btn_vaccination_center_edit.setEnabled(true);
                btn_vaccination_center_remove.setEnabled(true);

                int rows = tbl_view_vaccination_center.getSelectedRow();
                int row = tbl_view_vaccination_center.convertRowIndexToModel(rows);

                // For deleting
                center_class.setCenter_ID(Integer.parseInt(center_table_model.getValueAt(row, 0).toString()));
                center_class.setCenter_Name(center_table_model.getValueAt(row, 1).toString());

                // Populate to edit panel
                lbl_edit_center_id.setText(center_table_model.getValueAt(row, 0).toString());
                txt_edit_center_name.setText(center_table_model.getValueAt(row, 1).toString());
                txt_edit_center_address.setText(center_table_model.getValueAt(row, 2).toString());
                txt_edit_center_contact_number.setText(center_table_model.getValueAt(row, 3).toString());
                lbl_edit_center_vaccine_type.setText(center_table_model.getValueAt(row, 4).toString());
            }
        });

        // Hide panel
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(true);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
        Clear();
    }

    // Center details
    private class Center {

        private String id, name, type;

        public Center(String id, String name, String type) {
            this.id = id;
            this.name = name;
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String toString() {
            return name;
        }
    }

    ArrayList<Center> center_id_to_name = new ArrayList<>();

    public void Center_ID_and_Details() {
        // Load data
        center_class.View_Center();
        center_id_to_name.clear();

        // Loop and add data
        for (int i = 0; i < center_class.getCenter_Data().size(); i++) {
            String[] data = center_class.getCenter_Data().get(i).split("//");
            center_id_to_name.add(new Center(data[0], data[1], data[2]));
        }
    }

    // People details
    private class PeopleDetails {

        private String id, name, ic_passport_number;

        public PeopleDetails(String id, String name, String ic_passport_number) {
            this.id = id;
            this.name = name;
            this.ic_passport_number = ic_passport_number;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getICPassportNumber() {
            return ic_passport_number;
        }

        public String toString() {
            return name;
        }
    }

    ArrayList<PeopleDetails> people_id_and_details = new ArrayList<>();

    public void People_ID_and_Details() {
        // Load data
        personnel_class.View_People();
        people_id_and_details.clear();

        // Loop and add data
        for (int i = 0; i < personnel_class.getPeople_Data().size(); i++) {
            String[] data = personnel_class.getPeople_Data().get(i).split("//");
            people_id_and_details.add(new PeopleDetails(data[0], data[1], data[4]));
        }
    }

    // Vaccine details
    private class VaccineDetails {

        private String id, type, center_id, date;

        public VaccineDetails(String id, String date, String type, String center_id) {
            this.id = id;
            this.type = type;
            this.date = date;
            this.center_id = center_id;
        }

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public String getDate() {
            return date;
        }

        public String getCenterID() {
            return center_id;
        }

        public String toString() {
            return type;
        }
    }

    ArrayList<VaccineDetails> vaccine_id_and_details = new ArrayList<>();

    public void Vaccine_ID_and_Details() {
        // Load data
        vaccine_class.View_Vaccine();
        vaccine_id_and_details.clear();

        // Loop and add data
        for (int i = 0; i < vaccine_class.getVaccine_Data().size(); i++) {
            String[] data = vaccine_class.getVaccine_Data().get(i).split("//");
            vaccine_id_and_details.add(new VaccineDetails(data[0], data[3], data[2], data[6]));
        }
    }

    // View vaccine
    public void View_Vaccine() {
        // Populate the center dropdowns
        center_class.View_Center();
        cbo_add_vaccine_center_name.removeAllItems();
        cbo_edit_vaccine_center_name.removeAllItems();

        DefaultComboBoxModel cbo_add_model = (DefaultComboBoxModel) cbo_add_vaccine_center_name.getModel();
        DefaultComboBoxModel cbo_edit_model = (DefaultComboBoxModel) cbo_edit_vaccine_center_name.getModel();

        for (int i = 0; i < center_class.getCenter_Data().size(); i++) {
            String[] data = center_class.getCenter_Data().get(i).split("//");
            cbo_add_model.addElement(new Center(data[0], data[1], data[2]));
            cbo_edit_model.addElement(new Center(data[0], data[1], data[2]));
        }

        cbo_add_vaccine_center_name.setModel(cbo_add_model);
        cbo_edit_vaccine_center_name.setModel(cbo_edit_model);

        // Disable button no selected row
        btn_vaccine_edit.setEnabled(false);
        btn_vaccine_remove.setEnabled(false);

        // Load data
        vaccine_class.View_Vaccine();

        // Set column
        String columns[] = {"ID", "Batch ID", "Type", "Date", "Expiration Date", "Second Dose Gap (weeks)", "Center Name"};

        DefaultTableModel vaccine_table_model = (DefaultTableModel) tbl_view_vaccine.getModel();
        vaccine_table_model.setColumnIdentifiers(columns);

        // Remove ID column
        tbl_view_vaccine.removeColumn(tbl_view_vaccine.getColumnModel().getColumn(0));

        tbl_view_vaccine.setModel(vaccine_table_model);
        vaccine_table_model.setRowCount(0);

        // Loop and display data
        Center_ID_and_Details();

        for (int i = 0; i < vaccine_class.getVaccine_Data().size(); i++) {
            String[] data = vaccine_class.getVaccine_Data().get(i).split("//");

            for (Center center : center_id_to_name) {
                if (center.getId().equals(data[6])) {
                    data[6] = center.getName();
                }
            }
            vaccine_table_model.addRow(data);
        }

        // Get data of selected row
        tbl_view_vaccine.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btn_vaccine_edit.setEnabled(true);
                btn_vaccine_remove.setEnabled(true);

                int rows = tbl_view_vaccine.getSelectedRow();
                int row = tbl_view_vaccine.convertRowIndexToModel(rows);

                // For deleting
                vaccine_class.setVaccine_ID(Integer.parseInt(vaccine_table_model.getValueAt(row, 0).toString()));

                // Populate to edit panel
                txt_edit_vaccine_batch_id.setText(vaccine_table_model.getValueAt(row, 1).toString());
                cbo_edit_vaccine_type.setSelectedItem(vaccine_table_model.getValueAt(row, 2).toString());
                Date date = null;

                try {
                    date = date_format.parse(vaccine_table_model.getValueAt(row, 3).toString());
                    txt_edit_vaccine_date.setDate(date);

                    date = date_format.parse(vaccine_table_model.getValueAt(row, 4).toString());
                    txt_edit_vaccine_expiration_date.setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(Personnel.class.getName()).log(Level.SEVERE, null, ex);
                }

                lbl_edit_vaccine_second_dose_gap.setText(vaccine_table_model.getValueAt(row, 5).toString());
                cbo_edit_vaccine_center_name.setSelectedItem(vaccine_table_model.getValueAt(row, 6).toString());
            }
        });

        // Hide panel
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(true);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
        Clear();
    }

    // View appointment
    public void View_Appointment() {
        // Disable button no selected row
        btn_vaccination_appointments_edit.setEnabled(false);
        btn_vaccination_appointments_update.setEnabled(false);
        btn_vaccination_appointments_remove.setEnabled(false);

        // Load data
        appointment_class.View_Appointment();

        // Set column
        String columns[] = {"ID", "People ID", "Name", "IC / Passport Number", "Date", "Time", "Center Name", "Type", "Dose", "Status"};

        DefaultTableModel appointment_table_model = (DefaultTableModel) tbl_view_vaccination_appointments.getModel();
        appointment_table_model.setColumnIdentifiers(columns);

        // Remove ID column
        tbl_view_vaccination_appointments.removeColumn(tbl_view_vaccination_appointments.getColumnModel().getColumn(0));
        tbl_view_vaccination_appointments.removeColumn(tbl_view_vaccination_appointments.getColumnModel().getColumn(0));

        tbl_view_vaccination_appointments.setModel(appointment_table_model);
        appointment_table_model.setRowCount(0);

        // Loop and display data
        Center_ID_and_Details();
        People_ID_and_Details();
        Vaccine_ID_and_Details();

        for (int i = 0; i < appointment_class.getAppointment_Data().size(); i++) {
            String[] data = appointment_class.getAppointment_Data().get(i).split("//");

            for (PeopleDetails peopledetails : people_id_and_details) {
                if (peopledetails.getId().equals(data[1])) {
                    data[1] = peopledetails.getId();

                    int index = 2;
                    String key = peopledetails.getName();
                    String[] result = new String[data.length + 1];
                    System.arraycopy(data, 0, result, 0, index);
                    result[index] = key;
                    System.arraycopy(data, index, result, index + 1, data.length - index);
                    data = result;

                    index = 3;
                    key = peopledetails.getICPassportNumber();
                    result = new String[data.length + 1];
                    System.arraycopy(data, 0, result, 0, index);
                    result[index] = key;
                    System.arraycopy(data, index, result, index + 1, data.length - index);
                    data = result;
                }
            }

            for (VaccineDetails vac : vaccine_id_and_details) {
                if (vac.getId().equals(data[4])) {
                    data[4] = vac.getDate();
                    int index = 6;
                    String key = vac.getCenterID();
                    String[] result = new String[data.length + 1];
                    System.arraycopy(data, 0, result, 0, index);
                    result[index] = key;
                    System.arraycopy(data, index, result, index + 1, data.length - index);
                    data = result;

                    index = 7;
                    key = vac.getType();
                    result = new String[data.length + 1];
                    System.arraycopy(data, 0, result, 0, index);
                    result[index] = key;
                    System.arraycopy(data, index, result, index + 1, data.length - index);
                    data = result;
                }
            }

            for (Center center : center_id_to_name) {
                if (center.getId().equals(data[6])) {
                    data[6] = center.getName();
                }
            }

            appointment_table_model.addRow(data);
        }

        // Get data of selected row
        tbl_view_vaccination_appointments.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                btn_vaccination_appointments_edit.setEnabled(true);
                btn_vaccination_appointments_update.setEnabled(true);
                btn_vaccination_appointments_remove.setEnabled(true);

                int rows = tbl_view_vaccination_appointments.getSelectedRow();
                int row = tbl_view_vaccination_appointments.convertRowIndexToModel(rows);

                // For deleting
                appointment_class.setAppointnment_ID(Integer.parseInt(appointment_table_model.getValueAt(row, 0).toString()));

                // Vaccine ID
                appointment_class.setAppointment_Time(appointment_table_model.getValueAt(row, 5).toString());

                // Populte to edit panel
                txt_edit_vaccination_appointments_ic_passport_number.setText(appointment_table_model.getValueAt(row, 3).toString());
                Date date = null;

                try {
                    date = date_format.parse(appointment_table_model.getValueAt(row, 4).toString());
                    txt_edit_vaccination_appointments_select_date.setDate(date);
                } catch (ParseException ex) {

                }

                cbo_edit_vaccination_appointments_select_time.setSelectedItem(appointment_table_model.getValueAt(row, 5).toString());
                cbo_edit_vaccination_appointments_select_vaccination_center.setSelectedItem(appointment_table_model.getValueAt(row, 6).toString());
            }
        });

        // Hide panel 
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(true);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
        Clear();
    }

    // UI
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_sidenav = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        pnl_my_account = new javax.swing.JPanel();
        lbl_my_account = new javax.swing.JLabel();
        pnl_people = new javax.swing.JPanel();
        lbl_people = new javax.swing.JLabel();
        pnl_vaccination_appointments = new javax.swing.JPanel();
        lbl_vaccination_appointments = new javax.swing.JLabel();
        pnl_vaccination_center = new javax.swing.JPanel();
        lbl_vaccination_center = new javax.swing.JLabel();
        pnl_vaccine = new javax.swing.JPanel();
        lbl_vaccine = new javax.swing.JLabel();
        pnl_logout = new javax.swing.JPanel();
        lbl_logout = new javax.swing.JLabel();
        pnl_container = new javax.swing.JPanel();
        pnl_view_account = new javax.swing.JPanel();
        pnl_myAccount = new javax.swing.JPanel();
        lbl_myAccount = new javax.swing.JLabel();
        lbl_view_name = new javax.swing.JLabel();
        lbl_view_phone_number = new javax.swing.JLabel();
        lbl_view_nationality = new javax.swing.JLabel();
        lbl_view_ic_passport_number = new javax.swing.JLabel();
        btn_edit_account = new javax.swing.JButton();
        lbl_view_address = new javax.swing.JTextArea();
        pnl_edit_account = new javax.swing.JPanel();
        pnl_editAccount = new javax.swing.JPanel();
        lbl_editAccount = new javax.swing.JLabel();
        lbl_edit_name = new javax.swing.JLabel();
        txt_edit_name = new javax.swing.JTextField();
        lbl_edit_phone_number = new javax.swing.JLabel();
        txt_edit_phone_number = new javax.swing.JTextField();
        lbl_edit_nationality = new javax.swing.JLabel();
        txt_edit_nationality = new javax.swing.JTextField();
        lbl_edit_ic_passport_number = new javax.swing.JLabel();
        txt_edit_ic_passport_number = new javax.swing.JTextField();
        lbl_edit_address = new javax.swing.JLabel();
        txt_edit_address = new javax.swing.JTextField();
        lbl_edit_password = new javax.swing.JLabel();
        txt_edit_password = new javax.swing.JPasswordField();
        lbl_edit_confirm_password = new javax.swing.JLabel();
        txt_edit_confirm_password = new javax.swing.JPasswordField();
        btn_save_edit = new javax.swing.JButton();
        btn_cancel_edit = new javax.swing.JButton();
        pnl_view_people = new javax.swing.JPanel();
        pnl_viewPeople = new javax.swing.JPanel();
        lbl_view_people = new javax.swing.JLabel();
        lbl_search_people = new javax.swing.JLabel();
        txt_search_people = new javax.swing.JTextField();
        btn_people_register = new javax.swing.JButton();
        btn_people_edit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_view_people = new javax.swing.JTable();
        pnl_register_people = new javax.swing.JPanel();
        pnl_registerPeople = new javax.swing.JPanel();
        lbl_registerPeople = new javax.swing.JLabel();
        lbl_register_people_name = new javax.swing.JLabel();
        txt_register_people_name = new javax.swing.JTextField();
        lbl_register_people_phone_number = new javax.swing.JLabel();
        txt_register_people_phone_number = new javax.swing.JTextField();
        lbl_register_people_nationaliy = new javax.swing.JLabel();
        cbo_register_people_nationality = new javax.swing.JComboBox<>();
        lbl_register_people_ic_passport_number = new javax.swing.JLabel();
        txt_register_people_ic_passport_number = new javax.swing.JTextField();
        lbl_register_people_address = new javax.swing.JLabel();
        txt_register_people_address = new javax.swing.JTextField();
        lbl_register_people_password = new javax.swing.JLabel();
        txt_register_people_password = new javax.swing.JPasswordField();
        lbl_register_people_confirm_password = new javax.swing.JLabel();
        txt_register_people_confirm_password = new javax.swing.JPasswordField();
        btn_register_people_register = new javax.swing.JButton();
        btn_register_people_cancel = new javax.swing.JButton();
        pnl_edit_people = new javax.swing.JPanel();
        pnl_editPeople = new javax.swing.JPanel();
        lbl_editPeople = new javax.swing.JLabel();
        lbl_edit_people_name = new javax.swing.JLabel();
        txt_edit_people_name = new javax.swing.JTextField();
        lbl_edit_people__phone_number = new javax.swing.JLabel();
        txt_edit_people_phone_number = new javax.swing.JTextField();
        lbl_edit_people_nationaliy = new javax.swing.JLabel();
        cbo_edit_people_nationality = new javax.swing.JComboBox<>();
        lbl_edit_people_ic_passport_number = new javax.swing.JLabel();
        txt_edit_people_ic_passport_number = new javax.swing.JTextField();
        lbl_edit_people_address = new javax.swing.JLabel();
        txt_edit_people_address = new javax.swing.JTextField();
        lbl_edit_people_password = new javax.swing.JLabel();
        txt_edit_people_password = new javax.swing.JPasswordField();
        lbl_edit_people_confirm_password = new javax.swing.JLabel();
        txt_edit_people_confirm_password = new javax.swing.JPasswordField();
        btn_edit_people_save = new javax.swing.JButton();
        btn_edit_people_cancel = new javax.swing.JButton();
        pnl_view_vaccination_appointments = new javax.swing.JPanel();
        pnl_viewVaccinationAppointments = new javax.swing.JPanel();
        lbl_view_vaccination_appointments = new javax.swing.JLabel();
        lbl_search_vaccination_appointments = new javax.swing.JLabel();
        txt_search_vaccination_appointments = new javax.swing.JTextField();
        btn_vaccination_appointments_register = new javax.swing.JButton();
        btn_vaccination_appointments_edit = new javax.swing.JButton();
        btn_vaccination_appointments_update = new javax.swing.JButton();
        btn_vaccination_appointments_remove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_view_vaccination_appointments = new javax.swing.JTable();
        pnl_register_vaccination_appointments = new javax.swing.JPanel();
        pnl_registerVaccinationAppointments = new javax.swing.JPanel();
        lbl_registerVaccinationAppointments = new javax.swing.JLabel();
        lbl_register_vaccination_appointments_ic_passport_number = new javax.swing.JLabel();
        txt_register_vaccination_appointments_ic_passport_number = new javax.swing.JTextField();
        lbl_register_vaccination_appointments_select_date = new javax.swing.JLabel();
        txt_register_vaccination_appointments_select_date = new com.toedter.calendar.JDateChooser();
        lbl_register_vaccination_appointments_select_time = new javax.swing.JLabel();
        cbo_register_vaccination_appointments_select_time = new javax.swing.JComboBox<>();
        lbl_register_vaccination_appointments_select_vaccination_center = new javax.swing.JLabel();
        cbo_register_vaccination_appointments_select_vaccination_center = new javax.swing.JComboBox<>();
        lbl_registerVaccinationAppointmentsVaccineType = new javax.swing.JLabel();
        lbl_register_vaccination_appointments_vaccine_type = new javax.swing.JLabel();
        btn_register_vaccination_appointments_register = new javax.swing.JButton();
        btn_register_vaccination_appointments_cancel = new javax.swing.JButton();
        pnl_edit_vaccination_appointments = new javax.swing.JPanel();
        pnl_editVaccinationAppointments = new javax.swing.JPanel();
        lbl_registerVaccinationAppointments1 = new javax.swing.JLabel();
        lbl_edit_vaccination_appointments_ic_passport_number = new javax.swing.JLabel();
        txt_edit_vaccination_appointments_ic_passport_number = new javax.swing.JTextField();
        lbl_edit_vaccination_appointments_select_date = new javax.swing.JLabel();
        txt_edit_vaccination_appointments_select_date = new com.toedter.calendar.JDateChooser();
        lbl_edit_vaccination_appointments_select_time = new javax.swing.JLabel();
        cbo_edit_vaccination_appointments_select_time = new javax.swing.JComboBox<>();
        lbl_edit_vaccination_appointments_select_vaccination_center = new javax.swing.JLabel();
        cbo_edit_vaccination_appointments_select_vaccination_center = new javax.swing.JComboBox<>();
        lbl_editVaccinationAppointmentsVaccineType = new javax.swing.JLabel();
        lbl_edit_vaccination_appointments_vaccine_type = new javax.swing.JLabel();
        btn_edit_vaccination_appointments_save = new javax.swing.JButton();
        btn_edit_vaccination_appointments_cancel = new javax.swing.JButton();
        pnl_view_vaccination_center = new javax.swing.JPanel();
        pnl_viewVaccinationCenter = new javax.swing.JPanel();
        lbl_view_vaccination_center = new javax.swing.JLabel();
        lbl_search_vaccination_center = new javax.swing.JLabel();
        txt_search_vaccination_center = new javax.swing.JTextField();
        btn_vaccination_center_add = new javax.swing.JButton();
        btn_vaccination_center_edit = new javax.swing.JButton();
        btn_vaccination_center_remove = new javax.swing.JButton();
        scrpnl_view_vaccination_center = new javax.swing.JScrollPane();
        tbl_view_vaccination_center = new javax.swing.JTable();
        pnl_add_center = new javax.swing.JPanel();
        pnl_addCenter = new javax.swing.JPanel();
        lbl_add_center = new javax.swing.JLabel();
        lbl_add_center_name = new javax.swing.JLabel();
        txt_add_center_name = new javax.swing.JTextField();
        lbl_add_center_address = new javax.swing.JLabel();
        txt_add_center_address = new javax.swing.JTextField();
        lbl_add_center_contact_number = new javax.swing.JLabel();
        txt_add_center_contact_number = new javax.swing.JTextField();
        btn_add_center_add = new javax.swing.JButton();
        btn_add_center_cancel = new javax.swing.JButton();
        cbo_add_center_vaccine_type = new javax.swing.JComboBox<>();
        lbl_add_center_vaccine_type = new javax.swing.JLabel();
        pnl_edit_center = new javax.swing.JPanel();
        pnl_editCenter = new javax.swing.JPanel();
        lbl_edit_center = new javax.swing.JLabel();
        lbl_editCenterId = new javax.swing.JLabel();
        lbl_edit_center_id = new javax.swing.JLabel();
        lbl_edit_center_name = new javax.swing.JLabel();
        txt_edit_center_name = new javax.swing.JTextField();
        lbl_edit_center_address = new javax.swing.JLabel();
        txt_edit_center_address = new javax.swing.JTextField();
        lbl_edit_center_contact_number = new javax.swing.JLabel();
        txt_edit_center_contact_number = new javax.swing.JTextField();
        btn_edit_center_save = new javax.swing.JButton();
        btn_edit_center_cancel = new javax.swing.JButton();
        lbl_edit_center_vaccine_type = new javax.swing.JLabel();
        lbl_edit_center_vaccine_type_title = new javax.swing.JLabel();
        pnl_view_vaccine = new javax.swing.JPanel();
        pnl_viewVaccine = new javax.swing.JPanel();
        lbl_view_vaccine = new javax.swing.JLabel();
        lbl_search_vaccine = new javax.swing.JLabel();
        txt_search_vaccine = new javax.swing.JTextField();
        btn_vaccine_add = new javax.swing.JButton();
        btn_vaccine_edit = new javax.swing.JButton();
        btn_vaccine_remove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_view_vaccine = new javax.swing.JTable();
        pnl_add_vaccine = new javax.swing.JPanel();
        pnl_addVaccine = new javax.swing.JPanel();
        lbl_add_vaccine = new javax.swing.JLabel();
        lbl_add_vaccine_batch_id = new javax.swing.JLabel();
        txt_add_vaccine_batch_id = new javax.swing.JTextField();
        lbl_add_vaccine_type = new javax.swing.JLabel();
        cbo_add_vaccine_type = new javax.swing.JComboBox<>();
        lbl_add_vaccine_date = new javax.swing.JLabel();
        txt_add_vaccine_date = new com.toedter.calendar.JDateChooser();
        lbl_add_vaccine_expiration_date = new javax.swing.JLabel();
        txt_add_vaccine_expiration_date = new com.toedter.calendar.JDateChooser();
        lbl_add_vaccine_center_name = new javax.swing.JLabel();
        cbo_add_vaccine_center_name = new javax.swing.JComboBox<>();
        lbl_addVaccineSecondDoseGap = new javax.swing.JLabel();
        lbl_add_vaccine_second_dose_gap = new javax.swing.JLabel();
        btn_add_vaccine_add = new javax.swing.JButton();
        btn_add_vaccine_cancel = new javax.swing.JButton();
        pnl_edit_vaccine = new javax.swing.JPanel();
        pnl_editVaccine = new javax.swing.JPanel();
        lbl_edit_vaccine = new javax.swing.JLabel();
        lbl_edit_vaccine_batch_id = new javax.swing.JLabel();
        txt_edit_vaccine_batch_id = new javax.swing.JTextField();
        lbl_edit_vaccine_type = new javax.swing.JLabel();
        cbo_edit_vaccine_type = new javax.swing.JComboBox<>();
        lbl_edit_vaccine_date = new javax.swing.JLabel();
        txt_edit_vaccine_date = new com.toedter.calendar.JDateChooser();
        lbl_edit_vaccine_expiration_date = new javax.swing.JLabel();
        txt_edit_vaccine_expiration_date = new com.toedter.calendar.JDateChooser();
        lbl_edit_vaccine_center_name = new javax.swing.JLabel();
        cbo_edit_vaccine_center_name = new javax.swing.JComboBox<>();
        lbl_editVaccineSecondDoseGap = new javax.swing.JLabel();
        lbl_edit_vaccine_second_dose_gap = new javax.swing.JLabel();
        btn_edit_vaccine_save = new javax.swing.JButton();
        btn_edit_vaccine_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personnel");

        pnl_sidenav.setBackground(new java.awt.Color(136, 178, 219));
        pnl_sidenav.setMinimumSize(new java.awt.Dimension(320, 0));
        pnl_sidenav.setPreferredSize(new java.awt.Dimension(320, 496));
        pnl_sidenav.setVerifyInputWhenFocusTarget(false);

        lbl_logo.setBackground(new java.awt.Color(255, 255, 255));
        lbl_logo.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lbl_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vaccine/registration/system/images/MyVaccine Logo - White.png"))); // NOI18N

        pnl_my_account.setBackground(new java.awt.Color(127, 163, 198));

        lbl_my_account.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_my_account.setForeground(new java.awt.Color(255, 255, 255));
        lbl_my_account.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_my_account.setText("My Account");
        lbl_my_account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_my_accountMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_my_accountLayout = new javax.swing.GroupLayout(pnl_my_account);
        pnl_my_account.setLayout(pnl_my_accountLayout);
        pnl_my_accountLayout.setHorizontalGroup(
            pnl_my_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_my_account, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_my_accountLayout.setVerticalGroup(
            pnl_my_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_my_account, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_people.setBackground(new java.awt.Color(127, 163, 198));

        lbl_people.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_people.setForeground(new java.awt.Color(255, 255, 255));
        lbl_people.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_people.setText("People");
        lbl_people.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_peopleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_peopleLayout = new javax.swing.GroupLayout(pnl_people);
        pnl_people.setLayout(pnl_peopleLayout);
        pnl_peopleLayout.setHorizontalGroup(
            pnl_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_people, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_peopleLayout.setVerticalGroup(
            pnl_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_people, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_vaccination_appointments.setBackground(new java.awt.Color(127, 163, 198));

        lbl_vaccination_appointments.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_vaccination_appointments.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vaccination_appointments.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_vaccination_appointments.setText("Vaccination Appointment");
        lbl_vaccination_appointments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_vaccination_appointmentsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_vaccination_appointmentsLayout = new javax.swing.GroupLayout(pnl_vaccination_appointments);
        pnl_vaccination_appointments.setLayout(pnl_vaccination_appointmentsLayout);
        pnl_vaccination_appointmentsLayout.setHorizontalGroup(
            pnl_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_vaccination_appointments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_vaccination_appointmentsLayout.setVerticalGroup(
            pnl_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_vaccination_appointments, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_vaccination_center.setBackground(new java.awt.Color(127, 163, 198));

        lbl_vaccination_center.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_vaccination_center.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vaccination_center.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_vaccination_center.setText("Vaccination Center");
        lbl_vaccination_center.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_vaccination_centerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_vaccination_centerLayout = new javax.swing.GroupLayout(pnl_vaccination_center);
        pnl_vaccination_center.setLayout(pnl_vaccination_centerLayout);
        pnl_vaccination_centerLayout.setHorizontalGroup(
            pnl_vaccination_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_vaccination_center, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_vaccination_centerLayout.setVerticalGroup(
            pnl_vaccination_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_vaccination_center, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_vaccine.setBackground(new java.awt.Color(127, 163, 198));
        pnl_vaccine.setFocusTraversalPolicyProvider(true);

        lbl_vaccine.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_vaccine.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vaccine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_vaccine.setText("Vaccine");
        lbl_vaccine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_vaccineMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_vaccineLayout = new javax.swing.GroupLayout(pnl_vaccine);
        pnl_vaccine.setLayout(pnl_vaccineLayout);
        pnl_vaccineLayout.setHorizontalGroup(
            pnl_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_vaccine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_vaccineLayout.setVerticalGroup(
            pnl_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_vaccine, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_logout.setBackground(new java.awt.Color(221, 98, 98));

        lbl_logout.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logout.setText("Log Out");
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_logoutLayout = new javax.swing.GroupLayout(pnl_logout);
        pnl_logout.setLayout(pnl_logoutLayout);
        pnl_logoutLayout.setHorizontalGroup(
            pnl_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnl_logoutLayout.setVerticalGroup(
            pnl_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_sidenavLayout = new javax.swing.GroupLayout(pnl_sidenav);
        pnl_sidenav.setLayout(pnl_sidenavLayout);
        pnl_sidenavLayout.setHorizontalGroup(
            pnl_sidenavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_my_account, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_sidenavLayout.createSequentialGroup()
                .addComponent(pnl_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(pnl_people, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_vaccination_appointments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_vaccination_center, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_vaccine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_sidenavLayout.setVerticalGroup(
            pnl_sidenavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_sidenavLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(pnl_my_account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pnl_people, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pnl_vaccination_appointments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pnl_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pnl_vaccine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pnl_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pnl_container.setBackground(new java.awt.Color(204, 204, 204));
        pnl_container.setPreferredSize(new java.awt.Dimension(960, 720));
        pnl_container.setRequestFocusEnabled(false);

        pnl_view_account.setBackground(new java.awt.Color(255, 255, 255));
        pnl_view_account.setPreferredSize(new java.awt.Dimension(960, 720));

        pnl_myAccount.setBackground(new java.awt.Color(136, 178, 219));

        lbl_myAccount.setBackground(new java.awt.Color(255, 255, 255));
        lbl_myAccount.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_myAccount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_myAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_myAccount.setText("My Account");

        javax.swing.GroupLayout pnl_myAccountLayout = new javax.swing.GroupLayout(pnl_myAccount);
        pnl_myAccount.setLayout(pnl_myAccountLayout);
        pnl_myAccountLayout.setHorizontalGroup(
            pnl_myAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_myAccountLayout.createSequentialGroup()
                .addContainerGap(280, Short.MAX_VALUE)
                .addComponent(lbl_myAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );
        pnl_myAccountLayout.setVerticalGroup(
            pnl_myAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_myAccountLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_myAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_view_name.setBackground(new java.awt.Color(255, 255, 255));
        lbl_view_name.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_view_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbl_view_phone_number.setBackground(new java.awt.Color(255, 255, 255));
        lbl_view_phone_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_view_phone_number.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbl_view_nationality.setBackground(new java.awt.Color(255, 255, 255));
        lbl_view_nationality.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_view_nationality.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbl_view_ic_passport_number.setBackground(new java.awt.Color(255, 255, 255));
        lbl_view_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_view_ic_passport_number.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_edit_account.setBackground(new java.awt.Color(73, 161, 236));
        btn_edit_account.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_edit_account.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit_account.setText("Edit Account");
        btn_edit_account.setBorder(null);
        btn_edit_account.setOpaque(true);
        btn_edit_account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_accountActionPerformed(evt);
            }
        });

        lbl_view_address.setEditable(false);
        lbl_view_address.setColumns(20);
        lbl_view_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_view_address.setLineWrap(true);
        lbl_view_address.setRows(5);
        lbl_view_address.setWrapStyleWord(true);
        lbl_view_address.setBorder(null);

        javax.swing.GroupLayout pnl_view_accountLayout = new javax.swing.GroupLayout(pnl_view_account);
        pnl_view_account.setLayout(pnl_view_accountLayout);
        pnl_view_accountLayout.setHorizontalGroup(
            pnl_view_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_myAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_view_accountLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_view_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_view_nationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_view_phone_number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_view_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_view_ic_passport_number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_view_address)
                    .addComponent(btn_edit_account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_view_accountLayout.setVerticalGroup(
            pnl_view_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_view_accountLayout.createSequentialGroup()
                .addComponent(pnl_myAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(lbl_view_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbl_view_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbl_view_nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_view_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lbl_view_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btn_edit_account, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        pnl_edit_account.setBackground(new java.awt.Color(255, 255, 255));

        pnl_editAccount.setBackground(new java.awt.Color(136, 178, 219));

        lbl_editAccount.setBackground(new java.awt.Color(255, 255, 255));
        lbl_editAccount.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_editAccount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_editAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_editAccount.setText("Edit Account");

        javax.swing.GroupLayout pnl_editAccountLayout = new javax.swing.GroupLayout(pnl_editAccount);
        pnl_editAccount.setLayout(pnl_editAccountLayout);
        pnl_editAccountLayout.setHorizontalGroup(
            pnl_editAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_editAccountLayout.createSequentialGroup()
                .addContainerGap(280, Short.MAX_VALUE)
                .addComponent(lbl_editAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );
        pnl_editAccountLayout.setVerticalGroup(
            pnl_editAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_editAccountLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_editAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_edit_name.setBackground(new java.awt.Color(255, 255, 255));
        lbl_edit_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_edit_name.setText("Name");

        txt_edit_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_edit_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lbl_edit_phone_number.setBackground(new java.awt.Color(255, 255, 255));
        lbl_edit_phone_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_edit_phone_number.setText("Phone Number");

        txt_edit_phone_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_edit_phone_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lbl_edit_nationality.setBackground(new java.awt.Color(255, 255, 255));
        lbl_edit_nationality.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_edit_nationality.setText("Nationality");

        txt_edit_nationality.setEditable(false);
        txt_edit_nationality.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_edit_nationality.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lbl_edit_ic_passport_number.setBackground(new java.awt.Color(255, 255, 255));
        lbl_edit_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_edit_ic_passport_number.setText("IC / Passport Number");

        txt_edit_ic_passport_number.setEditable(false);
        txt_edit_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_edit_ic_passport_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lbl_edit_address.setBackground(new java.awt.Color(255, 255, 255));
        lbl_edit_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_edit_address.setText("Address");

        txt_edit_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_edit_address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lbl_edit_password.setBackground(new java.awt.Color(255, 255, 255));
        lbl_edit_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_edit_password.setText("Password");

        txt_edit_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_edit_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lbl_edit_confirm_password.setBackground(new java.awt.Color(255, 255, 255));
        lbl_edit_confirm_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_edit_confirm_password.setText("Confirm Password");

        txt_edit_confirm_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_edit_confirm_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        btn_save_edit.setBackground(new java.awt.Color(73, 161, 236));
        btn_save_edit.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_save_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_save_edit.setText("Save");
        btn_save_edit.setBorder(null);
        btn_save_edit.setOpaque(true);
        btn_save_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_save_editActionPerformed(evt);
            }
        });

        btn_cancel_edit.setBackground(new java.awt.Color(221, 98, 98));
        btn_cancel_edit.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_cancel_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancel_edit.setText("Cancel");
        btn_cancel_edit.setBorder(null);
        btn_cancel_edit.setOpaque(true);
        btn_cancel_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancel_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_edit_accountLayout = new javax.swing.GroupLayout(pnl_edit_account);
        pnl_edit_account.setLayout(pnl_edit_accountLayout);
        pnl_edit_accountLayout.setHorizontalGroup(
            pnl_edit_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_editAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_edit_accountLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_edit_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_edit_nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_edit_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_edit_name, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_edit_name)
                    .addComponent(lbl_edit_phone_number)
                    .addComponent(lbl_edit_nationality)
                    .addComponent(lbl_edit_ic_passport_number)
                    .addGroup(pnl_edit_accountLayout.createSequentialGroup()
                        .addComponent(btn_save_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btn_cancel_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_edit_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_edit_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_edit_confirm_password, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_edit_confirm_password))
                        .addComponent(txt_edit_ic_passport_number, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_edit_password, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_edit_address, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_edit_password)
                    .addComponent(lbl_edit_address))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_edit_accountLayout.setVerticalGroup(
            pnl_edit_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_edit_accountLayout.createSequentialGroup()
                .addComponent(pnl_editAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbl_edit_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_edit_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_edit_phone_number)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_edit_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_edit_nationality)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_edit_nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_edit_ic_passport_number)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_edit_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_edit_address)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_edit_address, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_edit_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_edit_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_edit_confirm_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_edit_confirm_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(pnl_edit_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_save_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnl_view_people.setBackground(new java.awt.Color(255, 255, 255));
        pnl_view_people.setPreferredSize(new java.awt.Dimension(960, 720));

        pnl_viewPeople.setBackground(new java.awt.Color(136, 178, 219));

        lbl_view_people.setBackground(new java.awt.Color(255, 255, 255));
        lbl_view_people.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_view_people.setForeground(new java.awt.Color(255, 255, 255));
        lbl_view_people.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_view_people.setText("Manage People");

        javax.swing.GroupLayout pnl_viewPeopleLayout = new javax.swing.GroupLayout(pnl_viewPeople);
        pnl_viewPeople.setLayout(pnl_viewPeopleLayout);
        pnl_viewPeopleLayout.setHorizontalGroup(
            pnl_viewPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_viewPeopleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_view_people, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_viewPeopleLayout.setVerticalGroup(
            pnl_viewPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_viewPeopleLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_view_people, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_search_people.setBackground(new java.awt.Color(255, 255, 255));
        lbl_search_people.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_search_people.setText("Search People");

        txt_search_people.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_search_people.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        txt_search_people.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search_peopleKeyReleased(evt);
            }
        });

        btn_people_register.setBackground(new java.awt.Color(73, 161, 236));
        btn_people_register.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_people_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_people_register.setText("Register People");
        btn_people_register.setBorder(null);
        btn_people_register.setOpaque(true);
        btn_people_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_people_registerActionPerformed(evt);
            }
        });

        btn_people_edit.setBackground(new java.awt.Color(73, 161, 236));
        btn_people_edit.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_people_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_people_edit.setText("Edit People");
        btn_people_edit.setBorder(null);
        btn_people_edit.setOpaque(true);
        btn_people_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_people_editActionPerformed(evt);
            }
        });

        tbl_view_people.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbl_view_people.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        )

        {public boolean isCellEditable(int row, int column){return false;}}

    );
    jScrollPane3.setViewportView(tbl_view_people);

    javax.swing.GroupLayout pnl_view_peopleLayout = new javax.swing.GroupLayout(pnl_view_people);
    pnl_view_people.setLayout(pnl_view_peopleLayout);
    pnl_view_peopleLayout.setHorizontalGroup(
        pnl_view_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_viewPeople, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_view_peopleLayout.createSequentialGroup()
            .addGap(40, 40, 40)
            .addGroup(pnl_view_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane3)
                .addGroup(pnl_view_peopleLayout.createSequentialGroup()
                    .addGroup(pnl_view_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_search_people)
                        .addComponent(lbl_search_people, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE))
                    .addGap(20, 20, 20)
                    .addGroup(pnl_view_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_people_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_people_register, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(40, 40, 40))
    );
    pnl_view_peopleLayout.setVerticalGroup(
        pnl_view_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_view_peopleLayout.createSequentialGroup()
            .addComponent(pnl_viewPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(16, 16, 16)
            .addGroup(pnl_view_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbl_search_people)
                .addComponent(btn_people_register, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnl_view_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_search_people, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_people_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(122, Short.MAX_VALUE))
    );

    pnl_register_people.setBackground(new java.awt.Color(255, 255, 255));

    pnl_registerPeople.setBackground(new java.awt.Color(136, 178, 219));

    lbl_registerPeople.setBackground(new java.awt.Color(255, 255, 255));
    lbl_registerPeople.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    lbl_registerPeople.setForeground(new java.awt.Color(255, 255, 255));
    lbl_registerPeople.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_registerPeople.setText("Register People");

    javax.swing.GroupLayout pnl_registerPeopleLayout = new javax.swing.GroupLayout(pnl_registerPeople);
    pnl_registerPeople.setLayout(pnl_registerPeopleLayout);
    pnl_registerPeopleLayout.setHorizontalGroup(
        pnl_registerPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_registerPeopleLayout.createSequentialGroup()
            .addContainerGap(280, Short.MAX_VALUE)
            .addComponent(lbl_registerPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(280, Short.MAX_VALUE))
    );
    pnl_registerPeopleLayout.setVerticalGroup(
        pnl_registerPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_registerPeopleLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lbl_registerPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    lbl_register_people_name.setBackground(new java.awt.Color(255, 255, 255));
    lbl_register_people_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_register_people_name.setText("Name");

    txt_register_people_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_register_people_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_register_people_phone_number.setBackground(new java.awt.Color(255, 255, 255));
    lbl_register_people_phone_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_register_people_phone_number.setText("Phone Number");

    txt_register_people_phone_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_register_people_phone_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_register_people_nationaliy.setBackground(new java.awt.Color(255, 255, 255));
    lbl_register_people_nationaliy.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_register_people_nationaliy.setText("Nationality");

    cbo_register_people_nationality.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

    lbl_register_people_ic_passport_number.setBackground(new java.awt.Color(255, 255, 255));
    lbl_register_people_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_register_people_ic_passport_number.setText("IC / Passport Number");

    txt_register_people_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_register_people_ic_passport_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_register_people_address.setBackground(new java.awt.Color(255, 255, 255));
    lbl_register_people_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_register_people_address.setText("Address");

    txt_register_people_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_register_people_address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_register_people_password.setBackground(new java.awt.Color(255, 255, 255));
    lbl_register_people_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_register_people_password.setText("Password");

    txt_register_people_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_register_people_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_register_people_confirm_password.setBackground(new java.awt.Color(255, 255, 255));
    lbl_register_people_confirm_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_register_people_confirm_password.setText("Confirm Password");

    txt_register_people_confirm_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_register_people_confirm_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    btn_register_people_register.setBackground(new java.awt.Color(73, 161, 236));
    btn_register_people_register.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_register_people_register.setForeground(new java.awt.Color(255, 255, 255));
    btn_register_people_register.setText("Register");
    btn_register_people_register.setBorder(null);
    btn_register_people_register.setOpaque(true);
    btn_register_people_register.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_register_people_registerActionPerformed(evt);
        }
    });

    btn_register_people_cancel.setBackground(new java.awt.Color(221, 98, 98));
    btn_register_people_cancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_register_people_cancel.setForeground(new java.awt.Color(255, 255, 255));
    btn_register_people_cancel.setText("Cancel");
    btn_register_people_cancel.setBorder(null);
    btn_register_people_cancel.setOpaque(true);
    btn_register_people_cancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_register_people_cancelActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pnl_register_peopleLayout = new javax.swing.GroupLayout(pnl_register_people);
    pnl_register_people.setLayout(pnl_register_peopleLayout);
    pnl_register_peopleLayout.setHorizontalGroup(
        pnl_register_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_registerPeople, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnl_register_peopleLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_register_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(cbo_register_people_nationality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_register_people_ic_passport_number)
                .addComponent(txt_register_people_confirm_password)
                .addComponent(lbl_register_people_password, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txt_register_people_password)
                .addComponent(lbl_register_people_confirm_password, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txt_register_people_address)
                .addComponent(txt_register_people_phone_number)
                .addComponent(txt_register_people_name)
                .addComponent(lbl_register_people_name, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_register_people_phone_number, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_register_people_nationaliy, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_register_people_ic_passport_number, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_register_people_address, javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_register_peopleLayout.createSequentialGroup()
                    .addComponent(btn_register_people_register, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(btn_register_people_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnl_register_peopleLayout.setVerticalGroup(
        pnl_register_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_register_peopleLayout.createSequentialGroup()
            .addComponent(pnl_registerPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(40, 40, 40)
            .addComponent(lbl_register_people_name)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_register_people_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_register_people_phone_number)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_register_people_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_register_people_nationaliy)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cbo_register_people_nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(11, 11, 11)
            .addComponent(lbl_register_people_ic_passport_number)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_register_people_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(11, 11, 11)
            .addComponent(lbl_register_people_address)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_register_people_address, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_register_people_password)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_register_people_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_register_people_confirm_password)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_register_people_confirm_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(60, 60, 60)
            .addGroup(pnl_register_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_register_people_register, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_register_people_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    pnl_edit_people.setBackground(new java.awt.Color(255, 255, 255));
    pnl_edit_people.setName(""); // NOI18N

    pnl_editPeople.setBackground(new java.awt.Color(136, 178, 219));

    lbl_editPeople.setBackground(new java.awt.Color(255, 255, 255));
    lbl_editPeople.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    lbl_editPeople.setForeground(new java.awt.Color(255, 255, 255));
    lbl_editPeople.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_editPeople.setText("Edit People");

    javax.swing.GroupLayout pnl_editPeopleLayout = new javax.swing.GroupLayout(pnl_editPeople);
    pnl_editPeople.setLayout(pnl_editPeopleLayout);
    pnl_editPeopleLayout.setHorizontalGroup(
        pnl_editPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_editPeopleLayout.createSequentialGroup()
            .addContainerGap(280, Short.MAX_VALUE)
            .addComponent(lbl_editPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(280, Short.MAX_VALUE))
    );
    pnl_editPeopleLayout.setVerticalGroup(
        pnl_editPeopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_editPeopleLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lbl_editPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    lbl_edit_people_name.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_people_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_people_name.setText("Name");

    txt_edit_people_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_edit_people_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_edit_people__phone_number.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_people__phone_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_people__phone_number.setText("Phone Number");

    txt_edit_people_phone_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_edit_people_phone_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_edit_people_nationaliy.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_people_nationaliy.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_people_nationaliy.setText("Nationality");

    cbo_edit_people_nationality.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

    lbl_edit_people_ic_passport_number.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_people_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_people_ic_passport_number.setText("IC / Passport Number");

    txt_edit_people_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_edit_people_ic_passport_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_edit_people_address.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_people_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_people_address.setText("Address");

    txt_edit_people_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_edit_people_address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_edit_people_password.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_people_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_people_password.setText("Password");

    txt_edit_people_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_edit_people_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_edit_people_confirm_password.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_people_confirm_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_people_confirm_password.setText("Confirm Password");

    txt_edit_people_confirm_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_edit_people_confirm_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    btn_edit_people_save.setBackground(new java.awt.Color(73, 161, 236));
    btn_edit_people_save.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_edit_people_save.setForeground(new java.awt.Color(255, 255, 255));
    btn_edit_people_save.setText("Save");
    btn_edit_people_save.setBorder(null);
    btn_edit_people_save.setOpaque(true);
    btn_edit_people_save.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_edit_people_saveActionPerformed(evt);
        }
    });

    btn_edit_people_cancel.setBackground(new java.awt.Color(221, 98, 98));
    btn_edit_people_cancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_edit_people_cancel.setForeground(new java.awt.Color(255, 255, 255));
    btn_edit_people_cancel.setText("Cancel");
    btn_edit_people_cancel.setBorder(null);
    btn_edit_people_cancel.setOpaque(true);
    btn_edit_people_cancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_edit_people_cancelActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pnl_edit_peopleLayout = new javax.swing.GroupLayout(pnl_edit_people);
    pnl_edit_people.setLayout(pnl_edit_peopleLayout);
    pnl_edit_peopleLayout.setHorizontalGroup(
        pnl_edit_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_editPeople, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnl_edit_peopleLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_edit_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(cbo_edit_people_nationality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_edit_peopleLayout.createSequentialGroup()
                    .addComponent(btn_edit_people_save, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(btn_edit_people_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(txt_edit_people_address)
                .addComponent(txt_edit_people_phone_number)
                .addComponent(txt_edit_people_name)
                .addComponent(lbl_edit_people_name, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_edit_people__phone_number, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_edit_people_nationaliy, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_edit_people_ic_passport_number, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_edit_people_address, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txt_edit_people_confirm_password)
                .addComponent(lbl_edit_people_password, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txt_edit_people_password)
                .addComponent(lbl_edit_people_confirm_password, javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txt_edit_people_ic_passport_number))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnl_edit_peopleLayout.setVerticalGroup(
        pnl_edit_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_edit_peopleLayout.createSequentialGroup()
            .addComponent(pnl_editPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(30, 30, 30)
            .addComponent(lbl_edit_people_name)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_people_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_edit_people__phone_number)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_people_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_edit_people_nationaliy)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(cbo_edit_people_nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lbl_edit_people_ic_passport_number)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_people_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(11, 11, 11)
            .addComponent(lbl_edit_people_address)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_people_address, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_edit_people_password)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_people_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_edit_people_confirm_password)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_people_confirm_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(pnl_edit_peopleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_edit_people_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_edit_people_save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    pnl_view_vaccination_appointments.setBackground(new java.awt.Color(255, 255, 255));
    pnl_view_vaccination_appointments.setPreferredSize(new java.awt.Dimension(960, 720));

    pnl_viewVaccinationAppointments.setBackground(new java.awt.Color(136, 178, 219));

    lbl_view_vaccination_appointments.setBackground(new java.awt.Color(255, 255, 255));
    lbl_view_vaccination_appointments.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    lbl_view_vaccination_appointments.setForeground(new java.awt.Color(255, 255, 255));
    lbl_view_vaccination_appointments.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_view_vaccination_appointments.setText("Manage Vaccination Appointment");

    javax.swing.GroupLayout pnl_viewVaccinationAppointmentsLayout = new javax.swing.GroupLayout(pnl_viewVaccinationAppointments);
    pnl_viewVaccinationAppointments.setLayout(pnl_viewVaccinationAppointmentsLayout);
    pnl_viewVaccinationAppointmentsLayout.setHorizontalGroup(
        pnl_viewVaccinationAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_viewVaccinationAppointmentsLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_view_vaccination_appointments, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnl_viewVaccinationAppointmentsLayout.setVerticalGroup(
        pnl_viewVaccinationAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_viewVaccinationAppointmentsLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lbl_view_vaccination_appointments, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    lbl_search_vaccination_appointments.setBackground(new java.awt.Color(255, 255, 255));
    lbl_search_vaccination_appointments.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_search_vaccination_appointments.setText("Search Vaccination Appointment");

    txt_search_vaccination_appointments.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_search_vaccination_appointments.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
    txt_search_vaccination_appointments.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_search_vaccination_appointmentsKeyReleased(evt);
        }
    });

    btn_vaccination_appointments_register.setBackground(new java.awt.Color(73, 161, 236));
    btn_vaccination_appointments_register.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_vaccination_appointments_register.setForeground(new java.awt.Color(255, 255, 255));
    btn_vaccination_appointments_register.setText("Register Appointment");
    btn_vaccination_appointments_register.setBorder(null);
    btn_vaccination_appointments_register.setMaximumSize(new java.awt.Dimension(125, 19));
    btn_vaccination_appointments_register.setMinimumSize(new java.awt.Dimension(125, 19));
    btn_vaccination_appointments_register.setOpaque(true);
    btn_vaccination_appointments_register.setPreferredSize(new java.awt.Dimension(200, 19));
    btn_vaccination_appointments_register.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_vaccination_appointments_registerActionPerformed(evt);
        }
    });

    btn_vaccination_appointments_edit.setBackground(new java.awt.Color(73, 161, 236));
    btn_vaccination_appointments_edit.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_vaccination_appointments_edit.setForeground(new java.awt.Color(255, 255, 255));
    btn_vaccination_appointments_edit.setText("Edit Appointment");
    btn_vaccination_appointments_edit.setBorder(null);
    btn_vaccination_appointments_edit.setMaximumSize(new java.awt.Dimension(125, 19));
    btn_vaccination_appointments_edit.setMinimumSize(new java.awt.Dimension(125, 19));
    btn_vaccination_appointments_edit.setOpaque(true);
    btn_vaccination_appointments_edit.setPreferredSize(new java.awt.Dimension(200, 19));
    btn_vaccination_appointments_edit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_vaccination_appointments_editActionPerformed(evt);
        }
    });

    btn_vaccination_appointments_update.setBackground(new java.awt.Color(73, 161, 236));
    btn_vaccination_appointments_update.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_vaccination_appointments_update.setForeground(new java.awt.Color(255, 255, 255));
    btn_vaccination_appointments_update.setText("Update Appointment");
    btn_vaccination_appointments_update.setBorder(null);
    btn_vaccination_appointments_update.setMaximumSize(new java.awt.Dimension(125, 19));
    btn_vaccination_appointments_update.setMinimumSize(new java.awt.Dimension(125, 19));
    btn_vaccination_appointments_update.setOpaque(true);
    btn_vaccination_appointments_update.setPreferredSize(new java.awt.Dimension(200, 19));
    btn_vaccination_appointments_update.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_vaccination_appointments_updateActionPerformed(evt);
        }
    });

    btn_vaccination_appointments_remove.setBackground(new java.awt.Color(221, 98, 98));
    btn_vaccination_appointments_remove.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_vaccination_appointments_remove.setForeground(new java.awt.Color(255, 255, 255));
    btn_vaccination_appointments_remove.setText("Remove Appointment");
    btn_vaccination_appointments_remove.setBorder(null);
    btn_vaccination_appointments_remove.setOpaque(true);
    btn_vaccination_appointments_remove.setPreferredSize(new java.awt.Dimension(200, 19));
    btn_vaccination_appointments_remove.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_vaccination_appointments_removeActionPerformed(evt);
        }
    });

    jScrollPane1.setBorder(null);

    tbl_view_vaccination_appointments.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    tbl_view_vaccination_appointments.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    )

    {public boolean isCellEditable(int row, int column){return false;}}

    );
    jScrollPane1.setViewportView(tbl_view_vaccination_appointments);

    javax.swing.GroupLayout pnl_view_vaccination_appointmentsLayout = new javax.swing.GroupLayout(pnl_view_vaccination_appointments);
    pnl_view_vaccination_appointments.setLayout(pnl_view_vaccination_appointmentsLayout);
    pnl_view_vaccination_appointmentsLayout.setHorizontalGroup(
        pnl_view_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_viewVaccinationAppointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnl_view_vaccination_appointmentsLayout.createSequentialGroup()
            .addGap(47, 47, 47)
            .addGroup(pnl_view_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(lbl_search_vaccination_appointments, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_view_vaccination_appointmentsLayout.createSequentialGroup()
                    .addGroup(pnl_view_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_search_vaccination_appointments)
                        .addGroup(pnl_view_vaccination_appointmentsLayout.createSequentialGroup()
                            .addComponent(btn_vaccination_appointments_register, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_vaccination_appointments_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_vaccination_appointments_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_vaccination_appointments_remove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 9, Short.MAX_VALUE)))
                    .addGap(2, 2, 2)))
            .addGap(48, 48, 48))
    );
    pnl_view_vaccination_appointmentsLayout.setVerticalGroup(
        pnl_view_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_view_vaccination_appointmentsLayout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addComponent(pnl_viewVaccinationAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27)
            .addComponent(lbl_search_vaccination_appointments)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_search_vaccination_appointments, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(pnl_view_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_vaccination_appointments_register, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_vaccination_appointments_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_vaccination_appointments_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_vaccination_appointments_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    pnl_register_vaccination_appointments.setBackground(new java.awt.Color(255, 255, 255));
    pnl_register_vaccination_appointments.setMinimumSize(new java.awt.Dimension(274, 0));

    pnl_registerVaccinationAppointments.setBackground(new java.awt.Color(136, 178, 219));

    lbl_registerVaccinationAppointments.setBackground(new java.awt.Color(255, 255, 255));
    lbl_registerVaccinationAppointments.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    lbl_registerVaccinationAppointments.setForeground(new java.awt.Color(255, 255, 255));
    lbl_registerVaccinationAppointments.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_registerVaccinationAppointments.setText("Register Vaccination Appointment");
    lbl_registerVaccinationAppointments.setMaximumSize(new java.awt.Dimension(440, 26));
    lbl_registerVaccinationAppointments.setMinimumSize(new java.awt.Dimension(440, 26));
    lbl_registerVaccinationAppointments.setPreferredSize(new java.awt.Dimension(440, 26));

    javax.swing.GroupLayout pnl_registerVaccinationAppointmentsLayout = new javax.swing.GroupLayout(pnl_registerVaccinationAppointments);
    pnl_registerVaccinationAppointments.setLayout(pnl_registerVaccinationAppointmentsLayout);
    pnl_registerVaccinationAppointmentsLayout.setHorizontalGroup(
        pnl_registerVaccinationAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_registerVaccinationAppointmentsLayout.createSequentialGroup()
            .addContainerGap(230, Short.MAX_VALUE)
            .addComponent(lbl_registerVaccinationAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(230, Short.MAX_VALUE))
    );
    pnl_registerVaccinationAppointmentsLayout.setVerticalGroup(
        pnl_registerVaccinationAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_registerVaccinationAppointmentsLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lbl_registerVaccinationAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    lbl_register_vaccination_appointments_ic_passport_number.setBackground(new java.awt.Color(255, 255, 255));
    lbl_register_vaccination_appointments_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_register_vaccination_appointments_ic_passport_number.setText("Search by IC / Passport Number");

    txt_register_vaccination_appointments_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_register_vaccination_appointments_ic_passport_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_register_vaccination_appointments_select_date.setBackground(new java.awt.Color(255, 255, 255));
    lbl_register_vaccination_appointments_select_date.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_register_vaccination_appointments_select_date.setText("Select Date");

    txt_register_vaccination_appointments_select_date.setBackground(new java.awt.Color(255, 255, 255));
    txt_register_vaccination_appointments_select_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
    txt_register_vaccination_appointments_select_date.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            txt_register_vaccination_appointments_select_datePropertyChange(evt);
        }
    });

    lbl_register_vaccination_appointments_select_time.setBackground(new java.awt.Color(255, 255, 255));
    lbl_register_vaccination_appointments_select_time.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_register_vaccination_appointments_select_time.setText("Select Time");

    cbo_register_vaccination_appointments_select_time.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    cbo_register_vaccination_appointments_select_time.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Time", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM" }));

    lbl_register_vaccination_appointments_select_vaccination_center.setBackground(new java.awt.Color(255, 255, 255));
    lbl_register_vaccination_appointments_select_vaccination_center.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_register_vaccination_appointments_select_vaccination_center.setText("Select Vaccination Center");

    cbo_register_vaccination_appointments_select_vaccination_center.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    cbo_register_vaccination_appointments_select_vaccination_center.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Vaccination Center" }));
    cbo_register_vaccination_appointments_select_vaccination_center.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbo_register_vaccination_appointments_select_vaccination_centerActionPerformed(evt);
        }
    });

    lbl_registerVaccinationAppointmentsVaccineType.setBackground(new java.awt.Color(255, 255, 255));
    lbl_registerVaccinationAppointmentsVaccineType.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_registerVaccinationAppointmentsVaccineType.setText("Vaccine Type");

    lbl_register_vaccination_appointments_vaccine_type.setBackground(new java.awt.Color(255, 255, 255));
    lbl_register_vaccination_appointments_vaccine_type.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_register_vaccination_appointments_vaccine_type.setForeground(new java.awt.Color(119, 119, 119));

    btn_register_vaccination_appointments_register.setBackground(new java.awt.Color(73, 161, 236));
    btn_register_vaccination_appointments_register.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_register_vaccination_appointments_register.setForeground(new java.awt.Color(255, 255, 255));
    btn_register_vaccination_appointments_register.setText("Register");
    btn_register_vaccination_appointments_register.setBorder(null);
    btn_register_vaccination_appointments_register.setOpaque(true);
    btn_register_vaccination_appointments_register.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_register_vaccination_appointments_registerActionPerformed(evt);
        }
    });

    btn_register_vaccination_appointments_cancel.setBackground(new java.awt.Color(221, 98, 98));
    btn_register_vaccination_appointments_cancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_register_vaccination_appointments_cancel.setForeground(new java.awt.Color(255, 255, 255));
    btn_register_vaccination_appointments_cancel.setText("Cancel");
    btn_register_vaccination_appointments_cancel.setBorder(null);
    btn_register_vaccination_appointments_cancel.setOpaque(true);
    btn_register_vaccination_appointments_cancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_register_vaccination_appointments_cancelActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pnl_register_vaccination_appointmentsLayout = new javax.swing.GroupLayout(pnl_register_vaccination_appointments);
    pnl_register_vaccination_appointments.setLayout(pnl_register_vaccination_appointmentsLayout);
    pnl_register_vaccination_appointmentsLayout.setHorizontalGroup(
        pnl_register_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_registerVaccinationAppointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnl_register_vaccination_appointmentsLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_register_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(lbl_register_vaccination_appointments_select_time, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbo_register_vaccination_appointments_select_time, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_register_vaccination_appointments_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_register_vaccination_appointments_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_register_vaccination_appointments_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_register_vaccination_appointments_select_date, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_register_vaccination_appointments_select_date, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_register_vaccination_appointments_select_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbo_register_vaccination_appointments_select_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_registerVaccinationAppointmentsVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_register_vaccination_appointmentsLayout.createSequentialGroup()
                    .addComponent(btn_register_vaccination_appointments_register, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(btn_register_vaccination_appointments_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnl_register_vaccination_appointmentsLayout.setVerticalGroup(
        pnl_register_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_register_vaccination_appointmentsLayout.createSequentialGroup()
            .addComponent(pnl_registerVaccinationAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27)
            .addComponent(lbl_register_vaccination_appointments_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_register_vaccination_appointments_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(lbl_register_vaccination_appointments_select_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_register_vaccination_appointments_select_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(lbl_register_vaccination_appointments_select_time, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cbo_register_vaccination_appointments_select_time, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(lbl_register_vaccination_appointments_select_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cbo_register_vaccination_appointments_select_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(lbl_registerVaccinationAppointmentsVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lbl_register_vaccination_appointments_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(43, 43, 43)
            .addGroup(pnl_register_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_register_vaccination_appointments_register, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_register_vaccination_appointments_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(14, 14, 14))
    );

    pnl_edit_vaccination_appointments.setBackground(new java.awt.Color(255, 255, 255));
    pnl_edit_vaccination_appointments.setMinimumSize(new java.awt.Dimension(274, 0));

    pnl_editVaccinationAppointments.setBackground(new java.awt.Color(136, 178, 219));

    lbl_registerVaccinationAppointments1.setBackground(new java.awt.Color(255, 255, 255));
    lbl_registerVaccinationAppointments1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    lbl_registerVaccinationAppointments1.setForeground(new java.awt.Color(255, 255, 255));
    lbl_registerVaccinationAppointments1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_registerVaccinationAppointments1.setText("Edit Vaccination Appointment");
    lbl_registerVaccinationAppointments1.setMaximumSize(new java.awt.Dimension(440, 26));
    lbl_registerVaccinationAppointments1.setMinimumSize(new java.awt.Dimension(440, 26));
    lbl_registerVaccinationAppointments1.setPreferredSize(new java.awt.Dimension(440, 26));

    javax.swing.GroupLayout pnl_editVaccinationAppointmentsLayout = new javax.swing.GroupLayout(pnl_editVaccinationAppointments);
    pnl_editVaccinationAppointments.setLayout(pnl_editVaccinationAppointmentsLayout);
    pnl_editVaccinationAppointmentsLayout.setHorizontalGroup(
        pnl_editVaccinationAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_editVaccinationAppointmentsLayout.createSequentialGroup()
            .addContainerGap(260, Short.MAX_VALUE)
            .addComponent(lbl_registerVaccinationAppointments1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(260, Short.MAX_VALUE))
    );
    pnl_editVaccinationAppointmentsLayout.setVerticalGroup(
        pnl_editVaccinationAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_editVaccinationAppointmentsLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lbl_registerVaccinationAppointments1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    lbl_edit_vaccination_appointments_ic_passport_number.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccination_appointments_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_vaccination_appointments_ic_passport_number.setText("Search by IC / Passport Number");

    txt_edit_vaccination_appointments_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_edit_vaccination_appointments_ic_passport_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_edit_vaccination_appointments_select_date.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccination_appointments_select_date.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_vaccination_appointments_select_date.setText("Select Date");

    txt_edit_vaccination_appointments_select_date.setBackground(new java.awt.Color(255, 255, 255));
    txt_edit_vaccination_appointments_select_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
    txt_edit_vaccination_appointments_select_date.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            txt_edit_vaccination_appointments_select_datePropertyChange(evt);
        }
    });

    lbl_edit_vaccination_appointments_select_time.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccination_appointments_select_time.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_vaccination_appointments_select_time.setText("Select Time");

    cbo_edit_vaccination_appointments_select_time.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    cbo_edit_vaccination_appointments_select_time.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Time", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM" }));

    lbl_edit_vaccination_appointments_select_vaccination_center.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccination_appointments_select_vaccination_center.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_vaccination_appointments_select_vaccination_center.setText("Select Vaccination Center");

    cbo_edit_vaccination_appointments_select_vaccination_center.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    cbo_edit_vaccination_appointments_select_vaccination_center.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Vaccination Center" }));
    cbo_edit_vaccination_appointments_select_vaccination_center.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbo_edit_vaccination_appointments_select_vaccination_centerActionPerformed(evt);
        }
    });

    lbl_editVaccinationAppointmentsVaccineType.setBackground(new java.awt.Color(255, 255, 255));
    lbl_editVaccinationAppointmentsVaccineType.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_editVaccinationAppointmentsVaccineType.setText("Vaccine Type");

    lbl_edit_vaccination_appointments_vaccine_type.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccination_appointments_vaccine_type.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_vaccination_appointments_vaccine_type.setForeground(new java.awt.Color(119, 119, 119));

    btn_edit_vaccination_appointments_save.setBackground(new java.awt.Color(73, 161, 236));
    btn_edit_vaccination_appointments_save.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_edit_vaccination_appointments_save.setForeground(new java.awt.Color(255, 255, 255));
    btn_edit_vaccination_appointments_save.setText("Save");
    btn_edit_vaccination_appointments_save.setBorder(null);
    btn_edit_vaccination_appointments_save.setOpaque(true);
    btn_edit_vaccination_appointments_save.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_edit_vaccination_appointments_saveActionPerformed(evt);
        }
    });

    btn_edit_vaccination_appointments_cancel.setBackground(new java.awt.Color(221, 98, 98));
    btn_edit_vaccination_appointments_cancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_edit_vaccination_appointments_cancel.setForeground(new java.awt.Color(255, 255, 255));
    btn_edit_vaccination_appointments_cancel.setText("Cancel");
    btn_edit_vaccination_appointments_cancel.setBorder(null);
    btn_edit_vaccination_appointments_cancel.setOpaque(true);
    btn_edit_vaccination_appointments_cancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_edit_vaccination_appointments_cancelActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pnl_edit_vaccination_appointmentsLayout = new javax.swing.GroupLayout(pnl_edit_vaccination_appointments);
    pnl_edit_vaccination_appointments.setLayout(pnl_edit_vaccination_appointmentsLayout);
    pnl_edit_vaccination_appointmentsLayout.setHorizontalGroup(
        pnl_edit_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_editVaccinationAppointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnl_edit_vaccination_appointmentsLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_edit_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_edit_vaccination_appointments_select_time, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbo_edit_vaccination_appointments_select_time, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_edit_vaccination_appointments_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_edit_vaccination_appointmentsLayout.createSequentialGroup()
                    .addComponent(btn_edit_vaccination_appointments_save, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(btn_edit_vaccination_appointments_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(txt_edit_vaccination_appointments_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_edit_vaccination_appointments_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_edit_vaccination_appointments_select_date, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_edit_vaccination_appointments_select_date, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_edit_vaccination_appointments_select_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbo_edit_vaccination_appointments_select_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_editVaccinationAppointmentsVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnl_edit_vaccination_appointmentsLayout.setVerticalGroup(
        pnl_edit_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_edit_vaccination_appointmentsLayout.createSequentialGroup()
            .addComponent(pnl_editVaccinationAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27)
            .addComponent(lbl_edit_vaccination_appointments_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_vaccination_appointments_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(lbl_edit_vaccination_appointments_select_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_vaccination_appointments_select_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(lbl_edit_vaccination_appointments_select_time, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cbo_edit_vaccination_appointments_select_time, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(lbl_edit_vaccination_appointments_select_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cbo_edit_vaccination_appointments_select_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(lbl_editVaccinationAppointmentsVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lbl_edit_vaccination_appointments_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(43, 43, 43)
            .addGroup(pnl_edit_vaccination_appointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_edit_vaccination_appointments_save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_edit_vaccination_appointments_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );

    pnl_view_vaccination_center.setBackground(new java.awt.Color(255, 255, 255));
    pnl_view_vaccination_center.setPreferredSize(new java.awt.Dimension(960, 720));

    pnl_viewVaccinationCenter.setBackground(new java.awt.Color(136, 178, 219));

    lbl_view_vaccination_center.setBackground(new java.awt.Color(255, 255, 255));
    lbl_view_vaccination_center.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    lbl_view_vaccination_center.setForeground(new java.awt.Color(255, 255, 255));
    lbl_view_vaccination_center.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_view_vaccination_center.setText("Manage Vaccination Center");

    javax.swing.GroupLayout pnl_viewVaccinationCenterLayout = new javax.swing.GroupLayout(pnl_viewVaccinationCenter);
    pnl_viewVaccinationCenter.setLayout(pnl_viewVaccinationCenterLayout);
    pnl_viewVaccinationCenterLayout.setHorizontalGroup(
        pnl_viewVaccinationCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_viewVaccinationCenterLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_view_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnl_viewVaccinationCenterLayout.setVerticalGroup(
        pnl_viewVaccinationCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_viewVaccinationCenterLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lbl_view_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    lbl_search_vaccination_center.setBackground(new java.awt.Color(255, 255, 255));
    lbl_search_vaccination_center.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_search_vaccination_center.setText("Search Vaccination Center");

    txt_search_vaccination_center.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_search_vaccination_center.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
    txt_search_vaccination_center.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_search_vaccination_centerKeyReleased(evt);
        }
    });

    btn_vaccination_center_add.setBackground(new java.awt.Color(73, 161, 236));
    btn_vaccination_center_add.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_vaccination_center_add.setForeground(new java.awt.Color(255, 255, 255));
    btn_vaccination_center_add.setText("Add Center");
    btn_vaccination_center_add.setBorder(null);
    btn_vaccination_center_add.setMaximumSize(new java.awt.Dimension(125, 19));
    btn_vaccination_center_add.setMinimumSize(new java.awt.Dimension(125, 19));
    btn_vaccination_center_add.setOpaque(true);
    btn_vaccination_center_add.setPreferredSize(new java.awt.Dimension(200, 19));
    btn_vaccination_center_add.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_vaccination_center_addActionPerformed(evt);
        }
    });

    btn_vaccination_center_edit.setBackground(new java.awt.Color(73, 161, 236));
    btn_vaccination_center_edit.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_vaccination_center_edit.setForeground(new java.awt.Color(255, 255, 255));
    btn_vaccination_center_edit.setText("Edit Center");
    btn_vaccination_center_edit.setBorder(null);
    btn_vaccination_center_edit.setMaximumSize(new java.awt.Dimension(125, 19));
    btn_vaccination_center_edit.setMinimumSize(new java.awt.Dimension(125, 19));
    btn_vaccination_center_edit.setOpaque(true);
    btn_vaccination_center_edit.setPreferredSize(new java.awt.Dimension(200, 19));
    btn_vaccination_center_edit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_vaccination_center_editActionPerformed(evt);
        }
    });

    btn_vaccination_center_remove.setBackground(new java.awt.Color(221, 98, 98));
    btn_vaccination_center_remove.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_vaccination_center_remove.setForeground(new java.awt.Color(255, 255, 255));
    btn_vaccination_center_remove.setText("Remove Center");
    btn_vaccination_center_remove.setBorder(null);
    btn_vaccination_center_remove.setMaximumSize(new java.awt.Dimension(125, 19));
    btn_vaccination_center_remove.setOpaque(true);
    btn_vaccination_center_remove.setPreferredSize(new java.awt.Dimension(200, 19));
    btn_vaccination_center_remove.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_vaccination_center_removeActionPerformed(evt);
        }
    });

    tbl_view_vaccination_center.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    tbl_view_vaccination_center.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    )
    {public boolean isCellEditable(int row, int column){return false;}}
    );
    scrpnl_view_vaccination_center.setViewportView(tbl_view_vaccination_center);

    javax.swing.GroupLayout pnl_view_vaccination_centerLayout = new javax.swing.GroupLayout(pnl_view_vaccination_center);
    pnl_view_vaccination_center.setLayout(pnl_view_vaccination_centerLayout);
    pnl_view_vaccination_centerLayout.setHorizontalGroup(
        pnl_view_vaccination_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_viewVaccinationCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnl_view_vaccination_centerLayout.createSequentialGroup()
            .addGap(47, 47, 47)
            .addGroup(pnl_view_vaccination_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(lbl_search_vaccination_center, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_view_vaccination_centerLayout.createSequentialGroup()
                    .addGroup(pnl_view_vaccination_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_search_vaccination_center)
                        .addGroup(pnl_view_vaccination_centerLayout.createSequentialGroup()
                            .addComponent(btn_vaccination_center_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_vaccination_center_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_vaccination_center_remove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 227, Short.MAX_VALUE))
                        .addComponent(scrpnl_view_vaccination_center, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGap(2, 2, 2)))
            .addGap(48, 48, 48))
    );
    pnl_view_vaccination_centerLayout.setVerticalGroup(
        pnl_view_vaccination_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_view_vaccination_centerLayout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addComponent(pnl_viewVaccinationCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27)
            .addComponent(lbl_search_vaccination_center)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_search_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(pnl_view_vaccination_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_vaccination_center_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_vaccination_center_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_vaccination_center_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(scrpnl_view_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(22, Short.MAX_VALUE))
    );

    pnl_add_center.setBackground(new java.awt.Color(255, 255, 255));

    pnl_addCenter.setBackground(new java.awt.Color(136, 178, 219));

    lbl_add_center.setBackground(new java.awt.Color(255, 255, 255));
    lbl_add_center.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    lbl_add_center.setForeground(new java.awt.Color(255, 255, 255));
    lbl_add_center.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_add_center.setText("Add Center");

    javax.swing.GroupLayout pnl_addCenterLayout = new javax.swing.GroupLayout(pnl_addCenter);
    pnl_addCenter.setLayout(pnl_addCenterLayout);
    pnl_addCenterLayout.setHorizontalGroup(
        pnl_addCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_addCenterLayout.createSequentialGroup()
            .addContainerGap(280, Short.MAX_VALUE)
            .addComponent(lbl_add_center, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(280, Short.MAX_VALUE))
    );
    pnl_addCenterLayout.setVerticalGroup(
        pnl_addCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_addCenterLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lbl_add_center, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    lbl_add_center_name.setBackground(new java.awt.Color(255, 255, 255));
    lbl_add_center_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_add_center_name.setText("Name");

    txt_add_center_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_add_center_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_add_center_address.setBackground(new java.awt.Color(255, 255, 255));
    lbl_add_center_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_add_center_address.setText("Address");

    txt_add_center_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_add_center_address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_add_center_contact_number.setBackground(new java.awt.Color(255, 255, 255));
    lbl_add_center_contact_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_add_center_contact_number.setText("Contact Number");

    txt_add_center_contact_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_add_center_contact_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    btn_add_center_add.setBackground(new java.awt.Color(73, 161, 236));
    btn_add_center_add.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_add_center_add.setForeground(new java.awt.Color(255, 255, 255));
    btn_add_center_add.setText("Add");
    btn_add_center_add.setBorder(null);
    btn_add_center_add.setOpaque(true);
    btn_add_center_add.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_add_center_addActionPerformed(evt);
        }
    });

    btn_add_center_cancel.setBackground(new java.awt.Color(221, 98, 98));
    btn_add_center_cancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_add_center_cancel.setForeground(new java.awt.Color(255, 255, 255));
    btn_add_center_cancel.setText("Cancel");
    btn_add_center_cancel.setBorder(null);
    btn_add_center_cancel.setOpaque(true);
    btn_add_center_cancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_add_center_cancelActionPerformed(evt);
        }
    });

    cbo_add_center_vaccine_type.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    cbo_add_center_vaccine_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sinovac", "Pfizer", "AstraZeneca" }));

    lbl_add_center_vaccine_type.setBackground(new java.awt.Color(255, 255, 255));
    lbl_add_center_vaccine_type.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_add_center_vaccine_type.setText("Vaccine Type");

    javax.swing.GroupLayout pnl_add_centerLayout = new javax.swing.GroupLayout(pnl_add_center);
    pnl_add_center.setLayout(pnl_add_centerLayout);
    pnl_add_centerLayout.setHorizontalGroup(
        pnl_add_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_addCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnl_add_centerLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_add_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(cbo_add_center_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_add_center_vaccine_type)
                .addComponent(txt_add_center_contact_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_add_center_address, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_add_center_name, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_add_center_name)
                .addComponent(lbl_add_center_address)
                .addComponent(lbl_add_center_contact_number)
                .addGroup(pnl_add_centerLayout.createSequentialGroup()
                    .addComponent(btn_add_center_add, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(btn_add_center_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnl_add_centerLayout.setVerticalGroup(
        pnl_add_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_add_centerLayout.createSequentialGroup()
            .addComponent(pnl_addCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(40, 40, 40)
            .addComponent(lbl_add_center_name)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_add_center_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_add_center_address)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_add_center_address, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_add_center_contact_number)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txt_add_center_contact_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_add_center_vaccine_type)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cbo_add_center_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(21, 21, 21)
            .addGroup(pnl_add_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_add_center_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_add_center_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(19, 19, 19))
    );

    pnl_edit_center.setBackground(new java.awt.Color(255, 255, 255));

    pnl_editCenter.setBackground(new java.awt.Color(136, 178, 219));

    lbl_edit_center.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_center.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    lbl_edit_center.setForeground(new java.awt.Color(255, 255, 255));
    lbl_edit_center.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_edit_center.setText("Edit Center");

    javax.swing.GroupLayout pnl_editCenterLayout = new javax.swing.GroupLayout(pnl_editCenter);
    pnl_editCenter.setLayout(pnl_editCenterLayout);
    pnl_editCenterLayout.setHorizontalGroup(
        pnl_editCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_editCenterLayout.createSequentialGroup()
            .addContainerGap(280, Short.MAX_VALUE)
            .addComponent(lbl_edit_center, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(280, Short.MAX_VALUE))
    );
    pnl_editCenterLayout.setVerticalGroup(
        pnl_editCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_editCenterLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lbl_edit_center, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    lbl_editCenterId.setBackground(new java.awt.Color(255, 255, 255));
    lbl_editCenterId.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_editCenterId.setText("Center ID");

    lbl_edit_center_id.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_center_id.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_center_id.setForeground(new java.awt.Color(119, 119, 119));

    lbl_edit_center_name.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_center_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_center_name.setText("Name");

    txt_edit_center_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_edit_center_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_edit_center_address.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_center_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_center_address.setText("Address");

    txt_edit_center_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_edit_center_address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_edit_center_contact_number.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_center_contact_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_center_contact_number.setText("Contact Number");

    txt_edit_center_contact_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_edit_center_contact_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    btn_edit_center_save.setBackground(new java.awt.Color(73, 161, 236));
    btn_edit_center_save.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_edit_center_save.setForeground(new java.awt.Color(255, 255, 255));
    btn_edit_center_save.setText("Save");
    btn_edit_center_save.setBorder(null);
    btn_edit_center_save.setOpaque(true);
    btn_edit_center_save.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_edit_center_saveActionPerformed(evt);
        }
    });

    btn_edit_center_cancel.setBackground(new java.awt.Color(221, 98, 98));
    btn_edit_center_cancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_edit_center_cancel.setForeground(new java.awt.Color(255, 255, 255));
    btn_edit_center_cancel.setText("Cancel");
    btn_edit_center_cancel.setBorder(null);
    btn_edit_center_cancel.setOpaque(true);
    btn_edit_center_cancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_edit_center_cancelActionPerformed(evt);
        }
    });

    lbl_edit_center_vaccine_type.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_center_vaccine_type.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_center_vaccine_type.setForeground(new java.awt.Color(119, 119, 119));

    lbl_edit_center_vaccine_type_title.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_center_vaccine_type_title.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_center_vaccine_type_title.setText("Vaccine Type");

    javax.swing.GroupLayout pnl_edit_centerLayout = new javax.swing.GroupLayout(pnl_edit_center);
    pnl_edit_center.setLayout(pnl_edit_centerLayout);
    pnl_edit_centerLayout.setHorizontalGroup(
        pnl_edit_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_editCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnl_edit_centerLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_edit_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(pnl_edit_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_edit_center_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_edit_center_vaccine_type_title))
                .addGroup(pnl_edit_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_edit_center_contact_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_edit_center_id, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_edit_center_address, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_edit_center_name, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_editCenterId)
                    .addComponent(lbl_edit_center_name)
                    .addComponent(lbl_edit_center_address)
                    .addComponent(lbl_edit_center_contact_number)
                    .addGroup(pnl_edit_centerLayout.createSequentialGroup()
                        .addComponent(btn_edit_center_save, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btn_edit_center_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnl_edit_centerLayout.setVerticalGroup(
        pnl_edit_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_edit_centerLayout.createSequentialGroup()
            .addComponent(pnl_editCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(40, 40, 40)
            .addComponent(lbl_editCenterId)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lbl_edit_center_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(11, 11, 11)
            .addComponent(lbl_edit_center_name)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_center_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_edit_center_address)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_center_address, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_edit_center_contact_number)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_center_contact_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_edit_center_vaccine_type_title)
            .addGap(5, 5, 5)
            .addComponent(lbl_edit_center_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(17, 17, 17)
            .addGroup(pnl_edit_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_edit_center_save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_edit_center_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );

    pnl_view_vaccine.setBackground(new java.awt.Color(255, 255, 255));
    pnl_view_vaccine.setPreferredSize(new java.awt.Dimension(960, 720));

    pnl_viewVaccine.setBackground(new java.awt.Color(136, 178, 219));

    lbl_view_vaccine.setBackground(new java.awt.Color(255, 255, 255));
    lbl_view_vaccine.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    lbl_view_vaccine.setForeground(new java.awt.Color(255, 255, 255));
    lbl_view_vaccine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_view_vaccine.setText("Manage Vaccine");

    javax.swing.GroupLayout pnl_viewVaccineLayout = new javax.swing.GroupLayout(pnl_viewVaccine);
    pnl_viewVaccine.setLayout(pnl_viewVaccineLayout);
    pnl_viewVaccineLayout.setHorizontalGroup(
        pnl_viewVaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_viewVaccineLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_view_vaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnl_viewVaccineLayout.setVerticalGroup(
        pnl_viewVaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_viewVaccineLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lbl_view_vaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    lbl_search_vaccine.setBackground(new java.awt.Color(255, 255, 255));
    lbl_search_vaccine.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_search_vaccine.setText("Search Vaccine");

    txt_search_vaccine.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_search_vaccine.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
    txt_search_vaccine.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_search_vaccineKeyReleased(evt);
        }
    });

    btn_vaccine_add.setBackground(new java.awt.Color(73, 161, 236));
    btn_vaccine_add.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_vaccine_add.setForeground(new java.awt.Color(255, 255, 255));
    btn_vaccine_add.setText("Add Vaccine");
    btn_vaccine_add.setBorder(null);
    btn_vaccine_add.setMaximumSize(new java.awt.Dimension(125, 19));
    btn_vaccine_add.setMinimumSize(new java.awt.Dimension(125, 19));
    btn_vaccine_add.setOpaque(true);
    btn_vaccine_add.setPreferredSize(new java.awt.Dimension(200, 19));
    btn_vaccine_add.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_vaccine_addActionPerformed(evt);
        }
    });

    btn_vaccine_edit.setBackground(new java.awt.Color(73, 161, 236));
    btn_vaccine_edit.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_vaccine_edit.setForeground(new java.awt.Color(255, 255, 255));
    btn_vaccine_edit.setText("Edit Vaccine");
    btn_vaccine_edit.setBorder(null);
    btn_vaccine_edit.setMaximumSize(new java.awt.Dimension(125, 19));
    btn_vaccine_edit.setMinimumSize(new java.awt.Dimension(125, 19));
    btn_vaccine_edit.setOpaque(true);
    btn_vaccine_edit.setPreferredSize(new java.awt.Dimension(200, 19));
    btn_vaccine_edit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_vaccine_editActionPerformed(evt);
        }
    });

    btn_vaccine_remove.setBackground(new java.awt.Color(221, 98, 98));
    btn_vaccine_remove.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_vaccine_remove.setForeground(new java.awt.Color(255, 255, 255));
    btn_vaccine_remove.setText("Remove Vaccine");
    btn_vaccine_remove.setBorder(null);
    btn_vaccine_remove.setOpaque(true);
    btn_vaccine_remove.setPreferredSize(new java.awt.Dimension(200, 19));
    btn_vaccine_remove.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_vaccine_removeActionPerformed(evt);
        }
    });

    tbl_view_vaccine.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    tbl_view_vaccine.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    )

    {public boolean isCellEditable(int row, int column){return false;}}

    );
    jScrollPane2.setViewportView(tbl_view_vaccine);

    javax.swing.GroupLayout pnl_view_vaccineLayout = new javax.swing.GroupLayout(pnl_view_vaccine);
    pnl_view_vaccine.setLayout(pnl_view_vaccineLayout);
    pnl_view_vaccineLayout.setHorizontalGroup(
        pnl_view_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_viewVaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnl_view_vaccineLayout.createSequentialGroup()
            .addGap(47, 47, 47)
            .addGroup(pnl_view_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(lbl_search_vaccine, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_view_vaccineLayout.createSequentialGroup()
                    .addGroup(pnl_view_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_search_vaccine)
                        .addGroup(pnl_view_vaccineLayout.createSequentialGroup()
                            .addComponent(btn_vaccine_add, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_vaccine_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_vaccine_remove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 227, Short.MAX_VALUE)))
                    .addGap(2, 2, 2)))
            .addGap(48, 48, 48))
    );
    pnl_view_vaccineLayout.setVerticalGroup(
        pnl_view_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_view_vaccineLayout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addComponent(pnl_viewVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27)
            .addComponent(lbl_search_vaccine)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_search_vaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(pnl_view_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_vaccine_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_vaccine_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_vaccine_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    pnl_add_vaccine.setBackground(new java.awt.Color(255, 255, 255));

    pnl_addVaccine.setBackground(new java.awt.Color(136, 178, 219));

    lbl_add_vaccine.setBackground(new java.awt.Color(255, 255, 255));
    lbl_add_vaccine.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    lbl_add_vaccine.setForeground(new java.awt.Color(255, 255, 255));
    lbl_add_vaccine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_add_vaccine.setText("Add Vaccine");

    javax.swing.GroupLayout pnl_addVaccineLayout = new javax.swing.GroupLayout(pnl_addVaccine);
    pnl_addVaccine.setLayout(pnl_addVaccineLayout);
    pnl_addVaccineLayout.setHorizontalGroup(
        pnl_addVaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_addVaccineLayout.createSequentialGroup()
            .addContainerGap(280, Short.MAX_VALUE)
            .addComponent(lbl_add_vaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(280, Short.MAX_VALUE))
    );
    pnl_addVaccineLayout.setVerticalGroup(
        pnl_addVaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_addVaccineLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lbl_add_vaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    lbl_add_vaccine_batch_id.setBackground(new java.awt.Color(255, 255, 255));
    lbl_add_vaccine_batch_id.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_add_vaccine_batch_id.setText("Batch ID");

    txt_add_vaccine_batch_id.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_add_vaccine_batch_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_add_vaccine_type.setBackground(new java.awt.Color(255, 255, 255));
    lbl_add_vaccine_type.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_add_vaccine_type.setText("Vaccine Type");

    cbo_add_vaccine_type.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    cbo_add_vaccine_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sinovac", "Pfizer", "AstraZeneca" }));
    cbo_add_vaccine_type.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbo_add_vaccine_typeActionPerformed(evt);
        }
    });

    lbl_add_vaccine_date.setBackground(new java.awt.Color(255, 255, 255));
    lbl_add_vaccine_date.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_add_vaccine_date.setText("Date");

    txt_add_vaccine_date.setBackground(new java.awt.Color(255, 255, 255));
    txt_add_vaccine_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_add_vaccine_expiration_date.setBackground(new java.awt.Color(255, 255, 255));
    lbl_add_vaccine_expiration_date.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_add_vaccine_expiration_date.setText("Expiration Date");

    txt_add_vaccine_expiration_date.setBackground(new java.awt.Color(255, 255, 255));
    txt_add_vaccine_expiration_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_add_vaccine_center_name.setBackground(new java.awt.Color(255, 255, 255));
    lbl_add_vaccine_center_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_add_vaccine_center_name.setText("Center Name");

    cbo_add_vaccine_center_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    cbo_add_vaccine_center_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Vaccination Center" }));

    lbl_addVaccineSecondDoseGap.setBackground(new java.awt.Color(255, 255, 255));
    lbl_addVaccineSecondDoseGap.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_addVaccineSecondDoseGap.setText("Second Dose Gap (Weeks)");

    lbl_add_vaccine_second_dose_gap.setBackground(new java.awt.Color(255, 255, 255));
    lbl_add_vaccine_second_dose_gap.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_add_vaccine_second_dose_gap.setForeground(new java.awt.Color(119, 119, 119));

    btn_add_vaccine_add.setBackground(new java.awt.Color(73, 161, 236));
    btn_add_vaccine_add.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_add_vaccine_add.setForeground(new java.awt.Color(255, 255, 255));
    btn_add_vaccine_add.setText("Add");
    btn_add_vaccine_add.setBorder(null);
    btn_add_vaccine_add.setOpaque(true);
    btn_add_vaccine_add.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_add_vaccine_addActionPerformed(evt);
        }
    });

    btn_add_vaccine_cancel.setBackground(new java.awt.Color(221, 98, 98));
    btn_add_vaccine_cancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_add_vaccine_cancel.setForeground(new java.awt.Color(255, 255, 255));
    btn_add_vaccine_cancel.setText("Cancel");
    btn_add_vaccine_cancel.setBorder(null);
    btn_add_vaccine_cancel.setOpaque(true);
    btn_add_vaccine_cancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_add_vaccine_cancelActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pnl_add_vaccineLayout = new javax.swing.GroupLayout(pnl_add_vaccine);
    pnl_add_vaccine.setLayout(pnl_add_vaccineLayout);
    pnl_add_vaccineLayout.setHorizontalGroup(
        pnl_add_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_addVaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnl_add_vaccineLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_add_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_add_vaccine_second_dose_gap, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_add_vaccine_date, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_add_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_add_vaccineLayout.createSequentialGroup()
                        .addComponent(lbl_addVaccineSecondDoseGap)
                        .addGap(207, 207, 207))
                    .addGroup(pnl_add_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbo_add_vaccine_center_name, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_add_vaccine_center_name)
                        .addComponent(cbo_add_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_add_vaccine_batch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_add_vaccine_batch_id)
                        .addComponent(lbl_add_vaccine_type)
                        .addComponent(lbl_add_vaccine_date)
                        .addComponent(lbl_add_vaccine_expiration_date)
                        .addGroup(pnl_add_vaccineLayout.createSequentialGroup()
                            .addComponent(btn_add_vaccine_add, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(btn_add_vaccine_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(txt_add_vaccine_expiration_date, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnl_add_vaccineLayout.setVerticalGroup(
        pnl_add_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_add_vaccineLayout.createSequentialGroup()
            .addComponent(pnl_addVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(40, 40, 40)
            .addComponent(lbl_add_vaccine_batch_id)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_add_vaccine_batch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_add_vaccine_type)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cbo_add_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(11, 11, 11)
            .addComponent(lbl_add_vaccine_date)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_add_vaccine_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_add_vaccine_expiration_date)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txt_add_vaccine_expiration_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_add_vaccine_center_name)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cbo_add_vaccine_center_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_addVaccineSecondDoseGap)
            .addGap(5, 5, 5)
            .addComponent(lbl_add_vaccine_second_dose_gap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(pnl_add_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_add_vaccine_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_add_vaccine_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    pnl_edit_vaccine.setBackground(new java.awt.Color(255, 255, 255));

    pnl_editVaccine.setBackground(new java.awt.Color(136, 178, 219));

    lbl_edit_vaccine.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccine.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
    lbl_edit_vaccine.setForeground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_edit_vaccine.setText("Edit Vaccine");

    javax.swing.GroupLayout pnl_editVaccineLayout = new javax.swing.GroupLayout(pnl_editVaccine);
    pnl_editVaccine.setLayout(pnl_editVaccineLayout);
    pnl_editVaccineLayout.setHorizontalGroup(
        pnl_editVaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_editVaccineLayout.createSequentialGroup()
            .addContainerGap(280, Short.MAX_VALUE)
            .addComponent(lbl_edit_vaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(280, Short.MAX_VALUE))
    );
    pnl_editVaccineLayout.setVerticalGroup(
        pnl_editVaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_editVaccineLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(lbl_edit_vaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    lbl_edit_vaccine_batch_id.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccine_batch_id.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_vaccine_batch_id.setText("Batch ID");

    txt_edit_vaccine_batch_id.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    txt_edit_vaccine_batch_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_edit_vaccine_type.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccine_type.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_vaccine_type.setText("Vaccine Type");

    cbo_edit_vaccine_type.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    cbo_edit_vaccine_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sinovac", "Pfizer", "AstraZeneca" }));
    cbo_edit_vaccine_type.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbo_edit_vaccine_typeActionPerformed(evt);
        }
    });

    lbl_edit_vaccine_date.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccine_date.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_vaccine_date.setText("Date");

    txt_edit_vaccine_date.setBackground(new java.awt.Color(255, 255, 255));
    txt_edit_vaccine_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_edit_vaccine_expiration_date.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccine_expiration_date.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_vaccine_expiration_date.setText("Expiration Date");

    txt_edit_vaccine_expiration_date.setBackground(new java.awt.Color(255, 255, 255));
    txt_edit_vaccine_expiration_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

    lbl_edit_vaccine_center_name.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccine_center_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_vaccine_center_name.setText("Center Name");

    cbo_edit_vaccine_center_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    cbo_edit_vaccine_center_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Vaccination Center" }));

    lbl_editVaccineSecondDoseGap.setBackground(new java.awt.Color(255, 255, 255));
    lbl_editVaccineSecondDoseGap.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_editVaccineSecondDoseGap.setText("Second Dose Gap (Weeks)");

    lbl_edit_vaccine_second_dose_gap.setBackground(new java.awt.Color(255, 255, 255));
    lbl_edit_vaccine_second_dose_gap.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    lbl_edit_vaccine_second_dose_gap.setForeground(new java.awt.Color(119, 119, 119));

    btn_edit_vaccine_save.setBackground(new java.awt.Color(73, 161, 236));
    btn_edit_vaccine_save.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_edit_vaccine_save.setForeground(new java.awt.Color(255, 255, 255));
    btn_edit_vaccine_save.setText("Save");
    btn_edit_vaccine_save.setBorder(null);
    btn_edit_vaccine_save.setOpaque(true);
    btn_edit_vaccine_save.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_edit_vaccine_saveActionPerformed(evt);
        }
    });

    btn_edit_vaccine_cancel.setBackground(new java.awt.Color(221, 98, 98));
    btn_edit_vaccine_cancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
    btn_edit_vaccine_cancel.setForeground(new java.awt.Color(255, 255, 255));
    btn_edit_vaccine_cancel.setText("Cancel");
    btn_edit_vaccine_cancel.setBorder(null);
    btn_edit_vaccine_cancel.setOpaque(true);
    btn_edit_vaccine_cancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_edit_vaccine_cancelActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pnl_edit_vaccineLayout = new javax.swing.GroupLayout(pnl_edit_vaccine);
    pnl_edit_vaccine.setLayout(pnl_edit_vaccineLayout);
    pnl_edit_vaccineLayout.setHorizontalGroup(
        pnl_edit_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_editVaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pnl_edit_vaccineLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_edit_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_edit_vaccine_second_dose_gap, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_edit_vaccine_date, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_edit_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_edit_vaccineLayout.createSequentialGroup()
                        .addComponent(lbl_editVaccineSecondDoseGap)
                        .addGap(207, 207, 207))
                    .addGroup(pnl_edit_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbo_edit_vaccine_center_name, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_edit_vaccine_center_name)
                        .addComponent(cbo_edit_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_edit_vaccine_batch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_edit_vaccine_batch_id)
                        .addComponent(lbl_edit_vaccine_type)
                        .addComponent(lbl_edit_vaccine_date)
                        .addComponent(lbl_edit_vaccine_expiration_date)
                        .addGroup(pnl_edit_vaccineLayout.createSequentialGroup()
                            .addComponent(btn_edit_vaccine_save, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(btn_edit_vaccine_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(txt_edit_vaccine_expiration_date, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnl_edit_vaccineLayout.setVerticalGroup(
        pnl_edit_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_edit_vaccineLayout.createSequentialGroup()
            .addComponent(pnl_editVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(40, 40, 40)
            .addComponent(lbl_edit_vaccine_batch_id)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_vaccine_batch_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_edit_vaccine_type)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cbo_edit_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(11, 11, 11)
            .addComponent(lbl_edit_vaccine_date)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_edit_vaccine_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_edit_vaccine_expiration_date)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txt_edit_vaccine_expiration_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(lbl_edit_vaccine_center_name)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cbo_edit_vaccine_center_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(lbl_editVaccineSecondDoseGap)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lbl_edit_vaccine_second_dose_gap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(pnl_edit_vaccineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_edit_vaccine_save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_edit_vaccine_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    javax.swing.GroupLayout pnl_containerLayout = new javax.swing.GroupLayout(pnl_container);
    pnl_container.setLayout(pnl_containerLayout);
    pnl_containerLayout.setHorizontalGroup(
        pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_view_account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_edit_account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_register_vaccination_appointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_edit_vaccination_appointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_view_people, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_view_vaccination_appointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_view_vaccination_center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_view_vaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_register_people, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_add_center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_edit_center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_add_vaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_edit_vaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_edit_people, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
    );
    pnl_containerLayout.setVerticalGroup(
        pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_view_account, javax.swing.GroupLayout.DEFAULT_SIZE, 2964, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_edit_account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_register_vaccination_appointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnl_edit_vaccination_appointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_view_people, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnl_view_vaccination_appointments, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnl_view_vaccination_center, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnl_view_vaccine, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_register_people, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnl_add_center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnl_add_vaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnl_edit_vaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnl_edit_center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_edit_people, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(pnl_sidenav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(pnl_container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_sidenav, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
        .addComponent(pnl_container, javax.swing.GroupLayout.PREFERRED_SIZE, 793, Short.MAX_VALUE)
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // My account side bar tab
    private void lbl_my_accountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_my_accountMouseClicked
        View_Personnel();
    }//GEN-LAST:event_lbl_my_accountMouseClicked

    // Cancel edit account button
    private void btn_cancel_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancel_editActionPerformed
        View_Personnel();
    }//GEN-LAST:event_btn_cancel_editActionPerformed

    // People side bar tab
    private void lbl_peopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_peopleMouseClicked
        View_People();
    }//GEN-LAST:event_lbl_peopleMouseClicked

    // Register people button
    private void btn_people_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_people_registerActionPerformed
        cbo_register_people_nationality.setSelectedIndex(-1);
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(true);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
    }//GEN-LAST:event_btn_people_registerActionPerformed

    // Cancel register people button
    private void btn_register_people_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_people_cancelActionPerformed
        View_People();
    }//GEN-LAST:event_btn_register_people_cancelActionPerformed

    // Cancel edit people button
    private void btn_edit_people_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_people_cancelActionPerformed
        View_People();
    }//GEN-LAST:event_btn_edit_people_cancelActionPerformed

    // Edit people button
    private void btn_people_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_people_editActionPerformed
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(true);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
    }//GEN-LAST:event_btn_people_editActionPerformed

    // Vaccination appointment side bar tab
    private void lbl_vaccination_appointmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_vaccination_appointmentsMouseClicked
        View_Appointment();
    }//GEN-LAST:event_lbl_vaccination_appointmentsMouseClicked

    // Register vaccination appointment button
    private void btn_vaccination_appointments_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaccination_appointments_registerActionPerformed
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(true);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
    }//GEN-LAST:event_btn_vaccination_appointments_registerActionPerformed

    // Cancel edit vaccination appointment button
    private void btn_edit_vaccination_appointments_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_vaccination_appointments_cancelActionPerformed
        View_Appointment();
    }//GEN-LAST:event_btn_edit_vaccination_appointments_cancelActionPerformed

    // Edit vaccination appointment button
    private void btn_vaccination_appointments_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaccination_appointments_editActionPerformed
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(true);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
        cbo_edit_vaccination_appointments_select_vaccination_center.setEnabled(false);
    }//GEN-LAST:event_btn_vaccination_appointments_editActionPerformed

    // Update vaccination appointment status button
    private void btn_vaccination_appointments_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaccination_appointments_updateActionPerformed
        String[] dosage = {"Pending", "Completed"};
        String selected;
        selected = (String) JOptionPane.showInputDialog(null, "Select Status: ", "Status", JOptionPane.QUESTION_MESSAGE, null, dosage, dosage[0]);

        if (!selected.equals("")) {
            appointment_class.Update_Appointment_Status(selected);
        }

        View_Appointment();
      }//GEN-LAST:event_btn_vaccination_appointments_updateActionPerformed

    // Vaccination center side bar tab
    private void lbl_vaccination_centerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_vaccination_centerMouseClicked
        View_Center();
    }//GEN-LAST:event_lbl_vaccination_centerMouseClicked

    // Add vaccination center button
    private void btn_vaccination_center_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaccination_center_addActionPerformed
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(true);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
    }//GEN-LAST:event_btn_vaccination_center_addActionPerformed

    // Edit vaccination center button
    private void btn_vaccination_center_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaccination_center_editActionPerformed
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(true);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
    }//GEN-LAST:event_btn_vaccination_center_editActionPerformed

    // Cancel edit vaccination center button
    private void btn_edit_center_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_center_cancelActionPerformed
        View_Center();
    }//GEN-LAST:event_btn_edit_center_cancelActionPerformed

    // Vaccine side bar tab
    private void lbl_vaccineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_vaccineMouseClicked
        View_Vaccine();
    }//GEN-LAST:event_lbl_vaccineMouseClicked

    // Add vaccine button
    private void btn_vaccine_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaccine_addActionPerformed
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(true);
        pnl_edit_vaccine.setVisible(false);
        cbo_add_vaccine_center_name.setEnabled(false);
    }//GEN-LAST:event_btn_vaccine_addActionPerformed

    // Cancel add vaccine button
    private void btn_add_vaccine_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_vaccine_cancelActionPerformed
        View_Vaccine();
    }//GEN-LAST:event_btn_add_vaccine_cancelActionPerformed

    // Edit vaccine button
    private void btn_vaccine_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaccine_editActionPerformed
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(true);
    }//GEN-LAST:event_btn_vaccine_editActionPerformed

    // Cancel edit vaccine button
    private void btn_edit_vaccine_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_vaccine_cancelActionPerformed
        View_Vaccine();
    }//GEN-LAST:event_btn_edit_vaccine_cancelActionPerformed

    // Logout button
    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        int return_value = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Warning", JOptionPane.YES_NO_OPTION);

        if (return_value == JOptionPane.YES_OPTION) {
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        } else if (return_value == JOptionPane.NO_OPTION) {

        }
    }//GEN-LAST:event_lbl_logoutMouseClicked

    // Cancel register vaccination appointment button
    private void btn_register_vaccination_appointments_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_vaccination_appointments_cancelActionPerformed
        View_Appointment();
    }//GEN-LAST:event_btn_register_vaccination_appointments_cancelActionPerformed

    // Cancel add vaccination center button
    private void btn_add_center_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_center_cancelActionPerformed
        View_Center();
    }//GEN-LAST:event_btn_add_center_cancelActionPerformed

    // Save register people button
    private void btn_register_people_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_people_registerActionPerformed
        if (txt_register_people_name.getText().equals("") || txt_register_people_phone_number.getText().equals("")
                || cbo_register_people_nationality.getSelectedItem() == "" || txt_register_people_ic_passport_number.getText().equals("")
                || txt_register_people_address.getText().equals("") || txt_register_people_password.getPassword().length == 0
                || txt_register_people_confirm_password.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validateName(txt_register_people_name.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("name"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validatePhoneNumber(txt_register_people_phone_number.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("phone_number"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (cbo_register_people_nationality.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Please Select your nationality", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validateICPassportNumber(txt_register_people_ic_passport_number.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("ic_passport_number"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!txt_register_people_password.getText().matches(txt_register_people_confirm_password.getText())) {
            JOptionPane.showMessageDialog(null, "Password not match.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (cbo_register_people_nationality.getSelectedItem() == "Malaysia") {
                try {
                    CitizenRecord register = new CitizenRecord(cc.calculatePeople_ID(), txt_register_people_name.getText(), txt_register_people_phone_number.getText(), cbo_register_people_nationality.getSelectedItem().toString(), txt_register_people_ic_passport_number.getText(), txt_register_people_address.getText(), txt_register_people_password.getText());
                    if (cc.Register_Account(register)) {
                        JOptionPane.showMessageDialog(null, "People registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        View_People();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to register account with the same IC Number exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PeopleRegisterAccount.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PeopleRegisterAccount.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
//                NonCitizenClass non_citizen = new NonCitizenClass();
//                non_citizen.calculatePeople_ID();
//                non_citizen.setName(txt_register_people_name.getText());
//                non_citizen.setPhone_Number(txt_register_people_phone_number.getText());
//                non_citizen.setNationality(cbo_register_people_nationality.getSelectedItem().toString());
//                non_citizen.setAddress(txt_register_people_address.getText());
//                non_citizen.setPassword(txt_register_people_password.getText());
//                non_citizen.setPassport_Number(txt_register_people_ic_passport_number.getText()); 
//                non_citizen.Register_Account();
//                
//                if(non_citizen.getSuccess_Save() == true) {
//                    JOptionPane.showMessageDialog(null, "People registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
//                    View_People();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Failed to register account with the same Passport Number exist.", "Error", JOptionPane.ERROR_MESSAGE);
//                }
            }
        }
    }//GEN-LAST:event_btn_register_people_registerActionPerformed

    // Save edit people button
    private void btn_edit_people_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_people_saveActionPerformed
        if (txt_edit_people_name.getText().equals("") || txt_edit_people_phone_number.getText().equals("") || cbo_edit_people_nationality.getSelectedItem() == "" || txt_edit_people_ic_passport_number.getText().equals("") || txt_edit_people_address.getText().equals("") || txt_edit_people_password.getPassword().length == 0 || txt_edit_people_confirm_password.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validateName(txt_edit_people_name.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("name"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validatePhoneNumber(txt_edit_people_phone_number.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("phone_number"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (cbo_edit_people_nationality.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Please Select your nationality", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validateICPassportNumber(txt_edit_people_ic_passport_number.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("ic_passport_number"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!txt_edit_people_password.getText().matches(txt_edit_people_confirm_password.getText())) {
            JOptionPane.showMessageDialog(null, "Password not match.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (cbo_edit_people_nationality.getSelectedItem() == "Malaysia") {
//                citizen_class.setName(txt_edit_people_name.getText());
//                citizen_class.setPhone_Number(txt_edit_people_phone_number.getText());
//                citizen_class.setNationality(cbo_edit_people_nationality.getSelectedItem().toString());
//                citizen_class.setAddress(txt_edit_people_address.getText());
//                citizen_class.setPassword(txt_edit_people_password.getText());
//                citizen_class.setIC_Number(txt_edit_people_ic_passport_number.getText());
//                citizen_class.Edit_Account();
                CitizenRecord edit = new CitizenRecord(People_ID, txt_edit_people_name.getText(), txt_edit_people_phone_number.getText(), cbo_edit_people_nationality.getSelectedItem().toString(), txt_edit_people_ic_passport_number.getText(), txt_edit_people_address.getText(), txt_edit_people_password.getText());
                System.out.println(edit);

                try {
                    if (cc.Edit_Account(edit)) {
                        View_People();
                        JOptionPane.showMessageDialog(null, "People updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update people. \nPossible error: \nA record with the same IC number exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Personnel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
//                noncitizen_class.setName(txt_edit_people_name.getText());
//                noncitizen_class.setPhone_Number(txt_edit_people_phone_number.getText());
//                noncitizen_class.setNationality(cbo_edit_people_nationality.getSelectedItem().toString());
//                noncitizen_class.setAddress(txt_edit_people_address.getText());
//                noncitizen_class.setPassword(txt_edit_people_password.getText());
//                noncitizen_class.setPassport_Number(txt_edit_people_ic_passport_number.getText());
//                noncitizen_class.Edit_Account();
//                if (noncitizen_class.getSuccess_Save() == true) {
//                    View_People();
//                    JOptionPane.showMessageDialog(null, "People updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Failed to update people.\nPossible error: \nA record with the same Passport number exist.", "Error", JOptionPane.ERROR_MESSAGE);
//                }
            }
        }
    }//GEN-LAST:event_btn_edit_people_saveActionPerformed

    // Remove vaccination appointment button
    private void btn_vaccination_appointments_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaccination_appointments_removeActionPerformed
        int return_value = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the record?", "Warning", JOptionPane.YES_NO_OPTION);

        if (return_value == JOptionPane.YES_OPTION) {
            appointment_class.Remove_Appointment();

            if (appointment_class.getSuccess_Save() == true) {
                View_Appointment();
                JOptionPane.showMessageDialog(null, "Vaccination appointment removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to remove vacicnation appointment.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (return_value == JOptionPane.NO_OPTION) {

        }
    }//GEN-LAST:event_btn_vaccination_appointments_removeActionPerformed

    // Save register vaccination appointment button
    private void btn_register_vaccination_appointments_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_vaccination_appointments_registerActionPerformed
        if (cbo_register_vaccination_appointments_select_vaccination_center.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "The selected date does not have a center. \nPlease select another date.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (cbo_register_vaccination_appointments_select_time.getSelectedIndex() == -1 || cbo_register_vaccination_appointments_select_time.getSelectedItem().equals("Select Time")) {
            JOptionPane.showMessageDialog(null, "Pelase select a time for the appointment.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (txt_register_vaccination_appointments_ic_passport_number.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                appointment_class.Check_Exist(txt_register_vaccination_appointments_ic_passport_number.getText());

                if (appointment_class.getExist() == false) {
                    JOptionPane.showMessageDialog(null, "Cannot find people!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else if (txt_register_vaccination_appointments_select_date.getDate().compareTo(date) < 0) {
                    JOptionPane.showMessageDialog(null, validation_class.validationMessage("date"), "Warning", JOptionPane.WARNING_MESSAGE);
                } else if (cbo_register_vaccination_appointments_select_vaccination_center.getSelectedItem().equals("")) {
                    JOptionPane.showMessageDialog(null, validation_class.validationMessage("center"), "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    appointment_class.calculateAppointnment_ID();
                    appointment_class.Add_Dose();

                    // Set vaccine ID
                    Center selected_item = (Center) cbo_register_vaccination_appointments_select_vaccination_center.getSelectedItem();
                    appointment_class.Add_Vaccine_Id(date_format.format(txt_register_vaccination_appointments_select_date.getDate()), selected_item.getId());
                    appointment_class.setAppointment_Time(cbo_register_vaccination_appointments_select_time.getSelectedItem().toString());
                    appointment_class.Add_Dose();
                    appointment_class.setStatus("Pending");
                    appointment_class.Add_Appointment();

                    if (appointment_class.getSuccess_Save() == true) {
                        JOptionPane.showMessageDialog(null, "Vaccinaton appointment registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        View_Appointment();
                        Clear();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to register vaccination appointment. \nPossible issue: \n- More than 2 appointment for this people.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_register_vaccination_appointments_registerActionPerformed

    // Save edit vaccination appointment button
    private void btn_edit_vaccination_appointments_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_vaccination_appointments_saveActionPerformed
        if (cbo_edit_vaccination_appointments_select_vaccination_center.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "The selected date does not have a center. \nPlease select another date.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (txt_edit_vaccination_appointments_ic_passport_number.getText().equals("") || cbo_edit_vaccination_appointments_select_time.getSelectedItem().equals("Select Time")
                    || cbo_edit_vaccination_appointments_select_vaccination_center.getSelectedItem().equals("Select Vaccination Center")
                    || cbo_edit_vaccination_appointments_select_vaccination_center.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                appointment_class.Check_Exist(txt_edit_vaccination_appointments_ic_passport_number.getText());

                if (appointment_class.getExist() == false) {
                    JOptionPane.showMessageDialog(null, "Cannot find people!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else if (txt_edit_vaccination_appointments_select_date.getDate().compareTo(date) < 0) {
                    JOptionPane.showMessageDialog(null, validation_class.validationMessage("date"), "Warning", JOptionPane.WARNING_MESSAGE);
                } else if (cbo_edit_vaccination_appointments_select_vaccination_center.getSelectedItem().equals("")) {
                    JOptionPane.showMessageDialog(null, validation_class.validationMessage("center"), "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Set vaccine id
                    Center selected_item = (Center) cbo_edit_vaccination_appointments_select_vaccination_center.getSelectedItem();
                    appointment_class.Add_Vaccine_Id(date_format.format(txt_edit_vaccination_appointments_select_date.getDate()), selected_item.getId());
                    appointment_class.setAppointment_Time(cbo_edit_vaccination_appointments_select_time.getSelectedItem().toString());
                    appointment_class.Add_Dose();
                    appointment_class.setStatus("Pending");
                    appointment_class.Update_Appointment();

                    if (appointment_class.getSuccess_Save() == true) {
                        JOptionPane.showMessageDialog(null, "Vaccination appointment updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        View_Appointment();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update vaccination appointment.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_edit_vaccination_appointments_saveActionPerformed

    // Remove vaccination center button
    private void btn_vaccination_center_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaccination_center_removeActionPerformed
        int return_value = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the record with name "
                + center_class.getCenter_Name() + " ?", "Warning", JOptionPane.YES_NO_OPTION);

        if (return_value == JOptionPane.YES_OPTION) {
            center_class.Remove_Center();

            if (center_class.getSuccess_Save() == true) {
                JOptionPane.showMessageDialog(null, "Vaccination center deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                View_Center();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete vaccination center.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (return_value == JOptionPane.NO_OPTION) {

        }
    }//GEN-LAST:event_btn_vaccination_center_removeActionPerformed

    // Save add vaccination center button
    private void btn_add_center_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_center_addActionPerformed
        if (txt_add_center_name.getText().equals("") || txt_add_center_address.getText().equals("") || txt_add_center_contact_number.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validateName(txt_add_center_name.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("name"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (cbo_add_center_vaccine_type.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a vaccine type.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validatePhoneNumber(txt_add_center_contact_number.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("phone_number"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            center_class.calculateCenter_ID();
            center_class.setCenter_Name(txt_add_center_name.getText());
            center_class.setCenter_Address(txt_add_center_address.getText());
            center_class.setCenter_Contact_Number(txt_add_center_contact_number.getText());
            center_class.setVaccine_Type(cbo_add_center_vaccine_type.getSelectedItem().toString());
            center_class.Add_Center();

            if (center_class.getSuccess_Save() == true) {
                JOptionPane.showMessageDialog(null, "Vaccination center added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                View_Center();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add vaccination center, center with the same name exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_add_center_addActionPerformed

    // Save edit vaccination center button
    private void btn_edit_center_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_center_saveActionPerformed
        if (txt_edit_center_name.getText().equals("") || txt_edit_center_address.getText().equals("") || txt_edit_center_contact_number.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validateName(txt_edit_center_name.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("name"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validatePhoneNumber(txt_edit_center_contact_number.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("phone_number"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            center_class.setCenter_ID(Integer.parseInt(lbl_edit_center_id.getText()));
            center_class.setCenter_Name(txt_edit_center_name.getText());
            center_class.setCenter_Address(txt_edit_center_address.getText());
            center_class.setCenter_Contact_Number(txt_edit_center_contact_number.getText());
            center_class.Edit_Center();

            if (center_class.getSuccess_Save() == true) {
                View_Center();
                JOptionPane.showMessageDialog(null, "Vaccination center updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update vaccination center. \nPossible error: \n- Same center name exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_edit_center_saveActionPerformed

    // Remove vaccine button
    private void btn_vaccine_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaccine_removeActionPerformed
        int return_value = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the record?", "Warning", JOptionPane.YES_NO_OPTION);

        if (return_value == JOptionPane.YES_OPTION) {
            vaccine_class.Remove_Vaccine();

            if (vaccine_class.getSuccess_Save() == true) {
                JOptionPane.showMessageDialog(null, "Vaccine deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                View_Vaccine();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete vaccine.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (return_value == JOptionPane.NO_OPTION) {

        }
    }//GEN-LAST:event_btn_vaccine_removeActionPerformed

    // Save add vaccine button
    private void btn_add_vaccine_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_vaccine_addActionPerformed
        if (cbo_add_vaccine_center_name.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "The selected type of vaccine does not have a center. \nPlease select another type of vaccine.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (txt_add_vaccine_batch_id.getText().equals("") || cbo_add_vaccine_type.getSelectedItem().equals("Select Vaccine Type") || cbo_add_vaccine_center_name.getSelectedItem().equals("Select Vaccination Center")
                    || txt_add_vaccine_date.getDate() == null || txt_add_vaccine_expiration_date.getDate() == null
                    || cbo_add_vaccine_center_name.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (txt_add_vaccine_date.getDate().compareTo(date) < 0) {
                JOptionPane.showMessageDialog(null, validation_class.validationMessage("date"), "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (txt_add_vaccine_expiration_date.getDate().compareTo(date) < 0) {
                JOptionPane.showMessageDialog(null, validation_class.validationMessage("date"), "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (cbo_add_vaccine_center_name.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, validation_class.validationMessage("center"), "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (validation_class.validateVaccineBatchID(txt_add_vaccine_batch_id.getText()) == true) {
                JOptionPane.showMessageDialog(null, validation_class.validationMessage("vaccine_batch_id"), "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                vaccine_class.calcualte_Vaccine_ID();
                vaccine_class.setVaccine_Batch_ID(txt_add_vaccine_batch_id.getText());
                vaccine_class.setVaccine_Type(cbo_add_vaccine_type.getSelectedItem().toString());
                vaccine_class.setdate(date_format.format(txt_add_vaccine_date.getDate()));
                vaccine_class.setExpiration_Date(date_format.format(txt_add_vaccine_expiration_date.getDate()));
                vaccine_class.setSecond_Dose_Gap(Integer.parseInt(lbl_add_vaccine_second_dose_gap.getText()));
                Center selected_item = (Center) cbo_add_vaccine_center_name.getSelectedItem();
                vaccine_class.Add_Vaccine(selected_item.getId());

                if (vaccine_class.getSuccess_Save() == true) {
                    JOptionPane.showMessageDialog(null, "Vaccine added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    View_Vaccine();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add vaccine. \nPossible error: \n- A record with same batch ID, date and center exist. \n- Invalid date.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btn_add_vaccine_addActionPerformed

    // Save edit vaccine button
    private void btn_edit_vaccine_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_vaccine_saveActionPerformed
        if (cbo_edit_vaccine_center_name.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "The selected type of vaccine does not have a center. \nPlease select another type of vaccine.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (txt_edit_vaccine_batch_id.getText().equals("") || cbo_edit_vaccine_type.getSelectedItem().equals("Select Vaccine Type") || cbo_edit_vaccine_center_name.getSelectedItem().equals("Select Vaccination Center")
                    || txt_edit_vaccine_date.getDate() == null || txt_edit_vaccine_expiration_date.getDate() == null || cbo_edit_vaccine_center_name.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (txt_edit_vaccine_date.getDate().compareTo(date) < 0) {
                JOptionPane.showMessageDialog(null, validation_class.validationMessage("date"), "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (txt_edit_vaccine_expiration_date.getDate().compareTo(date) < 0) {
                JOptionPane.showMessageDialog(null, validation_class.validationMessage("date"), "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (validation_class.validateVaccineBatchID(txt_edit_vaccine_batch_id.getText()) == true) {
                JOptionPane.showMessageDialog(null, validation_class.validationMessage("vaccine_batch_id"), "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                vaccine_class.setVaccine_Batch_ID(txt_edit_vaccine_batch_id.getText());
                vaccine_class.setVaccine_Type(cbo_edit_vaccine_type.getSelectedItem().toString());
                vaccine_class.setdate(date_format.format(txt_edit_vaccine_date.getDate()));
                vaccine_class.setExpiration_Date(date_format.format(txt_edit_vaccine_expiration_date.getDate()));
                vaccine_class.setSecond_Dose_Gap(Integer.parseInt(lbl_edit_vaccine_second_dose_gap.getText()));
                Center selected_item = (Center) cbo_edit_vaccine_center_name.getSelectedItem();
                vaccine_class.Edit_Vaccine(selected_item.getId());

                if (vaccine_class.getSuccess_Save() == true) {
                    JOptionPane.showMessageDialog(null, "Vaccine updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    View_Vaccine();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update vaccine. \nPossible error: \n- A record with same batch ID, date and center exist. \n- Invalid date.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btn_edit_vaccine_saveActionPerformed

    // Save edit account button
    private void btn_save_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_save_editActionPerformed
        if (txt_edit_name.getText().equals("") || txt_edit_phone_number.getText().equals("") || txt_edit_address.getText().equals("") || txt_edit_password.getPassword().length == 0 || txt_edit_confirm_password.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validateName(txt_edit_name.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("name"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validatePhoneNumber(txt_edit_phone_number.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("phone_number"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!txt_edit_password.getText().matches(txt_edit_confirm_password.getText())) {
            JOptionPane.showMessageDialog(null, "Password not match.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            personnel_class.setName(txt_edit_name.getText());
            personnel_class.setPhone_Number(txt_edit_phone_number.getText());
            personnel_class.setNationality(txt_edit_nationality.getText());
            personnel_class.setAddress(txt_edit_address.getText());
            personnel_class.setPassword(txt_edit_password.getText());
            personnel_class.setIC_Number(txt_edit_ic_passport_number.getText());
            personnel_class.Edit_Account();

            if (personnel_class.getSuccess_Save() == true) {
                View_Personnel();
                JOptionPane.showMessageDialog(null, "Accouont updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update account.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_save_editActionPerformed

    // Search people
    private void txt_search_peopleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_peopleKeyReleased
        DefaultTableModel people_table_model = (DefaultTableModel) tbl_view_people.getModel();
        TableRowSorter<DefaultTableModel> search_people = new TableRowSorter<DefaultTableModel>(people_table_model);
        tbl_view_people.setRowSorter(search_people);
        search_people.setRowFilter(RowFilter.regexFilter(txt_search_people.getText()));
    }//GEN-LAST:event_txt_search_peopleKeyReleased

    // Search vaccination center
    private void txt_search_vaccination_centerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_vaccination_centerKeyReleased
        DefaultTableModel center_table_model = (DefaultTableModel) tbl_view_vaccination_center.getModel();
        TableRowSorter<DefaultTableModel> search_center = new TableRowSorter<DefaultTableModel>(center_table_model);
        tbl_view_vaccination_center.setRowSorter(search_center);
        search_center.setRowFilter(RowFilter.regexFilter(txt_search_vaccination_center.getText()));
    }//GEN-LAST:event_txt_search_vaccination_centerKeyReleased

    // Vaccine type combo box
    private void cbo_add_vaccine_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_add_vaccine_typeActionPerformed
        if (cbo_add_vaccine_type.getSelectedItem() == "Sinovac") {
            cbo_add_vaccine_center_name.setEnabled(true);
            lbl_add_vaccine_second_dose_gap.setText("2");

            // Populate the center dropdowns
            center_class.View_Center();
            cbo_add_vaccine_center_name.removeAllItems();

            DefaultComboBoxModel cbo_add_model = (DefaultComboBoxModel) cbo_add_vaccine_center_name.getModel();

            for (int i = 0; i < center_class.getCenter_Data().size(); i++) {
                String[] data = center_class.getCenter_Data().get(i).split("//");
                if (data[4].equals("Sinovac")) {
                    cbo_add_model.addElement(new Center(data[0], data[1], data[2]));
                }
            }

            cbo_add_vaccine_center_name.setModel(cbo_add_model);
            lbl_edit_vaccine_second_dose_gap.setText("2");
        } else if (cbo_add_vaccine_type.getSelectedItem() == "Pfizer") {
            cbo_add_vaccine_center_name.setEnabled(true);
            lbl_add_vaccine_second_dose_gap.setText("2");

            // Populate the center dropdowns
            center_class.View_Center();
            cbo_add_vaccine_center_name.removeAllItems();

            DefaultComboBoxModel cbo_add_model = (DefaultComboBoxModel) cbo_add_vaccine_center_name.getModel();

            for (int i = 0; i < center_class.getCenter_Data().size(); i++) {
                String[] data = center_class.getCenter_Data().get(i).split("//");

                if (data[4].equals("Pfizer")) {
                    cbo_add_model.addElement(new Center(data[0], data[1], data[2]));
                }
            }

            cbo_add_vaccine_center_name.setModel(cbo_add_model);
            lbl_edit_vaccine_second_dose_gap.setText("2");
        } else if (cbo_add_vaccine_type.getSelectedItem() == "AstraZeneca") {
            cbo_add_vaccine_center_name.setEnabled(true);
            lbl_add_vaccine_second_dose_gap.setText("12");

            // Populate the center dropdowns
            center_class.View_Center();
            cbo_add_vaccine_center_name.removeAllItems();

            DefaultComboBoxModel cbo_add_model = (DefaultComboBoxModel) cbo_add_vaccine_center_name.getModel();

            for (int i = 0; i < center_class.getCenter_Data().size(); i++) {
                String[] data = center_class.getCenter_Data().get(i).split("//");
                if (data[4].equals("AstraZeneca")) {
                    cbo_add_model.addElement(new Center(data[0], data[1], data[2]));
                }
            }

            cbo_add_vaccine_center_name.setModel(cbo_add_model);
            lbl_edit_vaccine_second_dose_gap.setText("12");
        } else {
            lbl_add_vaccine_second_dose_gap.setText("");
        }    }//GEN-LAST:event_cbo_add_vaccine_typeActionPerformed

    // Edit vaccine type
    private void cbo_edit_vaccine_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_edit_vaccine_typeActionPerformed
        if (cbo_edit_vaccine_type.getSelectedItem() == "Sinovac") {
            cbo_edit_vaccine_center_name.setEnabled(true);
            lbl_add_vaccine_second_dose_gap.setText("2");

            // Populate the center dropdowns
            center_class.View_Center();
            cbo_edit_vaccine_center_name.removeAllItems();

            DefaultComboBoxModel cbo_add_model = (DefaultComboBoxModel) cbo_edit_vaccine_center_name.getModel();

            for (int i = 0; i < center_class.getCenter_Data().size(); i++) {
                String[] data = center_class.getCenter_Data().get(i).split("//");
                if (data[4].equals("Sinovac")) {
                    cbo_add_model.addElement(new Center(data[0], data[1], data[2]));
                }
            }

            cbo_edit_vaccine_center_name.setModel(cbo_add_model);
            lbl_edit_vaccine_second_dose_gap.setText("2");
        } else if (cbo_edit_vaccine_type.getSelectedItem() == "Pfizer") {
            cbo_edit_vaccine_center_name.setEnabled(true);
            lbl_add_vaccine_second_dose_gap.setText("2");

            // Populate the center dropdowns
            center_class.View_Center();
            cbo_edit_vaccine_center_name.removeAllItems();

            DefaultComboBoxModel cbo_add_model = (DefaultComboBoxModel) cbo_edit_vaccine_center_name.getModel();

            for (int i = 0; i < center_class.getCenter_Data().size(); i++) {
                String[] data = center_class.getCenter_Data().get(i).split("//");
                if (data[4].equals("Pfizer")) {
                    cbo_add_model.addElement(new Center(data[0], data[1], data[2]));
                }
            }

            cbo_edit_vaccine_center_name.setModel(cbo_add_model);
            lbl_edit_vaccine_second_dose_gap.setText("2");
        } else if (cbo_edit_vaccine_type.getSelectedItem() == "AstraZeneca") {
            cbo_edit_vaccine_center_name.setEnabled(true);
            lbl_add_vaccine_second_dose_gap.setText("12");

            // Populate the center dropdowns
            center_class.View_Center();
            cbo_edit_vaccine_center_name.removeAllItems();

            DefaultComboBoxModel cbo_add_model = (DefaultComboBoxModel) cbo_edit_vaccine_center_name.getModel();

            for (int i = 0; i < center_class.getCenter_Data().size(); i++) {
                String[] data = center_class.getCenter_Data().get(i).split("//");
                if (data[4].equals("AstraZeneca")) {
                    cbo_add_model.addElement(new Center(data[0], data[1], data[2]));
                }
            }

            cbo_edit_vaccine_center_name.setModel(cbo_add_model);
            lbl_edit_vaccine_second_dose_gap.setText("12");
        } else {
            lbl_edit_vaccine_second_dose_gap.setText("");
        }      }//GEN-LAST:event_cbo_edit_vaccine_typeActionPerformed

    // Search vaccine
    private void txt_search_vaccineKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_vaccineKeyReleased
        DefaultTableModel vaccine_table_model = (DefaultTableModel) tbl_view_vaccine.getModel();
        TableRowSorter<DefaultTableModel> search_vaccine = new TableRowSorter<DefaultTableModel>(vaccine_table_model);
        tbl_view_vaccine.setRowSorter(search_vaccine);
        search_vaccine.setRowFilter(RowFilter.regexFilter(txt_search_vaccine.getText()));
    }//GEN-LAST:event_txt_search_vaccineKeyReleased

    // Search vaccination appointment
    private void txt_search_vaccination_appointmentsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_vaccination_appointmentsKeyReleased
        DefaultTableModel appointment_table_model = (DefaultTableModel) tbl_view_vaccination_appointments.getModel();
        TableRowSorter<DefaultTableModel> search_appointment = new TableRowSorter<DefaultTableModel>(appointment_table_model);
        tbl_view_vaccination_appointments.setRowSorter(search_appointment);
        search_appointment.setRowFilter(RowFilter.regexFilter(txt_search_vaccination_appointments.getText()));
    }//GEN-LAST:event_txt_search_vaccination_appointmentsKeyReleased

    // Register vaccination appointment - select date
    private void txt_register_vaccination_appointments_select_datePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_register_vaccination_appointments_select_datePropertyChange
        if (txt_register_vaccination_appointments_select_date.getDate() == null) {
            cbo_register_vaccination_appointments_select_vaccination_center.setEnabled(false);
        } else {
            cbo_register_vaccination_appointments_select_vaccination_center.setEnabled(true);
            appointment_class.Show_Locations(date_format.format(txt_register_vaccination_appointments_select_date.getDate()));
            cbo_register_vaccination_appointments_select_vaccination_center.removeAllItems();
            center_class.View_Center();
            DefaultComboBoxModel cbo_edit_model = (DefaultComboBoxModel) cbo_register_vaccination_appointments_select_vaccination_center.getModel();

            for (int i = 0; i < appointment_class.getAvaliableLocation().size(); i++) {
                String[] data = appointment_class.getAvaliableLocation().get(i).split("//");
                String temp = "", ww;
                ww = data[6];

                for (int a = 0; a < center_class.getCenter_Data().size(); a++) {
                    String[] name = center_class.getCenter_Data().get(a).split("//");
                    if (name[0].equals(ww)) {
                        temp = name[1];
                    }
                }
                cbo_edit_model.addElement(new Center(data[6], temp, data[2]));
            }
            cbo_register_vaccination_appointments_select_vaccination_center.setModel(cbo_edit_model);
        }
    }//GEN-LAST:event_txt_register_vaccination_appointments_select_datePropertyChange

    // Edit vaccination appointment - select date
    private void txt_edit_vaccination_appointments_select_datePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_edit_vaccination_appointments_select_datePropertyChange
        if (txt_edit_vaccination_appointments_select_date.getDate() == null) {
            cbo_edit_vaccination_appointments_select_vaccination_center.setEnabled(false);
        } else {
            cbo_edit_vaccination_appointments_select_vaccination_center.setEnabled(true);
            appointment_class.Show_Locations(date_format.format(txt_edit_vaccination_appointments_select_date.getDate()));
            cbo_edit_vaccination_appointments_select_vaccination_center.removeAllItems();
            center_class.View_Center();
            DefaultComboBoxModel cbo_edit_model = (DefaultComboBoxModel) cbo_edit_vaccination_appointments_select_vaccination_center.getModel();

            for (int i = 0; i < appointment_class.getAvaliableLocation().size(); i++) {
                String[] data = appointment_class.getAvaliableLocation().get(i).split("//");
                String temp = "", ww;
                ww = data[6];

                for (int a = 0; a < center_class.getCenter_Data().size(); a++) {
                    String[] name = center_class.getCenter_Data().get(a).split("//");

                    if (name[0].equals(ww)) {
                        temp = name[1];
                    }
                }
                cbo_edit_model.addElement(new Center(data[6], temp, data[2]));
            }
            cbo_edit_vaccination_appointments_select_vaccination_center.setModel(cbo_edit_model);
        }
    }//GEN-LAST:event_txt_edit_vaccination_appointments_select_datePropertyChange

    // Register vaccination appointment - select vaccination center
    private void cbo_register_vaccination_appointments_select_vaccination_centerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_register_vaccination_appointments_select_vaccination_centerActionPerformed
        try {
            Center_ID_and_Details();
            Center selected_item = (Center) cbo_register_vaccination_appointments_select_vaccination_center.getSelectedItem();
            lbl_register_vaccination_appointments_vaccine_type.setText(selected_item.getType());
        } catch (NullPointerException e) {

        }
    }//GEN-LAST:event_cbo_register_vaccination_appointments_select_vaccination_centerActionPerformed

    // Edit vaccination appointment - select vaccination center
    private void cbo_edit_vaccination_appointments_select_vaccination_centerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_edit_vaccination_appointments_select_vaccination_centerActionPerformed
        try {
            Center_ID_and_Details();
            Center selected_item = (Center) cbo_edit_vaccination_appointments_select_vaccination_center.getSelectedItem();
            lbl_edit_vaccination_appointments_vaccine_type.setText(selected_item.getType());
        } catch (NullPointerException e) {

        }
    }//GEN-LAST:event_cbo_edit_vaccination_appointments_select_vaccination_centerActionPerformed

    // Save edit account button
    private void btn_edit_accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_accountActionPerformed
        // View data
        personnel_class.View_Account();
        txt_edit_name.setText(personnel_class.getName());
        txt_edit_phone_number.setText(personnel_class.getPhone_Number());
        txt_edit_nationality.setText(personnel_class.getNationality());
        txt_edit_ic_passport_number.setText(personnel_class.getIC_Number());
        txt_edit_address.setText(personnel_class.getAddress());
        txt_edit_password.setText(personnel_class.getPassword());
        txt_edit_confirm_password.setText(personnel_class.getPassword());

        // Hide panel
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(true);
        pnl_view_people.setVisible(false);
        pnl_register_people.setVisible(false);
        pnl_edit_people.setVisible(false);
        pnl_view_vaccination_appointments.setVisible(false);
        pnl_register_vaccination_appointments.setVisible(false);
        pnl_edit_vaccination_appointments.setVisible(false);
        pnl_view_vaccination_center.setVisible(false);
        pnl_add_center.setVisible(false);
        pnl_edit_center.setVisible(false);
        pnl_view_vaccine.setVisible(false);
        pnl_add_vaccine.setVisible(false);
        pnl_edit_vaccine.setVisible(false);
    }//GEN-LAST:event_btn_edit_accountActionPerformed

    // Main method
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Personnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personnel().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_center_add;
    private javax.swing.JButton btn_add_center_cancel;
    private javax.swing.JButton btn_add_vaccine_add;
    private javax.swing.JButton btn_add_vaccine_cancel;
    private javax.swing.JButton btn_cancel_edit;
    private javax.swing.JButton btn_edit_account;
    private javax.swing.JButton btn_edit_center_cancel;
    private javax.swing.JButton btn_edit_center_save;
    private javax.swing.JButton btn_edit_people_cancel;
    private javax.swing.JButton btn_edit_people_save;
    private javax.swing.JButton btn_edit_vaccination_appointments_cancel;
    private javax.swing.JButton btn_edit_vaccination_appointments_save;
    private javax.swing.JButton btn_edit_vaccine_cancel;
    private javax.swing.JButton btn_edit_vaccine_save;
    private javax.swing.JButton btn_people_edit;
    private javax.swing.JButton btn_people_register;
    private javax.swing.JButton btn_register_people_cancel;
    private javax.swing.JButton btn_register_people_register;
    private javax.swing.JButton btn_register_vaccination_appointments_cancel;
    private javax.swing.JButton btn_register_vaccination_appointments_register;
    private javax.swing.JButton btn_save_edit;
    private javax.swing.JButton btn_vaccination_appointments_edit;
    private javax.swing.JButton btn_vaccination_appointments_register;
    private javax.swing.JButton btn_vaccination_appointments_remove;
    private javax.swing.JButton btn_vaccination_appointments_update;
    private javax.swing.JButton btn_vaccination_center_add;
    private javax.swing.JButton btn_vaccination_center_edit;
    private javax.swing.JButton btn_vaccination_center_remove;
    private javax.swing.JButton btn_vaccine_add;
    private javax.swing.JButton btn_vaccine_edit;
    private javax.swing.JButton btn_vaccine_remove;
    private javax.swing.JComboBox<String> cbo_add_center_vaccine_type;
    private javax.swing.JComboBox<String> cbo_add_vaccine_center_name;
    private javax.swing.JComboBox<String> cbo_add_vaccine_type;
    private javax.swing.JComboBox<String> cbo_edit_people_nationality;
    private javax.swing.JComboBox<String> cbo_edit_vaccination_appointments_select_time;
    private javax.swing.JComboBox<String> cbo_edit_vaccination_appointments_select_vaccination_center;
    private javax.swing.JComboBox<String> cbo_edit_vaccine_center_name;
    private javax.swing.JComboBox<String> cbo_edit_vaccine_type;
    private javax.swing.JComboBox<String> cbo_register_people_nationality;
    private javax.swing.JComboBox<String> cbo_register_vaccination_appointments_select_time;
    private javax.swing.JComboBox<String> cbo_register_vaccination_appointments_select_vaccination_center;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_addVaccineSecondDoseGap;
    private javax.swing.JLabel lbl_add_center;
    private javax.swing.JLabel lbl_add_center_address;
    private javax.swing.JLabel lbl_add_center_contact_number;
    private javax.swing.JLabel lbl_add_center_name;
    private javax.swing.JLabel lbl_add_center_vaccine_type;
    private javax.swing.JLabel lbl_add_vaccine;
    private javax.swing.JLabel lbl_add_vaccine_batch_id;
    private javax.swing.JLabel lbl_add_vaccine_center_name;
    private javax.swing.JLabel lbl_add_vaccine_date;
    private javax.swing.JLabel lbl_add_vaccine_expiration_date;
    private javax.swing.JLabel lbl_add_vaccine_second_dose_gap;
    private javax.swing.JLabel lbl_add_vaccine_type;
    private javax.swing.JLabel lbl_editAccount;
    private javax.swing.JLabel lbl_editCenterId;
    private javax.swing.JLabel lbl_editPeople;
    private javax.swing.JLabel lbl_editVaccinationAppointmentsVaccineType;
    private javax.swing.JLabel lbl_editVaccineSecondDoseGap;
    private javax.swing.JLabel lbl_edit_address;
    private javax.swing.JLabel lbl_edit_center;
    private javax.swing.JLabel lbl_edit_center_address;
    private javax.swing.JLabel lbl_edit_center_contact_number;
    private javax.swing.JLabel lbl_edit_center_id;
    private javax.swing.JLabel lbl_edit_center_name;
    private javax.swing.JLabel lbl_edit_center_vaccine_type;
    private javax.swing.JLabel lbl_edit_center_vaccine_type_title;
    private javax.swing.JLabel lbl_edit_confirm_password;
    private javax.swing.JLabel lbl_edit_ic_passport_number;
    private javax.swing.JLabel lbl_edit_name;
    private javax.swing.JLabel lbl_edit_nationality;
    private javax.swing.JLabel lbl_edit_password;
    private javax.swing.JLabel lbl_edit_people__phone_number;
    private javax.swing.JLabel lbl_edit_people_address;
    private javax.swing.JLabel lbl_edit_people_confirm_password;
    private javax.swing.JLabel lbl_edit_people_ic_passport_number;
    private javax.swing.JLabel lbl_edit_people_name;
    private javax.swing.JLabel lbl_edit_people_nationaliy;
    private javax.swing.JLabel lbl_edit_people_password;
    private javax.swing.JLabel lbl_edit_phone_number;
    private javax.swing.JLabel lbl_edit_vaccination_appointments_ic_passport_number;
    private javax.swing.JLabel lbl_edit_vaccination_appointments_select_date;
    private javax.swing.JLabel lbl_edit_vaccination_appointments_select_time;
    private javax.swing.JLabel lbl_edit_vaccination_appointments_select_vaccination_center;
    private javax.swing.JLabel lbl_edit_vaccination_appointments_vaccine_type;
    private javax.swing.JLabel lbl_edit_vaccine;
    private javax.swing.JLabel lbl_edit_vaccine_batch_id;
    private javax.swing.JLabel lbl_edit_vaccine_center_name;
    private javax.swing.JLabel lbl_edit_vaccine_date;
    private javax.swing.JLabel lbl_edit_vaccine_expiration_date;
    private javax.swing.JLabel lbl_edit_vaccine_second_dose_gap;
    private javax.swing.JLabel lbl_edit_vaccine_type;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_myAccount;
    private javax.swing.JLabel lbl_my_account;
    private javax.swing.JLabel lbl_people;
    private javax.swing.JLabel lbl_registerPeople;
    private javax.swing.JLabel lbl_registerVaccinationAppointments;
    private javax.swing.JLabel lbl_registerVaccinationAppointments1;
    private javax.swing.JLabel lbl_registerVaccinationAppointmentsVaccineType;
    private javax.swing.JLabel lbl_register_people_address;
    private javax.swing.JLabel lbl_register_people_confirm_password;
    private javax.swing.JLabel lbl_register_people_ic_passport_number;
    private javax.swing.JLabel lbl_register_people_name;
    private javax.swing.JLabel lbl_register_people_nationaliy;
    private javax.swing.JLabel lbl_register_people_password;
    private javax.swing.JLabel lbl_register_people_phone_number;
    private javax.swing.JLabel lbl_register_vaccination_appointments_ic_passport_number;
    private javax.swing.JLabel lbl_register_vaccination_appointments_select_date;
    private javax.swing.JLabel lbl_register_vaccination_appointments_select_time;
    private javax.swing.JLabel lbl_register_vaccination_appointments_select_vaccination_center;
    private javax.swing.JLabel lbl_register_vaccination_appointments_vaccine_type;
    private javax.swing.JLabel lbl_search_people;
    private javax.swing.JLabel lbl_search_vaccination_appointments;
    private javax.swing.JLabel lbl_search_vaccination_center;
    private javax.swing.JLabel lbl_search_vaccine;
    private javax.swing.JLabel lbl_vaccination_appointments;
    private javax.swing.JLabel lbl_vaccination_center;
    private javax.swing.JLabel lbl_vaccine;
    private javax.swing.JTextArea lbl_view_address;
    private javax.swing.JLabel lbl_view_ic_passport_number;
    private javax.swing.JLabel lbl_view_name;
    private javax.swing.JLabel lbl_view_nationality;
    private javax.swing.JLabel lbl_view_people;
    private javax.swing.JLabel lbl_view_phone_number;
    private javax.swing.JLabel lbl_view_vaccination_appointments;
    private javax.swing.JLabel lbl_view_vaccination_center;
    private javax.swing.JLabel lbl_view_vaccine;
    private javax.swing.JPanel pnl_addCenter;
    private javax.swing.JPanel pnl_addVaccine;
    private javax.swing.JPanel pnl_add_center;
    private javax.swing.JPanel pnl_add_vaccine;
    private javax.swing.JPanel pnl_container;
    private javax.swing.JPanel pnl_editAccount;
    private javax.swing.JPanel pnl_editCenter;
    private javax.swing.JPanel pnl_editPeople;
    private javax.swing.JPanel pnl_editVaccinationAppointments;
    private javax.swing.JPanel pnl_editVaccine;
    private javax.swing.JPanel pnl_edit_account;
    private javax.swing.JPanel pnl_edit_center;
    private javax.swing.JPanel pnl_edit_people;
    private javax.swing.JPanel pnl_edit_vaccination_appointments;
    private javax.swing.JPanel pnl_edit_vaccine;
    private javax.swing.JPanel pnl_logout;
    private javax.swing.JPanel pnl_myAccount;
    private javax.swing.JPanel pnl_my_account;
    private javax.swing.JPanel pnl_people;
    private javax.swing.JPanel pnl_registerPeople;
    private javax.swing.JPanel pnl_registerVaccinationAppointments;
    private javax.swing.JPanel pnl_register_people;
    private javax.swing.JPanel pnl_register_vaccination_appointments;
    private javax.swing.JPanel pnl_sidenav;
    private javax.swing.JPanel pnl_vaccination_appointments;
    private javax.swing.JPanel pnl_vaccination_center;
    private javax.swing.JPanel pnl_vaccine;
    private javax.swing.JPanel pnl_viewPeople;
    private javax.swing.JPanel pnl_viewVaccinationAppointments;
    private javax.swing.JPanel pnl_viewVaccinationCenter;
    private javax.swing.JPanel pnl_viewVaccine;
    private javax.swing.JPanel pnl_view_account;
    private javax.swing.JPanel pnl_view_people;
    private javax.swing.JPanel pnl_view_vaccination_appointments;
    private javax.swing.JPanel pnl_view_vaccination_center;
    private javax.swing.JPanel pnl_view_vaccine;
    private javax.swing.JScrollPane scrpnl_view_vaccination_center;
    private javax.swing.JTable tbl_view_people;
    private javax.swing.JTable tbl_view_vaccination_appointments;
    private javax.swing.JTable tbl_view_vaccination_center;
    private javax.swing.JTable tbl_view_vaccine;
    private javax.swing.JTextField txt_add_center_address;
    private javax.swing.JTextField txt_add_center_contact_number;
    private javax.swing.JTextField txt_add_center_name;
    private javax.swing.JTextField txt_add_vaccine_batch_id;
    private com.toedter.calendar.JDateChooser txt_add_vaccine_date;
    private com.toedter.calendar.JDateChooser txt_add_vaccine_expiration_date;
    private javax.swing.JTextField txt_edit_address;
    private javax.swing.JTextField txt_edit_center_address;
    private javax.swing.JTextField txt_edit_center_contact_number;
    private javax.swing.JTextField txt_edit_center_name;
    private javax.swing.JPasswordField txt_edit_confirm_password;
    private javax.swing.JTextField txt_edit_ic_passport_number;
    private javax.swing.JTextField txt_edit_name;
    private javax.swing.JTextField txt_edit_nationality;
    private javax.swing.JPasswordField txt_edit_password;
    private javax.swing.JTextField txt_edit_people_address;
    private javax.swing.JPasswordField txt_edit_people_confirm_password;
    private javax.swing.JTextField txt_edit_people_ic_passport_number;
    private javax.swing.JTextField txt_edit_people_name;
    private javax.swing.JPasswordField txt_edit_people_password;
    private javax.swing.JTextField txt_edit_people_phone_number;
    private javax.swing.JTextField txt_edit_phone_number;
    private javax.swing.JTextField txt_edit_vaccination_appointments_ic_passport_number;
    private com.toedter.calendar.JDateChooser txt_edit_vaccination_appointments_select_date;
    private javax.swing.JTextField txt_edit_vaccine_batch_id;
    private com.toedter.calendar.JDateChooser txt_edit_vaccine_date;
    private com.toedter.calendar.JDateChooser txt_edit_vaccine_expiration_date;
    private javax.swing.JTextField txt_register_people_address;
    private javax.swing.JPasswordField txt_register_people_confirm_password;
    private javax.swing.JTextField txt_register_people_ic_passport_number;
    private javax.swing.JTextField txt_register_people_name;
    private javax.swing.JPasswordField txt_register_people_password;
    private javax.swing.JTextField txt_register_people_phone_number;
    private javax.swing.JTextField txt_register_vaccination_appointments_ic_passport_number;
    private com.toedter.calendar.JDateChooser txt_register_vaccination_appointments_select_date;
    private javax.swing.JTextField txt_search_people;
    private javax.swing.JTextField txt_search_vaccination_appointments;
    private javax.swing.JTextField txt_search_vaccination_center;
    private javax.swing.JTextField txt_search_vaccine;
    // End of variables declaration//GEN-END:variables

    private void OptionPaneExample() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }
}
