package sample;

public class Main {

    public static void main(String[] args) {
	    int x = 123;
	    int result = 0;
	    int i = 0;
	    do{
			result = result * i * 10 + (x % 10);
			System.out.println(result);
			x = x / 10;
			System.out.println(x);
			i++;
		}while(x / 10 > 0);
		result = result * (10 ^ (i + 1)) + (x % 10);
	    System.out.println(result);
    }
}
