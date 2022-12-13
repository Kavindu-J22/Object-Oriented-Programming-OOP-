public class Db{
	public static void main(String args[]){
		int n = 5;
		int x,y,z;
		for(x=0;x<n;x++){
			for(y=11;y>x;y--){
				
				System.out.print(" ");
			}for(z=0;z<(2*x-1);z++){
				
				System.out.print("*");
			}
			System.out.println("");
		}
		for(int a=1;a<n;a++){
			for(int b=5;b>a;b--){
				System.out.print(" ");
			}
			for(int c=1;c<=(2*n+(2*a));c++){
				System.out.print("*");
			}
			System.out.println("");
		}
		for(int d=1;d<n;d++){
			for(int e=0;e<d;e++){
				System.out.print(" ");
			}
			for(int f=20;f>2*d;f--){
				System.out.print("*");
			}
			System.out.println("");
		}
		for(int g=1;g<n;g++){
			for(int h=10;h<(10+n+g);h++){
				System.out.print(" ");
				
			}
			for(int i=2;i<(n*2 -(2*g-1));i++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}
}