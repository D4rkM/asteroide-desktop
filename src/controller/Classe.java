package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import javafx.collections.ObservableList;

public class Classe {

	private int id;
	private String Classe;
	private String Desc;

	public Classe(String Classe) {
		this.Classe = new String(Classe);
	}
	
	public Classe() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClasse() {
		return Classe;
	}
	public void setClasse(String classe) {
		Classe = classe;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	
	public static void PreenchaInformacao(Connection connection, ObservableList<Classe> lista) {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT tipo_classe FROM classe");
			while (resultado.next()) {
				lista.add(new Classe(resultado.getString("tipo_classe")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		
		return Classe.toString();
	}
}





