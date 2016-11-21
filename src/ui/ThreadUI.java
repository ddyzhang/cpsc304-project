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
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private boolean isMod;
    private Comment activeComment;
    /**
     * Creates new form ThreadUI
     */
    public ThreadUI(SeaQuellersBBAPI seaQuellers, seaquellersbb.Thread thread, User user, Forum forum, Subforum subforum, SubforumUI subUI, int[] modIds) {
        initComponents();
        this.seaQuellers = seaQuellers;
        this.thread = thread;
        this.loggedInUser = user;
        this.forum = forum;
        this.subforum = subforum;
        this.subUI = subUI;
        username.setText(loggedInUser.username);
        threadTitle.setText(thread.title);
        this.isMod = (user.isSuperAdmin || forum.userId == user.id || thread.poster.id == user.id || Arrays.stream(modIds).anyMatch(x -> x == user.id));
        if (!isMod) {
            deleteThreadButton.setVisible(false);
            editTitleButton.setVisible(false);
        }
        deleteCommentButton.setVisible(false);
        editButton.setVisible(false);
        cancelEditButton.setVisible(false);
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
        editTitleButton = new javax.swing.JButton();
        panel = new javax.swing.JScrollPane();
        commentPanel = new javax.swing.JTextPane();
        replyBtn = new javax.swing.JButton();
        DisplayPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        cancelEditButton = new javax.swing.JButton();
        deleteCommentButton = new javax.swing.JButton();

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

        editTitleButton.setText("Edit Title");
        editTitleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTitleButtonActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(editTitleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(deleteThreadButton)
                    .addComponent(editTitleButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panel.setViewportView(commentPanel);

        replyBtn.setText("Reply");
        replyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                replyBtnMouseClicked(evt);
            }
        });
        replyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replyBtnActionPerformed(evt);
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

        editButton.setText("Edit");
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editButtonMouseClicked(evt);
            }
        });

        cancelEditButton.setText("Cancel");
        cancelEditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelEditButtonMouseClicked(evt);
            }
        });

        deleteCommentButton.setText("Delete");
        deleteCommentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteCommentButtonMouseClicked(evt);
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
                        .addComponent(deleteCommentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelEditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(jButton1)
                    .addComponent(editButton)
                    .addComponent(cancelEditButton)
                    .addComponent(deleteCommentButton))
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
        String body = commentPanel.getText();
        
        String noSpacesBody = body.replaceAll("\\s+","");
        
        if (noSpacesBody.length() < 1) {
            JOptionPane.showMessageDialog(new JFrame(), "Please enter a comment.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
        seaQuellers.createComment(thread.id, thread.subId, thread.forumId, body, loggedInUser.id);
        commentPanel.setText("");
        this.refreshComments();
        }
    }//GEN-LAST:event_replyBtnMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void deleteThreadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteThreadButtonMouseClicked
        seaQuellers.deleteThread(thread.id, thread.subId, thread.forumId);
        subUI.refreshThreads();
        this.dispose();
    }//GEN-LAST:event_deleteThreadButtonMouseClicked

    private void editButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseClicked
        String body = commentPanel.getText();
        if (body.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Please enter a comment.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (activeComment != null){
            String newCommentBody = commentPanel.getText();
            seaQuellers.editCommentBody(activeComment.id, thread.id, thread.subId, thread.forumId, newCommentBody);
        }
        else {
            String newThreadBody = commentPanel.getText();
            seaQuellers.editThreadBody(thread.id, thread.subId, thread.forumId, newThreadBody);
            thread.body = newThreadBody;
        }
        commentPanel.setText("");
        editButton.setVisible(false);
        cancelEditButton.setVisible(false);
        deleteCommentButton.setVisible(false);
        replyBtn.setVisible(true);
        this.refreshComments();
    }//GEN-LAST:event_editButtonMouseClicked

    private void cancelEditButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelEditButtonMouseClicked
        commentPanel.setText("");
        activeComment = null;
        editButton.setVisible(false);
        cancelEditButton.setVisible(false);
        deleteCommentButton.setVisible(false);
        replyBtn.setVisible(true);
    }//GEN-LAST:event_cancelEditButtonMouseClicked

    private void deleteCommentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCommentButtonMouseClicked
        seaQuellers.deleteComment(activeComment.id, thread.id, thread.subId, thread.forumId);
        commentPanel.setText("");
        activeComment = null;
        editButton.setVisible(false);
        cancelEditButton.setVisible(false);
        deleteCommentButton.setVisible(false);
        replyBtn.setVisible(true);
        this.refreshComments();
    }//GEN-LAST:event_deleteCommentButtonMouseClicked

    private void editTitleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTitleButtonActionPerformed
        String newTitle = JOptionPane.showInputDialog("Please enter the new title: ");
        if (newTitle.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Title cannot be blank.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        seaQuellers.editThreadTitle(thread.id, thread.subId, thread.forumId, newTitle);
        threadTitle.setText(newTitle);
        subUI.refreshThreads();
    }//GEN-LAST:event_editTitleButtonActionPerformed

    private void replyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replyBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_replyBtnActionPerformed

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
    
    public void refreshComments(){
        DisplayPanel.removeAll();
        commentPanel.removeAll();
        drawComments();
        DisplayPanel.revalidate();
        DisplayPanel.repaint();
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
        threadBody.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (thread.poster.id == loggedInUser.id){
                    activeComment = null;
                    commentPanel.setText(threadBody.getText());
                    deleteCommentButton.setVisible(false);
                    replyBtn.setVisible(false);
                    editButton.setVisible(true);
                    cancelEditButton.setVisible(true);
                    deleteCommentButton.setVisible(false);
                }
            }
        });
        DisplayPanel.add(threadBody);
        JLabel poster = new JLabel(thread.poster.username);
        poster.setName("c"+0);
        poster.setFont(Font.decode("Times-New-Roman-11"));
        DisplayPanel.add(poster);
        DisplayPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            JLabel commentBody = new JLabel(comments.get(i).body);
            commentBody.setName("" + (i+1));
            commentBody.setFont(Font.decode("Lucida-Grande-Bold-14"));
            commentBody.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (comment.poster.id == loggedInUser.id){
                    activeComment = comment;
                    commentPanel.setText(commentBody.getText());
                    replyBtn.setVisible(false);
                    editButton.setVisible(true);
                    cancelEditButton.setVisible(true);
                    deleteCommentButton.setVisible(true);
                }
                else if (isMod){
                    activeComment = comment;
                    commentPanel.setText(commentBody.getText());
                    replyBtn.setVisible(false);
                    cancelEditButton.setVisible(true);
                    deleteCommentButton.setVisible(true);
                    
                }
            }
        });
            DisplayPanel.add(commentBody);
            JLabel commenter = new JLabel(comments.get(i).poster.username);
            commenter.setName("c"+(i+1));
            commenter.setFont(Font.decode("Times-New-Roman-9"));
            DisplayPanel.add(commenter);
            DisplayPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DisplayPanel;
    private javax.swing.JButton cancelEditButton;
    private javax.swing.JTextPane commentPanel;
    private javax.swing.JButton deleteCommentButton;
    private javax.swing.JButton deleteThreadButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton editTitleButton;
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
