package ch5.s04.p02;

class Outer {
    class InstanceInner {
        int x = 1;

        void innerMethod() {
            int x = 0;
            System.out.println(x); // 0
            System.out.println(this.x); // 1
            System.out.println(Outer.this.x); // 2
            System.out.println(Outer.y); // 3 static variable
        }
    }

    private int x = 2;
    private static int y = 3;

    public static void main(String[] args) {
        Outer outer = new Outer();
        InstanceInner inner = outer.new InstanceInner();
        inner.innerMethod();
    }

}

public class Main {
}
