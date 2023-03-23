package vaccine.registration.system;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import javax.swing.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class People extends javax.swing.JFrame {

    //CitizenClass citizen_class = new CitizenClass();
    //NonCitizenClass noncitizen_class = new NonCitizenClass();
    ValidationClass validation_class = new ValidationClass();
    //CenterClass center_class = new CenterClass();
    //VaccineClass vaccine_class = new VaccineClass();
    AppointmentClass appointment_class = new AppointmentClass();

    // For formatting date
    SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();

    ArrayList<String[]> Appointment_Data = new ArrayList<>();

    // For validation
    Date appointment_date;
    boolean citizenship;

    //for record
    CitizenController citizenController = new CitizenController();
    Optional<CitizenRecord> citizenRecord;
    NonCitizenController nonCitizenController = new NonCitizenController();
    Optional<NonCitizenRecord> nonCitizenRecord;
    VaccineController vaccineController = new VaccineController();
    int People_ID;
    CenterController centerController = new CenterController();

    // People form
    public People() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_vaccination_appointment.setVisible(false);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(false);
    }

    public People(int people_id, boolean citizen) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_vaccination_appointment.setVisible(false);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(false);

        if (citizen == true) {
            //citizen_class.setPeople_ID(people_id);
            citizenship = true;
            //funcitonal
            People_ID = people_id;

        } else {
            //noncitizen_class.setPeople_ID(people_id);
            citizenship = false;
        }
    }

    // Clear input field
    public void Clear() {
        txt_select_date.setCalendar(null);
        lbl_vaccine_type.setText("");
        cbo_select_time.setSelectedIndex(-1);

        lbl_vaccination_center_1.setText("");
        lbl_center_address_1.setText("");
        lbl_center_contact_number_1.setText("");
        lbl_date_1.setText("");
        lbl_time_1.setText("");
        lbl_vaccine_type_1.setText("");

        lbl_vaccination_center_2.setText("");
        lbl_center_address_2.setText("");
        lbl_center_contact_number_2.setText("");
        lbl_date_2.setText("");
        lbl_time_2.setText("");
        lbl_vaccine_type_2.setText("");
    }

    // View account
    public void View() throws FileNotFoundException {
        // Insert data
        if (citizenship == true) {
            citizenRecord = citizenController.View_Account(People_ID);
//            citizen_class.View_Account();
            lbl_view_name.setText(citizenRecord.get().Name());
            lbl_view_phone_number.setText(citizenRecord.get().Phone_Number());
            lbl_view_nationality.setText(citizenRecord.get().Nationality());
            lbl_view_ic_passport_number.setText(citizenRecord.get().IC_Number());
            lbl_view_address.setText(citizenRecord.get().Address());
        } else {
//            noncitizen_class.View_Account();
//            lbl_view_name.setText(noncitizen_class.getName());
//            lbl_view_phone_number.setText(noncitizen_class.getPhone_Number());
//            lbl_view_nationality.setText(noncitizen_class.getNationality());
//            lbl_view_ic_passport_number.setText(noncitizen_class.getPassport_Number());
//            lbl_view_address.setText(noncitizen_class.getAddress());
        }
    }

    // View appointment
    public void View_Appointment() throws FileNotFoundException {
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_vaccination_appointment.setVisible(true);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(false);

        // Loop and display data
        Center_ID_and_Details();
        Vaccine_ID_and_Details();
        appointment_class.View_Appointment();
        Appointment_Data = new ArrayList<>();
        int index;
        String key;
        String[] data = null;

        if (citizenship == true) {
            try {
                citizenRecord = citizenController.View_Account(People_ID);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < appointment_class.getAppointment_Data().size(); i++) {
                data = appointment_class.getAppointment_Data().get(i).split("//");

                if (String.valueOf(People_ID).equals(data[1])) {
                    data[1] = String.valueOf(People_ID);

                    index = 2;
                    key = citizenRecord.get().Name();
                    String[] result = new String[data.length + 1];
                    System.arraycopy(data, 0, result, 0, index);
                    result[index] = key;
                    System.arraycopy(data, index, result, index + 1, data.length - index);
                    data = result;

                    index = 3;
                    key = citizenRecord.get().IC_Number();
                    result = new String[data.length + 1];
                    System.arraycopy(data, 0, result, 0, index);
                    result[index] = key;
                    System.arraycopy(data, index, result, index + 1, data.length - index);
                    data = result;

                    for (VaccineDetails vac : vaccine_id_and_details) {
                        if (vac.getId().equals(data[4])) {
                            data[4] = vac.getDate();
                            index = 6;
                            key = vac.getCenterID();
                            result = new String[data.length + 1];
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
                            index = 10;
                            key = center.getType();
                            result = new String[data.length + 1];
                            System.arraycopy(data, 0, result, 0, index);
                            result[index] = key;
                            System.arraycopy(data, index, result, index + 1, data.length - index);
                            data = result;

                            index = 11;
                            key = center.getContact();
                            result = new String[data.length + 1];
                            System.arraycopy(data, 0, result, 0, index);
                            result[index] = key;
                            System.arraycopy(data, index, result, index + 1, data.length - index);
                            data = result;
                        }
                    }
                    Appointment_Data.add(data);
                }
            }
        } else {
            nonCitizenRecord = nonCitizenController.View_Account(People_ID);
            for (int n = 0; n < appointment_class.getAppointment_Data().size(); n++) {
                data = appointment_class.getAppointment_Data().get(n).split("//");

                if (String.valueOf(nonCitizenRecord.get().People_ID()).equals(data[1])) {
                    data[1] = String.valueOf(nonCitizenRecord.get().People_ID());

                    index = 2;
                    key = nonCitizenRecord.get().Name();
                    String[] result = new String[data.length + 1];
                    System.arraycopy(data, 0, result, 0, index);
                    result[index] = key;
                    System.arraycopy(data, index, result, index + 1, data.length - index);
                    data = result;

                    index = 3;
                    key = nonCitizenRecord.get().Passport_Number();
                    result = new String[data.length + 1];
                    System.arraycopy(data, 0, result, 0, index);
                    result[index] = key;
                    System.arraycopy(data, index, result, index + 1, data.length - index);
                    data = result;

                    for (VaccineDetails vac : vaccine_id_and_details) {
                        if (vac.getId().equals(data[4])) {
                            data[4] = vac.getDate();
                            index = 6;
                            key = vac.getCenterID();
                            result = new String[data.length + 1];
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
                            index = 10;
                            key = center.getType();
                            result = new String[data.length + 1];
                            System.arraycopy(data, 0, result, 0, index);
                            result[index] = key;
                            System.arraycopy(data, index, result, index + 1, data.length - index);
                            data = result;

                            index = 11;
                            key = center.getContact();
                            result = new String[data.length + 1];
                            System.arraycopy(data, 0, result, 0, index);
                            result[index] = key;
                            System.arraycopy(data, index, result, index + 1, data.length - index);
                            data = result;
                        }
                    }
                    Appointment_Data.add(data);
                }
            }
        }

        for (String[] display : Appointment_Data) {
            if (display[8].equals("1")) {
                lbl_vaccination_center_1.setText(display[6]);
                lbl_center_address_1.setText(display[10]);
                lbl_center_contact_number_1.setText(display[11]);
                lbl_date_1.setText(display[4]);
                lbl_time_1.setText(display[5]);
                lbl_vaccine_type_1.setText(display[7]);
                appointment_class.setAppointnment_ID(Integer.valueOf(display[0]));

                try {
                    appointment_date = date_format.parse(display[4]);
                } catch (ParseException ex) {

                }
            } else if (display[8].equals("2")) {
                lbl_vaccination_center_2.setText(display[6]);
                lbl_center_address_2.setText(display[10]);
                lbl_center_contact_number_2.setText(display[11]);
                lbl_date_2.setText(display[4]);
                lbl_time_2.setText(display[5]);
                lbl_vaccine_type_2.setText(display[7]);
                appointment_class.setAppointnment_ID(Integer.valueOf(display[0]));

                try {
                    appointment_date = date_format.parse(display[4]);
                } catch (ParseException ex) {

                }
            }
        }
    }

    // For center to have id
    private class Center {

        private String id, name, type, contact;

        public Center(String id, String name, String type, String contact) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.contact = contact;
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

        public String getContact() {
            return contact;
        }

        public String toString() {
            return name;
        }
    }

    ArrayList<Center> center_id_to_name = new ArrayList<>();

    public void Center_ID_and_Details() throws FileNotFoundException {
        // Load data
        //center_class.View_Center();
        center_id_to_name.clear();

        // Loop and add data
        for (CenterRecord centerRecord : centerController.View_Center()) {
            String[] data = {Integer.toString(centerRecord.Center_ID()), centerRecord.Center_Name(), centerRecord.Center_Address(), centerRecord.Center_Contact_Number(), centerRecord.Vaccine_Type()};
            center_id_to_name.add(new Center(data[0], data[1], data[2], data[3]));
        }
    }

    // View center
    public void View_Center() throws FileNotFoundException {
        // Load data
        //center_class.View_Center();

        // Set column
        String columns[] = {"Center ID", "Center Name", "Center Address", "Contact Number", "Vaccine Type"};
        DefaultTableModel center_table_model = (DefaultTableModel) tbl_vaccination_status.getModel();
        center_table_model.setColumnIdentifiers(columns);

        // Remove ID column
        tbl_vaccination_status.removeColumn(tbl_vaccination_status.getColumnModel().getColumn(0));
        tbl_vaccination_status.setModel(center_table_model);
        center_table_model.setRowCount(0);

        // Loop and display data
        for (CenterRecord centerRecord : centerController.View_Center()) {
            String[] data = {Integer.toString(centerRecord.Center_ID()), centerRecord.Center_Name(), centerRecord.Center_Address(), centerRecord.Center_Contact_Number(), centerRecord.Vaccine_Type()};
            center_table_model.addRow(data);
        }

        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_vaccination_appointment.setVisible(false);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(true);
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

    public void Vaccine_ID_and_Details() throws FileNotFoundException {
        // Load data
        //vaccine_class.View_Vaccine();
        vaccine_id_and_details.clear();
        // Loop and add data
        for (VaccineRecord vaccineRecord : vaccineController.View_Vaccine()) {
            String[] data = {Integer.toString(vaccineRecord.Vaccine_ID()), vaccineRecord.Vaccine_Batch_ID(), vaccineRecord.Vaccine_Type(), vaccineRecord.date(), vaccineRecord.Expiration_Date(), Integer.toString(vaccineRecord.Second_Dose_Gap()), Integer.toString(vaccineRecord.Center_ID())};
            vaccine_id_and_details.add(new VaccineDetails(data[0], data[3], data[2], data[6]));
        }
    }

    // UI
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_sidenav = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        pnl_my_account = new javax.swing.JPanel();
        lbl_my_account = new javax.swing.JLabel();
        pnl_vaccination_appointment = new javax.swing.JPanel();
        lbl_vaccination_appointment = new javax.swing.JLabel();
        pnl_vaccination_status = new javax.swing.JPanel();
        lbl_vaccination_status = new javax.swing.JLabel();
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
        lbl_view_address = new javax.swing.JTextArea();
        btn_edit_account = new javax.swing.JButton();
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
        btn_edit_save = new javax.swing.JButton();
        btn_edit_cancel = new javax.swing.JButton();
        pnl_view_vaccination_appointment = new javax.swing.JPanel();
        pnl_vaccinationAppoitment = new javax.swing.JPanel();
        lbl_vaccinationAppointment = new javax.swing.JLabel();
        lbl_1st_dose_appointment = new javax.swing.JLabel();
        lbl_vaccinationCenter1 = new javax.swing.JLabel();
        lbl_vaccination_center_1 = new javax.swing.JLabel();
        lbl_centerAddress1 = new javax.swing.JLabel();
        lbl_center_address_1 = new javax.swing.JLabel();
        lbl_centerContactNumber1 = new javax.swing.JLabel();
        lbl_center_contact_number_1 = new javax.swing.JLabel();
        lbl_date1 = new javax.swing.JLabel();
        lbl_date_1 = new javax.swing.JLabel();
        lbl_time1 = new javax.swing.JLabel();
        lbl_time_1 = new javax.swing.JLabel();
        lbl_vaccineType1 = new javax.swing.JLabel();
        lbl_vaccine_type_1 = new javax.swing.JLabel();
        lbl_2nd_dose_appointment = new javax.swing.JLabel();
        lbl_vaccinationCenter2 = new javax.swing.JLabel();
        lbl_vaccination_center_2 = new javax.swing.JLabel();
        lbl_centerAddress2 = new javax.swing.JLabel();
        lbl_center_address_2 = new javax.swing.JLabel();
        lbl_centerContactNumber2 = new javax.swing.JLabel();
        lbl_center_contact_number_2 = new javax.swing.JLabel();
        lbl_date2 = new javax.swing.JLabel();
        lbl_date_2 = new javax.swing.JLabel();
        lbl_time2 = new javax.swing.JLabel();
        lbl_time_2 = new javax.swing.JLabel();
        lbl_vaccineType2 = new javax.swing.JLabel();
        lbl_vaccine_type_2 = new javax.swing.JLabel();
        btn_register_appointment = new javax.swing.JButton();
        btn_cancel_appointment = new javax.swing.JButton();
        pnl_register_vaccination_appointment = new javax.swing.JPanel();
        pnl_registerVaccinationAppointment = new javax.swing.JPanel();
        lbl_registerVaccinationAppointment = new javax.swing.JLabel();
        lbl_select_date = new javax.swing.JLabel();
        txt_select_date = new com.toedter.calendar.JDateChooser();
        lbl_select_time = new javax.swing.JLabel();
        cbo_select_time = new javax.swing.JComboBox<>();
        lbl_select_vaccination_center = new javax.swing.JLabel();
        cbo_select_vaccination_center = new javax.swing.JComboBox<>();
        lbl_vaccineType = new javax.swing.JLabel();
        lbl_vaccine_type = new javax.swing.JLabel();
        btn_register_vaccination_appointment_register = new javax.swing.JButton();
        btn_register_vaccination_appointment_cancel = new javax.swing.JButton();
        pnl_view_vaccination_status = new javax.swing.JPanel();
        pnl_vaccinationStatus = new javax.swing.JPanel();
        lbl_vaccinationStatus = new javax.swing.JLabel();
        lbl_search_vaccination_status = new javax.swing.JLabel();
        txt_search_vaccination_status = new javax.swing.JTextField();
        scrpnl_vaccination_status = new javax.swing.JScrollPane();
        tbl_vaccination_status = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("People");

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

        pnl_vaccination_appointment.setBackground(new java.awt.Color(127, 163, 198));

        lbl_vaccination_appointment.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_vaccination_appointment.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vaccination_appointment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_vaccination_appointment.setText("Vaccination Appointment");
        lbl_vaccination_appointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_vaccination_appointmentMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_vaccination_appointmentLayout = new javax.swing.GroupLayout(pnl_vaccination_appointment);
        pnl_vaccination_appointment.setLayout(pnl_vaccination_appointmentLayout);
        pnl_vaccination_appointmentLayout.setHorizontalGroup(
            pnl_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_vaccination_appointment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_vaccination_appointmentLayout.setVerticalGroup(
            pnl_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_vaccination_appointment, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_vaccination_status.setBackground(new java.awt.Color(127, 163, 198));

        lbl_vaccination_status.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_vaccination_status.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vaccination_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_vaccination_status.setText("Vaccination Status");
        lbl_vaccination_status.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_vaccination_statusMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_vaccination_statusLayout = new javax.swing.GroupLayout(pnl_vaccination_status);
        pnl_vaccination_status.setLayout(pnl_vaccination_statusLayout);
        pnl_vaccination_statusLayout.setHorizontalGroup(
            pnl_vaccination_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_vaccination_status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_vaccination_statusLayout.setVerticalGroup(
            pnl_vaccination_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_vaccination_status, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
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
            .addComponent(pnl_vaccination_appointment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_vaccination_status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_sidenavLayout.createSequentialGroup()
                .addComponent(pnl_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_sidenavLayout.setVerticalGroup(
            pnl_sidenavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_sidenavLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(pnl_my_account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pnl_vaccination_appointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pnl_vaccination_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pnl_container.setBackground(new java.awt.Color(204, 204, 204));
        pnl_container.setPreferredSize(new java.awt.Dimension(960, 720));

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
                .addContainerGap(334, Short.MAX_VALUE)
                .addComponent(lbl_myAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
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

        lbl_view_address.setEditable(false);
        lbl_view_address.setColumns(20);
        lbl_view_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_view_address.setLineWrap(true);
        lbl_view_address.setRows(5);
        lbl_view_address.setWrapStyleWord(true);
        lbl_view_address.setBorder(null);

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

        javax.swing.GroupLayout pnl_view_accountLayout = new javax.swing.GroupLayout(pnl_view_account);
        pnl_view_account.setLayout(pnl_view_accountLayout);
        pnl_view_accountLayout.setHorizontalGroup(
            pnl_view_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_myAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_view_accountLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_view_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_edit_account, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_view_nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_view_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_view_name, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_view_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_view_address, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_view_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lbl_view_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btn_edit_account, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
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
                .addContainerGap(334, Short.MAX_VALUE)
                .addComponent(lbl_editAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
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

        btn_edit_save.setBackground(new java.awt.Color(73, 161, 236));
        btn_edit_save.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_edit_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit_save.setText("Save");
        btn_edit_save.setBorder(null);
        btn_edit_save.setOpaque(true);
        btn_edit_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_saveActionPerformed(evt);
            }
        });

        btn_edit_cancel.setBackground(new java.awt.Color(221, 98, 98));
        btn_edit_cancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_edit_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit_cancel.setText("Cancel");
        btn_edit_cancel.setBorder(null);
        btn_edit_cancel.setOpaque(true);
        btn_edit_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_cancelActionPerformed(evt);
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
                    .addComponent(txt_edit_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_edit_confirm_password, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_edit_password)
                    .addComponent(txt_edit_password, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_edit_nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_edit_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_edit_name, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_edit_confirm_password)
                    .addComponent(lbl_edit_name)
                    .addComponent(lbl_edit_phone_number)
                    .addComponent(lbl_edit_nationality)
                    .addComponent(lbl_edit_ic_passport_number)
                    .addComponent(lbl_edit_address)
                    .addGroup(pnl_edit_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnl_edit_accountLayout.createSequentialGroup()
                            .addComponent(btn_edit_save, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_edit_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txt_edit_address, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(11, 11, 11)
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
                    .addComponent(btn_edit_save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pnl_view_vaccination_appointment.setBackground(new java.awt.Color(255, 255, 255));
        pnl_view_vaccination_appointment.setPreferredSize(new java.awt.Dimension(960, 720));
        pnl_view_vaccination_appointment.setRequestFocusEnabled(false);

        pnl_vaccinationAppoitment.setBackground(new java.awt.Color(136, 178, 219));

        lbl_vaccinationAppointment.setBackground(new java.awt.Color(255, 255, 255));
        lbl_vaccinationAppointment.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_vaccinationAppointment.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vaccinationAppointment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_vaccinationAppointment.setText("Vaccination Appointment");

        javax.swing.GroupLayout pnl_vaccinationAppoitmentLayout = new javax.swing.GroupLayout(pnl_vaccinationAppoitment);
        pnl_vaccinationAppoitment.setLayout(pnl_vaccinationAppoitmentLayout);
        pnl_vaccinationAppoitmentLayout.setHorizontalGroup(
            pnl_vaccinationAppoitmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_vaccinationAppoitmentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_vaccinationAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_vaccinationAppoitmentLayout.setVerticalGroup(
            pnl_vaccinationAppoitmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_vaccinationAppoitmentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_vaccinationAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        lbl_1st_dose_appointment.setBackground(new java.awt.Color(255, 255, 255));
        lbl_1st_dose_appointment.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_1st_dose_appointment.setText("1st Dose Appointment");

        lbl_vaccinationCenter1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_vaccinationCenter1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_vaccinationCenter1.setText("Vaccination Center");

        lbl_vaccination_center_1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_vaccination_center_1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_vaccination_center_1.setForeground(new java.awt.Color(119, 119, 119));

        lbl_centerAddress1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_centerAddress1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_centerAddress1.setText("Center Address");

        lbl_center_address_1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_center_address_1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_center_address_1.setForeground(new java.awt.Color(119, 119, 119));

        lbl_centerContactNumber1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_centerContactNumber1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_centerContactNumber1.setText("Center Contact Number");

        lbl_center_contact_number_1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_center_contact_number_1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_center_contact_number_1.setForeground(new java.awt.Color(119, 119, 119));

        lbl_date1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_date1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_date1.setText("Date");

        lbl_date_1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_date_1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_date_1.setForeground(new java.awt.Color(119, 119, 119));

        lbl_time1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_time1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_time1.setText("Time");

        lbl_time_1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_time_1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_time_1.setForeground(new java.awt.Color(119, 119, 119));

        lbl_vaccineType1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_vaccineType1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_vaccineType1.setText("Vaccine Type");

        lbl_vaccine_type_1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_vaccine_type_1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_vaccine_type_1.setForeground(new java.awt.Color(119, 119, 119));

        lbl_2nd_dose_appointment.setBackground(new java.awt.Color(255, 255, 255));
        lbl_2nd_dose_appointment.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_2nd_dose_appointment.setText("2nd Dose Appointment");

        lbl_vaccinationCenter2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_vaccinationCenter2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_vaccinationCenter2.setText("Vaccination Center");

        lbl_vaccination_center_2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_vaccination_center_2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_vaccination_center_2.setForeground(new java.awt.Color(119, 119, 119));

        lbl_centerAddress2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_centerAddress2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_centerAddress2.setText("Center Address");

        lbl_center_address_2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_center_address_2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_center_address_2.setForeground(new java.awt.Color(119, 119, 119));

        lbl_centerContactNumber2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_centerContactNumber2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_centerContactNumber2.setText("Center Contact Number");

        lbl_center_contact_number_2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_center_contact_number_2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_center_contact_number_2.setForeground(new java.awt.Color(119, 119, 119));

        lbl_date2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_date2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_date2.setText("Date");

        lbl_date_2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_date_2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_date_2.setForeground(new java.awt.Color(119, 119, 119));

        lbl_time2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_time2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_time2.setText("Time");

        lbl_time_2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_time_2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_time_2.setForeground(new java.awt.Color(119, 119, 119));

        lbl_vaccineType2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_vaccineType2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_vaccineType2.setText("Vaccine Type");

        lbl_vaccine_type_2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_vaccine_type_2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_vaccine_type_2.setForeground(new java.awt.Color(119, 119, 119));

        btn_register_appointment.setBackground(new java.awt.Color(73, 161, 236));
        btn_register_appointment.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_register_appointment.setForeground(new java.awt.Color(255, 255, 255));
        btn_register_appointment.setText("Register Appointment");
        btn_register_appointment.setBorder(null);
        btn_register_appointment.setOpaque(true);
        btn_register_appointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_register_appointmentActionPerformed(evt);
            }
        });

        btn_cancel_appointment.setBackground(new java.awt.Color(221, 98, 98));
        btn_cancel_appointment.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_cancel_appointment.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancel_appointment.setText("Cancel Appointment");
        btn_cancel_appointment.setBorder(null);
        btn_cancel_appointment.setOpaque(true);
        btn_cancel_appointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancel_appointmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_view_vaccination_appointmentLayout = new javax.swing.GroupLayout(pnl_view_vaccination_appointment);
        pnl_view_vaccination_appointment.setLayout(pnl_view_vaccination_appointmentLayout);
        pnl_view_vaccination_appointmentLayout.setHorizontalGroup(
            pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_vaccinationAppoitment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_view_vaccination_appointmentLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_view_vaccination_appointmentLayout.createSequentialGroup()
                        .addComponent(btn_register_appointment, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(btn_cancel_appointment, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_view_vaccination_appointmentLayout.createSequentialGroup()
                        .addComponent(lbl_1st_dose_appointment, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(lbl_2nd_dose_appointment, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_view_vaccination_appointmentLayout.createSequentialGroup()
                        .addGroup(pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_center_address_1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_date_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_time1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_vaccination_center_1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_vaccinationCenter1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_centerAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_centerContactNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_center_contact_number_1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_time_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_vaccineType1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_vaccine_type_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnl_view_vaccination_appointmentLayout.createSequentialGroup()
                                    .addGap(88, 88, 88)
                                    .addGroup(pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_time_2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_time2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_date_2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_date2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_center_contact_number_2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_centerContactNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_center_address_2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_centerAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(lbl_vaccinationCenter2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_vaccination_center_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_vaccine_type_2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_vaccineType2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnl_view_vaccination_appointmentLayout.setVerticalGroup(
            pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_view_vaccination_appointmentLayout.createSequentialGroup()
                .addComponent(pnl_vaccinationAppoitment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_1st_dose_appointment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_2nd_dose_appointment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_vaccinationCenter2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_vaccinationCenter1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_view_vaccination_appointmentLayout.createSequentialGroup()
                        .addComponent(lbl_vaccination_center_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_centerAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_center_address_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_centerContactNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_center_contact_number_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_date2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_date_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_time2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_time_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_view_vaccination_appointmentLayout.createSequentialGroup()
                        .addComponent(lbl_vaccination_center_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_centerAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_center_address_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_centerContactNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_center_contact_number_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_date1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_date_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_time1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_time_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_view_vaccination_appointmentLayout.createSequentialGroup()
                        .addComponent(lbl_vaccineType1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_vaccine_type_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_view_vaccination_appointmentLayout.createSequentialGroup()
                        .addComponent(lbl_vaccineType2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_vaccine_type_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(pnl_view_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_register_appointment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel_appointment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnl_register_vaccination_appointment.setBackground(new java.awt.Color(255, 255, 255));
        pnl_register_vaccination_appointment.setMinimumSize(new java.awt.Dimension(274, 0));

        pnl_registerVaccinationAppointment.setBackground(new java.awt.Color(136, 178, 219));

        lbl_registerVaccinationAppointment.setBackground(new java.awt.Color(255, 255, 255));
        lbl_registerVaccinationAppointment.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_registerVaccinationAppointment.setForeground(new java.awt.Color(255, 255, 255));
        lbl_registerVaccinationAppointment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_registerVaccinationAppointment.setText("Register Vaccination Appointment");

        javax.swing.GroupLayout pnl_registerVaccinationAppointmentLayout = new javax.swing.GroupLayout(pnl_registerVaccinationAppointment);
        pnl_registerVaccinationAppointment.setLayout(pnl_registerVaccinationAppointmentLayout);
        pnl_registerVaccinationAppointmentLayout.setHorizontalGroup(
            pnl_registerVaccinationAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_registerVaccinationAppointmentLayout.createSequentialGroup()
                .addContainerGap(334, Short.MAX_VALUE)
                .addComponent(lbl_registerVaccinationAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        pnl_registerVaccinationAppointmentLayout.setVerticalGroup(
            pnl_registerVaccinationAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_registerVaccinationAppointmentLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_registerVaccinationAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_select_date.setBackground(new java.awt.Color(255, 255, 255));
        lbl_select_date.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_select_date.setText("Select Date");

        txt_select_date.setBackground(new java.awt.Color(255, 255, 255));
        txt_select_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        txt_select_date.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_select_datePropertyChange(evt);
            }
        });

        lbl_select_time.setBackground(new java.awt.Color(255, 255, 255));
        lbl_select_time.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_select_time.setText("Select Time");

        cbo_select_time.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cbo_select_time.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM" }));

        lbl_select_vaccination_center.setBackground(new java.awt.Color(255, 255, 255));
        lbl_select_vaccination_center.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_select_vaccination_center.setText("Select Vaccination Center");

        cbo_select_vaccination_center.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cbo_select_vaccination_center.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Vaccination Center" }));
        cbo_select_vaccination_center.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_select_vaccination_centerActionPerformed(evt);
            }
        });

        lbl_vaccineType.setBackground(new java.awt.Color(255, 255, 255));
        lbl_vaccineType.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_vaccineType.setText("Vaccine Type");

        lbl_vaccine_type.setBackground(new java.awt.Color(255, 255, 255));
        lbl_vaccine_type.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_vaccine_type.setForeground(new java.awt.Color(119, 119, 119));

        btn_register_vaccination_appointment_register.setBackground(new java.awt.Color(73, 161, 236));
        btn_register_vaccination_appointment_register.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_register_vaccination_appointment_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_register_vaccination_appointment_register.setText("Register");
        btn_register_vaccination_appointment_register.setBorder(null);
        btn_register_vaccination_appointment_register.setOpaque(true);
        btn_register_vaccination_appointment_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_register_vaccination_appointment_registerActionPerformed(evt);
            }
        });

        btn_register_vaccination_appointment_cancel.setBackground(new java.awt.Color(221, 98, 98));
        btn_register_vaccination_appointment_cancel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_register_vaccination_appointment_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_register_vaccination_appointment_cancel.setText("Cancel");
        btn_register_vaccination_appointment_cancel.setBorder(null);
        btn_register_vaccination_appointment_cancel.setOpaque(true);
        btn_register_vaccination_appointment_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_register_vaccination_appointment_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_register_vaccination_appointmentLayout = new javax.swing.GroupLayout(pnl_register_vaccination_appointment);
        pnl_register_vaccination_appointment.setLayout(pnl_register_vaccination_appointmentLayout);
        pnl_register_vaccination_appointmentLayout.setHorizontalGroup(
            pnl_register_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_registerVaccinationAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_register_vaccination_appointmentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_register_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_select_time, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_select_time, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_select_date, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_select_date, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_select_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_select_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_vaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_register_vaccination_appointmentLayout.createSequentialGroup()
                        .addComponent(btn_register_vaccination_appointment_register, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_register_vaccination_appointment_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_register_vaccination_appointmentLayout.setVerticalGroup(
            pnl_register_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_register_vaccination_appointmentLayout.createSequentialGroup()
                .addComponent(pnl_registerVaccinationAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(lbl_select_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_select_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_select_time, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_select_time, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_select_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_select_vaccination_center, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_vaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_vaccine_type, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(pnl_register_vaccination_appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_register_vaccination_appointment_register, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_register_vaccination_appointment_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pnl_view_vaccination_status.setBackground(new java.awt.Color(255, 255, 255));

        pnl_vaccinationStatus.setBackground(new java.awt.Color(136, 178, 219));

        lbl_vaccinationStatus.setBackground(new java.awt.Color(255, 255, 255));
        lbl_vaccinationStatus.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        lbl_vaccinationStatus.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vaccinationStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_vaccinationStatus.setText("Vaccination Status");

        javax.swing.GroupLayout pnl_vaccinationStatusLayout = new javax.swing.GroupLayout(pnl_vaccinationStatus);
        pnl_vaccinationStatus.setLayout(pnl_vaccinationStatusLayout);
        pnl_vaccinationStatusLayout.setHorizontalGroup(
            pnl_vaccinationStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_vaccinationStatusLayout.createSequentialGroup()
                .addContainerGap(334, Short.MAX_VALUE)
                .addComponent(lbl_vaccinationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        pnl_vaccinationStatusLayout.setVerticalGroup(
            pnl_vaccinationStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_vaccinationStatusLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_vaccinationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_search_vaccination_status.setBackground(new java.awt.Color(255, 255, 255));
        lbl_search_vaccination_status.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_search_vaccination_status.setText("Search Vaccination Status");

        txt_search_vaccination_status.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_search_vaccination_status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        txt_search_vaccination_status.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search_vaccination_statusKeyReleased(evt);
            }
        });

        tbl_vaccination_status.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbl_vaccination_status.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Vaccination Center", "Vaccine Type", "No. of Available Vaccine"
            }
        )

        {public boolean isCellEditable(int row, int column){return false;}}

    );
    scrpnl_vaccination_status.setViewportView(tbl_vaccination_status);

    javax.swing.GroupLayout pnl_view_vaccination_statusLayout = new javax.swing.GroupLayout(pnl_view_vaccination_status);
    pnl_view_vaccination_status.setLayout(pnl_view_vaccination_statusLayout);
    pnl_view_vaccination_statusLayout.setHorizontalGroup(
        pnl_view_vaccination_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_view_vaccination_statusLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pnl_view_vaccination_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_search_vaccination_status)
                .addComponent(scrpnl_vaccination_status)
                .addComponent(txt_search_vaccination_status))
            .addContainerGap())
        .addComponent(pnl_vaccinationStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    pnl_view_vaccination_statusLayout.setVerticalGroup(
        pnl_view_vaccination_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnl_view_vaccination_statusLayout.createSequentialGroup()
            .addComponent(pnl_vaccinationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(40, 40, 40)
            .addComponent(lbl_search_vaccination_status)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txt_search_vaccination_status, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(scrpnl_vaccination_status, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(93, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout pnl_containerLayout = new javax.swing.GroupLayout(pnl_container);
    pnl_container.setLayout(pnl_containerLayout);
    pnl_containerLayout.setHorizontalGroup(
        pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_view_account, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_view_vaccination_appointment, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_edit_account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_view_vaccination_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_register_vaccination_appointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnl_containerLayout.setVerticalGroup(
        pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_view_account, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_view_vaccination_appointment, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_edit_account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_view_vaccination_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)))
        .addGroup(pnl_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_register_vaccination_appointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(pnl_sidenav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(pnl_container, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnl_sidenav, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        .addComponent(pnl_container, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // My account side bar tab
    private void lbl_my_accountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_my_accountMouseClicked
        try {
            View();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
        }
        pnl_view_account.setVisible(true);
        pnl_edit_account.setVisible(false);
        pnl_view_vaccination_appointment.setVisible(false);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(false);
    }//GEN-LAST:event_lbl_my_accountMouseClicked

    // Edit account button
    private void btn_edit_accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_accountActionPerformed
        // View data
        if (citizenship == true) {
            try {
                //citizen_class.View_Account();
                citizenRecord = citizenController.View_Account(People_ID);
                txt_edit_name.setText(citizenRecord.get().Name());
                txt_edit_phone_number.setText(citizenRecord.get().Phone_Number());
                txt_edit_nationality.setText(citizenRecord.get().Nationality());
                txt_edit_ic_passport_number.setText(citizenRecord.get().IC_Number());
                txt_edit_address.setText(citizenRecord.get().Address());
                txt_edit_password.setText(citizenRecord.get().Password());
                txt_edit_confirm_password.setText(citizenRecord.get().Password());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                //citizen_class.View_Account();
                nonCitizenRecord = nonCitizenController.View_Account(People_ID);
                txt_edit_name.setText(nonCitizenRecord.get().Name());
                txt_edit_phone_number.setText(nonCitizenRecord.get().Phone_Number());
                txt_edit_nationality.setText(nonCitizenRecord.get().Nationality());
                txt_edit_ic_passport_number.setText(nonCitizenRecord.get().Passport_Number());
                txt_edit_address.setText(nonCitizenRecord.get().Address());
                txt_edit_password.setText(nonCitizenRecord.get().Password());
                txt_edit_confirm_password.setText(nonCitizenRecord.get().Password());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(true);
        pnl_view_vaccination_appointment.setVisible(false);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(false);
    }//GEN-LAST:event_btn_edit_accountActionPerformed

    // Vaccination appointment side bar tab
    private void lbl_vaccination_appointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_vaccination_appointmentMouseClicked
        Clear();
        try {
            View_Appointment();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbl_vaccination_appointmentMouseClicked

    // Register vaccination appointment button
    private void btn_register_appointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_appointmentActionPerformed
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_vaccination_appointment.setVisible(false);
        pnl_register_vaccination_appointment.setVisible(true);
        pnl_view_vaccination_status.setVisible(false);
    }//GEN-LAST:event_btn_register_appointmentActionPerformed

    // Cancel edit account button
    private void btn_edit_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_cancelActionPerformed
        Clear();
        pnl_view_account.setVisible(true);
        pnl_edit_account.setVisible(false);
        pnl_view_vaccination_appointment.setVisible(false);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(false);
    }//GEN-LAST:event_btn_edit_cancelActionPerformed

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
    private void btn_register_vaccination_appointment_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_vaccination_appointment_cancelActionPerformed
        Clear();
        try {
            View_Appointment();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_register_vaccination_appointment_cancelActionPerformed

    // Vaccination status side bar tab
    private void lbl_vaccination_statusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_vaccination_statusMouseClicked
        try {
            View_Center();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbl_vaccination_statusMouseClicked

    // Save edit account button
    private void btn_edit_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_saveActionPerformed
        if (txt_edit_name.getText().equals("") || txt_edit_phone_number.getText().equals("") || txt_edit_address.getText().equals("") || txt_edit_password.getPassword().length == 0 || txt_edit_confirm_password.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validateName(txt_edit_name.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("name"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validatePhoneNumber(txt_edit_phone_number.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("phone_number"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validateICPassportNumber(txt_edit_ic_passport_number.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("ic_passport_number"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!txt_edit_password.getText().matches(txt_edit_confirm_password.getText())) {
            JOptionPane.showMessageDialog(null, "Password not match.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (txt_edit_nationality.getText().equals("Malaysia")) {
                CitizenRecord edit = new CitizenRecord(People_ID, txt_edit_name.getText(), txt_edit_phone_number.getText(), txt_edit_nationality.getText(), txt_edit_ic_passport_number.getText(), txt_edit_address.getText(), txt_edit_password.getText());
                try {
                    if (citizenController.Edit_Account(edit)) {
                        try {
                            View();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        pnl_view_account.setVisible(true);
                        pnl_edit_account.setVisible(false);
                        pnl_view_vaccination_appointment.setVisible(false);
                        pnl_register_vaccination_appointment.setVisible(false);
                        pnl_view_vaccination_status.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Account updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update account.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                NonCitizenRecord edit = new NonCitizenRecord(People_ID, txt_edit_name.getText(), txt_edit_phone_number.getText(), txt_edit_nationality.getText(), txt_edit_ic_passport_number.getText(), txt_edit_address.getText(), txt_edit_password.getText());
                try {
                    if (nonCitizenController.Edit_Account(edit)) {
                        try {
                            View();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        pnl_view_account.setVisible(true);
                        pnl_edit_account.setVisible(false);
                        pnl_view_vaccination_appointment.setVisible(false);
                        pnl_register_vaccination_appointment.setVisible(false);
                        pnl_view_vaccination_status.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Account updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update account.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_edit_saveActionPerformed

    // Save register vaccination appointment button
    private void btn_register_vaccination_appointment_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_vaccination_appointment_registerActionPerformed
        try {
            if (cbo_select_vaccination_center.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "The selected date does not have a center. \nPlease select another date.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                if (cbo_select_time.getSelectedItem().equals("Select Time")
                        || cbo_select_vaccination_center.getSelectedItem().equals("Select Vaccination Center")
                        || cbo_select_vaccination_center.getSelectedItem().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (txt_select_date.getDate().compareTo(date) < 0) {
                        JOptionPane.showMessageDialog(null, validation_class.validationMessage("date"), "Warning", JOptionPane.WARNING_MESSAGE);
                    } else if (cbo_select_vaccination_center.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, validation_class.validationMessage("center"), "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        appointment_class.calculateAppointnment_ID();
                        if (citizenship == true) {
                            appointment_class.Check_Exist(citizenController.View_Account(People_ID).get().IC_Number());
                        } else {
                            appointment_class.Check_Exist(nonCitizenController.View_Account(People_ID).get().Passport_Number());
                        }
                        appointment_class.Add_Dose();

                        // Set vaccine ID
                        Center selected_item = (Center) cbo_select_vaccination_center.getSelectedItem();
                        appointment_class.Add_Vaccine_Id(date_format.format(txt_select_date.getDate()), selected_item.getId());
                        appointment_class.setAppointment_Time(cbo_select_time.getSelectedItem().toString());
                        appointment_class.Add_Dose();
                        appointment_class.setStatus("Pending");
                        appointment_class.Add_Appointment();

                        if (appointment_class.getSuccess_Save() == true) {
                            JOptionPane.showMessageDialog(null, "Vaccination appointment registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            Clear();
                            View_Appointment();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to register vaccination appointment. \nPossible issue: \n- More than 2 appointment for this people.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_register_vaccination_appointment_registerActionPerformed

    // Cancel vaccination appointment button
    private void btn_cancel_appointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancel_appointmentActionPerformed
        try {
            if (appointment_date.compareTo(date) < 0) {
                JOptionPane.showMessageDialog(null, "Could not cancel appointment as appointment is today or older.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int return_value = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel your appoitment on "
                        + date_format.format(appointment_date) + " ?", "Warning", JOptionPane.YES_NO_OPTION);

                if (return_value == JOptionPane.YES_OPTION) {
                    appointment_class.Remove_Appointment();
                    if (appointment_class.getSuccess_Save() == true) {
                        JOptionPane.showMessageDialog(null, "Vaccination appointment canceled successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        Clear();
                        View_Appointment();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to cancel vaccination appointmment.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (return_value == JOptionPane.NO_OPTION) {

                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No vaccination appointmment available to cancel.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_cancel_appointmentActionPerformed

    // Search vaccination status
    private void txt_search_vaccination_statusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_vaccination_statusKeyReleased
        DefaultTableModel center_table_model = (DefaultTableModel) tbl_vaccination_status.getModel();
        TableRowSorter<DefaultTableModel> search_center = new TableRowSorter<DefaultTableModel>(center_table_model);
        tbl_vaccination_status.setRowSorter(search_center);
        search_center.setRowFilter(RowFilter.regexFilter(txt_search_vaccination_status.getText()));
    }//GEN-LAST:event_txt_search_vaccination_statusKeyReleased

    // Select date
    private void txt_select_datePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_select_datePropertyChange
        try {
            if (txt_select_date.getDate() == null) {
                cbo_select_vaccination_center.setEnabled(false);
            } else {
                cbo_select_vaccination_center.setEnabled(true);
                appointment_class.Show_Locations(date_format.format(txt_select_date.getDate()));
                cbo_select_vaccination_center.removeAllItems();
                //center_class.View_Center();
                DefaultComboBoxModel cbo_edit_model = (DefaultComboBoxModel) cbo_select_vaccination_center.getModel();

                for (int i = 0; i < appointment_class.getAvaliableLocation().size(); i++) {
                    String[] data = appointment_class.getAvaliableLocation().get(i).split("//");

                    String temp = "", ww;
                    ww = data[6];

                    for (CenterRecord centerRecord : centerController.View_Center()) {
                        String[] name = {Integer.toString(centerRecord.Center_ID()), centerRecord.Center_Name(), centerRecord.Center_Address(), centerRecord.Center_Contact_Number(), centerRecord.Vaccine_Type()};

                        if (name[0].equals(ww)) {
                            temp = name[1];
                        }
                    }
                    cbo_edit_model.addElement(new Center(data[6], temp, data[2], data[3]));
                }
                cbo_select_vaccination_center.setModel(cbo_edit_model);
            }
        } catch (NullPointerException e) {

        } catch (FileNotFoundException ex) {
            Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_select_datePropertyChange

    // Select vaccination center
    private void cbo_select_vaccination_centerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_select_vaccination_centerActionPerformed
        try {
            Center_ID_and_Details();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(People.class.getName()).log(Level.SEVERE, null, ex);
        }
        Center selected_item = (Center) cbo_select_vaccination_center.getSelectedItem();
        lbl_vaccine_type.setText(selected_item.getType());
    }//GEN-LAST:event_cbo_select_vaccination_centerActionPerformed

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
            java.util.logging.Logger.getLogger(People.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(People.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(People.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(People.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new People().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel_appointment;
    private javax.swing.JButton btn_edit_account;
    private javax.swing.JButton btn_edit_cancel;
    private javax.swing.JButton btn_edit_save;
    private javax.swing.JButton btn_register_appointment;
    private javax.swing.JButton btn_register_vaccination_appointment_cancel;
    private javax.swing.JButton btn_register_vaccination_appointment_register;
    private javax.swing.JComboBox<String> cbo_select_time;
    private javax.swing.JComboBox<String> cbo_select_vaccination_center;
    private javax.swing.JLabel lbl_1st_dose_appointment;
    private javax.swing.JLabel lbl_2nd_dose_appointment;
    private javax.swing.JLabel lbl_centerAddress1;
    private javax.swing.JLabel lbl_centerAddress2;
    private javax.swing.JLabel lbl_centerContactNumber1;
    private javax.swing.JLabel lbl_centerContactNumber2;
    private javax.swing.JLabel lbl_center_address_1;
    private javax.swing.JLabel lbl_center_address_2;
    private javax.swing.JLabel lbl_center_contact_number_1;
    private javax.swing.JLabel lbl_center_contact_number_2;
    private javax.swing.JLabel lbl_date1;
    private javax.swing.JLabel lbl_date2;
    private javax.swing.JLabel lbl_date_1;
    private javax.swing.JLabel lbl_date_2;
    private javax.swing.JLabel lbl_editAccount;
    private javax.swing.JLabel lbl_edit_address;
    private javax.swing.JLabel lbl_edit_confirm_password;
    private javax.swing.JLabel lbl_edit_ic_passport_number;
    private javax.swing.JLabel lbl_edit_name;
    private javax.swing.JLabel lbl_edit_nationality;
    private javax.swing.JLabel lbl_edit_password;
    private javax.swing.JLabel lbl_edit_phone_number;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_myAccount;
    private javax.swing.JLabel lbl_my_account;
    private javax.swing.JLabel lbl_registerVaccinationAppointment;
    private javax.swing.JLabel lbl_search_vaccination_status;
    private javax.swing.JLabel lbl_select_date;
    private javax.swing.JLabel lbl_select_time;
    private javax.swing.JLabel lbl_select_vaccination_center;
    private javax.swing.JLabel lbl_time1;
    private javax.swing.JLabel lbl_time2;
    private javax.swing.JLabel lbl_time_1;
    private javax.swing.JLabel lbl_time_2;
    private javax.swing.JLabel lbl_vaccinationAppointment;
    private javax.swing.JLabel lbl_vaccinationCenter1;
    private javax.swing.JLabel lbl_vaccinationCenter2;
    private javax.swing.JLabel lbl_vaccinationStatus;
    private javax.swing.JLabel lbl_vaccination_appointment;
    private javax.swing.JLabel lbl_vaccination_center_1;
    private javax.swing.JLabel lbl_vaccination_center_2;
    private javax.swing.JLabel lbl_vaccination_status;
    private javax.swing.JLabel lbl_vaccineType;
    private javax.swing.JLabel lbl_vaccineType1;
    private javax.swing.JLabel lbl_vaccineType2;
    private javax.swing.JLabel lbl_vaccine_type;
    private javax.swing.JLabel lbl_vaccine_type_1;
    private javax.swing.JLabel lbl_vaccine_type_2;
    private javax.swing.JTextArea lbl_view_address;
    private javax.swing.JLabel lbl_view_ic_passport_number;
    private javax.swing.JLabel lbl_view_name;
    private javax.swing.JLabel lbl_view_nationality;
    private javax.swing.JLabel lbl_view_phone_number;
    private javax.swing.JPanel pnl_container;
    private javax.swing.JPanel pnl_editAccount;
    private javax.swing.JPanel pnl_edit_account;
    private javax.swing.JPanel pnl_logout;
    private javax.swing.JPanel pnl_myAccount;
    private javax.swing.JPanel pnl_my_account;
    private javax.swing.JPanel pnl_registerVaccinationAppointment;
    private javax.swing.JPanel pnl_register_vaccination_appointment;
    private javax.swing.JPanel pnl_sidenav;
    private javax.swing.JPanel pnl_vaccinationAppoitment;
    private javax.swing.JPanel pnl_vaccinationStatus;
    private javax.swing.JPanel pnl_vaccination_appointment;
    private javax.swing.JPanel pnl_vaccination_status;
    private javax.swing.JPanel pnl_view_account;
    private javax.swing.JPanel pnl_view_vaccination_appointment;
    private javax.swing.JPanel pnl_view_vaccination_status;
    private javax.swing.JScrollPane scrpnl_vaccination_status;
    private javax.swing.JTable tbl_vaccination_status;
    private javax.swing.JTextField txt_edit_address;
    private javax.swing.JPasswordField txt_edit_confirm_password;
    private javax.swing.JTextField txt_edit_ic_passport_number;
    private javax.swing.JTextField txt_edit_name;
    private javax.swing.JTextField txt_edit_nationality;
    private javax.swing.JPasswordField txt_edit_password;
    private javax.swing.JTextField txt_edit_phone_number;
    private javax.swing.JTextField txt_search_vaccination_status;
    private com.toedter.calendar.JDateChooser txt_select_date;
    // End of variables declaration//GEN-END:variables
}
