package vaccine.registration.system;

import java.io.*;
import javax.swing.*;


public class Login extends javax.swing.JFrame {
    // Login form
    public Login() {
        initComponents();
      
        // Create file if file does not exist
        try {
            FileWriter people_file_writer = new FileWriter("People.txt", true);
            people_file_writer.close();
            
            FileWriter personnel_file_writer = new FileWriter("Personnel.txt", true);
            personnel_file_writer.close();
                        
            FileWriter appointment_file_writer = new FileWriter("Appointment.txt", true);
            appointment_file_writer.close();
            
            FileWriter center_file_writer = new FileWriter("Center.txt", true);
            center_file_writer.close();
            
            FileWriter vaccine_file_writer = new FileWriter("Vaccine.txt", true);
            vaccine_file_writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // UI
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_login = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        lbl_ic_passport_number = new javax.swing.JLabel();
        txt_ic_passport_number = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        cbo_user_role = new javax.swing.JComboBox<>();
        btn_login = new javax.swing.JButton();
        btn_register = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        pnl_login.setBackground(new java.awt.Color(255, 255, 255));
        pnl_login.setPreferredSize(new java.awt.Dimension(1024, 576));

        lbl_logo.setBackground(new java.awt.Color(255, 255, 255));
        lbl_logo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vaccine/registration/system/images/MyVaccine Logo - Blue.png"))); // NOI18N

        lbl_ic_passport_number.setBackground(new java.awt.Color(255, 255, 255));
        lbl_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_ic_passport_number.setText("IC / Passport Number");

        txt_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_ic_passport_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lbl_password.setBackground(new java.awt.Color(255, 255, 255));
        lbl_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_password.setText("Password");

        txt_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        cbo_user_role.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cbo_user_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User Role", "Personnel", "People (Citizen)", "People (Non-Citizen)" }));

        btn_login.setBackground(new java.awt.Color(73, 161, 236));
        btn_login.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Log In");
        btn_login.setBorder(null);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        btn_register.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_register.setText("Register");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_loginLayout = new javax.swing.GroupLayout(pnl_login);
        pnl_login.setLayout(pnl_loginLayout);
        pnl_loginLayout.setHorizontalGroup(
            pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loginLayout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addGroup(pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_loginLayout.createSequentialGroup()
                        .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbo_user_role, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_password)
                    .addComponent(lbl_ic_passport_number)
                    .addComponent(txt_ic_passport_number)
                    .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txt_password))
                .addContainerGap(312, Short.MAX_VALUE))
        );
        pnl_loginLayout.setVerticalGroup(
            pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loginLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(lbl_ic_passport_number)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbo_user_role, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    // Register account button
    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        PeopleRegisterAccount register = new PeopleRegisterAccount();
        register.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_registerActionPerformed

    
    // Login button
    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        if (txt_ic_passport_number.getText().equals("") || txt_password.getPassword().length == 0 || cbo_user_role.getSelectedItem().equals("Select User Role")) {
            JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if(cbo_user_role.getSelectedItem() == "Personnel") {
                PersonnelClass personnel_class = new PersonnelClass();
                personnel_class.setIC_Number(txt_ic_passport_number.getText());
                personnel_class.setPassword(txt_password.getText());
                personnel_class.Login_Account();
                boolean personnel = personnel_class.getAuth();
                
                if (personnel == true) {
                    JOptionPane.showMessageDialog(null, "You have logged in successfully.", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                    new Personnel(personnel_class.getPersonnel_ID()).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to login! IC / Passport Number or Password or User Role \ndoes not match. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            // Citizen
            } else if (cbo_user_role.getSelectedItem() == "People (Citizen)"){
                CitizenClass citizen_class = new CitizenClass();
                citizen_class.setIC_Number(txt_ic_passport_number.getText());
                citizen_class.setPassword(txt_password.getText());
                citizen_class.Login_Account();
                boolean citizen = citizen_class.getAuth();
                
                if (citizen == true) {
                    JOptionPane.showMessageDialog(null, "You have logged in successfully.", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                    new People(citizen_class.getPeople_ID(), citizen_class.getCitizen()).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to login! IC / Passport Number or Password or User Role \ndoes not match. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            // Non-citizen
            } else if (cbo_user_role.getSelectedItem() == "People (Non-Citizen)"){
                NonCitizenClass noncitizen_class = new NonCitizenClass();
                noncitizen_class.setPassport_Number(txt_ic_passport_number.getText());
                noncitizen_class.setPassword(txt_password.getText());
                noncitizen_class.Login_Account();
                boolean non_citizen = noncitizen_class.getAuth();
                
                if (non_citizen == true) {
                    JOptionPane.showMessageDialog(null, "You have logged in successfully.", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                    new People(noncitizen_class.getPeople_ID(), noncitizen_class.getCitizen()).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to login! IC / Passport Number or Password or User Role \ndoes not match. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else if (cbo_user_role.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(null, "Failed to login! IC / Passport Number or Password or User Role \ndoes not match. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JComboBox<String> cbo_user_role;
    private javax.swing.JLabel lbl_ic_passport_number;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JPanel pnl_login;
    private javax.swing.JTextField txt_ic_passport_number;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
