package com.demo.FFM;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

public class TwoPointDistance {

	public class PointTwoDimensional {// convert it into record
		double x, y;

		private PointTwoDimensional(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static final MemoryLayout POINT2D_LAYOUT = MemoryLayout.structLayout(JAVA_DOUBLE.withName("x"),
			JAVA_DOUBLE.withName("y"));

	private MethodHandle distanceHandle;

	private final VarHandle xHandle = POINT2D_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("x"));

	private final VarHandle yHandle = POINT2D_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("y"));

	public TwoPointDistance() {

		Linker linker = Linker.nativeLinker();

		SymbolLookup lookup = SymbolLookup.libraryLookup("D:\\native-libs\\two_point_distance.dll", Arena.global());

		MemorySegment symbol = lookup.find("calculate_distance").get();

		FunctionDescriptor fd = FunctionDescriptor.of(JAVA_DOUBLE, ADDRESS, ADDRESS);

		distanceHandle = linker.downcallHandle(symbol, fd);
	}

	public double distance(PointTwoDimensional p1, PointTwoDimensional p2) throws Throwable {

		try (Arena arena = Arena.ofConfined()) {

			MemorySegment structP1 = arena.allocate(POINT2D_LAYOUT);
			MemorySegment structP2 = arena.allocate(POINT2D_LAYOUT);

			xHandle.set(structP1, 0L, p1.x);
			yHandle.set(structP1, 0L, p1.y);

			xHandle.set(structP2, 0L, p2.x);
			yHandle.set(structP2, 0L, p2.y);

			return (double) this.distanceHandle.invoke(structP1, structP2);
		}
	}

	public static void main(String[] args) throws Throwable {

		TwoPointDistance dist = new TwoPointDistance();

		double d = dist.distance(dist.new PointTwoDimensional(0, 0), dist.new PointTwoDimensional(3, 4));

		System.out.println("Distance = " + d);
	}
}
