package com.cf.utils;


import java.util.Random;

public class RandomUtils {

	//获取随机长度字母数字组合
	public static String getRandomLetterAndNum(int len) {
		String result = "";
		Random random = new Random();
		for(int i = 0; i <= len; i++) {
			boolean b = random.nextBoolean();
			if(b) {
				result += (char)(65 + random.nextInt(26));
			}
			else {
				result += String.valueOf(random.nextInt(10));
			}
			
		}
		return result;
	}
}
