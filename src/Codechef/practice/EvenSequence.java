package Codechef.practice;

import java.util.*;

public class EvenSequence {
        static Map<String, Integer> mp;
        public static int ES(int a[], int curr, int n, int freq, int even) {
            String sb = curr + "_" + n + "_" + freq + "_" + even;
            if(n== a.length) return even;
            else if(mp.containsKey(sb)) return mp.get(sb);
            else if(curr == 0) {
                mp.put(sb, ES(a, a[n], n+1,1, even));
                return mp.get(sb);}
            else if(curr == a[n]) {
                if((freq + 1)%2 == 0) even = even +2;
                mp.put(sb, ES(a, curr, n+1, freq+1, even));
                return mp.get(sb);
            }
            else {
                if(freq %2 == 0) {
                    mp.put(sb, ES(a, a[n], n+1, 1, even));
                    return mp.get(sb);
                }
                else {
                    mp.put(sb, Math.max(ES(a, curr, n+1, freq, even), ES(a, a[n], n+1, 1, even)));
                    return mp.get(sb);
                }
            }
        }

        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- >0) {
                mp = new HashMap<>();
                int n = sc.nextInt();
                int a[] = new int[n];
                for(int i =0;i<n;i++) {
                    a[i] = sc.nextInt();
                }
                int op = n - ES(a,0,0,0,0);
                System.out.println(mp);
                System.out.println(op);
            }
        }
}
