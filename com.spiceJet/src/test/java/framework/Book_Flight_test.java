package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.SwitchTab;
import genericUtilities.WebDriverUtility;
import objectRepository.Flights_Page;
import objectRepository.Home_Page;
import objectRepository.SignUp_page;

public class Book_Flight_test 
{
	@Test(dataProvider = "getData")
	public void Book_flight(String sheetName)
	{
		WebDriverUtility webdrive = new WebDriverUtility();		
		
		WebDriver driver = webdrive.launchApplication("chrome", "https://www.spicejet.com/", 10);
		String testCaseName = "Book_Flight_test";
		String sheet = sheetName;
		Home_Page homePage = new Home_Page(driver);
		Flights_Page flightsPage = new Flights_Page(driver);
		SignUp_page sign = new SignUp_page(driver);

		homePage.clickroundTripRadioButton();
		homePage.enterDataIntoFromAndToTextField(testCaseName, "Sheet1");
		homePage.enterDepartureDate(testCaseName, sheet);
		homePage.enterReturnDate(testCaseName, sheet);
		homePage.clickPassengersDropdown();
		homePage.addChildren(testCaseName, sheet);
		homePage.clickPassengersDropdown();
		homePage.clickSearchFlightButton();
		flightsPage.clickContinueButton();
		flightsPage.clickSignUpLink();
		new SwitchTab(driver);
		sign.selectFromtitleDropdown();
		
	}
	
	@DataProvider
	String[] getData()
	{
		String[] sheetName= {"Sheet1","Sheet2","Sheet3","Sheet4"};
		return sheetName;
		
	}

}
