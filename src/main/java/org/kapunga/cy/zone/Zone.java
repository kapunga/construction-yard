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

/**
 * This class represents the core data object of the Contruction Yard plugin.
 * 
 * @author kapunga
 *
 */
public class Zone {
	// The name of the world this Construction Zone is in.
	private transient final String worldName;
	
	// The name of the owner of this Construction Zone.
	private transient final String playerName;
	
	public Zone(final String worldName_, final String playerName_) {
		this.worldName = worldName_;
		this.playerName = playerName_;
	}
	
	public String getWorldName() { return worldName; }
	
	public boolean isInWorld(final String world) { return worldName.equals(world); }
	
	public String getPlayerName() { return playerName; }
	
	public boolean isOwnedBy(final String player) { return playerName.equals(player); }
}
