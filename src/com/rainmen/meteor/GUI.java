package com.rainmen.meteor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import java.io.*;

/**
 * This is the main GUI window
 * for Meteor
 *
 * @author see AUTHORS file
 * @version 1.0
 *
 */
public class GUI extends JFrame {
	
	private WeatherData curWetDat;	//Current WeatherData
	
	public GUI() {
		setSize(800, 600);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		curWetDat = new WeatherData(0, 0, "Location not chosen");	//Blank data

	}

	public void setWeatherData(WeatherData nWD) {	//Set weather data
		curWetDat = nWD;
	}
	
	public void displayData() {	//Display data from current Weather Data
		
		
	}
}
