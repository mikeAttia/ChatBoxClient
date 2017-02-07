/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import java.rmi.RemoteException;
/**
 *
 * @author Michael
 */
public class MainController{

     ClientImp clientObj;
     ChatBoxClient application;
     ClientModel model;
     
     
    //Constructor that takes FXMLController and creates objects of other classes
    public MainController(ChatBoxClient app) throws RemoteException {
        clientObj=new ClientImp(this);
        application = app;
        model = new ClientModel(this); 
    }
    
    public void cantConnectToServer(){
        application.signInController.cantConnectToServer();
    }
    
    //TODO: can't connect to server for SignUP view
    
    public boolean connectToServer(){
        return model.connectToServer();
    }
}
