/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.AccessPoint;
import java.util.List;

/**
 *
 * @author jonibatista
 */
public class SearchAccessPoint {
    private List<AccessPoint> aps;
    
    public SearchAccessPoint(List<AccessPoint> aps){
        this.aps = aps;
    }
    
    public int getApIndex(String bssid){
        for (int i = 0; i < aps.size(); i++) {
            if(aps.get(i).getBssid().equals(bssid)){
                return i;
            }
        }
        
        return -1;
    }
    
}
