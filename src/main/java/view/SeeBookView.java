package view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.dto.BookDto;

public class SeeBookView {

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<BookDto> booksTable;

    @FXML
    private TableColumn<BookDto, String> bookName;

    @FXML
    private TableColumn<BookDto, String> authorName;

    @FXML
    private TableColumn<BookDto, Double> bookPrice;

    @FXML
    private TableColumn<BookDto, Double> bookStock;
    @FXML
    private TableColumn<BookDto, String> bookGenre;

    @FXML
    private TableColumn<BookDto, Button> deleteColumn;



    private AnchorPane root2;
    private TableView<BookDto> booksTable2;
    private TableColumn<BookDto, String> bookName2;
    private TableColumn<BookDto, String> authorName2;
    private TableColumn<BookDto, Double> bookPrice2;
    private TableColumn<BookDto, Double> bookStock2;
    private TableColumn<BookDto, String> bookGenre2;
    private TableColumn<BookDto, Button> deleteColumn2;



    @FXML
    public void initialize(){
        this.root2 = root;
        this.booksTable2 = booksTable;
        this.bookName2 = bookName;
        this.authorName2 = authorName;
        this.bookPrice2 = bookPrice;
        this.bookStock2 = bookStock;
        this.bookGenre2 = bookGenre;
        this.deleteColumn2 = deleteColumn;
    }

    public AnchorPane getRoot2() {
        return root2;
    }

    public void setRoot2(AnchorPane root2) {
        this.root2 = root2;
    }

    public TableView<BookDto> getBooksTable2() {
        return booksTable2;
    }

    public void setBooksTable2(TableView<BookDto> booksTable2) {
        this.booksTable2 = booksTable2;
    }

    public TableColumn<BookDto, String> getBookName2() {
        return bookName2;
    }

    public void setBookName2(TableColumn<BookDto, String> bookName2) {
        this.bookName2 = bookName2;
    }

    public TableColumn<BookDto, String> getAuthorName2() {
        return authorName2;
    }

    public void setAuthorName2(TableColumn<BookDto, String> authorName2) {
        this.authorName2 = authorName2;
    }

    public TableColumn<BookDto, Double> getBookPrice2() {
        return bookPrice2;
    }

    public void setBookPrice2(TableColumn<BookDto, Double> bookPrice2) {
        this.bookPrice2 = bookPrice2;
    }

    public TableColumn<BookDto, Double> getBookStock2() {
        return bookStock2;
    }

    public void setBookStock2(TableColumn<BookDto, Double> bookStock2) {
        this.bookStock2 = bookStock2;
    }

    public TableColumn<BookDto, String> getBookGenre2() {
        return bookGenre2;
    }

    public void setBookGenre2(TableColumn<BookDto, String> bookGenre2) {
        this.bookGenre2 = bookGenre2;
    }

    public TableColumn<BookDto, Button> getDeleteColumn2() {
        return deleteColumn2;
    }

    public void setDeleteColumn2(TableColumn<BookDto, Button> deleteColumn2) {
        this.deleteColumn2 = deleteColumn2;
    }

}
