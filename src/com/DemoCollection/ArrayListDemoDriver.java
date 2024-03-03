package com.DemoCollection;

/*
 * Showing the different methods on ArrayList
 */
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemoDriver {
	public static void addCollection(ArrayList<Integer> ar, ArrayList<Integer> ars) {
		// addall the elements at the end of the first arraylist
		ar.addAll(ars);
		// add the array after an index
		// ar.addAll(2, ars);
		System.out.println("After append: " + ar);
	}

	public static void sortArrayList(ArrayList<Integer> ar) {
		// sorting the array list in the ascending order
		System.out.println("The list before sorting:" + ar);
		Collections.sort(ar);
		System.out.println("The list after sorting:" + ar);
		// sorting the list in the reverse order
		System.out.println("Sorting in the reverse order:");
		Collections.sort(ar, Collections.reverseOrder());
		System.out.println(ar);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		// decalre an arraylist(dynamic)

		// fixed length ArrayList<Integer> ar = new ArrayList<Integer>(10);
		ArrayList<Integer> ar = new ArrayList<Integer>();
		// add elements in arrayList
		ar.add(1);
		ar.add(2);
		ar.add(3);
		ar.add(4);

//to display at once
		System.out.println(ar);

//add an element at an position
		ar.add(3, 13);// 13 is inserted at 3rd position
//change an existing element inside the arraylist
		ar.set(0, 23);// 1->23
		System.out.println(ar);
//remove an element by the element itself
		ar.remove(1);// deleted at the index 1
		System.out.println(ar);
		// again delete using an element
		/*
		 * Now if we write only 23 inside the brackets then it would throw an error
		 * since 23rd index is not available.This is why we have to cast this as an
		 * Integer object
		 */
		ar.remove((Integer) 23);// element 23 will be deleted
		System.out.println(ar);

		ar.removeAll(ar);
		// sort the arraylist
		Collections.sort(ar);
		System.out.println(ar);
		// get the size of the arraylist
		System.out.println("Number of elements int he arraylist:" + ar.size());
//get the object at an index
		System.out.println("Element at the index 1" + ar.get(1));
		// check existance of an element
		System.out.println("The array contains the element: " + ar.contains(3));// if not then -1 is returned
		// delete the array
		System.out.println("Deleting the element in the arraylis:");
		// ar.clear();
		System.out.println("Is the arraylist empty?" + ar.isEmpty());
		// new arrayList
		ArrayList<Integer> ar2 = new ArrayList<Integer>();
		ar2.add(3);
		ar2.add(63);
		ar2.add(23);
		ar2.add(13);
		ar2.add(83);
		sortArrayList(ar2);
		System.out.println("Main: " + ar2);// being modifed here as well since pass by reference
		addCollection(ar, ar2);// comment the ar.clear() if not commented
		// get the sublist from the arraylist
		ArrayList<Integer> ar3 = new ArrayList<Integer>(ar2.subList(1, 4));
		System.out.println("ArrayList after sublist: " + ar3);
		// Get the occurrences of the arraylist eleements
		System.out.println("Element 3 occurred at: " + ar.indexOf(3));
		System.out.println("Element 3 again occurred at: " + ar.lastIndexOf(3));
		// swap the elements in a arraylist
		Collections.swap(ar3, 0, 2);
		System.out.println("After swapping: " + ar3);
		/*
		 * Other function cpp resize=>trimToSize() list to array =>toArray()
		 */
	}

}
