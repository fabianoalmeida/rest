package com.nasa.rest.constants;

public enum Orientation {

	NORTH ( "N" ),
	SOUTH ( "S" ),
	EAST  ( "E" ),
	WEST  ( "W" );
	
	private final String letter;
	
	Orientation( String letter ) {
		this.letter = letter;
	}
	
	public String value() { 
		return letter;
	}
}
