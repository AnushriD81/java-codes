package algorithims;
interface A{
    int chk();
}
interface B {
    int chk();
}
public class Test implements A,B{
    @Override
    public int chk() {
        return 7;
    }
    public static void main(String args[]) {
        Test t = new Test();
        System.out.println(t.chk());
    }
}
