package controller.impl;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.dto.UserDto;
import service.api.UserService;
import view.SeeUserView;

public class ViewUserController {

        private final SeeUserView userView;
        private final UserService userService;
        private int height, width;

        public ViewUserController(SeeUserView userView, UserService adminService, int width, int height) {
            this.userView = userView;
            this.userService = adminService;
            this.height = height;
            this.width = width;

        }

        public void initialize(){
            initializeLayout();
            ObservableList<UserDto> users = tableAction();
            deleteUserAction(users);
        }

    private void initializeLayout() {
        userView.getRoot2().setPrefHeight(height);
        userView.getRoot2().setPrefWidth(width);
    }

    private ObservableList<UserDto> tableAction() {
        userView.getUserNameCol2().setCellValueFactory((new PropertyValueFactory<>("username")));
        userView.getRoleCol2().setCellValueFactory((new PropertyValueFactory<>("role")));
        userView.getDeleteColumn2().setCellValueFactory((new PropertyValueFactory<>("deleteButton")));

        userView.getUserNameCol2().setCellFactory(TextFieldTableCell.forTableColumn());
        userView.getRoleCol2().setCellFactory(TextFieldTableCell.forTableColumn());

        userView.getUserNameCol2().setOnEditCommit(event->{
            Long id = userService.findByUsername(event.getOldValue()).getId();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setUsername(event.getNewValue());
            userService.updateUser(id, event.getNewValue(), event.getNewValue());
        });

        userView.getRoleCol2().setOnEditCommit(event->{
            UserDto user = userView.getTable2().getSelectionModel().getSelectedItem();
            Long id = userService.findByUsername(user.getUsername()).getId();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setUsername(event.getNewValue());
            userService.updateUser(id, event.getNewValue(), event.getNewValue());
        });


        userView.getTable2().setEditable(true);
        ObservableList<UserDto> users = FXCollections.observableArrayList(userService.findUsers());
        userView.getTable2().setItems(users);
        return users;
    }

    private void deleteUserAction(ObservableList<UserDto> users) {
        for(UserDto us : users){
            us.getDeleteButton().setOnAction(e->{
                UserDto user = userView.getTable2().getSelectionModel().getSelectedItem();
                String userName = user.getUsername();
                userService.deleteUser(userName);
                userView.getTable2().getItems().remove(user);

            });
        }
    }


}
