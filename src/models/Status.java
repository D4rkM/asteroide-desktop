package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Status {
	
	private IntegerProperty idStatus;
	private StringProperty tipoStatus;
	
	public Status(Integer idStatus, String tipoStatus){
		this.idStatus = new SimpleIntegerProperty(idStatus);
		this.tipoStatus = new SimpleStringProperty(tipoStatus);
	}
	
	public Status(String string) {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdStatus() {
		return idStatus.get();
	}
	public void setIdStatus(IntegerProperty idStatus) {
		this.idStatus = idStatus;
	}
	public StringProperty getTipoStatus() {
		return tipoStatus;
	}
	public void setTipoStatus(StringProperty tipoStatus) {
		this.tipoStatus = tipoStatus;
	}
	
	
	public static void PreenchaInformacao(java.sql.Connection connection, ObservableList<Status> listaStatus) {
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
	
	/*@Override
	public String toString() {
		
		return tipoStatus.get();
	}*/
	

}
