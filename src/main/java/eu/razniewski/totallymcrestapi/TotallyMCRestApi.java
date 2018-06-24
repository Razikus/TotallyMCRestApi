/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;

import eu.razniewski.totallymcrestapi.commandCallback.TotallyListener;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author adamr
 */
public class TotallyMCRestApi extends JavaPlugin {

    private final static String pluginName = "TotallyMCRestApi";
    
    private TotallyMCRestApiConfiguration configuration;
    private SparkIntegrator integrator;
    
    private Logger log;
    @Override
    public void onEnable() {
        log = getLogger();
        log.info("TotallyMC loading...");
        getServer().getPluginManager().registerEvents(new TotallyListener(), this);
        configuration = new TotallyMCRestApiConfiguration(getConfig(), this);
        configuration.registerDefaults();
        configuration.saveDefaultConfigIfNotExist();
        configuration.saveDefaultEntryPoints();
        integrator = SparkIntegrator.getInstance();
        integrator.configureFromConfig(configuration);
    }

    @Override
    public void onDisable() {
        spark.Spark.stop();
        getLogger().info("TotallyMC DISABLED!");
    }
    
    public static TotallyMCRestApi getInstance() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin(pluginName);
        if (plugin == null || !(plugin instanceof TotallyMCRestApi)) {
            throw new RuntimeException(pluginName + " not found");
        }
 
        return ((TotallyMCRestApi) plugin);
    }
    
    
}
