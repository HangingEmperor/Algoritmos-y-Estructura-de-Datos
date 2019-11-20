package Laboratorio.Practica_5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;

/**
 * Clase para manejar el control entre interfaz y controlador en el programa.
 *
 * @author Omar Flores Salazar
 */
public class Controller {

    @FXML
    private HBox list;
    @FXML
    private HBox listCopy;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private ColorPicker colorPickerSearch;
    private LinkedList<Button> linkedList = new LinkedList<>();
    private LinkedList<Button> aux = new LinkedList<>();

    /**
     * Funcion que inserta de forma visual un color.
     *
     * @param event Evento generado por una accion.
     */
    @FXML
    public void insert(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(new BackgroundFill(
                    colorPicker.getValue(), null, null)));

            for (int i = 0; i < linkedList.size(); i++)
                if (linkedList.get(i).getBackground().getFills().get(0).getFill().equals(colorPickerSearch.getValue())) {
                    Button b = (Button) listCopy.getChildren().get(0);
                    for (int j = 0; j < i; j++) {
                        aux.addFirst(linkedList.getFirst());
                        linkedList.removeStart();
                    }
                    linkedList.addFirst(b);
                    list.getChildren().add(i, b);
                    for (int j = 0; j < i; j++) {
                        linkedList.addFirst(aux.getFirst());
                        aux.removeStart();
                    }
                    break;
                }
        }
    }

    /**
     * Funcion para remover de forma visual un color.
     *
     * @param event Evento generado por una accion.
     */
    @FXML
    public void remove(ActionEvent event) {
        if (!list.getChildren().isEmpty())
            for (int i = 0; i < linkedList.size(); i++)
                if (linkedList.get(i).getBackground().getFills().get(0).getFill().equals(colorPickerSearch.getValue())) {
                    Button b = (Button) listCopy.getChildren().get(0);
                    for (int j = 0; j < i; j++) {
                        aux.addFirst(linkedList.getFirst());
                        linkedList.removeStart();
                    }
                    linkedList.removeStart();
                    listCopy.getChildren().add(list.getChildren().get(i));
                    for (int j = 0; j < i; j++) {
                        linkedList.addFirst(aux.getFirst());
                        aux.removeStart();
                    }
                }
    }

    /**
     * Funcion para insertar desde el principio de forma visual un color.
     *
     * @param event Evento generado por una accion.
     */
    @FXML
    public void insertStart(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            linkedList.addFirst((Button) listCopy.getChildren().get(0));
            list.getChildren().add(0, listCopy.getChildren().get(0));
        }
    }

    /**
     * Funcion para insertar desde el final de forma visual un color.
     *
     * @param event Evento generado por una accion.
     */
    @FXML
    public void insertEnd(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            linkedList.addFinal(((Button) listCopy.getChildren().get(0)));
            list.getChildren().add(listCopy.getChildren().get(0));
        }
    }

    /**
     * Funcion para remover desde el principio de forma visual un color.
     *
     * @param event Evento generado por una accion.
     */
    @FXML
    public void removeFirst(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            listCopy.getChildren().add(list.getChildren().get(0));
            linkedList.removeStart();
        }
    }

    /**
     * Funcion para remover desde el final de forma visual un color.
     *
     * @param event Evento generado por una accion.
     */
    @FXML
    public void removeEnd(ActionEvent event) {
        if (!list.getChildren().isEmpty()) {
            listCopy.getChildren().add(list.getChildren().get(list.getChildren().size() - 1));
            linkedList.removeFinal();
        }
    }
}
