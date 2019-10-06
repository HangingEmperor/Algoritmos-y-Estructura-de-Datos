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

    int time = 0;
    private Queue<Process> queu = new Queue<Process>();
    private int procesos = 0;

    private void crearProceso() {
        procesos++;
    }

    public int generarTarea() {
        if (((int) (Math.random() * 10) + 1) % 2 == 0) {
            crearProceso();
            return (int) (Math.random() * 10) + 2;
        }
        return 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int tarea = 0;

        do {
            time++;

            if (time % 3 == 0) {
                tarea = generarTarea();
                if (tarea != 0) {
                    if (tarea > 3) {

                    } else if (tarea < 3) {

                    } else {

                    }
                }
            }
            tarea--;
        } while (time == 600);
    }
}
