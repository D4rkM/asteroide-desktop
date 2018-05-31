package controller;

import javafx.scene.control.ComboBox;

public class Manutencao {

	private int id;
	private ComboBox<CadastroManutencao> cbPlaca;
	private ComboBox<CadastroManutencao> cbMarcaOleo;
	private ComboBox<CadastroManutencao> cbTipoOleo;
	private ComboBox<CadastroManutencao> cbTipoPneu;
	private ComboBox<CadastroManutencao> cbMarcaPneu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ComboBox<CadastroManutencao> getCbPlaca() {
		return cbPlaca;
	}
	public void setCbPlaca(ComboBox<CadastroManutencao> cbPlaca) {
		this.cbPlaca = cbPlaca;
	}
	public ComboBox<CadastroManutencao> getCbMarcaOleo() {
		return cbMarcaOleo;
	}
	public void setCbMarcaOleo(ComboBox<CadastroManutencao> cbMarcaOleo) {
		this.cbMarcaOleo = cbMarcaOleo;
	}
	public ComboBox<CadastroManutencao> getCbTipoOleo() {
		return cbTipoOleo;
	}
	public void setCbTipoOleo(ComboBox<CadastroManutencao> cbTipoOleo) {
		this.cbTipoOleo = cbTipoOleo;
	}
	public ComboBox<CadastroManutencao> getCbTipoPneu() {
		return cbTipoPneu;
	}
	public void setCbTipoPneu(ComboBox<CadastroManutencao> cbTipoPneu) {
		this.cbTipoPneu = cbTipoPneu;
	}
	public ComboBox<CadastroManutencao> getCbMarcaPneu() {
		return cbMarcaPneu;
	}
	public void setCbMarcaPneu(ComboBox<CadastroManutencao> cbMarcaPneu) {
		this.cbMarcaPneu = cbMarcaPneu;
	}



}
