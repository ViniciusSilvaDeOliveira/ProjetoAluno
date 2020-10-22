/*Nome: Vinicius Silva de Oliveira
 * RGM: 20710356 
 * Turma: 3°B
 * Período: Noturno
 */

package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.exemplo.model.Pessoais;
import br.com.exemplo.util.ConnectionFactory;

public class PessoaisDao {
	
	private Pessoais pessoais ;
	private Connection conn ;
	private PreparedStatement ps;
	private ResultSet rs ;
	
	public PessoaisDao() throws Exception {// conectar com o banco de dados e caso de erro mostrar o erro
		try {
			conn = ConnectionFactory.getConnection() ;
		}
		catch(Exception e) {
			throw new Exception("Erro---> " + e.getMessage()) ;
		}
	}
	
	public void salvar(Pessoais pessoais) throws Exception{
		
		try {
			String sql = "INSERT INTO PESSOAIS(RGM, NOME, DATA_NASCIMENTO, CPF, EMAIL, ENDERECO,"
					+ "MUNICIPIO, UF, CELULAR, CURSO, CAMPUS, PERIODO)" 
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			ps = conn.prepareStatement(sql) ;
			ps.setInt(1, pessoais.getRgm());
			ps.setString(2,  pessoais.getNome());
			ps.setString(3, pessoais.getDataNascimento());
			ps.setString(4, pessoais.getCpf());
			ps.setString(5, pessoais.getEmail());
			ps.setString(6, pessoais.getEndereco());
			ps.setString(7, pessoais.getMunicipio());
			ps.setString(8, pessoais.getUf());
			ps.setString(9, pessoais.getCelular());
			ps.setString(10, pessoais.getCurso());
			ps.setString(11, pessoais.getCampus());
			ps.setString(12, pessoais.getPeriodo());
			ps.executeUpdate() ;
		}
		catch(Exception e){
			throw new Exception("Erro ao salvar " + e.getMessage()) ;
		}
	} 
	
	public void alterar(Pessoais pessoais) throws Exception{
		
		try {
			String sql = "UPDATE PESSOAIS SET NOME = ?, DATA_NASCIMENTO = ?, CPF = ?, EMAIL = ?, ENDERECO = ?, MUNICIPIO = ?, "
					+ "UF = ?, CELULAR = ?, CURSO = ?, CAMPUS = ?, PERIODO = ?"
					+ " WHERE RGM = ?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,  pessoais.getNome());
			ps.setString(2, pessoais.getDataNascimento());
			ps.setString(3, pessoais.getCpf());
			ps.setString(4, pessoais.getEmail());
			ps.setString(5, pessoais.getEndereco());
			ps.setString(6, pessoais.getMunicipio());
			ps.setString(7, pessoais.getUf());
			ps.setString(8, pessoais.getCelular());
			ps.setString(9, pessoais.getCurso());
			ps.setString(10, pessoais.getCampus());
			ps.setString(11, pessoais.getPeriodo());
			ps.setInt(12, pessoais.getRgm());
			ps.executeUpdate() ;
		}
		catch(Exception e){
			throw new Exception("Erro ao alterar " + e.getMessage()) ;
		}
	}
	
	public void excluir(int rgm) throws Exception{
		
		try {			
			String sql = "DELETE FROM PESSOAIS WHERE RGM = ?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setInt(1, rgm);
			ps.executeUpdate() ;
			
			String sql1 = "DELETE FROM NOTAS_FALTAS WHERE RGM = ?" ;
			ps = conn.prepareStatement(sql1) ;
			ps.setInt(1, rgm);
			ps.executeUpdate() ;		
			
		}
		catch(Exception e) {
			throw new Exception("Erro ao excluir" + e.getMessage()) ;
		}
		
	}
	
	public Pessoais consultar (int rgm) throws Exception{
		try {
			ps = conn.prepareStatement("SELECT * FROM PESSOAIS WHERE RGM = ?") ;
			ps.setInt(1, rgm);
			rs = ps.executeQuery() ;
			if(rs.next()) {
				String nome = rs.getString("nome") ;
				String dataNascimento = rs.getString("data_nascimento") ;
				String cpf = rs.getString("cpf") ;
				String email = rs.getString("email") ;
				String endereco = rs.getString("endereco") ;
				String municipio = rs.getString("municipio") ;
				String uf = rs.getString("uf") ;
				String celular = rs.getString("celular") ;
				String curso = rs.getString("curso") ;
				String campus = rs.getString("campus") ;
				String periodo = rs.getString("periodo") ;
				pessoais = new Pessoais(rgm, nome, dataNascimento, cpf, email, endereco, municipio, uf, 
						celular, curso, campus, periodo);
			} 
			return pessoais;			
		}
		catch(Exception e) {
			throw new Exception("Erro ao listar" + e.getMessage()) ;
		}
	}
	
}


















