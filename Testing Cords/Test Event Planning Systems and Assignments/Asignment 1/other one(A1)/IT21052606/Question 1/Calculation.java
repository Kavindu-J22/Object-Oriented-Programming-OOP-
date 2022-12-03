
public class Calculation {
	
	public int SumOfSeries(int start, int end, int incr) {
		
		int sum = 0;
		
		for (int i = start; i <= end; i+=incr) {
			sum+=i;
		};
		
		return sum;
	}  
	
	public int SumOfArray(int data[], int size) {
		
		int sum = 0;
		
		for (int i = 0; i < size; i++) {
			sum+=data[i];			
		}
		
		return sum;
	}
	
	public int ProductOfSeries(int start, int end, int incr) {
		
		int pro = 1;
		
		for (int i = start; i <= end; i+=incr) {
			pro*=i;
		};
		
		return pro;
	}
	
	public int ProductOfArray(int data[], int size) {
		
		int pro = 1;
		
		for (int i = 0; i < size; i++) {
			pro*=data[i];			
		}
		
		return pro;
	} 

}
