package Codechef.jan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoTower {
    static Map<String, Integer> mp;
    public static int tower(int a[], int i, int sumA, int sumB) {
        if(sumA <= 0 && sumB <= 0) return 0;
        else if(i == 0) return a.length+2;
        String sb = i + "_" + sumA + "_" + sumB;
        if(mp.containsKey(sb)) return mp.get(sb);
        int aSub = a.length+2, bSub = a.length+2;
        if(sumA >0){
            String s1 = (i-1) +"_" + (sumA - a[i-1])+"_"+ sumB;
            if(mp.containsKey(s1)) aSub = mp.get(s1);
            else {
                aSub = tower(a, i-1, sumA - a[i-1], sumB);
                mp.put(s1, aSub);
            }
        }
        if(sumB > 0){
            String s1 = (i-1) +"_" + sumA +"_"+ (sumB - a[i-1]);
            if(mp.containsKey(s1)) bSub = mp.get(s1);
            else {
                bSub = tower(a, i-1, sumA, sumB - a[i-1]);
                mp.put(s1, bSub);
            }
        }
        int min = Math.min(aSub+1, bSub+1);
        mp.put(sb, min);
        return mp.get(sb);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            mp = new HashMap<>();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            long sum = 0;
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
                sum += a[i];
            }
            if(sum < 2*k) System.out.println(-1);
            else {
                Arrays.sort(a);
                int res = tower(a,n,k,k);
                if(res > n)  System.out.println(-1);
                else System.out.println(res);
            }
        }
    }
}
