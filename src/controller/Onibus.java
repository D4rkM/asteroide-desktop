package controller;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Onibus {

	private int id;
    private String txtPlaca;
   // private ComboBox<Poltronas> cmbPoltronas;
    private String txtPoltrona;
    private String txtKmRodado;
    private ComboBox<Classe> cmbClasse;
    private String txtCodigo;
    private ComboBox<Status> cmbStatus;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTxtPlaca() {
		return txtPlaca;
	}
	public void setTxtPlaca(String txtPlaca) {
		this.txtPlaca = txtPlaca;
	}
	/*public ComboBox<Poltronas> getCmbPoltronas() {
		return cmbPoltronas;
	}
	public void setCmbPoltronas(ComboBox<Poltronas> cmbPoltronas) {
		this.cmbPoltronas = cmbPoltronas;
	}*/
	public String getTxtKmRodado() {
		return txtKmRodado;
	}
	public void setTxtKmRodado(String txtKmRodado) {
		this.txtKmRodado = txtKmRodado;
	}
	public ComboBox<Classe> getCmbClasse() {
		return cmbClasse;
	}
	public void setCmbClasse(ComboBox<Classe> cmbClasse) {
		this.cmbClasse = cmbClasse;
	}
	public String getTxtCodigo() {
		return txtCodigo;
	}
	public void setTxtCodigo(String txtCodigo) {
		this.txtCodigo = txtCodigo;
	}
	public ComboBox<Status> getCmbStatus() {
		return cmbStatus;
	}
	public void setCmbStatus(ComboBox<Status> cmbStatus) {
		this.cmbStatus = cmbStatus;
	}
	public void setCmbClasse(Classe selectedItem) {
		// TODO Auto-generated method stub
		
	}
	public void setCmbPoltronas(Poltronas selectedItem) {
		// TODO Auto-generated method stub
		
	}
	public void setCmbStatus(Status selectedItem) {
		// TODO Auto-generated method stub
		
	}
	public String getTxtPoltrona() {
		return txtPoltrona;
	}
	public void setTxtPoltrona(String txtPoltrona) {
		this.txtPoltrona = txtPoltrona;
	}
	

    
    
}
