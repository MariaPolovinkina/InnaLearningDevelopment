import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Collections.SimpleOperations;

public class Main {

	
	public static void main(String[] args) {
		
		// This is just for calling the function like myObject.calculate();
		
		//Example:
		//MyObject myObject = new myObject();
		//myObject.calculate();
		
		SimpleOperations myObject = new SimpleOperations();
		myObject.calculate();
		ArrayList<String> sampleList = new ArrayList<>();
		sampleList.add("Apple");
		sampleList.add("Pear");
		sampleList.add("Beans");
		sampleList.add("Apple");
		sampleList.add("Banana");
		System.out.println(sampleList);
		HashSet<String> convertedSet = myObject.convertToSet(sampleList);
		System.out.println(convertedSet);
	}
}
