package controller.impl;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import model.entity.User;
import model.enumeration.Role;
import service.api.UserService;
import utils.Utils;
import validators.impl.UserValidator;
import view.CreateUserView;

public class CreateUserController {


    private int WIDTH, HEIGHT;
    private final UserService userService;
    private final CreateUserView userView;
    private UserValidator userValidator ;

    public CreateUserController(CreateUserView userView, UserService userService, int WIDTH, int HEIGHT) {
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
        this.userService = userService;
        this.userView = userView;
        this.userValidator = new UserValidator();
    }


    public void initialize(){
        initializeLayout();
        initializeAction();
    }

    private void initializeAction() {
        userView.getRegisterButton2().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = userView.getUsernameTextField2().getText();
                String password = userView.getPasswordTextField2().getText();
                String role = userView.getChoiceBox2().getSelectionModel().getSelectedItem();

                if (username != null && password != null && role != null ) {
                    User user;
                    User toRegister = new User();
                    toRegister.setPassword(password);
                    toRegister.setUserName(username);
                    switch (role) {
                        case "Administrator":
                            toRegister.setRole(Role.ADMINISTRATOR);
                            if (userValidator.isValid(toRegister)) {
                                user = userService.register(username, password, Role.ADMINISTRATOR);
                                if (user != null) {
                                    Utils.displayMessage(userView.getMessageLabel2(), "User " + user.getUserName() + " with role " + user.getRole().toString() + " successfully " +
                                            "registered!", "GREEN");
                                    break;
                                } else {
                                    Utils.displayMessage(userView.getMessageLabel2(), "Error at registration, username taken!", "RED");

                                }
                            }

                        case "Employee":
                            toRegister.setRole(Role.EMPLOYEE);
                            if (userValidator.isValid(toRegister)) {
                                user = userService.register(username, password, Role.EMPLOYEE);
                                if (user != null) {
                                    Utils.displayMessage(userView.getMessageLabel2(), "User " + user.getUserName() + " with role " + user.getRole().toString() + " successfully " +
                                            "registered!", "GREEN");
                                    break;
                                } else {
                                    Utils.displayMessage(userView.getMessageLabel2(), "Error at registration, username taken!", "RED");
                                }
                            } else {
                                Utils.displayMessage(userView.getMessageLabel2(), "User info not valid", "RED");
                            }

                    }

                }else{
                    Utils.displayMessage(userView.getMessageLabel2(), "Please fill all fields!", "RED");
                }
            }
        });
    }

    private void initializeLayout() {
        userView.getChoiceBox2().setItems(FXCollections.observableArrayList(
                "Administrator", "Employee"));
        userView.getChoiceBox2().setValue("Employee");
        userView.getAnchorPane2().setPrefHeight(HEIGHT);
        userView.getAnchorPane2().setPrefWidth(WIDTH);
    }


}
