package mw.cfg.test;

import java.io.File;
import org.junit.Test;

import mw.sftp.Sftp;

public class ConfigTest
{

	@Test
	public void testExample()
	{
		String PARAM_CMD = "PUT";
		
		File file = new File(".\\src\\test\\resources\\banan.txt");
		
		Sftp s = new Sftp();
		
		
		s.execute(PARAM_CMD, file);
	}

}
