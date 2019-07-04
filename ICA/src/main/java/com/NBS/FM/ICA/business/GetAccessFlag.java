package com.NBS.FM.ICA.business;

import java.sql.*;

public class GetAccessFlag{	

	public boolean getAccess(String user, String access) throws Exception {
	
	Connection conn = null;
	boolean outputFlag = false;
	
	try {
		conn = DBUtil.getConnection();
		CallableStatement cStmt = conn.prepareCall("{? = call ftdev01.checkMeOut(?,?)}");
		
		cStmt.registerOutParameter(1, java.sql.Types.BOOLEAN);
		cStmt.setString(2, user);
		cStmt.setString(3, access);
		cStmt.execute();
		outputFlag = cStmt.getBoolean(1);
		cStmt.close();
		conn.close();
		
	} catch(SQLException ex){
        DBUtil.showErrorMessage(ex);
    } finally{
        if (conn != null)
            conn.close();
    }
		return outputFlag;
	
	}
}