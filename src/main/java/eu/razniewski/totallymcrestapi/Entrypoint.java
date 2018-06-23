/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;

import java.io.Serializable;

/**
 *
 * @author adamr
 */

public class Entrypoint implements Serializable {
    private TotallyCallback callback;
    private String route;
    private RequestType requestType;

    public Entrypoint(TotallyCallback callback, String route, RequestType requestType) {
        this.callback = callback;
        this.route = route;
        this.requestType = requestType;
    }

    public TotallyCallback getCallback() {
        return callback;
    }

    public String getRoute() {
        return route;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    @Override
    public String toString() {
        return "Entrypoint{" + "callback=" + callback + ", route=" + route + ", requestType=" + requestType + '}';
    }
    
    
    
}
