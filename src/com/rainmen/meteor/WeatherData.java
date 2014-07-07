package com.rainmen.meteor;

/**
 * Contains properly formatted info about weather
 *
 * @author see AUTHORS file
 * @version 1.0
 *
 */
public class WeatherData {
	public int longitude;
	public int latitude;
	public String country = "NONE";
	public double sunrise = -1;	//-1 = not set
	public double sunset  = -1;	//-1 = not set
	public String description;
	public double temperature;
	public int humidity;
	public int pressure;
	public double minTemp;
	public double maxTemp;
	public double windSpeed = -1;	//-1 = not set
	public double windDirection = -1; //-1 = not set
	public double cloudPercent = -1;  //-1 = not set
	public String name = "None";

	public WeatherData(int log, int lat, String desc) { //Required data, all others optional
		longitude = log;
		latitude  = lat;
		description = desc;
	}

}
