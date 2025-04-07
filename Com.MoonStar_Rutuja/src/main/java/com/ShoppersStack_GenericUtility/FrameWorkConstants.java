package com.ShoppersStack_GenericUtility;

public interface FrameWorkConstants {
	Java_Utility javaUtility=new Java_Utility();
	
	final static String propertyFilePath = "./src/test/resources/testData/shopperProperty.properties";
	
	final static String excelFilePath = "./src/test/resources/testData/ShopperExcel.xlsx";
	
	final static String ScreenshotPath = "./Screenshots/"+javaUtility.getLocalDateAndTime()+".png";
	
	final static String reportsPath = "./Reports/"+javaUtility.getLocalDateAndTime()+".html";
	
	final static String chromekey="webdriver.chrome.driver";
	final static String chromeValue="./src/main/resources/SeDriver/chromedriver.exe";

}
