/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.configuration.file.FileConfiguration;

/**
 *
 * @author adamr
 */
public class TotallyMCRestApiConfiguration {
    private FileConfiguration config;
    private Logger log;
    private TotallyMCRestApi context;


    TotallyMCRestApiConfiguration(FileConfiguration config, TotallyMCRestApi aThis) {
        log = Bukkit.getLogger();
        this.config = config;
        this.context = aThis;
    }

    void registerDefaults() {
        for(DefaultConfigurationEntry entry: DefaultConfigurationEntry.values()) {
            config.addDefault(entry.getName(), entry.getObject());
            log.info("Adding default " + entry.getName());
        }
    }

    void saveDefaultConfigIfNotExist() {
        config.options().copyDefaults(true);
        if(!context.getDataFolder().exists()) {
            log.info("Creating plugin folder");
            context.getDataFolder().mkdirs();
        }
        if(!new File(context.getDataFolder(), "config.yml").exists()) {
        log.info("Saving default config");
            context.saveConfig();
        }
    }
    
    public void saveDefaultEntryPoints() {
        config.options().copyDefaults(true);
        if(!context.getDataFolder().exists()) {
            context.getDataFolder().mkdirs();
        }
        if(!new File(context.getDataFolder(), getString(DefaultConfigurationEntry.CALLS)).exists()) {
            Gson gson = new Gson();
            try {
                try (FileWriter writer = new FileWriter(new File(context.getDataFolder(), getString(DefaultConfigurationEntry.CALLS)))) {
                    writer.write(gson.toJson(DefaultConfigurationEntry.getDefaultCallbacks()));
                }
            } catch (IOException ex) {
                log.info(ex.getMessage());
            }
        }
    }

    public Object get(DefaultConfigurationEntry path) {
        return config.get(path.getName());
    }

    public int getInt(DefaultConfigurationEntry path) {
        return config.getInt(path.getName());
    }

    public boolean getBoolean(DefaultConfigurationEntry path) {
        return config.getBoolean(path.getName());
    }

    public double getDouble(DefaultConfigurationEntry path) {
        return config.getDouble(path.getName());
    }

    public List<Boolean> getBooleanList(DefaultConfigurationEntry path) {
        return config.getBooleanList(path.getName());
    }

    public List<Byte> getByteList(DefaultConfigurationEntry path) {
        return config.getByteList(path.getName());
    }

    public List<Character> getCharacterList(DefaultConfigurationEntry path) {
        return config.getCharacterList(path.getName());
    }

    public Color getColor(DefaultConfigurationEntry path) {
        return config.getColor(path.getName());
    }

    public String getString(DefaultConfigurationEntry path) {
        return config.getString(path.getName());
    }
    
    
    
    
    
    

    
}
