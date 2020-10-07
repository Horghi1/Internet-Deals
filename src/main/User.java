package main;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.ArrayList;


public class User {
    private final StringProperty userId = new SimpleStringProperty(this, "userId", "");
    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final StringProperty address = new SimpleStringProperty(this, "address");
    private final StringProperty speed = new SimpleStringProperty(this, "speed");
    private final StringProperty bandwidth = new SimpleStringProperty(this, "bandwidth");
    private final StringProperty contract = new SimpleStringProperty(this, "contract");


    public User() {

    }

    public User(String userId, String firstName, String lastName, String address, String speed, String bandwidth, String contract) {
        this.userId.set(userId);
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.address.set(address);
        this.speed.set(speed);
        this.bandwidth.set(bandwidth);
        this.contract.set(contract);

    }

    public User(String firstName) {
        this.firstName.set(firstName);
    }

    public User(String firstName, String lastName) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
    }

    public String getUserId() {
        return userId.get();
    }

    public StringProperty userIdProperty() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId.set(userId);
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

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getSpeed() {
        return speed.get();
    }

    public void setSpeed(String speed) {
        this.speed.set(speed);
    }

    public StringProperty speedProperty() {
        return speed;
    }

    public String getBandwidth() {
        return bandwidth.get();
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth.set(bandwidth);
    }

    public StringProperty bandwidthProperty() {
        return bandwidth;
    }

    public String getContract() {
        return contract.get();
    }

    public void setContract(String contract) {
        this.contract.set(contract);
    }

    public StringProperty contractProperty() {
        return contract;
    }


    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());

    public ObjectProperty<ArrayList<String>> errorsProperty() {
        return errorList;
    }

    public boolean isValid() {
        boolean isValid = true;
        if (firstName.get() != null && firstName.get().equals("")) {
            errorList.getValue().add("First name can't be empty!");
            isValid = false;
        }
        if (lastName.get() != null && lastName.get().equals("")) {
            errorList.getValue().add("Last name can't be empty!");
            isValid = false;
        }
        if (address.get() == null || address.get().equals("")) {
            errorList.getValue().add("Adress can't be empty!");
            isValid = false;
        }
        if (speed.get() == null || speed.get().equals("")) {
            errorList.getValue().add("Speed can't be empty!");
            isValid = false;
        }
        if (bandwidth.get() == null || bandwidth.get().equals("")) {
            errorList.getValue().add("Bandwidth can't be empty!");
            isValid = false;
        }
        if (contract.get() == null || contract.get().equals("")) {
            errorList.getValue().add("Contract can't be empty!");
            isValid = false;
        }
        if (userId.get() == null || userId.get().equals("")) {
            errorList.getValue().add("User ID can't be empty");
            isValid = false;
        }
        return isValid;
    }
}