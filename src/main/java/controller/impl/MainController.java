package controller.impl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.api.BookRepository;
import repository.api.UserRepository;
import repository.impl.BookRepositoryImpl;
import repository.impl.DbConnection;
import repository.impl.UserRepositoryImpl;
import service.impl.BookServiceImpl;
import service.api.BookService;
import service.api.UserService;
import service.impl.UserServiceImpl;
import validators.impl.BookValidator;
import validators.impl.UserValidator;
import view.*;

import java.io.IOException;

public class MainController extends Application {

    private static UserRepository userRepository;
    private static UserService userService;
    private static LoginController loginController;
    private static final int WIDTH = 900;
    private static final int HEIGHT = 500;
    private static Stage primaryStage;
    private static DbConnection dbConnection;
    private static EmployeeController employeeController;
    private static AdminController adminController;
    private static BookService bookService;
    private static BookRepository bookRepository;
    private static  LoginView loginView;
    private static   AdminView adminView;
    private static EmployeeView employeeView;
    private static ReportView reportView;
    private static CreateBookView createBookView;
    private static CreateUserView createUserView;
    private static SeeUserView userView;
    private static  SeeBookView bookView;



    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainController.class.getResource("/LoginView.fxml"));
        loginView = new LoginView();
        loader.setController(loginView);
        Parent root = loader.load();
        loginController = new LoginController(loginView, userService, WIDTH, HEIGHT);
        loginController.setOnAction();
        primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.setTitle("WELCOME");
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();
    }

    public static void openLoginView() throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainController.class.getResource("/LoginView.fxml"));
        loginView = new LoginView();
        loader.setController(loginView);
        Parent root = loader.load();
        loginController = new LoginController(loginView, userService, WIDTH, HEIGHT);
        loginController.setOnAction();
        primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.setTitle("WELCOME");
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();
    }

    public static void openEmployeeView(String username) throws IOException {
        primaryStage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainController.class.getResource("/EmployeeView.fxml"));
        employeeView = new EmployeeView();
        loader.setController(employeeView);
        Parent root = loader.load();
        employeeController = new EmployeeController(bookService,employeeView,  WIDTH, HEIGHT);
        employeeController.setOnAction();
        bookService.attachObserver(employeeController);
        primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.setTitle("WELCOME");
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();
    }

    public static void openAdminView(String userName) throws IOException {
        primaryStage.close();
        userService.setCurrentUsername(userName);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainController.class.getResource("/AdminView.fxml"));
        adminView = new AdminView();
        loader.setController(adminView);
        Parent root = loader.load();
        adminController = new AdminController(bookView,userView, reportView, adminView, bookService, userService, WIDTH, HEIGHT, userName, createBookView, createUserView);
        adminController.setOnAction();
        primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.setTitle("WELCOME");
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();
    }

    public static void main(String[] args) {

        //jdbc connector
        dbConnection = new DbConnection("library");
        userRepository = new UserRepositoryImpl(dbConnection);
        userService = new UserServiceImpl(userRepository);
        bookRepository = new BookRepositoryImpl(dbConnection);
        bookService = new BookServiceImpl(bookRepository);

         reportView = new ReportView();
         createBookView = new CreateBookView();
         createUserView = new CreateUserView();
         bookView = new SeeBookView();
         userView = new SeeUserView();

        launch(args);

    }
}
