/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi.commandCallback;

import eu.razniewski.totallymcrestapi.TotallyMCRestApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;

/**
 *
 * @author adamr
 */
public class OutputConfigCommandCallback extends CommandCallback {

    private String command;
    private Map<String, String> additionalParams;
    
    private transient CopyOnWriteArrayList<String> returnFromCommand = null;

    public OutputConfigCommandCallback(String command, Map<String, String> additionalParams) {
        this.command = command;
        this.additionalParams = additionalParams;
        this.returnFromCommand = new CopyOnWriteArrayList<>();
    }
    
    
    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public Map<String, String> getAdditionalParams() {
        return additionalParams;
    }

    @Override
    public Object callWithParams(Map<String, String> params) {
        try {
            String toExecute = parseCommandWithInternalParams(getCommand());
            toExecute = parseCommandWithRequestParams(params, toExecute);
            TotallyMCRestApi instance = TotallyMCRestApi.getInstance();
            Bukkit.getLogger().info("Before command dispatch");
            TotallyCommandSender sender = new TotallyCommandSender(this);
            instance.getServer().dispatchCommand(sender, toExecute);
            Bukkit.getLogger().info("After command dispatch");
        } catch(Exception e) {
            Bukkit.getLogger().info(e.getCause().getMessage());
            e.printStackTrace();
        }
        return returnFromCommand;
        
    }

    public void setReturnFromCommand(String returnFromCommand) {
        //TUNULLPOINTER
        this.returnFromCommand.add("test");
        Bukkit.getLogger().info("ADDED");
    }
    
    
    
}
