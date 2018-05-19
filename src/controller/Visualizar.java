package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.CadastroDAO;

public class Visualizar {
	
	@FXML TableColumn colunaID;
	@FXML TableColumn colunaTipo;
	@FXML TableView tblTipoFreio;
	
	CadastroDAO dao;
	
	public void initialize() {
	
	dao = new CadastroDAO();

	colunaID.setCellValueFactory(new PropertyValueFactory<TipoFreio, Integer>("id"));
	colunaTipo.setCellValueFactory(new PropertyValueFactory<TipoFreio, Integer>("Tipo"));

	ArrayList<TipoFreio> lstTipoFreio = dao.obterTodos();
	
	tblTipoFreio.setItems(FXCollections.observableArrayList(lstTipoFreio));
	
	System.out.println("Inicialização");
	
	}
}
