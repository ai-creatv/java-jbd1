package ch5.s05.p04;

/**
 * 람다식과 익명클래스 객체가 동일한 것은 아니다 라는 것의 증명
 */

@FunctionalInterface
interface IFoo {
    String method();
}

public class Main {
    static void functionalMethod(IFoo foo) {
        System.out.println(foo.method());
    }

    void methodA() {
        functionalMethod(() -> {
            System.out.println("this: " + this); // 이 this가 왜 main의 this? -> 람다식은 익명 클래스와 달리 클래스가 만들어지지 않음
            System.out.println("OuterClass.this: " + Main.this);
            return "Lambda expression used.";
        });

        functionalMethod(new IFoo() { // 익명 클래스가 만들어지고, 그 객체가 만들어지는 과정이 실제로 발생함
            @Override
            public String method() {
                System.out.println("this: " + this); // 익명 클래스의 객체가 this가 됨
                System.out.println("OuterClass.this: " + Main.this); // 외부 클래스인 Main 객체의 this
                return "Anonymous local inner class used.";
            }
        });
    }

    public static void main(String[] args) {
        new Main().methodA();
    }
}
