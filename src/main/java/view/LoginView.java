package view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginView {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button loginButton;

    private AnchorPane newAnchorPane;
    private Label newUsernameLabel;
    private Label newPasswordLabel;
    private  TextField newUsernameTextField;
    private  PasswordField newPasswordTextField;
    private  Button newLoginButton;


    @FXML
    public void initialize(){
        this.newAnchorPane = anchorPane;
        this.newUsernameLabel = usernameLabel;
        this.newPasswordLabel = passwordLabel;
        this.newPasswordTextField = passwordTextField;
        this.newUsernameTextField = usernameTextField;
        this.newLoginButton= loginButton;
    }

    public AnchorPane getNewAnchorPane() {
        return newAnchorPane;
    }

    public void setNewAnchorPane(AnchorPane newAnchorPane) {
        this.newAnchorPane = newAnchorPane;
    }

    public Label getNewUsernameLabel() {
        return newUsernameLabel;
    }

    public void setNewUsernameLabel(Label newUsernameLabel) {
        this.newUsernameLabel = newUsernameLabel;
    }

    public Label getNewPasswordLabel() {
        return newPasswordLabel;
    }

    public void setNewPasswordLabel(Label newPasswordLabel) {
        this.newPasswordLabel = newPasswordLabel;
    }

    public TextField getNewUsernameTextField() {
        return newUsernameTextField;
    }

    public void setNewUsernameTextField(TextField newUsernameTextField) {
        this.newUsernameTextField = newUsernameTextField;
    }

    public PasswordField getNewPasswordTextField() {
        return newPasswordTextField;
    }

    public void setNewPasswordTextField(PasswordField newPasswordTextField) {
        this.newPasswordTextField = newPasswordTextField;
    }

    public Button getNewLoginButton() {
        return newLoginButton;
    }

    public void setNewLoginButton(Button newLoginButton) {
        this.newLoginButton = newLoginButton;
    }



}
