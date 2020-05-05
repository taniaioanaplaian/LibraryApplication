package service.api;

import model.dto.BookDto;
import model.entity.Book;
import java.util.List;
import java.util.Observer;

public interface BookService  {

    Book addBook(Book book);
    List<BookDto> findBooks();
    boolean deleteBook(String bookTitle);
    void updateBook(String currentBook, BookDto newBook);
    //Book findByTitle(String bookTitle);
    List<Book> searchOutOfStock();
    void  addToCart(List<BookDto> title, List<Double> quantity);
    void attachObserver(Observer observer);
    List<BookDto> searchBooks(String title, String author, String genre);
}
