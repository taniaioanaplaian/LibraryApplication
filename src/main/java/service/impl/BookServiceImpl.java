package service.impl;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.dto.BookDto;
import model.dto.UserDto;
import model.entity.Book;
import model.entity.User;
import model.enumeration.Role;
import repository.api.BookRepository;
import service.api.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class BookServiceImpl extends Observable implements BookService {

    private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class.getName());
    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void attachObserver(Observer observer){
        this.addObserver(observer);
    }

    @Override
    public List<BookDto> searchBooks(String title, String author, String genre) {

        List<BookDto> books = this.findBooks();
        List<BookDto> result = new ArrayList<>() ;
        if (!title.isEmpty() && author.isEmpty() && genre.isEmpty() )
            result = books.stream()
                    .filter(line -> line != null && line.getBookName().contains(title)
                    )
                    .collect(Collectors.toList());

        if (!author.isEmpty() && title.isEmpty() && genre.isEmpty())
            result = books.stream().filter(line -> line != null && line.getBookAuthor().equals(author)).collect(Collectors.toList());
        if (!genre.isEmpty() && title.isEmpty() && author.isEmpty())
            result = books.stream().filter(line -> line != null && line.getBookGenre().equals(genre)).collect(Collectors.toList());


        if(!title.isEmpty() && !author.isEmpty() && !genre.isEmpty()){
            result = books.stream().filter(line -> line != null && line.getBookGenre().equals(genre)
                    && line.getBookName().contains(title)
                    && line.getBookAuthor().equals(author)
            ).collect(Collectors.toList());

        }

        if(title.isEmpty() && !author.isEmpty() && !genre.isEmpty()){

            result = books.stream().filter(line -> line != null && line.getBookGenre().equals(genre)
                    && line.getBookAuthor().equals(author)
            ).collect(Collectors.toList());
        }

        if(!title.isEmpty() && author.isEmpty() && !genre.isEmpty()){
            result = books.stream().filter(line -> line.getBookGenre().equals(genre)
                    && line.getBookName().contains(title)
            ).collect(Collectors.toList());

        }

        if(!title.isEmpty() && !author.isEmpty() && genre.isEmpty()){
            result = books.stream().filter(line -> line != null
                    && line.getBookName().contains(title)
                    && line.getBookAuthor().equals(author)
            ).collect(Collectors.toList());

        }
        return result;
    }


    @Override
    public Book addBook(Book book) {
        Book createdBook = bookRepository.loadByTitle(book.getBookTitle());
        if(createdBook == null)
            book = bookRepository.create(book);
        else {
            book.setBookQuantity(createdBook.getBookQuantity() + book.getBookQuantity());
            book.setId(createdBook.getId());
            book = bookRepository.update(book);}
        return book;
    }

    @Override
    public List<BookDto> findBooks() {
        List<BookDto> books = new ArrayList<>();
        List<Book> booksFound = bookRepository.findAll();
        if(booksFound == null){
            LOGGER.warning("Problem during search");
        }
        assert booksFound != null;
        for(Book found : booksFound){
            books.add(new BookDto(found.getBookTitle(), found.getBookAuthor(), found.getGenre(), found.getBookPrice(), found.getBookQuantity(), new Button("Delete")));
        }
        return books;
    }

    @Override
    public boolean deleteBook(String bookTitle) {
        Book foundBook = bookRepository.loadByTitle(bookTitle);
        boolean delete = bookRepository.delete(foundBook.getId());
        if(!delete){
            LOGGER.warning("Could not delete!");
        }
        return delete;
    }

    @Override
    public void updateBook(String currentBook, BookDto newBook) {
        Book current = bookRepository.loadByTitle(currentBook);
        if(current == null){
            LOGGER.warning("Could not find book!!");
        }
        assert current != null;
        current.setBookAuthor(newBook.getBookAuthor());
        current.setBookTitle(newBook.getBookName());
        current.setBookQuantity(newBook.getBookStock());
        current.setBookPrice(newBook.getBookPrice());
        current.setGenre(newBook.getBookGenre());
        current = bookRepository.update(current);
        if(current == null){
            LOGGER.warning("Could not update!");
        }
    }


    @Override
    public List<Book> searchOutOfStock() {
        return bookRepository.loadByStock();
    }

    @Override
    public void  addToCart(List<BookDto> books, List<Double> quantities) {
        System.out.println("Add book to shopping cart.");
        boolean sell = true;
        for (BookDto book : books) {
            Double currentStock = book.getBookStock();
            Double quantity = quantities.get(0);
            if (currentStock < quantity) {
                System.out.println("Current stock" + currentStock + " quantity" + quantity);
                sell = false;
                this.setChanged();
                this.notifyObservers(book);
                break;
            } else {
                book.setBookStock(currentStock - quantity);
                updateBook(book.getBookName(), book);
                //notify that it is possible to sell

            }
        }
        if(sell){
            this.setChanged();
            this.notifyObservers(true);
        }


    }

}
