/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import seaquellersbb.*;
import seaquellersbb.SeaQuellersBBAPI;

/**
 *
 * @author serenachen
 */
public class ForumUI extends javax.swing.JFrame {
    private SeaQuellersBBAPI seaQuellers;
    private Forum forum;
    private User loggedInUser;
    private ArrayList<Subforum> subforums;
    private HomeUI home;
    /**
     * Creates new form ForumUI
     */
    public ForumUI(SeaQuellersBBAPI seaQuellers, Forum forum, User user, HomeUI home) {
        initComponents();
        this.seaQuellers = seaQuellers;
        this.forum = forum;
        this.loggedInUser = user;
        this.subforums = seaQuellers.getSubforums(forum.id);
        this.home = home;
        if (!(user.isSuperAdmin || forum.userId == user.id)) forumDeletionButton.setVisible(false);
        drawSubForumsPanel();
        username.setText(loggedInUser.username);
        forumName.setText(forum.name);
        subsPanel.setLayout(new GridLayout(0, 1)); // One column, unlimited rows
        subsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
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

        jPanel1 = new javax.swing.JPanel();
        forumName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        subsPanel = new javax.swing.JPanel();
        forumDeletionButton = new javax.swing.JButton();
        subCreationButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        forumName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        forumName.setForeground(new java.awt.Color(255, 255, 255));
        forumName.setText("[forumName]");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Currently logged in:");

        username.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("[username]");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(forumName, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
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
                    .addComponent(forumName)
                    .addComponent(jLabel5)
                    .addComponent(username))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout subsPanelLayout = new javax.swing.GroupLayout(subsPanel);
        subsPanel.setLayout(subsPanelLayout);
        subsPanelLayout.setHorizontalGroup(
            subsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        subsPanelLayout.setVerticalGroup(
            subsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        forumDeletionButton.setText("Delete Forum");
        forumDeletionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forumDeletionButtonMouseClicked(evt);
            }
        });

        subCreationButton.setText("Create New Subforum");
        subCreationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subCreationButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(forumDeletionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(subCreationButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forumDeletionButton)
                    .addComponent(subCreationButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void forumDeletionButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forumDeletionButtonMouseClicked
        seaQuellers.deleteForum(forum.id);
        home.refreshForums();
        this.dispose();
    }//GEN-LAST:event_forumDeletionButtonMouseClicked

    private void subCreationButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subCreationButtonMouseClicked
        NewSubUI newSub = new NewSubUI(seaQuellers, this, forum.id);
        newSub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newSub.setVisible(true);
    }//GEN-LAST:event_subCreationButtonMouseClicked

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
            java.util.logging.Logger.getLogger(ForumUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForumUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForumUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForumUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new ForumUI(new SeaQuellersBBAPI()).setVisible(true);
            }
        });
    }
    
    public void refreshSubForums(){
        this.subforums = seaQuellers.getSubforums(forum.id);
        subsPanel.removeAll();
        drawSubForumsPanel();
        subsPanel.revalidate();
        subsPanel.repaint();
        this.pack();

    }
    
    public void drawSubForumsPanel(){
        for (int i = 0; i < subforums.size(); i++) {
            JLabel subforumName = new JLabel(subforums.get(i).name);
            JLabel description = new JLabel(subforums.get(i).description);
            subforumName.setName("" + i);
            subforumName.setFont(Font.decode("Lucida-Grande-Bold-16"));
            description.setFont(Font.decode("Lucida-Grande-14"));
            subforumName.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JLabel source = (JLabel) e.getSource();
                    SubforumUI subforum = new SubforumUI(seaQuellers, subforums.get(Integer.parseInt(source.getName())), loggedInUser);
                    subforum.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    subforum.setVisible(true);
                }
            });
            subsPanel.add(subforumName);
            subsPanel.add(description);
            subsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forumDeletionButton;
    private javax.swing.JLabel forumName;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton subCreationButton;
    private javax.swing.JPanel subsPanel;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
