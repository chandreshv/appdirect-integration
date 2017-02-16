package org.appDirectIntegrationCore.dto;

public class SubscriptionEventFailure extends SubscriptionEventResponse{

	private String errorCode;
	private String message;
	
	public SubscriptionEventFailure( ResponseErrorCodes errorCode,String message){
		super("false");
		this.errorCode = errorCode.name();
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}
	
	
	
}
