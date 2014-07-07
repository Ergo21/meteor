package com.rainmen.meteor;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.io.InputStream;
import java.util.Optional;

/**
 * Parses data from website into a {@code WeatherData} object
 *
 * @author see AUTHORS file
 * @version 1.0
 *
 */
public class WeatherDataParser {

    public WeatherData parseStream(Optional<InputStream> is) {
        WeatherData dataObject = new WeatherData(0, 0, "");
        
        if (!is.isPresent())
            return dataObject;

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is.get());
            doc.getDocumentElement().normalize();

            is.get().close();


            NodeList cityData = doc.getElementsByTagName("city");
            Element tmpElem = (Element) cityData.item(0);
            dataObject.name = tmpElem.getAttribute("name");
            
            Element tmpElem2 = (Element) tmpElem.getElementsByTagName("coord").item(0);
            dataObject.latitude = Double.parseDouble(tmpElem2.getAttribute("lat"));
            dataObject.longitude = Double.parseDouble(tmpElem2.getAttribute("lon"));

        }
        catch (Exception e) {
            System.out.println("Error while parsing: " + e.getMessage());
        }

        return dataObject;
    }
}
