package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.CadastroDAO;

public class CadastroTipoFreio {

	@FXML TextField txtFreio;

	//TipoFreio freioAtualizar;

	CadastroDAO dao = new CadastroDAO();

	@FXML public void inserir(){

		TipoFreio tipo = new TipoFreio();

		tipo.setTxtFreio(txtFreio.getText());

		dao.inserir(tipo);
	}

}
