package genericUtilities;

public class JavaUtility 
{
	public int timeout()
	{
		PropertyFileData pro = new PropertyFileData();
		String tim = null;
		tim = pro.getProperty(PropertyFileKeys.TIMEOUT.convertToString());
		return Integer.parseInt(tim);
		
	}
}
