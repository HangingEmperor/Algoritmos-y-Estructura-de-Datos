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

import java.util.LinkedList;

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
    private LinkedList<Button> linkedList = new LinkedList<Button>();
    private double items = 0;

    void printAction(int index) {
        textAreaActions.setText(textAreaActions.getText() + linkedList.get(index).getBackground() +
                " tiene como siguiente" + linkedList.get(index + 1).getBackground());
    }

    @FXML
    void insert(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            position.setMax(items++);
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            linkedList.add((int) position.getValue(), ((Button) listCopy.getChildren().get(0)));
            list.getChildren().add((int) position.getValue(), listCopy.getChildren().get(0));
            printAction((int) position.getValue());
        }
    }

    @FXML
    void insertStart(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            position.setMax(items++);
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            linkedList.addFirst(((Button) listCopy.getChildren().get(0)));
            list.getChildren().add(0, listCopy.getChildren().get(0));
            printAction(0);
        }
    }

    @FXML
    void insertEnd(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            position.setMax(items++);
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            linkedList.addLast(((Button) listCopy.getChildren().get(0)));
            list.getChildren().add(listCopy.getChildren().get(0));
            printAction((int) items);
        }
    }

    @FXML
    void remove(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            position.setMax(items--);
            listCopy.getChildren().add(list.getChildren().get((int) position.getValue()));
            linkedList.remove((int) position.getValue());
        }
    }

    @FXML
    void removeFirst(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            position.setMax(items--);
            listCopy.getChildren().add(list.getChildren().get(0));
            linkedList.removeFirst();
        }
    }

    @FXML
    void removeEnd(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            position.setMax(items--);
            listCopy.getChildren().add(list.getChildren().get(list.getChildren().size() - 1));
            linkedList.removeLast();
        }
    }
}
