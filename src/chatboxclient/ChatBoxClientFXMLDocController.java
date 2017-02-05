/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author michael
 */
public class ChatBoxClientFXMLDocController implements Initializable {
    
    /*----------------------------------------------------------------
        References to FXML elements with ids
    ----------------------------------------------------------------*/
    
    @FXML
    private Label label;
    
    @FXML
    public Hyperlink goToSignUp; 
    
    @FXML
    private Hyperlink backToSignIn;
    
    @FXML
    private Stage stage;

    @FXML
    private Text errorText;

    @FXML
    private TextField loginUserName;

    @FXML
    private PasswordField loginPassword;

    /*----------------------------------------------------------------
        Assigning actions to elements in FXML
    ----------------------------------------------------------------*/
    
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
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
     @FXML
    private void handleSignInButton(ActionEvent event) {
        
         boolean flagPassword = false;
         String strLogin = loginUserName.getText();
         String strPassword = loginPassword.getText();
         if (((strPassword.length()) != 0) && (strPassword.isEmpty()==false)) {
             flagPassword = true;
         }
         else{
             flagPassword=false;
         }
         // flagPassword=((strPassword.length())!=0);
         boolean userNameFieldOk = validateUserNameField(strLogin);
         System.out.println("userNameFiled" + userNameFieldOk + "password" + flagPassword);
         if ((userNameFieldOk == true) && (flagPassword == true)) {
               
           }
           }
    
    /*----------------------------------------------------------------
        Helper methods
    ----------------------------------------------------------------*/
    boolean validateUserNameField(String usernameFieldString)
    {
    boolean flagUserName;
    boolean flagEmail;
    flagUserName= validateUserName(usernameFieldString);
    flagEmail=validateEmail(usernameFieldString);
    
    if((flagUserName==true)&&(flagEmail==false))
    {
        //user entered username
        return true;
    }
    
    else if((flagUserName==false)&&(flagEmail==true))
    {
        // user enterd email
        return true;
    
    }
    else {
    
        // user entered invalid username or email
        return false;
    }
    
    }
    boolean validateUserName(String username)
    {
        Pattern p = Pattern.compile("^[a-zA-Z](([\\._\\-][a-zA-Z0-9])|[a-zA-Z0-9])*[a-z0-9]$");
        Matcher m = p.matcher(username);
        boolean b = m.matches();
        return b;
    }
    
    boolean validateEmail(String email)
    {
          Pattern p = Pattern.compile("^[a-zA-Z._-]+[a-zA-Z0-9._-]+@[a-zA-Z.-]+\\.[a-zA-Z]{2,4}$");
        Matcher m = p.matcher(email);
        boolean b = m.matches();
        return b;
        
       
    }
    
}
