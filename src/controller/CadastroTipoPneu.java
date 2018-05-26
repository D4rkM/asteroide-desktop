package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.CadastroDAO;
import view.Main;

public class CadastroTipoPneu {

	@FXML TextField txtPneu;

	TipoPneu tipoPneuAtualizar;

private boolean atualizacao=false;

	CadastroDAO dao = new CadastroDAO();

	public void initialize() {
		if(tipoPneuAtualizar != null) {
			txtPneu.setText(tipoPneuAtualizar.getPneu());
			atualizacao = true;

			System.out.println("txtPneu: "+ tipoPneuAtualizar.getPneu());
		}

	}



	@FXML public void inserir(){

		if(atualizacao) {
			tipoPneuAtualizar.setPneu(txtPneu.getText());

			dao.atualizarTipoPneu(tipoPneuAtualizar);

		}else{TipoPneu tipo = new TipoPneu();

		tipo.setPneu(txtPneu.getText());

		dao.inserir(tipo);
		limpar();

		}
	}

	@FXML public void voltar() {
		Main.abrirTela("Main");
	}

	private void limpar() {
		txtPneu.setText("");
	}


}
