package controller.impl;
import javafx.scene.control.Button;
import model.entity.User;
import model.enumeration.Role;
import service.api.UserService;
import view.LoginView;

import java.io.IOException;

public class LoginController {

    private final LoginView loginView;
    private final UserService userService;
    private int HEIGHT, WIDTH;

    public LoginController(LoginView loginView, UserService userService, int WIDTH, int HEIGHT) {
        this.loginView = loginView;
        this.userService = userService;
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
    }


   public void setOnAction(){
        loginView.getNewAnchorPane().setPrefHeight(WIDTH);
        loginView.getNewAnchorPane().setPrefHeight(HEIGHT);
        Button btn = loginView.getNewLoginButton();
        btn.setOnAction(event -> {
            String username = loginView.getNewUsernameTextField().getText();
            String password = loginView.getNewPasswordTextField().getText();
            User currentUser = userService.login(username, password);
            if(currentUser != null) {
                //successful login
                if(currentUser.getRole().equals(Role.ADMINISTRATOR)) {
                    System.out.println("Admin");
                    try {
                        MainController.openAdminView(username);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Employee");
                    try {
                        MainController.openEmployeeView(username);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                clearInputs();
            }
        });
   }
    public void clearInputs() {
        loginView.getNewUsernameTextField().setText("");
        loginView.getNewPasswordTextField().setText("");
    }


}
