package com.LocationSearchModule.AustralianPostCode_Service.operations;

import java.io.File;

import com.LocationSearchModule.AustralianPostCode_Service.AustralianPostCode;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetAustralianPostCodeByLocation extends AustralianPostCode{
    private boolean isFixed = false;
    public GetAustralianPostCodeByLocation() {
        File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/ausPostCodeSoap/getAustralianPostCodeByLocation/getAustralianPostCodeByLocation.xml").getPath());
        setRequestDocument(XMLTools.makeXMLDocument(xml));
        
        setOperationName("GetAustralianPostCodeByLocation");
        
        removeComments();
        removeWhiteSpace();
    }
    
    public void setLocation(String value) {
        setRequestNodeValueByXPath("/Envelope/Body/GetAustralianPostCodeByLocation/Location", value);
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
        String rawResponse = getResponseNodeValueByXPath("/Envelope/Body/GetAustralianPostCodeByLocationResponse/GetAustralianPostCodeByLocationResult");
        setResponseDocument(XMLTools.makeXMLDocument(rawResponse));
    }
}
