package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import javafx.collections.ObservableList;


public class Status {
	
	private int id;
	private String Status;
	
	
	
	public Status(String Status) {
		this.Status = new String(Status);
	}
	
	public Status() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String Status) {
		this.Status = Status;
	}
	
	public static void PreenchaInformacao(Connection connection, ObservableList<Status> listaStatus) {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT status FROM status_onibus");
			while (resultado.next()) {
				listaStatus.add(new Status(resultado.getString("status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		
		return Status.toString();
	}
	
}
