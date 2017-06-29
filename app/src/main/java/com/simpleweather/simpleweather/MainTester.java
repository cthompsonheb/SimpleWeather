package com.simpleweather.simpleweather;

import json.WeatherEvent;

/**
 * @author Connor Thompson-Hebert
 */

public class MainTester {
    public static void main(String[] args) {
        WeatherEvent w = new WeatherEvent("Dallas", "TX");
        String condition = w.getCondition();
        String temp = w.getTemp();
        System.out.println(condition);
        System.out.println(temp);
    }
}
