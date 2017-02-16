package org.conferenceMgmtService.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.appDirectIntegrationCore.dto.ResponseErrorCodes;
import org.appDirectIntegrationCore.dto.SubscriptionEventResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chandresh.confMgmt.User;
import chandresh.confMgmt.UserConfig;
import chandresh.confMgmt.dto.UserDTO;

@Path("/user")
public class UserService {

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SubscriptionEventResponse addNewUser(UserDTO userDTO){
		if(userDTO==null){
			return new SubscriptionEventResponse(ResponseErrorCodes.UNKNOWN_ERROR,"Unknown Error");
		}
	    
		User user = null;
		try(AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(UserConfig.class);)
		{
			user = ac.getBean(User.class);
		}
		return user.addNewUser(userDTO);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{email}")
	public SubscriptionEventResponse removeUser(@PathParam("email") String email){
		if(email==null){
			return new SubscriptionEventResponse(ResponseErrorCodes.USER_NOT_FOUND,"User not found with the given mail id");
		}
		User user = null;
		try(AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(UserConfig.class);)
		{
			user = ac.getBean(User.class);
		}
		return user.removeUser(email);
	}
}
