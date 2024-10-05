package bai3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public DBConnection() {
		super();
	}

	public static Connection getConnection() {
		Connection connection = null;
		String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=UploadFileServletDB;encrypt=false;";
		String jdbcUsername = "sa";
		String jdbcPassword = "sapassword";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}