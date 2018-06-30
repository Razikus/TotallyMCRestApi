/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi.groovyCallbacks;

import eu.razniewski.totallymcrestapi.TotallyCallback;
import java.util.Map;

/**
 *
 * @author RAZ
 */
public class BadGroovyCallback implements TotallyCallback {

    public BadGroovyCallback() {
    }

    @Override
    public Object callWithParams(Map<String, String> params) {
        return "ERROR :( Contact administrator";
    }
    
}
