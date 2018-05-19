package view;


import controller.CadastroTipoFreio;
import controller.CadastroTipoOleo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;


public class Main extends Application {


	static Stage primaryStage;


	@Override
	public void start(Stage primaryStage) {

		Main.primaryStage = primaryStage;
		abrirTela("home");

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


	public static void abrirTela(String fileName, Object controller){
		//Abrir tela:
		Parent tela;

		try{

			FXMLLoader loader = new FXMLLoader(Main.class.getResource(fileName+".fxml"));

			//definindo controller
			loader.setController(controller);

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

	public static void main(String[] args) {
		launch(args);
	}

	@FXML public void tipoFreio() {

		CadastroTipoFreio controller = new CadastroTipoFreio();
		abrirTela("modal_tipoFreio",controller);
	}

	@FXML public void tipoOleo() {

		CadastroTipoOleo controller = new CadastroTipoOleo();
		abrirTela("modal_tipoOleo",controller);
	}

	
}
