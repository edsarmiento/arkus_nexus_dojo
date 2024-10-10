// https://www.codewars.com/kata/51b6249c4612257ac0000005

class Kata2 {
	private static final int[] values = new int[128];

	static {
		values['I'] = 1;
		values['V'] = 5;
		values['X'] = 10;
		values['L'] = 50;
		values['C'] = 100;
		values['D'] = 500;
		values['M'] = 1000;
	}

	public static int romanToInt(String s) {
		int total = 0;
		int prevValue = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			char currentChar = s.charAt(i);
			int currentValue = values[currentChar];

			// Subtraction if the current value is less than the previous one, otherwise addition
			if (currentValue < prevValue) {
				total -= currentValue;
			} else {
				total += currentValue;
			}
			prevValue = currentValue;
		}

		return total;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXC")); // 1990
		System.out.println(romanToInt("MMVIII")); // 2008
		System.out.println(romanToInt("MDCLXVI")); // 1666
		System.out.println(romanToInt("IX")); // 9
		System.out.println(romanToInt("IV")); // 4
	}
}
