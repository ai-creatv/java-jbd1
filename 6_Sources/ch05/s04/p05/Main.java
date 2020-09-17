package ch5.s04.p05;

interface IFoo {
    void run();
    void walk();
}

class Foo implements IFoo {
    @Override
    public void run() {
        System.out.println("Normally Run");
    }

    @Override
    public void walk() {
        System.out.println("Normally Walk");
    }
}


class AnonymousInnerClass {
    static void useIFoo(IFoo foo) {
        foo.run();
        foo.walk();
    }

    public static void main(String[] args) {
        // 1.
        Foo foo = new Foo();
        useIFoo(foo); // Using Polymorphism

        // 2.
        class InnerClass implements IFoo {
            @Override
            public void run() {
                System.out.println("Run, Foo Run!");
            }

            @Override
            public void walk() {
                System.out.println("Walk... Foo... Walk...");
            }
        }

        InnerClass ic = new InnerClass();
        useIFoo(ic); // Polymorphism + Local inner class


        // 3.
        useIFoo(new IFoo() {
            @Override
            public void run() {
                System.out.println("Run!!!");
            }

            @Override
            public void walk() {
                System.out.println("Wal...k....");
            }
        }); // Polymorphism + Anonymous inner class

    }
}


interface IBar {
    void run(int x, int y);
}

class Bar implements IBar {
    @Override
    public void run(int x, int y) {
        System.out.println("Bar");
    }
}

public class Main {
    static void runIBar(IBar bar) {
        bar.run(10, 100);
    }

    public static void main(String[] args) {
        runIBar(new Bar());

        class InnerBar implements IBar {
            @Override
            public void run(int x, int y) {
                System.out.println("InnerBar");
            }
        }
        runIBar(new InnerBar());

        runIBar(new IBar() {
            @Override
            public void run(int x, int y) {
                System.out.println("Anonymous");
            }
        });

        // This!!! IS!!!! Lambda!!! EXPRESSION!!!!!
        runIBar((x, y) -> {
            System.out.println(x);
            System.out.println(y);
            System.out.println("LAMBDA!!!!!");
        });
    }
}
