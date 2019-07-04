package com.NBS.FM.ICA.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import com.google.gson.Gson;

public class DBUtil {

	private static final String mySqlUser = "user_update_fm";
	private static final String mySqlPwd = "fam1lIarFac35";
	private static final String mySQLCS = "jdbc:mySQL://localhost:3306/ftdev01?useLegacyDatetimeCode=false&serverTimezone=Europe/London&useSSL=false";

	public static String getQueryResults(String query) throws Exception {
		Connection conn = null;
        List<Map<String, Object>> listOfMaps = null;
        
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(mySQLCS, mySqlUser, mySqlPwd);
			
		} catch (ClassNotFoundException e) {
			throw new Exception("No Database found");
		}
		try {
            QueryRunner queryRunner = new QueryRunner();
            listOfMaps = queryRunner.query(conn, query, new MapListHandler());
        } catch (SQLException se) {
            throw new RuntimeException("Couldn't query the database.", se);
        } finally {
            DBUtil.closeQuietly(conn);
        }
        return new Gson().toJson(listOfMaps);
	}

	private static void closeQuietly(Connection conn) {
		// TODO Auto-generated method stub
		
	}

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