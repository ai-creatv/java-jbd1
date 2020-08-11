package s02;

/**
 * 인터페이스 (Interface)
 * - 클래스가 사용되는 방식/접점만을 선언하는 클래스와 유사한 틀
 * - 아무런 구현이 되어 있지 않으며, 모든 메소드가 추상 메소드
 *
 * 인터페이스의 특징
 * - class 가 아니고 interface 키워드를 사용
 * - 멤버 변수는 항상 "public static final"이다. (생략 가능)
 * - 멤버 메소드는 항상 "public abstract"이다. (생략 가능)
 * - 클래스는 하나만 상속할 수 있으나, 인터페이스는 여러개 가능
 * - 인터페이스의 상속은 implements 키워드
 */

// public, default가 가능
interface IFoo {
    public static final int MEMBER_VAR = 10;
    int MEMBER_VAR2 = 20; // public static final

    public abstract void methodA(int param);
    void methodB(int param); // public abstract
}

class Foo implements IFoo {

    @Override
    public void methodA(int param) {
        System.out.println(param);
    }

    @Override
    public void methodB(int param) {
        System.out.println(param);
    }
}

// interface IFoo <- class Foo
// interface Printable <- class Bar

/**
 * 인터페이스간의 상속
 * 인터페이스로 인터페이스를 상속할 경우, extends
 * 클래스 <- 클래스 상속과 달리 다중 상속 가능
 */

interface Walkable {
    void walk();
}

interface Runnable {
    void run();
}

interface Jumpable extends Walkable, Runnable {
    void jump();
}

class Jumper implements Jumpable {
    @Override
    public void walk() {
        System.out.println("walk");
    }

    @Override
    public void run() {
        System.out.println("run");
    }

    @Override
    public void jump() {
        System.out.println("jump");
    }
}

/**
 * JDK 1.8 이후의 인터페이스
 *
 * - 인터페이스에는 default 메소드를 구현할 수 있음
 * - default 메소드는 항상 public이다.
 * - 인터페이스의 철학과 맞지 않으나,
 *   기존에 사용하던 인터페이스가 개선되어, 모든 자식 메소드에 동일하게
 *   구현되어야 하는 메소드가 생긴 경우에 쉽게 기능을 추가하기 위해 만들어짐
 */

interface IFooTwo {
    void abstractMethod();
    default void defaultMethod() { // 디폴트 메소드
        System.out.println("Default method");
    }
}

class FooTwo implements IFooTwo {
    @Override
    public void abstractMethod() {
        System.out.println("Abstract method implemented");
    }
}

class SuperFoo {
    public void defaultMethod() {
        System.out.println("Default method in Super class");
    }
}

// 인터페이스의 static 메소드
interface IBar {
    static void staticMethod() {
        System.out.println("static method");
    }
}

class Bar implements IBar {
}


class FooThree extends SuperFoo implements IFooTwo {
    @Override
    public void abstractMethod() {
        System.out.println("abstract method implemented");
    }
}

public class Interface {
    public static void main(String[] args) {
        FooTwo footwo = new FooTwo();
        footwo.abstractMethod();
        footwo.defaultMethod();

        FooThree foothree = new FooThree();
        foothree.abstractMethod();
        foothree.defaultMethod(); // 부모와 인터페이스에 모두 메소드가 있는 경우,
        // 부모 클래스에 있는 메소드를 실행한다.
        // 다중 상속 시 문제를 방지하기 위해, 인터페이스보다 일반 상속이 우선시

        IBar.staticMethod(); // 인터페이스명으로 클래스 메소드 호출 가능
        // Bar.staticMethod(); // 구현체인 자식 클래스로는 클래스 메소드 호출 불가능

    }
}
