import java.util.HashSet;
import java.util.Iterator;
import Collections.SimpleOperations;
import Collections.UnequalWrapper;

public class Main {

	
	public static void main(String[] args) {
		
		// This is just for calling the function like myObject.calculate();
		
		//Example:
		//MyObject myObject = new myObject();
		//myObject.calculate();
		
		SimpleOperations myObject = new SimpleOperations();
		myObject.calculate();

		//add duplicate to HashSet
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

}
