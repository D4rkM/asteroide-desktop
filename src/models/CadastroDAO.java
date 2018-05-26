package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controller.CadastroUsuario;
import controller.Classe;
import controller.MarcaFreio;
import controller.MarcaOleo;
import controller.MarcaPneu;
import controller.Onibus;
import controller.TipoFreio;
import controller.TipoOleo;
import controller.TipoPneu;

public class CadastroDAO {

	Connection con;
	private int id;
	public CadastroDAO(){
		con = DbUtils.getConnection();

	}

	public boolean loginUser(String nomeUser,String senha){
    	boolean verifica = false;
    	int id = 0;

    	String sql ="select * FROM funcionario Where login=? and senha=?;";

    	try{

    		PreparedStatement st = con.prepareStatement(sql);
    		st.setString(1, nomeUser);
    		st.setString(2, senha);

    		ResultSet rs = st.executeQuery();
    		//String sql2 ="select @_idFuncionario as idFuncionario;";



    		//ResultSet rs2 =executeQuery(sql2);

    		while(rs.next()){

    			Usuario u = new Usuario();

    			u.setIdFuncionario(rs.getInt("id"));
    			//idFuncionario = (rs.getInt(idFuncionario));


    			verifica = true;
    		}



    	}catch(Exception ex){
			ex.printStackTrace();
    	}
		return verifica;



    }


