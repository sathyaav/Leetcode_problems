// https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/

public class MaxSubArrayWithEqNumOfZeroAndOne {

	public static int findMaxLength(int[] nums) {
	       
        int n = nums.length;
        int[] recorder = new int[2 * nums.length + 1];
        
        for( int i = 0; i < recorder.length; i++) recorder[i] = -2;
        
        int sum = n;
        int max = 0;
        recorder[n] = -1;
        
        for ( int i = 0; i < nums.length; i++){
            sum += (nums[i] * 2 - 1);
            if (recorder[sum] == -2)
                recorder[sum] = i; 
            else
                max = Math.max(max, i - recorder[sum]);
        }
        return max;
    }


	public static void main(String[] args) {
		int values[] = {0,0,0,0,1,1,1,1,0,1,0,0,1};
		System.out.println(findMaxLength(values));

	}

}
