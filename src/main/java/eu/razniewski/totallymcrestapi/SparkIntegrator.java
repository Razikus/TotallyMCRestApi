/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;
import com.google.gson.Gson;
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
        log = Bukkit.getLogger();
        gson = new Gson();
    }
    
    
    
    public void setPort(int port) {
        port(port);
        log.info("Changed port to: " + port);
    }

    void configureFromConfig(TotallyMCRestApiConfiguration configuration) {
        setPort(configuration.getInt(DefaultConfigurationEntry.PORT));
    }
    
    
}