	private ResultSet executeQuery(String sql2) {
		// TODO Auto-generated method stub
		return null;
	}


/*****************PARTE DE TIPO FREIO*******************/

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
				tipo.setTxtfreio(rs.getString("tipo"));


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
				tipo.setTxtfreio(rs.getString("tipo"));


			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		System.out.println(tipo);
		return tipo;
	}

	public boolean atualizar(TipoFreio tipoFreioAtualizar) {

		String sql = "UPDATE tipo_freio SET tipo=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tipoFreioAtualizar.getTxtfreio());

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Atualizado com sucesso");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return false;

	}


	public void inserir(TipoFreio...tipo_freio){

		for (TipoFreio tipo : tipo_freio){

			String sql = "INSERT INTO tipo_freio set tipo= ?;";

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, tipo.getTxtfreio());


				int rowsInserted = ps.executeUpdate();
				if (rowsInserted > 0) {
				    System.out.println("Inserido com sucesso");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

	}

	public boolean deletar (int id) {

		String sql = "DELETE FROM tipo_freio WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			int rowsDeleted = ps.executeUpdate();
			if(rowsDeleted > 0) {
				System.out.println("DELETADOOO");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

/***************************************************************/

	/***********************PARTE DE TIPO OLEO****************************/
	public ArrayList<TipoOleo> obterTodos1(){

		ArrayList<TipoOleo> tipo = new ArrayList<>();

		String SQL = "select * from tipo_oleo;";

		try {
			PreparedStatement ps = con.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				TipoOleo t = new TipoOleo();
				t.setId(rs.getInt("id"));
				t.setTxtOleo(rs.getString("tipo"));

				tipo.add(t);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		return tipo;

	}

	public TipoOleo obterPorId1(int id) {
		TipoOleo t = null;

		String SQL = "select * from tipo_oleo where id = ?;";

		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				t = new TipoOleo();
				t.setTxtOleo(rs.getString("tipo"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return t;
	}

	public boolean atualizar(TipoOleo t) {

		String sql = "UPDATE tipo_oleo set tipo=? WHERE id=?;";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getTxtOleo());
			ps.setInt(2, t.getId());

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0 ) {
				System.out.println("Atualizado com sucesso");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}


	public void inserir(TipoOleo...tipo_oleo){

		for (TipoOleo t : tipo_oleo){

			String sql = "INSERT INTO tipo_oleo set tipo= ?;";

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, t.getTxtOleo());


				int rowsInserted = ps.executeUpdate();
				if (rowsInserted > 0) {
				    System.out.println("Inserido com sucesso");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

	}

	public boolean deletarTipoOleo(int id) {
		String sql = "DELETE FROM tipo_oleo WHERE id=?;";

	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		int rowsDeleted = ps.executeUpdate();
		if (rowsDeleted > 0) {
			System.out.println("DELETADOOO");
			return true;
		}
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return false;

	}

/******************************************************/
/*****************PARTE DE TIPO PNEU*******************/

	//Efetua o select no banco
	public ArrayList<TipoPneu> obterTodos2(){

		ArrayList<TipoPneu> tipo_pneu=  new ArrayList<>();


		String SQL ="select * from tipo_pneu;";

		try{

			PreparedStatement ps = con.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				TipoPneu tipo = new TipoPneu();
				tipo.setId(rs.getInt("id"));
				tipo.setPneu(rs.getString("tipo"));


				tipo_pneu.add(tipo);
			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		return tipo_pneu;

	}


	public TipoPneu obterPorId2(int id){
		TipoPneu tipo = null;

		String SQL ="select * from tipo_pneu where id = ?;";


		try{

			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, id); //passando o ID pro select

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				tipo = new TipoPneu();
				tipo.setPneu(rs.getString("tipo"));


			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		System.out.println(tipo);
		return tipo;
	}

	public boolean atualizarTipoPneu(TipoPneu p) {

		String sql = "UPDATE tipo_freio SET tipo=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getPneu());

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Atualizado com sucesso");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return false;

	}


	public void inserir(TipoPneu...tipo_pneu){

		for (TipoPneu tipo : tipo_pneu){

			String sql = "INSERT INTO tipo_pneu set tipo= ?;";

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, tipo.getPneu());


				int rowsInserted = ps.executeUpdate();
				if (rowsInserted > 0) {
				    System.out.println("Inserido com sucesso");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

	}

	public boolean deletarTipoPneu(int id) {

		String sql = "DELETE FROM tipo_pneu WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			int rowsDeleted = ps.executeUpdate();
			if(rowsDeleted > 0) {
				System.out.println("DELETADO");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

/***************************************************************/
/*****************PARTE DE MARCA FREIO*******************/

	//Efetua o select no banco
	public ArrayList<MarcaFreio> obterTodos3(){

		ArrayList<MarcaFreio> marca_freio=  new ArrayList<>();


		String SQL ="select * from marca_freio;";

		try{

			PreparedStatement ps = con.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				MarcaFreio marca = new MarcaFreio();
				marca.setId(rs.getInt("id"));
				marca.setMarcaFreio(rs.getString("marca"));


				marca_freio.add(marca);
			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		return marca_freio;

	}


	public MarcaFreio obterPorId3(int id){
		MarcaFreio marca = null;

		String SQL ="select * from marca_freio where id = ?;";


		try{

			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, id); //passando o ID pro select

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				marca = new MarcaFreio();
				marca.setMarcaFreio(rs.getString("marca"));


			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		System.out.println(marca);
		return marca;
	}

	public boolean atualizarMarcaFreio(MarcaFreio m) {

		String sql = "UPDATE marca_freio SET tipo=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, m.getMarcaFreio());

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Atualizado com sucesso");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return false;

	}


	public void inserir(MarcaFreio...marca_freio){

		for (MarcaFreio marca : marca_freio){

			String sql = "INSERT INTO marca_freio set marca= ?;";

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, marca.getMarcaFreio());


				int rowsInserted = ps.executeUpdate();
				if (rowsInserted > 0) {
				    System.out.println("Inserido com sucesso");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

	}

	public boolean deletarMarcaFreio (int id) {

		String sql = "DELETE FROM marca_freio WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			int rowsDeleted = ps.executeUpdate();
			if(rowsDeleted > 0) {
				System.out.println("DELETADOOO");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

/***************************************************************/

/*****************PARTE DE MARCA OLEO*******************/

	//Efetua o select no banco
	public ArrayList<MarcaOleo> obterTodos4(){

		ArrayList<MarcaOleo> marca_oleo=  new ArrayList<>();


		String SQL ="select * from marca_oleo;";

		try{

			PreparedStatement ps = con.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				MarcaOleo marca = new MarcaOleo();
				marca.setId(rs.getInt("id"));
				marca.setMarcaOleo(rs.getString("marca"));


				marca_oleo.add(marca);
			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		return marca_oleo;

	}


	public MarcaOleo obterPorId4(int id){
		MarcaOleo marca = null;

		String SQL ="select * from marca_oleo where id = ?;";


		try{

			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, id); //passando o ID pro select

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				marca = new MarcaOleo();
				marca.setMarcaOleo(rs.getString("marca"));


			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		System.out.println(marca);
		return marca;
	}

	public boolean atualizarMarcaOleo(MarcaOleo o) {

		String sql = "UPDATE marca_oleo SET tipo=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, o.getMarcaOleo());

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Atualizado com sucesso");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return false;

	}


	public void inserir(MarcaOleo...marca_oleo){

		for (MarcaOleo marca : marca_oleo){

			String sql = "INSERT INTO marca_oleo set marca= ?;";

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, marca.getMarcaOleo());


				int rowsInserted = ps.executeUpdate();
				if (rowsInserted > 0) {
				    System.out.println("Inserido com sucesso");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

	}

	public boolean deletarMarcaOleo (int id) {

		String sql = "DELETE FROM marca_oleo WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			int rowsDeleted = ps.executeUpdate();
			if(rowsDeleted > 0) {
				System.out.println("DELETADOOO");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

/***************************************************************/

/*****************PARTE DE MARCA PNEU*******************/

	//Efetua o select no banco
	public ArrayList<MarcaPneu> obterTodos5(){

		ArrayList<MarcaPneu> marca_pneu=  new ArrayList<>();


		String SQL ="select * from marca_pneu;";

		try{

			PreparedStatement ps = con.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				MarcaPneu marca = new MarcaPneu();
				marca.setId(rs.getInt("id"));
				marca.setMarcaPneu(rs.getString("marca"));


				marca_pneu.add(marca);
			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		return marca_pneu;

	}


	public MarcaPneu obterPorId5(int id){
		MarcaPneu marca = null;

		String SQL ="select * from marca_pneu where id = ?;";


		try{

			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, id); //passando o ID pro select

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				marca = new MarcaPneu();
				marca.setMarcaPneu(rs.getString("marca"));


			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		System.out.println(marca);
		return marca;
	}

	public boolean atualizarMarcaPneu(MarcaPneu p) {

		String sql = "UPDATE marca_pneu SET tipo=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getMarcaPneu());

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Atualizado com sucesso");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return false;

	}


	public void inserir(MarcaPneu...marca_pneu){

		for (MarcaPneu marca : marca_pneu){

			String sql = "INSERT INTO marca_pneu set marca= ?;";

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, marca.getMarcaPneu());


				int rowsInserted = ps.executeUpdate();
				if (rowsInserted > 0) {
				    System.out.println("Inserido com sucesso");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

	}

	public boolean deletarMarcaPneu (int id) {

		String sql = "DELETE FROM marca_pneu WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			int rowsDeleted = ps.executeUpdate();
			if(rowsDeleted > 0) {
				System.out.println("DELETADOOO");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

/***************************************************************/
	/*****************PARTE DE CADASTRO DE CLASSE*******************/

	//Efetua o select no banco
	public ArrayList<Classe> obterTodos6(){

		ArrayList<Classe> classe_tipo=  new ArrayList<>();


		String SQL ="select * from classe;";

		try{

			PreparedStatement ps = con.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				Classe tipo = new Classe();
				tipo.setId(rs.getInt("id"));
				tipo.setClasse(rs.getString("tipo_classe"));
				tipo.setDesc(rs.getString("txtDesc"));


				classe_tipo.add(tipo);
			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		return classe_tipo;

	}


	public Classe obterPorId6(){
		Classe tipo_classe = null;

		String SQL ="select * from classe where id = ?;";


		try{

			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, id); //passando o ID pro select

			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				tipo_classe = new Classe();
				tipo_classe.setClasse(rs.getString("tipo_classe"));
				tipo_classe.setDesc(rs.getString("descricao"));
			}


		}catch(Exception ex){
			ex.printStackTrace();
		}

		System.out.println(tipo_classe);
		return tipo_classe;
	}

	public boolean atualizarClasse(Classe c) {

		String sql = "UPDATE classe SET tipo_classe=?, descricao=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getClasse());
			ps.setString(2, c.getDesc());


			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Atualizado com sucesso");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return false;

	}


	public void inserir(Classe...tipo_classe){

		for (Classe classe : tipo_classe){

			String sql = "INSERT INTO classe set tipo_classe=?, descricao=?;";

			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, classe.getClasse());
				ps.setString(1, classe.getDesc());


				int rowsInserted = ps.executeUpdate();
				if (rowsInserted > 0) {
				    System.out.println("Inserido com sucesso");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

	}

	public boolean deletarClasse (int id) {

		String sql = "DELETE FROM classe WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			int rowsDeleted = ps.executeUpdate();
			if(rowsDeleted > 0) {
				System.out.println("DELETADOOO");
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

/***************************************************************/


}

