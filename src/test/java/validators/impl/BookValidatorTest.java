package validators.impl;

import model.entity.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookValidatorTest {

    @Test
    public  void isBookValidTest(){
        Book book = new Book();
        book.setGenre("Drama");
        book.setBookPrice(12.9);
        book.setBookTitle("Betty hermosa");
        book.setBookAuthor("H.C.A");
        BookValidator validator = new BookValidator();
        assert validator.isValid(book);
        book.setBookAuthor(null);
        assert !validator.isValid(book);
        book.setBookAuthor("");
        assert !validator.isValid(book);

    }

}