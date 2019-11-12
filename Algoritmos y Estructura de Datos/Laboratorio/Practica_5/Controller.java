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
     * @param index
     */
    public void printAction(int index) {
        textAreaActions.setText(textAreaActions.getText() +
                linkedList.search(index).getInfo().getBackground().getFills().get(0).getFill() + " tiene como siguiente " +
                linkedList.get(index + 1).getBackground().getFills().get(0).getFill() + "\n");
    }

    /**
     * @param event
     */
    @FXML
    public void insert(ActionEvent event) {
        if (!listCopy.getChildren().isEmpty()) {
            position.setMax(items++);
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));


            for (int i = 0; i < linkedList.size(); i++) {
                if (linkedList.get(i).getBackground().getFills().get(0).getFill().equals(colorPickerSearch.getValue())) {
                    linkedList.add(i, ((Button) listCopy.getChildren().get(0)));
                    list.getChildren().add(i, listCopy.getChildren().get(0));
                    textAreaActions.setText(textAreaActions.getText() + " Se inserto el color: " +
                            linkedList.get(0).getBackground().getFills().get(0).getFill() + "\n");
                    if (linkedList.size() > 1)
                        printAction(i);
                    break;
                } else if (i == linkedList.size() - 1) {
                    textAreaActions.setText(textAreaActions.getText() + " No se encontro el color: " +
                            colorPickerSearch.getValue());
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
            position.setMax(items++);
            ((Button) listCopy.getChildren().get(0)).setBackground(new Background(
                    new BackgroundFill(colorPicker.getValue(), null, null)));
            linkedList.addFirst(((Button) listCopy.getChildren().get(0)));
            list.getChildren().add(0, listCopy.getChildren().get(0));
            textAreaActions.setText(textAreaActions.getText() + " Se inserto al inicio el color: " +
                    linkedList.get(0).getBackground().getFills().get(0).getFill() + "\n");
            if (linkedList.size() > 1)
                printAction(0);
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
            linkedList.addLast(((Button) listCopy.getChildren().get(0)));
            list.getChildren().add(listCopy.getChildren().get(0));
            textAreaActions.setText(textAreaActions.getText() + " Se inserto al final el color: " +
                    linkedList.get(0).getBackground().getFills().get(0).getFill() + " tiene como siguiente null. \n");
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
                if (linkedList.get(i).getBackground().getFills().get(0).getFill().equals(colorPickerSearch.getValue())) {
                    listCopy.getChildren().add(list.getChildren().get(i));
                    textAreaActions.setText(textAreaActions.getText() + "Se removio: " +
                            linkedList.remove(i).getBackground().getFills().get(0).getFill() + "\n");
                    break;
                } else if (i == linkedList.size() - 1) {
                    textAreaActions.setText(textAreaActions.getText() + "No se encontro el color:" +
                            colorPickerSearch.getValue() + "\n");
                }
            }
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
                    linkedList.removeFirst() + "\n");
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
                    linkedList.removeLast() + "\n");
        }
    }
}
