/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaquellersbb;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author derek
 */
public class SeaQuellersBBAPI {

    /**
     * @param args the command line arguments
     */
    Connection connection;
    
    public static void main(String[] args) {
        SeaQuellersBBAPI api = new SeaQuellersBBAPI();
        api.createUser("ddyzhang", "derekdyzhang@gmail.com", "asdf");
    }
    
    public SeaQuellersBBAPI() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://seaquellersbb.cdtebwg0ez9h.us-west-2.rds.amazonaws.com:5432/seaquellersbb",
                            "seaquellersbb", "compsci304");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    
    private ResultSet executeQuery(String query) {
        try {
            Statement st = connection.createStatement();
            return st.executeQuery(query);
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
    
    private void executeUpdate(String statement) {
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(statement);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public ArrayList<String> getTableInfo(String tableName) {
        try {
            ArrayList<String> tables = new ArrayList<String>();
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, tableName, null);
            while (rs.next()) {
                tables.add(rs.getString(3));
            }
            return tables;
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
        return null;
    }
    
    public ArrayList<Forum> getAllForums() {
        ArrayList<Forum> forums = new ArrayList<Forum>();
        ResultSet result = executeQuery("SELECT * FROM forums");
        try {
            while (result.next()) {
                int forumId = result.getInt("forumid");
                String name = result.getString("forumname");
                String description = result.getString("description");
                int userId = result.getInt("userid");
                Forum forum = new Forum(forumId, name, description, userId);
                forums.add(forum);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return forums;
    }
    
    public ArrayList<Subforum> getSubforums(int forumId) {
        ArrayList<Subforum> subforums = new ArrayList<Subforum>();
        ResultSet result = executeQuery("SELECT * FROM subforums WHERE forumid = " + forumId);
        try {
            while (result.next()) {
                int id = result.getInt("subid");
                String name = result.getString("subname");
                String description = result.getString("description");
                Subforum subforum = new Subforum(id, forumId, name, description);
                subforums.add(subforum);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return subforums;
    }
    
    public ArrayList<Thread> getThreads(int subId, int forumId) {
        // TODO
        return null;        
    }
    
    public ArrayList<Comment> getComments(int threadId, int subId, int forumId) {
        // TODO
        return null;        
    }
    
    public ArrayList<User> getModerators(int subId, int forumId) {
        // TODO
        return null;
    }
    
    public User getUserInfo(int userId) {
        // TODO
        return null;
    }
    
    public ArrayList<AdStatistic> getAdStats() {
        // TODO
        return null;
    }
    
    public ArrayList<AdStatistic> getStatsForAllForumAds() {
        // TODO
        return null;
    }
    
    public Advertisement getRandomAd() {
        // TODO
        return null;
    }
    
    public void createUser(String username, String email, String password) {
        ResultSet result = executeQuery("SELECT * FROM users WHERE username=\'" + username + "\'");
        try {
            if (result.next()) {
                throw new Exception("Username already taken.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        result = executeQuery("SELECT MAX(userid) FROM users");
        try {
            if (result.next()) {
                int id = result.getInt(1) + 1;
                executeUpdate("INSERT INTO users(userid, username, email, password) VALUES (" + id + ", \'" + username + "\', \'" + email + "\', \'" + password + "\')");
            } else {
                throw new RuntimeException("Something is wrong with the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void createForum(String forumName, String description, int userId) {
        ResultSet result = executeQuery("SELECT * FROM users WHERE userid=\'" + userId + "\'");
        try {
            if (result.next()) {
                throw new Exception("User does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        result = executeQuery("SELECT MAX(forumid) FROM forums");
        try {
            if (result.next()) {
                int id = result.getInt(1) + 1;
                executeUpdate("INSERT INTO forums VALUES (" + id + ", \'" + forumName + "\', \'" + description + "\', " + userId + ")");
            } else {
                throw new RuntimeException("Something is wrong with the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void createSubforum(int forumId, String subName, String description) {
        ResultSet result = executeQuery("SELECT * FROM forums WHERE forumid=" + forumId);
        try {
            if (result.next()) {
                throw new Exception("Forum does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        result = executeQuery("SELECT MAX(subid) FROM forums WHERE forumid=" + forumId);
        try {
            if (result.next()) {
                int id = result.getInt(1) + 1;
                executeUpdate("INSERT INTO subforums VALUES (" + id + ", " + forumId + ", \'" + subName + "\', \'" + description + "\')");
            } else {
                throw new RuntimeException("Something is wrong with the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void createThread(int subId, int forumId, String title, String body, int userId) {
        ResultSet result = executeQuery("SELECT * FROM subforums WHERE forumid=" + forumId + " AND subid=" + subId);
        try {
            if (result.next()) {
                throw new Exception("Subforum does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        result = executeQuery("SELECT MAX(threadid) FROM subforums WHERE forumid=" + forumId + " AND subid=" + subId);
        try {
            if (result.next()) {
                int id = result.getInt(1) + 1;
                executeUpdate("INSERT INTO threads(threadid, subid, forumid, title, body, userid)"
                        + " VALUES (" + id + ", " + subId + ", " + forumId + ", \'" + title + "\', \'" + body + "\', " + userId + ")");
            } else {
                throw new RuntimeException("Something is wrong with the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void createComment(int threadId, int subId, int forumId, String body, int userId) {
        ResultSet result = executeQuery("SELECT * FROM threads WHERE forumid=" + forumId + " AND subid=" + subId + " AND threadid=" + threadId);
        try {
            if (result.next()) {
                throw new Exception("Thread does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        result = executeQuery("SELECT MAX(commentid) FROM threads WHERE forumid=" + forumId + " AND subid=" + subId + " AND threadid=" + threadId);
        try {
            if (result.next()) {
                int id = result.getInt(1) + 1;
                executeUpdate("INSERT INTO threads(commentid, threadid, subid, forumid, body, userid)"
                        + " VALUES (" + id + ", " + threadId + ", " + subId + ", " + forumId  + ", \'" + body + "\', " + userId + ")");
            } else {
                throw new RuntimeException("Something is wrong with the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void createAd(String url, int userId, double cpc, double cpi, String link) {
        ResultSet result = executeQuery("SELECT * FROM users WHERE userid=" + userId);
        try {
            if (result.next()) {
                throw new Exception("User does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        result = executeQuery("SELECT * FROM advertisements WHERE imageurl = \'" + url + "\'");
        try {
            if (result.next()) {
                throw new Exception("Ad already exists.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        try {
            if (result.next()) {
                int id = result.getInt(1) + 1;
                executeUpdate("INSERT INTO advertisements VALUES (\'" + url + "\', " + userId + ", " + cpc + ", " + cpi + ", \'" + link + "\')");
            } else {
                throw new RuntimeException("Something is wrong with the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void changeEmail(int userId, String newEmail) {
        // TODO
    }
    
    public void changePassword(int userId, String newPassword) {
        // TODO
    }
    
    public void editThreadTitle(int threadId, int subId, int forumId, String newTitle) {
        // TODO
    }
    
    public void editThreadBody(int threadId, int subId, int forumId, String newBody) {
        // TODO
    }
    
    public void editCommentBody(int commentId, int threadId, int subId, int forumId, String newBody) {
        // TODO
    }
    
    public void changeAdImageUrl(String oldUrl, String newUrl) {
        // TODO
    }
    
    public void changeAdCpc(String url, double newCpc) {
        // TODO
    }
    
    public void changeAdCpi(String url, double newCpi) {
        // TODO
    }
    
    public void changeAdLink(String url, String newLink) {
        // TODO
    }
    
    public void deleteForum(int forumId) {
        // TODO
    }
    
    public void deleteSubforum(int subId, int forumId) {
        // TODO
    }
    
    public void deleteThread(int threadId, int subId, int forumId) {
        // TODO
    }
    
    public void deleteComment(int commentId, int threadId, int subId, int forumId) {
        // TODO
    }
    
    public void deleteModerator(int userId, int subId, int forumId) {
        // TODO
    }
    
    public void deleteAd(String imageUrl) {
        // TODO
    }
    
    public void addModerator(int userId, int subId, int forumId) {
        // TODO
    }
    
    public void pruneThreads(int subId, int forumId, int daysOld) {
        // TODO
    }
    
    public void adSeen(String imageUrl, int forumId) {
        // TODO
    }
    
    public void adClicked(String imageUrl, int forumId) {
        // TODO
    }
}