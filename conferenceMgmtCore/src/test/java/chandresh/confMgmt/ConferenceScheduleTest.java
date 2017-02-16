package chandresh.confMgmt;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import chandresh.confMgmt.ConferenceScheduler;
import chandresh.confMgmt.dto.ConferenceStatus;
import chandresh.confMgmt.dto.SchedulerResponse;



public class ConferenceScheduleTest{
	

	@Test
	public void testValidInputFileWithAllCorrectData() throws IllegalArgumentException{
		String[] inputStr = {"Writing Fast Tests Against Enterprise Rails 60min",
				"Overdoing it in Python 45min",
				"Lua for the Masses 30min",
				"Ruby Errors from Mismatched Gem Versions 45min",
				"Common Ruby Errors 45min",
				"Rails for Python Developers lightning",
				"Communicating Over Distance 60min",
				"Accounting-Driven Development 45min",
				"Woah 30min",
				"Sit Down and Write 30min",
				"Pair Programming vs Noise 45min",
				"Rails Magic 60min",
				"Ruby on Rails: Why We Should Move On 60min",
				"Clojure Ate Scala (on my project) 45min",
				"Programming in the Boondocks of Seattle 30min",
				"Ruby vs. Clojure for Back-End Development 30min",
				"Ruby on Rails Legacy App Maintenance 60min",
				"A World Without HackerNews 30min",
				"User Interface CSS in Rails Apps 30min",
				"Another session on Pair Programming vs Noise 45min",
				"Another session on Rails Magic 60min",
				"Another session on Ruby on Rails: Why We Should Move On 60min",
				"Another session on Clojure Ate Scala (on my project) 45min",
				"Another session on Programming in the Boondocks of Seattle 30min",
				"Another session on Ruby vs. Clojure for Back-End Development 30min",
				"Another session on Ruby on Rails Legacy App Maintenance 60min",
				"Another session on A World Without HackerNews 30min",
				"Another session on User Interface CSS in Rails Apps 30min"
				};
		
		List<String> input = Arrays.asList(inputStr);
		
		SchedulerResponse expected = new SchedulerResponse();
		expected.buildSchedulerResponse(ConferenceStatus.OK,"Conference scheduled successully");
		SchedulerResponse actual = new ConferenceScheduler().schedule(input);
		assertEquals(expected, actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullInputFile() throws IllegalArgumentException{
		new ConferenceScheduler().schedule(null);
	}
	
	@Test
	public void testValidInputFileWithMixedData() throws IllegalArgumentException{
		
		String[] inputStr = {
				"Writing Fast Tests Against Enterprise Rails 60min",
				"Overdoing it in Python 45min",
				"Lua for the Masses 30min",
				"invalid data",
				"Common Ruby Errors 45min",
				"Rails for Python Developers lightning",
				"Communicating Over Distance 60min",
				"Accounting-Driven Development 45min",
				"Woah 30min",
				"Sit Down and Write 30min",
				"Pair Programming vs Noise 45min",
				"Rails Magic 60min",
				"Ruby on Rails: Why We Should Move On 60min",
				"Clojure Ate Scala (on my project) 45min",
				"Programming in the Boondocks of Seattle 30min",
				"Ruby vs. Clojure for Back-End Development 30min",
				"Ruby on Rails Legacy App Maintenance 60min",
				"A World Without HackerNews 30min",
				"User Interface CSS in Rails Apps 30min",
				"Another session on Pair Programming vs Noise 45min",
				"Another session on Rails Magic 60min",
				"Data with exceeding time 600min",
				"Another session on Clojure Ate Scala (on my project) 45min",
				"Another session on Programming in the Boondocks of Seattle 30min",
				"Another session on Ruby vs. Clojure for Back-End Development 30min",
				"Another session on Ruby on Rails Legacy App Maintenance 60min",
				"Another session on A World Without HackerNews 30min",
				"Another session on User Interface CSS in Rails Apps 30min",
				};
		
		List<String> input = Arrays.asList(inputStr);
		
		SchedulerResponse expected = new SchedulerResponse();
		expected.buildSchedulerResponse(ConferenceStatus.OK,"Conference scheduled successully");
		SchedulerResponse actual = new ConferenceScheduler().schedule(input);
		assertEquals(expected, actual);
	}
	


}
