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
public class AdStatistic {
    
    String imageUrl;
    int forumId;
    String forumName;
    double profit;
    int totalClicks;
    int totalImpressions;
    
    public AdStatistic(String imageUrl, double profit, int totalClicks, int totalImpressions) {
        this.imageUrl = imageUrl;
        this.profit = profit;
        this.totalClicks = totalClicks;
        this.totalImpressions = totalImpressions;
    }
    
    public AdStatistic(int forumId, String forumName, double profit, int totalClicks, int totalImpressions) {
        this.forumId = forumId;
        this.forumName = forumName;
        this.profit = profit;
        this.totalClicks = totalClicks;
        this.totalImpressions = totalImpressions;
    }
    
}
