package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.CadastroDAO;
import view.Main;

public class VisualizarMarcaFreio {

	@FXML TableColumn colunaID;
	@FXML TableColumn colunaMarcaFreio;
	@FXML TableView tblMarcaFreio;

	CadastroDAO dao;

	public void initialize() {

	dao = new CadastroDAO();

	colunaID.setCellValueFactory(new PropertyValueFactory<MarcaFreio, Integer>("id"));
	colunaMarcaFreio.setCellValueFactory(new PropertyValueFactory<MarcaFreio, String>("MarcaFreio"));

	ArrayList<MarcaFreio> lstMarcaFreio = dao.obterTodos3();

	tblMarcaFreio.setItems(FXCollections.observableArrayList(lstMarcaFreio));

	System.out.println("Inicialização");

	}


	@FXML public void deletarMarcaFreio () {
		MarcaFreio m = (MarcaFreio)tblMarcaFreio.getSelectionModel().getSelectedItem();
		dao.deletarMarcaFreio(m.getId());

		tblMarcaFreio.getItems().remove(m);
	}

	@FXML public void atualizarMarcaFreio() {
		MarcaFreio m = (MarcaFreio)tblMarcaFreio.getSelectionModel().getSelectedItem();


		//Main.abrirTela2("lista_tipoFreio");

		Stage primaryStage = new Stage();
		//Abrir tela:
		Parent tela;

		try{

			FXMLLoader loader = new FXMLLoader(Main.class.getResource("modal_marcaFreio.fxml"));


			//carregar o arquivo XML
			tela = loader.load();


			CadastroMarcaFreio controller = new CadastroMarcaFreio();
			controller.marcaFreioAtualizar=m;

			loader.setController(controller);


			//Criando a cena
			Scene sc = new Scene(tela);

			//Exibindo a cena no stage principal
			primaryStage.setScene(sc);
			primaryStage.show();

		}catch(Exception ex){
			ex.printStackTrace();
		}


	}

	@FXML public void cadastrarMarcaFreio() {

		Stage primaryStage = new Stage();
		//Abrir tela:
		Parent tela;

		try{

			//carregar o arquivo XML
			tela = FXMLLoader.load(Main.class.getResource("modal_marcaFreio.fxml"));

			//Criando a cena
			Scene sc = new Scene(tela);

			//Exibindo a cena no stage principal
			primaryStage.setScene(sc);
			primaryStage.show();

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@FXML public void voltar() {
		Main.abrirTela("Main");
	}

}
