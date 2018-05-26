package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.CadastroDAO;

public class CadastroClasse {

	@FXML TextField txtClasse;
	@FXML TextArea txtDesc;

	Classe classeAtualizar;

	private boolean atualizacao=false;

	CadastroDAO dao = new CadastroDAO();

	public void initialize(){
		if(classeAtualizar != null){
			txtClasse.setText(classeAtualizar.getClasse());
			txtDesc.setText(classeAtualizar.getDesc());
			atualizacao = true;

		}
	}

	@FXML public void inserir(){
		if(atualizacao){
			classeAtualizar.setClasse(txtClasse.getText());
			classeAtualizar.setDesc(txtDesc.getText());

			dao.atualizarClasse(classeAtualizar);

		}else{Classe tipo = new Classe();
		tipo.setClasse(txtClasse.getText());
		tipo.setDesc(txtDesc.getText());

		dao.inserir(tipo);
		limpar();
	  }
	}

	private void limpar(){
		txtClasse.setText("");
		txtDesc.setText("");
	}

}
