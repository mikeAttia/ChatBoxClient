/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import ChatBox.Client;
import ChatBox.User;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ehab
 */

public class ClientImp extends UnicastRemoteObject implements Client {

    MainController mainController;
    ClientImp(MainController controller) throws RemoteException {
        this.mainController=controller;
    }

    @Override
    public void switchToMainView(User userData) throws RemoteException {
        System.out.println("Sign in successful");
    }

    @Override
    public void appednContact(User contactData) throws RemoteException {
        System.out.println("appending contact");
        
    }

    @Override
    public void sendAnnouncement(String message) throws RemoteException {
    
    }

    @Override
    public void startChatWindow() throws RemoteException {
    
    }

    @Override
    public void notifyServerClosing() throws RemoteException {
    
    }

    @Override
    public void sendMessage(String msgXML) throws RemoteException {
    
    }

    @Override
    public void sendNotification(String notification) throws RemoteException {
    
    }

    @Override
    public boolean requestFileSend(String... fileName) throws RemoteException {
        return false; // to be modified
     
    }

    @Override
    public void sendFile(String fName, byte[] bytes, int len) throws RemoteException {
    
    }

    @Override
    public void signInErrMsg(int errorNUM) throws RemoteException {
        System.out.println("Sign in error message");
    }

    @Override
    public void signUpErrMsg(int errorNUM) throws RemoteException {
        
    }

}
