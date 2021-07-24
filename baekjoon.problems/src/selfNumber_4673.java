public class selfNumber_4673 {

	public static void main(String[] args) {
		boolean[] check = new boolean[10001];
		
		for(int i=1; i<=10000; i++) {
			int self_num = Dn(i);
			if(self_num<=10000) {
				check[self_num] = true;
			}
		}
		
		for(int i=1; i<=10000; i++) {
			if(check[i] == false) {
				System.out.println(i);
			}
		}
		
	}

	public static int Dn(int num) {
		int sum=num;
		while(num != 0) {
			sum += num%10;
			num/=10;
		}
		return sum;
	}
}