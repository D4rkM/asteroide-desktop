package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import controller.Onibus;
import controller.TipoFreio;
import controller.TipoOleo;

public class CadastroDAO {

	Connection con;
	public CadastroDAO(){
		con = DbUtils.getConnection();

	}

	public void inserir(Onibus...onibus){

		for(Onibus o : onibus){


			String sql = "inserir_onibus( ?,  ?, ;";

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, o.getTxtDesc());
				ps.setString(2, o.getTxtDesc());

				int rowsInserted = ps.executeUpdate();
				if (rowsInserted > 0) {
				    System.out.println("Inserido com sucesso");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}

		}
	}
	
	
	//Efetua o select no banco
	public ArrayList<TipoFreio> obterTodos(){

		ArrayList<TipoFreio> tipo_freio=  new ArrayList<>();


		String SQL ="select * from tipo_freio;";

		try{

			PreparedStatement ps = con.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				TipoFreio tipo = new TipoFreio();
				tipo.setId(rs.getInt("id"));
				tipo.setTxtFreio(rs.getString("Tipo"));
				

				tipo_freio.add(tipo);
			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		return tipo_freio;

	}


	public TipoFreio obterPorId(int id){
		TipoFreio tipo = null;

		String SQL ="select * from tipo_freio where id = ?;";


		try{

			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, id); //passando o ID pro select

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				tipo = new TipoFreio();
				tipo.setTxtFreio(rs.getString("tipo"));
				

			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		return tipo;
	}
	public void inserir(TipoFreio...tipo_freio){

		for (TipoFreio tipo : tipo_freio){

			String sql = "INSERT INTO tipo_freio set tipo= ?;";

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, tipo.getTxtFreio());


				int rowsInserted = ps.executeUpdate();
				if (rowsInserted > 0) {
				    System.out.println("Inserido com sucesso");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

	}

	public void inserir(TipoOleo...tipo_oleo){

		for (TipoOleo tipo : tipo_oleo){

			String sql = "INSERT INTO tipo_oleo set tipo= ?;";

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, tipo.getTxtOleo());


				int rowsInserted = ps.executeUpdate();
				if (rowsInserted > 0) {
				    System.out.println("Inserido com sucesso");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

	}

}

