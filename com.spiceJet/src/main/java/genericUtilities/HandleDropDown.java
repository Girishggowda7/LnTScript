package genericUtilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown 
{

	public void selectByVisibleText(WebElement ele, String tex)
	{
		Select sel = new Select(ele);
		sel.selectByVisibleText(tex);
	}
}
