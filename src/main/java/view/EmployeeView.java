package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.dto.BookDto;

import java.beans.EventHandler;

public class EmployeeView {
    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField genreField;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<BookDto> bookTable;
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
    private TableColumn<BookDto, Button> deleteButton;
    @FXML
    private  TableColumn<BookDto, Double> quantityColumn;
    @FXML
    private AnchorPane root;
    @FXML
    private Label observerLabel;
    @FXML
    private TextField priceField;
    @FXML
    private Button sellButton;


    private TextField titleField2;
    private TextField authorField2;
    private TextField genreField2;
    private Button searchButton2;
    private TableView<BookDto> bookTable2;
    private TableColumn<BookDto, String> bookName2;
    private TableColumn<BookDto, String> authorName2;
    private TableColumn<BookDto, Double> bookPrice2;
    private TableColumn<BookDto, Double> bookStock2;
    private TableColumn<BookDto, String> bookGenre2;
    private TableColumn<BookDto, Button> deleteButton2;
    private  TableColumn<BookDto, Double> quantityColumn2;
    private AnchorPane roo2t;
    private Label observerLabel2;
    private TextField priceField2;
    private Button sellButton2;


    @FXML
    void initialize() {
        this.authorField2 =authorField;
        this.titleField2 = titleField;
        this.genreField2 = genreField;
        this.searchButton2 = searchButton;
        this.bookTable2 = bookTable;
        this.bookName2 = bookName;
        this.authorName2 = authorName;
        this.bookPrice2 = bookPrice;
        this.bookStock2 = bookStock;
        this.bookGenre2 = bookGenre;
        this.deleteButton2 = deleteButton;
        this.quantityColumn2 = quantityColumn;
        this.priceField2 = priceField;
        this.sellButton2 = sellButton;
        this.observerLabel2 = observerLabel;
        this.roo2t = root;
    }

    public Label getObserverLabel2() {
        return observerLabel2;
    }

    public TextField getTitleField2() {
        return titleField2;
    }



    public TextField getAuthorField2() {
        return authorField2;
    }



    public TextField getGenreField2() {
        return genreField2;
    }


    public Button getSearchButton2() {
        return searchButton2;
    }

    public void setSearchButton2(Button searchButton2) {
        this.searchButton2 = searchButton2;
    }

    public TableView<BookDto> getBookTable2() {
        return bookTable2;
    }

    public void setBookTable2(TableView<BookDto> bookTable2) {
        this.bookTable2 = bookTable2;
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

    public TableColumn<BookDto, Button> getDeleteButton2() {
        return deleteButton2;
    }

    public void setDeleteButton2(TableColumn<BookDto, Button> deleteButton2) {
        this.deleteButton2 = deleteButton2;
    }

    public TableColumn<BookDto, Double> getQuantityColumn2() {
        return quantityColumn2;
    }

    public AnchorPane getRoo2t() {
        return roo2t;
    }

    public void setQuantityColumn2(TableColumn<BookDto, Double> quantityColumn2) {
        this.quantityColumn2 = quantityColumn2;
    }

    public TextField getPriceField2() {
        return priceField2;
    }

    public Button getSellButton2() {
        return sellButton2;
    }


}



