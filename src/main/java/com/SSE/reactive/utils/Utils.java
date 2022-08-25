package com.SSE.reactive.utils;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

@Component
public class Utils {


	public String getRandomDoubleBetweenRange(double min, double max) {
			String pattern = "###,###.##";
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			String format = decimalFormat.format((Math.random() * ((max - min) + 1)) + min);
			return format;
		}
	
	
	
}
