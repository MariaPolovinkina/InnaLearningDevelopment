package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

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
	
	/**
	 * Just for demonstration!
	 * @param sourceList
	 * @return
	 */
	public Map<Integer, Integer> formatListToMapVersion2(List<Integer> sourceList) {
		
		Map<Integer, Integer> myMap = new HashMap<>();
		
		for (Integer iter : sourceList) {
			
			myMap.compute(iter, new BiFunction<Integer, Integer, Integer>() {
                @Override
                public Integer apply(Integer iter, Integer count) {
                    return count == null ? 1 : count + 1;
                }
            });
		}
		
		System.out.println("Version2 results =====>");
		System.out.println(Arrays.asList(myMap));
		return myMap;
	
	}
	
	public void inverseMap (Map<Integer, Integer> sourceMap) {
		
		//TODO: define the return value type and add it instead of void!
		
	}
	
	public List<Integer> generateRandomList(int minBound, int maxBound, int iterationsCount) {
		
		// Generate 100 random integer values between [1...10]
		List<Integer> generatedList = new ArrayList<>();

		//TODO: I'd prefer to use the for () cycle to exclude the instantiations of cycle
		// variables (out of cycle)

		// int len = 0;
		// while (len < 100) {
		
		// TODO: It would be better to move the "int random_int" declaration put of cycle.
		
		int random_int = 0;
		
		for (int i = 0; i < iterationsCount; i++) {

			random_int = (int) Math.floor(Math.random() * (maxBound - minBound + 1) + minBound);

			generatedList.add(random_int);
			// len++;
		}
		System.out.println("Size: " + generatedList.size());
		
		return generatedList;
	}

	public void calculate() {

		List<Integer> generatedList = generateRandomList(1, 10, 100);

		// Call the formatListToMap(...) method
		Map<Integer, Integer> formatedMap = formatListToMap(generatedList);
		
		inverseMap(formatedMap);
		
		//formatListToMapVersion2(generatedList);
	}
}
