package Collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SimpleOperations {

	public void calculateForLists() {

		List<String> myArrayList = new ArrayList<String>();

		myArrayList.add("Value1");
		myArrayList.add("Value2");
		myArrayList.add("Value3");
		
		System.out.print(myArrayList.get(1) + " ");
		System.out.println();

		myArrayList.add(1, "Value4");

		System.out.print(myArrayList.get(1) + " ");
		System.out.println();

		// Example with for
		for (int i = 0; i < myArrayList.size(); i++) {
			System.out.print(myArrayList.get(i) + " ");
		}

		System.out.println();

		// Example with iterator
		Iterator<String> iter = myArrayList.iterator();

		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}

		// TODO: Add remove operations and check the results
		myArrayList.remove(2);
		System.out.println();

		// Example with for when element was removed
		for (int i = 0; i < myArrayList.size(); i++) {
			System.out.print(myArrayList.get(i) + " ");
		}
		System.out.println();
		myArrayList.remove("Value4");

		// Example with iterator.
		///
		///
		// ? I wasn't able to use iter. why?
		Iterator<String> iter1 = myArrayList.iterator();
		while (iter1.hasNext()) {
			System.out.print(iter1.next() + " ");
		}

	}

	public void calculateForSets() {
		Set<String> mySet = new HashSet<String>();
		mySet.add("Mama");
		mySet.add("Papa");
		mySet.add("Daughter");
		mySet.add("Sun");

		System.out.println(mySet);

		mySet.add("Aunt");
		mySet.add("Dog");
		mySet.add("Cat");
		Iterator<String> iter = mySet.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		
		//new elements were added anywhere. How can I get and print only one element? For ex. "Mama"???
		//remove
		mySet.remove("Cat");
		System.out.println();
		System.out.println(mySet);
		

	}

	public void calculate() {

		calculateForLists();
		// added print new line
		System.out.println();

		// TODO: Add method for Set
		calculateForSets();

	}

}
