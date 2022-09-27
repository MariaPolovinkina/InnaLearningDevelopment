package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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

		myArrayList.remove(2);
		System.out.println();

		// Example with for when element was removed
		for (int i = 0; i < myArrayList.size(); i++) {
			System.out.print(myArrayList.get(i) + " ");
		}
		System.out.println();
		myArrayList.remove("Value4");

		// This is the way to re-use the iterator
		iter = myArrayList.iterator();

		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}

		// Short task. Why does it work (with this results)?

		ArrayList<String> sampleList = new ArrayList<>();
		String value1 = "value1";
		String value2 = "value2";

		sampleList.add(value1);
		sampleList.add(value2);
		System.out.print("\n" + sampleList.size() + ":");

		value1 = "value3";
		sampleList.remove(value1);
		System.out.println(sampleList.size());

	}

	public void calculateForSets() {

		Set<String> mySet = new HashSet<String>();

		mySet.add("Mama");
		mySet.add("Papa");
		mySet.add("Daughter");
		mySet.add("Son");
		mySet.add("Mama"); // Try to add extra "Mama"

		System.out.println(mySet);

		System.out.println("\nOne more way to print the set");

		for (String s : mySet) {
			System.out.print(s + " ");
		}

		mySet.add("Aunt");
		mySet.add("Dog");
		mySet.add("Cat");

		Iterator<String> iter = mySet.iterator();

		System.out.println("\n\nPrint with using iterator");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}

		// new elements were added anywhere. How can I get and print only one element?
		// For ex. "Mama"???
		System.out.println("\n");

		if (mySet.contains("Mama")) {
			// Do something
			System.out.println("Mama");
		}

		// remove
		mySet.remove("Cat");
		System.out.println();
		System.out.println(mySet);

	}

	public HashSet<String> convertToSet(ArrayList<String> arrList) {

		HashSet<String> convertedSet = new HashSet<String>(arrList);
		return convertedSet;
	}

	public void addDuplicatesToSets() {

		HashSet<UnequalWrapper> addDuplSet = new HashSet<UnequalWrapper>();

		addDuplSet.add(new UnequalWrapper("Banan"));
		addDuplSet.add(new UnequalWrapper("Apple"));
		addDuplSet.add(new UnequalWrapper("Banan"));
		addDuplSet.add(new UnequalWrapper("Apple"));

		Iterator<UnequalWrapper> iter = addDuplSet.iterator();

		while (iter.hasNext()) {
			System.out.print(iter.next().get() + " ");
		}

	}

	public void sortedMySet() {
		// use sorted set
		SortedSet<String> mySortedSet = new TreeSet<>();
		mySortedSet.add("Banana");
		mySortedSet.add("Apple");
		mySortedSet.add("Dom");
		mySortedSet.add("Cat");
		System.out.println();
		System.out.println(mySortedSet);

		// sorted hashset
		HashSet<String> myHashset = new HashSet<>();
		myHashset.add("b4");
		myHashset.add("b2");
		myHashset.add("b1");
		myHashset.add("b3");
		System.out.println("Before sorting: ");
		System.out.println(myHashset);
		ArrayList<String> mylist = new ArrayList<>(myHashset);
		// Collections.sort(mylist);
		/*
		 * System.out.println("After sorting: "); System.out.println(mylist);
		 * Collections.sort(mylist, Collections.reverseOrder());
		 * System.out.println("After reverse sorting: "); System.out.println(mylist);
		 */

		ArrayList<String> list = new ArrayList<>();
		list.add("a121");
		list.add("d331");
		list.add("b411");
		list.add("c241");
		System.out.println(list);

		/*
		 * Collections.sort(list, new Comparator<String>() { public int compare(String
		 * a, String b) { return a.toString().compareTo(b.toString()); } });
		 */

		Collections.sort(list, new Comparator<String>() {
			public int compare(String a, String b) {
				return a.substring(1).toString().compareTo(b.substring(1).toString());
			}
		});

		System.out.println(list);

	}

	public void excludeDuplicatesFromList() {

		// Both ways are good!
		// ArrayList<String> sampleList = new ArrayList<>();
		ArrayList<String> sampleList = new ArrayList<String>();

		sampleList.add("Apple");
		sampleList.add("Pear");
		sampleList.add("Beans");
		sampleList.add("Apple");
		sampleList.add("Banana");

		System.out.println(sampleList);

		HashSet<String> convertedSet = convertToSet(sampleList);

		System.out.println(convertedSet);
	}

	public void createMap() {
		// create ArrayList
		List<String> mylist = new ArrayList<>();
		mylist.add("Apple");
		mylist.add("Pear");
		mylist.add("Beans");
		mylist.add("Apple");
		mylist.add("Banana");
		mylist.add("Beans");
		mylist.add("Apple");
		mylist.add("Apple");

		// HashMap<K, V>
		// create HashMap
		Map<String, Integer> myMap = new HashMap<>();

		for (int i = 0; i < mylist.size(); i++) {
			if (myMap.containsKey(mylist.get(i))) {
				myMap.put(mylist.get(i), myMap.get(mylist.get(i)) + 1);
			} else {
				myMap.put(mylist.get(i), 1);
			}
		}
		System.out.println(myMap.values());
		System.out.println(myMap.keySet());
		System.out.println();
		System.out.println(Arrays.asList(myMap));

	}

	public void calculate() {

		calculateForLists();
		// added print new line
		System.out.println();

		// calculateForSets();

		excludeDuplicatesFromList();

		addDuplicatesToSets();

		sortedMySet();
		System.out.println();
		createMap();

	}

}
