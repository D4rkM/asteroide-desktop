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

public class VisualizarMarcaPneu {

	@FXML TableColumn colunaID;
	@FXML TableColumn colunaMarcaPneu;
	@FXML TableView tblMarcaPneu;

	CadastroDAO dao;

	public void initialize() {

	dao = new CadastroDAO();

	colunaID.setCellValueFactory(new PropertyValueFactory<MarcaPneu, Integer>("id"));
	colunaMarcaPneu.setCellValueFactory(new PropertyValueFactory<MarcaPneu, String>("MarcaPneu"));

	ArrayList<MarcaPneu> lstMarcaPneu = dao.obterTodos5();

	tblMarcaPneu.setItems(FXCollections.observableArrayList(lstMarcaPneu));

	System.out.println("Inicialização");

	}


	@FXML public void deletarMarcaPneu () {
		MarcaPneu p = (MarcaPneu)tblMarcaPneu.getSelectionModel().getSelectedItem();
		dao.deletarMarcaPneu(p.getId());

		tblMarcaPneu.getItems().remove(p);
	}

	@FXML public void atualizarMarcaPneu() {
		MarcaPneu p = (MarcaPneu)tblMarcaPneu.getSelectionModel().getSelectedItem();


		//Main.abrirTela2("lista_tipoFreio");

		Stage primaryStage = new Stage();
		//Abrir tela:
		Parent tela;

		try{

			FXMLLoader loader = new FXMLLoader(Main.class.getResource("modal_marcaPneu.fxml"));


			//carregar o arquivo XML
			tela = loader.load();


			CadastroMarcaPneu controller = new CadastroMarcaPneu();
			controller.marcaPneuAtualizar=p;

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

	@FXML public void cadastrarMarcaPneu() {

		Stage primaryStage = new Stage();
		//Abrir tela:
		Parent tela;

		try{

			//carregar o arquivo XML
			tela = FXMLLoader.load(Main.class.getResource("modal_marcaPneu.fxml"));

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
