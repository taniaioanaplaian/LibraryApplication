package controller.impl;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.entity.Book;
import service.api.BookService;
import utils.Utils;
import validators.impl.BookValidator;
import view.CreateBookView;

public class CreateBookController {

    private BookValidator bookValidator;
    private final BookService bookService;
    private final CreateBookView bookView;
    private int width, height;

    public CreateBookController(CreateBookView bookView, BookService service, int width, int height){
        this.width = width;
        this.height = height;
        this.bookService = service;
        this.bookView = bookView;
        this.bookValidator = new BookValidator();
    }

    public void initialize(){
        initializeLayout();
        initializeAction();

    }

    private void initializeLayout() {
        bookView.getAnchorPane2().setPrefHeight(height);
        bookView.getAnchorPane2().setPrefWidth(width);
    }

    private void initializeAction() {
        bookView.addBookAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 Book book = new Book();
                 book.setBookAuthor(bookView.getBookAuthor2().getText());
                 book.setBookTitle(bookView.getBookTitle2().getText());
                 if(bookView.getBookPrice2().getText().matches("[0-9]"))
                    book.setBookPrice(Double.parseDouble(bookView.getBookPrice2().getText()));
                 else
                     book.setBookPrice(0.0);
                 if(bookView.getBookStock2().getText().matches("[0-9]"))
                    book.setBookQuantity(Double.parseDouble(bookView.getBookStock2().getText()));
                 else
                     book.setBookQuantity(0.0);
                 book.setGenre(bookView.getBookGenre2().getText());
                 if(bookValidator.isValid(book)){
                     book = bookService.addBook(book);
                     Utils.displayMessage(bookView.getMessageLabel2(), "Successfully created " + book.getBookTitle(), "GREEN");
                 }else{
                     Utils.displayMessage(bookView.getMessageLabel2(), "Book info not valid", "RED");
                 }
             }
         });
    }


}
