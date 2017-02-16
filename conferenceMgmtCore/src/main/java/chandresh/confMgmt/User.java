package chandresh.confMgmt;

import org.appDirectIntegrationCore.dto.ResponseErrorCodes;
import org.appDirectIntegrationCore.dto.SubscriptionEventFailure;
import org.appDirectIntegrationCore.dto.SubscriptionEventResponse;
import org.appDirectIntegrationCore.dto.SubscriptionEventSuccess;
import org.springframework.stereotype.Component;

import chandresh.confMgmt.dto.UserDTO;
import chandresh.confMgmt.dto.UserData;

@Component
public class User {

	public SubscriptionEventResponse addNewUser(UserDTO user){
		SubscriptionEventResponse response = null;
		if(UserData.getUserByEmailID(user.getEmail())!=null){
			response = new SubscriptionEventFailure(ResponseErrorCodes.USER_ALREADY_EXISTS, "User already exist with the given mail id");
		}else{
			UserData.addNewUserByEmailID(user);
			response = new SubscriptionEventSuccess(user.getUserId()+"");
		}
		
		return response;
	}
	
	public SubscriptionEventResponse removeUser(UserDTO user){
		SubscriptionEventResponse response = null;
		if(UserData.getUserByEmailID(user.getEmail())==null){
			response = new SubscriptionEventFailure(ResponseErrorCodes.USER_NOT_FOUND, "User not found with the given mail id");
		}else{
			UserData.removeUserByEmailID(user.getEmail());
			response = new SubscriptionEventSuccess(user.getUserId()+"");
		}
		
		return response;
	}
	
}
