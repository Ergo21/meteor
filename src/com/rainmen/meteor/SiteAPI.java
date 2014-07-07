package com.rainmen.meteor;

/**
 * Contains everything needed to contact a website
 * for weather query
 *
 * @author see AUTHORS file
 * @version 1.0
 *
 */
public class SiteAPI {

    private WeatherDataParser parser = new WeatherDataParser();

    public WeatherData getWeatherDataByCity(String cityName) {
        String query = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&mode=xml";
        return parser.parseStream(NetworkAccess.getStreamFromQuery(query));
    }
}
