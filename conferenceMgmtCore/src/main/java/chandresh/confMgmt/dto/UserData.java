package chandresh.confMgmt.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserData {

	private static Map<String, UserDTO> userData = new HashMap<>();
	
	public static UserDTO getUserByEmailID(String emailId){
		return userData.get(emailId);
	}
	
	public static void addNewUserByEmailID(UserDTO user){
		user.setUserId(Math.abs(new Random().nextInt()));
		userData.put(user.getEmail(),user);
	}
	
	public static void removeUserByEmailID(String emailId){
		userData.remove(emailId);
	}
}
