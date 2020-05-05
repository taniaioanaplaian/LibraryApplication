package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.dto.UserDto;

public class SeeUserView {

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<UserDto> table;

    @FXML
    private TableColumn<UserDto, String> userNameCol;

    @FXML
    private TableColumn<UserDto, String> roleCol;


    @FXML
    private TableColumn<UserDto, Button> deleteColumn;

    private AnchorPane root2;
    private TableView<UserDto> table2;
    private TableColumn<UserDto, String> userNameCol2;
    private TableColumn<UserDto, String> roleCol2;
    private TableColumn<UserDto, Button> deleteColumn2;

    @FXML
    public void initialize(){
        this.root2 = root;
        this.table2 = table;
        this.userNameCol2 = userNameCol;
        this.roleCol2 = roleCol;
        this.deleteColumn2 =deleteColumn;
    }


    public AnchorPane getRoot2() {
        return root2;
    }

    public void setRoot2(AnchorPane root2) {
        this.root2 = root2;
    }

    public TableView<UserDto> getTable2() {
        return table2;
    }

    public void setTable2(TableView<UserDto> table2) {
        this.table2 = table2;
    }

    public TableColumn<UserDto, String> getUserNameCol2() {
        return userNameCol2;
    }

    public void setUserNameCol2(TableColumn<UserDto, String> userNameCol2) {
        this.userNameCol2 = userNameCol2;
    }

    public TableColumn<UserDto, String> getRoleCol2() {
        return roleCol2;
    }

    public void setRoleCol2(TableColumn<UserDto, String> roleCol2) {
        this.roleCol2 = roleCol2;
    }

    public TableColumn<UserDto, Button> getDeleteColumn2() {
        return deleteColumn2;
    }

    public void setDeleteColumn2(TableColumn<UserDto, Button> deleteColumn2) {
        this.deleteColumn2 = deleteColumn2;
    }
}
