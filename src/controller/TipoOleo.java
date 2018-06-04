package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import javafx.collections.ObservableList;

public class TipoOleo {

	private int id;
	private String txtOleo;
	
	public TipoOleo(String txtOleo) {
		this.txtOleo = new String(txtOleo);
	}
	
	public TipoOleo() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTxtOleo() {
		return txtOleo;
	}
	public void setTxtOleo(String txtOleo) {
		this.txtOleo = txtOleo;
	}
	public static void PreenchaInformacao(Connection connection, ObservableList<TipoOleo> lista) {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT tipo FROM tipo_oleo");
			while (resultado.next()) {
				lista.add(new TipoOleo(resultado.getString("tipo")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		
		return txtOleo.toString();
	}

	

}
