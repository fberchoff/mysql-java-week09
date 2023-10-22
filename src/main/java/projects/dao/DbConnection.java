package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
	
	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	private static final String PASSWORD = "projects";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;

	public static Connection getConnection() {
		
		String uri = "jdbc:mysql://" + HOST + ":" + PORT + "/" + SCHEMA + "?user=" + USER + "&password=" + PASSWORD
				        + "&useSSL=false";
		
		System.out.println("Connecting with uri=" + uri);
		
		try {
			Connection conn = DriverManager.getConnection(uri);
			System.out.println("Succesfully obtained connection!");
			return conn;
		} catch (SQLException e) {
			throw new DbException("The connection failed!", e);
		}
	}

}
