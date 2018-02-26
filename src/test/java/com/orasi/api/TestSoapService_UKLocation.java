package com.orasi.api;

import org.testng.annotations.Test;

import com.LocationSearchModule.UKLocation_Service.operations.GetUKLocationByCounty;
import com.LocationSearchModule.UKLocation_Service.operations.GetUKLocationByPostCode;
import com.LocationSearchModule.UKLocation_Service.operations.GetUKLocationByTown;
import com.orasi.utils.Constants;
import com.orasi.utils.TestReporter;

public class TestSoapService_UKLocation {
	
	private String excelFileLocation = Constants.EXCEL_SHEETS + "/UkLocation";
	
	@Test
	public void getUKLocationByCounty() {
		TestReporter.setDebugLevel(3);
		GetUKLocationByCounty getInfo = new GetUKLocationByCounty();
		getInfo.setCounty("Surrey");
		getInfo.sendRequest();
		TestReporter.logAPI(getInfo.getNumberOfResults() != 0, "Results were returned", getInfo);
		//boolean validate = getInfo.validateResponse(excelFileLocation +"/GetUKLocationByCounty/GetUKLocationByCounty.csv", "Main");
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetUKLocationByCounty/GetUKLocationByCounty.csv", "Main"), "Validate Response");
	}
	
	@Test
	public void getUKLocationByTown() {
		TestReporter.setDebugLevel(3);
		GetUKLocationByTown getInfo = new GetUKLocationByTown();
		getInfo.setTown("Little London");
		getInfo.sendRequest();
		//System.out.println(getInfo.getNumberOfResults());
		TestReporter.logAPI(getInfo.getNumberOfResults() != 0, "Results were returned", getInfo);
		//boolean validate = getInfo.validateResponse(excelFileLocation +"/GetUKLocationByCounty/GetUKLocationByCounty.csv", "Main");
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetUKLocationByTown/GetUKLocationByTown.csv", "Main"), "Validate Response");
	}
	
	@Test
	public void getUKLocationByPostCode() {
		TestReporter.setDebugLevel(3);
		GetUKLocationByPostCode getInfo = new GetUKLocationByPostCode();
		getInfo.setPostCode("IM6");
		getInfo.sendRequest();
		System.out.println(getInfo.getNumberOfResults());
		TestReporter.logAPI(getInfo.getNumberOfResults() != 0, "Results were returned", getInfo);
		//boolean validate = getInfo.validateResponse(excelFileLocation +"/GetUKLocationByCounty/GetUKLocationByCounty.csv", "Main");
		TestReporter.assertTrue(getInfo.validateResponse(excelFileLocation + "/GetUKLocationByPostCode/GetUKLocationByPostCode.csv", "Main"), "Validate Response");
	}
}
