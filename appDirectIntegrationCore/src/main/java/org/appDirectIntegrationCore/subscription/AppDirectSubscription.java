package org.appDirectIntegrationCore.subscription;

import java.io.IOException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.apache.http.client.ClientProtocolException;
import org.appDirectIntegrationCore.dto.SubscriptionEventResponse;
import org.appDirectIntegrationCore.util.AppDirectHTTPClient;
import org.appDirectIntegrationCore.util.IAppDirectClient;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class AppDirectSubscription implements IAppDirectSubscription{

	
	/* 
	 * Create new subscription by calling application specific HTTP POST method 
	 */
	public SubscriptionEventResponse createNewSubscription(String url) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException{
		IAppDirectClient client = new AppDirectHTTPClient();
		
		//get more details of the even
		JSONObject json = client.execute(url);
		
		return client.sendPOST("http://localhost:8080/conferenceMgmtService/user", json);
		
		
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
		
		//get more details of the even
		JSONObject json = client.execute(url);
		
		return client.sendDELETE("http://localhost:8080/conferenceMgmtService/user", json);
		
	}
}
