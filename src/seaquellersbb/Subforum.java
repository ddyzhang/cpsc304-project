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
public class Subforum {
    
    int id;
    int forumId;
    String name;
    String description;
    
    public Subforum(int id, int forumId, String name, String description) {
        this.id = id;
        this.forumId = forumId;
        this.name = name;
        this.description = description;
    }
}
