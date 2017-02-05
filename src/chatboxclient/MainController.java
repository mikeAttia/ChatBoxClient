/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author ehab
 */
public class MainController{

     ClientModal clientModal;
     ChatBoxClientFXMLDocController fxmlController;
     ChatBoxClient application;
     
     
    //Constructor that takes FXMLController and creates objects of other classes
    public MainController(ChatBoxClientFXMLDocController fxmlCtrlr) throws RemoteException {
        System.out.println("sad");
        clientModal=new ClientModal(this);
        fxmlController = fxmlCtrlr;
    }
}
