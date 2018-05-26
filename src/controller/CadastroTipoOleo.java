package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.CadastroDAO;

public class CadastroTipoOleo {


	@FXML TextField txtOleo;

	TipoOleo oleoAtualizar;

	private boolean atualizacao=false;

	CadastroDAO dao = new CadastroDAO();

	public void initialize(){

		if(oleoAtualizar != null) {
			txtOleo.setText(oleoAtualizar.getTxtOleo());
			atualizacao = true;

			System.out.println("txtOleo: "+ oleoAtualizar.getTxtOleo());
		}

	}


	@FXML public void inserir(){

		if(atualizacao) {
			oleoAtualizar.setTxtOleo(txtOleo.getText());

			dao.atualizar(oleoAtualizar);
		}else{
			TipoOleo t = new TipoOleo();
			t.setTxtOleo(txtOleo.getText());

			dao.inserir(t);
			limpar();


		/*TipoOleo tipo = new TipoOleo();

		tipo.setTxtOleo(txtOleo.getText());

		dao.inserir(tipo);*/
		}
	}

	private void limpar() {
		txtOleo.setText("");
	}

}
