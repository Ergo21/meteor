package com.rainmen.meteor;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
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
    
    private Document doc;

    public WeatherData parseStream(Optional<InputStream> is) {
        WeatherData dataObject = new WeatherData(0, 0, "");

        if (!is.isPresent())
            return dataObject;

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(is.get());
            doc.getDocumentElement().normalize();

            is.get().close();

            dataObject.name = getAttribute("name", "city");
            dataObject.country = getTagData("country");
            dataObject.humidity = Integer.parseInt(getAttribute("value", "humidity"));
            dataObject.pressure = Integer.parseInt(getAttribute("value", "pressure"));
            dataObject.windSpeed = Double.parseDouble(getAttribute("value", "speed"));
            
            dataObject.temperature = Double.parseDouble(getAttribute("value", "temperature"));
            
            
            dataObject.latitude = Double.parseDouble(getAttribute("lat", "coord"));
            dataObject.longitude = Double.parseDouble(getAttribute("lon", "coord"));
        }
        catch (Exception e) {
            System.out.println("Error while parsing: " + e.getMessage());
        }

        return dataObject;
    }

    private String getAttribute(String attr, String tag) {
        // we can namespace if there are two same tags
        // care no bounds checking
        Element e = (Element) doc.getElementsByTagName(tag).item(0);
        return e.getAttribute(attr);
    }
    
    private String getTagData(String tag) {
        // no bounds checking
        return doc.getElementsByTagName(tag).item(0).getTextContent();
    }
}
