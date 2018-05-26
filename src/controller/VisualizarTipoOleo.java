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

public class VisualizarTipoOleo {

	@FXML TableColumn colunaID;
	@FXML TableColumn colunaTipoOleo;
	@FXML TableView tblTipoOleo;

	CadastroDAO dao;

	public void initialize(){

		dao = new CadastroDAO();

		colunaID.setCellValueFactory(new PropertyValueFactory<TipoOleo, Integer>("id"));
		colunaTipoOleo.setCellValueFactory(new PropertyValueFactory<TipoOleo, String>("txtOleo"));



		ArrayList<TipoOleo> lstTipoOleo = dao.obterTodos1();

		tblTipoOleo.setItems(
				FXCollections.observableArrayList(lstTipoOleo)
				);


		System.out.println("inicialização ");
	}

	@FXML public void deletarTipoOleo() {


		TipoOleo t = (TipoOleo)tblTipoOleo.getSelectionModel().getSelectedItem();
		dao.deletarTipoOleo(t.getId());

		//tirando da tela
		tblTipoOleo.getItems().remove(t);


	}

	@FXML public void atualizar() {
		TipoOleo t = (TipoOleo)tblTipoOleo.getSelectionModel().getSelectedItem();


		//Main.abrirTela2("lista_tipoFreio");

		Stage primaryStage = new Stage();
		//Abrir tela:
		Parent tela;

		try{

			FXMLLoader loader = new FXMLLoader(Main.class.getResource("modal_tipoOleo.fxml"));


			//carregar o arquivo XML
			tela = loader.load();


			CadastroTipoOleo controller = new CadastroTipoOleo();
			controller.oleoAtualizar=t;

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

	@FXML public void cadastrar() {

		Stage primaryStage = new Stage();
		//Abrir tela:
		Parent tela;

		try{

			//carregar o arquivo XML
			tela = FXMLLoader.load(Main.class.getResource("modal_tipoOleo.fxml"));

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
