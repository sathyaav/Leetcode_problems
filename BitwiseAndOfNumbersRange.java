import java.util.Random;

//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
public class BitwiseAndOfNumbersRange {
	
	
	
	public static int rangeBitwiseAnd(int m, int n) { // finds the common bits in m and n. 
		int count=0;
		while(m!=n) {
			m = m>>1;
			n = n>>1;
			count++;
		}
		
		return m<<count;
    }  
	
	public static int rangeBitwiseAndBF(int m, int n) { // Brute force
		for(int i=m; i <=n ; i++) {
			m = m & i;
		}
		return m;
	}
	
	public static void main(String args[]) {
		StressTest();
		int v=10;
		int n=15;		
		System.out.println(Integer.toBinaryString(v));
		System.out.println(v+" : "+ Integer.toBinaryString(v)+" n:" +Integer.toBinaryString(n));
		System.out.println(rangeBitwiseAnd(v ,n));
	}

	private static void StressTest() {
    	Random rand = new Random();
    	int n=0;
    	int m =0;
    	int val1, val2;
    	while(true) {
    		n = rand.nextInt(10000000)+1;
    		m = rand.nextInt(10000000)+n;
    		
            val1 = rangeBitwiseAnd(n ,m);
            val2 = rangeBitwiseAndBF(n, m);
            System.out.println(n+" "+m);
            if(val1 != (val2)) {
            	System.out.println("val1: "+ val1+" Val2: "+val2);
            }else {
            	System.out.println("OK");
            }
            
    	}
	
	}
}
