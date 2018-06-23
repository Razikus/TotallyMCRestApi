/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;

import java.util.Map;

/**
 *
 * @author adamr
 */
public interface TotallyCallback {
    /**
     * Should return something jsonable
     * @param params from entrypoint
     * @return jsonable object
     */
    public Object callWithParams(Map<String, String> params);
}
