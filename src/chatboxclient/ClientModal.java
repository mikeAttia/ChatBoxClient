/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ehab
 */
public class ClientModal extends UnicastRemoteObject implements Client {

    MainController mainController;
    static ServerInterface server;
    Registry reg;

    ClientModal(MainController controller) throws RemoteException {

        this.mainController = controller;
    }

    public void lookUp() {
        if (server == null) {

            try {
                reg = LocateRegistry.getRegistry("127.0.0.1",2002);
                String[] services = reg.list();
                for (String service : services) {

                    if ("ChatBox".equals(service.trim())) {
                        System.out.println("service Name "+service);
                        server = (ServerInterface) reg.lookup("ChatBox");
                        
                        break;
                    } else {
                        //error
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
        }

    }

    @Override
    public void displayMsg(String msg) throws RemoteException {

    }

    @Override
    public void showAdvert(String s) throws RemoteException {

    }

    @Override
    public void getNotification(User s, String Status) throws RemoteException {

    }

    @Override
    public void notifyServerStop() throws RemoteException {

    }

    @Override
    public void notifySchduledServerStop(int seconds) throws RemoteException {

    }

    @Override
    public boolean requestFileSend(String... FileName) throws RemoteException {
        return false;

    }

    @Override
    public void SendFile(String fName, byte[] bytes, int len) throws RemoteException {

    }

}
