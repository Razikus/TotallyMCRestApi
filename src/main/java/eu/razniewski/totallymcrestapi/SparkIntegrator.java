/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import static spark.Spark.*;
/**
 *
 * @author adamr
 */
public class SparkIntegrator {
    
    private static SparkIntegrator instance = null;
    private Logger log;
    private Gson gson;
    
    public static SparkIntegrator getInstance() {
        if(instance == null) {
            instance = new SparkIntegrator();
        } 
        return instance;
    }

    public SparkIntegrator() {
        log = TotallyMCRestApi.getInstance().getLogger();
        gson = Utils.getStandardGsonInstance();
    }
    
    
    
    public void setPort(int port) {
        port(port);
        log.info("Changed port to: " + port);
    }
    
    boolean fromEntryPoint(Entrypoint entryPoint) {
        log.info("Adding entrypoint: " + entryPoint.getRoute() + " " + entryPoint.getRequestType().name() + " " + entryPoint.getCallback().getClass().getCanonicalName());
        switch(entryPoint.getRequestType()) {
            case GET:
                get(entryPoint.getRoute(), (rqst, rspns) -> {
                    TotallyMCRestApi.getInstance().getLogger().info(entryPoint.getRequestType() + " Callback " + entryPoint.getRoute() + " executed from " + rqst.ip());
                    rspns.type("application/json");
                    return entryPoint.getCallback().callWithParams(rqst.params());
                });
            case DELETE:
                delete(entryPoint.getRoute(), (rqst, rspns) -> {
                    TotallyMCRestApi.getInstance().getLogger().info(entryPoint.getRequestType() + " Callback " + entryPoint.getRoute() + " executed from " + rqst.ip());
                    rspns.type("application/json");
                    return entryPoint.getCallback().callWithParams(rqst.params());
                });
            case PUT:
                put(entryPoint.getRoute(), (rqst, rspns) -> {
                    TotallyMCRestApi.getInstance().getLogger().info(entryPoint.getRequestType() + " Callback " + entryPoint.getRoute() + " executed from " + rqst.ip());
                    rspns.type("application/json");
                    return entryPoint.getCallback().callWithParams(rqst.params());
                });
            case POST:
                post(entryPoint.getRoute(), (rqst, rspns) -> {
                    TotallyMCRestApi.getInstance().getLogger().info(entryPoint.getRequestType() + " Callback " + entryPoint.getRoute() + " executed from " + rqst.ip());
                    rspns.type("application/json");
                    return entryPoint.getCallback().callWithParams(rqst.params());
                });
        }
        return true;
    }

    void configureFromConfig(TotallyMCRestApiConfiguration configuration) {
        
        setPort(configuration.getInt(DefaultConfigurationEntry.PORT));
        for(Entrypoint entry: configuration.deserializeEntrypoints()) {
            fromEntryPoint(entry);
        }
    }
    
    
}
