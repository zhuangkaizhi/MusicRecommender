package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

public class HttpDownloadFile implements Runnable
{
	public static final String PEER_CERTIFICATES = "PEER_CERTIFICATES";

	private String link;

	private File file;

	public HttpDownloadFile(String link, File out)
	{
		this.link = link;
		this.file = out;
	}

	@Override
	public void run()
	{
		try
		{
			// saveFileFromUrlWithHttpClient();
			sslTest();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sslTest()
	{
		try
		{
			// configure the SSLContext with a TrustManager
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(new KeyManager[0],
					new TrustManager[] { new DefaultTrustManager() },
					new SecureRandom());
			SSLContext.setDefault(ctx);

			URL url = new URL("https://cdns-preview-d.dzcdn.net//stream//c-deda7fa9316d9e9e880d2c6207e92260-5.mp3");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setHostnameVerifier(new HostnameVerifier()
			{

				@Override
				public boolean verify(String hostname, SSLSession session)
				{
					return true;
				}
			});

			System.out.println(conn.getResponseCode());
			
			conn.disconnect();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static class DefaultTrustManager implements X509TrustManager
	{

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1)
				throws CertificateException
		{
		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1)
				throws CertificateException
		{
		}

		@Override
		public X509Certificate[] getAcceptedIssuers()
		{
			return null;
		}
	}

	public void httpClientGetServerCertificate()
	{
		// create http response certificate interceptor
		HttpResponseInterceptor certificateInterceptor = (httpResponse,
				context) -> {
			ManagedHttpClientConnection routedConnection = (ManagedHttpClientConnection) context
					.getAttribute(HttpCoreContext.HTTP_CONNECTION);
			SSLSession sslSession = routedConnection.getSSLSession();
			if (sslSession != null)
			{
				// get the server certificates from the {@Link SSLSession}
				Certificate[] certificates = sslSession.getPeerCertificates();

				// add the certificates to the context, where we can later grab
				// it from
				context.setAttribute(PEER_CERTIFICATES, certificates);
			}
		};

		// create closable http client and assign the certificate interceptor
		CloseableHttpClient httpClient = HttpClients.custom()
				.addInterceptorLast(certificateInterceptor).build();

		try
		{
			// make HTTP GET request to resource server
			// HttpGet httpget = new HttpGet("https://google.com");
			HttpGet httpget = new HttpGet(link);
			System.out.println("Executing request " + httpget.getRequestLine());

			// create http context where the certificate will be added
			HttpContext context = new BasicHttpContext();
			httpClient.execute(httpget, context);

			// obtain the server certificates from the context
			Certificate[] peerCertificates = (Certificate[]) context
					.getAttribute(PEER_CERTIFICATES);

			// loop over certificates and print meta-data
			for (Certificate certificate : peerCertificates)
			{
				X509Certificate real = (X509Certificate) certificate;
				System.out.println("----------------------------------------");
				System.out.println("Type: " + real.getType());
				System.out
						.println("Signing Algorithm: " + real.getSigAlgName());
				System.out.println(
						"IssuerDN Principal: " + real.getIssuerX500Principal());
				System.out.println("SubjectDN Principal: "
						+ real.getSubjectX500Principal());
				System.out.println("Not After: " + DateUtils
						.formatDate(real.getNotAfter(), "dd-MM-yyyy"));
				System.out.println("Not Before: " + DateUtils
						.formatDate(real.getNotBefore(), "dd-MM-yyyy"));
			}

		} catch (Exception exp)
		{
			exp.printStackTrace();
		} finally
		{
			// close httpclient
			try
			{
				httpClient.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// using HttpClient
	public void saveFileFromUrlWithHttpClient() throws Exception
	{
		// Trust own CA and all self-signed certs
		SSLContext sslcontext = SSLContexts.custom()
				.loadTrustMaterial(new File("my.keystore"),
						"nopassword".toCharArray(),
						new TrustSelfSignedStrategy())
				.build();

		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.getDefaultHostnameVerifier());

		CloseableHttpClient httpclient = HttpClients.custom()
				.setSSLSocketFactory(sslsf).build();
		try
		{

			HttpGet httpget = new HttpGet(link);

			System.out.println("Executing request " + httpget.getRequestLine());

			CloseableHttpResponse response = httpclient.execute(httpget);
			try
			{
				HttpEntity entity = response.getEntity();

				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				EntityUtils.consume(entity);
			} finally
			{
				response.close();
			}
		} finally
		{
			httpclient.close();
		}
	}

	public void urlConnection()
	{
		try
		{
			URL url = new URL(link);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			long fileSize = http.getContentLengthLong();
			BufferedInputStream bin = new BufferedInputStream(
					http.getInputStream());
			FileOutputStream fout = new FileOutputStream(this.file);
			BufferedOutputStream bout = new BufferedOutputStream(fout, 1024);
			byte[] buffer = new byte[1024];
			double downloaded = 0.0d;
			int read = 0;
			double percentD = 0.0d;
			while ((read = bin.read(buffer, 0, 1024)) > 0)
			{
				bout.write(buffer, 0, read);
				downloaded += read;
				percentD = (downloaded * 100) / fileSize;
				String percentage = String.format("%.4f", percentD);
				System.out.println("Download " + percentage + " % of file");
			}
			bout.close();
			bin.close();
			System.out.println("Download complete!");

		} catch (Exception exp)
		{
			exp.printStackTrace();
		}
	}

	// Using Java IO
	public static void saveFileFromUrlWithJavaIO(String fileName,
			String fileUrl)
	{
		BufferedInputStream in = null;
		FileOutputStream fout = null;
		try
		{
			in = new BufferedInputStream(new URL(fileUrl).openStream());
			fout = new FileOutputStream(fileName);
			byte data[] = new byte[1024];
			int count;
			while ((count = in.read(data, 0, 1024)) != -1)
			{
				fout.write(data, 0, count);
			}
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			try
			{
				if (in != null)
					in.close();

				if (fout != null)
					fout.close();

			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	// Using Commons IO library
	public static void saveFileFromUrlWithCommonsIO(String fileName,
			String fileUrl)
	{
		try
		{
			FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
		} catch (MalformedURLException exp)
		{
			exp.printStackTrace();
		} catch (IOException exp)
		{
			exp.printStackTrace();
		} catch (Exception exp)
		{
			exp.printStackTrace();
		}
	}

}
