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

		myArrayList.remove(2);
		System.out.println();

		// Example with for when element was removed
		for (int i = 0; i < myArrayList.size(); i++) {
			System.out.print(myArrayList.get(i) + " ");
		}
		System.out.println();
		myArrayList.remove("Value4");

		//This is the way to re-use the iterator
		iter = myArrayList.iterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		
		//Short task. Why does it work (with this results)?
		
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
		mySet.add("Mama"); //Try to add extra "Mama"

		System.out.println(mySet);
		
		System.out.println("\nOne more way to print the set");
		
		for (String s: mySet) {
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
		
		//new elements were added anywhere. How can I get and print only one element? For ex. "Mama"???
		System.out.println("\n");
		
		if(mySet.contains("Mama")) {
			//Do something
			System.out.println("Mama");
		}
		
		//remove
		mySet.remove("Cat");
		System.out.println();
		System.out.println(mySet);
		

	}
	
	public HashSet<String> convertToSet(ArrayList<String> arrList){
		
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
	
	public void excludeDuplicatesFromList() {
		
		//Both ways are good!
		//ArrayList<String> sampleList = new ArrayList<>();
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

	public void calculate() {

		calculateForLists();
		// added print new line
		System.out.println();

		//calculateForSets();
		
		excludeDuplicatesFromList();
		
		addDuplicatesToSets();

	}

}
