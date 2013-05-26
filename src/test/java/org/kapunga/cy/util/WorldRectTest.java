package org.kapunga.cy.util;

import static org.junit.Assert.*;

import org.bukkit.Location;
import org.bukkit.World;
import org.junit.Test;

public class WorldRectTest {
	private static final String worldNameOne = "tatooine";
	private static final String worldNameTwo = "endor";
	private static final World testWorldOne = new FakeWorld(worldNameOne);
	private static final World testWorldTwo = new FakeWorld(worldNameTwo);
	private static final Location testLocOne = new Location(testWorldOne, 0.0, 64.0, 0.0);
	private static final Location testLocTwo = new Location(testWorldTwo, 0.0, 64.0, 0.0);
	private static final Location testLocThree = new Location(testWorldTwo, 37.0, 64.0, 0.0);
	private static final Location testLocFour = new Location(testWorldTwo, 36.0, 64.0, -12.0);
	private static final Location testLocFive = new Location(testWorldTwo, 36.0, 64.0, 21.0);
	private static final Location testLocSix = new Location(testWorldTwo, 36.0, 64.0, 20.0);
	private static final int testX = 5;
	private static final int testZ = -11;
	private static final int testH = 32;
	private static final int testW = 32;

	@Test
	public void testBasic() {
		WorldRect testWorldRect = new WorldRect(worldNameOne, testX, testZ, testH, testW);
		
		assertTrue(testWorldRect.getWorldName().equals(worldNameOne));
		assertFalse(testWorldRect.getWorldName().equals(worldNameTwo));
		
		assertTrue(testWorldRect.isInWorld(testWorldOne));
		assertTrue(testWorldRect.isInWorld(worldNameOne));

		assertFalse(testWorldRect.isInWorld(testWorldTwo));
		assertFalse(testWorldRect.isInWorld(worldNameTwo));
		
		assertTrue(testWorldRect.getMinX() == testX);
		assertTrue(testWorldRect.getMaxX() == testX + testH);
		assertTrue(testWorldRect.getMinZ() == testZ);
		assertTrue(testWorldRect.getMaxZ() == testZ + testW);
		
		assertFalse(testWorldRect.getMinX() == testX + 1);
		assertFalse(testWorldRect.getMaxX() == testX + testH + 1);
		assertFalse(testWorldRect.getMinZ() == testZ + 1);
		assertFalse(testWorldRect.getMaxZ() == testZ + testW + 1);
	}
	
	@Test
	public void testLocations() {
		WorldRect testWorldRect = new WorldRect(worldNameTwo, testX, testZ, testH, testW);
		
		assertFalse(testWorldRect.contains(testLocOne));
		assertFalse(testWorldRect.contains(testLocTwo));
		assertFalse(testWorldRect.contains(testLocThree));
		assertFalse(testWorldRect.contains(testLocFour));
		assertFalse(testWorldRect.contains(testLocFive));
		assertTrue(testWorldRect.contains(testLocSix));
	}

}
