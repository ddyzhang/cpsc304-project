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
public class Thread {
    int id;
    int threadId;
    int subId;
    int forumId;
    String body;
    String postDate;
    String postTime;

    public Thread(int id, int threadId, int subId, int forumId, String body, String postDate, String postTime) {
        this.id = id;
        this.threadId = threadId;
        this.subId = subId;
        this.forumId = forumId;
        this.body = body;
        this.postDate = postDate;
        this.postTime = postTime;
    }
}
