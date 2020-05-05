package controller.impl;

import controller.api.RootController;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import model.dto.BookDto;
import service.api.BookService;
import utils.Utils;
import validators.impl.BookValidator;
import view.EmployeeView;

import java.util.*;
import java.util.stream.Collectors;


public class EmployeeController implements RootController, Observer {

    private List<BookDto> shoppingCart;
    private List<Double> quantities;
    private final EmployeeView employeeView;
    private final BookService bookService;
    private final int WIDTH;
    private final int HEIGHT;


    public EmployeeController(BookService bookService, EmployeeView employeeView, int width, int height) {

        this.employeeView = employeeView;
        this.bookService = bookService;
        WIDTH = width;
        HEIGHT = height;
        this.shoppingCart = new ArrayList<>();
        this.quantities = new ArrayList<>();
    }


    public void setOnAction(){
        initializeLayout();
        setSearchButtonAction();
        sellButtonAction();
    }

    private void sellButtonAction() {
        employeeView.getSellButton2().setOnAction(event -> {
            if (!shoppingCart.isEmpty() && !quantities.isEmpty()) {
                bookService.addToCart(shoppingCart, quantities);
                employeeView.getBookTable2().refresh();
                shoppingCart.removeAll(shoppingCart);
                quantities.removeAll(quantities);
                employeeView.getPriceField2().setText("");
            } else{
                Utils.displayMessage(employeeView.getObserverLabel2(), "Empty cart!", "RED");
            }
        });

    }
    private void addToShoppingCart(BookDto book){

            book.getDeleteButton().setOnAction(e->{
                BookDto book2 = employeeView.getBookTable2().getSelectionModel().getSelectedItem();
                Double quantity = employeeView.getQuantityColumn2().getCellData(book2);
                if(quantity == null)
                    quantity = 1.0;
                shoppingCart.add(book2);
                quantities.add(quantity);
                int sum = 0 ;
                for(int i = 0 ; i < shoppingCart.size(); i ++){
                    sum += (shoppingCart.get(i).getBookPrice()*quantities.get(i));
                }
                employeeView.getPriceField2().setText(String.valueOf(sum));
            });
        }
    private void initializeLayout() {
        employeeView.getBookTable2().setVisible(false);
        employeeView.getPriceField2().setVisible(false);
        employeeView.getSellButton2().setVisible(false);
        employeeView.getRoo2t().setPrefHeight(HEIGHT);
        employeeView.getRoo2t().setPrefWidth(WIDTH);
        employeeView.getBookName2().setCellValueFactory((new PropertyValueFactory<>("bookName")));
        employeeView.getAuthorName2().setCellValueFactory((new PropertyValueFactory<>("bookAuthor")));
        employeeView.getBookPrice2().setCellValueFactory((new PropertyValueFactory<>("bookPrice")));
        employeeView.getBookStock2().setCellValueFactory((new PropertyValueFactory<>("bookStock")));
        employeeView.getBookGenre2().setCellValueFactory((new PropertyValueFactory<>("bookGenre")));
        employeeView.getDeleteButton2().setCellValueFactory((new PropertyValueFactory<>("deleteButton")));
        employeeView.getQuantityColumn2().setCellValueFactory(new PropertyValueFactory<>("quantity"));
        employeeView.getQuantityColumn2().setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        employeeView.getQuantityColumn2().setOnEditCommit(event->{
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setQuantity(event.getNewValue());
        });
        employeeView.getBookTable2().setEditable(true);
    }
    private void setSearchButtonAction() {
        employeeView.getSearchButton2().setOnAction(event -> {
            employeeView.getBookTable2().setVisible(true);
            employeeView.getPriceField2().setVisible(true);
            employeeView.getSellButton2().setVisible(true);
            List<BookDto> books =  bookService.findBooks();
            books.forEach(bookDto -> bookDto.getDeleteButton().setText("Add to cart"));
            books.forEach(this::addToShoppingCart);
            List<BookDto> result = new ArrayList<>();
            String title = employeeView.getTitleField2().getText();
            String author = employeeView.getAuthorField2().getText();
            String genre = employeeView.getGenreField2().getText();


            if(title.isEmpty() && author.isEmpty() && genre.isEmpty())
                employeeView.getBookTable2().setItems(FXCollections.observableArrayList(books));
            else {

                employeeView.getBookTable2().setItems(FXCollections.observableArrayList(bookService.searchBooks(title, author, genre)));
            }

        });

    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("I got notified");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");

        if( arg instanceof BookDto) {
            alert.setHeaderText("Can't sell, not enough books!");
            alert.setContentText("Book " + arg.toString() + " it's not available");
        }else if(arg.equals(true)) {
            alert.setHeaderText("Done!");
            alert.setContentText("Thank you!");
        }

        ButtonType buttonTypeCancel = new ButtonType("Ok", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeCancel);
        alert.showAndWait();
    }
}
