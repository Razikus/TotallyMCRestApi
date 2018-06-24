/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi.commandCallback;

import eu.razniewski.totallymcrestapi.TotallyCallback;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author adamr
 */
public abstract class CommandCallback implements TotallyCallback, Serializable {
    
    public abstract String getCommand();
    public abstract Map<String, String> getAdditionalParams();
    
    public String parseCommandWithInternalParams(String cmd) {
        String ret = cmd;
        for(String key: getAdditionalParams().keySet()) {
            ret = ret.replaceAll(getFormattedStandardKey(key), getAdditionalParams().get(key));
        }
        return ret;
    }
    
    public String parseCommandWithRequestParams(Map<String, String> req, String cmd) {
        String ret = cmd;
        for(String key: req.keySet()) {
            ret = ret.replaceAll(getFormattedExternalKey(key), req.get(key));
        }
        return ret;
    }
    
    private String getFormattedStandardKey(String from) {
        return "{%" + from + "%}";
    }
    
    private String getFormattedExternalKey(String from) {
        return "{" + from + "}";
    }
}
