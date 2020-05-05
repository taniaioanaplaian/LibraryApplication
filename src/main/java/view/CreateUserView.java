package view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class CreateUserView {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label userLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button registerButton;
    @FXML
    private Label messageLabel;


    private AnchorPane anchorPane2;
    private Label userLabel2;
    private TextField usernameTextField2;
    private PasswordField passwordTextField2;
    private ChoiceBox<String> choiceBox2;
    private Button registerButton2;
    private Label messageLabel2;

    @FXML
    public void initialize(){
        this.anchorPane2 = anchorPane;
        this.userLabel2 = userLabel;
        this.usernameTextField2 = usernameTextField;
        this.passwordTextField2 = passwordTextField;
        this.choiceBox2= choiceBox;
        this.registerButton2 = registerButton;
        this.messageLabel2 = messageLabel;
    }


    public AnchorPane getAnchorPane2() {
        return anchorPane2;
    }

    public void setAnchorPane2(AnchorPane anchorPane2) {
        this.anchorPane2 = anchorPane2;
    }

    public Label getUserLabel2() {
        return userLabel2;
    }

    public void setUserLabel2(Label userLabel2) {
        this.userLabel2 = userLabel2;
    }

    public TextField getUsernameTextField2() {
        return usernameTextField2;
    }

    public void setUsernameTextField2(TextField usernameTextField2) {
        this.usernameTextField2 = usernameTextField2;
    }

    public PasswordField getPasswordTextField2() {
        return passwordTextField2;
    }

    public void setPasswordTextField2(PasswordField passwordTextField2) {
        this.passwordTextField2 = passwordTextField2;
    }

    public ChoiceBox<String> getChoiceBox2() {
        return choiceBox2;
    }

    public void setChoiceBox2(ChoiceBox<String> choiceBox2) {
        this.choiceBox2 = choiceBox2;
    }

    public Button getRegisterButton2() {
        return registerButton2;
    }

    public void setRegisterButton2(Button registerButton2) {
        this.registerButton2 = registerButton2;
    }

    public Label getMessageLabel2() {
        return messageLabel2;
    }

    public void setMessageLabel2(Label messageLabel2) {
        this.messageLabel2 = messageLabel2;
    }




    public void addUserButtonAction(EventHandler event){
        this.registerButton2.setOnAction(event);
    }
}
