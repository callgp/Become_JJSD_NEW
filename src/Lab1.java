
public class Lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sum is "+sum(3));
		System.out.println("fact is "+fact(3));
		int[] numbers={1,5,-4,1,3};
		System.out.println("min is"+findMin(numbers));
		System.out.println("min is"+findMax(numbers));
		System.out.println("avg is"+findAvg(numbers));
		System.out.println("04212020 at 5 pm");
	}

	private static int findAvg(int[] numbers) {
		// TODO Auto-generated method stub
		int sum=numbers[0];
		for(int i=0;i<numbers.length;i++){
			//if(numbers[i]>sum){
				sum=sum+numbers[i];
			//}
		}
		
		
		return sum/numbers.length;
	}

	private static int findMax(int[] numbers) {
		// TODO Auto-generated method stub
				int max=numbers[0];
				for(int i=0;i<numbers.length;i++){
					if(numbers[i]>max){
						max=numbers[i];
					}
				}
				
				
				return max;
	}

	private static int findMin(int[] numbers) {
		// TODO Auto-generated method stub
		int min=numbers[0];
		for(int i=0;i<numbers.length;i++){
			if(numbers[i]<min){
				min=numbers[i];
			}
		}
		
		
		return min;
	}

	public static int sum(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			System.out.print(i + "+" + sum);
			sum = sum + i;
			System.out.println( " =" + sum);
		}
		return sum;
	}
	
	
	public static int fact(int n){
		if(n==0){
			return 1;
			
		}
		return fact(n-1)*n;
	}
}
