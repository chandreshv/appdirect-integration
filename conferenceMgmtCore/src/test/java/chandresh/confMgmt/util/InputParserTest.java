package chandresh.confMgmt.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

import chandresh.confMgmt.talk.GeneralTalk;
import chandresh.confMgmt.talk.Talk;

public class InputParserTest {
/*	public static final String FILE_PATH= System.getProperty("user.dir")+"\\Input\\";
	@Test
	public void testValidInput(){
		List<Talk> expected = new ArrayList<Talk>();
		Talk t = new GeneralTalk();
		t.setDuration(5);
		t.setName("test 5min");
		expected.add(t);

		InputParser ip = new InputParser();
		List<Talk> l = ip.parseInput(new File(FILE_PATH+"parserValidInput.txt"));
		assertEquals(expected.get(0), l.get(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullInput() throws IllegalArgumentException{
		InputParser ip = new InputParser();
		ip.parseInput(null);
	}
	
	@Test
	public void testInvalidInput(){
		InputParser ip = new InputParser();
		List<Talk> l = ip.parseInput(new File(FILE_PATH+"parserInvalidInput.txt"));
		assertEquals(0, l.size());
	}
	
	@Test
	public void testMixedInput(){
		List<Talk> expected = new ArrayList<Talk>();
		
		Talk talk1 = new GeneralTalk();
		talk1.setDuration(10);
		talk1.setName("test minutes 10min");
		expected.add(talk1);
		
		Talk talk2 = new GeneralTalk();
		talk2.setDuration(5);
		talk2.setName("test lightning");
		expected.add(talk2);
		
		Talk talk3 = new GeneralTalk();
		talk3.setDuration(17);
		talk3.setName("17min");
		expected.add(talk3);
		
		InputParser ip = new InputParser();
		List<Talk> l = ip.parseInput(new File(FILE_PATH+"parserValidAndInvalid.txt"));
		assertEquals(expected.get(0), l.get(0));
		assertEquals(expected.get(1), l.get(1));
		assertEquals(expected.get(2), l.get(2));
		assertEquals(3, l.size());
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidFileFormat() throws IllegalArgumentException{
		InputParser ip = new InputParser();
		ip.parseInput(new File(FILE_PATH+"parserInvalidFormat.pdf"));
	}
	
	@Test
	public void testValidInputWithZeroDuration(){
		InputParser ip = new InputParser();
		List<Talk> l = ip.parseInput(new File(FILE_PATH+"parserZeroDuration.txt"));
		assertEquals(l.size(), 0);
	}
*/

	
	
}
