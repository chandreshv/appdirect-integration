package org.appDirectIntegrationService.service;

import java.io.IOException;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.apache.http.client.ClientProtocolException;
import org.appDirectIntegrationCore.UserConfig;
import org.appDirectIntegrationCore.dto.SubscriptionEventResponse;
import org.appDirectIntegrationCore.subscription.IAppDirectSubscription;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Path("/appdirect")
public class SubscriptionService {

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public SubscriptionEventResponse createNewSubscription(@QueryParam("url") String url) throws IllegalArgumentException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException{
		if(url==null)
			throw new IllegalArgumentException("Invalid url");
		IAppDirectSubscription ias = null;
		try(AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(UserConfig.class);)
		{
			ias = ac.getBean(IAppDirectSubscription.class);
		}
		return ias.createNewSubscription(url);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public SubscriptionEventResponse cancelSubscription(@QueryParam("url") String url) throws IllegalArgumentException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException{
		if(url==null)
			throw new IllegalArgumentException("Invalid url");
		IAppDirectSubscription ias = null;
		try(AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(UserConfig.class);)
		{
			ias = ac.getBean(IAppDirectSubscription.class);
		}
		return ias.cancelSubscription(url);
	}
}
