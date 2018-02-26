package com.orasi.api;

import org.testng.annotations.Test;

import com.LocationSearchModule.AustralianPostCode_Service.operations.GetAustralianLocationByPostCode;
import com.LocationSearchModule.AustralianPostCode_Service.operations.GetAustralianPostCodeByLocation;
import com.orasi.utils.Constants;
import com.orasi.utils.TestReporter;

public class TestSoapService_AustralianPostCode {
private String excelFileLocation = Constants.EXCEL_SHEETS + "/ausPostCode";
	
	@Test
	public void getAustralianLocationByPostCode() {
		//TestReporter.setDebugLevel(3);
		GetAustralianLocationByPostCode getInfo = new GetAustralianLocationByPostCode();
		getInfo.setPostCode("1");
		getInfo.sendRequest();
		System.out.println(getInfo.getNumberOfResults());
		TestReporter.logAPI(getInfo.getNumberOfResults() != 0, "Results were returned", getInfo);
		//boolean validate = getInfo.validateResponse(excelFileLocation +"/GetUKLocationByCounty/GetUKLocationByCounty.csv", "Main");
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetAustralianLocationByPostCode/GetAustralianLocationByPostCode.csv", "Main"), "Validate Response");
	}
	
	@Test
	public void getAustralianPostCodeByLocation() {
		//TestReporter.setDebugLevel(3);
		GetAustralianPostCodeByLocation getInfo = new GetAustralianPostCodeByLocation();
		getInfo.setLocation("Melbourne");
		getInfo.sendRequest();
		System.out.println(getInfo.getNumberOfResults());
		TestReporter.logAPI(getInfo.getNumberOfResults() != 0, "Results were returned", getInfo);
		//boolean validate = getInfo.validateResponse(excelFileLocation +"/GetUKLocationByCounty/GetUKLocationByCounty.csv", "Main");
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetAustralianPostCodeByLocation/GetAustralianPostCodeByLocation.csv", "Main"), "Validate Response");
	}
}
