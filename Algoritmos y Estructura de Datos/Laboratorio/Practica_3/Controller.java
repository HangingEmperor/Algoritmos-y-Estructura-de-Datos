package Laboratorio.Practica_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private VBox torreHanoi1;
    @FXML
    private VBox torreHanoi2;
    @FXML
    private VBox torreHanoi3;
    @FXML
    private Button buttonNextMove;
    @FXML
    private TextArea textAreaIntrucciones;

    private void mov(int D, String inicio, String auxiliar, String fin) {
        if (D == 0)
            return;
        mov(D - 1, inicio, fin, auxiliar);
        textAreaIntrucciones.setText(textAreaIntrucciones.getText()
                + "Mover Disco #" + D + " de la torre " + inicio + " a la torre " + fin + "\n");
        mov(D - 1, auxiliar, inicio, fin);
    }

    @FXML
    void nextMove(ActionEvent event) {
        System.out.println(textAreaIntrucciones.getText(13, 14));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < 6; i++) {
            torreHanoi1.getChildren().get(i).setVisible(false);
        }

        List<String> choices = new ArrayList<>();
        choices.add("4");
        choices.add("5");
        choices.add("6");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("4", choices);
        dialog.setTitle("Torre de Hanoi");
        dialog.setHeaderText("Elige la cantidad de discos que deseas en la torre.");
        dialog.setContentText("Discos:");

        Optional<String> result = dialog.showAndWait();

        mov(Integer.parseInt(result.get()), "1", "2", "3");
        //Hanoi(Integer.parseInt(result.get()), 1, 2, 3);
        for (int i = 0; i < Integer.parseInt(result.get()); i++) {
            /* Poner que segun el tamaño, el disco sea el 1 y luego vaya descendiendo*/
            torreHanoi1.getChildren().get(5 - i).setVisible(true);
        }
    }
}