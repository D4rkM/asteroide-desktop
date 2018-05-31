package view;


import java.io.IOException;

import controller.CadastroTipoFreio;
import controller.CadastroTipoOleo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import models.CadastroDAO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;


public class Main extends Application {

	@FXML TextField txtUsuario;
	@FXML TextField txtSenha;

	String nomeUser;
	String senha;

	static Stage primaryStage;


	@Override
	public void start(Stage primaryStage) {

		Main.primaryStage = primaryStage;
		abrirTela("cadastro_onibus");

	}

	public static void abrirTela(String fileName){
		//Abrir tela:
		Parent tela;

		try{

			//carregar o arquivo XML
			tela = FXMLLoader.load(Main.class.getResource(fileName+".fxml"));


			//Criando a cena
			Scene sc = new Scene(tela);

			//Exibindo a cena no stage principal
			primaryStage.setScene(sc);
			primaryStage.show();





		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void abrirTela2(String fileName){
		//Abrir tela:
		Parent tela;

		try{

			FXMLLoader loader = new FXMLLoader(Main.class.getResource(fileName+".fxml"));

			//definindo controller
			//loader.setController(controller);

			//carregar o arquivo XML
			tela = loader.load();


			//Criando a cena
			Scene sc = new Scene(tela);

			//Exibindo a cena no stage principal
			primaryStage.setScene(sc);
			primaryStage.show();



		}catch(Exception ex){
			ex.printStackTrace();
		}
	}




	@FXML public void Entrar() {



		CadastroDAO user_class = new CadastroDAO();


		nomeUser=(txtUsuario.getText());
		senha=(txtSenha.getText());

		System.out.println(nomeUser +" " + senha);

		user_class.loginUser(nomeUser, senha);

		if(user_class.loginUser(nomeUser, senha)){
			//HomeController controller = new HomeController();
			//abrirTela2("Home");
			Parent abrirTela = null;


			try {
				Parent loader = FXMLLoader.load(getClass().getResource("home.fxml"));

				//carregar o arquivo XML
				//abrirTela = loader.load();


				//Criando a cena
				Scene sc = new Scene(loader);

				//Exibindo a cena no stage principal
				primaryStage.setScene(sc);
				primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//borderPane.setCenter(abrirTela);
		}else{
			System.out.println("nao Logado");
		}

		//abrirTela("controller_Usuario",controller);
	}

	public static void main(String[] args) {
		launch(args);
	}

	/*
	@FXML public void tipoFreio() {

		CadastroTipoFreio controller = new CadastroTipoFreio();
		abrirTela("modal_tipoFreio",controller);
	}

	@FXML public void tipoOleo() {

		CadastroTipoOleo controller = new CadastroTipoOleo();
		abrirTela("modal_tipoOleo",controller);
	}
*/

}
