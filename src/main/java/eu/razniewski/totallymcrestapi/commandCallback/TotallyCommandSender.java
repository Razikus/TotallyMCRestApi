/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi.commandCallback;

import eu.razniewski.totallymcrestapi.TotallyMCRestApi;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author adamr
 */
public class TotallyCommandSender implements ConsoleCommandSender, CommandSender {

    ConsoleCommandSender sender = TotallyMCRestApi.getInstance().getServer().getConsoleSender();
    private OutputConfigCommandCallback channel;
    TotallyCommandSender(OutputConfigCommandCallback aThis) {
        this.channel = aThis;
    }

    @Override
    public void sendMessage(String string) {
        //sender.sendMessage(string);
        channel.setReturnFromCommand(string);
    }

    @Override
    public void sendMessage(String[] strings) {
        for(String s: strings) {
            sendMessage(s);
        }
    }

    @Override
    public Server getServer() {
        return sender.getServer();
    }

    @Override
    public String getName() {
        return sender.getName();
    }

    @Override
    public Spigot spigot() {
        return sender.spigot();
    }

    @Override
    public boolean isPermissionSet(String string) {
        return sender.isPermissionSet(string);
    }

    @Override
    public boolean isPermissionSet(Permission prmsn) {
        return sender.isPermissionSet(prmsn);
    }

    @Override
    public boolean hasPermission(String string) {
        return sender.hasPermission(string);
    }

    @Override
    public boolean hasPermission(Permission prmsn) {
        return sender.hasPermission(prmsn);
        
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String string, boolean bln) {
        return sender.addAttachment(plugin, string, bln);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return sender.addAttachment(plugin);
        
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String string, boolean bln, int i) {
        return sender.addAttachment(plugin, string, bln, i);
        
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int i) {
        return sender.addAttachment(plugin, i);
        
    }

    @Override
    public void removeAttachment(PermissionAttachment pa) {
        sender.removeAttachment(pa);
        
    }

    @Override
    public void recalculatePermissions() {
        sender.recalculatePermissions();
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return sender.getEffectivePermissions();
    }

    @Override
    public boolean isOp() {
        return sender.isOp();
    }

    @Override
    public void setOp(boolean bln) {
        sender.setOp(bln);
    }

    @Override
    public void acceptConversationInput(String string) {
        sender.acceptConversationInput(string);
    }

    @Override
    public boolean beginConversation(Conversation c) {
        return sender.beginConversation(c);
    }

    @Override
    public void abandonConversation(Conversation c) {
        sender.abandonConversation(c);
    }

    @Override
    public void abandonConversation(Conversation c, ConversationAbandonedEvent cae) {
        sender.abandonConversation(c, cae);
    }

    @Override
    public void sendRawMessage(String string) {
        sender.sendRawMessage(string);
    }

    @Override
    public boolean isConversing() {
        return sender.isConversing();
    }

    
    
    
}
