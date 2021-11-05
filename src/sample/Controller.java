package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import model.entities.Person;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //responsável pela associação com combobox
    @FXML
    private ComboBox<Person> comboPerson;
    @FXML
    private Button btnAll;


    //Carrega a lista dentro do comboBox

    private ObservableList<Person> obsList;


    //Método para controlar eventos do comboBox pessoas
    @FXML
    public void onComboboxPersonAction(){
        /*quando selecionar um item no comboBox será impresso no console */
        Person person = comboPerson.getSelectionModel().getSelectedItem();
        System.out.println(person);

    }

    //PERCORRER OS ELEMENTOS DA COMBOBOX BTN
    @FXML
    public void onBtnAllAction(){
        for(Person p:comboPerson.getItems()){
            System.out.println(p);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Person> lista = new ArrayList<>();
        lista.add(new Person(1,"Mary", "mary@gmail.com"));
        lista.add(new Person(2,"Joao", "jb@gmail.com"));
        lista.add(new Person(5,"Caio", "caioFeliph@hotmail.com"));

        obsList = FXCollections.observableArrayList(lista);
        comboPerson.setItems(obsList);

        //IRÁ LISTAR APENAS O NOME DAS PESSOAS
        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        comboPerson.setCellFactory(factory);
        comboPerson.setButtonCell(factory.call(null));

    }
}
