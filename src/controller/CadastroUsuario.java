package controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.CadastroDAO;

public class CadastroUsuario {


    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtCelular;

    @FXML
    private TextField txtCEP;

    @FXML
    private TextField txtCidade;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtComplemento;

    @FXML
    private TextField txtLogradouro;

    @FXML
    private TextField txtRG;

    @FXML
    private TextField txtCPF;

    @FXML
    private DatePicker txtDtNasc;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtLogin;

    CadastroUsuario usuarioAtualizar;

    private boolean atualizacao=false;

    CadastroDAO dao = new CadastroDAO();
/*
    public void initialize(){

    	if(usuarioAtualizar != null){
    		txtNome.setText(usuarioAtualizar.getNome());
    		txtEmail.setText(usuarioAtualizar.getEmail());
    		txtTelefone.setText(usuarioAtualizar.getTelefone());
    		txtCelular.setText(usuarioAtualizar.getCelular());
    		txtCEP.setText(usuarioAtualizar.getCEP());
    		txtCidade.setText(usuarioAtualizar.getCidade());
    		txtNumero.setText(usuarioAtualizar.getNumero());
    		txtComplemento.setText(usuarioAtualizar.getComplemento());
    		txtLogradouro.setText(usuarioAtualizar.getLogradouro());
    		txtRG.setText(usuarioAtualizar.getRG());
    		txtCPF.setText(usuarioAtualizar.getCPF());
    		//txtDTnasc)
    		txtLogin.setText(usuarioAtualizar.getLogin());
    		txtSenha.setText(usuarioAtualizar.getSenha());
    		atualizacao=true;

    	}

    }

    @FXML public void inserir(){

    	if(atualizacao){
    		usuarioAtualizar.setNome(txtNome.getText());
    		usuarioAtualizar.setEmail(txtEmail.getText());
    		usuarioAtualizar.setTelefone(txtTelefone.getText());
    		usuarioAtualizar.setCelular(txtCelular.getText());
    		usuarioAtualizar.setCEP(txtCEP.getText());
    		usuarioAtualizar.setCidade(txtCidade.getText());
    		usuarioAtualizar.setNumero(txtNumero.getText());
    		usuarioAtualizar.setComplemento(txtComplemento.getText());
    		usuarioAtualizar.setLogradouro(txtLogradouro.getText());
    		usuarioAtualizar.setRG(txtRG.getText());
    		usuarioAtualizar.setCPF(txtCPF.getText());
    		//dtnasc
    		usuarioAtualizar.setLogin(txtLogin.getText());
    		usuarioAtualizar.setSenha(txtSenha.getText());

    		dao.atualizar(usuarioAtualizar);

    	}else{

    	}

    	}

    }*/

}
