package com.rainmen.meteor;

/**
 * This is the entry point to Meteor
 *
 * @author see AUTHORS file
 * @version 1.0
 *
 */
public class Main {

    public static void main(String[] args) {
        WeatherData data = new SiteAPI().getWeatherDataByCity("Paris");
        System.out.println(data.latitude + " " + data.longitude + " " + data.name);
    }
}
