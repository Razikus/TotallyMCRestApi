/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author adamr
 */
public class PlayersOnlineCallback implements TotallyCallback, Serializable {

    private String className = this.getClass().getCanonicalName();
    
    @Override
    public Object callWithParams(Map<String, String> params) {
        return TotallyMCRestApi.getInstance().getServer().getOnlinePlayers().size();
    }
    
}
