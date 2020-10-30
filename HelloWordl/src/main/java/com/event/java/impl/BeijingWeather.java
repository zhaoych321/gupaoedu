package com.event.java.impl;

import java.util.ArrayList;
import java.util.List;
import com.event.java.Observer;
import com.event.java.WeatherCenter;

public class BeijingWeather implements WeatherCenter {

	public List<Observer> observerArrayList = new ArrayList<Observer>();
	
	@Override
	public void publishWeatherInfo() {
		for (Observer observer : observerArrayList) {
			observer.sendWeatherWarning();
		}
	}
	
	public static void main(String[] args) {
		BeijingWeather weather = new BeijingWeather();
		weather.observerArrayList.add(new BeijingTvObserver());
		weather.observerArrayList.add(new CCTVObserver());
		
		weather.publishWeatherInfo();
	}
}
