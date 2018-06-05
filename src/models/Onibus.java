package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Onibus {
	private IntegerProperty idOnibus;
	private StringProperty txtPlaca;
	private StringProperty txtKmRodado;
	private StringProperty txtCodigo;
	private StringProperty txtPoltrona;
	private Classe classe;
	private Status status;
	

	public Onibus(Integer idOnibus, String txtPlaca, String txtKmRodado, String txtCodigo, String txtPoltrona, Classe classe, Status status) {
		this.idOnibus = new SimpleIntegerProperty(idOnibus);
		this.txtPlaca = new SimpleStringProperty(txtPlaca);
		this.txtKmRodado = new SimpleStringProperty(txtKmRodado);
		this.txtCodigo = new SimpleStringProperty(txtCodigo);
		this.txtPoltrona = new SimpleStringProperty(txtPoltrona);
		this.classe = classe;
		this.status = status;
	}
	public IntegerProperty getIdOnibus() {
		return idOnibus;
	}
	public void setIdOnibus(IntegerProperty idOnibus) {
		this.idOnibus = idOnibus;
	}
	public StringProperty getTxtPlaca() {
		return txtPlaca;
	}
	public void setTxtPlaca(StringProperty txtPlaca) {
		this.txtPlaca = txtPlaca;
	}
	public StringProperty getTxtKmrodado() {
		return txtKmRodado;
	}
	public void setTxtKmrodado(StringProperty txtKmRodado) {
		this.txtKmRodado = txtKmRodado;
	}
	public StringProperty getTxtCodigo() {
		return txtCodigo;
	}
	public void setTxtCodigo(StringProperty txtCodigo) {
		this.txtCodigo = txtCodigo;
	}
	
	public StringProperty getTxtPoltrona() {
		return txtPoltrona;
	}
	public void setTxtPoltrona(StringProperty txtPoltrona) {
		this.txtPoltrona = txtPoltrona;
	}
	
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public int guardarRegistro(Connection connection) {
		try {
			PreparedStatement instrucao =
					connection.prepareStatement("INSERT INTO onibus (poltronas, km_rodado, id_classe, placa, "
					+ "status_onibus_id, cod_antt) "+
					"VALUES (?, ?, ?, ?, ?, ?)");
			instrucao.setString(1, txtPoltrona.get());
			instrucao.setString(2, txtKmRodado.get());
			instrucao.setInt(3, classe.getIdClasse());
			instrucao.setString(4, txtPlaca.get());
			instrucao.setInt(5,status.getIdStatus());
			instrucao.setString(6, txtCodigo.get());
			return instrucao.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	
	
	}

}
