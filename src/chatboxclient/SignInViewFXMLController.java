/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import ChatBox.Client;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author michael
 */
public class SignInViewFXMLController implements Initializable {

    ChatBoxClient application;

    /*----------------------------------------------------------------
        Overridign Default Constructor
    ----------------------------------------------------------------*/

    public SignInViewFXMLController(ChatBoxClient application) {
        this.application = application;
    }

    /*----------------------------------------------------------------
        References to FXML elements with ids
    ----------------------------------------------------------------*/
    @FXML
    public Hyperlink goToSignUp;

    @FXML
    private Text errorText;

    @FXML
    private TextField loginUserName;

    @FXML
    private PasswordField loginPassword;

    /*----------------------------------------------------------------
        Assigning actions to elements in FXML
    ----------------------------------------------------------------*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void goToSignUp(ActionEvent event) throws IOException {
        application.switchToSignUpView();
    }

    @FXML
    private void handleSignInButton(ActionEvent event) {

        //If all validations passed
        boolean flagPassword = false;
        String strLogin = loginUserName.getText();
        String strPassword = loginPassword.getText();
        if (((strPassword.length()) != 0) && (strPassword.isEmpty() == false)) {
            flagPassword = true;
        } else {
            flagPassword = false;
        }

        String userNameField = validateUserNameField(strLogin);
        System.out.println("in iuser name field " + userNameField);
        boolean userNameFieldOk = !(userNameField.isEmpty());
        System.out.println("userNameFiled" + userNameFieldOk + "password" + flagPassword);
        if ((userNameFieldOk == true) && (flagPassword == true)) {
            //TODO: application.connectToServer---> call function from class aplication that connect to server  
            if (application.mainController.connectToServer()) {
                try {
                    application.mainController.model.server.loginRequest(strLogin, strPassword, new ClientImp(application.mainController));
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                    System.out.println("el error ely msh fahmeno");
                }
            }
            // mainController.server.loginRequest(mailOrPassword, password, flag, clientObj); --> to be done on connectToServer function in class application 
        } else {
            errorText.setText("please enter a valid data");

        }
    }

    /*----------------------------------------------------------------
        Helper methods
    ----------------------------------------------------------------*/
    public void cantConnectToServer() {
        System.out.println("error msg");
        errorText.setText("Cann't connect to the Server");
    }

    String validateUserNameField(String usernameFieldString) //aghyr esmaha validateLoginFields;
    {
        boolean flagUserName;
        boolean flagEmail;
        String usernameOrEmail;
        flagUserName = validateUserName(usernameFieldString);
        flagEmail = validateEmail(usernameFieldString);

        if ((flagUserName == true) && (flagEmail == false)) {
            //user entered username
            usernameOrEmail = "username";
            return usernameOrEmail;
        } else if ((flagUserName == false) && (flagEmail == true)) {
            // user enterd email
            usernameOrEmail = "email";
            return usernameOrEmail;

        } else {
            usernameOrEmail = "username";
//            usernameOrEmail = null;
            errorText.setText("please enter a valid username or email");
            return usernameOrEmail;
        }
    }

    boolean validateUserName(String username) {
        Pattern p = Pattern.compile("^[a-zA-Z](([\\._\\-][a-zA-Z0-9])|[a-zA-Z0-9])*[a-z0-9]$");
        Matcher m = p.matcher(username);
        boolean b = m.matches();
        return b;
    }

    boolean validateEmail(String email) {
        Pattern p = Pattern.compile("^[a-zA-Z._-]+[a-zA-Z0-9._-]+@[a-zA-Z.-]+\\.[a-zA-Z]{2,4}$");
        Matcher m = p.matcher(email);
        boolean b = m.matches();
        return b;

    }
}
