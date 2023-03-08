package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetry implements IRetryAnalyzer
{
	int count=2;
	int limit=0;

	@Override
	public boolean retry(ITestResult result) {

		if (limit<count)
		{
			limit++;
			return true;
		} else 
		{

		}


		return false;
	}


}
