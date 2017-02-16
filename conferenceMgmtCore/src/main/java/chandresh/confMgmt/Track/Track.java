package chandresh.confMgmt.Track;

import java.util.ArrayList;
import java.util.List;

import chandresh.confMgmt.sessions.AfternoonSession;
import chandresh.confMgmt.sessions.LunchSession;
import chandresh.confMgmt.sessions.MorningSession;
import chandresh.confMgmt.sessions.NetworkSession;
import chandresh.confMgmt.sessions.Session;
import chandresh.confMgmt.talk.Talk;

public class Track {
	private List<Session> sessionList = new ArrayList<Session>();
	
	public List<Session> getSessionList() {
		return sessionList;
	}

	public Track create(List<Talk> allTalks) {
		Session session=null;

		if (allTalks.size() > 0) {
			session = new MorningSession();
			this.sessionList.add(session.scheduleSession(allTalks));
		}
		
			session = new LunchSession();
			this.sessionList.add(session.scheduleSession(allTalks));

		if (allTalks.size() > 0) {
			session = new AfternoonSession();
			this.sessionList.add(session.scheduleSession(allTalks));
		}

		session = new NetworkSession();
		List<Talk> lastSessionTalks = this.sessionList.get(
				this.sessionList.size() - 1).getSessionTalk();
		this.sessionList.add(session.scheduleSession(lastSessionTalks));

		return this;

	}

	public List<String> print() {
		List<String> result = new ArrayList<String>();
		for(Session eachSession: this.sessionList){
			result.addAll(eachSession.print());
		}
		return result;
	}

}