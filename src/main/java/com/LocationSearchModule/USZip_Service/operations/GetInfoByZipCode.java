package com.LocationSearchModule.USZip_Service.operations;

import java.io.File;

import com.LocationSearchModule.USZip_Service.USZip;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetInfoByZipCode extends USZip{
	
	public GetInfoByZipCode() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/usZipSoap/getInfoByZIP/getInfoByZip.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		setOperationName("GetInfoByZIP");
		
		removeComments();
		removeWhiteSpace();
	
	
	}
	
	public void setZipCode(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/GetInfoByZIP/USZip", value);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/Envelope/Body/GetInfoByZIPResponse/GetInfoByZIPResult/NewDataSet/Table");	
	}
}
