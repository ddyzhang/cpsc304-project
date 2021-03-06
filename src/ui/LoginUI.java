/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import seaquellersbb.*;
/**
 *
 * @author serenachen
 */
public class LoginUI extends javax.swing.JFrame {
    private SeaQuellersBBAPI seaQuellers;
    private User mostRecent;
    private int numUsers;

    /**
     * Creates new form Login
     */
    public LoginUI(SeaQuellersBBAPI seaQuellers) {
        initComponents();

        this.seaQuellers = seaQuellers;
        this.mostRecent = seaQuellers.getMostRecentUser();
        this.numUsers = seaQuellers.getNumUsers();
        registerHeading3.setText("Most Recent User: " + mostRecent.username);
        registerHeading4.setText("Number of Users: " + numUsers);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        seaquellersBBLabel = new javax.swing.JLabel();
        usernameTxtField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        headingLabel = new javax.swing.JLabel();
        registerUsernameLabel = new javax.swing.JLabel();
        registerPWTxtField = new javax.swing.JPasswordField();
        registerEmailTxtField = new javax.swing.JTextField();
        registerPWLabel = new javax.swing.JLabel();
        registerUsernameTxtField = new javax.swing.JTextField();
        registerEmailLabel = new javax.swing.JLabel();
        signUpBtn = new javax.swing.JButton();
        registerHeading1 = new javax.swing.JLabel();
        registerHeading2 = new javax.swing.JLabel();
        registerHeading3 = new javax.swing.JLabel();
        registerHeading4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        seaquellersBBLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        seaquellersBBLabel.setForeground(new java.awt.Color(255, 255, 255));
        seaquellersBBLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/seaquellersbb_logo copy.png"))); // NOI18N

        usernameTxtField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        usernameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTxtFieldActionPerformed(evt);
            }
        });

        passwordField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password");

        loginBtn.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        loginBtn.setText("Log In");
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seaquellersBBLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginBtn))
                    .addComponent(passwordLabel))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(passwordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seaquellersBBLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        headingLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        headingLabel.setText("Not registered? Sign up!");

        registerUsernameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        registerUsernameLabel.setText("Username");

        registerEmailTxtField.setToolTipText("");
        registerEmailTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerEmailTxtFieldActionPerformed(evt);
            }
        });

        registerPWLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        registerPWLabel.setText("Password");

        registerEmailLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        registerEmailLabel.setText("Email");

        signUpBtn.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        signUpBtn.setText("Sign Up");
        signUpBtn.setToolTipText("");
        signUpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpBtnMouseClicked(evt);
            }
        });
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });

        registerHeading1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        registerHeading1.setText("on the SeaQuellers Bulletin Board.");

        registerHeading2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        registerHeading2.setText("Connect with friends and the world around you ");

        registerHeading3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        registerHeading3.setText("Most Recent User:");

        registerHeading4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        registerHeading4.setText("Number of Users:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerHeading1)
                    .addComponent(registerHeading2)
                    .addComponent(registerHeading3)
                    .addComponent(registerHeading4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(headingLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registerPWLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(registerEmailLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(registerUsernameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(signUpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(registerPWTxtField)
                            .addComponent(registerUsernameTxtField)
                            .addComponent(registerEmailTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(headingLabel)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerUsernameLabel)
                            .addComponent(registerUsernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerPWTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerPWLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerEmailTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerEmailLabel))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(registerHeading2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registerHeading1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registerHeading3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registerHeading4)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTxtFieldActionPerformed

    private void registerEmailTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerEmailTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerEmailTxtFieldActionPerformed

    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signUpBtnActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    /**
     * Sign up new user
     * */
    private void signUpBtnMouseClicked(java.awt.event.MouseEvent evt) {                                       
        String username = registerUsernameTxtField.getText();
        String password = new String(registerPWTxtField.getPassword());
        String email = registerEmailTxtField.getText();
        if ( username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!isValidUsername(username)) {
            JOptionPane.showMessageDialog(new JFrame(), "Invalid username. Please only use alphanumeric characters.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!isValidEmailAddress(email)) {
            JOptionPane.showMessageDialog(new JFrame(), "Invalid email address format.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (seaQuellers.createUser(username, email, password)) {
            JOptionPane.showMessageDialog(new JFrame(), "Account created successfully! Please login using your new account.");
            this.mostRecent = seaQuellers.getMostRecentUser();
            this.numUsers = seaQuellers.getNumUsers();
            registerHeading3.setText("Most Recent User: " + mostRecent.username);
            registerHeading4.setText("Number of Users: " + numUsers);
            this.pack();
            
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Username is already taken.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    
    private boolean isValidUsername(String username) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[A-Za-z0-9]+");
        java.util.regex.Matcher m = pattern.matcher(username);
        return m.matches();
    }

    /**
     * TODO: SeaQuellersBBAPI.login(username, password);
     *
     * Log in existing user
     * */
    private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {                                      
        String username = usernameTxtField.getText();
        String password = new String(passwordField.getPassword());
        
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            User user = seaQuellers.login(username, password);
            if (user != null) {
                HomeUI home = new HomeUI(seaQuellers, user, this);
                home.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                home.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Username or password is incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            // TEST CODE
        }
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI(new SeaQuellersBBAPI()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel headingLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel registerEmailLabel;
    private javax.swing.JTextField registerEmailTxtField;
    private javax.swing.JLabel registerHeading1;
    private javax.swing.JLabel registerHeading2;
    private javax.swing.JLabel registerHeading3;
    private javax.swing.JLabel registerHeading4;
    private javax.swing.JLabel registerPWLabel;
    private javax.swing.JPasswordField registerPWTxtField;
    private javax.swing.JLabel registerUsernameLabel;
    private javax.swing.JTextField registerUsernameTxtField;
    private javax.swing.JLabel seaquellersBBLabel;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTxtField;
    // End of variables declaration//GEN-END:variables
}
