package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Classe {
	
	private IntegerProperty idClasse;
	private StringProperty tipoClasse;
	
	public Classe(Integer idClasse, String tipoClasse) {
		this.idClasse = new SimpleIntegerProperty(idClasse);
		this.tipoClasse = new SimpleStringProperty(tipoClasse);
	}

	public Classe(String string) {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdClasse() {
		return idClasse.get();
	}
	public void setIdClasse(Integer idClasse) {
		this.idClasse = new SimpleIntegerProperty(idClasse);
	}
	public String getTipoClasse() {
		return tipoClasse.get();
	}
	public void setTipoClasse(String tipoClasse) {
		this.tipoClasse = new SimpleStringProperty(tipoClasse);
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
	
	/*@Override
	public String toString() {
		
		return tipoClasse.get() ;
	}*/
	
	

}
