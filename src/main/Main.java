package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Simon Sperr
 * @version 2020.3, 10.12.2020
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/upnView.fxml"));
        stage.setTitle("UPN Rechner in JavaFX by Sperr");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
