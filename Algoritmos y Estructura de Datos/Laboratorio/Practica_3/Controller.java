package Laboratorio.Practica_3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author Omar
 */
public class Controller implements Initializable {

    @FXML
    private VBox torreHanoi;
    @FXML
    private VBox torreHanoi1;
    @FXML
    private VBox torreHanoi2;
    @FXML
    private VBox torreHanoi3;
    @FXML
    private TextArea textAreaIntrucciones;
    @FXML
    private Button buttonStart;

    private int size = 0;
    private Alert dialogAlert = new Alert(Alert.AlertType.CONFIRMATION);

    private void hanoi(int discos, int inicio, int auxiliar, int fin) {
        if (discos == 0)
            return;
        hanoi(discos - 1, inicio, fin, auxiliar);

        if (dialogAlert.showAndWait().filter(ButtonType.OK::equals).isPresent()) {
            textAreaIntrucciones.setText(textAreaIntrucciones.getText()
                    + "Mover Disco #" + discos + " de la torre " + inicio + " a la torre " + fin + "\n");
            if (inicio == 1) {
                if (fin == 2)
                    torreHanoi2.getChildren().add(0, torreHanoi1.getChildren().get(0));
                else if (fin == 3)
                    torreHanoi3.getChildren().add(0, torreHanoi1.getChildren().get(0));
            } else if (inicio == 2) {
                if (fin == 1)
                    torreHanoi1.getChildren().add(0, torreHanoi2.getChildren().get(0));
                else if (fin == 3)
                    torreHanoi3.getChildren().add(0, torreHanoi2.getChildren().get(0));
            } else if (inicio == 3) {
                if (fin == 1)
                    torreHanoi1.getChildren().add(0, torreHanoi3.getChildren().get(0));
                else if (fin == 2)
                    torreHanoi2.getChildren().add(0, torreHanoi3.getChildren().get(0));
            }
        }
        hanoi(discos - 1, auxiliar, inicio, fin);
    }

    @FXML
    private void start(ActionEvent event) {
        hanoi(size, 1, 2, 3);
        buttonStart.setDisable(true);
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dialogAlert.setTitle("Aviso");
        dialogAlert.setHeaderText(null);
        dialogAlert.setContentText("Click para siguiente movimiento");
        dialogAlert.initStyle(StageStyle.UTILITY);

        List<String> choices = new ArrayList<>();
        choices.add("4");
        choices.add("5");
        choices.add("6");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("4", choices);
        dialog.setTitle("Torre de Hanoi");
        dialog.setHeaderText("Elige la cantidad de discos que deseas en la torre.");
        dialog.setContentText("Discos:");
        Optional<String> result = dialog.showAndWait();

        for (int i = 0; i < Integer.parseInt(result.get()); i++) {
            torreHanoi1.getChildren().add(torreHanoi.getChildren().get(5 - i));
            ((Button) torreHanoi1.getChildren().get(i)).setText("Disco " + (i + 1));
        }
        size = Integer.parseInt(result.get());
    }
}