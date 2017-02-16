package org.appDirectIntegrationCore.subscription;

import java.io.IOException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.apache.http.client.ClientProtocolException;
import org.appDirectIntegrationCore.dto.SubscriptionEventResponse;

public interface IAppDirectSubscription {

	public SubscriptionEventResponse createNewSubscription(String url) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException;
	public SubscriptionEventResponse cancelSubscription(String url) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException;
	
}
