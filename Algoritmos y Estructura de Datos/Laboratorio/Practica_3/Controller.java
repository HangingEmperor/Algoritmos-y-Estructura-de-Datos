package Laboratorio.Practica_3;

import javafx.collections.ObservableList;
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
    public VBox torreHanoi1;
    @FXML
    public VBox torreHanoi2;
    @FXML
    public VBox torreHanoi3;
    @FXML
    private Button buttonNextMove;
    @FXML
    private TextArea textAreaIntrucciones;

    /*
        Mover Disco #1 de la torre 1 a la torre 2
        Mover Disco #2 de la torre 1 a la torre 3
        Mover Disco #1 de la torre 2 a la torre 3
        Mover Disco #3 de la torre 1 a la torre 2
        Mover Disco #1 de la torre 3 a la torre 1
        Mover Disco #2 de la torre 3 a la torre 2
        Mover Disco #1 de la torre 1 a la torre 2
        Mover Disco #4 de la torre 1 a la torre 3
        Mover Disco #1 de la torre 2 a la torre 3
        Mover Disco #2 de la torre 2 a la torre 1
        Mover Disco #1 de la torre 3 a la torre 1
        Mover Disco #3 de la torre 2 a la torre 3
        Mover Disco #1 de la torre 1 a la torre 2
        Mover Disco #2 de la torre 1 a la torre 3
        Mover Disco #1 de la torre 2 a la torre 3
    */

    private void hanoi(int discos, int inicio, int auxiliar, int fin) {
        if (discos == 0)
            return;
        hanoi(discos - 1, inicio, fin, auxiliar);

        textAreaIntrucciones.setText(textAreaIntrucciones.getText()
                + "Mover Disco #" + discos + " de la torre " + inicio + " a la torre " + fin + "\n");
        if (inicio == 1) {
            if (fin == 2) {
                torreHanoi2.getChildren().add(torreHanoi1.getChildren().get(6-discos));
            }
        }

        hanoi(discos - 1, auxiliar, inicio, fin);
    }

    @FXML
    void nextMove(ActionEvent event) {
    }

    private void hanoiColocation(int posDisco, ObservableList<Button> disco, VBox inicio, VBox auxiliar, VBox fin) {
        this.torreHanoi1 = inicio;
        this.torreHanoi2 = auxiliar;
        this.torreHanoi3 = fin;
        if (posDisco == 0)
            return;
        hanoiColocation(posDisco - 1, disco, inicio, fin, auxiliar);

        torreHanoi1.getChildren().add(disco.get(4 - posDisco));

        hanoiColocation(posDisco - 1, disco, auxiliar, inicio, fin);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < 6; i++)
            torreHanoi1.getChildren().get(i).setVisible(false);

        List<String> choices = new ArrayList<>();
        choices.add("4");
        choices.add("5");
        choices.add("6");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("4", choices);
        dialog.setTitle("Torre de Hanoi");
        dialog.setHeaderText("Elige la cantidad de discos que de    seas en la torre.");
        dialog.setContentText("Discos:");
        Optional<String> result = dialog.showAndWait();

        hanoi(Integer.parseInt(result.get()), 1, 2, 3);
        for (int i = 0; i < Integer.parseInt(result.get()); i++) {
            ((Button) torreHanoi1.getChildren().get(5 - i)).setText("Disco " + (Integer.parseInt(result.get()) - i));
            torreHanoi1.getChildren().get(5 - i).setVisible(true);
        }
    }
}