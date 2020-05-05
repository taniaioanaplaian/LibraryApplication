package model.dto;

import javafx.scene.control.Button;

public class BookDto {

    private String bookName;
    private String bookAuthor;
    private Double bookPrice;
    private Double bookStock;
    private Button deleteButton;
    private String bookGenre;

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    private Double quantity;

    public BookDto(String bookName, String bookAuthor,String bookGenre, Double bookPrice, Double bookStock, Button deleteButton) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookStock = bookStock;
        this.bookGenre = bookGenre;
        this.deleteButton = deleteButton;
    }

    @Override
    public String toString() {
        return
                "bookName='" + bookName +
                ", bookAuthor='" + bookAuthor +
                ", bookPrice=" + bookPrice +
                ", bookStock=" + bookStock +
                ", bookGenre='" + bookGenre ;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Double getBookStock() {
        return bookStock;
    }

    public void setBookStock(Double bookStock) {
        this.bookStock = bookStock;
    }
}
