package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import javafx.collections.ObservableList;

public class MarcaPneu {
	
	private int id;
	private String MarcaPneu;
	
	public MarcaPneu(String MarcaPneu) {
		this.MarcaPneu = new String(MarcaPneu);
	}
	
	public MarcaPneu(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarcaPneu() {
		return MarcaPneu;
	}
	public void setMarcaPneu(String marcaPneu) {
		MarcaPneu = marcaPneu;
	}
	public static void PreenchaInformacao(Connection connection, ObservableList<MarcaPneu> lista) {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT marca FROM marca_pneu");
			while (resultado.next()) {
				lista.add(new MarcaPneu(resultado.getString("marca")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String toString() {

		return MarcaPneu.toString();
	}
	
	
}
