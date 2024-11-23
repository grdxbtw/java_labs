package org.example.studentapp.view;

import org.example.studentapp.model.Person;
import org.example.studentapp.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditDialogController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField groupCodeField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField specialtyField;
    @FXML
    private TextField courseField;
    @FXML
    private TextField gradeField;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(Person person) {
        this.person = person;
        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        groupCodeField.setText(String.valueOf(person.getGroupCode()));
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
        specialtyField.setText(person.getSpecialty());
        courseField.setText(String.valueOf(person.getCourse()));
        gradeField.setText(String.valueOf(person.getGrade()));
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setGroupCode(Integer.parseInt(groupCodeField.getText()));
            person.setBirthday(DateUtil.parse(birthdayField.getText()));
            person.setSpecialty(specialtyField.getText());
            person.setCourse(Integer.parseInt(courseField.getText()));
            person.setGrade(Double.parseDouble(gradeField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    @FXML
    private boolean isInputValid() {
        String errorMessage = "";
        if (firstNameField.getText() == null || firstNameField.getText().isEmpty()) {
            errorMessage += "No valid first name!\n";
        }

        if (lastNameField.getText() == null || lastNameField.getText().isEmpty()) {
            errorMessage += "No valid last name!\n";
        }

        if (groupCodeField.getText() == null || groupCodeField.getText().isEmpty()) {
            errorMessage += "No valid postal code!\n";
        } else {
            try {
                Integer.parseInt(groupCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid group code (must be an integer)!\n";
            }
        }

        if (birthdayField.getText() == null || birthdayField.getText().isEmpty()) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }

        if (specialtyField.getText() == null || specialtyField.getText().isEmpty()) {
            errorMessage += "No valid specialty!\n";
        }

        if (courseField.getText() == null || courseField.getText().isEmpty()) {
            errorMessage += "No valid course!\n";
        } else {
            try {
                int course = Integer.parseInt(courseField.getText());
                if (course < 1 || course > 6) {
                    errorMessage += "No valid course (must be between 1 and 6)!\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid course (must be an integer)!\n";
            }
        }

        if (gradeField.getText() == null || gradeField.getText().isEmpty()) {
            errorMessage += "No valid grade!\n";
        } else {
            try {
                double grade = Double.parseDouble(gradeField.getText());
                if (grade < 0.0 || grade > 5.0) {
                    errorMessage += "No valid grade (must be between 0.0 and 5.0)!\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid grade (must be a double)!\n";
            }
        }

        if (errorMessage.isEmpty()) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}