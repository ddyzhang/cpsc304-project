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
    
    public String imageUrl;
    public int forumId;
    public String forumName;
    public double profit;
    public int totalClicks;
    public int totalImpressions;
    
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
