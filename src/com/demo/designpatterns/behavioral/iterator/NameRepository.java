package com.demo.designpatterns.behavioral.iterator;

public class NameRepository implements Container {

	public String names[] = { "John", "Jane", "Robert" };

	@Override
	public Iterator getIterator() {

		return new NameIterator();
	}

	private class NameIterator implements Iterator {

		int index;

		@Override
		public boolean hasNext() {

			if (index < names.length) {

				return true;
			}

			return false;
		}

		@Override
		public Object next() {

			if (this.hasNext()) {

				String st = names[index];
				index++;

				return st;
			}

			return null;
		}

	}

}
