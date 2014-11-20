package br.com.matheuscs.votenolivro.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

	protected static Connection criaConexao() throws URISyntaxException, SQLException {
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}

	protected void fechaConexao(Connection conexao, Statement stmt) {
		try {
			if(stmt!=null) {
				stmt.close();
			}
			if(conexao!=null) {
				conexao.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro SQL");
			e.printStackTrace();			
		}
	}
	
	protected void fechaConexao(Connection conexao, PreparedStatement prestat, ResultSet... rs) {
		try {
			if(rs[0]!=null) {
				rs[0].close();
			}
			if(rs.length == 2 && rs[1]!=null) {
				rs[1].close();
			}
			if(prestat!=null) {
				prestat.close();
			}
			if(conexao!=null) {
				conexao.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro SQL");
			e.printStackTrace();			
		}
	}

	protected void fechaConexao(Connection conexao, PreparedStatement prestat1,
			PreparedStatement prestat2, ResultSet... rs) {
		try {
			if(rs[0]!=null) {
				rs[0].close();
			}
			if(rs[1]!=null) {
				rs[1].close();
			}
			if(prestat1!=null) {
				prestat1.close();
			}
			if(prestat2!=null) {
				prestat2.close();
			}
			if(conexao!=null) {
				conexao.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro SQL");
			e.printStackTrace();			
		}
	}
}