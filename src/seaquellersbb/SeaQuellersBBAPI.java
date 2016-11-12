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
    private Connection connection;
    
    public static void main(String[] args) {
        SeaQuellersBBAPI api = new SeaQuellersBBAPI();
        ArrayList<User> mods = new ArrayList<User>();
        mods = api.getModerators(0, 0);
        System.out.println(mods.get(0).username);
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
    
    public User login(String username, String password) {
        ResultSet result = executeQuery("SELECT * FROM users WHERE username=\'" + username + "\' AND password=\'" + password + "\'");
        try {
            if (result.next()) {
                int userId = result.getInt("userid");
                String email = result.getString("email");
                int numPosts = result.getInt("numposts");
                String signupDate = result.getString("signupdate");
                boolean isadmin = this.isSuperAdmin(userId);
                return new User(userId, numPosts, signupDate, username, email, isadmin);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
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
    
    public ArrayList<Advertisement> getAllAds() {
        ArrayList<Advertisement> ads = new ArrayList<Advertisement>();
        ResultSet result = executeQuery("SELECT * FROM advertisements, users WHERE advertisements.userid = users.userid");
        try {
            while (result.next()) {
                String imageUrl = result.getString("imageurl");
                String username = result.getString("username");
                double cpc = result.getDouble("cpc");
                double cpi = result.getDouble("cpi");
                String link = result.getString("link");
                Advertisement ad = new Advertisement(imageUrl, username, cpc, cpi, link);
                ads.add(ad);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return ads;
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
        ArrayList<Thread> threads = new ArrayList<Thread>();
        ResultSet result = executeQuery("SELECT * FROM threads, users WHERE forumid=" + forumId + 
                " AND subid=" + subId + " AND threads.userid=users.userid");
        try {
            while (result.next()) {
                int id = result.getInt("threadid");
                String title = result.getString("title");
                String body = result.getString("body");
                int postCount = result.getInt("postcount");
                String time = result.getString("threadtime");
                String date = result.getString("threaddate");
                int userId = result.getInt("userid");
                String username = result.getString("username");
                String email = result.getString("email");
                int numPosts = result.getInt("numposts");
                String signupDate = result.getString("signupdate");
                User poster = new User(userId, numPosts, signupDate, username, email);
                Thread thread = new Thread(id, subId, forumId, title, body, date, time, poster);
                threads.add(thread);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return threads;
    }
    
    public ArrayList<Comment> getComments(int threadId, int subId, int forumId) {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        ResultSet result = executeQuery("SELECT * FROM comments, users WHERE forumid=" + forumId + 
                " AND subid=" + subId + " AND threadid=" + threadId + " AND comments.userid=users.userid");
        try {
            while (result.next()) {
                int id = result.getInt("commentid");
                String body = result.getString("body");
                String time = result.getString("posttime");
                String date = result.getString("postdate");
                int userId = result.getInt("userid");
                String username = result.getString("username");
                int numPosts = result.getInt("numposts");
                String signupDate = result.getString("signupdate");
                String email = result.getString("email");
                User poster = new User(userId, numPosts, signupDate, username, email);
                Comment comment = new Comment(id, subId, forumId, body, date, time, poster);
                comments.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return comments;       
    }
    
    public ArrayList<User> getModerators(int subId, int forumId) {
        ArrayList<User> mods = new ArrayList<User>();
        ResultSet result = executeQuery("SELECT * FROM moderators, users WHERE forumid=" + forumId + 
                " AND subid=" + subId + " AND moderators.userid=users.userid");
        try {
            while (result.next()) {
                int userId = result.getInt("userid");
                String username = result.getString("username");
                int numPosts = result.getInt("numposts");
                String signupDate = result.getString("signupdate");
                String email = result.getString("email");
                User mod = new User(userId, numPosts, signupDate, username, email);
                mods.add(mod);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return mods;
    }
    
    public User getUserInfo(int userId) {
        ResultSet result = executeQuery("SELECT * from users WHERE userid=" + userId);
        try {
            if (result.next()) {
                String username = result.getString("username");
                int numPosts = result.getInt("numposts");
                String signupDate = result.getString("signupdate");
                String email = result.getString("email");
                boolean isadmin = this.isSuperAdmin(userId);
                return new User(userId, numPosts, signupDate, username, email, isadmin);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
    
    public boolean  isSuperAdmin(int userId) {
        ResultSet result = executeQuery("SELECT * from Superadmins WHERE userId=" + userId);
        try {
            if (result.next()){
                return result.getInt("userId") == userId;
            }
        }  catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return false;
    }
    public User getMostRecentUser() {
        ResultSet result = executeQuery("SELECT MAX(userid) FROM users");
        int maxId = 0;
        try {
            if (result.next()) {
                maxId = result.getInt(0);
            } else {
                throw new Exception("Something's wrong with the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        result = executeQuery("SELECT * FROM users WHERE userid=" + maxId);
        try {
            if (result.next()) {
                String username = result.getString("username");
                int numPosts = result.getInt("numposts");
                String signupDate = result.getString("signupdate");
                String email = result.getString("email");
                return new User(maxId, numPosts, signupDate, username, email);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
    
    public User getUserWithMostPosts() {
        // If there are multiple users with the same max post count, return the first one
        ResultSet result = executeQuery("SELECT MAX(postcount) FROM users");
        int maxPosts = 0;
        try {
            if (result.next()) {
                maxPosts = result.getInt(0);
            } else {
                throw new Exception("Something's wrong with the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        result = executeQuery("SELECT * FROM users WHERE userid=" + maxPosts);
        try {
            if (result.next()) {
                int id = result.getInt("userid");
                String username = result.getString("username");
                int numPosts = result.getInt("numposts");
                String signupDate = result.getString("signupdate");
                String email = result.getString("email");
                return new User(id, numPosts, signupDate, username, email);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public ArrayList<AdStatistic> getAdStatsByAd() {
        ArrayList<AdStatistic> adstats = new ArrayList<AdStatistic>();
        ResultSet result = executeQuery("SELECT profits.imageurl, SUM(((clicks * cpc) + (impressions * cpi))) AS profit, SUM(clicks) as totalclicks, SUM(impressions) as totalimpressions "
                + "FROM profits "
                + "INNER JOIN advertisements "
                + "ON profits.imageurl = advertisements.imageurl "
                + "GROUP BY profits.imageurl");
	try{
            while (result.next()){
                String imageUrl = result.getString("imageurl");
                double profit = result.getDouble("profit");
                int totalClicks = result.getInt("totalclicks");
                int totalImpressions = result.getInt("totalimpressions");
                AdStatistic stat = new AdStatistic(imageUrl, profit, totalClicks, totalImpressions);
                adstats.add(stat);
            }
	} catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
	
	}

        return adstats;
    }
    
    public ArrayList<AdStatistic> getAdStatsByForum() {
        ArrayList<AdStatistic> adstats = new ArrayList<AdStatistic>();
        ResultSet result = executeQuery("SELECT profits.forumid, forumname, SUM(((clicks * cpc) + (impressions * cpi))) AS profit, SUM(clicks) as totalclicks, SUM(impressions) as totalimpressions "
                + "FROM profits "
                + "INNER JOIN advertisements "
                + "ON profits.imageurl = advertisements.imageurl "
                + "INNER JOIN forums "
                + "ON profits.forumid = forums.forumid"
                + " GROUP BY profits.forumid, forums.forumname");
	try{
            while (result.next()){
                int forumId = result.getInt("forumid");
                String forumName = result.getString("forumname");
                double profit = result.getDouble("profit");
                int totalClicks = result.getInt("totalclicks");
                int totalImpressions = result.getInt("totalimpressions");
                AdStatistic stat = new AdStatistic(forumId, forumName, profit, totalClicks, totalImpressions);
                adstats.add(stat);
            }
	} catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
	
	}

        return adstats;
    }
    //division where you return all imageurls who have a list of forumids
    public ArrayList<AdStatistic> getStatsForAllForumAds() { 
        
        ArrayList<AdStatistic> adstats = new ArrayList<AdStatistic>();
        ResultSet result = executeQuery("SELECT * "
                + "FROM advertisements a "
                + "WHERE NOT EXISTS "
                    + "(SELECT forumid "
                    + "FROM forums "
                    + "EXCEPT "
                    + "SELECT forumid "
                    + "FROM profits p "
                    + "WHERE p.imageurl = a.imageurl)");					
	try{
            if (result.next()){
                String imageUrl = result.getString("imageurl");
                double profit = result.getDouble("profit");
                int totalClicks = result.getInt("totalclicks");
                int totalImpressions = result.getInt("totalimpressions");
                AdStatistic stat = new AdStatistic(imageUrl, profit, totalClicks, totalImpressions);
                adstats.add(stat);
            }
	} catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
	
	}

        return adstats;
    }
    
    public Advertisement getRandomAd() {
        ResultSet result = executeQuery("SELECT * FROM advertisements, users WHERE advertisements.userid = users.userid ORDER BY random() LIMIT 1");
        try {
            if (result.next()) {
                String imageUrl = result.getString("imageurl");
                String link = result.getString("link");
                double cpc = result.getDouble("cpc");
                double cpi = result.getDouble("cpi");
                String username = result.getString("username");
                return new Advertisement(imageUrl, username, cpc, cpi, link);
            } else {
                throw new Exception("Something's wrong with the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
    
    public boolean createUser(String username, String email, String password) {
        ResultSet result = executeQuery("SELECT * FROM users WHERE username=\'" + username + "\'");
        try {
            if (result.next()) {
                return false;
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
        return true;
    }
    
    public void createForum(String forumName, String description, int userId) {
        ResultSet result = executeQuery("SELECT * FROM users WHERE userid=\'" + userId + "\'");
        try {
            if (!result.next()) {
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
                executeUpdate("INSERT INTO forums VALUES (" + id + ", \'" + forumName.replace("'", "''") + "\', \'" + description.replace("'", "''") + "\', " + userId + ")");
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
            if (!result.next()) {
                throw new Exception("Forum does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        result = executeQuery("SELECT MAX(subid) FROM subforums WHERE forumid=" + forumId);
        try {
            if (result.next()) {
                int id = result.getInt(1) + 1;
                executeUpdate("INSERT INTO subforums VALUES (" + id + ", " + forumId + ", \'" + subName.replace("'", "''") + "\', \'" + description.replace("'", "''") + "\')");
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
            if (!result.next()) {
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
                        + " VALUES (" + id + ", " + subId + ", " + forumId + ", \'" + title.replace("'", "''") + "\', \'" + body.replace("'", "''") + "\', " + userId + ")");
            } else {
                throw new RuntimeException("Something is wrong with the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        executeUpdate("UPDATE users SET postcount = postcount + 1 WHERE userid=" + userId);
    }
    
    public void createComment(int threadId, int subId, int forumId, String body, int userId) {
        ResultSet result = executeQuery("SELECT * FROM threads WHERE forumid=" + forumId + " AND subid=" + subId + " AND threadid=" + threadId);
        try {
            if (!result.next()) {
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
                        + " VALUES (" + id + ", " + threadId + ", " + subId + ", " + forumId  + ", \'" + body.replace("'", "''") + "\', " + userId + ")");
            } else {
                throw new RuntimeException("Something is wrong with the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        executeUpdate("UPDATE users SET postcount = postcount + 1 WHERE userid=" + userId);
    }
    
    public void createAd(String url, int userId, double cpc, double cpi, String link) {
        ResultSet result = executeQuery("SELECT * FROM users WHERE userid=" + userId);
        try {
            if (!result.next()) {
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
        executeUpdate("UPDATE users SET email=\'" + newEmail + "\' WHERE userid=" + userId);
    }
    
    public void changePassword(int userId, String newPassword) {
        executeUpdate("UPDATE users SET password=\'" + newPassword + "\' WHERE userid=" + userId);
    }
    
    public void editThreadTitle(int threadId, int subId, int forumId, String newTitle) {
        executeUpdate("UPDATE threads SET title=\'" + newTitle + "\' WHERE threadid=" + threadId + " AND subid=" + subId + " AND forumid=" + forumId);
    }
    
    public void editThreadBody(int threadId, int subId, int forumId, String newBody) {
        executeUpdate("UPDATE threads SET body=\'" + newBody + "\' WHERE threadid=" + threadId + " AND subid=" + subId + " AND forumid=" + forumId);
    }
    
    public void editCommentBody(int commentId, int threadId, int subId, int forumId, String newBody) {
        executeUpdate("UPDATE comments SET body=\'" + newBody + "\' WHERE threadid=" + threadId + " AND subid=" + subId + " AND forumid=" + forumId + " AND commentid=" + commentId);
    }
    
    public void changeAdImageUrl(String oldUrl, String newUrl) {
        executeUpdate("UPDATE advertisements SET imageurl=\'" + newUrl + "\' WHERE imageurl=\'" + oldUrl + "\'");
    }
    
    public void changeAdCpc(String url, double newCpc) {
        executeUpdate("UPDATE advertisements SET cpc=" + newCpc + " WHERE imageurl=\'" + url + "\'");
    }
    
    public void changeAdCpi(String url, double newCpi) {
        executeUpdate("UPDATE advertisements SET cpc=" + newCpi + " WHERE imageurl=\'" + url + "\'");
    }
    
    public void changeAdLink(String url, String newLink) {
        executeUpdate("UPDATE advertisements SET link=\'" + newLink + "\' WHERE imageurl=\'" + url + "\'");
    }
    
    public void deleteForum(int forumId) {
        executeUpdate("DELETE FROM forums WHERE forumid=" + forumId);
    }
    
    public void deleteSubforum(int subId, int forumId) {
        executeUpdate("DELETE FROM subforums WHERE forumid=" + forumId + " AND subid=" + subId);
    }
    
    public void deleteThread(int threadId, int subId, int forumId) {
        executeUpdate("DELETE FROM threads WHERE forumid=" + forumId + " AND subid=" + subId + " AND threadid=" + threadId);
    }
    
    public void deleteComment(int commentId, int threadId, int subId, int forumId) {
        executeUpdate("DELETE FROM comments WHERE forumid=" + forumId + " AND subid=" + subId + " AND threadid=" + threadId + " AND commentid=" + commentId);
    }
    
    public void deleteModerator(int userId, int subId, int forumId) {
        executeUpdate("DELETE FROM moderators WHERE userid=" + userId + " AND subid=" + subId + " AND forumid=" + forumId);
    }
    
    public void deleteAd(String imageUrl) {
        executeUpdate("DELETE FROM advertisements WHERE imageurl=\'" + imageUrl + "\'");
    }
    
    public void addModerator(int userId, int subId, int forumId) {
        executeUpdate("INSERT INTO moderators VALUES (" + userId + ", " + forumId + ", " + subId + ")");
    }
    
    public void pruneThreads(int subId, int forumId, int daysOld) {
        executeUpdate("DELETE FROM threads WHERE threaddate < now() - INTERVAL \'" + daysOld + " days\' AND postcount=0");        
    }
    
    public void adSeen(String imageUrl, int forumId) {
        executeUpdate("UPDATE profits SET impressions = impressions + 1 WHERE imageurl=\'" + imageUrl + "\' AND forumid=" + forumId);
    }
    
    public void adClicked(String imageUrl, int forumId) {
        executeUpdate("UPDATE profits SET clicks = clicks + 1 WHERE imageurl=\'" + imageUrl + "\' AND forumid=" + forumId);
    }
}
