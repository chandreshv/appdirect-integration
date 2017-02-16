package chandresh.confMgmt.sessions;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;

import chandresh.confMgmt.sessions.MorningSession;
import chandresh.confMgmt.sessions.Session;
import chandresh.confMgmt.talk.GeneralTalk;
import chandresh.confMgmt.talk.LightningTalk;
import chandresh.confMgmt.talk.Talk;

public class SessionTest {

/*	@Test
	public void testExactMorningSessionScheduling(){
		Session session = new MorningSession();
		List<Talk> allTalks = new ArrayList<Talk>();
		Talk t1 = new GeneralTalk();
		t1.setName("Talk 1");
		t1.setDuration(45);
		allTalks.add(t1);
		Talk t2 = new GeneralTalk();
		t2.setName("Talk 2");
		t2.setDuration(45);
		allTalks.add(t2);
		Talk t3 = new LightningTalk();
		t3.setName("Ligntning talk");
		t3.setDuration(5);
		allTalks.add(t3);
		Talk t4 = new LightningTalk();
		t4.setName("Talk3");
		t4.setDuration(85);
		allTalks.add(t4);
		
		session.scheduleSession(allTalks);
		assertEquals(5, session.getSessionTalk().size());
		//Number of talks that could not be scheduled
		assertEquals(0, allTalks.size());
	}
	
	@Test
	public void testBestPossibleMorningSessionScheduling(){
		Session session = new MorningSession();
		List<Talk> allTalks = new ArrayList<Talk>();
		Talk t1 = new GeneralTalk();
		t1.setName("Talk 1");
		t1.setDuration(80);
		allTalks.add(t1);
		Talk t2 = new GeneralTalk();
		t2.setName("Talk 2");
		t2.setDuration(80);
		allTalks.add(t2);
		Talk t3 = new LightningTalk();
		t3.setName("Ligntning talk");
		t3.setDuration(80);
		allTalks.add(t3);
		
		session.scheduleSession(allTalks);
		assertEquals(3, session.getSessionTalk().size());
		assertEquals(1, allTalks.size());
	}*/

}
