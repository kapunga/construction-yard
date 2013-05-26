package org.kapunga.cy.zone;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZoneTest {
	public static final String testPlayerOne="luke";
	public static final String testPlayerTwo="c3p0";
	public static final String testWorldOne="endor";
	public static final String testWorldTwo="tatooine";

	@Test
	public void basicTest() {
		Zone testZone = new Zone(testWorldOne, testPlayerOne);
		assertEquals(testWorldOne, testZone.getWorldName());
		assertFalse(testWorldTwo.equals(testZone.getWorldName()));
		assertTrue(testZone.isInWorld(testWorldOne));
		assertFalse(testZone.isInWorld(testWorldTwo));
		
		assertEquals(testPlayerOne, testZone.getPlayerName());
		assertFalse(testPlayerTwo.equals(testZone.getPlayerName()));
		assertTrue(testZone.isOwnedBy(testPlayerOne));
		assertFalse(testZone.isOwnedBy(testPlayerTwo));
	}

}
