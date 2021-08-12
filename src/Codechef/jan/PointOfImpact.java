package Codechef.jan;

import java.util.ArrayList;
import java.util.Scanner;
class Pair{
    int x,y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
     }
}
public class PointOfImpact {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt() - 1;
            int x = sc.nextInt();
            int y = sc.nextInt();
            Pair p = new Pair(x,y);
            ArrayList<Pair> al = new ArrayList<>();
            if(x==y) al.add(new Pair(n,n));
            else if((x == 0 && y == 0) || (x == 0 && y == n) || (x == n && y == 0) || (x == n && y == n)) al.add(new Pair(x,y));
            else if(x > y) {
                // will hit the row first
                int diff = n - x;
                al.add(new Pair(n, y + diff)); //(Row,)
                al.add(new Pair( y + diff,n)); // (, Col)
                al.add(new Pair(0, n - (y+diff))); // (0, )
                al.add(new Pair(n - (y+diff), 0)); // (, 0)
            }
            else {
                // will hit the col first
                int diff = n - y;
                al.add(new Pair(x+diff, n)); // (, col)
                al.add(new Pair(n, x+diff)); // (Row, )
                al.add(new Pair(n - (x+diff), 0)); // (, col)
                al.add(new Pair(0, n - (x+diff))); // (Row, )
            }
            if(al.size() == 1) System.out.println(al.get(0).x + " " + al.get(0).y);
            else System.out.println(al.get(k%4).x + " " + al.get(k%4).y);
        }
    }
}
