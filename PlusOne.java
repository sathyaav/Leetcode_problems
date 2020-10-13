/****
 * 
 * 
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 * 
 * 
 * @author sathy
 *
 */
public class PlusOne {

	
	private int[] solution(int[] digits) {
		
		int carry=1;
		int n= digits.length;
		for(int i=n-1; i>=0;i--) {
			int sum = carry+ digits[i];
			carry = sum/10;
			digits[i]= sum%10;
		}
		if(carry ==1) {
			int[] newArr = new int[n+1];
			newArr[0] = carry;
			for(int i=1;i<=n;i++) {
				newArr[i] = digits[i-1];
			}
			return newArr;
		}
		return digits;
	}
	
	  // O(N), O(N) Best solution
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // move along the input array starting from the end
        for (int idx = n - 1; idx >= 0; --idx) {
            // set all the nines at the end of array to zeros
            if (digits[idx] == 9) {
                digits[idx] = 0;
            }
            // here we have the rightmost not-nine
            else {
                // increase this rightmost not-nine by 1
                digits[idx]++;
                // and the job is done
                return digits;
            }
        }
        // we're here because all the digits are nines
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    } 	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlusOne obj = new PlusOne();
		for (Integer i : obj.solution(new int[] {9,9,9,9})) {
			System.out.print(i+" ");
		};
	}

}
