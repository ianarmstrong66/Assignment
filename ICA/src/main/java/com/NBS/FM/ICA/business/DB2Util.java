package com.NBS.FM.ICA.business;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB2Util {

	private static final String mySqlUser = "user_view_fm";
	private static final String mySqlPwd = "Alexandra";
	private static final String mySQLCS = "jdbc:mySQL://localhost:3306/functionfm?useLegacyDatetimeCode=false&serverTimezone=Europe/London&useSSL=false";

	public static Connection getConnection() throws Exception {
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("No Database found");
		}
		return DriverManager.getConnection(mySQLCS, mySqlUser, mySqlPwd);
	}

	public static void showErrorMessage(SQLException e) {
		System.err.println("Error : " + e.getMessage());
		System.err.println("Error : " + e.getErrorCode());
	}
}