package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsCasting {

	public Map<Integer, Integer> formatListToMap(List<Integer> sourceList) {
		Map<Integer, Integer> myMap = new HashMap<>();
		
		for (int i = 0; i < sourceList.size(); i++) {
			if (myMap.containsKey(sourceList.get(i))) {
				myMap.put(sourceList.get(i), myMap.get(sourceList.get(i)) + 1);
			} else {
				myMap.put(sourceList.get(i), 1);
			}
		}
		//print for checking #1
		System.out.println(Arrays.asList(myMap));
		//print for checking #2
		System.out.println(Collections.singletonList(myMap));
		
		// Add your own return
		return myMap;
	}

	public void calculate() {

		// Generate 100 random integer values between [1...10]
		List<Integer> sourceList = new ArrayList<>();
		int max = 10;
		int min = 1;
		int len = 0;
		while (len < 100) {
			int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
			// Why can i add here int as Integer? Integer is a class, int is a primitive
			// type
			sourceList.add(random_int);
			len++;
		}
		System.out.println("Size: " + sourceList.size());

		// Call the formatListToMap(...) method
		formatListToMap(sourceList);

	}
}
