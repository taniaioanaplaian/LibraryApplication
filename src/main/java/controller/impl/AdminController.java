package controller.impl;

import controller.api.RootController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import service.api.BookService;
import service.api.UserService;
import validators.impl.BookValidator;
import validators.impl.UserValidator;
import view.*;

import java.io.IOException;

public class AdminController implements RootController {

    private  int HEIGHT  ;
    private  int WIDTH ;
    private final UserService adminService;
    private final String userName;
    private final BookService bookService;
    private final AdminView adminView;
    private final ReportView reportView;
    private final CreateBookView createBookView;
    private final CreateUserView createUserView;
    private final SeeUserView seeUserView;
    private final SeeBookView seeBookView;


    public AdminController(SeeBookView seeBookView, SeeUserView seeUserView,
                           ReportView reportView, AdminView view, BookService service,
                           UserService adminService, int WIDTH, int HEIGHT, String username,
                           CreateBookView createBookView, CreateUserView createUserView) {
        this.adminService = adminService;
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
        this.userName = username;
        this.bookService = service;
        this.adminView = view;
        this.reportView = reportView;
        this.createBookView = createBookView;
        this.createUserView = createUserView;
        this.seeBookView = seeBookView;
        this.seeUserView = seeUserView;
    }

    public  void setOnAction(){
        createUserAction();
        adminView.getStaticViewButton().setOnAction(event -> openView());
        seeBookAction();
        addBookAction();
        generateReportAction();
        logOut(adminView.getStaticLogOutButton());
        initializeLayout();
    }

    private void seeBookAction() {
        adminView.getStaticViewBookButton().setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("/ViewBookView.fxml"));
            loader.setController(seeBookView);
            Parent root = null;
            try {
                root = loader.load();
                ViewBookController controller = new ViewBookController ( bookService,  WIDTH, HEIGHT, seeBookView);
                controller.initialize();
                adminView.getStaticBorderPane().setCenter(root);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    public void initializeLayout() {
        adminView.getStaticWelcomeLabel().setText("Welcome " + userName);
        adminView.getStaticBorderPane().setPrefHeight(HEIGHT);
        adminView.getStaticBorderPane().setPrefWidth(WIDTH);
        AnchorPane pane = adminView.getStaticAnchorPane();
        pane = (AnchorPane) adminView.getStaticBorderPane().getCenter();
        adminView.setStaticAnchorPane(pane);
    }

    public void generateReportAction() {
        adminView.getStaticGenerateReport().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainController.class.getResource("/GenerateReport.fxml"));
                loader.setController(reportView);
                Parent root = null;
                try {
                    root = loader.load();
                    GenerateReportController controller = new GenerateReportController(reportView,  bookService,  WIDTH, HEIGHT);
                    controller.initialize();
                    adminView.getStaticBorderPane().setCenter(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addBookAction() {
        adminView.getStaticAddBookButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainController.class.getResource("/CreateBookView.fxml"));
                loader.setController(createBookView);
                Parent root = null;
                try {
                    root = loader.load();
                    CreateBookController controller = new CreateBookController(createBookView,  bookService,  WIDTH, HEIGHT);
                    controller.initialize();
                    adminView.getStaticBorderPane().setCenter(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void createUserAction() {
        adminView.getStaticCreateButton().setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("/CreateUserView.fxml"));
            loader.setController(createUserView);
            Parent root = null;
            try {
                root = loader.load();
                CreateUserController controller = new CreateUserController(createUserView,  adminService,  WIDTH, HEIGHT);
                controller.initialize();
                adminView.getStaticBorderPane().setCenter(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void openView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainController.class.getResource("/ViewUserView.fxml"));
        loader.setController(seeUserView);
    Parent root = null;
        try {
        root = loader.load();
        ViewUserController controller = new ViewUserController(seeUserView,  adminService,  WIDTH, HEIGHT);
        controller.initialize();
        adminView.getStaticBorderPane().setCenter(root);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

}
