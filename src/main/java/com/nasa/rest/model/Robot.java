package com.nasa.rest.model;

import javax.ws.rs.ForbiddenException;

import com.nasa.rest.constants.Movement;
import com.nasa.rest.constants.Orientation;

public class Robot {

	private int xAxis;
	
	private int yAxis;
	
	private Orientation orientation;
	
	private Robot() {
		this( 0, 0, Orientation.NORTH );
	}
	
	private Robot( int xAxis, int yAxis, Orientation orientation ) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.orientation = orientation;
	}
	
	public void move( String movement, Terrain terrain ) {
		
		String[] movementChar = movement.split("");
		
		for ( String letter : movementChar ) {
			
			if ( letter.equalsIgnoreCase( Movement.MOVE.value() )  ) {
			
				validateMovement( terrain );
				updatePosition();
			
			} else if ( letter.equalsIgnoreCase( Movement.LEFT.value() )  ) {
				
				turnLeft();
				
			} else {
				
				turnRight();
			}
		}
	}
	
	private void validateMovement( Terrain terrain ) {
		
		if ( orientation.equals( Orientation.NORTH ) ) {
			
			if ( ! terrain.exists( yAxis + 1 ) ) {
				throw new ForbiddenException();
			}
			
		} else if ( orientation.equals( Orientation.SOUTH ) ) {

			if ( ! terrain.exists( yAxis - 1 ) ) {
				throw new ForbiddenException();
			}
		
		} else if ( orientation.equals( Orientation.EAST ) ) {

			if ( ! terrain.exists( xAxis + 1 ) ) {
				throw new ForbiddenException();
			}

		} else if ( orientation.equals( Orientation.WEST ) ) {

			if ( ! terrain.exists( xAxis - 1 ) ) {
				throw new ForbiddenException();
			}
		}
	}
	
	private void updatePosition() {
		
		if ( orientation.equals( Orientation.NORTH ) ) {
			yAxis = yAxis + 1;
		
		} else if ( orientation.equals( Orientation.SOUTH ) ) {
			yAxis = yAxis - 1;
		
		} else if ( orientation.equals( Orientation.EAST ) ) {
			xAxis = xAxis + 1;

		} else if ( orientation.equals( Orientation.WEST ) ) {
			xAxis = xAxis - 1;
		}
	}

	private void turnLeft() {
		
		if ( orientation.equals( Orientation.NORTH ) ) {
			orientation = Orientation.WEST;
		
		} else if ( orientation.equals( Orientation.SOUTH ) ) {
			orientation = Orientation.EAST;
		
		} else if ( orientation.equals( Orientation.EAST ) ) {
			orientation = Orientation.NORTH;

		} else if ( orientation.equals( Orientation.WEST ) ) {
			orientation = Orientation.SOUTH;
		}
	}
	
	private void turnRight() {
		
		if ( orientation.equals( Orientation.NORTH ) ) {
			orientation = Orientation.EAST;
		
		} else if ( orientation.equals( Orientation.SOUTH ) ) {
			orientation = Orientation.WEST;
		
		} else if ( orientation.equals( Orientation.EAST ) ) {
			orientation = Orientation.SOUTH;

		} else if ( orientation.equals( Orientation.WEST ) ) {
			orientation = Orientation.NORTH;
		}
	}
	
	public String position() {
		return String.format( "(%d,%d,%s)", xAxis, yAxis, orientation.value() );
	}
	
	public static Robot build() {
		return new Robot();
	}
	
}
