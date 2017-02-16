package chandresh.confMgmt.track;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import chandresh.confMgmt.Track.Track;
import chandresh.confMgmt.talk.GeneralTalk;
import chandresh.confMgmt.talk.LightningTalk;
import chandresh.confMgmt.talk.Talk;

public class TrackTest {
	
/*	@Test
	public void testNewLunchSession(){
		Track t = new Track();
		List<Talk> allTalks = new ArrayList<Talk>();
		Talk t1 = new GeneralTalk();
		t1.setName("Talk 1");
		t1.setDuration(60);
		allTalks.add(t1);
		Talk t2 = new GeneralTalk();
		t2.setName("Talk 2");
		t2.setDuration(60);
		allTalks.add(t2);
		Talk t3 = new LightningTalk();
		t3.setName("Ligntning talk");
		t3.setDuration(60);
		allTalks.add(t3);
		
		Talk t4 = new LightningTalk();
		t4.setName("Ligntning talk");
		t4.setDuration(60);
		allTalks.add(t4);
		
		t.create(allTalks);
		assertEquals(t.getSessionList().size(), 4);
		assertEquals(t.getSessionList().get(1).getSessionTalk().size(), 0);
	}

	@Test
	public void testScheduleTalksPerfectFitInMorningSession(){
		Track t = new Track();
		List<Talk> allTalks = new ArrayList<Talk>();
		Talk t1 = new GeneralTalk();
		t1.setName("Talk 1");
		t1.setDuration(60);
		allTalks.add(t1);
		Talk t2 = new GeneralTalk();
		t2.setName("Talk 2");
		t2.setDuration(60);
		allTalks.add(t2);
		Talk t3 = new LightningTalk();
		t3.setName("Ligntning talk");
		t3.setDuration(60);
		allTalks.add(t3);
		
		Talk t4 = new LightningTalk();
		t4.setName("Ligntning talk");
		t4.setDuration(60);
		allTalks.add(t4);
		
		t.create(allTalks);
		assertEquals("0900", t.getSessionList().get(0).getSessionTalk().get(0).getStartTime());
		assertEquals("1000", t.getSessionList().get(0).getSessionTalk().get(1).getStartTime());
		assertEquals("1100", t.getSessionList().get(0).getSessionTalk().get(2).getStartTime());
	}
	
	@Test
	public void testScheduleTalksPerfectFitInAfterNoonSession(){
		Track t = new Track();
		List<Talk> allTalks = new ArrayList<Talk>();
		Talk t1 = new GeneralTalk();
		t1.setName("Talk 1");
		t1.setDuration(60);
		allTalks.add(t1);
		Talk t2 = new GeneralTalk();
		t2.setName("Talk 2");
		t2.setDuration(60);
		allTalks.add(t2);
		Talk t3 = new LightningTalk();
		t3.setName("Ligntning talk");
		t3.setDuration(70);
		allTalks.add(t3);
		
		Talk t4 = new LightningTalk();
		t4.setName("Ligntning talk");
		t4.setDuration(170);
		allTalks.add(t4);
		
		t.create(allTalks);
		// compare total duration of talks scheduled in afternoon session with the max allowed duration for after session
		assertEquals(240, t.getSessionList().get(2).getSessionTalk().get(0).getDuration()+t.getSessionList().get(2).getSessionTalk().get(1).getDuration());
	}*/
	
/*	@Test
	public void testScheduleTalksBestFitInMorningSession(){
		Track t = new Track();
		List<Talk> allTalks = new ArrayList<Talk>();
		Talk t1 = new GeneralTalk();
		t1.setName("Talk 1");
		t1.setDuration(60);
		allTalks.add(t1);
		Talk t2 = new GeneralTalk();
		t2.setName("Talk 2");
		t2.setDuration(60);
		allTalks.add(t2);
		Talk t3 = new LightningTalk();
		t3.setName("Ligntning talk");
		t3.setDuration(50);
		allTalks.add(t3);
		
		Talk t4 = new LightningTalk();
		t4.setName("Ligntning talk");
		t4.setDuration(40);
		allTalks.add(t4);
		
		t.create(allTalks);
		assertEquals("0900", t.getSessionList().get(0).getSessionTalk().get(0).getStartTime());
		assertEquals("0940", t.getSessionList().get(0).getSessionTalk().get(1).getStartTime());
		assertEquals("1030", t.getSessionList().get(0).getSessionTalk().get(2).getStartTime());
	}
	
	@Test
	public void testTrackSchedulingNetworkAtFour(){
		Track t = new Track();
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
		t3.setDuration(40);
		allTalks.add(t3);
		
		t.create(allTalks);
		assertEquals("1600", t.getSessionList().get(2).getSessionTalk().get(0).getStartTime());
	}
	
	@Test
	public void testSchedulingNetworkSessionAtFive(){
		Track t = new Track();
		List<Talk> allTalks = new ArrayList<Talk>();
		Talk t1 = new GeneralTalk();
		t1.setName("Talk 1");
		t1.setDuration(80);
		allTalks.add(t1);
		Talk t2 = new GeneralTalk();
		t2.setName("Talk 2");
		t2.setDuration(80);
		allTalks.add(t2);
		Talk t3 = new GeneralTalk();
		t3.setName("Talk 3");
		t3.setDuration(80);
		allTalks.add(t3);
		
		Talk t4 = new GeneralTalk();
		t4.setName("Talk 4");
		t4.setDuration(180);
		allTalks.add(t4);
		
		t.create(allTalks);
		assertEquals("1700", t.getSessionList().get(2).getSessionTalk().get(0).getStartTime());
	}*/

	
}
