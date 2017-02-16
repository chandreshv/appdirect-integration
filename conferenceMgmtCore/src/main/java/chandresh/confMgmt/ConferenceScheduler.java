package chandresh.confMgmt;

import static chandresh.confMgmt.util.Printer.printOnConsole;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import chandresh.confMgmt.conference.Conference;
import chandresh.confMgmt.dto.ConferenceData;
import chandresh.confMgmt.dto.ConferenceStatus;
import chandresh.confMgmt.dto.SchedulerResponse;
import chandresh.confMgmt.talk.Talk;
import chandresh.confMgmt.util.InputParser;

@Component
public class ConferenceScheduler implements IConferenceScheduler {

	public SchedulerResponse schedule(List<String> input)
			throws IllegalArgumentException {
		printOnConsole("Request recieved");
		if (input == null)
			throw new IllegalArgumentException(
					"Invalid Input. Please provide valid input file");

		List<Talk> allTalksList = new InputParser().getAllTalkList(input);
		
		Conference conf = new Conference().create(allTalksList);
		ConferenceData.addNewConferenceById(conf);
	//	 new WriteOutput().writeOutputToFile(conf,input.getName());
		printOnConsole("Request completed");
		
		//Build Response
		SchedulerResponse response = new SchedulerResponse();
		response.buildSchedulerResponse(ConferenceStatus.OK,"Conference scheduled successully with id: "+ conf.getConfId());
		return response;
	}

	@Override
	public List<String> getConferenceDetailsById(int id)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Conference conference = ConferenceData.getConferenceById(id);
		List<String> result = new ArrayList<String>();
		if(conference!=null)
			result = conference.print();
		return result;
	}

	@Override
	public SchedulerResponse updateConferenceDetailsById(int id, List<String> input)
			throws IllegalArgumentException {
		if(ConferenceData.getConferenceById(id)==null)
			throw new IllegalArgumentException(
					"Invalid Input. No conference exist with given ID");
		
		ConferenceData.removeConferenceById(id);
		
		List<Talk> allTalksList = new InputParser().getAllTalkList(input);
		
		Conference conf = new Conference().create(allTalksList, id);
		ConferenceData.addNewConferenceById(conf);

		//Build Response
		SchedulerResponse response = new SchedulerResponse();
		response.buildSchedulerResponse(ConferenceStatus.OK,"Conference scheduled successully");
		return response;
	}

	@Override
	public SchedulerResponse deleteConferenceDetailsById(int id)
			throws IllegalArgumentException {
		if(ConferenceData.getConferenceById(id)==null)
			throw new IllegalArgumentException(
					"Invalid Input. No conference exist with given ID");
		
		ConferenceData.removeConferenceById(id);
		//Build Response
		SchedulerResponse response = new SchedulerResponse();
		response.buildSchedulerResponse(ConferenceStatus.OK,"Conference scheduled successully");
		return response;
	}

	@Override
	public List<List<String>> getAllConferenceDetails()
			throws IllegalArgumentException {
		List<List<String>> result = new ArrayList<List<String>>() ;
		for(Conference each:ConferenceData.getAllConferenceDetails()){
			result.add(each.print());
		}
		
		return result;
	}

}
