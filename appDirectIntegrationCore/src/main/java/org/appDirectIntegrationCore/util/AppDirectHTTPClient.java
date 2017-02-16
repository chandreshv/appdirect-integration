package org.appDirectIntegrationCore.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

public class AppDirectHTTPClient implements IAppDirectClient {

	OAuthConsumer consumer;

	public AppDirectHTTPClient() {
		consumer = new DefaultOAuthConsumer("Dummy", "secret");
	}

	private void signURL(String urlString) throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException {
		this.consumer.sign(urlString);
	}

	public JSONObject execute(String url) throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException,
			ClientProtocolException, IOException {
		this.signURL(url);
		InputStream is = this.sendGET(url);
		return this.getJSONObject(is);

	}

	/**
	 * @param is
	 * @return Convert InputStream to JSON object
	 */
	public JSONObject getJSONObject(InputStream is) {
		JSONObject jsonObject = null;
		try {
			BufferedReader streamReader = new BufferedReader(
					new InputStreamReader(is, "UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();

			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
				responseStrBuilder.append(inputStr);

			jsonObject = new JSONObject(responseStrBuilder.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	/**
	 * @param url
	 * @return
	 * @throws UnsupportedOperationException 
	 * @throws OAuthMessageSignerException
	 * @throws OAuthExpectationFailedException
	 * @throws OAuthCommunicationException
	 * @throws ClientProtocolException
	 * @throws IOException
	 * 
	 * Send HTTP GET request to the input url
	 */
	public InputStream sendGET(String url) throws UnsupportedOperationException, ClientProtocolException, IOException{
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		return client.execute(request).getEntity().getContent();
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.appDirectIntegrationCore.util.IAppDirectClient#sendPOST(java.lang
	 * .String, org.json.JSONObject) HTTP Post request to the input url
	 */
	@Override
	public InputStream sendPOST(String url, JSONObject param)
			throws UnsupportedOperationException, ClientProtocolException,
			IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		StringEntity se = new StringEntity(param.toString());
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
				"application/json"));
		post.setEntity(se);
		return client.execute(post).getEntity().getContent();
	}

	@Override
	public InputStream sendDELETE(String url,JSONObject param) throws UnsupportedOperationException, ClientProtocolException, IOException {
		
		class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
		    public static final String METHOD_NAME = "DELETE";
		 
		    public String getMethod() {
		        return METHOD_NAME;
		    }
		 
		    public HttpDeleteWithBody(final String uri) {
		        super();
		        setURI(URI.create(uri));
		    }
		}
		
		HttpDeleteWithBody httpDelete = new HttpDeleteWithBody(url);
		StringEntity se = new StringEntity(param.toString()); 
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpDelete.setEntity(se);  
        CloseableHttpClient httpclient = HttpClients.createDefault();
		
		return httpclient.execute(httpDelete).getEntity().getContent();
	}
}
