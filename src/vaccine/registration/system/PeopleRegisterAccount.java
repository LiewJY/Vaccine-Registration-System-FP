package vaccine.registration.system;

import java.awt.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.*;


public class PeopleRegisterAccount extends javax.swing.JFrame {
    // for validation
    ValidationClass validation_class = new ValidationClass();

    
    // People Register Account form
    public PeopleRegisterAccount() {
        initComponents();
        // Populate country in nationality
        DefaultComboBoxModel cbo = new DefaultComboBoxModel();
        for (String rowValue : getCountries()) {
            cbo.addElement(rowValue);
        }
        cbo_nationality.setModel(cbo);
        cbo_nationality.setSelectedIndex(-1);
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
    
    public void viewLogin() {
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }
    
    

    // UI
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_register_account = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        lbl_phone_number = new javax.swing.JLabel();
        txt_phone_number = new javax.swing.JTextField();
        lbl_nationality = new javax.swing.JLabel();
        cbo_nationality = new javax.swing.JComboBox<>();
        lbl_ic_passport_number = new javax.swing.JLabel();
        txt_ic_passport_number = new javax.swing.JTextField();
        lbl_address = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        lbl_confirm_password = new javax.swing.JLabel();
        txt_confirm_password = new javax.swing.JPasswordField();
        btn_register = new javax.swing.JButton();
        btn_back_to_login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("People Register Account");
        setResizable(false);

        pnl_register_account.setBackground(new java.awt.Color(255, 255, 255));

        lbl_logo.setBackground(java.awt.Color.white);
        lbl_logo.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lbl_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vaccine/registration/system/images/MyVaccine Logo - Blue.png"))); // NOI18N

        lbl_name.setBackground(java.awt.Color.white);
        lbl_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_name.setText("Name");

        txt_name.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lbl_phone_number.setBackground(java.awt.Color.white);
        lbl_phone_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_phone_number.setText("Phone Number");

        txt_phone_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_phone_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lbl_nationality.setBackground(java.awt.Color.white);
        lbl_nationality.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_nationality.setText("Nationality");

        cbo_nationality.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        lbl_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_ic_passport_number.setText("IC / Passport Number");

        txt_ic_passport_number.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_ic_passport_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lbl_address.setBackground(java.awt.Color.white);
        lbl_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_address.setText("Address");

        txt_address.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lbl_password.setBackground(java.awt.Color.white);
        lbl_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_password.setText("Password");

        txt_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        lbl_confirm_password.setBackground(java.awt.Color.white);
        lbl_confirm_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_confirm_password.setText("Confirm Password");

        txt_confirm_password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_confirm_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        btn_register.setBackground(new java.awt.Color(73, 161, 236));
        btn_register.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_register.setText("Register");
        btn_register.setBorder(null);
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });

        btn_back_to_login.setBackground(new java.awt.Color(255, 255, 255));
        btn_back_to_login.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btn_back_to_login.setText("Back to Log In");
        btn_back_to_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_back_to_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_register_accountLayout = new javax.swing.GroupLayout(pnl_register_account);
        pnl_register_account.setLayout(pnl_register_accountLayout);
        pnl_register_accountLayout.setHorizontalGroup(
            pnl_register_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_register_accountLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btn_back_to_login, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145)
                .addGroup(pnl_register_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_confirm_password)
                    .addComponent(txt_address, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(lbl_nationality)
                    .addComponent(txt_phone_number, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(lbl_ic_passport_number)
                    .addComponent(lbl_logo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(lbl_name)
                    .addComponent(txt_name)
                    .addComponent(lbl_phone_number)
                    .addComponent(lbl_address)
                    .addComponent(lbl_password)
                    .addComponent(btn_register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_password)
                    .addComponent(txt_confirm_password)
                    .addComponent(txt_ic_passport_number, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(cbo_nationality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(440, Short.MAX_VALUE))
        );
        pnl_register_accountLayout.setVerticalGroup(
            pnl_register_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_register_accountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_register_accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back_to_login, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_phone_number)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_phone_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_nationality)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lbl_ic_passport_number)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ic_passport_number, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lbl_address)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(lbl_confirm_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_confirm_password, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_register_account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_register_account, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    // Back to login button
    private void btn_back_to_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_back_to_loginActionPerformed
        viewLogin();
    }//GEN-LAST:event_btn_back_to_loginActionPerformed

    
    // Register account button
    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
           
        if (txt_name.getText().equals("") || txt_phone_number.getText().equals("") || cbo_nationality.getSelectedItem() == "" || txt_ic_passport_number.getText().equals("") || txt_address.getText().equals("") || txt_password.getPassword().length == 0 || txt_confirm_password.getPassword().length == 0) {
           JOptionPane.showMessageDialog(null, "Please fill in all details!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validateName(txt_name.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("name"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validatePhoneNumber(txt_phone_number.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("phone_number"), "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (validation_class.validateICPassportNumber(txt_ic_passport_number.getText()) == true) {
            JOptionPane.showMessageDialog(null, validation_class.validationMessage("ic_passport_number"), "Warning", JOptionPane.WARNING_MESSAGE);
        }else if (cbo_nationality.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Please Select your nationality", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!txt_password.getText().matches(txt_confirm_password.getText())) {
            JOptionPane.showMessageDialog(null, "Password not match.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if(cbo_nationality.getSelectedItem() == "Malaysia") {
                CitizenClass citizen = new CitizenClass();
                citizen.calculatePeople_ID();
                citizen.setName(txt_name.getText());
                citizen.setPhone_Number(txt_phone_number.getText());
                citizen.setNationality(cbo_nationality.getSelectedItem().toString());
                citizen.setAddress(txt_address.getText());
                citizen.setPassword(txt_password.getText());
                citizen.setIC_Number(txt_ic_passport_number.getText()); 
                citizen.Register_Account();
                if(citizen.getSuccess_Save() == true) {
                    JOptionPane.showMessageDialog(null, "Account Created.", "Success", JOptionPane.INFORMATION_MESSAGE); 
                    viewLogin();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to register account with the same IC Number exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                NonCitizenClass non_citizen = new NonCitizenClass();
                non_citizen.calculatePeople_ID();
                non_citizen.setName(txt_name.getText());
                non_citizen.setPhone_Number(txt_phone_number.getText());
                non_citizen.setNationality(cbo_nationality.getSelectedItem().toString());
                non_citizen.setAddress(txt_address.getText());
                non_citizen.setPassword(txt_password.getText());
                non_citizen.setPassport_Number(txt_ic_passport_number.getText()); 
                non_citizen.Register_Account();
                if(non_citizen.getSuccess_Save() == true) {
                    JOptionPane.showMessageDialog(null, "Account Created.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    viewLogin();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to register account with the same Passport Number exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btn_registerActionPerformed

    
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
            java.util.logging.Logger.getLogger(PeopleRegisterAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeopleRegisterAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeopleRegisterAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeopleRegisterAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeopleRegisterAccount().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back_to_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JComboBox<String> cbo_nationality;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_confirm_password;
    private javax.swing.JLabel lbl_ic_passport_number;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_nationality;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_phone_number;
    private javax.swing.JPanel pnl_register_account;
    private javax.swing.JTextField txt_address;
    private javax.swing.JPasswordField txt_confirm_password;
    private javax.swing.JTextField txt_ic_passport_number;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_phone_number;
    // End of variables declaration//GEN-END:variables
}
