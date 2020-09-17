package ch5.s04.p01;

class Outer {
    class InstanceInner {
        int innerMemberVar = 1;
        // static int staticVar = 20;
        static final int CONSTANT_VAR = 1000;

        void innerMethod() {
            System.out.println(innerMemberVar);
            System.out.println(outerMemberVar); // outer의 private 멤버 변수에도 접근 가능
        }
    }

    private int outerMemberVar = 2;

    void outerMethod() {
        InstanceInner obj = new InstanceInner();
        obj.innerMethod();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        InstanceInner inner = outer.new InstanceInner();

        inner.innerMethod();
    }
}

public class InnerClasses {

    public static void main(String[] args) {

    }
}
