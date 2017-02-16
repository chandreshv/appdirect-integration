package chandresh.confMgmt.conference;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import chandresh.confMgmt.conference.Conference;
import chandresh.confMgmt.talk.GeneralTalk;
import chandresh.confMgmt.talk.Talk;

public class ConferenceTest {

	@Test
	public void testNullInputFile() throws IllegalArgumentException{
		List<Talk> allTalks = new ArrayList<Talk>();
		
		int[] duration = {60,45,30,45,45,5,60,45,30,30,45,60,60,45,30,30,60,30,30};
		
		for(int i=0;i<19;i++){
			Talk t = new GeneralTalk();
			t.setName(i+"");
			t.setDuration(duration[i]);
			allTalks.add(t);
		}
		
		Conference test = 	new Conference().create(allTalks);
		assertEquals(2, test.getTrackList().size());
	}
}
