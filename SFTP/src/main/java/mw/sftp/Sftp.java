package mw.sftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import mw.cfg.Config;

/**
 * Module responsible for basic SFTP operations
 * 
 * @author Milosz Wadas
 * @version 0.1
 * @since 2018-06-01
 *
 */
public class Sftp
{
	private String 
	
	
	private final String STATUS_OK = "OK";

	public Sftp()
	{

	}

	public String execute(String command, File f)
	{

		if (f == null)
			System.out.println("File not found");

		String PARAM_CMD_PUT = "PUT";
		String PARAM_HOSTNAME = "127.0.0.1";
		int PARAM_PORT = 22;
		String PARAM_USER = "abc";
		String PARAM_PASSWORD = "qqq";
		String PARAM_RESULT = "OK";

		JSch jsch = new JSch();

		Session session = prepareSession(PARAM_USER, PARAM_PASSWORD, PARAM_HOSTNAME, PARAM_PORT, jsch);

		if (PARAM_CMD_PUT.equals(command))
		{
			// String fileExt = FilenameUtils.getExtension(f.getName());
			// String fileName = f.getName()+"."+fileExt;

			sendFile(session, f.getName());// , PARAM_DIR);
		}
		else
		{
			throw new IllegalArgumentException();
		}

		return PARAM_RESULT;
	}

	private Session prepareSession(final String user, String pass, String host, int port, JSch jsch)
	{
		try
		{
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");

			Session s = jsch.getSession(user, host, port);
			s.setConfig(config);
			s.setPassword(pass);
			s.connect();

			return s;
		}
		catch (JSchException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	private ChannelSftp prepareConnection(final Session session) throws JSchException
	{
		if (session != null)
		{
			Channel channel = session.openChannel("sftp");
			channel.connect();

			ChannelSftp c = (ChannelSftp) channel;

			return c;
		}
		else
			throw new JSchException();

	}

	/**
	 * Uploads file to sftp
	 * 
	 * @param session
	 * @param filePath
	 * @return
	 */

	private String sendFile(final Session session, final String filePath)// , final String remotePath)
	{
		try
		{
			ChannelSftp c = prepareConnection(session);

			c.put(filePath, filePath);
		}
		catch (JSchException e)
		{
			e.printStackTrace();
		}
		catch (SftpException e)
		{
			e.printStackTrace();
		}

		return STATUS_OK;
	}

}
