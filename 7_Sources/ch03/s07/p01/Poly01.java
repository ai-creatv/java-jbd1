package s07.p01;

/**
 * 부모 클래스 타입으로 자식 클래스 타입의 객체를 참조하는 특징
 */

class Foo {
    public void methodA() {}
}

class Bar extends Foo {
    public void methodB() {}
}

public class Poly01 {
    public static void main(String[] args) {
        Bar bar = new Bar(); // 자식 객체를 생성
        Foo foo = (Foo)bar; // 부모 클래스 타입으로 자식 객체를 받음
        // 여전히 힙 영역에는 자식 객체가 있습니다.

        foo.methodA();
        // foo.methodB(); // 이 경우 자식 클래스 메소드는 사용이 불가능
        // 문법적으로 불가능함

        Foo foo1 = new Foo();
//         Bar bar1 = (Bar)foo1; // 자식 클래스 타입으로 부모 객체를 받음
        // 문법 오류는 아니지만, 런타임 오류가 발생
        // 자식 클래스 자료형으로 객체를 보려 하지만, 부모 객체 부분만 있기 때문에
        // 런타임에서 오류를 발생시킴

        // bar1.methodA(); // 문법오류x 성립하지않음
        // bar1.methodB(); // 문법오류x 성립하지않음

        // 힙 영역에는 계속 자식 객체가 있었던 것
        Bar bar1 = (Bar)foo; // 자식 클래스 타입으로 자식 객체를 받음
        bar1.methodA();
        bar1.methodB();
    }
}
