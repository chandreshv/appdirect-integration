package org.appDirectIntegrationCore.dto;

public class SubscriptionEventResponse{

	public String success;
	public ResponseErrorCodes errorCode;
	public String accountIdentifier;
	public String message;
	
	public SubscriptionEventResponse(){}
	
	public SubscriptionEventResponse(String accountIdentifier){
		this.success="true";
		this.accountIdentifier=accountIdentifier;
	}
	
	public SubscriptionEventResponse(ResponseErrorCodes errorCode, String message){
		this.success="false";
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public ResponseErrorCodes getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(ResponseErrorCodes errorCode) {
		this.errorCode = errorCode;
	}
	public String getAccountIdentifier() {
		return accountIdentifier;
	}
	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
