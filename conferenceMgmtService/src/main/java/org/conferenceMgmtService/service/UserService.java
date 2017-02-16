package org.conferenceMgmtService.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.appDirectIntegrationCore.dto.ResponseErrorCodes;
import org.appDirectIntegrationCore.dto.SubscriptionEventFailure;
import org.appDirectIntegrationCore.dto.SubscriptionEventResponse;

import chandresh.confMgmt.dto.UserDTO;

@Path("/user")
public class UserService {

	
	@POST
	public SubscriptionEventResponse addNewUser(UserDTO user){
		SubscriptionEventResponse response = null;
		if(user==null){
			response = new SubscriptionEventFailure(ResponseErrorCodes.UNKNOWN_ERROR,"Unknown Error");
		}
	    
		return response;
	}
	
	@DELETE
	public SubscriptionEventResponse removeUser(UserDTO user){
		SubscriptionEventResponse response = null;
		if(user==null){
			response = new SubscriptionEventFailure(ResponseErrorCodes.UNKNOWN_ERROR,"Unknown Error");
		}
	    
		return response;
	}
}
