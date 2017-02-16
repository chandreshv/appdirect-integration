package chandresh.confMgmt.sessions;

import java.util.List;

import chandresh.confMgmt.talk.GeneralTalk;
import chandresh.confMgmt.talk.Talk;

public class MorningSession extends Session{
	public static final String MORNING_SESSION_START_TIME="0900";
	public static final String MORNING_SESSION_END_TIME="1200";
	
	public static final String LUNCH_SESSION_NAME="Lunch";
	public static final String LUNCH_START_TIME="1200";
	public static final int LUNCH_DURATION=60;
	

	@Override
	public Session scheduleSession(List<Talk> allTalks) {
		if(validateTime(MORNING_SESSION_START_TIME,MORNING_SESSION_END_TIME)){
			int availableTimeInMins = getAvailableTimeInMinutes(MORNING_SESSION_START_TIME,MORNING_SESSION_END_TIME);
			schedule(allTalks, availableTimeInMins,MORNING_SESSION_START_TIME);
			//this.getSessionTalk().add(addLunchDetails());
		}else{
			throw new IllegalArgumentException("Invalid start and end time of the session");
		}
		
		return this;
		
	}


	private Talk addLunchDetails() {
		Talk lunch = new GeneralTalk();
		lunch.setName(LUNCH_SESSION_NAME);
		lunch.setDuration(LUNCH_DURATION);
		lunch.setStartTime(LUNCH_START_TIME);
		return lunch;
	}


}
