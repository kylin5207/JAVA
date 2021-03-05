package Test1;

import java.util.Scanner;

/**5行7列
 * ABCDEFG
 * BABCDEF
 * CBABCDE
 * DCBABCD
 * EDCBABC
 */
public class AlphaGraph {

    public static void plotRow(int row, int m){
        char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int k = 0;
        int p = row;
        for (int i = 0; i < m; i++) {
            if(i < row){
                System.out.print(alpha[p % 26]);
                p--;
            }
            else{
                System.out.print(alpha[k % 26]);
                k++;
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        n 行数， m 列数
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            plotRow(i, m);
        }

    }
}
