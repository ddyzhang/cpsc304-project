/**
* First page users sees after logging in.
* This page displays all the forums available to user.
*/

package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import seaquellersbb.*;

/**
 *
 * @author serenachen
 */
public class HomeUI extends javax.swing.JFrame {
    private SeaQuellersBBAPI seaQuellers;
    private LoginUI loginPage;
    private User loggedInUser;
    private ArrayList<Forum> forums;
    private boolean isSuperAdmin;
    /**
     * Creates new form HomeUI
     */
    public HomeUI(SeaQuellersBBAPI seaQuellers, User user, LoginUI loginPage) {
        initComponents();
       
        
        this.seaQuellers = seaQuellers;
        this.loggedInUser = user;
        this.loginPage = loginPage;
        username.setText(loggedInUser.username); 
        if (user.isSuperAdmin) jLabel5.setText("Administrator: ");
        ManageAds.setVisible(loggedInUser.isSuperAdmin);
        drawForumsPanel();
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ManageAds = new javax.swing.JLabel();
        forumsPanel = new javax.swing.JPanel();
        createForumButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Currently logged in:");

        username.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("[username]");
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome to the SeaQuellers Bulletin Board!");

        ManageAds.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        ManageAds.setForeground(new java.awt.Color(255, 255, 255));
        ManageAds.setText("Manage Ads");
        ManageAds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageAdsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ManageAds)
                    .addComponent(username))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(username)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ManageAds)
                .addContainerGap())
        );

        forumsPanel.setPreferredSize(new java.awt.Dimension(549, 449));
        forumsPanel.setLayout(new java.awt.GridLayout(5, 0));

        createForumButton.setText("Create Forum");
        createForumButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createForumButtonMouseClicked(evt);
            }
        });

        jButton2.setText("REFRESH");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(forumsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createForumButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(forumsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createForumButton)
                    .addComponent(jButton2))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseClicked
       System.out.println(loggedInUser.username);
        if(loggedInUser.isSuperAdmin){
            SuperAdminProfileUI superAdminProfile = new SuperAdminProfileUI(seaQuellers, loggedInUser);
            superAdminProfile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            superAdminProfile.setVisible(true);
    }
        else{
            UserProfileUI userProfile = new UserProfileUI(seaQuellers, loggedInUser);
            userProfile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            userProfile.setVisible(true);
                }
    }//GEN-LAST:event_usernameMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        loginPage.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void createForumButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createForumButtonMouseClicked
        NewForumUI newForum = new NewForumUI(seaQuellers, loggedInUser, this);
        newForum.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newForum.setVisible(true);
    }//GEN-LAST:event_createForumButtonMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        //this is a debug cause I got tired of rerunning every time
        //TODO: remove this in final version
        this.refreshForums();
    }//GEN-LAST:event_jButton2MouseClicked

    private void ManageAdsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageAdsMouseClicked
        ManageAdsUI manageAds = new ManageAdsUI(seaQuellers, loggedInUser, this);
        manageAds.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        manageAds.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ManageAdsMouseClicked

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
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new HomeUI(new SeaQuellersBBAPI(), null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ManageAds;
    private javax.swing.JButton createForumButton;
    private javax.swing.JPanel forumsPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables

    public void refreshForums(){
        forumsPanel.removeAll();
        drawForumsPanel();
        forumsPanel.revalidate();
        forumsPanel.repaint();
        this.pack();

    }
    public void drawForumsPanel() {
        this.forums = seaQuellers.getAllForums();
        HomeUI that = this;
        forumsPanel.setLayout(new GridLayout(0, 1)); // One column, unlimited rows
        forumsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        for (int i = 0; i < forums.size(); i++) {
            JLabel forumName = new JLabel(forums.get(i).name);
            JLabel description = new JLabel(forums.get(i).description);
            forumName.setName("" + i);
            forumName.setFont(Font.decode("Lucida-Grande-Bold-16"));
            description.setFont(Font.decode("Lucida-Grande-14"));
            forumName.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JLabel source = (JLabel)e.getSource();
                    ForumUI forum = new ForumUI(seaQuellers, forums.get(Integer.parseInt(source.getName())), loggedInUser, that);
                    forum.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    forum.setVisible(true);
                }
            });
            forumsPanel.add(forumName);
            forumsPanel.add(description);
            forumsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        }
    }
}
