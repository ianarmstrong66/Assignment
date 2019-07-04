package com.NBS.FM.ICA.business;

import java.util.Dictionary;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Dictionary;
//import java.util.Hashtable;
//import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ApplicationsBusiness implements IApplicationsBusiness{
	
	public Dictionary<Integer,String> getApplicationList() throws Exception {
		
		GetApplicationList getApplicationList = new GetApplicationList();
		return getApplicationList.getList();

	}
	
}