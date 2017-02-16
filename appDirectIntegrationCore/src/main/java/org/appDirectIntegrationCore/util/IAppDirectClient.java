package org.appDirectIntegrationCore.util;

import java.io.IOException;
import java.io.InputStream;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.apache.http.client.ClientProtocolException;
import org.appDirectIntegrationCore.dto.SubscriptionEventResponse;
import org.json.JSONObject;

public interface IAppDirectClient {

	public JSONObject execute(String url) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException;
	public InputStream sendGET(String url) throws UnsupportedOperationException, ClientProtocolException, IOException;
	public SubscriptionEventResponse sendPOST(String url,JSONObject param) throws UnsupportedOperationException, ClientProtocolException, IOException;
	public JSONObject getJSONObject(InputStream is);
	public SubscriptionEventResponse sendDELETE(String url, JSONObject param)
			throws UnsupportedOperationException, ClientProtocolException,
			IOException;
}
