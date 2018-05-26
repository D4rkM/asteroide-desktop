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

public class VisualizarTipoPneu {

	@FXML TableColumn colunaID;
	@FXML TableColumn colunaTipoPneu;
	@FXML TableView tblTipoPneu;

	CadastroDAO dao;

	public void initialize(){

		dao = new CadastroDAO();

		colunaID.setCellValueFactory(new PropertyValueFactory<TipoPneu, Integer>("id"));
		colunaTipoPneu.setCellValueFactory(new PropertyValueFactory<TipoPneu, String>("Pneu"));



		ArrayList<TipoPneu> lstTipoPneu = dao.obterTodos2();

		tblTipoPneu.setItems(
				FXCollections.observableArrayList(lstTipoPneu)
				);


		System.out.println("inicialização ");
	}

	@FXML public void deletarTipoPneu() {


		TipoPneu tipo = (TipoPneu)tblTipoPneu.getSelectionModel().getSelectedItem();
		dao.deletarTipoPneu(tipo .getId());

		//tirando da tela
		tblTipoPneu.getItems().remove(tipo);


	}
	@FXML public void atualizarTipoPneu() {
		TipoPneu tipo = (TipoPneu)tblTipoPneu.getSelectionModel().getSelectedItem();


		//Main.abrirTela2("lista_tipoFreio");

		Stage primaryStage = new Stage();
		//Abrir tela:
		Parent tela;

		try{


			FXMLLoader loader = new FXMLLoader(Main.class.getResource("modal_tipoPneu.fxml"));

			//carregar o arquivo XML
			tela = loader.load();


			CadastroTipoPneu controller = new CadastroTipoPneu();
			controller.tipoPneuAtualizar=tipo;

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
			tela = FXMLLoader.load(Main.class.getResource("modal_tipoPneu.fxml"));

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
