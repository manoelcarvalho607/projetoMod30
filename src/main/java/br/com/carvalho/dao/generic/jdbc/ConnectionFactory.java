/**
 * 
 */
package br.com.carvalho.dao.generic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author manoel.carvalho
 *
 */
public class ConnectionFactory {
	
private static Connection connection;
	
	private ConnectionFactory(Connection connection) {
		
	}
	
	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = initConnection();
			return connection;
		} else if (connection.isClosed()) {
			connection = initConnection();
			return connection;
		} else {
			return connection;
		}
	}
	
	private static Connection initConnection() {
		
		 /**
		  * methodo responsavel por estabelecer conexao com DB
		  * 
		  */
     
       String url = "jdbc:mysql://localhost:3306/db_projeto_vendas_2?characterEncoding=utf-8";
       String user = "root";
       String password = "123456";
       // Estabelecendo a conexao com DB
       try {
          
		//	Class.forName(driver);
			return  DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e); 
		 }
    }

}
