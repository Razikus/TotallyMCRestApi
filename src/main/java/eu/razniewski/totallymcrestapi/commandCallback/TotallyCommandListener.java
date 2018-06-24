/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi.commandCallback;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.server.ServerCommandEvent;

/**
 *
 * @author adamr
 */
public class TotallyCommandListener implements Listener {
    
    @EventHandler
    public void onCommand(ServerCommandEvent event) {
        Bukkit.getLogger().info(event.getCommand());
    }
    
    @EventHandler
    public void onMsg(AsyncPlayerChatEvent event) {
        Bukkit.getLogger().info(event.getMessage());
        
    }
    
}
