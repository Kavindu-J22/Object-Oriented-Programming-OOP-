public class Arr9{
	public static void main(String args[]){
		
		//Array option 1
		
		int arr[] = new int[3];
			arr[0] = 34;
			arr[1] = 56;
			arr[2] = 76;
			
		//Array option 2
		
		int array[] = {33,65,75};
			System.out.println(array[2]);
			System.out.println();
			System.out.println();
			
		// 2 Dimentiontional Array opt 1 
		
		int ary[][]= new int[2][2];
			ary[0][0] = 11;
			ary[0][1] = 34;
			ary[1][0] = 45;
			ary[1][1] = 56;
			
			System.out.println(ary[0][0]);
			System.out.println(ary[1][0]);
			
		// 2 Dimentiontional Array opt 2
		
		 int arry[][] = {{21,35},{45,51}};
			System.out.println();
			System.out.println(arry[0][0]);
			System.out.println(arry[0][1]);
			System.out.println(arry[1][0]);
			System.out.println(arry[1][1]);
		
	}
}