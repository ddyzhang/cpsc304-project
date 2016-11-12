/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import seaquellersbb.*;

/**
 *
 * @author serenachen
 */
public class ThreadUI extends javax.swing.JFrame {
    private SeaQuellersBBAPI seaQuellers;
    private seaquellersbb.Thread thread;
    private ArrayList<Comment> comments;
    private User loggedInUser;
    private Forum forum;
    private Subforum subforum;
    private SubforumUI subUI;

    /**
     * Creates new form ThreadUI
     */
    public ThreadUI(SeaQuellersBBAPI seaQuellers, seaquellersbb.Thread thread, User user, Forum forum, Subforum subforum, SubforumUI subUI) {
        initComponents();
        this.seaQuellers = seaQuellers;
        this.thread = thread;
        this.loggedInUser = user;
        this.forum = forum;
        this.subforum = subforum;
        this.subUI = subUI;
        username.setText(loggedInUser.username);
        threadTitle.setText(thread.title);
        drawComments();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        toolbarPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        threadTitle = new javax.swing.JLabel();
        deleteThreadButton = new javax.swing.JButton();
        panel = new javax.swing.JScrollPane();
        commentPanel = new javax.swing.JTextPane();
        replyBtn = new javax.swing.JButton();
        DisplayPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        toolbarPanel.setBackground(new java.awt.Color(0, 102, 204));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Currently logged in:");

        username.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("[username]");

        threadTitle.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        threadTitle.setForeground(new java.awt.Color(255, 255, 255));
        threadTitle.setText("[threadTitle]");

        deleteThreadButton.setText("Delete This Thread");
        deleteThreadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteThreadButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout toolbarPanelLayout = new javax.swing.GroupLayout(toolbarPanel);
        toolbarPanel.setLayout(toolbarPanelLayout);
        toolbarPanelLayout.setHorizontalGroup(
            toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(username)
                .addGap(67, 67, 67)
                .addComponent(threadTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(deleteThreadButton)
                .addContainerGap())
        );
        toolbarPanelLayout.setVerticalGroup(
            toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(username)
                    .addComponent(threadTitle)
                    .addComponent(deleteThreadButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panel.setViewportView(commentPanel);

        replyBtn.setText("Reply");
        replyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                replyBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DisplayPanelLayout = new javax.swing.GroupLayout(DisplayPanel);
        DisplayPanel.setLayout(DisplayPanelLayout);
        DisplayPanelLayout.setHorizontalGroup(
            DisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DisplayPanelLayout.setVerticalGroup(
            DisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );

        jButton1.setText("Exit");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(replyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 326, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 326, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(toolbarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(replyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 224, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 225, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // TODO: need IDs
    // mouse event to create a new thread comment, clear commentPanel, and refresh the window 
    private void replyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_replyBtnMouseClicked
        String body = commentPanel.getText();  // ??
       
        seaQuellers.createComment(thread.id, thread.subId, thread.forumId, body, loggedInUser.id);
        commentPanel.setText("");
        this.refreshThreads();
    }//GEN-LAST:event_replyBtnMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void deleteThreadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteThreadButtonMouseClicked
        seaQuellers.deleteThread(thread.id, thread.subId, thread.forumId);
        subUI.refreshThreads();
        this.dispose();
    }//GEN-LAST:event_deleteThreadButtonMouseClicked

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
            java.util.logging.Logger.getLogger(ThreadUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThreadUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThreadUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThreadUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ThreadUI(new SeaQuellersBBAPI()).setVisible(true);
//            }
//        });
    }
    
    public void refreshThreads(){
        commentPanel.removeAll();
        drawComments();
        commentPanel.revalidate();
        commentPanel.repaint();
        this.pack();
    }
    
    public void drawComments(){
        comments = seaQuellers.getComments(thread.id, thread.subId, thread.forumId);
        DisplayPanel.setLayout(new GridLayout(0, 1)); // One column, unlimited rows
        DisplayPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        JLabel threadBody = new JLabel(thread.body);
        threadBody.setName("" + 0);
        threadBody.setFont(Font.decode("Lucida-Grande-Bold-16"));
        DisplayPanel.add(threadBody);
        DisplayPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        for (int i = 0; i < comments.size(); i++) {
            JLabel commentBody = new JLabel(comments.get(i).body);
            commentBody.setName("" + (i+1));
            commentBody.setFont(Font.decode("Lucida-Grande-Bold-16"));
            DisplayPanel.add(commentBody);
            DisplayPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DisplayPanel;
    private javax.swing.JTextPane commentPanel;
    private javax.swing.JButton deleteThreadButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane panel;
    private javax.swing.JButton replyBtn;
    private javax.swing.JLabel threadTitle;
    private javax.swing.JPanel toolbarPanel;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
