import java.util.HashMap;
// Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/
public class SubarraySumEqualK {
	
	public static int subarraySum(int[] nums, int k) {
        int sum_count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int sum =0;
        map.put(0,1);
        
        for (int i=0;i<nums.length;i++){
            
            sum += nums[i];
            if(map.containsKey(sum-k))
                sum_count += map.get(sum-k);
            
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        
        return sum_count;
    }
	
	
	public static void main(String[] args) {
		int values[] = {-1, 1, 2, 3, 4, 5, 6, 9, 2,3,4, -2, -3, -4, 11, -1, -3, 4};
		System.out.println(subarraySum(values, 40));
	}

	
	/* Solution:
	   We traverse over the array nums and keep on finding the cumulative sum. 
	   Every time we encounter a new sum,
	    	we make a new entry in the hashmap corresponding to that sum. 
	   If the same sum occurs again,
	    	we increment the count corresponding to that sum in the hashmap.
	   		Further, for every sum encountered, we also determine the 
	   		number of times the sum-k has occured already, 
	   		since it will determine the number of times a subarray with sum k 
	   		has occured upto the current index. 
	 		We increment the sum_count by the same amount.
		After the complete array has been traversed, the sum_count gives the required result.
	 */
}
