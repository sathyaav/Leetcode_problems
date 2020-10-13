import java.util.Arrays;

/**
 * 
 * @author sathy
 *
 */
public class MinArrow {
	public int findMinArrowShots(Integer[][] points) {
		int total = points.length;
		Point[] point = new Point[total];
		int i =0;
		for(Integer[] p : points) {
			Point pObj = new Point();
			pObj.start = p[0];
			pObj.end = p[1];
			point[i] = pObj;
			i++;
		}
		
		
		Arrays.sort(point);
		
		i=0;
		
		int count =0;
		while(i < total) {
			int j = i+1;
			int min = point[i].start;
			int max = point[i].end;
			while(j<total && point[i].end >= point[j].start ) {
				
				if(min <= point[j].start) min = point[j].start;
				if(max >= point[j].end) max = point[j].end;
				//System.out.println( min +":"+max);
				if( min<=max && (min <= point[j].start || max >= point[j].end ))
					j++;
				else
					break;
			}
			
			count++;
			i=j;
		}
		
		
		
		
		return count;
        
    }
	
	private static class Point implements Comparable<Point>{
		int start;
		int end;
		
		@Override
		public int compareTo(Point o) {
			if(this.start < o.start)
				return -1;
			else if(this.start > o.start)
				return 1;
			else {
				if(this.end < o.end) return -1;
				else if(this.end > o.end) return 1;
				return 0;
			}
				//return 0;
		}

	}
	public static void main(String[] args) {
		MinArrow obj = new MinArrow();
		//{{10,16},{2,8},{1,6},{7,12},{2,3}}
		//{{1,2},{3,4},{5,6},{7,8}}
		// {{1,2},{2,3},{3,4},{4,5}}   //2
		// {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}}
		Integer[][] points = {{10,16},{2,8},{1,6},{7,12},{2,3}};
		System.out.println(obj.findMinArrowShots(points));

	}

}
