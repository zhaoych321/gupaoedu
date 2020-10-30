package com.event.java.impl;

import com.event.java.Observer;

public class CCTVObserver implements Observer {

	@Override
	public void sendWeatherWarning() {
		System.out.println("中央电视台天气预报开始了！");
	}

}
