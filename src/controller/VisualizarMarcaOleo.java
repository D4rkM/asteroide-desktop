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

public class VisualizarMarcaOleo {

	@FXML TableColumn colunaID;
	@FXML TableColumn colunaMarcaOleo;
	@FXML TableView tblMarcaOleo;

	CadastroDAO dao;

	public void initialize() {

	dao = new CadastroDAO();

	colunaID.setCellValueFactory(new PropertyValueFactory<MarcaOleo, Integer>("id"));
	colunaMarcaOleo.setCellValueFactory(new PropertyValueFactory<MarcaOleo, String>("MarcaOleo"));

	ArrayList<MarcaOleo> lstMarcaOleo = dao.obterTodos4();

	tblMarcaOleo.setItems(FXCollections.observableArrayList(lstMarcaOleo));

	System.out.println("Inicialização");

	}


	@FXML public void deletarMarcaOleo () {
		MarcaOleo o = (MarcaOleo)tblMarcaOleo.getSelectionModel().getSelectedItem();
		dao.deletarMarcaOleo(o.getId());

		tblMarcaOleo.getItems().remove(o);
	}

	@FXML public void marcaOleoAtualizar() {
		MarcaOleo o = (MarcaOleo)tblMarcaOleo.getSelectionModel().getSelectedItem();


		//Main.abrirTela2("lista_tipoFreio");

		Stage primaryStage = new Stage();
		//Abrir tela:
		Parent tela;

		try{

			FXMLLoader loader = new FXMLLoader(Main.class.getResource("modal_marcaOleo.fxml"));


			//carregar o arquivo XML
			tela = loader.load();


			CadastroMarcaOleo controller = new CadastroMarcaOleo();
			controller.marcaOleoAtualizar=o;

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

	@FXML public void cadastrarMarcaOleo() {

		Stage primaryStage = new Stage();
		//Abrir tela:
		Parent tela;

		try{

			//carregar o arquivo XML
			tela = FXMLLoader.load(Main.class.getResource("modal_marcaOleo.fxml"));

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
