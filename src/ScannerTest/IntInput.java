package ScannerTest;

import java.util.Scanner;

public class IntInput {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        String msg = sc.next();

        System.out.println("The num is " + num + ", message is " + msg);

    }
}
