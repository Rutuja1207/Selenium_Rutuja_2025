package com.ShoppersStack_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ShoppersStack_GenericUtility.Base_Test;
import com.ShoppersStack_POM.AddressForm_Page;
import com.ShoppersStack_POM.MyAddress_Page;
import com.ShoppersStack_POM.MyProfile_Page;

public class TC_001_verify_user_is_able_to_add_address_or_not_Test extends Base_Test{
	@Test
	
	public void addAddress() throws InterruptedException, EncryptedDocumentException, IOException{
		homePage.getAccountSettingsBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfile_Page myProfilePage=new MyProfile_Page(driver);
		myProfilePage.getMyAddressBtn().click();
		Thread.sleep(2000);
		MyAddress_Page myAddressPage=new MyAddress_Page(driver);
		myAddressPage.getAddAddressBtn().click();
		
		AddressForm_Page addAddressFormPage=new AddressForm_Page(driver);
		addAddressFormPage.getOfficeRadioBtn().click();
		addAddressFormPage.getNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 0));
		addAddressFormPage.getHouseTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
		addAddressFormPage.getStreetTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));
		addAddressFormPage.getLandmarkTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 3));
		
		webDriverUtility.selectByValue(addAddressFormPage.getCountryDropDown(), fileUtility.readDataFromPropertyFile("country"));
		webDriverUtility.selectByValue(addAddressFormPage.getStateDropDown(), fileUtility.readDataFromPropertyFile("state"));
		webDriverUtility.selectByValue(addAddressFormPage.getCityDropDown(), fileUtility.readDataFromPropertyFile("city"));
		
		addAddressFormPage.getPincodeTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
		addAddressFormPage.getPhoneNumberTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 5));
		addAddressFormPage.getAddAddressBtn().click();
		
		myAddressPage.getCloseBtn().click();
		webDriverUtility.getWebPageScreenShot(driver);
		
		
		
	}

}
