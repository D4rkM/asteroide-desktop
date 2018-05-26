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

public class VisualizarClasse {

	@FXML TableColumn colunaTipoClasse;
	@FXML TableColumn colunaDescricao;
	@FXML TableView tblListaClasse;

	CadastroDAO dao;

	public void initialize(){

		dao = new CadastroDAO();

		colunaTipoClasse.setCellValueFactory(new PropertyValueFactory<Classe, Integer>("classe"));
		colunaDescricao.setCellValueFactory(new PropertyValueFactory<Classe, String>("descricao"));

		ArrayList<Classe> lstClasse = dao.obterTodos6();

		tblListaClasse.setItems(FXCollections.observableArrayList(lstClasse));

		System.out.println("Inicialização");
	}

	@FXML public void deletarClasse(){
		Classe c = (Classe)tblListaClasse.getSelectionModel().getSelectedItem();
		dao.deletarClasse(c.getId());

		tblListaClasse.getItems().remove(c);
	}

	@FXML public void atualizarClasse(){
		Classe c = (Classe)tblListaClasse.getSelectionModel().getSelectedItem();

		Stage primaryStage = new Stage();

		Parent tela;

		try{
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("modal_cadastroClasse.fxml"));
			//carregar o arquivo XML
			tela = loader.load();


			CadastroClasse controller = new CadastroClasse();
			controller.classeAtualizar=c;

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

}
