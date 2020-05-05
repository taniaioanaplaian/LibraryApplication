package view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CreateBookView {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField bookTitle;

    @FXML
    private TextField bookAuthor;

    @FXML
    private TextField bookPrice;

    @FXML
    private TextField bookStock;

    @FXML
    private TextField bookGenre;

    @FXML
    private Button addBookButton;

    @FXML
    private Label messageLabel;



    private AnchorPane anchorPane2;
    private TextField bookTitle2;
    private TextField bookAuthor2;
    private TextField bookPrice2;
    private TextField bookStock2;
    private TextField bookGenre2;
    private Button addBookButton2;
    private Label messageLabel2;


    @FXML
    public void initialize(){
        this.anchorPane2 = anchorPane;
        this.bookTitle2 = bookTitle;
        this.bookAuthor2 = bookAuthor;
        this.bookPrice2 = bookPrice;
        this.bookStock2 = bookStock;
        this.bookGenre2 = bookGenre;
        this.addBookButton2 = addBookButton;
        this.messageLabel2 = messageLabel;
    }

    public AnchorPane getAnchorPane2() {
        return anchorPane2;
    }

    public void setAnchorPane2(AnchorPane anchorPane2) {
        this.anchorPane2 = anchorPane2;
    }

    public TextField getBookTitle2() {
        return bookTitle2;
    }

    public void setBookTitle2(TextField bookTitle2) {
        this.bookTitle2 = bookTitle2;
    }

    public TextField getBookAuthor2() {
        return bookAuthor2;
    }

    public void setBookAuthor2(TextField bookAuthor2) {
        this.bookAuthor2 = bookAuthor2;
    }

    public TextField getBookPrice2() {
        return bookPrice2;
    }

    public void setBookPrice2(TextField bookPrice2) {
        this.bookPrice2 = bookPrice2;
    }

    public TextField getBookStock2() {
        return bookStock2;
    }

    public void setBookStock2(TextField bookStock2) {
        this.bookStock2 = bookStock2;
    }

    public TextField getBookGenre2() {
        return bookGenre2;
    }

    public void setBookGenre2(TextField bookGenre2) {
        this.bookGenre2 = bookGenre2;
    }

    public Button getAddBookButton2() {
        return addBookButton2;
    }

    public void setAddBookButton2(Button addBookButton2) {
        this.addBookButton2 = addBookButton2;
    }

    public Label getMessageLabel2() {
        return messageLabel2;
    }

    public void setMessageLabel2(Label messageLabel2) {
        this.messageLabel2 = messageLabel2;
    }

    public void addBookAction(EventHandler event){
        this.addBookButton2.setOnAction(event);
    }




}
