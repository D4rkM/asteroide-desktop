package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.CadastroDAO;

public class CadastroTipoOleo {


	@FXML TextField txtOleo;

	//TipoFreio freioAtualizar;

	CadastroDAO dao = new CadastroDAO();

	@FXML public void inserir(){

		TipoOleo tipo = new TipoOleo();

		tipo.setTxtOleo(txtOleo.getText());

		dao.inserir(tipo);
	}


}
