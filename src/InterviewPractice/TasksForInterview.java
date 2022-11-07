package InterviewPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TasksForInterview {

	// sort list after removing first char in String
	public List<String> sortWithoutFirstChar() {

		List<String> names = new ArrayList<>();

		names.add("Addy");
		names.add("Greg");
		names.add("Rebecca");
		names.add("Abbi");
		names.add("Molli");
		names.add("Tyri");

		for (int i = 0; i < names.size(); i++) {

			names.set(i, names.get(i).substring(1));
		}

		Collections.sort(names);

		Iterator<String> iter = names.iterator();

		while (iter.hasNext()) {

			System.out.print(iter.next() + " ");
		}

		return names;
	}

	// reverse string with StringBuilder
	public String reverseStringWithStringBuilder(final String str) {

		StringBuilder revStr = new StringBuilder(str);

		revStr.reverse();

		System.out.println(revStr);

		return revStr.toString();

		// It could be done with in one line
		// return new StringBuilder(str).reverse().toString();
	}

	// reverse string with char array
	public String reverseStringWithCharArr(final String str) {

		String revStr = "";

		char[] arr = str.toCharArray();

		for (int i = (arr.length - 1); i >= 0; i--) {
			revStr += arr[i];
		}

		System.out.println(revStr);

		return revStr;
	}

	// reverse string with char array variant 2
	public String reverseStringWithCharArr2(final String str) {

		int index = str.length() - 1;

		char[] arr = new char[str.length()];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = str.charAt(index);
			index--;
		}

		String revStr = String.valueOf(arr);

		System.out.println(revStr);

		return revStr;
	}

	// reverse string with char array variant 3
	public String reverseStringWithCharArr3(final String str) {

		String resString = "";

		for (int i = 0; i < str.length(); i++) {
			resString = str.charAt(i) + resString;
		}

		System.out.println(resString);
		return resString;
	}

	// Recursive implementation
	public String reverseStringRecursive(final String str) {

		String rightPartStr;
		String leftPartStr;
		int length = str.length();

		if (length <= 1) {
			return str;
		}

		leftPartStr = str.substring(0, length / 2);
		rightPartStr = str.substring(length / 2, length);

		return reverseStringRecursive(rightPartStr) + reverseStringRecursive(leftPartStr);
	}

	// Advanced solution
	public String reverseStringWithCharsXOR(final String str) {

		char[] stringArray = str.toCharArray();

		int leftIndex = 0;
		int rightIndex = stringArray.length - 1;
		String resString = "";

		while (leftIndex < rightIndex) {

			stringArray[leftIndex] = (char) (stringArray[leftIndex] ^ stringArray[rightIndex]);
			stringArray[rightIndex] = (char) (stringArray[leftIndex] ^ stringArray[rightIndex]);
			stringArray[leftIndex] = (char) (stringArray[leftIndex] ^ stringArray[rightIndex]);

			leftIndex++;
			rightIndex--;
		}

		for (int i = 0; i < stringArray.length; i++) {
			resString = resString + stringArray[i];
		}

		System.out.println(resString);
		return resString;
	}

	public void swapInt(int a, int b) {

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("a: " + a);
		System.out.println("b: " + b);

	}

	public void swapIntXOR(int a, int b) {

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println("a: " + a);
		System.out.println("b: " + b);

	}

	public Boolean isPrime(int num) {

		if (num <= 1) {

			return false;
		}

		if (num <= 3) {

			return true;
		}

		if (num % 2 == 0 || num % 3 == 0) {

			return false;
		}

		for (int i = 2; i <= num / 2; i++) {

			if (num % i == 0) {

				return false;

			}
		}

		return true;
	}

	// "abacaa" k = 2
	public String getMaxSubstring(int k, String sourceStr) {

		List<String> arrStr = new ArrayList<>();
		String str = "";
		int unique = 0;
		int len = 0;
		int maxLen = 0;

		while (len < sourceStr.length()) {

			for (int i = len; i < sourceStr.length(); i++) {

				if (!str.contains(String.valueOf(sourceStr.charAt(i))) && unique < k) {

					unique++;

					str += sourceStr.charAt(i);

				} else if (str.contains(String.valueOf(sourceStr.charAt(i)))) {

					str += sourceStr.charAt(i);

				} else {

					break;
				}

			}

			// find the max length of string
			if (str.length() > maxLen) {

				maxLen = str.length();

			}

			arrStr.add(str);

			unique = 0;
			str = "";
			len++;

		}

		/*
		 * result = arrStr.get(0);
		 * 
		 * for (int i = 1; i < arrStr.size(); i++) {
		 * 
		 * System.out.println(arrStr.get(i));
		 * 
		 * if (result.length() < arrStr.get(i).length()) {
		 * 
		 * result = arrStr.get(i);
		 * 
		 * } else if(result.length() == arrStr.get(i).length()) {
		 * 
		 * } }
		 */

		// find all strings with maxLen;
		str = "";
		for (int i = 0; i < arrStr.size(); i++) {

			if (arrStr.get(i).length() == maxLen) {

				str += arrStr.get(i) + " ";

			}
		}

		System.out.print("result: " + str);

		return str.trim();
	}

	public int findMissingTwo(int[] numbers) {

		int diff = (numbers[numbers.length - 1] - numbers[0]) / (numbers.length);

		int miss = numbers[0];

		for (int i = 1; i < numbers.length; i++) {

			/*
			 * miss = numbers[i - 1] + diff;
			 * 
			 * if (numbers[i] != miss) {
			 * 
			 * break; }
			 */

			if (numbers[i] != (numbers[i - 1] + diff)) {

				miss = numbers[i - 1] + diff;

				break;
			}
		}

		System.out.println("miss: " + miss);

		return miss;
	}

	// "abakcakam"
	public List<String> getMaxSubstringOpimizationWithMap(int k, String sourceStr) {

		List<String> arrStr = new ArrayList<>();
		Map<String, String> checkMap = new HashMap<>();
		String str = "";
		int len = 0;
		int maxLen = 0;

		while (len < sourceStr.length()) {

			for (int i = len; i < sourceStr.length(); i++) {

				if ((!checkMap.containsKey(String.valueOf(sourceStr.charAt(i))) && checkMap.size() < k)
						|| (checkMap.containsKey(String.valueOf(sourceStr.charAt(i))))) {

					str += sourceStr.charAt(i);

					checkMap.put(String.valueOf(sourceStr.charAt(i)), str);

				} else {

					break;
				}

			}

			for (String key : checkMap.keySet()) {

				if (arrStr.isEmpty()) {

					arrStr.add(checkMap.get(key));

					maxLen = checkMap.get(key).length();

				} else if (checkMap.get(key).length() > maxLen) {

					arrStr.clear();

					arrStr.add(checkMap.get(key));

					maxLen = checkMap.get(key).length();

				} else if (checkMap.get(key).length() == maxLen) {

					arrStr.add(checkMap.get(key));
				}
			}

			checkMap.clear();
			str = "";
			len++;

		}

		System.out.println("result: " + arrStr);

		return arrStr;
	}

	public String getMaxSubstringOpimizationWithSet(int k, String sourceStr) {

		List<String> arrStr = new ArrayList<>();
		Set<String> checkSet = new HashSet<>();
		String str = "";
		int len = 0;
		int maxLen = 0;

		while (len < sourceStr.length()) {

			for (int i = len; i < sourceStr.length(); i++) {

				if (!checkSet.contains(String.valueOf(sourceStr.charAt(i))) && checkSet.size() < k) {

					checkSet.add(String.valueOf(sourceStr.charAt(i)));

					str += sourceStr.charAt(i);

				} else if (checkSet.contains(String.valueOf(sourceStr.charAt(i)))) {

					str += sourceStr.charAt(i);

				} else {

					break;
				}

			}

			// find the max length of string
			if (str.length() > maxLen) {

				maxLen = str.length();

			}

			checkSet.clear();
			arrStr.add(str);
			str = "";
			len++;

		}

		// find all strings with maxLen;
		str = "";
		for (int i = 0; i < arrStr.size(); i++) {

			if (arrStr.get(i).length() == maxLen) {

				str += arrStr.get(i) + " ";

			}
		}

		System.out.print("result: " + str);

		return str.trim();
	}

	// "abakcakam"
	public List<String> getMaxSubstringSlidingWindow(int k, String sourceStr) {

		List<String> arrStr = new ArrayList<>();
		Map<String, Integer> checkMap = new HashMap<>();
		String str = "";
		int len = 0;
		int maxLen = 0;
		String key = null;
		String oldkey = null;

		// find first window
		for (int i = 0; i <= k;) {

			key = String.valueOf(sourceStr.charAt(len));

			if (!checkMap.containsKey(key) && i < k) {

				checkMap.put(key, 1);

				str += key;

				i++;

			} else if (checkMap.containsKey(key) && i == k) {

				checkMap.put(key, checkMap.get(key) + 1);

				str += key;

			} else if (!checkMap.containsKey(key) && i == k) {

				break;

			}

			len++;
		}

		maxLen = str.length();
		arrStr.add(str);

		// slide window
		for (int j = str.length(); j < sourceStr.length();) {

			oldkey = String.valueOf(str.charAt(0));

			key = String.valueOf(sourceStr.charAt(j));

			if (checkMap.containsKey(key)) {

				checkMap.put(key, checkMap.get(key) + 1);

				str += sourceStr.charAt(j);

				j++;

				// find max str
				if (maxLen < str.length()) {

					arrStr.clear();

					arrStr.add(str);

					maxLen = str.length();

				} else if (maxLen == str.length()) {

					arrStr.add(str);

				}

			} else if (!checkMap.containsKey(key)) {

				if (checkMap.get(oldkey) == 1) {

					checkMap.remove(oldkey);

					checkMap.put(key, 1);

					str = str.substring(1) + sourceStr.charAt(j);

					j++;					
					
					 if (maxLen == str.length()) {

						arrStr.add(str);
					}

				} else {

					checkMap.put(oldkey, checkMap.get(oldkey) - 1);

					str = str.substring(1);

				}

			}

		}

		System.out.println("result " + arrStr);

		return arrStr;
	}
	
	// This function calculates number of unique characters
	// using a associative array count[]. 
	static boolean isValid (int count[], int k) {
		
		int val = 0;
		
		for (int i = 0; i < 26; i++)	{
			
			if (count[i] > 0){
				val++;
			}
		}
	
		return (k >= val);
	}
	
    static void findMaxSubstring(final int k, final String sourceStr)
    {
        int unuqueInd = 0;
        int strLenght = sourceStr.length();
        
        Map<Integer, List<String>> resMaxStrings = new HashMap<>();
        Integer resMaxMapIndex = 1;
 
        int count[] = new int[26];
        Arrays.fill(count, 0);
        
        int currentCharIndex = 0;
        for (int i = 0; i < strLenght; i++)
        {
        	currentCharIndex = sourceStr.charAt(i) - 'a';
            if (count[currentCharIndex] == 0)
            {
            	unuqueInd++;
            }
            count[currentCharIndex]++;
        }
 
        if (unuqueInd < k) {
            System.out.print("Not enough unique characters");
            return;
        }
 
        int curr_start = 0, curr_end = 0;
 
        int max_window_size = 1;
        int max_window_start = 0;
 
        Arrays.fill(count, 0);
         
        count[sourceStr.charAt(0) - 'a']++;
 
        for (int i = 1; i < strLenght; i++) {

            count[sourceStr.charAt(i) - 'a']++;
            curr_end++;
 
            while (!isValid(count, k)) {
                count[sourceStr.charAt(curr_start) - 'a']--;
                curr_start++;
            }
 
            if (curr_end - curr_start + 1 >= max_window_size)
            {
                max_window_size = curr_end - curr_start + 1;
                max_window_start = curr_start;
                
                String resMaxSubstring = sourceStr.substring(max_window_start,
                        max_window_start + max_window_size);
                
                List<String> resMaxStringsLst = resMaxStrings.get(max_window_size);
                
                if (resMaxStringsLst == null) {
                	resMaxStringsLst = new ArrayList<String>();
                	resMaxMapIndex++;
                } 
                
                resMaxStringsLst.add(resMaxSubstring);
                resMaxStrings.putIfAbsent(max_window_size, resMaxStringsLst);
                
            }
        }
        
        System.out.println("resultMKA " + resMaxStrings.get(resMaxMapIndex));
    }

	public void compute() {

		// List<String> sortedList = sortWithoutFirstChar();

		// String str = "Java is the best programming language!";

		// String strResult = reverseStringWithStringBuilder(str);

		// String strArr = reverseStringWithCharArr(str);

		// String strArr2 = reverseStringWithCharArr2(strArr);

		// String strArr3 = reverseStringWithCharArr3(strArr);

		// String strArr4 = reverseStringRecursive(strArr);
		// System.out.println("Arr4 " + strArr4);

		// String strArr5 = reverseStringWithCharsXOR(str);

		// int a = 9;
		// int b = 77;

		// swapInt(a, b);
		// swapIntXOR(a,b);

		// System.out.println(isPrime(29));

		// getMaxSubstring(2, "abakcakam");

		// System.out.println();

		// findMissingTwo(new int[]{1,3,4,5});

		// findMissingTwo(new int[]{-2,-4,-8,-10});

		// getMaxSubstringOpimizationWithSet(2, "abakcakam");

		// System.out.println();

		getMaxSubstringOpimizationWithMap(2, "abakcakam");
		System.out.println();
		getMaxSubstringSlidingWindow(2, "abakcakaaamm");
		getMaxSubstringSlidingWindow(2, "abakcakammmm");
		getMaxSubstringSlidingWindow(2, "abakcakam");
		getMaxSubstringSlidingWindow(2, "baaaakcakam");
		findMaxSubstring(2, "baaaakcakam");
	}

}
