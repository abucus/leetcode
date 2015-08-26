package leetcode;

import java.util.ArrayList;

public class HappyNumber {
	
	public static boolean isHappy(int n){
		ArrayList<Integer> l = new ArrayList<Integer>();
		if(n == 1){
			return true;
		}
		int c = n;
		while((c=digitSquareSum(c))!=1){
			if(l.contains(c)){
				return false;
			}else{
				l.add(c);
			}
		}
		return true;
	}
	
	public static int digitSquareSum(int m){
		String s = Integer.toString(m);
		int sum = 0;
		for(int i=0,len=s.length();i<len;i++){
			int digit = Integer.parseInt(s.substring(i, i+1));
			sum += digit*digit;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(digitSquareSum(29));
	}

}
