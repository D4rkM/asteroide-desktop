package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import models.CadastroDAO;
import models.DbUtils;

public class CadastroOnibus implements Initializable {

    @FXML private TextField txtPlaca;
   // @FXML private ComboBox<Poltronas> cmbPoltronas;
    @FXML private TextField txtPoltrona;
    @FXML private TextField txtKmRodado;
    @FXML private ComboBox<Classe> cmbClasse;
    @FXML private TextField txtCodigo;
    @FXML private ComboBox<Status> cmbStatus;
    
    private ObservableList<Classe>listaClasse;
    private ObservableList<Status>listaStatus;
   // private ObservableList<Poltronas>listaPoltronas;

    private DbUtils dbUtils;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbUtils = new DbUtils();
		dbUtils.getConnection();
		listaClasse = FXCollections.observableArrayList();
		Classe.PreenchaInformacao((Connection)dbUtils.getConnection(), listaClasse);
		cmbClasse.setItems(listaClasse);
		listaStatus = FXCollections.observableArrayList();
		Status.PreenchaInformacao((Connection)dbUtils.getConnection(), listaStatus);
		cmbStatus.setItems(listaStatus);
	/*	listaPoltronas = FXCollections.observableArrayList();
		Poltronas.PreenchaInformacao((Connection)dbUtils.getConnection(), listaPoltronas);
		cmbPoltronas.setItems(listaPoltronas);*/
		
	}
	
	CadastroDAO dao = new CadastroDAO();
    
    @FXML public void inserir() {
    	Onibus Cadonibus = new Onibus();
    	
    	Cadonibus.setTxtCodigo(txtCodigo.getText());
    	Cadonibus.setTxtKmRodado(txtKmRodado.getText());
    	Cadonibus.setTxtPlaca(txtPlaca.getText());
    	Cadonibus.setTxtPoltrona(txtPoltrona.getText());
    	//Cadonibus.setCmbPoltronas(cmbPoltronas.getSelectionModel().getSelectedItem());
    	Cadonibus.setCmbClasse(cmbClasse.getSelectionModel().getSelectedItem());
    	Cadonibus.setCmbStatus(cmbStatus.getSelectionModel().getSelectedItem());
    	
    	dao.inserir(Cadonibus);
    }
    
}
