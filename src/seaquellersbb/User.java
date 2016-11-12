/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaquellersbb;

/**
 *
 * @author derek
 */
public class User {
    
    public int id;
    public int numPosts;
    public String signupDate;
    public String username;
    public String email;
    public boolean isSuperAdmin;
    
    public User(int id, int numPosts, String signupDate, String username, String email) {
        this.id = id;
        this.numPosts = numPosts;
        this.signupDate = signupDate;
        this.username = username;
        this.email = email;
        this.isSuperAdmin = false;
    }
    
    public User(int id, int numPosts, String signupDate, String username, String email, boolean isadmin) {
        this.id = id;
        this.numPosts = numPosts;
        this.signupDate = signupDate;
        this.username = username;
        this.email = email;
        this.isSuperAdmin = isadmin;
    }
    
}
