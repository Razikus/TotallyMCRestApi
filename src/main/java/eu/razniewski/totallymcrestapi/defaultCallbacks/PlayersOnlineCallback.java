/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi.defaultCallbacks;

import eu.razniewski.totallymcrestapi.TotallyCallback;
import eu.razniewski.totallymcrestapi.TotallyMCRestApi;
import eu.razniewski.totallymcrestapi.commandCallback.TotallyCommandSender;
import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author adamr
 */
public class PlayersOnlineCallback extends JavaCallback implements TotallyCallback, Serializable {

    @Override
    public Object callWithParams(Map<String, String> params) {
        return TotallyMCRestApi.getInstance().getServer().getOnlinePlayers().size();
    }
    
}
