/** 
 * Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B, otherwise, return false.
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and 
 * swapping the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "aabcd" results in "acbad"
 * https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3492/
**/


public class IsSwapString {
	public boolean buddyStrings(String A, String B) {
        
		if(A.length() != B.length()) return false;
		if(A.length() == 0 || B.length() == 0) return false;
		if(A.length() == 2 && A.charAt(0) == B.charAt(0) && A.charAt(1) == B.charAt(1) && A.charAt(0) == A.charAt(1)) return true; 
		
		
		int len = A.length();
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();
		int count =0;
		int[] flag = new int[26];
		for(int i=0 ; i < len; i++) {
			
			flag[A.charAt(i) - 97] += 1 ;
			
			if(A.charAt(i) != B.charAt(i)) {
				count++;
				if(count > 2) return false;
				str1.append(A.charAt(i));
				str2.append(B.charAt(i));
			}
			
			
		}
		if(str1.length() == 0 ) {
			for(int i=0 ; i< 26 ; i++) {
				if(flag[i] >= 2) return true;
			}
			return false;
		}
		if(str1.length() <2) return false;
		
		if(str1.charAt(0) != str2.charAt(1)  || str1.charAt(1) != str2.charAt(0) ) return false;
		
		return true; 
		
    }
	public static void main(String[] args) {
		IsSwapString obj = new IsSwapString();
		System.out.println(obj.buddyStrings("aabcd", "acbad")); //t
		System.out.println(obj.buddyStrings("aaaaaaabc", "aaaaaaacb")); //t
		System.out.println(obj.buddyStrings("aa", "aa")); // t
		System.out.println(obj.buddyStrings("ab", "ba")); //t 
		System.out.println(obj.buddyStrings("abab", "abab")); //t
		System.out.println(obj.buddyStrings("aaab", "aaab")); //t
		
		System.out.println(obj.buddyStrings("", "acbad")); //f
		System.out.println(obj.buddyStrings("aabcad", "acbada")); //f
		
		System.out.println(obj.buddyStrings("ab", "ab")); //f
		System.out.println(obj.buddyStrings("ab", "ca")); //f
		
		System.out.println(obj.buddyStrings("de", "de")); //f
		

	}

}
