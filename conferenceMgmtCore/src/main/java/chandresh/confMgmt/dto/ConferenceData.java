package chandresh.confMgmt.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import chandresh.confMgmt.conference.Conference;

public class ConferenceData {

	private static Map<Integer, Conference> conferenceData = new HashMap<>();
	
	public static Conference getConferenceById(int id){
		return conferenceData.get(id);
	}
	
	public static Conference addNewConferenceById(Conference conf){
		return conferenceData.put(conf.getConfId(),conf);
	}
	
	public static Conference removeConferenceById(int id){
		return conferenceData.remove(id);
	}
	
	public static List<Conference> getAllConferenceDetails(){
		List<Conference> conferenceList = new ArrayList<Conference>();
		
		for(Entry<Integer, Conference> each: conferenceData.entrySet()){
			conferenceList.add(each.getValue());
		}
		
		return conferenceList;
	}
	
}
