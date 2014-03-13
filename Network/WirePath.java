/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.ElectriCraft.Network;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.world.World;
import Reika.ElectriCraft.Auxiliary.ElectriNetworkTickEvent;
import Reika.ElectriCraft.Base.WiringTile;
import Reika.ElectriCraft.TileEntities.TileEntityGenerator;
import Reika.ElectriCraft.TileEntities.TileEntityMotor;
import Reika.ElectriCraft.TileEntities.TileEntityResistor;

public final class WirePath {

	private final LinkedList<WiringTile> nodes = new LinkedList();
	private final TileEntityGenerator start;
	private final TileEntityMotor end;
	private final WireNetwork net;

	public final int resistance;
	private final int currentLimit;

	public WirePath(World world, LinkedList<List<Integer>> points, TileEntityGenerator start, TileEntityMotor end, WireNetwork net) {
		int maxcurrent = Integer.MAX_VALUE;
		int r = 0;
		for (int i = 0; i < points.size(); i++) {
			List<Integer> li = points.get(i);
			int x = li.get(0);
			int y = li.get(1);
			int z = li.get(2);
			WiringTile te = (WiringTile)world.getBlockTileEntity(x, y, z);
			nodes.addLast(te);
			r += te.getResistance();
			if (te instanceof TileEntityResistor) {
				int max = te.getCurrentLimit();
				if (max < maxcurrent)
					maxcurrent = max;
			}
		}
		this.start = start;
		this.end = end;
		this.net = net;
		resistance = r;
		currentLimit = maxcurrent;
		//ReikaJavaLibrary.pConsole(points, Side.SERVER);
	}

	public int getLength() {
		return nodes.size();
	}

	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	public int getVoltageAt(WiringTile wire) {
		return start.getGenVoltage() > 0 ? start.getGenVoltage()-this.getResistanceTo(wire) : 0;
	}

	private int getResistanceTo(WiringTile wire) {
		return this.getResistanceTo(nodes.indexOf(wire));
	}

	private int getResistanceTo(int index) {
		int r = 0;
		for (int i = 0; i < index; i++) {
			WiringTile wire = nodes.get(i);
			r += wire.getResistance();
		}
		return r;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < nodes.size(); i++) {
			WiringTile w = nodes.get(i);
			sb.append("[");
			sb.append(w.xCoord);
			sb.append(":");
			sb.append(w.yCoord);
			sb.append(":");
			sb.append(w.zCoord);
			sb.append("]");
		}
		sb.append(">");
		return sb.toString();
	}

	public boolean containsBlock(WiringTile te) {
		return nodes.contains(te);
	}

	void tick(ElectriNetworkTickEvent evt) {
		//int current = this.getPathCurrent();

	}

	public boolean startsAt(int x, int y, int z) {
		return start.xCoord == x && y == start.yCoord && z == start.zCoord;
	}

	public boolean endsAt(int x, int y, int z) {
		return end.xCoord == x && y == end.yCoord && z == end.zCoord;
	}

	public int getTerminalVoltage() {
		int v = start.getGenVoltage() > 0 ? start.getGenVoltage()-this.getVoltageLoss() : 0;
		return v > 0 ? v : 0;
	}

	public int getVoltageLoss() {
		return resistance;
	}

	public boolean isLimitedCurrent() {
		return currentLimit < Integer.MAX_VALUE;
	}

	public int getPathCurrent() {
		ArrayList<WirePath> li = net.getPathsStartingAt(start);
		int total = start.getGenCurrent();
		int num = net.getNumberPathsStartingAt(start);
		int frac = total/num;
		int bonus = 0;
		int num2 = 0;
		for (int i = 0; i < li.size(); i++) {
			WirePath path = li.get(i);
			if (path.isLimitedCurrent()) {
				int max = path.currentLimit;
				if (max < frac) {
					bonus += frac-max;
				}
			}
			else
				num2++;
		}
		int frac2 = num2 > 0 ? bonus/num2 : 0;
		return this.isLimitedCurrent() ? Math.min(frac, currentLimit) : frac+frac2;
	}

}
