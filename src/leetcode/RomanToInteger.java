package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class RomanToInteger {
	
	static HashMap<Character,Integer> map = new HashMap<Character,Integer>(7);
	static {
		map.put('I', 1);
		map.put('X', 10);
		map.put('C', 100);
		map.put('M', 1000);
		map.put('V', 5);
		map.put('L', 50);
		map.put('D', 500);
	}


	
	public static boolean sameLevel(char s1, char s2){
		int v1 = map.get(s1);
		int v2 = map.get(s2);
		return v2/v1 == 10 || v2/v1==5 || v1/v2==5 || v2/v1==1; 
	}
	
	public static int parseUnit(String s){
		int splitIdx = 0;
		int left=0,right=0,leftUnit=map.get(s.charAt(0)),rightUnit=map.get(s.charAt(s.length()-1));
		while((splitIdx<=s.length()-1) && s.charAt(splitIdx) == s.charAt(0)){
			splitIdx++;
		}
		left = (splitIdx)*leftUnit;
		right = (s.length()-splitIdx)*rightUnit;
		int plus = leftUnit-rightUnit;
		if(plus>=0){
			return left+right;
		}else{
			return right-left;
		}
	}
	
	public static int solution(String s){
		int rlt = 0;
		while(s.length()>0){
			int i = 0;
			while((i<s.length()-1)&&(sameLevel(s.charAt(i),s.charAt(i+1)))){
				i++;
			}
			rlt += parseUnit(s.substring(0, i+1));
			s = s.substring(i+1, s.length());
		}
		return rlt;
	}

	public static void main(String[] args) {
		System.out.println(solution("MMMDLXXXVI"));
	}

}
