package Laboratorio.Practica_3;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceDialog;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public static void Hanoi(int n, int origen, int auxiliar, int destino) {
        if (n == 1)
            System.out.println("mover disco de " + origen + " a " + destino);
        else {
            Hanoi(n - 1, origen, destino, auxiliar);
            System.out.println("mover disco de " + origen + " a " + destino);
            Hanoi(n - 1, auxiliar, origen, destino);
        }
    }

    public static void mov(int D, String inicio, String auxiliar, String fin) {

        if (D == 0) return;

        else ;

        String salida;

        mov(D - 1, inicio, fin, auxiliar);

        salida = ("Mover Disco #" + D + " de " + inicio + " a " + fin);

        JOptionPane.showMessageDialog(null, salida, "Torres de Hanoi", JOptionPane.INFORMATION_MESSAGE);

        mov(D - 1, auxiliar, inicio, fin);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> choices = new ArrayList<>();
        choices.add("4");
        choices.add("5");
        choices.add("6");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("4", choices);
        dialog.setTitle("Torre de Hanoi");
        dialog.setHeaderText("Elige la cantidad de discos que deseas en la torre.");
        dialog.setContentText("Discos:");

        Optional<String> result = dialog.showAndWait();

        Hanoi(Integer.parseInt(result.get()), 1, 2, 3);
    }

}
