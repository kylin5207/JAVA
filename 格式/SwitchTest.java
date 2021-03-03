package Test1;

import java.util.Scanner;

/*
 * switch¡∑œ∞
 */
public class SwitchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		switch(a)
		{
			case 1:
				System.out.println("a = 1");
				break;
			case 2:
				System.out.println("a = 2");
				break;
			default:
				System.out.println("a != 1 and a != 2");
		}
	}

}
