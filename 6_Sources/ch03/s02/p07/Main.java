package s02.p07;

/**
 * 초기화 블록 (Initializer)
 */
public class Main {
    static int classVar;
    static int instanceCount;
    int instanceVar;

    // static initializer
    static {
        System.out.println("static block1");
        classVar = 20;
    }

    // object initializer
    {
        System.out.println("block1");
        instanceVar = 30;
        classVar = 50; // 추천되지 않는다.
        instanceCount++; // 이러한 패턴은 사용된다.
    }

    static {
        System.out.println("static block2");
        classVar = 5;
    }

    {
        System.out.println("block2");
        instanceVar = 5;
    }
}

class MainTest {
    public static void main(String[] args) {
        System.out.println(Main.classVar);
        Main main = new Main();
        System.out.println(Main.instanceCount);

        System.out.println(main.instanceVar);
        System.out.println(Main.classVar);

        Main main2 = new Main();
        System.out.println(Main.instanceCount);
        Main main3 = new Main();
        System.out.println(Main.instanceCount);
    }
}