package ch5.s04.p04;

class LocalInnerClass {
    int x = 1;

    public Object methodA() {
        final int y1 = 2;
        int y2 = 2;

        class LocalInner {
            // static int z = 4; // **Impossible**
            static final int Z = 4; // Possible
            void methodA() {
                System.out.println(x);
                System.out.println(y1); // JDK1.7

                System.out.println(y2); // JDK1.8
                //y2++; // final 처럼 사용되어야 함
            }
        }

        LocalInner inner = new LocalInner(); // Heap area
        inner.methodA();

        return (Object)inner;

    }

    static {
        int y = 2;
        class LocalInner {
            void methodA() {
                System.out.println("a");
            }
        }
    }

    {
        int y = 2;
        class LocalInner {
            void methodA() {
                System.out.println(x);
            }
        }
    }

    public static void main(String[] args) {
        int y = 2;
        class LocalInner {
            void methodA() {
                System.out.println("a");
            }
        }
    }
}

public class Main {
}
