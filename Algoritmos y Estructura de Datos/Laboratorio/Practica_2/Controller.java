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

public class Controller implements Initializable {

    static Stack<Button> stack = new Stack<Button>();

    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Label labelMessage;
    @FXML
    private GridPane gridPaneStack;
    @FXML
    private Button buttonAddColor;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button buttonRemoveTop;

    @FXML
    void removeColorOnStack(ActionEvent event) {
        System.out.println(((Button) event.getSource()).getId());
    }

    @FXML
    void addColorToStack(ActionEvent event) {
        BackgroundFill fill = new BackgroundFill(colorPicker.getValue(), null, null);
        button0.setBackground(new Background(fill));
        stack.push(button0);
        //buttonRemoveTop.setDisable();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonRemoveTop.setDisable(true);
    }
}
