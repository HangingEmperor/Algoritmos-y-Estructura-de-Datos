package Laboratorio.Practica_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Lee el archivo FXML para poder mostrar la interfaz del programa
 *
 * @author Omar
 */
public class Main extends Application {

    /**
     * Ejecuta JavaFX
     *
     * @param args Recibe los argumentos desde consola
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Parametriza la escena del programa
     *
     * @param primaryStage Recibe argumentos del escenario
     * @throws Exception Excepcion para archivo inexistente en el programa
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        primaryStage.setTitle("Pila de Colores");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
}
