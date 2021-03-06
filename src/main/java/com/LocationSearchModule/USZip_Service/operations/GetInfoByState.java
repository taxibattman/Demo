package com.LocationSearchModule.USZip_Service.operations;

import java.io.File;

import com.LocationSearchModule.USZip_Service.USZip;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetInfoByState extends USZip{
	public GetInfoByState() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/usZipSoap/getInfoByState/getInfoByState.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		setOperationName("GetInfoByState");
		
		removeComments();
		removeWhiteSpace();
	
	
	}
	
	public void setState(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/GetInfoByState/USState", value);
	}
	
	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/Envelope/Body/GetInfoByStateResponse/GetInfoByStateResult/NewDataSet/Table");	
	}
}
