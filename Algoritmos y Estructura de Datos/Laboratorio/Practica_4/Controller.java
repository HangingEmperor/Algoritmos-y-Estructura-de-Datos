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

    private int time = 0;
    private Queue<Process> queu = new Queue<Process>();
    private Queue<Process> queueEnd = new Queue<Process>();
    private int procesos = 0;

    private int generarTarea() {
        if (((int) (Math.random() * 10) + 1) % 2 == 0)
            return (int) (Math.random() * 10) + 1;
        return 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        do {
            time++;
            if (time % 3 == 0) {
                int proceso = generarTarea();
                if (proceso != 0) {
                    procesos++;
                    Process process = new Process(procesos, proceso, time, 0);
                    queu.insert(process);
                    textAreaProcesosGenerados.setText(textAreaProcesosGenerados.getText() + "Proceso " + process.getId()
                            + " se genero en t: " + process.getStart() + " seg\n" + "Tiempo ejecucion: "
                            + process.getTime() + " seg\n\n");

                    if (queu.front().getInfo().getTime() > 3) {
                        queu.front().getInfo().setTime(queu.front().getInfo().getTime() - 3);
                        queu.insert(queu.remove().getInfo());
                    } else if (queu.front().getInfo().getTime() < 3) {
                        time = time + queu.front().getInfo().getTime();
                        queu.front().getInfo().setEnd(time);
                        queu.front().getInfo().setTime(0);
                        textAreaProcesosTerminados.setText(textAreaProcesosTerminados.getText() + "Proceso: " +
                                queu.front().getInfo().getId() + "\nTiempo inicio: " + queu.front().getInfo().getStart() +
                                "\nTiempo restante: " + queu.front().getInfo().getTime() + "\nTiempo final: " +
                                queu.front().getInfo().getEnd() + "\nTiempo requerido: " +
                                (time - queu.front().getInfo().getStart()) + "\n\n");
                        queueEnd.insert(queu.remove().getInfo());
                    } else {
                        queu.front().getInfo().setTime(0);
                        queu.front().getInfo().setEnd(time);
                        textAreaProcesosTerminados.setText(textAreaProcesosTerminados.getText() + "Proceso: " +
                                queu.front().getInfo().getId() + "\nTiempo inicio: " + queu.front().getInfo().getStart() +
                                "\nTiempo restante: " + queu.front().getInfo().getTime() + "\nTiempo final: " +
                                queu.front().getInfo().getEnd() + "\nTiempo requerido: " +
                                (time - queu.front().getInfo().getStart()) + "\n\n");
                        queueEnd.insert(queu.remove().getInfo());
                    }
                }
            }
        } while (time < 40);
        int size = queu.size();
        for (int i = 0; i < size; i++) {
            textAreaProcesosNoTerminados.setText(textAreaProcesosNoTerminados.getText() + "Proceso: " +
                    queu.front().getInfo().getId() + "\nTiempo inicio: " + queu.front().getInfo().getStart() +
                    "\nTiempo restante: " + queu.front().getInfo().getTime() + "\nTiempo final: " + 0 +
                    "\nTiempo requerido: " + 0 + "\n\n");
            queu.remove();
        }
    }
}
