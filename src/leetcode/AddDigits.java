package leetcode;

public class AddDigits {

	public static int addDigits(int num) {
		if(num<10){
			return num;
		}else{
			while((num=digitSum(num))>=10);
			return num;
		}
	}
	
	public static int digitSum(int num){
		String s = Integer.toString(num);
		int rlt = 0;
		for(int i=0,len=s.length();i<len;i++){
			rlt += Integer.parseInt(s.substring(i, i+1));
		}
		return rlt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
