package com.orasi.api;

import org.testng.annotations.Test;

import com.LocationSearchModule.USZip_Service.operations.GetInfoByAreaCode;
import com.LocationSearchModule.USZip_Service.operations.GetInfoByState;
import com.orasi.utils.Constants;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
import com.webservicex.locationSearch.usZip.operations.GetInfoByCity;
import com.webservicex.locationSearch.usZip.operations.GetInfoByZip;

public class TestSoapService_USZip extends TestEnvironment{
	private String excelFileLocation = Constants.EXCEL_SHEETS + "/usZip";
	
	@Test
	public void getInfoByZip() {
		GetInfoByZip getInfo = new GetInfoByZip();
		getInfo.setZip("27410");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() != 0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation +"/GetInfoByZip/GetInfoByZipResponse.xls", "Main"), "Validate Response");
	}
	
	@Test
	public void getInfoByState() {
		GetInfoByState getInfo = new GetInfoByState();
		getInfo.setState("NC");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() != 0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation +"/GetInfoByState/GetInfoByStateResponse.xls", "Main"), "Validate Response");
	}
	
	@Test
	public void getInfoByCity() {
		GetInfoByCity getInfo = new GetInfoByCity();
		getInfo.setCity("Greensboro");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() != 0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation +"/GetInfoByCity/GetInfoByCityResponse.xls", "Main"), "Validate Response");
	}
	
	@Test
	public void getInfoByAreaCode() {
		GetInfoByAreaCode getInfo = new GetInfoByAreaCode();
		getInfo.setAreaCode("901");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() != 0, "Results were returned", getInfo);
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation +"/GetInfoByAreaCode/GetInfoByAreaCodeResponse.xls", "Main"), "Validate Response");
	}
}
