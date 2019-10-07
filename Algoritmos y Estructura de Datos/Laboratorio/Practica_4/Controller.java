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
    private Queue<Process> queueEnd = new Queue<Process>();
    private int procesos = 0;

    private void crearProceso() {
        procesos++;
    }

    private int generarTarea() {
        if (((int) (Math.random() * 10) + 1) % 2 == 0) {
            crearProceso();
            return (int) (Math.random() * 10) + 2;
        }
        return 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        do {
            time++;
            if (time % 3 == 0) {
                System.out.println("hello");
                int proceso = generarTarea();
                if (proceso != 0) {
                    Process process = new Process(procesos, proceso, time, 0);
                    queu.insert(process);
                    textAreaProcesosGenerados.setText(textAreaProcesosGenerados.getText() + "Proceso " + process.getId()
                            + " se genero en t: " + process.getTime() + "\n");
                }

                /*
                if (queu.front().getInfo().getTime() > 3) {
                    queu.front().getInfo().setTime(queu.front().getInfo().getTime() - 3);
                    queu.insert(queu.front().getInfo());
                } else if (queu.front().getInfo().getTime() < 3) {
                    time = time + queu.front().getInfo().getTime();
                    queu.front().getInfo().setTime(0);
                    queu.front().getInfo().setEnd(time);

                    queueEnd.insert(queu.front().getInfo());
                } else {
                    queu.front().getInfo().setTime(0);
                    queu.front().getInfo().setEnd(time);

                    queueEnd.insert(queu.remove().getInfo());
                }*/
            }
        } while (time < 20);

    }
}
