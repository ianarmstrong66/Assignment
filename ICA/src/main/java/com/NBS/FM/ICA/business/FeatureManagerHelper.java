package com.NBS.FM.ICA.business;
import java.sql.*;

public class FeatureManagerHelper {
	
	public FeatureManagerHelper() {}

	public void addFeatureRoleMatrix(Integer feature_id, Integer AppRole_id , Integer application_id, Boolean in_use_z) throws Exception{
		Connection conn = null;
		try {
			conn = DB2Util.getConnection();

			String sql = "{ call sp_update_fr_matrix(?,?,?,?) }";

			CallableStatement pstmt = conn.prepareCall(sql);

			pstmt.setInt(1, feature_id);
			pstmt.setInt(2, AppRole_id);
			pstmt.setInt(3, application_id);
			pstmt.setBoolean(4, in_use_z);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.println("Record inserted Successfully");
			}
			else {
				System.err.println("Error while adding the record");
			}

			pstmt.close();
			conn.close();

		}catch(SQLException ex) {
			DBUtil.showErrorMessage(ex);
		}
		finally {
			if(conn !=null)
				conn.close();
		}
	}

	public void addUserRoleMatrix(Integer user_id, Integer AppRole_id , Integer application_id, Boolean in_use_z) throws Exception{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();

			String sql = "{ call sp_update_ur_matrix(?,?,?,?) }";

			CallableStatement pstmt = conn.prepareCall(sql);

			pstmt.setInt(1, user_id);
			pstmt.setInt(2, AppRole_id);
			pstmt.setInt(3, application_id);
			pstmt.setBoolean(4, in_use_z);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.println("Record inserted Successfully");
			}
			else {
				System.err.println("Error while adding the record");
			}

			pstmt.close();
			conn.close();

		}catch(SQLException ex) {
			DBUtil.showErrorMessage(ex);
		}
		finally {
			if(conn !=null)
				conn.close();
		}
	}

	public void addApplication(String app_name, Boolean in_use_z) throws Exception {
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "{ call sp_update_feature(?,?) }";

			CallableStatement pstmt = conn.prepareCall(sql);
			pstmt.setString(1, app_name);
			pstmt.setBoolean(2, in_use_z);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.println("Record inserted Successfully");
			}
			else {
				System.err.println("Error while adding the record");
			}

			pstmt.close();
			conn.close();

		}catch(SQLException ex) {
			DBUtil.showErrorMessage(ex);
		}
		finally {
			if(conn !=null)
				conn.close();
		}
	}

	public void addRole(String function_v, String application_v, String rolename_v, Boolean in_use_z) throws Exception {
		Connection conn = null;
		ResultSet rs = null;

		try {
			int application_id, function_id;
			conn = DBUtil.getConnection();

			application_id = getAppID(application_v);

			String sqlApp = "Select ft_id from ferature where ft_name_v = '" + function_v +"'";
			PreparedStatement astmt = conn.prepareStatement(sqlApp);

			rs = astmt.executeQuery(sqlApp);
			rs.first();
			function_id = rs.getInt("ft_id");

			rs.close();
			astmt.close();

			String sql = "{ call sp_update_role(?,?,?,?) }";

			CallableStatement pstmt = conn.prepareCall(sql);

			pstmt.setInt(1,function_id);
			pstmt.setInt(2, application_id);
			pstmt.setString(3, rolename_v);
			pstmt.setBoolean(4, in_use_z);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.println("Record inserted Successfully");
			}
			else {
				System.err.println("Error while adding the record");
			}

			pstmt.close();
			conn.close();

		}catch(SQLException ex) {
			DBUtil.showErrorMessage(ex);
		}
		finally {
			if (rs != null)
				rs.close();
			if(conn !=null)
				conn.close();
		}
	}

	public void addUser(String function_v, String application_v, String forename_v, String surname_v, Boolean in_use_z) throws Exception {
		Connection conn = null;
		ResultSet rs = null;

		try {
			int application_id, function_id;
			conn = DBUtil.getConnection();

			application_id = getAppID(application_v);

			String sqlApp = "Select ft_id from ferature where ft_name_v = '" + function_v +"'";
			PreparedStatement astmt = conn.prepareStatement(sqlApp);

			rs = astmt.executeQuery(sqlApp);
			rs.first();
			function_id = rs.getInt("ft_id");

			rs.close();
			astmt.close();

			String sql = "{ call sp_update_feature(?,?,?,?,?) }";

			CallableStatement pstmt = conn.prepareCall(sql);

			pstmt.setInt(1,function_id);
			pstmt.setInt(2, application_id);
			pstmt.setString(3, forename_v);
			pstmt.setString(4, surname_v);
			pstmt.setBoolean(5, in_use_z);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.println("Record inserted Successfully");
			}
			else {
				System.err.println("Error while adding the record");
			}

			pstmt.close();
			conn.close();

		}catch(SQLException ex) {
			DBUtil.showErrorMessage(ex);
		}
		finally {
			if (rs != null)
				rs.close();
			if(conn !=null)
				conn.close();
		}
	}

	public void addFeature(String name_v, String toggle_name_v, String application_v, Boolean in_use_z) throws Exception {
		Connection conn = null;
//		ResultSet rs = null;

		try {
			int application_id;
			conn = DBUtil.getConnection();

			application_id = getAppID(application_v);

//			String sql = "Insert into feature values(null,?,?,?,?)";
//
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name_v);
//			pstmt.setString(2, toggle_name_v);
//			pstmt.setInt(3, application_id);
//			pstmt.setBoolean(4, in_use_z);
//
//			int result = pstmt.executeUpdate();

			String query = "{ call sp_update_feature(?,?,?,?) }";
			CallableStatement cstmt = conn.prepareCall(query);
			cstmt.setString(1, name_v);
			cstmt.setString(2, toggle_name_v);
			cstmt.setInt(3, application_id);
			cstmt.setBoolean(4, in_use_z);

			int result = cstmt.executeUpdate();
			if (result == 1) {
				System.out.println("Record inserted Successfully");
			}
			else {
				System.err.println("Error while adding the record");
			}
			cstmt.close();
			conn.close();

		}catch(SQLException ex) {
			DBUtil.showErrorMessage(ex);
		}
		finally {
//			if (rs != null)
//				rs.close();
			if(conn !=null)
				conn.close();
		}
	}

	private int getAppID (String application_v)  throws Exception {

		Connection conn = null;
		ResultSet rs = null;
		int application_id = 0;

		try {
			conn = DBUtil.getConnection();

			String sqlApp = "Select ap_id from application where app_name = '" + application_v + "'";
			PreparedStatement astmt = conn.prepareStatement(sqlApp);

			rs = astmt.executeQuery(sqlApp);
			rs.first();
			application_id = rs.getInt("ap_id");

			rs.close();
			astmt.close();
			conn.close();

		} catch (SQLException ex) {
			DBUtil.showErrorMessage(ex);
		} finally {
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
		}
		return application_id;
	}
}