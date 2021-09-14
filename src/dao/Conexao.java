package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	protected Connection conn;
	protected String mensagem;

	public Connection conecta() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		} catch (Exception ex) {
			mensagem = "Erro 0001 - 'Conexão': Driver não carregado!";
			System.out.println("erro:" + mensagem);
		}

		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Exames_SOC",
					"sa", "123456");
		} catch (SQLException ex) {
			ex.printStackTrace();
			mensagem = "erro 0002 - 'Conexão':" + ex.getMessage();
			System.out.println("erro 0002 - 'Conexão':" + mensagem);
		}
		return conn;
	}

}
