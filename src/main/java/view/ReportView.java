package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ReportView {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ChoiceBox<String> reportType;
    @FXML
    private Button generateButton;
    @FXML
    private Label messageLabel;


    private AnchorPane anchorPane2;
    private ChoiceBox<String> reportType2;
    private Button generateButton2;
    private Label messageLabel2;

    @FXML
    void initialize() {
        this.anchorPane2 = anchorPane;
        this.reportType2 = reportType;
        this.generateButton2 = generateButton;
        this.messageLabel2 = messageLabel;
    }

    public AnchorPane getAnchorPane2() {
        return anchorPane2;
    }

    public void setAnchorPane2(AnchorPane anchorPane2) {
        this.anchorPane2 = anchorPane2;
    }

    public ChoiceBox<String> getReportType2() {
        return reportType2;
    }

    public void setReportType2(ChoiceBox<String> reportType2) {
        this.reportType2 = reportType2;
    }

    public Button getGenerateButton2() {
        return generateButton2;
    }

    public void setGenerateButton2(Button generateButton2) {
        this.generateButton2 = generateButton2;
    }

    public Label getMessageLabel2() {
        return messageLabel2;
    }

    public void setMessageLabel2(Label messageLabel2) {
        this.messageLabel2 = messageLabel2;
    }



    public void addActionListener(EventHandler event){
        this.generateButton2.setOnAction(event);
    }
}
