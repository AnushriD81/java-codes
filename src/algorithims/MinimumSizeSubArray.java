package algorithims;

import java.util.Arrays;

public class MinimumSizeSubArray {


    public static int minSize(int a[], int n, int k) {
        int size =Integer.MAX_VALUE;
        if(a[0] >= k) return 1;
        for(int i=1;i<n;i++) {
            if(a[i] >= k) return 1;
            a[i] = a[i] + a[i-1];
        }
        for(int i=0;i<n;i++) {
            int cnt = Integer.MAX_VALUE, index;
            if(a[i] >= k) {
                    if(a[i] == k) cnt = i+1;
                    else {
                        index = Arrays.binarySearch(a,a[i]-k);
                        if(index < 0 && index != -1) index = Math.abs(index+1) - 1;
                        cnt = i - index;
                    }
            }
            size = Math.min(size, cnt);
        }
        if(size == Integer.MAX_VALUE) return 0;
        return size;
    }

    public static void main(String args[]) {
        int a[] = {1,4,4};
        int k = 4;
        System.out.println(minSize(a,a.length,k));
    }
}
