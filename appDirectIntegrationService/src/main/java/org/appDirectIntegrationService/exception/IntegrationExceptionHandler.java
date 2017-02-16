package org.appDirectIntegrationService.exception;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.appDirectIntegrationCore.dto.ResponseErrorCodes;
import org.appDirectIntegrationCore.dto.SubscriptionEventResponse;

@Provider
public class IntegrationExceptionHandler implements ExceptionMapper<Exception>{

	@Override
	public Response toResponse(Exception arg0) {
		SubscriptionEventResponse response = new SubscriptionEventResponse(ResponseErrorCodes.UNKNOWN_ERROR, arg0.getMessage());
		//String error = {"success":"false", "errorCode": "UNKNOWN_ERROR"}
		return Response.status(Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(Entity.json(response)).build();
	}
	
	

}
