/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi.defaultCallbacks;

import eu.razniewski.totallymcrestapi.TotallyCallback;
import eu.razniewski.totallymcrestapi.TotallyMCRestApi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bukkit.entity.Player;

/**
 *
 * @author adamr
 */
public class PlayersNicknamesCallback extends JavaCallback implements TotallyCallback, Serializable {

    @Override
    public Object callWithParams(Map<String, String> params) {
        ArrayList<String> players = new ArrayList<>();
        for(Player p: TotallyMCRestApi.getInstance().getServer().getOnlinePlayers()) {
            players.add(p.getName());
        }
        return players;
    }
    
}
