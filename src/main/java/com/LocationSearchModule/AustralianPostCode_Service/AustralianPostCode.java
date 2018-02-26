package com.LocationSearchModule.AustralianPostCode_Service;

import com.orasi.api.soapServices.SoapService;

public class AustralianPostCode extends SoapService {
	public AustralianPostCode() {
		setServiceName("AustralianPostCodeService");
		setServiceURL("http://www.webservicex.net/australianpostcode.asmx?wsdl");
	}
}
