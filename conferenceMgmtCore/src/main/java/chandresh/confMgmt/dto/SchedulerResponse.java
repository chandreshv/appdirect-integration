package chandresh.confMgmt.dto;


public class SchedulerResponse {

	public ConferenceStatus status;
	public String message;
	public ConferenceStatus getStatus() {
		return status;
	}
	public void setStatus(ConferenceStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void buildSchedulerResponse(ConferenceStatus status,String message) {
		this.status=status;
		this.message=message;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj==null || !SchedulerResponse.class.isAssignableFrom(obj.getClass()))
			return false;
		
		
		SchedulerResponse sr2 = (SchedulerResponse)obj;
		if(this.status.name().equals(sr2.status.name()) && this.message.equals(sr2.message))
			return true;
		
		return false;
	}
	
	
}
