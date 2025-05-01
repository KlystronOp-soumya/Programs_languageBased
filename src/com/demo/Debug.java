package com.demo;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class Debug {
	// Enable or disable debugging
	private static final boolean LOCAL = true;

	// Method to print a single object
	public Debug print(Object obj) {
		if (LOCAL) {
			if (obj instanceof Iterable<?>) {
				printIterable((Iterable<?>) obj);
			} else if (obj instanceof Map.Entry<?, ?>) {
				printPair((Map.Entry<?, ?>) obj);
			} else {
				System.out.print(obj);
			}
		}
		return this; // Return the current object for chaining
	}

	// Method to handle ranges (e.g., arrays or collections)
	public Debug printRange(Collection<?> collection) {
		if (LOCAL) {
			System.out.print("[");
			String result = collection.stream().map(Object::toString).collect(Collectors.joining(", "));
			System.out.print(result);
			System.out.print("]");
		}
		return this;
	}

	// Method to handle pairs (Map.Entry in Java)
	private void printPair(Map.Entry<?, ?> pair) {
		if (LOCAL) {
			System.out.print("(" + pair.getKey() + ", " + pair.getValue() + ")");
		}
	}

	// Method to handle iterable collections (like lists, sets, etc.)
	private void printIterable(Iterable<?> iterable) {
		if (LOCAL) {
			System.out.print("[");
			Iterator<?> it = iterable.iterator();
			while (it.hasNext()) {
				System.out.print(it.next());
				if (it.hasNext()) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
		}
	}

	// Optional: End debug output with a newline
	public Debug endLine() {
		if (LOCAL) {
			System.out.println();
		}
		return this;
	}
}
