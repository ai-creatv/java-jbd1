package s01;

/**
 * Wrapper 클래스 (Wrapper class)
 * - 기본형 타입을 객체로 쓰기 위해 있는 클래스
 * - 기본형 타입이 허용되지 않는 문법에 기본형 타입을 쓰기 위해서 제공
 *
 * byte -> Byte
 * char -> Character
 * short -> Short
 * int -> Integer
 * long -> Long
 * float -> Float
 * double -> Double
 * boolean -> Boolean
 *
 */



public class WrapperClass {
    public static Integer add(Integer x, Integer y) {
        return x + y; // Unboxing
        // 자동으로 기본자료형으로 변형되어서 계산
        // 반환 시에는 다시 Autoboxing이 이루어짐
    }

    public static <T> T bypass (T x) {
        return x;
    }


    public static void main(String[] args) {
        Integer integer = new Integer(10);
        Integer integer1 = Integer.valueOf(10);


        Character character = new Character('d');
        Character character1 = Character.valueOf('f');

        // Autoboxing
        Integer integer2 = 4;
        System.out.println(add(4, 2));

        bypass(5); // autoboxing
        // T: Wrapper class인 Integer로 결정됨
        // 5 -> new Integer(5) (Autoboxing)

        // 문자열 <-> 기본자료형
        int x = Integer.parseInt("100"); // parse+자료형 정적 메소드
        int y = new Integer("100");
        int z = Integer.valueOf("200");

        int m = new Integer(10); // 기본 자료형이 필요한 자리에
        // Wrapper class 객체가 있을 경우 자동 unboxing이 이루어짐
    }
}
