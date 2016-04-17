package com.inportia.utils;

public class CommonResourceHandler {
   
	
	public static String getUploadTextFilePath()
	{
		return "src/test/java/com/inportia/utils/Resources/SampleUploadTextFile.txt";
	}
	
	public static String getRandomString(int size)
	{
		return Long.toHexString(Double.doubleToLongBits(Math.random()));	
	}
	
	
	
	
	
	
}
