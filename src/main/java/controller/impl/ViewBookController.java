package controller.impl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import model.dto.BookDto;
import service.api.BookService;
import view.SeeBookView;


public class ViewBookController {


    private int width, height;
    private final BookService service;
    private final SeeBookView bookView;

    public ViewBookController(BookService service, int width, int height, SeeBookView bookView){
        this.width = width;
        this.height = height;
        this.service = service;
        this.bookView = bookView;
    }

    public void initialize(){

        ObservableList<BookDto> books = initializeLayout();
        updateBook(bookView.getBookName2());
        updateAuthorAction();
        updateGenreAction();
        updatePriceAction();
        updateStockAction();
        addColumnAction(books);


    }

    private ObservableList<BookDto> initializeLayout() {
        bookView.getRoot2().setPrefHeight(height);
        bookView.getRoot2().setPrefWidth(width);

        bookView.getBookName2().setCellValueFactory((new PropertyValueFactory<>("bookName")));
        bookView.getAuthorName2().setCellValueFactory((new PropertyValueFactory<>("bookAuthor")));
        bookView.getBookPrice2().setCellValueFactory((new PropertyValueFactory<>("bookPrice")));
        bookView.getBookStock2().setCellValueFactory((new PropertyValueFactory<>("bookStock")));
        bookView.getBookGenre2().setCellValueFactory((new PropertyValueFactory<>("bookGenre")));
        bookView.getDeleteColumn2().setCellValueFactory((new PropertyValueFactory<>("deleteButton")));

        bookView.getBookName2().setCellFactory(TextFieldTableCell.forTableColumn());
        bookView.getAuthorName2().setCellFactory(TextFieldTableCell.forTableColumn());
        bookView.getBookGenre2().setCellFactory(TextFieldTableCell.forTableColumn());
        bookView.getBookPrice2().setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        bookView.getBookStock2().setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        bookView.getBooksTable2().setEditable(true);
        ObservableList<BookDto> books = FXCollections.observableArrayList(service.findBooks());
        bookView.getBooksTable2().setItems(books);
        return books;
    }

    private void updateAuthorAction() {
        bookView.getAuthorName2().setOnEditCommit(event -> {

            BookDto currentBook = bookView.getBooksTable2().getSelectionModel().getSelectedItem();
            String title  = currentBook.getBookName();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setBookAuthor(event.getNewValue());
            BookDto newBook = bookView.getBooksTable2().getSelectionModel().getSelectedItem();
            service.updateBook(title, newBook);
            bookView.getBooksTable2().refresh();

        });
    }

    private void updateGenreAction() {
        bookView.getBookGenre2().setOnEditCommit(event -> {
            BookDto currentBook = bookView.getBooksTable2().getSelectionModel().getSelectedItem();
            String title  = currentBook.getBookName();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setBookGenre(event.getNewValue());
            BookDto newBook = bookView.getBooksTable2().getSelectionModel().getSelectedItem();
            service.updateBook(title, newBook);
            bookView.getBooksTable2().refresh();
        });
    }

    private void updatePriceAction() {
        bookView.getBookPrice2().setOnEditCommit(event -> {

            BookDto currentBook = bookView.getBooksTable2().getSelectionModel().getSelectedItem();
            String title  = currentBook.getBookName();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setBookPrice(event.getNewValue());
            BookDto newBook = bookView.getBooksTable2().getSelectionModel().getSelectedItem();
            service.updateBook(title, newBook);
            bookView.getBooksTable2().refresh();


        });
    }

    private void updateStockAction() {
        bookView.getBookStock2().setOnEditCommit(event -> {
            BookDto currentBook = bookView.getBooksTable2().getSelectionModel().getSelectedItem();
            String title  = currentBook.getBookName();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setBookStock(currentBook.getBookStock() + event.getNewValue());
            BookDto newBook = bookView.getBooksTable2().getSelectionModel().getSelectedItem();
            service.updateBook(title, newBook);
            bookView.getBooksTable2().refresh();
        });
    }

    private void addColumnAction(ObservableList<BookDto> books) {
        for(BookDto book : books){
            book.getDeleteButton().setOnAction(e->{
                BookDto currentBook = bookView.getBooksTable2().getSelectionModel().getSelectedItem();
                String bookTitle = currentBook.getBookName();
                if(bookTitle.isEmpty()){
                    System.out.println("SELECTEAZA CARTEA FAH");
                }else {
                    service.deleteBook(bookTitle);
                    bookView.getBooksTable2().getItems().remove(currentBook);
                }
            });
        }
    }

    private void updateBook(TableColumn<BookDto, String> authorName) {
        authorName.setOnEditCommit(event -> {
            BookDto currentBook = bookView.getBooksTable2().getSelectionModel().getSelectedItem();
            String name = currentBook.getBookName();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setBookName(event.getNewValue());
            BookDto newBook = bookView.getBooksTable2().getSelectionModel().getSelectedItem();
            service.updateBook(name, newBook);

        });
    }

}
