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
    private VBox torreHanoi1;
    @FXML
    private VBox torreHanoi2;
    @FXML
    private VBox torreHanoi3;
    @FXML
    private Button buttonNextMove;
    @FXML
    private TextArea textAreaIntrucciones;

    private void hanoi(int discos, String inicio, String auxiliar, String fin) {
        if (discos == 0)
            return;
        hanoi(discos - 1, inicio, fin, auxiliar);
        textAreaIntrucciones.setText(textAreaIntrucciones.getText()
                + "Mover Disco #" + discos + " de la torre " + inicio + " a la torre " + fin + "\n");
        hanoi(discos - 1, auxiliar, inicio, fin);
    }

    private void hanoiColocation(int posDisco, ObservableList<Button> disco, VBox torreHanoi1, VBox torreHanoi2, VBox torreHanoi3) {
        if (posDisco == 0)
            return;
        hanoiColocation(posDisco - 1, disco, torreHanoi1, torreHanoi3, torreHanoi2);
        /*Mover los botones aqui... pero como?*/
        hanoiColocation(posDisco - 1, disco, torreHanoi2, torreHanoi1, torreHanoi3);
    }

    @FXML
    void nextMove(ActionEvent event) {
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

        hanoi(Integer.parseInt(result.get()), "1", "2", "3");
        for (int i = 0; i < Integer.parseInt(result.get()); i++) {
            ((Button) torreHanoi1.getChildren().get(5 - i)).setText("Disco " + (Integer.parseInt(result.get()) - i));
            torreHanoi1.getChildren().get(5 - i).setVisible(true);
        }
    }
}