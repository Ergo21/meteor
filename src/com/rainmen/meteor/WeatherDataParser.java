package com.rainmen.meteor;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
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
        if (!is.isPresent())
            return new WeatherData();

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is.get());
            doc.getDocumentElement().normalize();

            is.get().close();


            NodeList cityData = doc.getElementsByTagName("city");
            Element e = (Element) cityData.item(0);
            System.out.println(e.getAttribute("id") + " " + e.getAttribute("name"));
            Element e2 = (Element) e.getElementsByTagName("coord").item(0);

            System.out.println("Coord Lon : " + e2.getAttribute("lon"));
            System.out.println("Coord Lat : " + e2.getAttribute("lat"));

            /*for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("City id : "
                            + eElement.getAttribute("id"));
                    System.out.println("City name : "
                            + eElement.getAttribute("name"));

                    Element e = (Element) eElement.getElementsByTagName("coord").item(0);

                    System.out.println("Coord Lon : " + e.getAttribute("lon"));
                    System.out.println("Coord Lat : " + e.getAttribute("lat"));

                }
            }*/
        }
        catch (Exception e) {
            System.out.println("Error while parsing: " + e.getMessage());
        }

        return new WeatherData();
    }
}
