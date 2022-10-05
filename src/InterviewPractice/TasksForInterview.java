package InterviewPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TasksForInterview {

	//sort list after removing first char in String 
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

	public void compute() {

		List<String> sortedList = sortWithoutFirstChar();

	}

}
