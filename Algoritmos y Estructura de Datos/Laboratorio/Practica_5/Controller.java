package Laboratorio.Practica_5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private HBox list;
    @FXML
    private HBox listCopy;
    @FXML
    private Slider position;
    @FXML
    private ColorPicker colorPicker;

    @FXML
    void insert(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            list.getChildren().add((int) position.getValue(), listCopy.getChildren().get(0));
        }
    }

    @FXML
    void insertStart(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            list.getChildren().add(0, listCopy.getChildren().get(0));
        }
    }

    @FXML
    void insertEnd(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            list.getChildren().add(listCopy.getChildren().get(0));
        }
    }

    @FXML
    void remove(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            listCopy.getChildren().add(list.getChildren().get((int) position.getValue()));
        }
    }

    @FXML
    void removeFirst(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            listCopy.getChildren().add(list.getChildren().get(0));
        }
    }

    @FXML
    void removeEnd(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            listCopy.getChildren().add(list.getChildren().get(list.getChildren().size() - 1));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
