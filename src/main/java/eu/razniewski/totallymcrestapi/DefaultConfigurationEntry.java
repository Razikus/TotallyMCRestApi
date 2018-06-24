/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;

import eu.razniewski.totallymcrestapi.commandCallback.OutputConfigCommandCallback;
import eu.razniewski.totallymcrestapi.defaultCallbacks.PlayersNicknamesCallback;
import eu.razniewski.totallymcrestapi.defaultCallbacks.PlayersOnlineCallback;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;

/**
 *
 * @author adamr
 */
public enum DefaultConfigurationEntry {
    PORT("port", 8888),
    CALLS("calls.json");

    public static ArrayList<Entrypoint> getDefaultCallbacks() {
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("testToken");
        
        ArrayList<Entrypoint> entries = new ArrayList<>();
        Entrypoint playersOnlineCallback = new Entrypoint(new PlayersOnlineCallback(), "/onlinePlayers", RequestType.GET, true, tokens);
        Entrypoint playersNickname = new Entrypoint(new PlayersNicknamesCallback(), "/onlinePlayersNickname", RequestType.GET, true, tokens);
        
        Entrypoint commandCallback = new Entrypoint(new OutputConfigCommandCallback("?", new HashMap<>()), "/help", RequestType.GET);
        entries.add(playersOnlineCallback);
        entries.add(playersNickname);
        entries.add(commandCallback);
        return entries;
    }
    
    private String name;
    private Serializable object;

    private DefaultConfigurationEntry(String name, Serializable obj) {
        this.name = name.toLowerCase();
        this.object = obj;
    }
    
    private DefaultConfigurationEntry(Serializable obj) {
        this.name = name().toLowerCase();
        this.object = obj;
    }

    public String getName() {
        return name;
    }

    public Serializable getObject() {
        return object;
    }

    @Override
    public String toString() {
        return name;
    }
    
    

    
    
}
