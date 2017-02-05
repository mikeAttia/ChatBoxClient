/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author michael
 */
public class ChatBoxClientFXMLDocController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    public Hyperlink goToSignUp; 
    
    @FXML
    private Hyperlink backToSignIn;
    
    @FXML
    private Stage stage;
    
    @FXML
    private void goToSignUp(ActionEvent event) throws IOException
    {
        
        Node node=(Node) event.getSource();
        stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SignUpViewFXMLDoc.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
  
  
    }
    
    @FXML
    private void backToSignIn(ActionEvent event) throws IOException
    {
        
        Node node=(Node) event.getSource();
        stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SignInViewFXMLDoc.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
  
  
    }
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
