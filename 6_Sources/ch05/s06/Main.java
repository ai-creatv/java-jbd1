package ch5.s06;

import java.util.Scanner;

/**
 * java.lang 패키지
 * - Java에서 가장 기본적이며, 자주 사용되는 클래스를 모은 패키지
 * - 별도로 import를 하지 않아도 사용이 가능한 기본중의 기본
 */

public class Main {
    public static void main(String[] args) throws Exception{
        // Object 클래스
        // 모든 클래스의 조상 클래스 - 클래스의 기본 기능을 제공
        // 필요한 경우 Object 클래스에 구현된 메소드를 override해서 사용
        Object obj = new Object();
        Object obj1 = obj;
        Object obj2 = new Object();

        System.out.println(obj.getClass()); // Class 클래스 객체를 반환


        // equals() 메소드
        System.out.println(obj.equals(obj1)); // 동일 객체를 가르키는지 여부
        System.out.println(obj.equals(obj2)); // 동일 객체를 가르키는지 여부
        System.out.println();

        String str1 = "abc";
        String str2 = str1;
        String str3 = "abc";
        String str4 = new String("abc");

        System.out.println(str1 == str2); // 동일 객체인지 비교
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        System.out.println();

        // String의 경우 내용까지 (효율적으로)비교하게끔 Override
        System.out.println(str1.equals(str2)); // String의 equals는 내용만 같아도 true를 반환
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str4));

        // hashCode() 메소드
        // - 객체를 구분하기 위해서 사용하는 정수값(int)을 반환
        // - 각 객체마다 프로그램 내에서 유일하기 때문에 주소값처럼 사용 가능
        // - hashCode()는 native이기 때문에 정의를 볼 수 없다.
        //      - native: C 또는 C++ 등 외부 언어로 작성된 메소드
        // - hashCode()를 Override할 때 제약사항
        //    - 한 객체의 hashCode()를 여러번 호출할 경우,
        //      해당 객체의 equals()에서 사용하는 값이 변하지 않았다면
        //      hashCode()의 반환값은 동일해야 한다. (필수)
        //    - equals() 메소드가 같다고 판단한 두 객체의 hashCode() 값은
        //       항상 같아야 한다. (필수)
        //    - equals() 메소드에서 다르다고 판단하는 두 객체는
        //      항상 hashCode() 값이 다를 필요는 없으나,
        //      다르면 Hash기반 자료구조의 성능이 향상된다. (권고)
        //   -> 즉, 같으면 hashCode()는 반드시 같고, 다르다고 hashCode()가 반드시 다른 것은 아니다.

        class Foo {
        }
        Foo foo = new Foo();
        System.out.println(foo.hashCode());
        // 일반적으로 Object에 구현된 hashCode를 그대로 쓰는 것이 좋다.


        // getClass(): 클래스 정보를 담고 있는 Class 객체를 반환
        class Bar{
            public void methodA() {
                System.out.println("method A is called.");
            }
        }
        // Class 클래스, Method 클래스의 활용
        //    Reflection API를 이용
        Bar bar = new Bar();
        Class barClass = bar.getClass();

        System.out.println(barClass.getName());
        System.out.println(barClass.getDeclaredMethods().length);
        barClass.getDeclaredMethod("methodA").invoke(bar);


        // System 클래스
        // OS와 interact하기 위한 클래스
        // 정적 변수, 메소드만으로 구성된 클래스
        System.out.println(System.out); // PrintStream 객체
        System.out.println(System.err); // PrintStream 객체
        System.out.println(System.in); // InputStream 객체
        // Stream API와는 다른, I/O Stream이다.
        System.out.println("f"); // 표준 출력을 처리하기 위한 객체
        System.err.println("w"); // 오류를(표준 출력 장치에) 출력하기 위한 객체
        Scanner scanner = new Scanner(System.in); // 표준 입력장치를 사용하기 위한 객체

        // arraycopy() : native 구현으로, 더 효율적인 구현이 되어 있다.
        int[] ints = {1, 2, 3, 4};
        int[] ints1 = new int[10];
        System.arraycopy(ints, 0, ints1, 0, ints.length);

        // currentTimeMillis(), nanoTime() (시간)
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime()); // RTOS가 아니기 때문에 정확하지 않을 수 있음
        System.out.println(System.nanoTime());

//        System.exit(1); // 프로그램 강제 종료
        // status = 0: 정상 종료. status != 0: 비정상 종료 (1)
        
        System.gc(); // Garbage Collection
                    // 꼭 실행할 필요는 없으나, 좀더 빨리 해달라고 요청하는 정도
        System.out.println(System.getenv("JAVA_HOME"));
        System.out.println(System.getProperties());
        System.out.println(System.getProperty("user.country"));
        System.out.println(System.getProperty("java.io.tmpdir"));
        System.out.println(System.getProperty("line.separator")); // windows \r\n, UNIX \n
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("file.separator")); // windows \ UNIX /
    }
}
