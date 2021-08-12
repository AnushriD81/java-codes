import java.io.IOException;
class P{}
class C extends P{}
public class File {

    public static void hello() {
        //throw new ArithmeticException("why");
    }
    public static void main(String args[]){
            hello();
            C c = (C)new P();
    }
}
