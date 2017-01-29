package com.nasa.rest.config;

import com.nasa.rest.model.Robot;
import com.nasa.rest.model.Terrain;

public class Test {

	public static void main(String[] args) {

		Robot robot = Robot.build();
		robot.move( "MLM", Terrain.build() );
		
		System.out.println( robot.position() );
	}
}
