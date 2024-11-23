package com.example.lab_7;

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


public class Star extends Application {
    private final Canvas canvas = new Canvas(200, 200);
    private final GraphicsContext gc = canvas.getGraphicsContext2D();
    private final Group root = new Group();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Star with gradient");
        moveCanvas();
        drawStarWithGradient();
        drawRadialGradient();
        drawLinearGradient();
        drawDropShadow();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root, 200, 200));
        primaryStage.show();
    }

    private void moveCanvas() {
        canvas.setTranslateX(0);
        canvas.setTranslateY(0);
    }

    private void drawStarWithGradient() {
        gc.save();

        LinearGradient gradient = new LinearGradient(
                0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0.0, Color.PURPLE),
                new Stop(0.5, Color.PINK),
                new Stop(1.0, Color.ORANGE)
        );

        gc.setFill(gradient);

        double[] xPoints = {100, 110, 140, 110, 120, 100, 80, 90, 60, 90};
        double[] yPoints = {50, 85, 85, 105, 140, 120, 140, 105, 85, 85};

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
                new Stop(1.0, Color.HOTPINK)));
        gc.fill();
    }

    private void drawLinearGradient() {
        LinearGradient lg = new LinearGradient(0, 0, 1, 1, true, CycleMethod.REFLECT,
                new Stop(0.0, Color.AQUA),
                new Stop(1.0, Color.DARKBLUE));
        gc.setStroke(lg);
        gc.setLineWidth(3);
        gc.stroke();
    }

    private void drawDropShadow() {
        gc.applyEffect(new DropShadow(20, 20, 0, Color.CHARTREUSE));
        gc.applyEffect(new DropShadow(20, 0, 20, Color.YELLOW));
        gc.applyEffect(new DropShadow(20, -20, 0, Color.ORANGE));
        gc.applyEffect(new DropShadow(20, 0, -20, Color.RED));
    }
}