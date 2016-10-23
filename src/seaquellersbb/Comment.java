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
public class Comment {
    
    int id;
    int subId;
    int forumId;
    String body;
    String postDate;
    String postTime;
    User poster;
    
    public Comment(int id, int subId, int forumId, String body, String postDate, String postTime, User poster) {
        this.id = id;
        this.subId = subId;
        this.forumId = forumId;
        this.body = body;
        this.postDate = postDate;
        this.postTime = postTime;
        this.poster = poster;
    }
    
}
