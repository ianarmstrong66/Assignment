package com.NBS.FM.ICA.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.NBS.FM.ICA.business.IFeatureManagerBusiness;
import com.NBS.FM.ICA.constants.Constants;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FeatureManagerController {

	@Autowired
	private IFeatureManagerBusiness featureManagerBusiness;
	
	@RequestMapping(value = Constants.FEATUREMANAGER)
	public @ResponseBody String getAttr(@PathVariable(value="appID") String AppId) throws Exception {
		System.out.println(AppId);
		return featureManagerBusiness.getFeatureList(AppId);
	}	
}