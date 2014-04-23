package ojleet;

import java.util.HashMap;

public class TwoSum {

	/**
	 * @param args
	 * @author Cristiano
	 */
	public static void main(String[] args) {

		TwoSum ts = new TwoSum();
		System.out.println(ts.twoSum(new int[] { 5, 75, 25 }, 100));
	}

	/**
	 * Two sum implementation
	 * 
	 * @param numbers
	 *            possible sum options
	 * @param target
	 *            result to find
	 * @return array of 2 items that result in target
	 * @author Cristiano
	 */
	public int[] twoSum(int[] numbers, int target) {

		HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
		int[] answer = new int[2];

		for (int i = 0; i < numbers.length; i++) {
			Integer number = values.get(numbers[i]);

			if (number == null) {
				values.put(numbers[i], i);
			}

			number = values.get(target - numbers[i]);
			if (number != null) {
				if (i < number) {
					answer[0] = i + 1;
					answer[1] = number + 1;
					return answer;
				} else {
					answer[0] = number + 1;
					answer[1] = i + 1;
					return answer;
				}
			}

		}
		return answer;
	}
}
