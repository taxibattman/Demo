package com.orasi.api;

import org.testng.annotations.Test;

import com.orasi.utils.Constants;
import com.orasi.utils.TestEnvironment;
import com.orasi.utils.TestReporter;
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
}
