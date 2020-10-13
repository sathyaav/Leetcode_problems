import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


// a +b+c =0
public class ThreeSum {

	
	/// doesnot work with duplicates
	public List<List<Integer>> solution(int[] nums){
		int n = nums.length;
		HashSet<Integer> set;	
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i=0;i< n-2; i++) {
			set = new 	HashSet<Integer>();
			
			for(int j=i+1; j< n; j++) {
				if(set.contains(-nums[j]-nums[i])) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(-(nums[j]+nums[i]));
					result.add(list);
				}
				set.add(nums[j]);
			}
			
			
			
			
		}
		
		return result;
	}
	
	public List<List<Integer>> goodSolution(int[] nums){
		int n = nums.length;
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(n<3) return result;
		
		
		Arrays.sort(nums);
		
		for(int i=0; i<n-2 ; i++) {
			
			if(i>0 && nums[i] == nums[i-1])
				continue;
			
			for(int j=i+1; j<n ; j++) {
				
				int toFind = 0-nums[i];
				
				
				int low = j;
				int high = n-1;
				
				while(low < high) {
					int curr_sum = nums[low] + nums[high];
					if(curr_sum == toFind) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[low]);
						list.add(nums[high]);
						result.add(list);
						
						while(low < high && nums[low] == nums[low+1])
							low++;
						while(low < high  && nums[high] == nums[high-1])
							high--;
						
						low += 1;
						high -= 1;
					}
					else if(curr_sum < toFind) {
						low += 1;
					}else {
						high -= 1;
					}
					
					
					
					
				}
				
						
				
				
				
			}
			
			
			
			
			
			
		}
		
		
		
		return result;
	}
	
	
	private boolean binarySearch(int[] nums,int start, int n, int toFind) {
		
		int mid,  end =n-1;
		while(start < end) {
			mid = start+(end-start)/2;
			
			if(nums[mid] == toFind)
				return true;
			else if(nums[mid] < toFind) {
				start = mid+1;
			}
			else
				end=mid-1;
			
			
			
		}
		return false;
		
		
		
	}

	public static void main(String[] args) {
		ThreeSum obj = new ThreeSum();
		obj.goodSolution(new int[] {-1,0,1,2,-1,-4});
	}

}
