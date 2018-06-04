package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import javafx.collections.ObservableList;

public class TipoPneu {
	
	private int id;
	private String Pneu;
	
	public TipoPneu(String Pneu) {
		this.Pneu = new String(Pneu);
	}
	
	public TipoPneu() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPneu() {
		return Pneu;
	}
	public void setPneu(String pneu) {
		Pneu = pneu;
	}
	
	public static void PreenchaInformacao(Connection connection, ObservableList<TipoPneu> lista) {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT tipo FROM tipo_pneu");
			while (resultado.next()) {
				lista.add(new TipoPneu(resultado.getString("tipo")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
	
		return Pneu.toString();
	}
	
}
