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

public class Visualizar {

	@FXML TableColumn colunaID;
	@FXML TableColumn colunaTipoFreio;
	@FXML TableView tblTipoFreio;

	CadastroDAO dao;

	public void initialize() {

	dao = new CadastroDAO();

	colunaID.setCellValueFactory(new PropertyValueFactory<TipoFreio, Integer>("id"));
	colunaTipoFreio.setCellValueFactory(new PropertyValueFactory<TipoFreio, String>("txtfreio"));

	ArrayList<TipoFreio> lstTipoFreio = dao.obterTodos();

	tblTipoFreio.setItems(FXCollections.observableArrayList(lstTipoFreio));

	System.out.println("Inicialização");

	}


	@FXML public void deletar () {
		TipoFreio f = (TipoFreio)tblTipoFreio.getSelectionModel().getSelectedItem();
		dao.deletar(f.getId());

		tblTipoFreio.getItems().remove(f);
	}

	@FXML public void atualizar() {
		TipoFreio f = (TipoFreio)tblTipoFreio.getSelectionModel().getSelectedItem();


		//Main.abrirTela2("lista_tipoFreio");

		Stage primaryStage = new Stage();
		//Abrir tela:
		Parent tela;

		try{

			FXMLLoader loader = new FXMLLoader(Main.class.getResource("modal_tipoFreio.fxml"));


			//carregar o arquivo XML
			tela = loader.load();


			CadastroTipoFreio controller = new CadastroTipoFreio();
			controller.tipoFreioAtualizar=f;

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
			tela = FXMLLoader.load(Main.class.getResource("modal_tipoFreio.fxml"));

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
