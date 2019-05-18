/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.utilities;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Jason.Zhuang
 * Apr 24, 2019
 * StaticUtils.java
 * Describe:
 */
public class StaticUtils
{
	private final static Logger log =  LogManager.getLogger(StaticUtils.class);

	private static ApplicationContext context;

	private static String buildPath = "";

	private static String projectPath = "";

	static
	{
		String classPath = System.getProperty("java.class.path");
		String arrCurrentRunPath[] = classPath.split(";");
		buildPath = arrCurrentRunPath[0];
		projectPath = System.getProperty("user.dir");
	}
	
	public static void initApplicationContext()
	{
		log.info("Initializing system =========");
		context = new ClassPathXmlApplicationContext("conf/spring.xml");
		log.info("Initializing system completed.");
	}

	public static ApplicationContext getContext()
	{
		return context;
	}

	public static String getBuildPath()
	{
		return buildPath;
	}

	public static String getProjectPath()
	{
		return projectPath;
	}

	public static String getConfigFileName()
	{
        String file = "";
        try 
        {
        	file = buildPath + "\\conf\\spring.xml";
        	System.out.println("File path:"+file);
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
	}

	public static List<String> readFile(BufferedReader br)
	{
		List<String> lines = new ArrayList<String>();
		try
		{
			for (String line = br.readLine(); line != null; line = br.readLine())
			{
				lines.add(line);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return lines;
	}

	/**
	 * calculate the number of Months between argument and current Date
	 * @param inceptionDate
	 * @return
	 */
	public static int calculateMonths(Date inceptionDate)
	{

		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.MONTH, -1);
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(inceptionDate);

		int count = 0;
		while (!(c2.get(Calendar.MONTH) == c1.get(Calendar.MONTH) && c2.get(Calendar.YEAR) == c1.get(Calendar.YEAR)))
		{
			// System.out.println(c1.getTime() + "," + c2.getTime());
			count++;
			c2.add(Calendar.MONTH, 1);

		}
		
		return count;
	}

	public static List<String> processZipFile(ZipFile zf)
	{
		Enumeration<?> zfEntries = zf.entries();
		List<String> lines = new ArrayList<String>();
		while (zfEntries.hasMoreElements())
		{
			BufferedReader br = null;
			try
			{
				ZipEntry zfEntry = (ZipEntry) zfEntries.nextElement();
				br = new BufferedReader(new InputStreamReader(zf.getInputStream(zfEntry)));
				for (String line = br.readLine(); line != null; line = br.readLine())
				{
					lines.add(line);
				}

			} catch (IOException ex)
			{
				ex.printStackTrace();
			} finally
			{
				try
				{
					br.close();
				} catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		}
		return lines;
	}

	public static Double checkDouble(Double d)
	{
		if (d.isNaN())
		{
			return null;
		} else
		{
			return d;
		}
	}

	public static long downloadFileFromURL(String address, String localFileName)
	{
		File temp = new File(localFileName);
		if (!temp.exists())
		{
			OutputStream out = null;
			URLConnection conn = null;
			InputStream in = null;
			try
			{
				URL url = new URL(address);
				out = new BufferedOutputStream(new FileOutputStream(localFileName));
				conn = url.openConnection();
				in = conn.getInputStream();
				byte[] buffer = new byte[1024];
				int numRead;
				long numWritten = 0;
				while ((numRead = in.read(buffer)) != -1)
				{
					out.write(buffer, 0, numRead);
					numWritten += numRead;
				}
				return numWritten;
			} catch (Exception exception)
			{
				exception.printStackTrace();
			} finally
			{
				try
				{
					if (in != null)
					{
						in.close();
					}
					if (out != null)
					{
						out.close();
					}
				} catch (IOException ioe)
				{
					ioe.printStackTrace();
				}
			}
		}
		
		return 0;
	}

	public static boolean isNumeric(String str)
	{
		try
		{
			double d = Double.parseDouble(str);
			d = d * 1;
		} catch (NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}

	public static void fileChannelCopy(File s, File t)
	{
		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;
		try
		{
			fi = new FileInputStream(s);
			fo = new FileOutputStream(t);
			in = fi.getChannel();
			out = fo.getChannel();
			in.transferTo(0, in.size(), out);
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				fi.close();
				in.close();
				fo.close();
				out.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static String getClientIp(HttpServletRequest request) 
	{

        String remoteAddr = "";

        if (request != null) 
        {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) 
            {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}
