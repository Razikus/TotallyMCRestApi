/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 *
 * @author adamr
 */
public class JSONTransformer implements ResponseTransformer {

    private Gson gson = Utils.getStandardGsonInstance();
    
    @Override
    public String render(Object o) throws Exception {
        return gson.toJson(o);
    }
    
}
