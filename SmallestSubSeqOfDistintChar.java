import java.util.Stack;

/*
 *Given a string s, remove duplicate letters so that every letter appears once and only once. 
 *You must make sure your result is the smallest in lexicographical order among all possible results.
 *https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */
public class SmallestSubSeqOfDistintChar {

	public String removeDuplicateLetters(String s) {
	
		long mask  = 0;
		int len = s.length();
		int i = 0;
		
		int[] freq = new int[26];
		for(int c = 0; c < s.length(); c++)
			freq[s.charAt(c) - 97] += 1;
		
		
		Stack<Character> st = new Stack<Character>();	
		while( i < len) {
			char ch = s.charAt(i);
			
			freq[ch - 97] -= 1;
			if( (mask & (1 << (ch- 97))) != 0) {
				i++;
				continue;
			}
			
			while(  st.size() > 0 && st.peek() > ch && freq[st.peek() - 97] > 0) {
				char rem = st.pop();
				
				mask = mask & ~(1 << (rem -97));
				
			}
			mask = mask | (1 << (ch - 97));
			
			st.push(ch);
			
			i++;
			
		}
		
		StringBuilder str = new StringBuilder();
		while(st.size() > 0) {
			str.append(st.pop());
		}
		return str.reverse().toString();
		
	}
	
	
	public String fastRemoveDuplicateLetters(String s) {
        
        int [] last=new int[26];
        for(int i=0;i<s.length();i++)last[s.charAt(i)-'a']=i;
        
        char [] ans=new char[26];
        ans[0]=s.charAt(0);
        boolean [] used=new boolean[26];
        used[ans[0]-'a']=true;
        
        for(int i=1,j=1;i<s.length();i++){
            char c=s.charAt(i);
            if(used[c-'a'])continue;
            while(j>0 && ans[j-1]>c){
                if(last[ans[j-1]-'a']>i){
                    used[ans[j-1]-'a']=false;
                    j--;
                }
                else{
                    break;
                }
            }
            ans[j++]=c;
            used[c-'a']=true;
        }
        
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<26;i++){
            char c=ans[i];
            if(c>='a' && c<='z')sb.append(c);
        }
        return sb.toString();
        
        
    }
	
	public static void main(String[] args) {
		SmallestSubSeqOfDistintChar obj = new SmallestSubSeqOfDistintChar();
	//	System.out.println(obj.removeDuplicateLetters("bcabc"));
		
		System.out.println(obj.removeDuplicateLetters("cbacdcbc"));
		System.out.println(obj.removeDuplicateLetters("abdca"));
		System.out.println(obj.removeDuplicateLetters("bcac"));
		System.out.println(obj.removeDuplicateLetters("cdadabcc")); //adbc
		

	}

}
