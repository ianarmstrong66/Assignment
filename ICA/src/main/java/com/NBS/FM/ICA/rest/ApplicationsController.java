package com.NBS.FM.ICA.rest;

import java.util.Dictionary;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.NBS.FM.business.ApplicationsBusiness;
//import com.NBS.FM.business.GetAccessFlag;
//import com.NBS.FM.business.IAccessBusiness;
import com.NBS.FM.ICA.business.IApplicationsBusiness;
import com.NBS.FM.ICA.constants.Constants;
//import com.NBS.FM.domain.Applications;
//import com.NBS.FM.persistence.ApplicationsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicationsController {

	@Autowired
	private IApplicationsBusiness applicationsBusiness;
	
	@RequestMapping(Constants.APPLICATIONS)
	public @ResponseBody Dictionary<Integer, String> getApplications() throws Exception {
		System.out.println("About to get List");
		return applicationsBusiness.getApplicationList();
	}	
}