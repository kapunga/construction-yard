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
package org.kapunga.cy;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This is the base class for the Construction Yard plugin.  It handles all of the
 * setup and configuration.
 * 
 * @author kapunga
 *
 */
public final class ConstructionYard extends JavaPlugin {
	// Strings to access the different settings in config.yml
	public static final String EN_SCAFFOLDING = "con_yard.modules.scaffolding";
	public static final String EN_FLYING = "con_yard.modules.flying";
	public static final String EN_WARPS = "con_yard.modules.warps";
	public static final String EN_FALL_MITIGATION = "con_yard.modules.fall_mitigation";
	public static final String EN_CONSTRUCTION_CHESTS = "con_yard.modules.chests";
	public static final String ZONE_RADIUS = "con_yard.con_zone.radius";
	public static final String NUM_ZONES = "con_yard.con_zone.num_zones";
	public static final String MAX_FALL = "con_yard.con_zone.max_fall";
	
	// Strings for the different permissions in plugin.yml
	public static final String PERM_BASIC = "conyard.basic";
	public static final String PERM_ADMIN = "conyard.admin";
	public static final String PERM_SCAFFOLDING = "conyard.scaffolding";
	public static final String PERM_FLYING = "conyard.flying";
	public static final String PERM_WARP = "conyard.warp";
	public static final String PERM_CHEST = "conyard.chest";
	
	@Override
	public void onEnable() {
	}
	
	@Override
	public void onDisable() {

	}
}
