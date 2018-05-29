package mw.cfg;

import java.util.Properties;

public class Config
{
	private Properties p;
	
	public Properties getConfig()
	{
		p.setProperty("hostname", "127.0.0.1");
		p.setProperty("port", "22");
		p.setProperty("user", "abc");
		p.setProperty("password", "qqq");
		
		return p;
	}
}
