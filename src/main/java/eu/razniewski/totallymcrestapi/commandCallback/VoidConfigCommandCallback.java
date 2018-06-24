/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi.commandCallback;

import com.google.gson.Gson;
import eu.razniewski.totallymcrestapi.TotallyMCRestApi;
import eu.razniewski.totallymcrestapi.Utils;
import java.util.Map;

/**
 *
 * @author adamr
 */
public class VoidConfigCommandCallback extends CommandCallback {

    private String command;
    private Map<String, String> additionalParams;
    
    public VoidConfigCommandCallback(String command, Map<String, String> additionalParams) {
        this.command = command;
        this.additionalParams = additionalParams;
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
        String toExecute = parseCommandWithInternalParams(getCommand());
        toExecute = parseCommandWithRequestParams(params, toExecute);
        TotallyMCRestApi instance = TotallyMCRestApi.getInstance();
        return getGsonInstance().toJson(instance.getServer().dispatchCommand(instance.getServer().getConsoleSender(), toExecute));
    }
    
}
