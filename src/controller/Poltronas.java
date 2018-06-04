package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import javafx.collections.ObservableList;

public class Poltronas {

	private int id;
	private String Poltronas;
	
	public Poltronas (String Poltronas) {
		this.Poltronas = new String(Poltronas);
	}
	
	public Poltronas() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPoltronas() {
		return Poltronas;
	}
	public void setPoltronas(String poltronas) {
		Poltronas = poltronas;
	}
	
	public static void PreenchaInformacao(Connection connection, ObservableList<Poltronas> lista) {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT poltronas FROM onibus");
			while (resultado.next()) {
				lista.add(new Poltronas(resultado.getString("poltronas")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		
		return Poltronas.toString();
	}
	
	
}
