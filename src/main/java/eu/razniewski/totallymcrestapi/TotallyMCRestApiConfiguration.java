/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
        log = TotallyMCRestApi.getInstance().getLogger();
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
            Gson gson = Utils.getStandardGsonInstance();
            try {
                try (FileWriter writer = new FileWriter(new File(context.getDataFolder(), getString(DefaultConfigurationEntry.CALLS)))) {
                    writer.write(gson.toJson(DefaultConfigurationEntry.getDefaultCallbacks()));
                }
            } catch (IOException ex) {
                log.info(ex.getMessage());
            }
        }
    }
    
    public Entrypoint[] deserializeEntrypoints() {
        FileInputStream fis = null;
        Entrypoint[] rets = new Entrypoint[0];
        try {
            File file = new File(context.getDataFolder(), getString(DefaultConfigurationEntry.CALLS));
            fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String str = new String(data, "UTF-8");
            rets = Utils.getStandardGsonInstance().fromJson(str, Entrypoint[].class);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TotallyMCRestApiConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TotallyMCRestApiConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(TotallyMCRestApiConfiguration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rets;
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
