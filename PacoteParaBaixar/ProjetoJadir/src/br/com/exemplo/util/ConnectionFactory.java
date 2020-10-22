/*Nome: Vinicius Silva de Oliveira
 * RGM: 20710356 
 * Turma: 3°B
 * Período: Noturno
 */

package br.com.exemplo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception {
		// metodo getConnection ---> nao ira tratar erros nesse metodo
		try {
			// indica o db mysql e aponta para o driver 
			Class.forName("com.mysql.jdbc.Driver") ;
			String login = "root" ;
			String senha = "" ;
			String url = "jdbc:mysql://localhost:3306/projeto_jadir" ;
			return DriverManager.getConnection(url, login, senha) ;
		}
		catch(Exception e) {
			throw new Exception(e.getMessage()) ;			
		}
		
	}
	
//	 metodo main criado apenas para testar a conexão com o banco de dados 
//		public static void main(String[] args) {
//			try {
//				Connection conn = ConnectionFactory.getConnection() ;
//				JOptionPane.showMessageDialog(null, "Conectado ao banco");
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//		}

}
