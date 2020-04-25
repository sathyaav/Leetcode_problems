import java.util.Stack;

public class BitwiseAndOfNumbersRange {
	public static int rangeBitwiseAnd(int m, int n) {
        Long r = new Long((m));
        //System.out.println(r+" : "+ Long.toBinaryString(r));
		
        Long prevValue = r;
        m++;
        while(r!=0 && m<=n && m >=0 && n >=0 ){
        	if(!prevValue.equals(r)) {
        		 System.out.println("m: "+(m-1)+" r:"+r + " n: "+n);
        		 System.out.println("m: "+Integer.toBinaryString(m-1)+" r:"+Long.toBinaryString(r) + " n: "+Integer.toBinaryString(n));
        		 prevValue = r;
        	}
           
            r = r & m;
            m++;
           
        }
        return r.intValue();
    }  
	//58720256
	public static void main(String args[]) {
		int v=10;
		int n= 
				11
				 
				;
		
		System.out.println(Integer.toBinaryString(v));
		v=getD(v);
		System.out.println(v+" : "+ Integer.toBinaryString(v));
		System.out.println(rangeBitwiseAnd(v ,n));
		
	}
	
	public static int getD(int num) {
		int temp=num, val=0;
		
		Stack<Integer> st = new Stack<Integer>();
		while(temp!=0) {
			st.push(temp & 1);
			temp = temp >>1; 
		}
		boolean flag=false;
		while(!st.isEmpty()) {
			
			if(flag == true) {
				val = val << 1 ;
				
			}else if(st.peek() == 0) {
				flag = true;
				val = val << 1;
			}
			
			else if(st.peek() == 1) {
				val = val <<1 | 1 ;
			}
			//System.out.println(" peek: "+st.peek()+ " val: "+Integer.toBinaryString(val));
			
			st.pop();
		}
		System.out.println(val);
		//if(val<num) return num;
		return val;
	}
}
