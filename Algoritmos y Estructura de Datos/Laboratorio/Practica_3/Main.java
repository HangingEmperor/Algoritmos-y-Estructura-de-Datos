package Laboratorio.Practica_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * El programa consiste en realizar una torre de hanoi animando sus movimientos de forma visual para el usuario.
 *
 * @author Omar
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
        primaryStage.setTitle("Torres de Hanoi");
        primaryStage.setX(0);
        primaryStage.setScene(new Scene(root, 880, 330));
        primaryStage.show();
    }
}