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
    
    int id;
    int numPosts;
    String signupDate;
    String username;
    
    public User(int id, int numPosts, String signupDate, String username) {
        this.id = id;
        this.numPosts = numPosts;
        this.signupDate = signupDate;
        this.username = username;
    }
}