package Laboratorio.Practica_4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextArea textAreaProcesosTerminados;
    @FXML
    private TextArea textAreaProcesosNoTerminados;
    @FXML
    private TextArea textAreaProcesosGenerados;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
