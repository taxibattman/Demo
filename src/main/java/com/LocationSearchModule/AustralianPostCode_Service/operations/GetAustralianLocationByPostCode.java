package com.LocationSearchModule.AustralianPostCode_Service.operations;

import java.io.File;

import com.LocationSearchModule.AustralianPostCode_Service.AustralianPostCode;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetAustralianLocationByPostCode extends AustralianPostCode{
    private boolean isFixed = false;
    public GetAustralianLocationByPostCode() {
        File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/ausPostCodeSoap/getAustralianLocationByPostCode/getAustralianLocationByPostCode.xml").getPath());
        setRequestDocument(XMLTools.makeXMLDocument(xml));
        
        setOperationName("GetAustralianLocationByPostCode");
        
        removeComments();
        removeWhiteSpace();
    }
    
    public void setPostCode(String value) {
        setRequestNodeValueByXPath("/Envelope/Body/GetAustralianLocationByPostCode/PostCode", value);
    }
    
    public int getNumberOfResults() {
        if(!isFixed)
            fix();
        //System.out.println(getNumberOfResponseNodesByXPath("/NewDataSet/Table"));
        return getNumberOfResponseNodesByXPath("/NewDataSet/Table");
    }
    
    /*
     * This method takes the CDATA field from the ResponseDocument and transforms it into the new response document.
     */
    public void fix() {
        isFixed = true;
        String rawResponse = getResponseNodeValueByXPath("/Envelope/Body/GetAustralianLocationByPostCodeResponse/GetAustralianLocationByPostCodeResult");
        setResponseDocument(XMLTools.makeXMLDocument(rawResponse));
    }
}
