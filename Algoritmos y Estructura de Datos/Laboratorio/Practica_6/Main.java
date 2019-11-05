package Laboratorio.Practica_6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * @param args Argumentos para consola
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @param primaryStage Escenario visual que se crea.
     * @throws Exception En caso de no existir el archivo.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        primaryStage.setTitle("Listas simplemente ligadas");
        primaryStage.setScene(new Scene(root, 950, 305));
        primaryStage.show();
    }
}