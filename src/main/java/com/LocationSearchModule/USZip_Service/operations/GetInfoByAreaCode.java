package com.LocationSearchModule.USZip_Service.operations;

import java.io.File;

import com.LocationSearchModule.USZip_Service.USZip;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetInfoByAreaCode extends USZip {
	public GetInfoByAreaCode() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/usZipSoap/getInfoByAreaCode/getInfoByAreaCode.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		setOperationName("GetInfoByAreaCode");
		
		removeComments();
		removeWhiteSpace();
	
	
	}
	
	public void setAreaCode(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/GetInfoByAreaCode/USAreaCode", value);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/Envelope/Body/GetInfoByAreaCodeResponse/GetInfoByAreaCodeResult/NewDataSet/Table");	
	}
}
