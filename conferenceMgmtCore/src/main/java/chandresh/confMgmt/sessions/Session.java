package chandresh.confMgmt.sessions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import chandresh.confMgmt.talk.Talk;

public abstract class Session {
	private List<Talk> sessionTalk = new ArrayList<Talk>();
	
	public static final int HOUR_START_INDEX=0;
	public static final int HOUR_END_INDEX=1;
	
	public static final int MINUTES_START_INDEX=2;
	public static final int MINUTES_END_INDEX=3;
	
	public static final int MINUTES_PER_HOUR=60;
	public static final String REGEX_TIME_FORMAT_24HRS="([01]?[0-9]|2[0-3])[0-5][0-9]";
	
	

	public List<Talk> getSessionTalk() {
		return sessionTalk;
	}
	
	/**
	 * @param lastTalkStartTime
	 * @param lastTalkDuration
	 * @return String start time of the current talk based on the end time of last scheduled talk
	 */
	public String getStartTimeOfCurrentTalk(String lastTalkStartTime, int lastTalkDuration){
		
		int startHrs = Integer.parseInt(lastTalkStartTime.substring(HOUR_START_INDEX, HOUR_END_INDEX+1)) * MINUTES_PER_HOUR;
		int startMin = Integer.parseInt(lastTalkStartTime.substring(MINUTES_START_INDEX, MINUTES_END_INDEX+1));
		
		//Calculate start time of current talk in 24Hrs format
		String startTime = String.format("%02d",(startHrs + startMin + lastTalkDuration) / MINUTES_PER_HOUR)
				+ String.format("%02d",(startHrs + startMin + lastTalkDuration) % MINUTES_PER_HOUR);
		
		return startTime;

	}

	/**
	 * @param startTime
	 * @param endTime
	 * @return true if the startTime and endTime matches 24HRS format and startTime<endTime. 
	 * 			False otherwise
	 */
	public boolean validateTime(String startTime, String endTime) {
		if (startTime == null || endTime == null)
			return false;

		Pattern pattern;
		Matcher startMatcher, endMatcher;
		
		//Regex for 24HRS format
		//String timePattern = ;
		pattern = Pattern.compile(REGEX_TIME_FORMAT_24HRS);
		startMatcher = pattern.matcher(startTime);
		endMatcher = pattern.matcher(endTime);
		if (!startMatcher.matches() || !endMatcher.matches()
				|| Integer.parseInt(startTime) > Integer.parseInt(endTime)){
			//print("Invalid start and end time. Start Time: "+startTime +" and End Time: "+endTime);
			return false;
		}
			

		return true;
	}
	
	public int getAvailableTimeInMinutes(String startTime, String endTime) {
		int startHrs = Integer.parseInt(startTime.substring(HOUR_START_INDEX, HOUR_END_INDEX+1));
		int startMin = Integer.parseInt(startTime.substring(MINUTES_START_INDEX, MINUTES_END_INDEX+1));
		
		int endHrs = Integer.parseInt(endTime.substring(HOUR_START_INDEX, HOUR_END_INDEX+1));
		int endtMin = Integer.parseInt(endTime.substring(MINUTES_START_INDEX, MINUTES_END_INDEX+1));
		
		return ((endHrs*MINUTES_PER_HOUR)+endtMin)-((startHrs*MINUTES_PER_HOUR)+startMin);
	}


