/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;

import java.io.Serializable;
import java.util.ArrayList;
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
        ArrayList<Entrypoint> entries = new ArrayList<>();
        Entrypoint playersOnlineCallback = new Entrypoint(new PlayersOnlineCallback(), "/onlinePlayers", RequestType.GET);
        entries.add(playersOnlineCallback);
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
