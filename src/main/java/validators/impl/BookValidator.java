package validators.impl;
import model.entity.Book;
import validators.api.Validator;


public class BookValidator implements Validator<Book> {
    @Override
    public boolean isValid(Book obj) {
        if(obj == null)
            return false;
        if(obj.getGenre() == null  || obj.getBookTitle() == null || obj.getBookPrice() == 0 || obj.getBookAuthor() == null
    || obj.getBookAuthor().isEmpty() || obj.getBookTitle().isEmpty() || obj.getGenre().isEmpty() || obj.getBookQuantity() == null
        || obj.getBookPrice() == null || obj.getBookQuantity() == 0)
            return false;
        return true;
    }
}
