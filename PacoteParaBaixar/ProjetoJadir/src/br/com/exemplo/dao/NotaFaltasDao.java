/*Nome: Vinicius Silva de Oliveira
 * RGM: 20710356 
 * Turma: 3°B
 * Período: Noturno
 */

package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.NotaFaltas;
import br.com.exemplo.util.ConnectionFactory;

public class NotaFaltasDao {
	
	private NotaFaltas notaFaltas ;
	private Connection conn ;
	private PreparedStatement ps ;
	private ResultSet rs ;
	
	public NotaFaltasDao() throws Exception {// conectar com o banco de dados e caso de erro mostrar o erro
		try {
			conn = ConnectionFactory.getConnection() ;
		}
		catch(Exception e) {
			throw new Exception("Erro---> " + e.getMessage()) ;
		}
	}
	
	public void salvar(NotaFaltas notaFaltas) throws Exception{
		try {
			String sql = "INSERT INTO NOTAS_FALTAS(RGM, DISCIPLINA, SEMESTRE, NOTA, FALTAS)" 
		+ "VALUES(?, ?, ?, ?, ?)" ;
			ps = conn.prepareStatement(sql) ;
			ps.setInt(1, notaFaltas.getRgmNotas());
			ps.setString(2,  notaFaltas.getDisciplina());
			ps.setString(3, notaFaltas.getSemestre());
			ps.setString(4, notaFaltas.getNota());
			ps.setString(5, notaFaltas.getFaltas());
			ps.executeUpdate() ;
		}
		catch(Exception e) {
			throw new Exception("Erro ao salvar " + e.getMessage()) ;
		}
	}
	
	public void excluir(int rgmNotaFaltas, String disciplina) throws Exception{
		
		try {			
			String sql = "DELETE FROM NOTAS_FALTAS WHERE RGM = ? AND DISCIPLINA = ?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setInt(1, rgmNotaFaltas);
			ps.setString(2, disciplina);
			ps.executeUpdate() ;		
			
		}
		catch(Exception e) {
			throw new Exception("Erro ao excluir" + e.getMessage()) ;
		}
	}
	
	public void alterar(NotaFaltas notaFaltas) throws Exception{
		
		try {
			String sql = "UPDATE NOTAS_FALTAS SET SEMESTRE = ?, NOTA = ?, FALTAS = ?"
					+ " WHERE RGM = ? AND DISCIPLINA = ?" ;
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, notaFaltas.getSemestre());
			ps.setString(2, notaFaltas.getNota());
			ps.setString(3, notaFaltas.getFaltas());
			ps.setInt(4, notaFaltas.getRgmNotas());
			ps.setString(5,  notaFaltas.getDisciplina());
			ps.executeUpdate() ;
		}
		catch(Exception e){
			throw new Exception("Erro ao alterar " + e.getMessage()) ;
		}
	}
	
	public NotaFaltas consulta (int rgmNotaFaltas, String disciplina) throws Exception{
		try {			
			ps = conn.prepareStatement("SELECT * FROM NOTAS_FALTAS WHERE RGM = ? AND DISCIPLINA = ?") ;
			ps.setInt(1, rgmNotaFaltas);
			ps.setString(2, disciplina);
			rs = ps.executeQuery() ;
			if(rs.next()) {
				//String disciplina = rs.getString("disciplina") ;
				String semestre = rs.getString("semestre") ;
				String nota = rs.getString("nota") ;
				String faltas = rs.getString("faltas") ;
				notaFaltas = new NotaFaltas(rgmNotaFaltas, disciplina, semestre, nota, faltas) ;
			} 
			return notaFaltas;
		}
		catch(Exception e) {
			throw new Exception("Erro ao listar" + e.getMessage()) ;
		}
	}
	
	public List listarNotas(int rgm) throws Exception {
		List<NotaFaltas> lista = new ArrayList<NotaFaltas>();
		try {			
			ps = conn.prepareStatement("SELECT * FROM NOTAS_FALTAS WHERE RGM = ?");
			ps.setInt(1, rgm);
			rs = ps.executeQuery();
			while(rs.next()) {
				int rgm2 = rs.getInt("rgm");
				String disciplina = rs.getString("disciplina");
				String nota = rs.getString("nota");
				String faltas = rs.getString("faltas");	
				
				notaFaltas = new NotaFaltas(rgm, disciplina, nota, faltas);
				lista.add(notaFaltas);
			}
			return lista;
		}catch(Exception e) {
			throw new Exception("Erro ao listar "+ e.getMessage());
		}
	}
}












