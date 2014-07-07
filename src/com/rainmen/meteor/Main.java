package com.rainmen.meteor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * This is the entry point to Meteor
 *
 * @author see AUTHORS file
 * @version 1.0
 *
 */
public class Main {

    public static void main(String[] args) {

        new SiteAPI().getWeatherDataByCity("Paris");
    }
}
