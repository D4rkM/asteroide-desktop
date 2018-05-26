package models;

public class Usuario {
	
	public int id;
	public String login;
	public String senha;
	public String nome;
	
	public int getIdFuncionario() {
		return id;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.id = idFuncionario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
