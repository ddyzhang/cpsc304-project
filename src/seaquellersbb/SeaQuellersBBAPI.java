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
        ArrayList<Subforum> subforums = new ArrayList<Subforum>();
        subforums = api.getSubforums(4);
        for(int i = 0; i < subforums.size(); i++) {
            System.out.println(subforums.get(i).name);
        }
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
    
    public ResultSet executeQuery(String query) {
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
}