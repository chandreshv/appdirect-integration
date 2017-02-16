package org.appDirectIntegrationCore.dto;

public abstract class SubscriptionEventResponse{

	protected String success;
	
	public SubscriptionEventResponse(String success){
		this.success = success;
	}

	public String getSuccess() {
		return success;
	}
}
