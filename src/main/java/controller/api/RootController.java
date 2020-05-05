package controller.api;

import controller.impl.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public interface RootController {

    default FXMLLoader openView(String filename, AnchorPane pane, BorderPane borderPane, String className) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(className.getClass().getResource(filename));
        AnchorPane root = null;
        try {
            root = loader.load();
            borderPane.setCenter(root);
            return loader;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    default void logOut(Button button){
        button.setOnAction(event -> {
            try {
                MainController.openLoginView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
