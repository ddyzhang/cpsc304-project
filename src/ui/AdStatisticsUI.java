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
    private ManageAdsUI managePage;
    private User loggedInUser;
    private SuperAdminProfileUI superAdmin;
    private ArrayList<AdStatistic> adsView;
    private ArrayList<AdStatistic> forumView;
    private ArrayList<AdStatistic> allView;


    public AdStatisticsUI(SeaQuellersBBAPI seaQuellers, User user, ManageAdsUI managePage) {
        initComponents();
        this.seaQuellers = seaQuellers;
        this.loggedInUser = user;
        this.managePage=managePage;
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
            String Description = ("Profit:$" + adsView.get(i).profit
                    + " Total Clicks:" + adsView.get(i).totalClicks + " Total Impressions:"
                    + adsView.get(i).totalImpressions);

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
            String Description = ("ForumId:" + forumView.get(i).forumId + " Profit:$" + forumView.get(i).profit
                    + " Total Clicks:" + forumView.get(i).totalClicks + " Total Impressions:"
                    + forumView.get(i).totalImpressions);

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
            String Description = ("Profit:$" + allView.get(i).profit
                    + " Total Clicks:" + allView.get(i).totalClicks + " Total Impressions:"
                    + allView.get(i).totalImpressions);

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
     
    public void populateAggregatedStats() {
        adsPanel.removeAll();
        adsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        double total = seaQuellers.getTotalProfit();
        double avg = seaQuellers.getAverageProfit();
        JLabel totalProfit = new JLabel("Total Profit: $" + total);
        totalProfit.setFont(Font.decode("Lucida-Grande-Bold-16"));
        adsPanel.add(totalProfit);
        adsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        JLabel avgProfit = new JLabel("Average Profit: $" + avg);
        avgProfit.setFont(Font.decode("Lucida-Grande-Bold-16"));
        adsPanel.add(avgProfit);
        adsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
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
        adsPanel = new javax.swing.JPanel();
        byAdButton = new javax.swing.JButton();
        byForumButton = new javax.swing.JButton();
        divisonButton = new javax.swing.JButton();
        aggregatedButton = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jLabel1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        adsPanel.setPreferredSize(new java.awt.Dimension(549, 449));
        adsPanel.setLayout(new java.awt.GridLayout(5, 0));

        byAdButton.setText("By Ad");
        byAdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byAdButtonActionPerformed(evt);
            }
        });

        byForumButton.setText("By Forum");
        byForumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byForumButtonActionPerformed(evt);
            }
        });

        divisonButton.setText("By Ads in All Forums");
        divisonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divisonButtonActionPerformed(evt);
            }
        });

        aggregatedButton.setText("Aggregated Stats");
        aggregatedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggregatedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(byAdButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(byForumButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(divisonButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aggregatedButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(byAdButton)
                    .addComponent(byForumButton)
                    .addComponent(divisonButton)
                    .addComponent(aggregatedButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        managePage.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void byAdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byAdButtonActionPerformed
        System.out.println("Ads Clicked");
        populateAdsView();
    }//GEN-LAST:event_byAdButtonActionPerformed

    private void byForumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byForumButtonActionPerformed
        System.out.println("Forum Clicked");
        populateForumsView();
    }//GEN-LAST:event_byForumButtonActionPerformed

    private void divisonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divisonButtonActionPerformed
        System.out.println("All Clicked");
        populateAllView();
    }//GEN-LAST:event_divisonButtonActionPerformed

    private void aggregatedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggregatedButtonActionPerformed
        populateAggregatedStats();
    }//GEN-LAST:event_aggregatedButtonActionPerformed

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
    private javax.swing.JPanel adsPanel;
    private javax.swing.JButton aggregatedButton;
    private javax.swing.JButton byAdButton;
    private javax.swing.JButton byForumButton;
    private javax.swing.JButton divisonButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
