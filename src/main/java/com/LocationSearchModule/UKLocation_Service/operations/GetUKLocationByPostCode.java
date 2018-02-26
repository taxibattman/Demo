package com.LocationSearchModule.UKLocation_Service.operations;

import java.io.File;

import com.LocationSearchModule.UKLocation_Service.UKLocation;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetUKLocationByPostCode extends UKLocation{
	private boolean isFixed = false;
	public GetUKLocationByPostCode() {
		File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/ukLocationSoap/getUKLocationByPostCode/getUKLocationByPostCode.xml").getPath());
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		
		setOperationName("GetUKLocationByPostCode");
		
		removeComments();
		removeWhiteSpace();
	
		
	}
	
	public void setPostCode(String value) {
		setRequestNodeValueByXPath("/Envelope/Body/GetUKLocationByPostCode/PostCode", value);
	}
	
	public int getNumberOfResults() {
		if(!isFixed)
			fixCData();
		return getNumberOfResponseNodesByXPath("/NewDataSet/Table");
	}
	
	public void fixCData() {
		isFixed = true;
		String raw = getResponseNodeValueByXPath("/Envelope/Body/GetUKLocationByPostCodeResponse/GetUKLocationByPostCodeResult");
		setResponseDocument(XMLTools.makeXMLDocument(raw));
	}
}
