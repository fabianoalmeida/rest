package com.nasa.rest.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import com.nasa.rest.model.Robot;
import com.nasa.rest.model.Terrain;

public class RobotTest {

	@Test
	public void testNewRobotPosition() {
		Robot robot = Robot.build();
		assertEquals( "(0,0,N)", robot.position() );
	}

	@Test
	public void testNewRobotNotEqualPosition() {
		Robot robot = Robot.build();
		assertNotSame( "(1,1,S)", robot.position() );
	}
	
	@Test
	public void testValidMovementWithLowerCaseCommand() {
		Robot robot = Robot.build();
		robot.move( "mmrmmrmmr", Terrain.build() );
		assertNotSame( "(2,0,W)", robot.position() );
	}

	@Test
	public void testValidMovementWithUpperCaseCommand() {
		Robot robot = Robot.build();
		robot.move( "MMRMMRMMR", Terrain.build() );
		assertNotSame( "(2,0,W)", robot.position() );
	}

	@Test( expected = RuntimeException.class )
	public void testInvalidMovementEmptyCommand() {
		Robot robot = Robot.build();
		robot.move( "", Terrain.build() );
	}

	@Test( expected = RuntimeException.class )
	public void testInvalidMovementNullCommand() {
		Robot robot = Robot.build();
		robot.move( null, Terrain.build() );
	}
	
	@Test( expected = RuntimeException.class )
	public void testInvalidMovementLetterLowerCaseCommand() {
		Robot robot = Robot.build();
		robot.move( "aaaaaaaa", Terrain.build() );
	}

	@Test( expected = RuntimeException.class )
	public void testInvalidMovementLetterUpperCaseCommand() {
		Robot robot = Robot.build();
		robot.move( "AAAAAAAA", Terrain.build() );
	}

	@Test
	public void testValidMovementLetterWithFiveMoves() {
		Robot robot = Robot.build();
		robot.move( "MMMMM", Terrain.build() );
	}
	
	@Test( expected = RuntimeException.class )
	public void testValidMovementLetterWithInvalidNumberOfMovements() {
		Robot robot = Robot.build();
		robot.move( "MMMMMM", Terrain.build() );
	}

	@Test( expected = RuntimeException.class )
	public void testValidMovementLetterWithInvalidNumberOfMovementsAndTurnLeft() {
		Robot robot = Robot.build();
		robot.move( "MMLM", Terrain.build() );
	}

	@Test( expected = RuntimeException.class )
	public void testValidMovementLetterWithInvalidNumberOfMovementsAndTurnRight() {
		Robot robot = Robot.build();
		robot.move( "MMRMRMMMMRMRMRM", Terrain.build() );
	}

	@Test( expected = RuntimeException.class )
	public void testValidMovementLetterWithInvalidNumberOfMovementsAndTurnRightAndTurnLeft() {
		Robot robot = Robot.build();
		robot.move( "MMRMLMMMMRMRMRM", Terrain.build() );
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void testValidMovementWithNullTerrain() {
		Robot robot = Robot.build();
		robot.move( "MMRMMRMMR", null );
	}
	
}
