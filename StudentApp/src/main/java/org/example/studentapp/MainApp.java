package org.example.studentapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import org.example.studentapp.model.Person;
import org.example.studentapp.view.PersonOverviewController;
import org.example.studentapp.view.PersonEditDialogController;

import java.io.IOException;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private final ObservableList<Person> personData = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Student Group App");
        initRootLayout();
        showPersonOverview();
    }

    public MainApp() {
        personData.add(new Person("John", "Smith"));
        personData.add(new Person("Michael", "Johnson"));
        personData.add(new Person("Emily", "Brown"));
        personData.add(new Person("Sarah", "Davis"));
        personData.add(new Person("Jessica", "Miller"));
        personData.add(new Person("Daniel", "Taylor"));
        personData.add(new Person("James", "Anderson"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    public void initRootLayout() {
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("/org/example/studentapp.view/RootLayout.fxml"));
        try {
            rootLayout = (BorderPane) fxmlLoader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showPersonOverview() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(MainApp.class.getResource("/org/example/studentapp.view/PersonOverview.fxml"));
        try {
            AnchorPane personOverview = (AnchorPane) fxmlLoader.load();
            rootLayout.setCenter(personOverview);

            PersonOverviewController controller = fxmlLoader.getController();
            controller.setMainApp(this);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean showPersonEditDialog(Person person) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/org/example/studentapp.view/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}