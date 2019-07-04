package com.NBS.FM.ICA.business;

import java.sql.SQLException;

public class GetFeatures  {

    public String getfeatures(String AppId) throws Exception{
    	
    	String appQuery = AppId.replace(";","").replace("=", "").replace("\"", " ").replace("\'", " ");
        System.out.println("Convert: " +appQuery);
        String FeatureList;
        try {

            String sqlQuery = "select distinct(t1.ft_id) as featureID, t1.ft_name_v as featureName, " +
            				"t1.ft_toggle_name_v as toggleName, ifnull(t1.ap_id,0) as appID, t1.in_use_z as enabled " + 
            				"from feature t1 left join app_feature_roles_matrix t2 on t1.ft_id = t2.ft_id " + 
            				"where t1.ap_id = " + appQuery + ";";
            
            FeatureList = DBUtil.getQueryResults(sqlQuery);          

            return FeatureList;

        } catch(SQLException ex){
        	DBUtil.showErrorMessage(ex);
        } 
        
        return null;
    }
}