package com.LocationSearchModule.UKLocation_Service.operations;

import java.io.File;

import com.LocationSearchModule.UKLocation_Service.UKLocation;
import com.orasi.utils.Constants;
import com.orasi.utils.XMLTools;

public class GetUKLocationByTown extends UKLocation{
    private boolean isFixed = false;
    public GetUKLocationByTown() {
        File xml = new File(this.getClass().getResource(Constants.XML_FILES + "/ukLocationSoap/getUKLocationByTown/getUKLocationByTown.xml").getPath());
        setRequestDocument(XMLTools.makeXMLDocument(xml));
        
        setOperationName("GetUKLocationByTown");
        
        removeComments();
        removeWhiteSpace();
    }
    
    public void setTown(String value) {
        setRequestNodeValueByXPath("/Envelope/Body/GetUKLocationByTown/Town", value);
    }
    
    public int getNumberOfResults() {
        if(!isFixed)
            fix();
        return getNumberOfResponseNodesByXPath("/NewDataSet/Table");
    }
    
    /*
     * This method takes the CDATA field from the ResponseDocument and transforms it into the new response document.
     */
    public void fix() {
        isFixed = true;
        String rawResponse = getResponseNodeValueByXPath("/Envelope/Body/GetUKLocationByTownResponse/GetUKLocationByTownResult");
        setResponseDocument(XMLTools.makeXMLDocument(rawResponse));
    }
}
