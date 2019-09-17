package Laboratorio.prueba;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ButtonDraggable extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane borderPane = new AnchorPane();
        borderPane.setPrefSize(800, 600);
        final Button button = new Button("Drag ME !");

        final Delta dragDelta = new Delta();
        button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                dragDelta.x = button.getLayoutX() - mouseEvent.getSceneX();
                dragDelta.y = button.getLayoutY() - mouseEvent.getSceneY();
                button.setCursor(Cursor.MOVE);
            }
        });
        button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setCursor(Cursor.HAND);
            }
        });
        button.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
                button.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
            }
        });
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setCursor(Cursor.HAND);
            }
        });

        borderPane.snapPositionX(200);
        borderPane.snapPositionY(200);

        Scene scene = new Scene(borderPane);

        stage.setScene(scene);
        stage.show();

    }

    // records relative x and y co-ordinates.
    class Delta {
        double x, y;
    }
}
