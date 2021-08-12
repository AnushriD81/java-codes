package algorithims;

import java.util.HashMap;
import java.util.Map;

public class MinimumToGetZero {

    static Map<String,Integer> mp;
    public static int minSize(int a[], int x, int l, int r) {
        String s = x + "_" + l + "_" + r;
        if(x==0) return 0;
        else if(mp.containsKey(s)) return mp.get(s);
        else if(l>r) return 2*a.length;
        else {
            int cnt;
            if(a[l] <= x && a[r] <= x)
                cnt = 1+ Math.min(minSize(a,x-a[l], l+1, r), minSize(a,x-a[r], l, r-1));
            else if(a[l]<= x) cnt = 1+minSize(a,x-a[l], l+1, r);
            else cnt = 1 + minSize(a,x-a[r], l, r-1);
            mp.put(s,cnt);
            return cnt;
        }
    }

    public static void main(String args[]) {
        int a[] = {5,6,7,8,9};
        int x = 4;
        mp = new HashMap<>();
        int cnt = minSize(a,x,0, a.length-1);
        if(cnt > a.length) cnt = -1;
        System.out.println(cnt);
    }
}
