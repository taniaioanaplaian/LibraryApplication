package model.entity;

public class Book {
    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private Double bookPrice;
    private Double bookQuantity;
    private String genre;
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookQuantity=" + bookQuantity +
                ", genre='" + genre + '\'' +
                '}';
    }

    public Book(){

    }

    public Book(String bookTitle, String bookAuthor, Double bookPrice, Double bookQuantity, String genre) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
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

    public Double getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Double bookQuantity) {
        this.bookQuantity = bookQuantity;
    }
}
