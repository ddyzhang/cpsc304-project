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
        ResultSet result = api.executeQuery("SELECT subname FROM subforums, moderators, users "
                + "WHERE subforums.subid = moderators.subid AND subforums.forumid = moderators.forumid "
                + "AND moderators.userid = users.userid AND username = 'testmoderator'");
        try {
            System.out.println("Subforums moderated by 'testmoderator':");
            while(result.next()) {
                System.out.println(result.getString(1));
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
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
}