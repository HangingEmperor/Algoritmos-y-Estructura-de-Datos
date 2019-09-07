package Laboratorio.Practica_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

/**
 * Clase que hace funcion como el controlador del programa usando el metodo MVC
 *
 * @author Omar
 */
public class Controller implements Initializable {

    private static Stack<BackgroundFill> stack = new Stack<BackgroundFill>();
    private int pointer = 10;

    @FXML
    private Label labelMessage;
    @FXML
    private GridPane gridPaneStack;
    @FXML
    private Button buttonAddColor;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Button buttonRemoveTop;

    /**
     * Funcion que remueve el ultimo color agregado de la pila
     *
     * @param event Recibe la accion de un boton si se produce
     */
    @FXML
    public void removeTop(ActionEvent event) {
        buttonRemoveTop.setDisable(false);
        if (!stack.isEmpty()) {
            gridPaneStack.getChildren().get(pointer).setVisible(false);
            gridPaneStack.getChildren().get(pointer).setDisable(true);

            pointer++;
            labelMessage.setText("Se ha removido un color: " + stack.peek().getFill());
            stack.pop();
        } else {
            labelMessage.setText("La pila esta vacia.");
            buttonRemoveTop.setDisable(true);
        }
    }

    /**
     * Funcion que recibe la accion de un boton para poder eliminar de la pila
     * el color seleccionado
     *
     * @param event Recibe la accion de un boton
     */
    @FXML
    public void removeColorOnStack(ActionEvent event) {
        int position = 0;
        for (int i = 0; i < 10; i++) {
            if (((Button) event.getSource()).getId().equals("button" + i)) {
                position = i;
                break;
            }
        }
        Stack<BackgroundFill> temporalStack = new Stack<>();

        int size = stack.size();
        labelMessage.setText("Se ha removido un color: "
                + ((Button) event.getSource()).getBackground().getFills().get(0).getFill()
                + "en la posicion: " + position);

        for (int i = position; i < size; i++) {
            gridPaneStack.getChildren().get(9 - i).setVisible(false);
            gridPaneStack.getChildren().get(9 - i).setDisable(true);
        }
        for (int i = position; i < size; i++) {
            temporalStack.push(stack.pop());
        }
        temporalStack.pop();

        pointer++;
        for (int i = position; i < size - 1; i++) {
            gridPaneStack.getChildren().get(9 - i).setVisible(true);
            gridPaneStack.getChildren().get(9 - i).setDisable(false);
            stack.push(temporalStack.pop());
            ((Button) gridPaneStack.getChildren().get(9 - i)).setBackground(new Background(stack.peek()));

        }
    }

    /**
     * Funcion que agrega un color a la pila
     *
     * @param event Recibe la accion si se produce una en el programa
     */
    @FXML
    public void addColorToStack(ActionEvent event) {
        if (stack.size() < 10) {
            pointer--;
            labelMessage.setText("Se agrego un nuevo color: " + colorPicker.getValue());

            stack.push(new BackgroundFill(colorPicker.getValue(), null, null));
            gridPaneStack.getChildren().get(pointer).setVisible(true);
            ((Button) gridPaneStack.getChildren().get(pointer)).setBackground(new Background(stack.peek()));
            gridPaneStack.getChildren().get(pointer).setDisable(false);
        } else {
            labelMessage.setText("La pila esta llena.");
        }
        buttonRemoveTop.setDisable(false);
    }

    /**
     * Inicializa los requisitos iniciales del programa
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonRemoveTop.setDisable(true);

        for (int i = 0; i < 10; i++) {
            gridPaneStack.getChildren().get(i).setDisable(true);
            gridPaneStack.getChildren().get(i).setVisible(false);
        }
    }
}