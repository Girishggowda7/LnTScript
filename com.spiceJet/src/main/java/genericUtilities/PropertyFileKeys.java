package genericUtilities;

public enum PropertyFileKeys 
{
	BROWSER("browser"), URL("url"), TIMEOUT("timeout");

	private String keys;
	private PropertyFileKeys(String keys)
	{
		this.keys=keys;	
	}

	public String convertToString()
	{
		return keys.toString();
	}
}
