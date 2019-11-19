package Laboratorio.Practica_5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;

public class Controller {

    @FXML
    private TextArea textAreaActions;
    @FXML
    private HBox list;
    @FXML
    private HBox listCopy;
    @FXML
    private Slider position;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private ColorPicker colorPickerSearch;
    private LinkedList<Button> linkedList = new LinkedList<>();
    private LinkedList<Button> auxList = new LinkedList<>();
    private double items = 0;

    @FXML
    public void insert(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(new BackgroundFill(
                    colorPicker.getValue(), null, null)));

            for (int i = 0; i < linkedList.size(); i++) {
                if ((linkedList.get(i)).getBackground().getFills().get(0).getFill().equals(colorPickerSearch.getValue())) {
                    Button b = (Button) listCopy.getChildren().get(0);
                    linkedList.add(b, i);
                    list.getChildren().add(i, b);
                    textAreaActions.setText(textAreaActions.getText() + " Se inserto el color: " +
                            colorPickerSearch.getValue() + "\n");
                    break;
                }
            }
        }
    }

    @FXML
    public void remove(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            position.setMax(items--);

            for (int i = 0; i < linkedList.size(); i++) {
                if ((linkedList.getFirst()).getBackground().getFills().get(0).getFill().equals(colorPickerSearch.getValue())) {
                    for (int j = 0; j < i; j++) {
                        linkedList.addFirst(auxList.getLast());
                        auxList.removeFinal();
                    }
                    listCopy.getChildren().add(list.getChildren().get(i));
                    textAreaActions.setText(textAreaActions.getText() + "Se removio: " +
                            linkedList.remove(linkedList.search(linkedList.getFirst())) + "\n");
                } else {
                    auxList.addFinal(linkedList.getFirst());
                    linkedList.removeStart();
                    if (i + 1 == linkedList.size()) {
                        textAreaActions.setText(textAreaActions.getText() + " No se encontro el color: " +
                                colorPickerSearch.getValue());
                    }
                }
            }
        }
    }

    @FXML
    public void insertStart(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            linkedList.addFirst((Button) listCopy.getChildren().get(0));
            System.out.println("Agregado: " + (linkedList.getFirst()).getBackground().getFills().get(0).getFill());
            list.getChildren().add(0, listCopy.getChildren().get(0));
            textAreaActions.setText(textAreaActions.getText() + " Se inserto al inicio el color: " +
                    colorPicker.getValue() + "\n");
        }
    }

    @FXML
    public void insertEnd(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            position.setMax(items++);
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            linkedList.addFinal(((Button) listCopy.getChildren().get(0)));
            list.getChildren().add(listCopy.getChildren().get(0));
            textAreaActions.setText(textAreaActions.getText() + " Se inserto al final el color: " +
                    colorPicker.getValue() + "\n");
        }
    }

    @FXML
    public void removeFirst(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            position.setMax(items--);
            listCopy.getChildren().add(list.getChildren().get(0));
            textAreaActions.setText(textAreaActions.getText() + "Se removio: " +
                    linkedList.getFirst() + "\n");
            linkedList.removeStart();
        }
    }

    @FXML
    public void removeEnd(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            position.setMax(items--);
            listCopy.getChildren().add(list.getChildren().get(list.getChildren().size() - 1));
            textAreaActions.setText(textAreaActions.getText() + "Se removio: " +
                    linkedList.getLast() + "\n");
            linkedList.removeFinal();
        }
    }
}
