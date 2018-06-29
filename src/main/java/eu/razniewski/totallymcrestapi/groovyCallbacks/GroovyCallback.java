/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi.groovyCallbacks;

import eu.razniewski.totallymcrestapi.TotallyCallback;
import eu.razniewski.totallymcrestapi.TotallyMCRestApi;
import groovy.lang.GroovyClassLoader;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.groovy.control.CompilationFailedException;

/**
 *
 * @author RAZ
 */
public class GroovyCallback implements Serializable, TotallyCallback{
    private String fileName;
    
    public transient Class loadClass;
    public transient TotallyCallback groovyProxyInstance;

    public TotallyCallback getProxyInstance() {
        if(groovyProxyInstance == null) {
            try {
                loadInstance();
            } catch (CompilationFailedException ex) {
                TotallyMCRestApi.getInstance().getLogger().info("Compilation failed! " + ex.getMessage());
            } catch (IOException ex) {
                TotallyMCRestApi.getInstance().getLogger().info("Something wrong with file! " + ex.getMessage());
            } catch (InstantiationException ex) {
                TotallyMCRestApi.getInstance().getLogger().info("Cannot instance groovy class. It is implements TotallyCallback? " + ex.getMessage());
            } catch (IllegalAccessException ex) {
                TotallyMCRestApi.getInstance().getLogger().info("Cannot instance groovy class. It is implements TotallyCallback and have public constructor with no parameters? " + ex.getMessage());
            }
            if(groovyProxyInstance == null) {
                groovyProxyInstance = new BadGroovyCallback();
            }
        } 
        return groovyProxyInstance;
    }
    
    @Override
    public Object callWithParams(Map<String, String> params) {
        return getProxyInstance().callWithParams(params);
    }

    private void loadInstance() throws CompilationFailedException, IOException, InstantiationException, IllegalAccessException {
        GroovyClassLoader loader = new GroovyClassLoader(TotallyMCRestApi.class.getClassLoader());
        Class example = loader.parseClass(new File(fileName));
        TotallyCallback callback = (TotallyCallback) example.newInstance();
        groovyProxyInstance = callback;
    }
    
}
