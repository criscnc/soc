package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import classes.Exame;

public class ExameDao {

	public static String adicionarExame(Exame exame) throws SQLException {
		
		String retorno = null;
		
		Conexao conecta = new Conexao();
		Connection conn = conecta.conecta();
		
		try {
			PreparedStatement sql = conn
					.prepareStatement("SELECT 1 FROM DBO.EXAME WHERE NOMEPACIENTE = ? ");

			sql.setString(1, exame.getNomePaciente());
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()){
				//addActionError(getText("error.paciente"));
				retorno = "erro";
			}else {
				
				PreparedStatement sqlAdd = conn
						.prepareStatement(" INSERT INTO DBO.EXAME (NOMEPACIENTE, NOMEEXAME, DTEXAME, OBS) VALUES (?,?,?,?) ");

				sqlAdd.setString(1, exame.getNomePaciente());
				sqlAdd.setString(2, exame.getNomeExame());
				sqlAdd.setString(3, exame.getDtExame());
				sqlAdd.setString(4, exame.getObs());
				sqlAdd.executeUpdate();
				
				retorno = "sucesso";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			conn.close();
		}		
		
		return retorno;
		
	}
	
	
	public static Exame buscarExame(Exame exame) throws SQLException {
		
		Conexao conecta = new Conexao();
		Connection conn = conecta.conecta();
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			String query = " SELECT NOMEPACIENTE, NOMEEXAME, DTEXAME, OBS FROM DBO.EXAME WHERE 1=1 ";
			
			if(!exame.getNomePaciente().isEmpty()) {
				query += " AND NOMEPACIENTE = '" + exame.getNomePaciente() +"'";
			}
			if(!exame.getNomeExame().isEmpty()) {
				query += " AND NOMEEXAME = '" + exame.getNomeExame() +"'";
			}
			if(!exame.getDtExame().isEmpty()) {
				query += " AND DTEXAME = '" + exame.getDtExame() +"'";
			}
			if(!exame.getObs().isEmpty()) {
				query += " AND OBS = '" + exame.getObs() +"'";
			}
			
			PreparedStatement sql = conn.prepareStatement(query);
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()){
				
				Date data = rs.getDate("DTEXAME"); 
				String dtExame = formatador.format(data);
				
				exame.setNomePaciente(rs.getString("NOMEPACIENTE"));
				exame.setNomeExame(rs.getString("NOMEEXAME"));
				exame.setDtExame(dtExame);
				exame.setObs(rs.getString("OBS"));
				exame.setRetorno("busca");
				
			}else {
				//addActionError(getText("error.buscar"));
				exame.setRetorno("erro");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			conn.close();
		}
		
		return exame;
	}
	
	
	public static String alterarExame(Exame exame) throws SQLException {
		
		String retorno = null;
		
		Conexao conecta = new Conexao();
		Connection conn = conecta.conecta();
		
		try {
			PreparedStatement sql = conn
					.prepareStatement("SELECT 1 FROM DBO.EXAME WHERE NOMEPACIENTE = ? ");

			sql.setString(1, exame.getNomePaciente());
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()){
				
				PreparedStatement sqlUp = conn
						.prepareStatement(" UPDATE DBO.EXAME SET NOMEEXAME = ?, DTEXAME = ?, OBS = ? WHERE NOMEPACIENTE = ? ");

				sqlUp.setString(1, exame.getNomeExame());
				sqlUp.setString(2, exame.getDtExame());
				sqlUp.setString(3, exame.getObs());
				sqlUp.setString(4, exame.getNomePaciente());
				sqlUp.executeUpdate();
				
				retorno = "alterado";
				
			}else {
				adicionarExame(exame);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			conn.close();
		}
		
		return retorno;
	}
	
	public static String excluirExame(Exame exame) throws SQLException {
		
		String retorno = null;
		
		Conexao conecta = new Conexao();
		Connection conn = conecta.conecta();
		
		try {
			
			if(exame.getNomePaciente().isEmpty()) {
				retorno = "erro";
			}else {
				PreparedStatement sql = conn
						.prepareStatement("DELETE FROM DBO.EXAME WHERE NOMEPACIENTE = ? ");
	
				sql.setString(1, exame.getNomePaciente());
				sql.executeQuery();
				
				retorno = "excluido";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			conn.close();
		}
		
		return retorno;
		
	}
	
	public static Exame listarExames() throws SQLException {
		
		Conexao conecta = new Conexao();
		Connection conn = conecta.conecta();
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Exame> exames = new ArrayList<Exame>(); 
		Exame exame = new Exame();
		
		try {
			
			String query = " SELECT NOMEPACIENTE, NOMEEXAME, DTEXAME, OBS FROM DBO.EXAME ORDER BY DTEXAME, NOMEPACIENTE ";
			PreparedStatement sql = conn.prepareStatement(query);
			ResultSet rs = sql.executeQuery();
			
			while(rs.next()){
				
				exame = new Exame();
				
				Date data = rs.getDate("DTEXAME"); 
				String dtExame = formatador.format(data);
				
				exame.setNomePaciente(rs.getString("NOMEPACIENTE"));
				exame.setNomeExame(rs.getString("NOMEEXAME"));
				exame.setDtExame(dtExame);
				exame.setObs(rs.getString("OBS"));

				exames.add(exame);
			}

			exame.setListarExames(exames);
			exame.setRetorno("listar");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			conn.close();
		}
		
		return exame;	
	}

}
