package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;


import javafx.collections.ObservableList;

public class MarcaOleo {

	private int id;
	private String MarcaOleo;
	
	
	
	public MarcaOleo(String MarcaOleo) {
		this.MarcaOleo = new String(MarcaOleo);
	}
	public MarcaOleo() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarcaOleo() {
		return MarcaOleo;
	}
	
	
	public void setMarcaOleo(String marcaOleo) {
		MarcaOleo = marcaOleo;
	}
	
	public static void PreenchaInformacao(Connection connection, ObservableList<MarcaOleo> lista) {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT marca FROM marca_oleo");
			while (resultado.next()) {
				lista.add(new MarcaOleo(resultado.getString("marca")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		
		return MarcaOleo.toString();
	}
	
}
