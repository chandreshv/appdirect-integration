package org.appDirectIntegrationCore.util;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	
	public static void main(String args[]){
		String json = "{'type': 'SUBSCRIPTION_ORDER','marketplace': {'baseUrl': 'https://www.acme.com', 'partner': 'APPDIRECT' },'creator': {'address': "
				+ "{'firstName': 'Sample','fullName': 'Sample Tester','lastName': 'Tester'},"
				+ " 'email': 'sampletester@testco.com','firstName': 'Sample','language': 'en','lastName': 'Tester','locale': 'en-US',"
				+ "'openId': 'https://www.acme.com/openid/id/211aa367-f53b-4606-8887-80a381e0ef69','uuid': '211aa369-f53b-4606-8887-80a361e0ef66'}}";
		JSONObject jsonObject = new JSONObject(json);
		Object om = jsonObject.get("type");
		System.out.println(om.toString());
	}
}
