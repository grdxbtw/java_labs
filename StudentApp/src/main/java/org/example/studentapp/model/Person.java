package org.example.studentapp.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty groupCode;
    private final ObjectProperty<LocalDate> birthday;

    private final StringProperty specialty;
    private final IntegerProperty course;
    private final DoubleProperty grade;

    public Person() {
        this(null, null);
    }

    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.groupCode = new SimpleIntegerProperty(1747);
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(2000, 2, 21));
        this.specialty = new SimpleStringProperty("Computer Science");
        this.course = new SimpleIntegerProperty(1);
        this.grade = new SimpleDoubleProperty(4.2);
    }


    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public int getGroupCode() {
        return groupCode.get();
    }

    public void setGroupCode(int groupCode) {
        this.groupCode.set(groupCode);
    }

    public IntegerProperty groupCodeProperty() {
        return groupCode;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public String getSpecialty() {
        return specialty.get();
    }

    public void setSpecialty(String specialty) {
        this.specialty.set(specialty);
    }

    public StringProperty specialtyProperty() {
        return specialty;
    }

    public int getCourse() {
        return course.get();
    }

    public void setCourse(int course) {
        this.course.set(course);
    }

    public IntegerProperty courseProperty() {
        return course;
    }

    public double getGrade() {
        return grade.get();
    }

    public void setGrade(double grade) {
        this.grade.set(grade);
    }

    public DoubleProperty gradeProperty() {
        return grade;
    }
}