package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.CadastroDAO;
import view.Main;

public class CadastroMarcaPneu {

	@FXML TextField txtMarcaPneu;

	MarcaPneu marcaPneuAtualizar;


	private boolean atualizacao=false;

	CadastroDAO dao = new CadastroDAO();

	public void initialize() {
		if(marcaPneuAtualizar != null) {
			txtMarcaPneu.setText(marcaPneuAtualizar.getMarcaPneu());
			atualizacao = true;
		}

	}



	@FXML public void inserir(){

		if(atualizacao) {
			marcaPneuAtualizar.setMarcaPneu(txtMarcaPneu.getText());

			dao.atualizarMarcaPneu(marcaPneuAtualizar);

		}else{MarcaPneu tipo = new MarcaPneu();

		tipo.setMarcaPneu(txtMarcaPneu.getText());

		dao.inserir(tipo);
		limpar();

		}
	}

	@FXML public void voltar() {
		Main.abrirTela("Main");
	}

	private void limpar() {
		txtMarcaPneu.setText("");
	}

}
