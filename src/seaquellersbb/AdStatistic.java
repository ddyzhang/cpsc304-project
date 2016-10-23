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
    String forumName;
    double profit;
    double avgClicks;
    double avgImpressions;
    
    public AdStatistic(String imageUrl, String forumName, double profit, double avgClicks, double avgImpressions) {
        this.imageUrl = imageUrl;
        this.forumName = forumName;
        this.profit = profit;
        this.avgClicks = avgClicks;
        this.avgImpressions = avgImpressions;
    }
    
}
