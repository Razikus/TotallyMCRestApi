/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author adamr
 */
public class TotallyMCRestApi extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("TotallyMC loading...");
        spark.Spark.get("/playersOnline", (req, res) -> getServer().getOnlinePlayers().size());
        spark.Spark.get("/bc/:text", (req, res) ->  {
            getServer().broadcastMessage(req.params(":text"));
            return true;
        });
        spark.Spark.get("/players", (req, res) ->  {
            return getServer().getOnlinePlayers();
        });
        
        spark.Spark.get("/kick/:name", (req, res) ->  {
            getServer().getPlayer(req.params(":name")).kickPlayer("LOL");
            return true;
        });
        
        spark.Spark.get("/kick/:name", (req, res) ->  {
            getServer().getPlayer(req.params(":name")).kickPlayer("LOL");
            return true;
        });
        //Bukkit.getScheduler().runTaskAsynchronously(this, new ServerTask());
    }

    @Override
    public void onDisable() {
        spark.Spark.stop();
        getLogger().info("TotallyMC DISABLED!");
    }
    
    
    
}
