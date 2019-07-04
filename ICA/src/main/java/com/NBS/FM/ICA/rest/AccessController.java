package com.NBS.FM.ICA.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.NBS.FM.ICA.business.IAccessBusiness;
import com.NBS.FM.ICA.constants.Constants;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AccessController {

	@Autowired
	private IAccessBusiness AccessBusiness;
// TODO - Consider using a JWT and handling in the Path variable to make the http request more secure.	
	@RequestMapping(Constants.ACCESS)
	public @ResponseBody Boolean getAttr(@PathVariable(value="id") String userid, 
			@PathVariable(value="access") String access) throws Exception {
		System.out.println(userid +' '+ access);
		return AccessBusiness.getAccess(userid, access);
	}	
}