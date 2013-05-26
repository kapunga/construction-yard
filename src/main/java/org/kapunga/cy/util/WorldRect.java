package org.kapunga.cy.util;

import org.bukkit.Location;
import org.bukkit.World;

public class WorldRect {
	private final String worldName;
	private final int x,z;
	private final int h,w;

	public WorldRect(final String worldName_, final int x_, final int z_, final int h_, final int w_) {
		this.worldName = worldName_;
		this.x = x_;
		this.z = z_;
		this.h = h_;
		this.w = w_;
	}
	
	public String getWorldName() { return worldName; }
	
	public int getMinX() { return x; }
	
	public int getMaxX() { return x + h; }
	
	public int getMinZ() { return z; }
	
	public int getMaxZ() { return z + w; }
	
	public boolean isInWorld(World world) { return world.getName().equals(this.worldName); }
	
	public boolean isInWorld(String world) { return world.equals(this.worldName); }
	
	public boolean contains(Location loc) {
		if (loc.getWorld().getName().equals(worldName)) {
			if (loc.getBlockX() > x && loc.getBlockX() < x + h) {
				if (loc.getBlockZ() > z && loc.getBlockZ() < z + w) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
