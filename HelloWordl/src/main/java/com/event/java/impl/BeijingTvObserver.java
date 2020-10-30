package com.event.java.impl;

import com.event.java.Observer;

public class BeijingTvObserver implements Observer {

	@Override
	public void sendWeatherWarning() {
		System.out.println("北京卫视天气预报开始！");
	}

}
