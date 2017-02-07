/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

/**
 *
 * @author michael
 */
public class MainViewFXMLController implements Initializable{
    
    ChatBoxClient application;
    
    @FXML
    public Image userImage; 
    
    @FXML
    private Text userNameLabel;

    @FXML
    private TextField searchField;

    @FXML
    private TextArea announceArea;
    
    @FXML
    private ChoiceBox userStatus;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public MainViewFXMLController(ChatBoxClient application) {
        this.application = application;
    }
    
}
