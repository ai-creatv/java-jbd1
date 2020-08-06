package s04.p05.subp01;

import java.util.stream.DoubleStream;

public class ClassA {
    public int x;
    protected int y;
    int z; // default (=package)
    private int w;

    public void methodA() {}
    protected void methodB() {}
    void methodC() {} // default (=package)
    private void methodD() {} // 내부 구현을 위해서만 쓴다.

    public void methodTest() {
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(w);

        methodA();
        methodB();
        methodC();
        methodD();
    }
}

class ClassATest { // 같은 패키지
    public static void main(String[] args) {
        ClassA obj = new ClassA();
        System.out.println(obj.x);
        System.out.println(obj.y);
        System.out.println(obj.z);
        // System.out.println(obj.w); private

        obj.methodA();
        obj.methodB();
        obj.methodC();
        // obj.methodD(); private
    }
}