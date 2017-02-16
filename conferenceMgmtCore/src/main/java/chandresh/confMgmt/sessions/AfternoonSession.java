package chandresh.confMgmt.sessions;

import java.util.List;

import chandresh.confMgmt.talk.Talk;

public class AfternoonSession extends Session {
	public static final String START_TIME="1300";
	public static final String END_TIME="1700";
	
	@Override
	public Session scheduleSession(List<Talk> allTalks) {
		if(validateTime(START_TIME,END_TIME)){
			int availableTimeInMins = getAvailableTimeInMinutes(START_TIME,END_TIME);
			schedule(allTalks, availableTimeInMins,START_TIME);
		}else{
			throw new IllegalArgumentException("Invalid start and end time of the session");
		}
		
		return this;
	}
	
	

}
