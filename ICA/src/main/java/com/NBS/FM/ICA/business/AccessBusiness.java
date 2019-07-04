package com.NBS.FM.ICA.business;

import org.springframework.stereotype.Service;

@Service
public class AccessBusiness implements IAccessBusiness {

	public boolean getAccess(String user, String access) throws Exception {
		GetAccessFlag GetAccessFlag = new GetAccessFlag();
		return GetAccessFlag.getAccess(user, access);
	}
} 