package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AtlassianTests {

	/**
	 * @param args
	 * @author Cristiano
	 */
	public static void main(String[] args) {

		List<Integer> ints = new ArrayList<Integer>();
		Collections.reverse(ints);
		Collections.unmodifiableList(ints);

	}

	public int[] twoSum(int[] numbers, int target) {
        for(int x = 1; x < numbers.length; x++){
        	for(int y = x+1; y < numbers.length; y++){
        		if(numbers[x] + numbers[y] == target){
					return new int[] { x, y };
        		}
        	}
        }
		return null;
    }
}
