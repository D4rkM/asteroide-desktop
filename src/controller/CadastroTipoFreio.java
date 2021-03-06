package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.CadastroDAO;
import view.Main;

public class CadastroTipoFreio {

	@FXML TextField txtFreio;

	TipoFreio tipoFreioAtualizar;


	private boolean atualizacao=false;

	CadastroDAO dao = new CadastroDAO();

	public void initialize() {



		if(tipoFreioAtualizar != null) {
			txtFreio.setText(tipoFreioAtualizar.getTxtfreio());
			atualizacao = true;

			System.out.println("txtFreio: "+ tipoFreioAtualizar.getTxtfreio());

		}

	}



	@FXML public void inserir(){

		if(atualizacao) {
			tipoFreioAtualizar.setTxtfreio(txtFreio.getText());

			dao.atualizar(tipoFreioAtualizar);

		}else{TipoFreio tipo = new TipoFreio();

		tipo.setTxtfreio(txtFreio.getText());

		dao.inserir(tipo);
		limpar();

		}
	}

	@FXML public void voltar() {
		Main.abrirTela("Main");
	}

	private void limpar() {
		txtFreio.setText("");
	}

}
