import java.util.Arrays;
import java.util.Random;

public class MaxSubSum4 {
	public static int maxSubSum4( int []a){
	int maxSum = 0, thisSum = 0;
	int startIndex=0;
	int endIndex = 0;
	
	
		for( int j = 0; j < a.length; j++ ){
			thisSum += a[ j ];
			
			if(thisSum > maxSum){
				maxSum = thisSum;
				endIndex = j;
			}
			
			else if( thisSum < 0){
				
				thisSum = 0;
				if(startIndex==endIndex){
					startIndex = j+1;
				}
				else if(startIndex>endIndex){
					startIndex=endIndex;
				}
		
			}
		}
		if(startIndex>endIndex){
			startIndex=endIndex;
		}
		if(endIndex==0){
			startIndex=0;
		}
		if (maxSum==a[a.length-1]){
			startIndex=endIndex;
		}

		
		System.out.println(startIndex);
		System.out.println(endIndex);
		return maxSum;
		
		
				
	}

	public static void main(String[] args) {
		Random random = new Random();
		int[] a = {1,2,3};
		
		for( int i = 0; i < 3; i++ ){
			a[i] = random.nextInt(100)-50;
			}

		System.out.println("Max Sum: " + maxSubSum4(a));
		System.out.println("Array: " + Arrays.toString(a));
		
	}
	
}
