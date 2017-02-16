package chandresh.confMgmt.sessions;

import java.util.List;

import chandresh.confMgmt.talk.GeneralTalk;
import chandresh.confMgmt.talk.Talk;

public class NetworkSession extends Session{
	
	public static final String NETWORK_SESSION_NAME = "Networking session";
	public static final String DEFAULT_NETWORK_SESSION_START_TIME = "1600";
	
	
	@Override
	public Session scheduleSession(List<Talk> allTalks) {
		Talk lastTalk = allTalks.get(allTalks.size() - 1);
		Talk networkSession = new GeneralTalk();
		String networkStartTime = getStartTimeOfCurrentTalk(lastTalk.getStartTime(), lastTalk.getDuration());
		if(validateTime(networkStartTime, DEFAULT_NETWORK_SESSION_START_TIME)){
			networkSession.setStartTime(DEFAULT_NETWORK_SESSION_START_TIME);
		}else{
			networkSession.setStartTime(networkStartTime);
		}
		networkSession.setName(NETWORK_SESSION_NAME);
		this.getSessionTalk().add(networkSession);
		
		return this;
	}

}
