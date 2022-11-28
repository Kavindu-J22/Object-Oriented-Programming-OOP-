class Lottery{
	private int[] lotteryNumbers=new int[5];

	public Lottery(){
		for(int i=0;i<5;i++){
			this.lotteryNumbers[i]=(int)(Math.random()*10);
		}
	}

	public String findMatchingDigts(int userArray[]){
		String elements="(elements ";
		int count=0;
		System.out.println("lotteryNumbers array : ");
		System.out.print("\t[ ");
		for(int i=0;i<4;i++){
			System.out.print(lotteryNumbers[i]+" , ");
		}
		System.out.print(lotteryNumbers[4]+" ]\n");

		System.out.println("User's array : ");
		System.out.print("\t[ ");
		for(int i=0;i<4;i++){
			System.out.print(userArray[i]+" , ");
		}
		System.out.print(userArray[4]+" ]\n\n");


		if(userArray.length==5){
			for(int i=0;i<5;i++){
				if(this.lotteryNumbers[i]==userArray[i]){
					if(count==0){
						elements+=i;
					}
					else{
						elements+=","+i;
					}
					count++;
				}
			}
			if(count>1){
				return "There are "+count+" digits "+elements+")";
			}
			else if (count==1) {
				return "There is "+count+" digit "+elements+")";
			}
			else{
				return "There are no matching digits";
			}
		}
		
		return "Invalid Array Please check Size of the array!";
		
	}

}

public class IT21024122{
	public static void main(String[] args) {
		Lottery lottery=new Lottery();
		int[] userArray={1,7,3,8,6};
		String result=lottery.findMatchingDigts(userArray);
		System.out.println(result);
	}
}