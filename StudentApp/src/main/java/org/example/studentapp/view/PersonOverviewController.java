package org.example.studentapp.view;

import org.example.studentapp.MainApp;
import org.example.studentapp.model.Person;
import org.example.studentapp.util.DateUtil;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ButtonType;

import java.util.Optional;


public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label groupCodeLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Label specialtyLabel;
    @FXML
    private Label courseLabel;
    @FXML
    private Label gradeLabel;

    private MainApp mainApp;


    public PersonOverviewController() {
    }

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        showPersonDetails(null);
        personTable.getSelectionModel().selectedItemProperty().addListener((i, z, newValue) -> showPersonDetails(newValue));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        personTable.setItems(mainApp.getPersonData());
    }

    private void showPersonDetails(Person person) {
        if (person != null) {
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            groupCodeLabel.setText(String.valueOf(person.getGroupCode()));
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
            specialtyLabel.setText(person.getSpecialty());
            courseLabel.setText(String.valueOf(person.getCourse()));
            gradeLabel.setText(String.valueOf(person.getGrade()));
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            groupCodeLabel.setText("");
            birthdayLabel.setText("");
            specialtyLabel.setText("");
            courseLabel.setText("");
            gradeLabel.setText("");
        }
    }

    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    @FXML
    private void handleEditPerson() {
        Person
                selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Confirm Deletion");
            alert.setHeaderText("Delete Person");
            alert.setContentText("Are you sure you want to delete the selected person?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                personTable.getItems().remove(selectedIndex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }
}