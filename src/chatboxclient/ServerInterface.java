/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatboxclient;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author Mustafa
 */
public interface ServerInterface extends Remote{
    Vector<User> loginRequest(String username,String password,ClientInterface userInt) throws RemoteException;
    String signUp(User newUser,ClientInterface userInt) throws RemoteException;
}
