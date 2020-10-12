package ch5.s04.p03;

class Outer {
    static class ClassInner {
        int innerVar = 1;
        static int staticInnerVar = 100;

        void innerMethod() {
            Outer outer = new Outer();
            System.out.println(outer.outerVar); // 이상하지만... 받아들이세요.
            System.out.println(innerVar);
        }
    }

    private int outerVar = 2;

    
}

public class Main {
    public static void main(String[] args) {

    }
}
