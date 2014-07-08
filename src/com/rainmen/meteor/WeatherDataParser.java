package com.rainmen.meteor;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
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
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is.get());
            doc.getDocumentElement().normalize();

            is.get().close();

            Element tmp = (Element) doc.getElementsByTagName("city").item(0);
            dataObject.name = tmp.getAttribute("name");

            tmp = (Element) tmp.getElementsByTagName("coord").item(0);
            dataObject.latitude = Double.parseDouble(tmp.getAttribute("lat"));
            dataObject.longitude = Double.parseDouble(tmp.getAttribute("lon"));


            Element t = (Element) doc.getElementsByTagName("direction").item(0);
            System.out.println(t.getAttribute("value"));

            //dataObject.country = tmp.getAttribute(name)

        }
        catch (Exception e) {
            System.out.println("Error while parsing: " + e.getMessage());
        }

        return dataObject;
    }

    private String getAttribute(String attr, String tag, Node node) {
        if (node.getNodeType() == Node.DOCUMENT_NODE) {
            Document doc = (Document) node;
        }
        else if (node.getNodeType() == Node.ELEMENT_NODE) {

        }


        return "";
    }
}
