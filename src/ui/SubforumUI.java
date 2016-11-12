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
import seaquellersbb.*;

/**
 *
 * @author serenachen
 */
public class SubforumUI extends javax.swing.JFrame {
    
    private SeaQuellersBBAPI seaQuellers;
    private Subforum subforum;
    private Forum forum;
    private User loggedInUser;
    private ArrayList<seaquellersbb.Thread> threads;
    private ForumUI forumUI;
    private ArrayList<User> mods;
    private int[] modIds;
    /**
     * Creates new form SubforumUI
     */
    public SubforumUI(SeaQuellersBBAPI seaQuellers, Subforum subforum, Forum forum, User user, ForumUI forumUI) {
        initComponents();
        this.seaQuellers = seaQuellers;
        this.subforum = subforum;
        this.forum = forum;
        this.loggedInUser = user;
        this.forumUI = forumUI;
        if (!(user.isSuperAdmin || forum.userId == user.id)){ 
            manageModsButton.setVisible(false);
            deleteSubButton.setVisible(false);
        }
        username.setText(loggedInUser.username);
        subforumName.setText(subforum.name);
        drawThreadsPanel();
        this.mods = seaQuellers.getModerators(subforum.id, subforum.forumId);
        for (int i = 0; i < mods.size(); i++) {
            modIds[i] = mods.get(i).id;
        }
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
        jLabel5 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        subforumName = new javax.swing.JLabel();
        postThreadButton = new javax.swing.JButton();
        threadsPanel = new javax.swing.JPanel();
        deleteSubButton = new javax.swing.JButton();
        manageModsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Currently logged in:");

        username.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("[username]");

        subforumName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        subforumName.setForeground(new java.awt.Color(255, 255, 255));
        subforumName.setText("[subforumName]");

        postThreadButton.setText("Post Thread");
        postThreadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postThreadButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subforumName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(postThreadButton)
                .addGap(48, 48, 48)
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
                    .addComponent(subforumName)
                    .addComponent(postThreadButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout threadsPanelLayout = new javax.swing.GroupLayout(threadsPanel);
        threadsPanel.setLayout(threadsPanelLayout);
        threadsPanelLayout.setHorizontalGroup(
            threadsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        threadsPanelLayout.setVerticalGroup(
            threadsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        deleteSubButton.setText("Delete Subforum");
        deleteSubButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteSubButtonMouseClicked(evt);
            }
        });

        manageModsButton.setText("Manage Moderators");
        manageModsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageModsButtonMouseClicked(evt);
            }
        });
        manageModsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageModsButtonActionPerformed(evt);
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
                    .addComponent(threadsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteSubButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(manageModsButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(threadsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteSubButton)
                    .addComponent(manageModsButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteSubButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteSubButtonMouseClicked
        seaQuellers.deleteSubforum(subforum.id, subforum.forumId);
        forumUI.refreshSubForums();
        this.dispose();
    }//GEN-LAST:event_deleteSubButtonMouseClicked

    private void postThreadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postThreadButtonMouseClicked
        NewThreadUI newThread = new NewThreadUI(seaQuellers, this, subforum, forum, loggedInUser);
        newThread.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newThread.setVisible(true);
    }//GEN-LAST:event_postThreadButtonMouseClicked

    private void manageModsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageModsButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_manageModsButtonMouseClicked

    private void manageModsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageModsButtonActionPerformed
        ManageModsUI manageMods = new ManageModsUI(seaQuellers, subforum, loggedInUser);
        manageMods.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        manageMods.setVisible(true);
    }//GEN-LAST:event_manageModsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SubforumUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubforumUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubforumUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubforumUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SubforumUI().setVisible(true);
//            }
//        });
    }
    
    public void refreshThreads(){
        threadsPanel.removeAll();
        drawThreadsPanel();
        threadsPanel.revalidate();
        threadsPanel.repaint();
        this.pack();

    }
    
    public void drawThreadsPanel(){
        SubforumUI that = this;
        threads = seaQuellers.getThreads(subforum.id, subforum.forumId);
        threadsPanel.setLayout(new GridLayout(0, 1)); // One column, unlimited rows
        threadsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        for (int i = 0; i < threads.size(); i++) {
            JLabel threadTitle = new JLabel(threads.get(i).title);
            threadTitle.setName("" + i);
            threadTitle.setFont(Font.decode("Lucida-Grande-Bold-16"));
            threadTitle.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JLabel source = (JLabel) e.getSource();
                    ThreadUI thread = new ThreadUI(seaQuellers, threads.get(Integer.parseInt(source.getName())), loggedInUser, forum, subforum, that);
                    thread.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    thread.setVisible(true);
                }
            });
            threadsPanel.add(threadTitle);
            threadsPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteSubButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton manageModsButton;
    private javax.swing.JButton postThreadButton;
    private javax.swing.JLabel subforumName;
    private javax.swing.JPanel threadsPanel;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
