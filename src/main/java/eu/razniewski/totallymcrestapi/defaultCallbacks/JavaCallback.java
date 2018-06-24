/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi.defaultCallbacks;

import com.google.gson.Gson;
import eu.razniewski.totallymcrestapi.TotallyCallback;
import eu.razniewski.totallymcrestapi.Utils;
import java.io.Serializable;

/**
 *
 * @author adamr
 */
public abstract class JavaCallback implements TotallyCallback, Serializable{
    
    private Gson gsonInstance;
    
    public Gson getGsonInstance() {
        if(gsonInstance == null) {
            gsonInstance = Utils.getStandardGsonInstance();
        }
        return gsonInstance;
    }
}
