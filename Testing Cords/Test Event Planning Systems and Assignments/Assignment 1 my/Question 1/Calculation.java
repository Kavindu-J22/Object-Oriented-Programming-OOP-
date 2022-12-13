public class Calculation{
	
	public int SumOfSeries(int start, int end, int incr){
		
        int output = 0;
		
        for(int i = start; i <= end; i= i+incr){
            output = output + i;
			
        }
        return output; 		
	}
	
	public int SumOfArray(int data[], int size){
		
        int output = 0;
		
        for(int i = 0; i<size; i++){
            output = output + data[i];
			
        }
        return output;	
	}
	
	public int ProductOfSeries(int start, int end, int incr){
        int product = 0;
		
        for(int i = start; i <= end; i= i+incr){
            product = product*i;
			
        }
        return product;			
	}
	
	public int ProductOfArray(int data[], int size){
        int product = 0;
		
        for(int i = 0; i<size; i++){
            product = product*data[i];
			
        }
        return product;		
	}

}