package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		
		//Example with for
		for (int i = 0; i < myArrayList.size(); i++) {
	        System.out.print(myArrayList.get(i) + " ");
	    }
		
		System.out.println();
		
		
		//Example with iterator
		Iterator<String> iter = myArrayList.iterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		
		//TODO: Add remove operations and check the results
	}
	
	public void calculate() {		

	calculateForLists();
	
	//TODO: Add method for Set
	
	}
	
	

}
