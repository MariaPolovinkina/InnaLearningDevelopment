package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

		// print for checking #1
		System.out.println(Arrays.asList(myMap));
		// print for checking #2
		// System.out.println(Collections.singletonList(myMap));

		// Add your own return
		return myMap;
	}

	/**
	 * Just for demonstration!
	 * 
	 * @param sourceList
	 * @return cool!!!!!!
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

	public Map<MyIntWrapper, Integer> inverseMap(Map<Integer, Integer> sourceMap) {

		// TODO: define the return value type and add it instead of void!

		Map<MyIntWrapper, Integer> myMap = new HashMap<>();

		for (Map.Entry<Integer, Integer> entry : sourceMap.entrySet()) {

			myMap.put(new MyIntWrapper(entry.getValue()), entry.getKey());

		}
		// print to check
		System.out.print("{ ");
		for (Map.Entry<MyIntWrapper, Integer> entry : myMap.entrySet()) {
			System.out.print(entry.getKey().get() + ":" + entry.getValue() + " ");
		}
		System.out.println("}");

		return myMap;

	}

	public List<Integer[]> inverseMap2(Map<Integer, Integer> sourceMap) {

		// TODO: define the return value type and add it instead of void!

		List<Integer[]> inverseList = new ArrayList<>();

		for (Map.Entry<Integer, Integer> entry : sourceMap.entrySet()) {

			inverseList.add(new Integer[] { entry.getValue(), entry.getKey() });

		}
		// print to check with iterator

		Iterator<Integer[]> iter = inverseList.iterator();

		Integer[] myInt;

		while (iter.hasNext()) {

			myInt = iter.next();

			System.out.print(myInt[0] + ":" + myInt[1] + " ");
		}

		System.out.println();

		// print to check with for

		for (int i = 0; i < inverseList.size(); i++) {

			System.out.print(inverseList.get(i)[0] + ":" + inverseList.get(i)[1] + " ");
		}

		return inverseList;

	}

	public List<Integer> generateRandomList(int minBound, int maxBound, int iterationsCount) {

		// Generate 100 random integer values between [1...10]
		List<Integer> generatedList = new ArrayList<>();

		// TODO: I'd prefer to use the for () cycle to exclude the instantiations of
		// cycle
		// variables (out of cycle)

		// int len = 0;
		// while (len < 100) {

		// TODO: It would be better to move the "int random_int" declaration put of
		// cycle.

		int random_int = 0;

		for (int i = 0; i < iterationsCount; i++) {

			random_int = (int) Math.floor(Math.random() * (maxBound - minBound + 1) + minBound);

			generatedList.add(random_int);
			// len++;
		}
		System.out.println("Size: " + generatedList.size());

		return generatedList;
	}

	public static Map<Integer, Collection<Integer>> inverseMapMariaImpl(Map<Integer, Integer> sourceMap) {
		Map<Integer, Collection<Integer>> resultMap = new HashMap<>();

		Set<Integer> keys = sourceMap.keySet();

		Integer curValue;

		for (Integer key : keys) {
			// System.out.println("key: "+key);
			curValue = sourceMap.get(key);
			// System.out.println("curvalue: "+curValue);
			resultMap.compute(curValue, (val, keySet) -> {

				if (keySet == null) {

					keySet = new HashSet<>();
				}

				keySet.add(key);

				return keySet;
			});

		}

		System.out.println("\nInverseMapMariaImpl method results =====>");
		System.out.println(Arrays.asList(resultMap));

		return resultMap;
	}

	public Map<Integer, Integer> exampleCompute(Map<Integer, Integer> sourseMap) {

		Map<Integer, Integer> resMap = new HashMap<>();

		for (Integer key : sourseMap.keySet()) {

			resMap.compute(key, (mykey, val) -> {
				
				val = sourseMap.get(key);
				
				if (val % 2 == 0) {

					val++;
				}

				return val;

			});
		}

		System.out.println("\nExample to compute method results =====>");
		System.out.println(Arrays.asList(resMap));

		return resMap;
	}
	
	public static Map<Integer, Collection<Integer>> inverseMapWithoutCompute(Map<Integer, Integer> sourceMap) {
		
		Map<Integer, Collection<Integer>> resultMap = new HashMap<>();

		Set<Integer> keys = sourceMap.keySet();

		Integer curValue;
		
		Collection<Integer> newValues = null;

		for (Integer key : keys) {
			
			curValue = sourceMap.get(key);
			
			if (!resultMap.containsKey(curValue)) {
				
			newValues = new HashSet<>();
			
			newValues.add(key);
			
			resultMap.put(curValue, newValues);
			
			} else {
				
				resultMap.get(curValue).add(key);
			}
			

		}

		System.out.println("\nInverse_Without_Compute method results =====>");
		System.out.println(Arrays.asList(resultMap));

		return resultMap;
	}

	public void calculate() {

		List<Integer> generatedList = generateRandomList(1, 10, 100);

		// Call the formatListToMap(...) method
		Map<Integer, Integer> formatedMap = formatListToMap(generatedList);

		// inverseMap2(formatedMap);

		Map<Integer, Integer> computedMap = exampleCompute(formatedMap);

		Map<Integer, Collection<Integer>> inversedMap = inverseMapMariaImpl(formatedMap);
		
		Map<Integer, Collection<Integer>> inversedMapWithoutComp = inverseMapWithoutCompute(formatedMap);

		// formatListToMapVersion2(generatedList);

	}
}
