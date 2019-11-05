package Laboratorio.Practica_6;

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

    private DoubleLinked<Button> doubleLinked = new DoubleLinked<>();
    @FXML
    private TextArea textAreaActions;
    @FXML
    private Slider position;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private ColorPicker colorPickerSearch;
    @FXML
    private HBox list;
    @FXML
    private HBox listCopy;
    @FXML
    private HBox listSort;

    @FXML
    void insert(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));

            for (int i = 0; i < doubleLinked.size(); i++) {
                if (doubleLinked.get(i).getBackground().getFills().get(0).getFill().equals(colorPickerSearch.getValue())) {
                    doubleLinked.add(((Button) listCopy.getChildren().get(0)), i);
                    list.getChildren().add(i, listCopy.getChildren().get(0));
                    textAreaActions.setText(textAreaActions.getText() + " Se inserto el color: " +
                            doubleLinked.get(0).getBackground().getFills().get(0).getFill() + "\n");
                    if (doubleLinked.size() > 1)
                        printAction(i);
                    break;
                } else if (i == doubleLinked.size() - 1) {
                    textAreaActions.setText(textAreaActions.getText() + " No se encontro el color: " +
                            colorPickerSearch.getValue());
                }
            }
        }
    }

    @FXML
    void insertStart(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            doubleLinked.addFirst(((Button) listCopy.getChildren().get(0)));
            list.getChildren().add(0, listCopy.getChildren().get(0));
            if (doubleLinked.size() > 1)
                printAction(0);
        }
    }

    @FXML
    void insertEnd(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            doubleLinked.addLast(((Button) listCopy.getChildren().get(0)));
            list.getChildren().add(listCopy.getChildren().get(0));
            textAreaActions.setText(textAreaActions.getText() + " Se inserto al final el color: " +
                    doubleLinked.getLast().getBackground().getFills().get(0).getFill() + " tiene como siguiente null. " +
                    " Y anterior: " + doubleLinked.get(doubleLinked.size() - 1).getBackground().getFills().get(0).getFill()
                    + "\n");
        }
    }

    @FXML
    void remove(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            for (int i = 0; i < doubleLinked.size(); i++) {
                if (doubleLinked.get(i).getBackground().getFills().get(0).getFill().equals(colorPickerSearch.getValue())) {
                    listCopy.getChildren().add(list.getChildren().get(i));
                    textAreaActions.setText(textAreaActions.getText() + "Se removio: " +
                            doubleLinked.get(i).getBackground().getFills().get(0).getFill() + "\n");
                    doubleLinked.remove(i);
                    break;
                } else if (i == doubleLinked.size() - 1) {
                    textAreaActions.setText(textAreaActions.getText() + "No se encontro el color:" +
                            colorPickerSearch.getValue() + "\n");
                }
            }
        }
    }

    @FXML
    void removeFirst(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            listCopy.getChildren().add(list.getChildren().get(0));
            textAreaActions.setText(textAreaActions.getText() + "Se removio: " +
                    doubleLinked.getFirst().getBackground().getFills().get(0).getFill() + "\n");
            doubleLinked.removeFirst();
        }
    }

    @FXML
    void removeEnd(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            listCopy.getChildren().add(list.getChildren().get(list.getChildren().size() - 1));
            textAreaActions.setText(textAreaActions.getText() + "Se removio: " +
                    doubleLinked.getLast() + "\n");
            doubleLinked.removeLast();
        }
    }

    @FXML
    void sortStartToEnd(ActionEvent event) {
        for (int i = 0; i < doubleLinked.size(); i++) {
            ((Button) list.getChildren().get(i)).setBackground(doubleLinked.get(i).getBackground());
        }
    }

    @FXML
    void sortEndToStart(ActionEvent event) {
        for (int i = 0; i < doubleLinked.size(); i++) {
            ((Button) list.getChildren().get(i)).setBackground(doubleLinked.get(doubleLinked.size() - i).getBackground());
        }
    }

    @FXML
    void sortColorToFinal(ActionEvent event) {
        for (int i = 0; i < doubleLinked.size(); i++) {
            if (doubleLinked.get(i).getBackground().getFills().get(0).getFill().equals(colorPickerSearch.getValue())) {

            }
        }
    }

    @FXML
    void sortColorToStart(ActionEvent event) {

    }

    void printAction(int index) {
        if (index == 0) {
            textAreaActions.setText(textAreaActions.getText() +
                    doubleLinked.get(index).getBackground().getFills().get(0).getFill() + " tiene como siguiente " +
                    doubleLinked.get(index + 1).getBackground().getFills().get(0).getFill() + " y anterior: null. \n");
        } else {
            textAreaActions.setText(textAreaActions.getText() +
                    doubleLinked.get(index).getBackground().getFills().get(0).getFill() + " tiene como siguiente " +
                    doubleLinked.get(index + 1).getBackground().getFills().get(0).getFill() + " y anterior: " +
                    doubleLinked.get(index - 1).getBackground().getFills().get(0).getFill() + "\n");
        }
    }
}
