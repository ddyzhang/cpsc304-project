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
    String title;
    String body;
    int postCount;
    String threadDate;
    String threadTime;
    int userId;
    
    public Comment(int id, int subId, int forumId, String title, String body, int postCount, String postDate, String postTime, int userId) {
        this.id = id;
        this.subId = subId;
        this.forumId = forumId;
        this.title = title;
        this.body = body;
        this.postCount = postCount;
        this.threadDate = postDate;
        this.threadTime = postTime;
        this.userId = userId;
    }
    
}
