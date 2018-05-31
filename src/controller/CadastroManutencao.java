package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.omg.CORBA.INITIALIZE;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class CadastroManutencao implements Initializable{

    @FXML
    private ComboBox<String> cbPlaca;

    @FXML
    private ComboBox<Manutencao> cbMarcaOleo;

    @FXML
    private ComboBox<Manutencao> cbTipoOleo;

    @FXML
    private ComboBox<Manutencao> cbTipoPneu;

    @FXML
    private ComboBox<Manutencao> cbMarcaPneu;



    private ObservableList<String> listaPlaca = FXCollections.observableArrayList(

    	"value 1", "value 2"

    		);



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbPlaca.setItems(listaPlaca);

	}
    }


