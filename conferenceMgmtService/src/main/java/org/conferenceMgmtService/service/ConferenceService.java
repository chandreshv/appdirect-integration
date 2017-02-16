package org.conferenceMgmtService.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chandresh.confMgmt.IConferenceScheduler;
import chandresh.confMgmt.UserConfig;
import chandresh.confMgmt.dto.SchedulerResponse;


@Path("/conference")
public class ConferenceService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public SchedulerResponse scheduleConference(List<String> input) throws Exception{
		if(input==null)
			throw new IllegalArgumentException("Invalid Input");
		
		IConferenceScheduler ic = null;
		try(AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(UserConfig.class);)
		{
			ic = ac.getBean(IConferenceScheduler.class);
		}
		return ic.schedule(input);
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getConferenceDetailsById(@PathParam("id") int id) throws Exception{
		if(id<=0)
			throw new IllegalArgumentException("Invalid Input");
		
		IConferenceScheduler ic = null;
		try(AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(UserConfig.class);)
		{
			ic = ac.getBean(IConferenceScheduler.class);
		}
		return ic.getConferenceDetailsById(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<List<String>> getAllConferenceDetails() throws Exception{

		IConferenceScheduler ic = null;
		try(AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(UserConfig.class);)
		{
			ic = ac.getBean(IConferenceScheduler.class);
		}
		return ic.getAllConferenceDetails();
	}
	
	@Path("/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public SchedulerResponse updateConferenceDetailsById(@PathParam("id") int id, List<String> input) throws Exception{
		if(input==null)
			throw new IllegalArgumentException("Invalid Input");
		
		IConferenceScheduler ic = null;
		try(AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(UserConfig.class);)
		{
			ic = ac.getBean(IConferenceScheduler.class);
		}
		return ic.updateConferenceDetailsById(id, input);
	}
	
	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public SchedulerResponse updateConferenceDetailsById(@PathParam("id") int id) throws Exception{
		IConferenceScheduler ic = null;
		try(AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(UserConfig.class);)
		{
			ic = ac.getBean(IConferenceScheduler.class);
		}
		return ic.deleteConferenceDetailsById(id);
	}
	
	
	
}
