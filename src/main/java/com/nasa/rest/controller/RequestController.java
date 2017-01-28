package com.nasa.rest.controller;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nasa.rest.constants.Movement;
import com.nasa.rest.model.Robot;
import com.nasa.rest.model.Terrain;

@Path("/")
public class RequestController {

	private Robot robot;
	
	@POST
	@Path("/")
	@Produces( MediaType.TEXT_PLAIN )
	public String robot() {
		return robots( null );
	}
	
	@POST
	@Path("/{command}")
	@Produces( MediaType.TEXT_PLAIN )
	public String robots( @PathParam("command") String command ) {
		
		try {

			validateCommand( command );
			
			if ( robot == null ) {
				robot = Robot.build();
			}
			
			robot.move( command.toUpperCase(), Terrain.build() );
			
			Response.status( Response.Status.OK ).build();
			
			return robot.position();
			
		} catch( BadRequestException ex ) {
			Response.status( Response.Status.BAD_REQUEST ).build();
			return ex.getMessage();
		
		} catch( NotAcceptableException ex ) {
			Response.status( Response.Status.NOT_ACCEPTABLE ).build();
			return ex.getMessage();
			
		} catch( ForbiddenException ex ) {
			Response.status( Response.Status.FORBIDDEN ).build();
			return ex.getMessage();
		}
	}

	private void validateCommand( String command ) throws BadRequestException {
		
		if ( command == null
				|| command.isEmpty() 
				|| command.equalsIgnoreCase("") ) {
			
			throw new BadRequestException();
		}
		
		String[] commandChar = command.toUpperCase().split("");
		
		for ( String movement : commandChar ) {
			if ( ! Movement.contains( movement ) ) {
				throw new NotAcceptableException();
			}
		}		
	}
}
