package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Login;

public class LoginDao {

	public static String getLogar(Login login) throws SQLException {
		
		String retorno = null;
		
		Conexao conecta = new Conexao();
		Connection conn = conecta.conecta();
		
		try {

			PreparedStatement sql = conn
					.prepareStatement("SELECT 1 FROM DBO.LOGIN WHERE USUARIO = ? AND SENHA = ? ");

			sql.setString(1, login.getUsuario());
			sql.setString(2, login.getSenha());
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()){
				retorno = "sucesso";
			}else {
			//	addActionError(getText("error.login"));
				retorno = "erro";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			conn.close();
		}
		
		return retorno;
		
	}

	public static void getLogar(String usuario, String senha) {
		// TODO Auto-generated method stub
		
	}

}
