/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ehab
 */

public class ClientModal extends UnicastRemoteObject implements Client {

    MainController mainController;
    ClientModal(MainController controller) throws RemoteException {
        this.mainController=controller;
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
