package genericUtilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchTab 
{
	public SwitchTab(WebDriver driver)
	{
		String s = driver.getWindowHandle();
		Set<String> d = driver.getWindowHandles();
		d.remove(s);
		
		for (String string : d) {
			driver.switchTo().window(string);
		}
		
		
	}
}
