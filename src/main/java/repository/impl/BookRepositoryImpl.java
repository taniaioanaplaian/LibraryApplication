package repository.impl;

import model.dto.BookDto;
import model.entity.Book;
import repository.api.BookRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl  implements BookRepository {


    private static final String LOAD_BY_TITLE = "SELECT * FROM book WHERE bookTitle = ?";
    private static final String DELETE ="DELETE FROM book WHERE bookId= ?";
    private static final String INSERT = "INSERT into book(bookTitle, bookAuthor,stock, price, genre) VALUES (?, ?, ?,?,?)";
    private static final String UPDATE = "UPDATE book SET bookTitle=?, bookAuthor=?, stock =?, price =?, genre=? WHERE bookId= ?";
    private static final String SELECT = "SELECT * FROM book";
    private static final String LOAD_BY_ID = "SELECT * FROM book WHERE bookId = ? ";
    private static final String LOAD_BY_STOCK = "SELECT * FROM book WHERE stock = 0 ";

    private final DbConnection jdbConnectionWrapper;

    public BookRepositoryImpl(DbConnection jdbConnectionWrapper) {
        this.jdbConnectionWrapper = jdbConnectionWrapper;
    }

    @Override
    public Book create(Book book) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, book.getBookTitle());
            preparedStatement.setString(2, book.getBookAuthor());
            preparedStatement.setDouble(3, book.getBookQuantity());
            preparedStatement.setDouble(4, book.getBookPrice());
            preparedStatement.setString(5, book.getGenre());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                book.setId(resultSet.getLong(1));
                return book;
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public Book update(Book book) {

        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, book.getBookTitle());
            preparedStatement.setString(2, book.getBookAuthor());
            preparedStatement.setDouble(3, book.getBookQuantity());
            preparedStatement.setDouble(4, book.getBookPrice());
            preparedStatement.setString(5, book.getGenre());
            preparedStatement.setLong(6, book.getId());

            int changedRows = preparedStatement.executeUpdate();

            if (changedRows > 0) {
                return book;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setLong(1, id);

            int updatedRows = preparedStatement.executeUpdate();

            return updatedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Book findById(Long id) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LOAD_BY_ID);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return extractFields(resultSet);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Book extractFields(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong(1));
        book.setBookTitle(resultSet.getString(2));
        book.setBookAuthor(resultSet.getString(3));
        book.setBookQuantity(resultSet.getDouble(4));
        book.setBookPrice(resultSet.getDouble(5));
        book.setGenre(resultSet.getString(6));
        return book;
    }

    @Override
    public List<Book> findAll() {

        Connection connection = jdbConnectionWrapper.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Book book = extractFields(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book loadByTitle(String title) {

        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LOAD_BY_TITLE);
            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return extractFields(resultSet);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Book> loadByStock() {
        Connection connection = jdbConnectionWrapper.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LOAD_BY_STOCK);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Book book = extractFields(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
