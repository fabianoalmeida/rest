package com.nasa.rest.model;

public class Terrain {

	private int[][] dimension;
	
	private Terrain() {
		this.dimension = new int[5][5];
	}
	
	public static Terrain build() {
		return new Terrain();
	}
	
	public boolean exists( int value ) {
		
		if ( value < 0 || dimension.length < value) 
			return false;
		
		return true;
	}
}
