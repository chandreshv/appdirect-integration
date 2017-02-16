package org.appDirectIntegrationCore.subscription;

import java.io.IOException;
import java.io.InputStream;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.apache.http.client.ClientProtocolException;
import org.appDirectIntegrationCore.dto.SubscriptionEventResponse;
import org.appDirectIntegrationCore.util.AppDirectHTTPClient;
import org.appDirectIntegrationCore.util.IAppDirectClient;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AppDirectSubscription implements IAppDirectSubscription{

	
	/* 
	 * Create new subscription by calling application specific HTTP POST method 
	 */
	public SubscriptionEventResponse createNewSubscription(String url) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException{
		IAppDirectClient client = new AppDirectHTTPClient();
		JSONObject json = client.execute(url);
		
		InputStream is = client.sendPOST("http://localhost:8080/conferenceMgmtService/user", json);
		return new ObjectMapper().readValue(is,SubscriptionEventResponse.class);
	}

	/* 
	 * Cancel new subscription by calling application specific HTTP DELETE method 
	 */
	@Override
	public SubscriptionEventResponse cancelSubscription(String url)
			throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException,
			ClientProtocolException, IOException {

		IAppDirectClient client = new AppDirectHTTPClient();
		JSONObject json = client.execute(url);
		
		InputStream is = client.sendDELETE("http://localhost:8080/conferenceMgmtService/user", json);
		return new ObjectMapper().readValue(is,SubscriptionEventResponse.class);
	}
}
