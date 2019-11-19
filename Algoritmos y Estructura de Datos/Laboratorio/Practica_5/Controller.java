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

    /**
     * @param event
     */
    @FXML
    public void insert(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));

            int listSize = 0;
            listSize = linkedList.size();
            System.out.println("size lista: " + linkedList.size());
            for (int i = 0; i < listSize; i++) {
                if (((Button) linkedList.getFirst()).getBackground().getFills().get(0).getFill().equals(colorPickerSearch.getValue())) {
                    System.out.println("Size lista aux: " + auxList.size());
                    for (int j = 0; j < i; j++) {
                        System.out.println(((Button) linkedList.getFirst()).getBackground().getFills().get(0).getFill());
                        linkedList.addFirst((Button) auxList.getFirst());
                        auxList.removeStart();
                    }
                    System.out.println("post size: " + linkedList.size());
                    linkedList.add((Button) listCopy.getChildren().get(0), i);
                    list.getChildren().add(i, listCopy.getChildren().get(0));
                    textAreaActions.setText(textAreaActions.getText() + " Se inserto el color: " +
                            colorPickerSearch.getValue() + "\n");
                    break;
                } else {
                    auxList.addFirst(linkedList.getFirst());
                    linkedList.removeStart();
                    System.out.println(((Button) auxList.getFirst()).getBackground().getFills().get(0).getFill());
                }
            }
        }
    }

    /**
     * @param event
     */
    @FXML
    public void remove(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            position.setMax(items--);

            for (int i = 0; i < linkedList.size(); i++) {
                if (((Button) linkedList.getFirst()).getBackground().getFills().get(0).getFill().equals(colorPickerSearch.getValue())) {
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

    /**
     * @param event
     */
    @FXML
    public void insertStart(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            linkedList.addFirst((Button) listCopy.getChildren().get(0));
            System.out.println("Agregado: " + ((Button) linkedList.getFirst()).getBackground().getFills().get(0).getFill());
            list.getChildren().add(0, listCopy.getChildren().get(0));
            textAreaActions.setText(textAreaActions.getText() + " Se inserto al inicio el color: " +
                    colorPicker.getValue() + "\n");
        }
    }

    /**
     * @param event
     */
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

    /**
     * @param event
     */
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

    /**
     * @param event
     */
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
