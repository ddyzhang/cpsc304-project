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
public class Advertisement {
    
    String imageUrl;
    int userId;
    double cpc;
    double cpi;
    String link;
    
    public Advertisement(String url, int userId, double cpc, double cpi, String link) {
        this.imageUrl = url;
        this.userId = userId;
        this.cpc = cpc;
        this.cpi = cpi;
        this.link = link;
    }
    
}
