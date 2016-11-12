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
public class AdStatisticsUI extends javax.swing.JFrame {
    private SeaQuellersBBAPI seaQuellers;
    private HomeUI homePage;
    private User loggedInUser;
    private SuperAdminProfileUI superAdmin;
    private ArrayList<AdStatistic> adsView;
    private ArrayList<AdStatistic> forumView;
    private ArrayList<AdStatistic> allView;


    public AdStatisticsUI(SeaQuellersBBAPI seaQuellers, User user) {
        initComponents();
        this.seaQuellers = seaQuellers;
        this.loggedInUser = user;
        this.superAdmin=superAdmin;
        this.adsView=seaQuellers.getAdStatsByAd();
        this.forumView=seaQuellers.getAdStatsByForum();
        this.allView=seaQuellers.getStatsForAllForumAds();

        username.setText(loggedInUser.username); 
        adsPanel.setLayout(new GridLayout(0, 1)); // One column, unlimited rows
        adsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        populateAdsView();
       
    }

    
    
      public void populateAdsView() {
        
         adsPanel.removeAll();
         adsPanel.setLayout(new GridLayout(0, 1)); // One column, unlimited rows
        adsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
         for (int i = 0; i < adsView.size(); i++) {
            JLabel adName = new JLabel(adsView.get(i).imageUrl);
          String  Description=("Profit:"+adsView.get(i).profit                    
                  +" Total Clicks:"+adsView.get(i).totalClicks+" Total Impressions:"
                    +adsView.get(i).totalImpressions);
          
            JLabel description = new JLabel(Description);
            adName.setName("bloop " + i);
            adName.setFont(Font.decode("Lucida-Grande-Bold-16"));
            description.setFont(Font.decode("Lucida-Grande-14"));

            adsPanel.add(adName);
            adsPanel.add(description);
            adsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        }
         
        this.pack();
        adsPanel.revalidate();
        adsPanel.repaint();
        
    }
    
    
    public void populateForumsView() {
        
         adsPanel.removeAll();
         adsPanel.setLayout(new GridLayout(0, 1)); // One column, unlimited rows
        adsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
         for (int i = 0; i < forumView.size(); i++) {
            JLabel adName = new JLabel(forumView.get(i).forumName);
          String  Description=("ForumId:"+forumView.get(i).forumId+" Profit:"+forumView.get(i).profit                    
                  +" Total Clicks:"+forumView.get(i).totalClicks+" Total Impressions:"
                    +forumView.get(i).totalImpressions);
          
            JLabel description = new JLabel(Description);
            adName.setName("bloop " + i);
            adName.setFont(Font.decode("Lucida-Grande-Bold-16"));
            description.setFont(Font.decode("Lucida-Grande-14"));

            adsPanel.add(adName);
            adsPanel.add(description);
            adsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        }
         
        this.pack();
        adsPanel.revalidate();
        adsPanel.repaint();
        
    }
    
    
     public void populateAllView() {
        
         adsPanel.removeAll();
                 adsPanel.setLayout(new GridLayout(0, 1)); // One column, unlimited rows
        adsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
         for (int i = 0; i < allView.size(); i++) {
            JLabel adName = new JLabel(allView.get(i).imageUrl);
          String  Description=("ForumId:"+allView.get(i).forumId+" Profit:"+allView.get(i).profit                    
                  +" Total Clicks:"+allView.get(i).totalClicks+" Total Impressions:"
                    +allView.get(i).totalImpressions+" Forum Name:"+allView.get(i).forumName);
          
            JLabel description = new JLabel(Description);
            adName.setName("bloop " + i);
            adName.setFont(Font.decode("Lucida-Grande-Bold-16"));
            description.setFont(Font.decode("Lucida-Grande-14"));

        }
         
        this.pack();
        adsPanel.revalidate(); 
        adsPanel.repaint();
        
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
        AdsView = new javax.swing.JLabel();
        ForumView = new javax.swing.JLabel();
        AllView = new javax.swing.JLabel();
        adsPanel = new javax.swing.JPanel();

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
        jLabel1.setText("AdStatistics");

        AdsView.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        AdsView.setForeground(new java.awt.Color(255, 255, 255));
        AdsView.setText("AdsView");
        AdsView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdsViewMouseClicked(evt);
            }
        });

        ForumView.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        ForumView.setForeground(new java.awt.Color(255, 255, 255));
        ForumView.setText("ForumView");
        ForumView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ForumViewMouseClicked(evt);
            }
        });

        AllView.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        AllView.setForeground(new java.awt.Color(255, 255, 255));
        AllView.setText("All");
        AllView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AllViewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(AdsView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ForumView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AllView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(username)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(username)
                    .addComponent(jLabel1)
                    .addComponent(AdsView)
                    .addComponent(ForumView)
                    .addComponent(AllView))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        adsPanel.setPreferredSize(new java.awt.Dimension(549, 449));
        adsPanel.setLayout(new java.awt.GridLayout(5, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(adsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(adsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseClicked
        System.out.println(loggedInUser.username);
        UserProfileUI userProfile = new UserProfileUI(seaQuellers, loggedInUser);
        userProfile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userProfile.setVisible(true);
    }//GEN-LAST:event_usernameMouseClicked


    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
     //   homePage.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void AllViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllViewMouseClicked
        System.out.println("All Clicked");
        populateAllView();
    }//GEN-LAST:event_AllViewMouseClicked

    private void AdsViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdsViewMouseClicked
        System.out.println("Ads Clicked");
        populateAdsView();
    }//GEN-LAST:event_AdsViewMouseClicked

    private void ForumViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForumViewMouseClicked
        System.out.println("Forum Clicked");
        populateForumsView();
    }//GEN-LAST:event_ForumViewMouseClicked

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
            java.util.logging.Logger.getLogger(AdStatisticsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdStatisticsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdStatisticsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdStatisticsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new HomeUI(new SeaQuellersBBAPI(), null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdsView;
    private javax.swing.JLabel AllView;
    private javax.swing.JLabel ForumView;
    private javax.swing.JPanel adsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
