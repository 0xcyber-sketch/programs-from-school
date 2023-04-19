package exersize_6_1;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 2;
		int sum = 0;
		while (i <= 100) {
			if (i % 2 == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println(sum);
		
	}

}
