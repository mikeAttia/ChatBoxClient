/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import ChatBox.Server;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author michael
 */
public class ClientModel {

    MainController maincontroller;
    Registry reg;
    Server server;

    ClientModel(MainController controller) {
        maincontroller = controller;

        //Locate Registry
        try {
            reg = LocateRegistry.getRegistry();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean connectToServer(){
        try {
            server = (Server) reg.lookup("ChatBox");
            return true;
        } catch (RemoteException | NotBoundException ex) {
            ex.printStackTrace();
            maincontroller.cantConnectToServer();
            return false;
        }
    }

}