	/**
	 * @param allTalks
	 * @param availableTimeInMins
	 * @param startTime
	 * 
	 * Find exact match using subset sum problem. 
	 * if exact match found then it schedule those talks in session.
	 * Otherwise it tries to find the best possible match
	 */
	public void schedule(List<Talk> allTalks, int availableTimeInMins, String startTime) {

		
		//Find exact match using subset sum problem
		boolean subsetArr[][] = new boolean[allTalks.size()][availableTimeInMins + 1];
		for (int i = 0; i < allTalks.size(); i++) {
			subsetArr[i][0] = true;
		}
		subsetArr[0][allTalks.get(0).getDuration()]=true;
		for (int i = 1; i < allTalks.size(); i++) {
			for (int j = 1; j <= availableTimeInMins; j++) {
				if (j - allTalks.get(i).getDuration() >= 0) {
					subsetArr[i][j] = subsetArr[i - 1][j]
							|| subsetArr[i - 1][j - allTalks.get(i).getDuration()];
				} else {
					subsetArr[i][j] = subsetArr[i - 1][j];
				}
			}
		}
		
		if (subsetArr[allTalks.size()-1][availableTimeInMins]) {
			scheduleExactMatch(allTalks,availableTimeInMins,subsetArr,startTime);
		}else{
			scheduleBestPossibleMatch(allTalks,availableTimeInMins,startTime);
		}

	}

	/**
	 * @param allTalks
	 * @param availableTimeInMins
	 * @param startTime
	 * 
	 * Tries to schedule as much talks possible in  availableTimeInMins
	 * 
	 */
	private void scheduleBestPossibleMatch(List<Talk> allTalks,
			int availableTimeInMins, String startTime) {
		
		//Sort the talk in ascending order as per their duration
		Collections.sort(allTalks, new Comparator<Talk>() {
			@Override
			public int compare(Talk o1, Talk o2) {
				return o1.getDuration()-o2.getDuration();
			}
		});
		
		int consumedMins = 0;
		List<Talk> leftOverTalks = new ArrayList<Talk>();
		for(Talk eachTalk : allTalks){
			
			if(consumedMins+eachTalk.getDuration()<=availableTimeInMins){
				consumedMins+=eachTalk.getDuration();
				eachTalk.setStartTime(startTime);
				sessionTalk.add(eachTalk);

				startTime = getStartTimeOfCurrentTalk(startTime, eachTalk.getDuration());
				
			}else{
				leftOverTalks.add(eachTalk);
			}
		}
		allTalks.clear();
		allTalks.addAll(leftOverTalks);		
	}

	
	/**
	 * @param allTalks
	 * @param availableTimeInMins
	 * @param subsetArr
	 * @param startTime
	 * 
	 * Schedule talks, which are result of subset sum solution, in availableTimeInMins
	 */
	private void scheduleExactMatch(List<Talk> allTalks, int availableTimeInMins, boolean[][] subsetArr, String startTime) {
		int tempRow = subsetArr.length-1;
		int tempCol = subsetArr[0].length-1;
		List<Talk> leftOverTalks = new ArrayList<Talk>();
		
		//
		while(tempRow>=0 && tempCol>=0){
			if(tempRow==0){
				
				if(tempCol==0){
					leftOverTalks.add(allTalks.get(0));
					break;
				}
				if(subsetArr[tempRow][tempCol-allTalks.get(tempRow).getDuration()])
					allTalks.get(tempRow).setStartTime(startTime);
					sessionTalk.add(allTalks.get(tempRow));
					startTime = getStartTimeOfCurrentTalk(startTime, allTalks.get(tempRow).getDuration());
				break;
			}
			
			if(subsetArr[tempRow-1][tempCol]){
				leftOverTalks.add(allTalks.get(tempRow));
				tempRow--;
			}else{
				allTalks.get(tempRow).setStartTime(startTime);
				sessionTalk.add(allTalks.get(tempRow));
				startTime = getStartTimeOfCurrentTalk(startTime, allTalks.get(tempRow).getDuration());
				tempCol-=allTalks.get(tempRow).getDuration();
				tempRow--;
			}
		}
		allTalks.clear();
		allTalks.addAll(leftOverTalks);
	}

	/**
	 * @param allTalks
	 * @return Session
	 * To be implemented by the concrete implementing class.
	 */
	public abstract Session scheduleSession(List<Talk> allTalks);

	public List<String> print() {
		List<String> result = new ArrayList<String>();
		
		for(Talk eachTalk:this.sessionTalk){
			result.add(eachTalk.print());
		}
		return result;
		
	}

}
