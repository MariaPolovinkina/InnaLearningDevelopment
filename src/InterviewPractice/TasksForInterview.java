package InterviewPractice;

import java.util.ArrayList;
import java.util.Arrays;
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
	public StringBuilder reverseStringWithStringBuilder() {

		String str = "abcd";

		StringBuilder revStr = new StringBuilder(str);

		revStr.reverse();

		System.out.println(revStr);

		return revStr;
	}

	// reverse string with char array
	public String reverseStringWithCharArr() {

		String str = "abcd";

		String revStr = "";

		char[] arr = str.toCharArray();

		for (int i = (arr.length - 1); i >= 0; i--) {

			revStr += arr[i];
		}

		System.out.println(revStr);

		return revStr;

	}
	
	// reverse string with char array variant 2
	public String reverseStringWithCharArr2(String str) {
		
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

	public void compute() {

		// List<String> sortedList = sortWithoutFirstChar();
		
		StringBuilder strBuild = reverseStringWithStringBuilder();
		
		String strArr = reverseStringWithCharArr();
		
		String strArr2 = reverseStringWithCharArr2(strArr);

	}

}
