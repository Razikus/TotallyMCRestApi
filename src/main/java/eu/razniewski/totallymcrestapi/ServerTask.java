/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.totallymcrestapi;

import org.eclipse.jetty.server.Server;

/**
 *
 * @author adamr
 */
public class ServerTask implements Runnable{
    

    @Override
    public void run() {
        try {
            Server server = new Server(8080);
            server.start();
            server.join();
        } catch (Exception ex) {
        }
    }
    
}
