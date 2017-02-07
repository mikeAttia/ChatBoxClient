/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxclient;

import ChatBox.User;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

/**
 *
 * @author michael
 */
public class SignUpViewFXMLController implements Initializable {

    ChatBoxClient application;
    String dateReturned; 
    String genderSelected;
    /*----------------------------------------------------------------
        Overridign Default Constructor
    ----------------------------------------------------------------*/
    public SignUpViewFXMLController(ChatBoxClient application) {
        this.application = application;
    }

    /*----------------------------------------------------------------
        References to FXML elements with ids
    ----------------------------------------------------------------*/
    @FXML
    private Hyperlink backToSignIn;

    @FXML
    private TextField loginUserName;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private TextField signupUserName;

    @FXML
    private TextField signupEmail;

    @FXML
    private PasswordField signupPassword;

    @FXML
    private PasswordField signupConfirmPassword;

    @FXML
    private TextField signupPhone;

    @FXML
    private RadioButton signupMale;

    @FXML
    private RadioButton signupFemale;

    @FXML
    private DatePicker signupDatePicker;

    @FXML
    private ChoiceBox<String> signupChoiceBoxCountry;

    @FXML
    private Text signupErrorMsg;

    @FXML
    private Button signupBtn;

    /*----------------------------------------------------------------
        Assigning actions to elements in FXML
    ----------------------------------------------------------------*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void backToSignIn(ActionEvent event) throws IOException {
        application.switchToSignInView();
    }

    @FXML
    private void handleSignUpButton(ActionEvent event) {
        
        String username = signupUserName.getText();
        String password = signupPassword.getText();
        String confirmPassword = signupConfirmPassword.getText();
        String Email = signupEmail.getText();
        String phone = signupPhone.getText();
        String pattern = "yyyy-MM-dd";
        boolean validateUser = validateUserName(username);
        boolean validateEmailFlag = validateEmail(Email);
        boolean flagDataApproved=true;
        if (username.isEmpty() | (validateUser == false)) {
            flagDataApproved = false;
            signupErrorMsg.setText("please enter a valid username");
        }
        if (Email.isEmpty() | (validateEmailFlag == false)) {
            flagDataApproved = false;
            signupErrorMsg.setText("please enter a valid Email");
        }
        boolean confirmPasswordFlag = password.equals(confirmPassword);
        if (password.isEmpty() | (confirmPasswordFlag == false)) {
            flagDataApproved = false;
            signupErrorMsg.setText("please enter a valid password");
        }
        //////////////////start of date///////////////////////////////////////////
        
        StringConverter converter;
        converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    System.out.println("date is " + dateFormatter.format(date));
                    dateReturned=dateFormatter.format(date);
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        signupDatePicker.setConverter(converter);
        ///////////////////////////////////////////////////End of date TODO : get string from datepicker/////////////////////////////////////////////
        System.out.println("selected " + signupChoiceBoxCountry.getSelectionModel().getSelectedItem());
        String country = signupChoiceBoxCountry.getSelectionModel().getSelectedItem();
        if (country.isEmpty() | country.equals("- Select choice -")) {
            flagDataApproved = false;
            signupErrorMsg.setText("please select a country");
            country = null;
        }
        boolean maleReturned = signupMale.selectedProperty().getValue();
        boolean femaleReturned = signupFemale.selectedProperty().getValue();
        //    System.out.println("male sel"+signupMale.selectedProperty().getValue());
        if (maleReturned == true) {
            genderSelected="male";
            System.out.println("male");
        } else if (femaleReturned == true) {
            genderSelected="female";
            System.out.println("female");
        } else {
            flagDataApproved = false;
            signupErrorMsg.setText("please select a gender");
            // genderSelected=null;
        }
        System.out.println("the big flag " + flagDataApproved);
        if (flagDataApproved == true) {
            User user = new User(username, Email, phone, genderSelected, dateReturned, password, country, null, null);
            //TODO invoke signUp from server
            //TODO: application.addNewUser---> call function from class aplication that send user object to the server
            // mainController.server.signUp(newUser, clientObj);
        }
    }

    ////////// end of signUp method//////////////////////////
    /*----------------------------------------------------------------
        Helper methods
    ----------------------------------------------------------------*/
    public void cantConnectToServer() {
        System.out.println("error msg");
        signupErrorMsg.setText("Cann't connect to the Server");
        //TODO: Check to display sign up err msg in sign up view
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
