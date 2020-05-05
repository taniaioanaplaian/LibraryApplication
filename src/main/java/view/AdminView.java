package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class AdminView {
    @FXML
    private BorderPane borderPane;
    @FXML
    private Label welcomeLabel;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button createButton;

    @FXML
    private Button viewButton;

    @FXML
    private Button viewBookButton;
    @FXML
    private Button addBookButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button generateReport;

    private  BorderPane staticBorderPane;
    private  Label staticWelcomeLabel;
    private  AnchorPane staticAnchorPane;
    private  Button staticCreateButton;
    private  Button staticViewButton;
    private  Button staticViewBookButton;
    private  Button staticAddBookButton;
    private  Button staticLogOutButton;
    private  Button staticGenerateReport;

    @FXML
    public void initialize(){
        this.staticBorderPane = borderPane;
        this.staticWelcomeLabel = welcomeLabel;
        this.staticCreateButton = createButton;
        this.staticAnchorPane = anchorPane;
        this.staticViewButton = viewButton;
        this.staticViewBookButton = viewBookButton;
        this.staticAddBookButton = addBookButton;
        this.staticLogOutButton = logOutButton;
        this.staticGenerateReport = generateReport;
    }


    public  BorderPane getStaticBorderPane() {
        return staticBorderPane;
    }

    public static void setStaticBorderPane(BorderPane staticBorderPane) {
        staticBorderPane = staticBorderPane;
    }

    public  Label getStaticWelcomeLabel() {
        return staticWelcomeLabel;
    }

    public static void setStaticWelcomeLabel(Label staticWelcomeLabel) {
        staticWelcomeLabel = staticWelcomeLabel;
    }

    public AnchorPane getStaticAnchorPane() {
        return staticAnchorPane;
    }

    public static void setStaticAnchorPane(AnchorPane staticAnchorPane) {
        staticAnchorPane = staticAnchorPane;
    }

    public  Button getStaticCreateButton() {
        return staticCreateButton;
    }

    public static void setStaticCreateButton(Button staticCreateButton) {
        staticCreateButton = staticCreateButton;
    }

    public  Button getStaticViewButton() {
        return staticViewButton;
    }

    public static void setStaticViewButton(Button staticViewButton) {

        staticViewButton = staticViewButton;
    }

    public  Button getStaticViewBookButton() {
        return staticViewBookButton;
    }

    public static void setStaticViewBookButton(Button staticViewBookButton) {
        staticViewBookButton = staticViewBookButton;
    }

    public  Button getStaticAddBookButton() {
        return staticAddBookButton;
    }

    public static void setStaticAddBookButton(Button staticAddBookButton) {
        staticAddBookButton = staticAddBookButton;
    }

    public  Button getStaticLogOutButton() {
        return staticLogOutButton;
    }

    public static void setStaticLogOutButton(Button staticLogOutButton) {
        staticLogOutButton = staticLogOutButton;
    }

    public  Button getStaticGenerateReport() {
        return staticGenerateReport;
    }

    public static void setStaticGenerateReport(Button staticGenerateReport) {
        staticGenerateReport = staticGenerateReport;
    }
}