package com.example.lab_7;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Painter extends Application {
    private double brushSize = 2;

    private void reset(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.DARKBLUE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PaintApp");
        Group root = new Group();

        Rectangle rect = new Rectangle(500, 500, Color.WHITE);
        root.getChildren().add(rect);

        final Canvas canvas = new Canvas(500, 500);
        reset(canvas);
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> gc.clearRect(e.getX() - brushSize / 2,
                e.getY() - brushSize / 2, brushSize, brushSize));

        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            if (t.getClickCount() > 2) {
                reset(canvas);
            }
        });

        ComboBox<Double> brushSizeSelector = new ComboBox<>();
        brushSizeSelector.getItems().addAll(2.0, 4.0, 6.0, 8.0, 10.0);
        brushSizeSelector.setValue(brushSize);
        brushSizeSelector.setOnAction(_ -> brushSize = brushSizeSelector.getValue());

        VBox vbox = new VBox(brushSizeSelector, canvas);
        root.getChildren().add(vbox);

        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }
}
