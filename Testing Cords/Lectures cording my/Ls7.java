import java.util.*;

public class Ls7{
	public static void main(String args[]){
		Scanner ls = new Scanner(System.in);
		int a[] = {0,0,0};
		
		System.out.println("Enter 3 integer");
		for(int i = 0;i<3;i++){
			System.out.println("\nEnter "+(i+1)+" integer");
			a[i] = ls.nextInt();
		}
		int max = a[2];
		int min = a[2];
		for (int r = 0;r<3;r++){
			if(a[r] > max){
				max = a[r];
			}
			if(a[r] < min){
				min = a[r];
			}

		}
			System.out.println("MAX : "+max);
			System.out.println("MIN : "+min);
		
	}
}