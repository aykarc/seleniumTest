package com.maven.seleniumTest;

import java.util.Random;

public class HelperFactory {
	
	public int randomNumberGenerateFact(int maxNumber) {
		Random random = new Random();
		return random.nextInt(maxNumber);
	}
}
