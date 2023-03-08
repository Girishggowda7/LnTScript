package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.HandleDropDown;

public class SignUp_page 
{
	@FindBy(xpath="//select[@class=\"form-control form-select \"]") private WebElement titleDropdown;
	
	public SignUp_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectFromtitleDropdown()
	{
		new HandleDropDown().selectByVisibleText(titleDropdown, "Mr");
	}
	
}
