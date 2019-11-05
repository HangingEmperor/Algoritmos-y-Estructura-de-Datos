package Laboratorio.Practica_4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Clase encargada de controlar el programa mediante el interfaz.
 *
 * @author Omar
 */
public class Controller implements Initializable {

    @FXML
    private TextArea textAreaProcesosTerminados;
    @FXML
    private TextArea textAreaProcesosNoTerminados;
    @FXML
    private TextArea textAreaProcesosGenerados;

    private int time = 0;
    private Queue<Process> queu = new Queue<>();
    private Queue<Process> aux = new Queue<>();
    private Queue<Process> queueEnd = new Queue<>();
    private int procesos = 0;
    private int size = 0;

    private int generarTarea() {
        if (((int) (Math.random() * 10) + 1) % 2 == 0) {
            return (int) (Math.random() * 10) + 2;
        }
        return 0;
    }

    /**
     * Funcion encargada de crear todos los procesos.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        do {
            time++;
            int proceso = generarTarea();
            if (proceso != 0) {
                procesos++;
                size++;

                Process process = new Process(procesos, proceso, proceso, time, 0);
                textAreaProcesosGenerados.setText(textAreaProcesosGenerados.getText() + "Proceso " + process.getId()
                        + " se genero en t: " + process.getStart() + " seg\n" + "Tiempo ejecucion: "
                        + process.getTime() + " seg\n\n");
                textAreaProcesosGenerados.setText(textAreaProcesosGenerados.getText() + " - - - - - - - - - -"
                        + " - - - - - - - - - - - - - - - - - - - \n");

                queu.insert(process);
            }

            if (time % 3 == 0 && size > 0) {
                System.out.println("time: " + time + " size: " + size);
                for (int i = 0; i <= size; i++) {
                    if (queu.front().getInfo().getTime() > 3) {
                        queu.front().getInfo().setTime(queu.front().getInfo().getTime() - 3);
                        textAreaProcesosGenerados.setText(textAreaProcesosGenerados.getText() + "Proceso "
                                + queu.front().getInfo().getId() + " reinsertado en tiempo: " + time + " seg\n");
                        queu.insert(queu.remove().getInfo());
                    } else if (queu.front().getInfo().getTime() < 3) {
                        time = time + queu.front().getInfo().getTime();
                        queu.front().getInfo().setEnd(time);
                        textAreaProcesosTerminados.setText(textAreaProcesosTerminados.getText() + "Proceso: "
                                + queu.front().getInfo().getId() + "\nTiempo inicio: " + queu.front().getInfo().getStart()
                                + "\nTiempo ejecucion: " + queu.front().getInfo().getRequerido() + "\nTiempo restante: " + 0
                                + "\nTiempo final: " + queu.front().getInfo().getEnd() + "\nTiempo requerido: "
                                + (time - queu.front().getInfo().getStart()) + "\n\n");
                        textAreaProcesosGenerados.setText(textAreaProcesosGenerados.getText() + "Proceso: "
                                + queu.front().getInfo().getId() + " se inserto en " + "Procesos Terminados\n");
                        queueEnd.insert(queu.remove().getInfo());
                        size--;
                    } else {
                        queu.front().getInfo().setEnd(time);
                        textAreaProcesosTerminados.setText(textAreaProcesosTerminados.getText() + "Proceso: "
                                + queu.front().getInfo().getId() + "\nTiempo inicio: " + queu.front().getInfo().getStart()
                                + "\nTiempo ejecucion: " + queu.front().getInfo().getRequerido() + "\nTiempo restante: "
                                + queu.front().getInfo().getTime() + "\nTiempo final: " + queu.front().getInfo().getEnd()
                                + "\nTiempo requerido: " + (time - queu.front().getInfo().getStart()) + "\n\n");
                        textAreaProcesosGenerados.setText(textAreaProcesosGenerados.getText() + "Proceso: "
                                + queu.front().getInfo().getId() + " se inserto en " + "Procesos Terminados\n");
                        queueEnd.insert(queu.remove().getInfo());
                        size--;
                    }
                }
                textAreaProcesosGenerados.setText(textAreaProcesosGenerados.getText() + " - - - - - - - - - -"
                        + " - - - - - - - - - - - - - - - - - - - \n");
            }
        } while (time < 600);

        int size = queu.size();
        for (int i = 0; i < size; i++) {
            textAreaProcesosNoTerminados.setText(textAreaProcesosNoTerminados.getText() + "Proceso: "
                    + queu.front().getInfo().getId() + "\nTiempo inicio: " + queu.front().getInfo().getStart()
                    + "\nTiempo restante: " + queu.front().getInfo().getTime() + "\nTiempo final: " + 0
                    + "\nTiempo requerido: " + 0 + "\n\n");
            queu.remove();
        }
        this.textAreaProcesosNoTerminados.setEditable(false);
        this.textAreaProcesosTerminados.setEditable(false);
        this.textAreaProcesosGenerados.setEditable(false);
    }
}
