package chandresh.confMgmt.conference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import chandresh.confMgmt.Track.Track;
import chandresh.confMgmt.talk.Talk;

public class Conference {

	private List<Track> trackList = new ArrayList<Track>();
	private int confId;
	public List<Track> getTrackList() {
		return trackList;
	}
	
	public int getConfId(){
		return this.confId;
	}
	public Conference create(List<Talk> allTalks) {
		int id = Math.abs(new Random().nextInt());
		return create(allTalks,  id);
	}
	
	public Conference create(List<Talk> allTalks, int id) {
		this.confId = id;
		while (allTalks.size() > 0) {
			trackList.add(new Track().create(allTalks));
		}
		return this;
	}
	
	public List<String> print(){
		List<String> result = new ArrayList<String>();
		int trackNumber = 1;
		for(Track eachTrack:this.trackList){
			result.add(String.valueOf(trackNumber));
			result.addAll(eachTrack.print());
			trackNumber++;
		}
		return result;
		
	}

}
