/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import java.rmi.RemoteException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author michael
 */

public class ChatBoxClient extends Application {
    
    MainController mainController;
    Stage mainStage;
    
    Parent signInRoot;
    Parent signUpRoot;
//    Parent mainViewRoot;
    
    Scene signInScene;
    Scene signUpScene;
    Scene mainViewScene;
    
    SignInViewFXMLController signInController = new SignInViewFXMLController(this);
    SignUpViewFXMLController signUpController = new SignUpViewFXMLController(this);
//    MainViewFXMLController mainViewController = new MainViewFXMLController(this);
    
    FXMLLoader signInLoader = new FXMLLoader();
    FXMLLoader signUpLoader = new FXMLLoader();
//    FXMLLoader mainViewLoader = new FXMLLoader();
    
    @Override
    public void init(){
        
       
       
        
//        mainViewLoader.setController(mainViewController);
//        try {
//            mainViewRoot = mainViewLoader.load(getClass().getResource("MainViewFXMLDoc.fxml").openStream());
//        } catch (IOException ex) {
//            System.out.println("Couldn't load mainview");
//        }
//        mainViewController = mainViewLoader.getController();
        
    }
    

    public ChatBoxClient() throws RemoteException {
        mainController = new MainController(this);
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        mainStage = stage;
        
        signInLoader.setController(signInController);
        signInRoot = signInLoader.load(getClass().getResource("SignInViewFXMLDoc.fxml").openStream());
        signInController = signInLoader.getController();
        
        
        signUpLoader.setController(signUpController);
        signUpRoot = signUpLoader.load(getClass().getResource("SignUpViewFXMLDoc.fxml").openStream());
        signUpController = signUpLoader.getController();
        
        signInScene = new Scene(signInRoot);
        signUpScene = new Scene(signUpRoot);
        
        mainStage.setMinWidth(326);
        mainStage.setMinHeight(647);
        mainStage.setScene(signInScene);
        mainStage.show();
    }
    
    public void switchToSignUpView(){
        mainStage.setScene(signUpScene);
        
    }
    
    public void switchToSignInView(){
        mainStage.setScene(signInScene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
