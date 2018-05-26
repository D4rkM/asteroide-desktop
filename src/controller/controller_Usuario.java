package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.CadastroDAO;
import models.Usuario;

public class controller_Usuario {

	Usuario user;

	CadastroDAO user_class = new CadastroDAO();

	@FXML TextField txtUsuario;
	@FXML TextField txtSenha;

	String nomeUser;
	String senha;

	@FXML public void entrar() {

		nomeUser=(txtUsuario.getText());
		senha=(txtSenha.getText());

		System.out.println(nomeUser +" " + senha);

		user_class.loginUser(nomeUser, senha);


}
	
}
