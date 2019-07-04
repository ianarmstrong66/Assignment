package com.NBS.FM.ICA.business;

import org.springframework.stereotype.Service;

@Service
public class FeatureManagerBusiness implements IFeatureManagerBusiness {

	public String getFeatureList(String AppId) throws Exception {
		
		GetFeatures getFeatures = new GetFeatures();
		return getFeatures.getfeatures(AppId);

	}
}