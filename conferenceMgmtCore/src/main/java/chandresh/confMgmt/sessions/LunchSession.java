package chandresh.confMgmt.sessions;

import java.util.ArrayList;
import java.util.List;

import chandresh.confMgmt.talk.Talk;

public class LunchSession extends Session{

	public static final String MORNING_SESSION_START_TIME="1200";
	public static final String MORNING_SESSION_END_TIME="1300";
	public static final String SESSION_NAME="Lunch";
	
	@Override
	public Session scheduleSession(List<Talk> allTalks) {
		return this; 
	}
	
	@Override
	public List<String> print() {
		List<String> result = new ArrayList<String>();
		 
		result.add(this.MORNING_SESSION_START_TIME+" "+ this.SESSION_NAME+" "+String.valueOf(this.getAvailableTimeInMinutes(MORNING_SESSION_START_TIME, MORNING_SESSION_END_TIME)));
		return result;
	}

}
