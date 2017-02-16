package org.conferenceMgmtService.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import chandresh.confMgmt.dto.ConferenceStatus;
import chandresh.confMgmt.dto.SchedulerResponse;

@Provider
public class ExceptionBuilder implements ExceptionMapper<IllegalArgumentException> {

	@Override
	public Response toResponse(IllegalArgumentException arg0) {
		SchedulerResponse response = new SchedulerResponse();
		response.buildSchedulerResponse(ConferenceStatus.NOK,arg0.getMessage());
		return Response.status(Status.BAD_REQUEST).entity(response).build();
	}

}
