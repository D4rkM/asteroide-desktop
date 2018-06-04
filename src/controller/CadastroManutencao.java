package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import models.DbUtils;

public class CadastroManutencao implements Initializable {
	@FXML private ComboBox<MarcaOleo> cmbMarcaOleo;
	@FXML private ComboBox<TipoOleo> cmbTipoOleo;
	@FXML private ComboBox<MarcaPneu> cmbMarcaPneu;
	@FXML private ComboBox<TipoPneu> cmbTipoPneu;
	
	private ObservableList<MarcaOleo> listaMarcaOleo;
	private ObservableList<TipoOleo> listaTipoOleo;
	private ObservableList<MarcaPneu> listaMarcaPneu;
	private ObservableList<TipoPneu> listaTipoPneu;
	
	private DbUtils dbUtils;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbUtils = new DbUtils();
		dbUtils.getConnection();
		listaMarcaOleo = FXCollections.observableArrayList();	
		listaTipoOleo = FXCollections.observableArrayList();	
		listaMarcaPneu = FXCollections.observableArrayList();	
		listaTipoPneu = FXCollections.observableArrayList();	
		MarcaOleo.PreenchaInformacao((Connection) dbUtils.getConnection(), listaMarcaOleo);
		TipoOleo.PreenchaInformacao((Connection) dbUtils.getConnection(), listaTipoOleo);
		MarcaPneu.PreenchaInformacao((Connection) dbUtils.getConnection(), listaMarcaPneu);
		TipoPneu.PreenchaInformacao((Connection) dbUtils.getConnection(), listaTipoPneu);
		cmbMarcaOleo.setItems(listaMarcaOleo);
		cmbTipoOleo.setItems(listaTipoOleo);
		cmbMarcaPneu.setItems(listaMarcaPneu);
		cmbTipoPneu.setItems(listaTipoPneu);
		
		
	}
	
}
    


