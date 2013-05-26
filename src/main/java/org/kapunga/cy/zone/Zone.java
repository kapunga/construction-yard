/**
 *  Construction Yard - A bukkit plugin for assisting hardcore builders
 *  Copyright (C) Mar 11, 2013  Paul J Thordarson a.k.a. kapunga
 *  Email: kapunga@gmail.com
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kapunga.cy.zone;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.kapunga.cy.util.WorldRect;

/**
 * This class represents the core data object of the Contruction Yard plugin.
 * 
 * @author kapunga
 *
 */
public class Zone {
	// The name of the world this Construction Zone is in.
	private final transient WorldRect worldRect;
	
	// The name of the owner of this Construction Zone.
	private final transient String ownerName;
	
	// A list of people who are allowed to build in this Construction Zone.
	private final transient List<String> coBuilders = new ArrayList<String>();
	
	/**
	 * This is the Constructor for the Zone class.
	 * @param worldName_
	 * @param ownerName_
	 */
	public Zone(final WorldRect worldRect_, final String ownerName_) {
		this.worldRect = worldRect_;
		this.ownerName = ownerName_;
	}
	
	/**
	 * Returns name of the world this zone is in.
	 * @return The name of the world this zone is in.
	 */
	public String getWorldName() { return worldRect.getWorldName(); }
	
	/**
	 * Check to see if this zone is in a given world.
	 * @param worldName - The world we are checking.
	 * @return true if the parameter "world" matches the world this zone is in,
	 * otherwise false.
	 */
	public boolean isInWorld(final String worldName) { return worldRect.isInWorld(worldName); }
	
	/**
	 * Check to see if this zone is in a given world.
	 * @param world - The world we are checking.
	 * @return true if the parameter "world" matches the world this zone is in,
	 * otherwise false.
	 */
	public boolean isInWorld(final World world) { return worldRect.isInWorld(world); }
	
	/**
	 * Get's the name of the owner of this zone.
	 * @return The name of the Zone's owner.
	 */
	public String getOwnerName() { return ownerName; }
	
	/**
	 * Check's if this Zone is owned by a particular Player
	 * @param owner
	 * @return true if the parameter "owner" matches the owner of this zone,
	 * otherwise false.
	 */
	public boolean isOwnedBy(final String owner) { return ownerName.equals(owner); }
	
	/**
	 * Adds an allowed builder to this zone.
	 * @param builder The builder to add to this zone.
	 * @return true if the builder was added, false if the builder was already added
	 * or if "builder" matches the owner of this Zone.
	 */
	public boolean addBuilder(final String builder) {
		if (ownerName.equals(builder)) {
			// TODO: Throw IllegalArgumentException here. 
			return false;
		} else if (coBuilders.contains(builder)) {
			return false;
		} else {
			coBuilders.add(builder);
			return true;
		}
	}

	/**
	 * Removes an allowed builder from this zone.
	 * @param builder The builder to remove from this zone.
	 * @return true if the builder was removed, false if the builder was not allowed already
	 * or if "builder" matches the owner of this Zone.
	 */
	public boolean removeBuilder(final String builder) {
		if (ownerName.equals(builder)) {
			// TODO: Throw IllegalArgumentException here. 
			return false;
		} else if (coBuilders.contains(builder)) {
			coBuilders.remove(builder);
			return true;
		} else {
			return false;
		}	
	}
	
	/**
	 * Checks if a person is allowed to build in this Zone.
	 * @param builder The name of the player we are checking.
	 * @return true if the player can build her, false otherwise.
	 */
	public boolean canBuildHere(final String builder) {
		return ownerName.equals(builder) || coBuilders.contains(builder);
	}
}
