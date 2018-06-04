package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.CadastroDAO;
import view.Main;

public class CadastroMarcaOleo {

	@FXML TextField txtMarcaOleo;

	MarcaOleo marcaOleoAtualizar;


	private boolean atualizacao=false;

	CadastroDAO dao = new CadastroDAO();

	public void initialize() {

		if(marcaOleoAtualizar != null) {
			txtMarcaOleo.setText(marcaOleoAtualizar.getMarcaOleo());
			atualizacao = true;
			System.out.println("txtMarcaOleo "+ marcaOleoAtualizar.getMarcaOleo());

		}

	}



	@FXML public void inserir(){

		if(atualizacao) {
			marcaOleoAtualizar.setMarcaOleo(txtMarcaOleo.getText());

			dao.atualizarMarcaOleo(marcaOleoAtualizar);

		}else{MarcaOleo tipo = new MarcaOleo();

		tipo.setMarcaOleo(txtMarcaOleo.getText());

		dao.inserir(tipo);
		limpar();

		}
	}

	@FXML public void voltar() {
		Main.abrirTela("Main");
	}

	private void limpar() {
		txtMarcaOleo.setText("");
	}
}

