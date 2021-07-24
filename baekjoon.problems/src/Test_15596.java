//long sum(int[] a);
public class Test_15596 {
	long sum(int[] a) {
		long s=0;
		
		for(int i=0; i<a.length; i++) {
			s += a[i];
		}
		
		return s;
	}

}
