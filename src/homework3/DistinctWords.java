package homework3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DistinctWords {

	public static void main(String[] args) {
		String [] words = {"one", "two", "three", "one","two", "one", "two", "four","five", "five", "five", "five"};
		Set<String> distinctWords = new HashSet<>(Arrays.asList(words));
		System.out.println(distinctWords);
		System.out.println(numberOfTimes(words));
	}
	
	public static Map<String, Long> numberOfTimes(String[] args) {
		//return Arrays.asList(args).stream()
        	//.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<String, Long> numberOfTimesMap= new HashMap<>();
		/*for(String s: args) {
			if(!numberOfTimesMap.containsKey(s)) {
				numberOfTimesMap.put(s, 1l);
			}
			else {
				numberOfTimesMap.put(s, numberOfTimesMap.get(s)+1);
			}
		}*/

		List<String> words = Arrays.asList(args);
		Set<String> distinctWords = new HashSet<>(words);
		for(String s: distinctWords) {
			numberOfTimesMap.put(s, (long)Collections.frequency(words, s));
		}

		return numberOfTimesMap;
	}

}
