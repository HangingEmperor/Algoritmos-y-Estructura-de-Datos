package Laboratorio.Practica_5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * El programa consiste en representar de forma visual el uso de LinkedList.
 *
 * @author Omar Flores Salazar
 */
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
        primaryStage.setScene(new Scene(root, 600, 250));
        primaryStage.show();
    }
}