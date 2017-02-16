package org.appDirectIntegrationCore.dto;

public class SubscriptionEventSuccess extends SubscriptionEventResponse {

	private String accountIdentifier;
	
	public SubscriptionEventSuccess(String accountIdentifier){
		super("success");
		this.accountIdentifier = accountIdentifier;
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	
}
