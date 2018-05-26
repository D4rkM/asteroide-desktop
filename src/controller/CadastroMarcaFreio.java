package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.CadastroDAO;
import view.Main;

public class CadastroMarcaFreio {

	@FXML TextField txtMarcaFreio;

	MarcaFreio marcaFreioAtualizar;


	private boolean atualizacao=false;

	CadastroDAO dao = new CadastroDAO();

	public void initialize() {

		if(marcaFreioAtualizar != null) {
			txtMarcaFreio.setText(marcaFreioAtualizar.getMarcaFreio());
			atualizacao = true;
			System.out.println("txtMarcaFreio "+ marcaFreioAtualizar.getMarcaFreio());
		}

	}



	@FXML public void inserir(){

		if(atualizacao) {
			marcaFreioAtualizar.setMarcaFreio(txtMarcaFreio.getText());

			dao.atualizarMarcaFreio(marcaFreioAtualizar);

		}else{MarcaFreio tipo = new MarcaFreio();

		tipo.setMarcaFreio(txtMarcaFreio.getText());

		dao.inserir(tipo);
		limpar();

		}
	}

	@FXML public void voltar() {
		Main.abrirTela("Main");
	}

	private void limpar() {
		txtMarcaFreio.setText("");
	}

}
