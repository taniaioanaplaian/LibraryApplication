package repository.api;

import model.dto.BookDto;
import model.entity.Book;

import java.util.List;

public interface BookRepository extends Crud<Book> {
    Book loadByTitle(String title);
    List<Book> loadByStock();
}
