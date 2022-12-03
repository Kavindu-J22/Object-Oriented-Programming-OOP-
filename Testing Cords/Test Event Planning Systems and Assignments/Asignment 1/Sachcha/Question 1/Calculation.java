public class Calculation{
	
	public int SumOfSeries(int start, int end, int incr){
		
        int answer1 = 0;
		
        for(int i = start; i <= end; i= i+incr){
            answer1 = answer1 + i;
        }
        return answer1; 		
	}
	
	public int SumOfArray(int data[], int size){
		
        int answer1 = 0;
		
        for(int i = 0; i<size; i++){
            answer1 = answer1 + data[i];	
        }
        return answer1;	
	}
	
	public int ProductOfSeries(int start, int end, int incr){
        int productos = 0;
		
        for(int i = start; i <= end; i= i+incr){
            productos = productos*i;	
        }
        return productos;			
	}
	
	public int ProductOfArray(int data[], int size){
        int productos = 0;
		
        for(int i = 0; i<size; i++){
            productos = productos*data[i];	
        }
        return productos;		
	}

}