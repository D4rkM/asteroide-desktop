package controller;

import java.net.URL;
import java.util.ResourceBundle;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import models.Conexion;
import models.Classe;
import models.Onibus;
import models.Status;

public class CadastroOnibus implements Initializable {

    @FXML private TextField txtPlaca;
    @FXML private TextField txtPoltrona;
    @FXML private TextField txtKmRodado;
    @FXML private ComboBox<Classe> cmbClasse;
    @FXML private TextField txtCodigo;
    @FXML private ComboBox<Status> cmbStatus;
    
    private ObservableList<Classe>listaClasse;
    private ObservableList<Status>listaStatus;
   // private ObservableList<Poltronas>listaPoltronas;

    private Conexion conexion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conexion = new Conexion();
		conexion.establecerConexion();
		
		listaClasse = FXCollections.observableArrayList();
		listaStatus = FXCollections.observableArrayList();
		
		cmbClasse.setItems(listaClasse);
		cmbStatus.setItems(listaStatus);
	
		Classe.PreenchaInformacao(conexion.getConnection(), listaClasse);
		Status.PreenchaInformacao(conexion.getConnection(), listaStatus);
	}
	/*
	CadastroDAO dao = new CadastroDAO();
    
    @FXML public void inserir() {
    	Onibus Cadonibus = new Onibus();
    	
    	Cadonibus.setTxtCodigo(txtCodigo.getText());
    	Cadonibus.setTxtKmRodado(txtKmRodado.getText());
    	Cadonibus.setTxtPlaca(txtPlaca.getText());
    	Cadonibus.setTxtPoltrona(txtPoltrona.getText());
    	Cadonibus.setCmbClasse(cmbClasse.getSelectionModel().getSelectedItem());
    	Cadonibus.setCmbStatus(cmbStatus.getSelectionModel().getSelectedItem());
    	
    	dao.inserir(Cadonibus);
    }
    */
	
	@FXML
	public void guardarRegistro() {
			Onibus o = new Onibus (0,
				txtPlaca.getText(), 
				txtKmRodado.getText(),
				txtCodigo.getText(),
				txtPoltrona.getText(),
				cmbClasse.getSelectionModel().getSelectedItem(), 
				cmbStatus.getSelectionModel().getSelectedItem());
		conexion.establecerConexion();
		o.guardarRegistro(conexion.getConnection());
		conexion.cerrarConexion();
				
		
	}
	
}
