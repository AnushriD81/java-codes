package algorithims;

public class MinimumNumberOfJump {
    public static int jumps(int a[], int i, int n) {
        if(i == n-1) return 0;
        if(a[i] == 0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int j=i+1;j<n && j<= a[i]+i;j++) {
            int best = jumps(a, j, n);
            if(best != Integer.MAX_VALUE && best + 1 < min) min = best +1;
            //System.out.println(j + " " + min + " " + a[j]);
        }
        return min;
    }
    public  static int minJumps(int[] arr){
        int dp[] = new int[arr.length];
        for(int i=1;i<arr.length;i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<i;j++) {
                if(i <= arr[j]+j && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1+dp[j]);
                }
            }

        }
        return dp[arr.length-1];
    }

    public static int minJ(int a[]) {
        if(a[0] == 0) return -1;
        int maxReach = a[0];
        int step = a[0];
        int jump = 1;
        for(int i=1;i<a.length;i++) {
            if(i == a.length-1) return jump;
            maxReach = Math.max(maxReach, i+a[i]);
            step --;
            if(step == 0) {
                jump++;
                if(i >= maxReach) return  -1;
                step = maxReach - i;
            }

        }
        return jump;
    }

    public static void main(String args[]) {
        int n = 11;
        int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(jumps(a,0,n));
        System.out.println(minJ(a));
    }
}
