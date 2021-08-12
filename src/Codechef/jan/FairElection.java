package Codechef.jan;

import java.util.Arrays;
import java.util.Scanner;

public class FairElection {
    public static int swaps(int a[], int b[], long sumA, long sumB) {
        Arrays.sort(a);
        Arrays.sort(b);
        int cnt = 0, k = b.length-1;
        boolean flag = false;
        for(int i=0;i<a.length;i++) {
            sumA = sumA - a[i] + b[k];
            sumB = sumB - b[k] + a[i];
            if(sumA <= sumB) {
                cnt++;
                k--;
            }
            if(sumA > sumB) {
                cnt++;
                flag = true;
                break;
            }
        }
        if(flag) return cnt;
        else return -1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[m];
            long sumA = 0, sumB= 0;
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
                sumA += a[i];
            }
            for(int i=0;i<m;i++) {
                b[i] = sc.nextInt();
                sumB += b[i];
            }
            if(sumA > sumB) System.out.println(0);
            else System.out.println(swaps(a,b,sumA,sumB));
        }
    }
}
