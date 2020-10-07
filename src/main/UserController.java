
package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

public class UserController {
    @FXML
    private Label errorLabel;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField address;
    @FXML
    private ChoiceBox<String> cbSpeed;
    @FXML
    private ChoiceBox<String> cbBandwidth;
    @FXML
    private ChoiceBox<String> cbContract;
    @FXML
    private Button saveBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button closeBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;

    ObservableList<User> persons = FXCollections.<User>observableArrayList();
    User person;

    @FXML
    TableView<User> table = new TableView<>();

    public UserController() {
    }

    @FXML
    private void initialize() {

        person = new User();

        firstName.textProperty().bindBidirectional(person.firstNameProperty());
        lastName.textProperty().bindBidirectional(person.lastNameProperty());
        address.textProperty().bindBidirectional(person.addressProperty());
        cbSpeed.valueProperty().bindBidirectional(person.speedProperty());
        cbBandwidth.valueProperty().bindBidirectional(person.bandwidthProperty());
        cbContract.valueProperty().bindBidirectional(person.contractProperty());


        cbSpeed.getItems().addAll("2 Mbps", "5 Mbps", "10 Mbps", "20 Mbps", "50 Mbps", "100 Mbps");
        cbBandwidth.getItems().addAll("1 GB", "5 GB", "10 GB", "100 GB", "Flat");
        cbContract.getItems().addAll("1 year", "2 years");
    }

    @FXML
    private void savePerson() {

        errorLabel.setText("");

        String uuid = UUID.randomUUID().toString().split("-")[0];
        User user = new User(uuid, firstName.getText(), lastName.getText(), address.getText(), cbSpeed.getSelectionModel().getSelectedItem(),
                cbBandwidth.getSelectionModel().getSelectedItem(), cbContract.getSelectionModel().getSelectedItem());

        if (user.isValid()) {

            persons = table.getItems();
            persons.add(user);
            table.setItems(persons);
        } else {
            List<String> errors = user.errorsProperty().get();
            System.out.println(errors);
            errorLabel.setText(errors.get(0));
        }
    }

    @FXML
    private void clearPerson() {

        person.speedProperty().set(null);
        person.bandwidthProperty().set(null);
        person.contractProperty().set(null);
        person.firstNameProperty().set("");
        person.lastNameProperty().set("");
        person.addressProperty().set("");
    }


    @FXML
    private void deletePerson() {

        persons = table.getItems();
        int index = table.selectionModelProperty().getValue().getSelectedIndex();
        if (index != -1) {


            persons.remove(index);
            table.setItems(persons);
        } else {
            errorLabel.setText("Select row");
        }
    }

    @FXML
    public void editPerson() {
        persons = table.getItems();
        int index = table.selectionModelProperty().getValue().getSelectedIndex();

        if (index != -1) {

            User user = new User(table.getItems().get(index).getUserId(), firstName.getText(), lastName.getText(), address.getText(), cbSpeed.getSelectionModel().getSelectedItem(),
                    cbBandwidth.getSelectionModel().getSelectedItem(), cbContract.getSelectionModel().getSelectedItem());

            persons.get(index).setFirstName(firstName.getText());
            persons.get(index).setLastName(lastName.getText());
            persons.get(index).setAddress(address.getText());
            persons.get(index).setSpeed(cbSpeed.getValue());
            persons.get(index).setBandwidth(cbBandwidth.getValue());
            persons.get(index).setContract(cbContract.getValue());
            table.setItems(persons);
        }
    }

    @FXML
    private void selectRow() {
        int index = table.selectionModelProperty().getValue().getSelectedIndex();

        if (index != -1) {
            User oldUser = table.getItems().get(index);

            person.speedProperty().set(oldUser.getSpeed());
            person.bandwidthProperty().set(oldUser.getBandwidth());
            person.contractProperty().set(oldUser.getContract());
            person.firstNameProperty().set(oldUser.getFirstName());
            person.lastNameProperty().set(oldUser.getLastName());
            person.addressProperty().set(oldUser.getAddress());
        } else {
            errorLabel.setText("Select row");
        }
    }
}
