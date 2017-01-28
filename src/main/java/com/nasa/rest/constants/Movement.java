package com.nasa.rest.constants;

public enum Movement {

	LEFT  ( "L" ),
	RIGHT ( "R" ),
	MOVE  ( "M" );
	
	private final String letter;
	
	Movement( String letter ) {
		this.letter = letter;
	}
	
	public String value() { 
		return letter;
	}
	
	public static boolean contains( String letter ) {
		
		for ( Movement movement : values() ) {
			if ( movement.value().equalsIgnoreCase( letter ) ) {
				return true;
			}
		}
		
		return false;
	}
	
}
