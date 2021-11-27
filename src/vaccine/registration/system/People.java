package vaccine.registration.system;

import java.awt.*;
import javax.swing.*;
import java.text.*;
import java.util.regex.*;

public class People extends javax.swing.JFrame {

    
    CitizenClass citizen_class = new CitizenClass();
    NonCitizenClass noncitizen_class = new NonCitizenClass();
    PeopleClass people_class = new PeopleClass();
    boolean citizenship;
    
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
        if (citizen == true){
            citizen_class.setPeople_ID(people_id);
            citizenship = true;
        } else {
            noncitizen_class.setPeople_ID(people_id);
            citizenship = false;
        }
    }
    
    public void View(){
        //insert data
        if (citizenship == true){
            citizen_class.View_Account();
            lbl_view_name.setText(citizen_class.getName());
            lbl_view_phone_number.setText(citizen_class.getPhone_Number());
            lbl_view_nationality.setText(citizen_class.getNationality());
            lbl_view_ic_passport_number.setText(citizen_class.getIC_Number());
            lbl_view_address.setText(citizen_class.getAddress());
        } else {
            noncitizen_class.View_Account();
            lbl_view_name.setText(noncitizen_class.getName());
            lbl_view_phone_number.setText(noncitizen_class.getPhone_Number());
            lbl_view_nationality.setText(noncitizen_class.getNationality());
            lbl_view_ic_passport_number.setText(noncitizen_class.getPassport_Number());
            lbl_view_address.setText(noncitizen_class.getAddress());       
        }
    }


    // UIW
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
        lbl_view_address = new javax.swing.JLabel();
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

        lbl_view_address.setBackground(new java.awt.Color(255, 255, 255));
        lbl_view_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_view_address.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_edit_account.setBackground(new java.awt.Color(73, 161, 236));
        btn_edit_account.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_edit_account.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit_account.setText("Edit Account");
        btn_edit_account.setBorder(null);
        btn_edit_account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_accountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_view_accountLayout = new javax.swing.GroupLayout(pnl_view_account);
        pnl_view_account.setLayout(pnl_view_accountLayout);
        pnl_view_accountLayout.setHorizontalGroup(
            pnl_view_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_view_accountLayout.createSequentialGroup()
                .addContainerGap(280, Short.MAX_VALUE)
                .addGroup(pnl_view_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_edit_account, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_view_address, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_view_nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_view_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_view_name, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_view_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(280, Short.MAX_VALUE))
            .addComponent(pnl_myAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(40, 40, 40)
                .addComponent(lbl_view_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbl_view_address, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btn_edit_account, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
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

        lbl_select_time.setBackground(new java.awt.Color(255, 255, 255));
        lbl_select_time.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_select_time.setText("Select Time");

        cbo_select_time.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cbo_select_time.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Time", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM" }));

        lbl_select_vaccination_center.setBackground(new java.awt.Color(255, 255, 255));
        lbl_select_vaccination_center.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_select_vaccination_center.setText("Select Vaccination Center");

        cbo_select_vaccination_center.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cbo_select_vaccination_center.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Vaccination Center" }));

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
                .addContainerGap(117, Short.MAX_VALUE))
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
        lbl_search_vaccination_status.setText("Search Vaccination Status (Vaccination Center / Vaccine Type)");

        txt_search_vaccination_status.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_search_vaccination_status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

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
        ));
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
                .addGap(40, 40, 40)
                .addComponent(scrpnl_vaccination_status, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
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
        View();
        pnl_view_account.setVisible(true);
        pnl_edit_account.setVisible(false);
        pnl_view_vaccination_appointment.setVisible(false);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(false);
    }//GEN-LAST:event_lbl_my_accountMouseClicked

    
    // Edit account button
    private void btn_edit_accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_accountActionPerformed
        //view data
        if (citizenship == true){
            citizen_class.View_Account();
            txt_edit_name.setText(citizen_class.getName());
            txt_edit_phone_number.setText(citizen_class.getPhone_Number());
            txt_edit_nationality.setText(citizen_class.getNationality());
            txt_edit_ic_passport_number.setText(citizen_class.getIC_Number());
            txt_edit_address.setText(citizen_class.getAddress());
        } else {
            noncitizen_class.View_Account();
            txt_edit_name.setText(noncitizen_class.getName());
            txt_edit_phone_number.setText(noncitizen_class.getPhone_Number());
            txt_edit_nationality.setText(noncitizen_class.getNationality());
            txt_edit_ic_passport_number.setText(noncitizen_class.getPassport_Number());
            txt_edit_address.setText(noncitizen_class.getAddress());
        }
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(true);
        pnl_view_vaccination_appointment.setVisible(false);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(false);
        
    }//GEN-LAST:event_btn_edit_accountActionPerformed

    
    // Vaccination appointment side bar tab
    private void lbl_vaccination_appointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_vaccination_appointmentMouseClicked
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_vaccination_appointment.setVisible(true);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(false);
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
        pnl_view_account.setVisible(true);
        pnl_edit_account.setVisible(false);
        pnl_view_vaccination_appointment.setVisible(false);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(false);
    }//GEN-LAST:event_btn_edit_cancelActionPerformed

    
    // Logout button
    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_logoutMouseClicked

    
    // Cancel register vaccination appointment button
    private void btn_register_vaccination_appointment_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_vaccination_appointment_cancelActionPerformed
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_vaccination_appointment.setVisible(true);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(false);
    }//GEN-LAST:event_btn_register_vaccination_appointment_cancelActionPerformed

    
    // Vaccination status side bar tab
    private void lbl_vaccination_statusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_vaccination_statusMouseClicked
        pnl_view_account.setVisible(false);
        pnl_edit_account.setVisible(false);
        pnl_view_vaccination_appointment.setVisible(false);
        pnl_register_vaccination_appointment.setVisible(false);
        pnl_view_vaccination_status.setVisible(true);
    }//GEN-LAST:event_lbl_vaccination_statusMouseClicked

    
    // Save edit account button
    private void btn_edit_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_saveActionPerformed
        if (txt_edit_name.getText().equals("") || txt_edit_phone_number.getText().equals("") || txt_edit_address.getText().equals("") || txt_edit_password.getPassword().length == 0 || txt_edit_confirm_password.getPassword().length == 0) {
           JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (people_class.validation(txt_edit_name.getText(), txt_edit_phone_number.getText()).equals("name")) {
            JOptionPane.showMessageDialog(null, people_class.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (people_class.validation(txt_edit_name.getText(), txt_edit_phone_number.getText()).equals("phone_number")) {
            JOptionPane.showMessageDialog(null, people_class.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!txt_edit_password.getText().matches(txt_edit_confirm_password.getText())) {
            JOptionPane.showMessageDialog(null, "Password not match.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if(txt_edit_nationality.getText().equals("Malaysia")) {
                citizen_class.setName(txt_edit_name.getText());
                citizen_class.setPhone_Number(txt_edit_phone_number.getText());
                citizen_class.setNationality(txt_edit_nationality.getText());
                citizen_class.setAddress(txt_edit_address.getText());
                citizen_class.setPassword(txt_edit_password.getText());
                citizen_class.setIC_Number(txt_edit_ic_passport_number.getText()); 
                citizen_class.Edit_Account();
                if(citizen_class.getSuccess_Save() == true) {
                    View();
                    pnl_view_account.setVisible(true);
                    pnl_edit_account.setVisible(false);
                    pnl_view_vaccination_appointment.setVisible(false);
                    pnl_register_vaccination_appointment.setVisible(false);
                    pnl_view_vaccination_status.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Your changes has been saved.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to save edit.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                noncitizen_class.calculatePeople_ID();
                noncitizen_class.setName(txt_edit_name.getText());
                noncitizen_class.setPhone_Number(txt_edit_phone_number.getText());
                noncitizen_class.setNationality(txt_edit_nationality.getText());
                noncitizen_class.setAddress(txt_edit_address.getText());
                noncitizen_class.setPassword(txt_edit_password.getText());
                noncitizen_class.setPassport_Number(txt_edit_ic_passport_number.getText()); 
                noncitizen_class.Edit_Account();
                if(noncitizen_class.getSuccess_Save() == true) {
                    View();
                    pnl_view_account.setVisible(true);
                    pnl_edit_account.setVisible(false);
                    pnl_view_vaccination_appointment.setVisible(false);
                    pnl_register_vaccination_appointment.setVisible(false);
                    pnl_view_vaccination_status.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Your changes has been saved.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to save edit.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }         
        }
    }//GEN-LAST:event_btn_edit_saveActionPerformed

    
    // Save register vaccination appointment button
    private void btn_register_vaccination_appointment_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_vaccination_appointment_registerActionPerformed
        try {
            SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
            String select_date = date_format.format(txt_select_date.getDate());
            String select_time = cbo_select_time.getSelectedItem().toString();
            String select_vaccination_center = cbo_select_vaccination_center.getSelectedItem().toString();
            
            if (cbo_select_time.getSelectedItem().equals("Select Time") || cbo_select_vaccination_center.getSelectedItem().equals("Select Vaccination Center")) {
                JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                pnl_view_account.setVisible(false);
                pnl_edit_account.setVisible(false);
                pnl_view_vaccination_appointment.setVisible(true);
                pnl_register_vaccination_appointment.setVisible(false);
                pnl_view_vaccination_status.setVisible(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_register_vaccination_appointment_registerActionPerformed

    
    // Cancel vaccination appointment button
    private void btn_cancel_appointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancel_appointmentActionPerformed
        
    }//GEN-LAST:event_btn_cancel_appointmentActionPerformed

    
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
    private javax.swing.JLabel lbl_view_address;
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
