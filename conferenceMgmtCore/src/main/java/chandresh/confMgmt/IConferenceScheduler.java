package chandresh.confMgmt;

import java.util.List;

import chandresh.confMgmt.dto.SchedulerResponse;

public interface IConferenceScheduler {

	public SchedulerResponse schedule(List<String> input) throws IllegalArgumentException;
	public List<String> getConferenceDetailsById(int id) throws IllegalArgumentException;
	public List<List<String>> getAllConferenceDetails() throws IllegalArgumentException;
	public SchedulerResponse updateConferenceDetailsById(int id,List<String> input) throws IllegalArgumentException;
	public SchedulerResponse deleteConferenceDetailsById(int id) throws IllegalArgumentException;
}
