package InterviewPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
		
		//It could be done with in one line
		//return new StringBuilder(str).reverse().toString();
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

	//Recursive implementation
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
	
	//Advanced solution
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
	
	public void compute() {

		// List<String> sortedList = sortWithoutFirstChar();
		
		String str = "Java is the best programming language!";
		
		String strResult = reverseStringWithStringBuilder(str);
		
		String strArr = reverseStringWithCharArr(str);
		
		String strArr2 = reverseStringWithCharArr2(strArr);
		
		String strArr3 = reverseStringWithCharArr3(strArr);
		
		String strArr4 = reverseStringRecursive(strArr);
		System.out.println(strArr4);
		
		String strArr5 = reverseStringWithCharsXOR(str);
			
	}

}
