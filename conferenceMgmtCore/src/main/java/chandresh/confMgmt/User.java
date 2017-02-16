package chandresh.confMgmt;

import org.appDirectIntegrationCore.dto.ResponseErrorCodes;
import org.appDirectIntegrationCore.dto.SubscriptionEventResponse;
import org.springframework.stereotype.Component;

import chandresh.confMgmt.dto.UserDTO;
import chandresh.confMgmt.dto.UserData;

@Component
public class User {

	public SubscriptionEventResponse addNewUser(UserDTO user){
		SubscriptionEventResponse response = null;
		if(UserData.getUserByEmailID(user.getCreator().getEmail())!=null){
			response = new SubscriptionEventResponse(ResponseErrorCodes.USER_ALREADY_EXISTS, "User already exist with the given mail id");
		}else{
			UserData.addNewUserByEmailID(user);
			response = new SubscriptionEventResponse(user.getUserId()+"");
		}
		
		return response;
	}
	
	public SubscriptionEventResponse removeUser(String email){
		SubscriptionEventResponse response = null;
		if(UserData.getUserByEmailID(email)==null){
			response = new SubscriptionEventResponse(ResponseErrorCodes.USER_NOT_FOUND, "User not found with the given mail id");
		}else{
			int userID = UserData.getUserByEmailID(email).getUserId();
			UserData.removeUserByEmailID(email);
			response = new SubscriptionEventResponse(userID+"");
		}
		
		return response;
	}
	
}
