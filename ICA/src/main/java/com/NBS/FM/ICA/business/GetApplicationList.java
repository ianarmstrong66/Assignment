package com.NBS.FM.ICA.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;

public class GetApplicationList {

    public Dictionary<Integer, String> getList() throws Exception {

        Connection conn = null;
        ResultSet rs = null;
        int application_id = 0;
        String application_name = "";
        Dictionary<Integer, String> AppD = new Hashtable<Integer, String>();

        try {
            conn = DBUtil.getConnection();

            String sqlApp = "Select ap_id,app_name from application";
            PreparedStatement astmt = conn.prepareStatement(sqlApp);

            rs = astmt.executeQuery(sqlApp);
            while (rs.next()) {
                application_id = rs.getInt("ap_id");
                application_name = rs.getString("app_name");
                AppD.put(application_id,application_name);
            }
                rs.close();
                astmt.close();
                conn.close();

            } catch(SQLException ex){
                DBUtil.showErrorMessage(ex);
            } finally{
                if (rs != null)
                    rs.close();
                if (conn != null)
                    conn.close();
            }
            return AppD;
    }
}