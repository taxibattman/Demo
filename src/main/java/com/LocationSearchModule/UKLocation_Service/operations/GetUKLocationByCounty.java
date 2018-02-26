package com.LocationSearchModule.UKLocation_Service.operations;

import java.io.File;

import com.LocationSearchModule.UKLocation_Service.UKLocation;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetUKLocationByCounty extends UKLocation {
    private boolean isFixed = false;
    public GetUKLocationByCounty() {
        File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/ukLocationSoap/getUKLocationByCounty/getUKLocationByCounty.xml").getPath());
        setRequestDocument(XMLTools.makeXMLDocument(xml));
        
        setOperationName("GetUKLocationByCounty");
        
        removeComments();
        removeWhiteSpace();
    }
    
    public void setCounty(String value) {
        setRequestNodeValueByXPath("/Envelope/Body/GetUKLocationByCounty/County", value);
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
        String rawResponse = getResponseNodeValueByXPath("/Envelope/Body/GetUKLocationByCountyResponse/GetUKLocationByCountyResult");
        setResponseDocument(XMLTools.makeXMLDocument(rawResponse));
    }
}
