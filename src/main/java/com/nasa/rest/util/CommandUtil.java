package com.nasa.rest.util;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAcceptableException;

import com.nasa.rest.constants.Movement;

public class CommandUtil {

	public static void validateCommand( String command ) {
		
		if ( command == null
				|| command.isEmpty() ) {
			
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
