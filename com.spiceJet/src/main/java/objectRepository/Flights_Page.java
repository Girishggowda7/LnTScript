package objectRepository;

import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flights_Page 
{

	WebDriver driver;
	@FindBy(xpath="//div[@id='list-results-section-0']/div[5]/div[1]/div/div[2]/div/div") private List<WebElement> fetchLowestPrice;
	String radioButtonXpath="//*[@id='list-results-section-0']/div[5]/div[1]/div/div[2]/div[%s]/div/div/div";
	@FindBy(xpath="//div[@data-testid='continue-search-page-cta']") private WebElement continueButton;
	@FindBy(xpath="//div[.='Signup']") private WebElement SignUpLink;
	public void clickSignUpLink()
	{
		SignUpLink.click();
	}

	public void clickContinueButton()
	{
		continueButton.click();
	}


	public WebElement stringToXpath(String xpath, int index)
	{
		String buttonxpath = String.format(xpath, index);
		System.out.println(buttonxpath);
		return driver.findElement(By.xpath(buttonxpath));
	}


	public Flights_Page(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void clickLowestPriceRadioButton()
	{
		List<WebElement> priceList = fetchLowestPrice;
		TreeSet<String> tr=new TreeSet<String>();
		int count = 0;

		for(WebElement price:priceList)
		{	

			String pr = price.getText();
			count++;
			tr.add(pr+"="+count);

		}

		String low = tr.last();
		String num = low.substring(low.indexOf("=")+1);
		System.out.println(num);
		Integer.parseInt(num);



		WebElement ele = stringToXpath(radioButtonXpath, Integer.parseInt(num));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();




	}
}
