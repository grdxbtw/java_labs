package com.example.lab7;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;


public class Pentagon extends Application {
    private final Canvas canvas = new Canvas(200, 200);
    private final GraphicsContext gc = canvas.getGraphicsContext2D();
    private final Group root = new Group();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pentagon with gradient");
        moveCanvas();
        drawPentagonWithGradient();
        drawRadialGradient();
        drawLinearGradient();
        drawDropShadow();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void moveCanvas() {
        canvas.setTranslateX(60);
        canvas.setTranslateY(60);
    }

    private void drawPentagonWithGradient() {
        gc.save();

        RadialGradient gradient = new RadialGradient(
                0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE,
                new Stop(0.0, Color.LIGHTCORAL),
                new Stop(0.5, Color.GREENYELLOW),
                new Stop(1.0, Color.DARKGOLDENROD)
        );

        gc.setFill(gradient);

        double[] xPoints = {100, 125, 115, 85, 75};
        double[] yPoints = {50, 80, 130, 130, 80};

        gc.beginPath();
        gc.moveTo(xPoints[0], yPoints[0]);
        for (int i = 1; i < xPoints.length; i++) {
            gc.lineTo(xPoints[i], yPoints[i]);
        }

        gc.closePath();
        gc.fill();
        gc.restore();
    }

    private void drawRadialGradient() {
        gc.setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.1, true,
                CycleMethod.REFLECT, new Stop(0.0, Color.BLACK),
                new Stop(1.0, Color.HONEYDEW)));
        gc.fill();
    }

    private void drawLinearGradient() {
        LinearGradient lg = new LinearGradient(0, 0, 1, 1, true, CycleMethod.REFLECT,
                new Stop(0.0, Color.AQUA),
                new Stop(1.0, Color.DARKCYAN));
        gc.setStroke(lg);
        gc.setLineWidth(3);
        gc.stroke();
    }

    private void drawDropShadow() {
        gc.applyEffect(new DropShadow(20, 20, 0, Color.CHARTREUSE));
        gc.applyEffect(new DropShadow(20, 0, 20, Color.RED));
        gc.applyEffect(new DropShadow(20, -20, 0, Color.GREENYELLOW));
        gc.applyEffect(new DropShadow(20, 0, -20, Color.YELLOW));
    }
}
