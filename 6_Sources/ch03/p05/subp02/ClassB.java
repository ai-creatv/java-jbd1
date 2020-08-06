package s04.p05.subp02;

import s04.p05.subp01.ClassA;

class ClassAA extends ClassA {
    public void methodTest() {
        System.out.println(x); // public
        System.out.println(y); // protected 자식이면 다른패키지여도 ok
        // protected는 private처럼 쓰지만, 상속한 경우 구현 시 접근이 필요 할 때
        // System.out.println(z); // default
        // System.out.println(w); // private

        methodA(); // public
        methodB(); // protected
        // methodC(); // default
        // methodD(); // private
    }
}

public class ClassB {
    public static void main(String[] args) {
        ClassA obj = new ClassA();
        System.out.println(obj.x); // public
        //System.out.println(obj.y); // protected는 다른 패키지인 경우 자식만 된다.
        //System.out.println(obj.z); // default는 다른 패키지면 안됩니다.
        // System.out.println(obj.w); private

        obj.methodA();
        //obj.methodB(); //protected는 다른 패키지인 경우 자식만 된다.
        //obj.methodC(); // default는 다른 패키지면 안된다.
        // obj.methodD(); private
    }

}
