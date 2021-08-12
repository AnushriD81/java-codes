package Codechef.jan;

import java.util.HashMap;
import java.util.Scanner;

public class Encode {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Character> hm = new HashMap<>();
        for(int i=0;i<16;i++) {
            StringBuilder sb = new StringBuilder();
            if(i/8 == 0) sb.append("0"); else if(i/8 == 1) sb.append("1");
            if((i/4) %2 == 0) sb.append("0"); else if((i/4) %2 == 1)  sb.append("1");
            if((i/2) %2 == 0) sb.append("0"); else if((i/2) %2 == 1)  sb.append("1");
            if(i%2 == 0) sb.append("0"); else sb.append("1");
            hm.put(sb.toString(), (char)('a' + i));
        }
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            for(int i=0;i<n;i+=4) {
                String s2 = s.substring(i, i+4);
                System.out.print(hm.get(s2));
            }
            System.out.println();
        }
        //System.out.println(hm);
    }
}
