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
    public int id;
    public int subId;
    public int forumId;
    public String title;
    public String body;
    public String postDate;
    public String postTime;
    public User poster;

    public Thread(int id, int subId, int forumId, String title, String body, String postDate, String postTime, User poster) {
        this.id = id;
        this.subId = subId;
        this.forumId = forumId;
        this.title = title;
        this.body = body;
        this.postDate = postDate;
        this.postTime = postTime;
        this.poster = poster;
    }
}
