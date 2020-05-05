package repository.impl;
import java.sql.*;

public class DbConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final int TIMEOUT = 5;

    private Connection connection;

    public DbConnection(String schemaName) {
        try {
            connection = DriverManager.getConnection(DB_URL + schemaName + "?useSSL=false", USER, PASS);
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS user (" +
                "  userId BIGINT(100) NOT NULL AUTO_INCREMENT," +
                "  username varchar(255) NOT NULL UNIQUE," +
                "  password varchar(255) NOT NULL," +
                "  role varchar(255) NOT NULL," +
                "  PRIMARY KEY (userId)," +
                "  UNIQUE KEY id_UNIQUE (userId)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";
        statement.execute(sql);

        sql = "CREATE TABLE IF NOT EXISTS book (" +
                "  bookId BIGINT(100) NOT NULL AUTO_INCREMENT," +
                "  bookTitle varchar(255) NOT NULL UNIQUE," +
                "  bookAuthor varchar(255) NOT NULL," +
                "  stock DOUBLE NOT NULL," +
                " price DOUBLE NOT NULL,"+
                "genre VARCHAR(255),"+
                "  PRIMARY KEY(bookId)," +
                "  UNIQUE KEY id_UNIQUE (bookId)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";
        statement.execute(sql);

        sql = "CREATE TABLE IF NOT EXISTS shoppingCart (" +
                "  cartId BIGINT(100) NOT NULL AUTO_INCREMENT," +
                "  userId BIGINT(255) NOT NULL UNIQUE," +
                "  PRIMARY KEY (cartId)," +
                "  UNIQUE KEY id_UNIQUE (userId)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";
        statement.execute(sql);

        sql = "CREATE TABLE IF NOT EXISTS client (" +
                "  clientId BIGINT(100) NOT NULL AUTO_INCREMENT," +
                "  clientName BIGINT(255) NOT NULL UNIQUE," +
                "  PRIMARY KEY (clientId)," +
                "  UNIQUE KEY id_UNIQUE (clientId)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";
        statement.execute(sql);


        sql = "CREATE TABLE IF NOT EXISTS cart_book (" +
                " cartBookId  BIGINT(100) NOT NULL AUTO_INCREMENT,"+
                "  clientId BIGINT(100) NOT NULL, " +
                "  cartId BIGINT(100) NOT NULL ," +
                "  bookId BIGINT(100) NOT NULL ," +
                "  quantity INT NOT NULL ," +
                "  PRIMARY KEY (cartBookId)," +
                "  UNIQUE KEY id_UNIQUE (cartBookId)," +
                " foreign key (cartId) references shoppingCart(cartId),"+
                " foreign key (bookId) references book(bookId)"+
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";
        statement.execute(sql);


    }

    public boolean testConnection() throws SQLException {
        return connection.isValid(TIMEOUT);
    }

    public Connection getConnection() {
        return connection;
    }
}

