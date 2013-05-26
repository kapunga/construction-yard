package org.kapunga.cy.zone;

import static org.junit.Assert.*;

import org.bukkit.World;
import org.junit.Test;
import org.kapunga.cy.util.FakeWorld;
import org.kapunga.cy.util.WorldRect;

public class ZoneTest {
	public static final String testOwner="luke";
	public static final String testPlayerOne="c3p0";
	public static final String testPlayerTwo="r2d2";
	public static final String worldNameOne="endor";
	public static final String worldNameTwo="tatooine";
	public static final World testWorldOne = new FakeWorld(worldNameOne);
	public static final World testWorldTwo = new FakeWorld(worldNameTwo);
	public static final WorldRect testRectOne = new WorldRect(worldNameOne, 0, 0, 32, 32);
	public static final WorldRect testRectTwo = new WorldRect(worldNameTwo, 0, 0, 32, 32);

	/**
	 * Test basic functionality of the zone.
	 */
	@Test
	public void basicTest() {
		Zone testZone = new Zone(testRectOne, testOwner);
		assertEquals(worldNameOne, testZone.getWorldName());
		assertFalse(worldNameTwo.equals(testZone.getWorldName()));
		assertTrue(testZone.isInWorld(worldNameOne));
		assertFalse(testZone.isInWorld(worldNameTwo));
		assertTrue(testZone.isInWorld(testWorldOne));
		assertFalse(testZone.isInWorld(testWorldTwo));
		
		assertEquals(testOwner, testZone.getOwnerName());
		assertFalse(testPlayerOne.equals(testZone.getOwnerName()));
		assertTrue(testZone.isOwnedBy(testOwner));
		assertFalse(testZone.isOwnedBy(testPlayerOne));
	}

	@Test
	public void testBuilders() {
		Zone testZone = new Zone(testRectOne, testOwner);

		assertTrue(testZone.canBuildHere(testOwner));
		assertFalse(testZone.canBuildHere(testPlayerOne));
		assertFalse(testZone.canBuildHere(testPlayerTwo));
		
		assertFalse(testZone.addBuilder(testOwner));
		assertTrue(testZone.addBuilder(testPlayerOne));
		assertFalse(testZone.addBuilder(testPlayerOne));
		
		assertTrue(testZone.canBuildHere(testOwner));
		assertTrue(testZone.canBuildHere(testPlayerOne));
		assertFalse(testZone.canBuildHere(testPlayerTwo));
		
		assertFalse(testZone.removeBuilder(testOwner));
		assertTrue(testZone.removeBuilder(testPlayerOne));
		assertFalse(testZone.removeBuilder(testPlayerOne));
		
		assertTrue(testZone.canBuildHere(testOwner));
		assertFalse(testZone.canBuildHere(testPlayerOne));
		assertFalse(testZone.canBuildHere(testPlayerTwo));				
	}
}
