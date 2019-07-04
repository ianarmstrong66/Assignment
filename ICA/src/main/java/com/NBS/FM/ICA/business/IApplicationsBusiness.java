package com.NBS.FM.ICA.business;

import java.util.Dictionary;

public interface IApplicationsBusiness {

	Dictionary< Integer, String> getApplicationList() throws Exception;
}