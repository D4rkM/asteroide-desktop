	package controller;

import java.awt.TextField;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import models.CadastroDAO;

public class CadastroOnibus {

	@FXML TextField txtPlaca;
	@FXML TextField txtDesc;
	@FXML TextField txtModelo;
	@FXML TextField txtKmRodado;
	@FXML TextField txtKmManutencao;

	Onibus onibusAtualizar;

	//private boolean atualizacao=false;

	CadastroDAO dao = new CadastroDAO();

/*	public void initialize(){

		if(onibusAtualizar != null){
			txtPlaca.setText(onibusAtualizar.getTxtPlaca());
			txtDesc.setText(onibusAtualizar.getTxtDesc());
			txtModelo.setText(onibusAtualizar.getTxtModelo());
			txtKmRodado.setText(onibusAtualizar.getTxtKmRodado());
			txtKmManutencao.setText(onibusAtualizar.getTxtKmManutencao());
			atualizacao = true;

		}
	}*/

	@FXML public void cadastrar(){

		/*if(atualizacao){

			onibusAtualizar.setTxtPlaca(txtPlaca.getText());
			onibusAtualizar.setTxtDesc(txtDesc.getText());
			onibusAtualizar.setTxtModelo(txtModelo.getText());
			onibusAtualizar.setTxtKmRodado(txtKmRodado.getText());
			onibusAtualizar.setTxtKmManutencao(txtKmManutencao.getText());

			dao.atualizar(onibusAtualizar);


		}else {*/

			Onibus o = new Onibus();
			o.setTxtPlaca(txtPlaca.getText());
			o.setTxtDesc(txtDesc.getText());
			o.setTxtModelo(txtModelo.getText());
			o.setTxtKmRodado(txtKmRodado.getText());
			o.setTxtKmManutencao(txtKmManutencao.getText());

			dao.inserir(o);




	}
}