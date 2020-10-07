package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;


public class main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxmlUrl = getClass().getClassLoader().getResource("fxml/ui_fxml.fxml");
        HBox root = FXMLLoader.<HBox>load(fxmlUrl);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
        primaryStage.setResizable(false);
    }

}