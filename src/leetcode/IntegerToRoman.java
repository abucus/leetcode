package leetcode;

public class IntegerToRoman {

	static String[] romans1 = new String[] { "I", "X", "C", "M" };
	static String[] romans5 = new String[] { "V", "L", "D" };

	public static String solution(int num) {
		String rlt = "";
		int currentIdx = 0;
		while (num > 0) {
			int digit = num % 10;
			switch (digit) {
			case 9:
				rlt = romans1[currentIdx] + romans1[currentIdx + 1] + rlt;
				break;
			case 4:
				rlt = romans1[currentIdx] + romans5[currentIdx] + rlt;
				break;
			case 5:
				rlt = romans5[currentIdx] + rlt;
				break;
			default:
				int r = digit % 5;
				while (r > 0) {
					rlt = romans1[currentIdx] + rlt;
					r--;
				}
				if (digit > 5) {
					rlt = romans5[currentIdx] + rlt;
				}
			}
			num /= 10;
			currentIdx++;
		}
		return rlt;
	}

	public static void main(String[] args) {
		System.out.println(solution(6));
	}

}
