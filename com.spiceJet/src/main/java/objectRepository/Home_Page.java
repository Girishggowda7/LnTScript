package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.ExcelData;



public class Home_Page 
{
	WebDriver driver;
	@FindBy(xpath="//div[.='round trip']") private WebElement roundTripRadioButton;
	@FindBy(xpath="//div[.='From']/div[2]") private WebElement fromTextfield;
	@FindBy(xpath="//div[.='To']/div[1]") private WebElement toTextfield;
	@FindBy(xpath="//div[.='Departure Date']/..") private WebElement departureDateTextfield;
	@FindBy(xpath="//div[.='Return Date']/..") private WebElement returnDateTextfield;
	@FindBy(xpath="//div[.='Passengers']/../div[2]") private WebElement passengersDropDown;
	@FindBy(xpath="//div[.='Children']/../following-sibling::div/div[3]") private WebElement childrenAddbutton;
	@FindBy(xpath="//div[.='Welcome aboard.']/../../../div[.='Search Flight']/div[2]") private WebElement SearchFlightbutton;

	String fromXpath="//div[.='%s']";
	String toXpath="//div[.='%s']";
	String departureDateXpath="//div[@data-testid='undefined-month-%s']//div[.='%%s']";
	String returnDateXpath="//div[@data-testid='undefined-month-%s']//div[.='%%s']";
	String childrenXpath="//div[.='%s']/../following-sibling::div/div[3]";


	public WebElement stringToXpath(String xpath, String date)
	{
		String fromDateEleXp = String.format(xpath, date);
		return driver.findElement(By.xpath(fromDateEleXp));
	}


	
	public WebElement doubleStringToXpath(String xpath, String monthAndYear, String date)
	{
		String r1 = String.format(xpath, monthAndYear);
		String r2 = String.format(r1, date);
		return driver.findElement(By.xpath(r2));
	}



	public Home_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	
	public void clickroundTripRadioButton()
	{
		roundTripRadioButton.click();
	}


	
	public void enterDataIntoFromAndToTextField(String expectedTestCaseName, String sheet)
	{
		ExcelData excel = new ExcelData();

		String fromPlace="";
		String toPlace="";

		for(int i=0;i<excel.getLastRowNumOfExcel(sheet);i++)
		{
			String actualTestCaseName = excel.getaDataFromExcel(sheet, i, 1);
			System.out.println(actualTestCaseName);
			if(actualTestCaseName.equals(expectedTestCaseName))
			{
				for (int j = 0; j <excel.getLastCellNumOfExcel(sheet, 1); j++)
				{
					String data = excel.getaDataFromExcel(sheet, i, j);
					if(data.equals("From"))
					{
						fromPlace=excel.getaDataFromExcel(sheet, i+1, j);
					}
					if(data.equals("To"))
					{
						toPlace=excel.getaDataFromExcel(sheet, i+1, j);
					}
				}
			}
		}
		fromTextfield.click();
		stringToXpath(fromXpath, fromPlace).click();;
		
		stringToXpath(toXpath, toPlace).click();;
	}


	
	public void enterDepartureDate(String expectedTestCaseName, String sheet) 
	{	
		ExcelData excel = new ExcelData();
		String DepartureMonthYear="";
		String DepartureDay="";

		for(int i=0;i<excel.getLastRowNumOfExcel(sheet);i++)
		{
			String actualTestCaseName = excel.getaDataFromExcel(sheet, i, 1);
			if(actualTestCaseName.equals(expectedTestCaseName))
			{
				for (int j = 0; j <excel.getLastCellNumOfExcel(sheet, 1); j++)
				{
					String data = excel.getaDataFromExcel(sheet, i, j);
					if(data.equals("DepartureMonthYear"))
					{
						DepartureMonthYear=excel.getaDataFromExcel(sheet, i+1, j);
					}
					if(data.equals("DepartureDay"))
					{
						DepartureDay=excel.getaDataFromExcel(sheet, i+1, j);
					}
				}
			}
		}
		WebElement ele=doubleStringToXpath(departureDateXpath, DepartureMonthYear,DepartureDay);
		ele.click();
	}



	
	public void enterReturnDate(String expectedTestCaseName, String sheet)
	{
		ExcelData excel = new ExcelData();
		String ReturnMonthYear="";
		String ReturnDay="";

		for(int i=0;i<excel.getLastRowNumOfExcel(sheet);i++)
		{
			String actualTestCaseName = excel.getaDataFromExcel(sheet, i, 1);
			if(actualTestCaseName.equals(expectedTestCaseName))
			{
				for (int j = 0; j <excel.getLastCellNumOfExcel(sheet, 1); j++)
				{
					String data = excel.getaDataFromExcel(sheet, i, j);
					if(data.equals("ReturnMonthYear"))
					{
						ReturnMonthYear=excel.getaDataFromExcel(sheet, i+1, j);
					}
					if(data.equals("ReturnDay"))
					{
						ReturnDay=excel.getaDataFromExcel(sheet, i+1, j);
					}
				}
			}
		}
		WebElement ele = doubleStringToXpath(returnDateXpath, ReturnMonthYear,ReturnDay);
		ele.click();
	}



	
	public void clickAddButtonOfChildren(int numOfChildren)
	{
		passengersDropDown.click();

		for(int i=0;i<numOfChildren;i++)
		{
			childrenAddbutton.click();
		}
	}



	 public void clickSearchFlightButton()
	{
		SearchFlightbutton.click();
	}


	
	public void clickPassengersDropdown()
	{
		passengersDropDown.click();
	}




	
	public void addChildren(String expectedTestCaseName, String sheet)
	{

		ExcelData excel = new ExcelData();
		String NumberOfChildren="";
		for(int i=0;i<excel.getLastRowNumOfExcel(sheet);i++)
		{
			String actualTestCaseName = excel.getaDataFromExcel(sheet, i, 1);
			if(actualTestCaseName.equals(expectedTestCaseName))
			{
				for (int j = 0; j <excel.getLastCellNumOfExcel(sheet, 1); j++)
				{
					String data = excel.getaDataFromExcel(sheet, i, j);
					if(data.equals("NumberOfChildren"))
					{
						NumberOfChildren=excel.getaDataFromExcel(sheet, i+1, j);
					}

				}
			}
		}
		int num = Integer.parseInt(NumberOfChildren);

		for (int i = 0; i <num; i++) {
			stringToXpath(childrenXpath, "Children").click();
		}
	}


}
