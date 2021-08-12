package Codechef.jan;

import java.util.Scanner;

public class Division {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int d = sc.nextInt();
            //int a[] = new int[n];
            int sum = 0;
            for(int i=0;i<n;i++) {
                sum += sc.nextInt();
            }
            int dS = sum/k;
            if(dS>d) System.out.println(d);
            else System.out.println(dS);
        }
    }
}
