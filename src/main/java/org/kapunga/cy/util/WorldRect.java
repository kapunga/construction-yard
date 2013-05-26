package org.kapunga.cy.util;

import org.bukkit.Location;
import org.bukkit.World;

public class WorldRect {
	private final transient String worldName;
	private final transient int x,z;
	private final transient int h,w;

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
	
	public boolean isInWorld(final World world) { return world.getName().equals(this.worldName); }
	
	public boolean isInWorld(final String world) { return world.equals(this.worldName); }
	
	public boolean contains(final Location loc) {
		if (loc.getWorld().getName().equals(worldName)) {
			if (loc.getBlockX() > x && loc.getBlockX() < x + h) {
				return loc.getBlockZ() > z && loc.getBlockZ() < z + w;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
