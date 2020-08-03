package com.company;

/**
 * 문자열 (String)
 *
 * 문자열은 내부적으로 '클래스'로 구성되어 있다.
 * 내부에는 문자의 배열로 된 데이터가 있다. char []
 * 한번 만든 문자열은 변하지 않는다. (Immutable)
 *
 * 문자열 편집은 String을 쓰지 않고 Builder나 Buffer 등을 사용한다.
 */

public class Main {

    public static void main(String[] args) {
	    // 문자열의 생성
        String s1 = "문자열 생성 방법";
        String s2 = new String("문자열 생성 방법2"); // 클래스 생성자. 권장하지 않음

        String s3 = "abcde";
        String s4 = "abcde";
        String s5 = new String("abcde");

        System.out.println(s3 == s4); // 문자열을 곧바로 생성할 경우 상수 풀에서 찾아 사용
        System.out.println(s3 == s5); // 문자열을 클래스로 생성할 경우 새로운 값을 생성 권장하지 않음

        System.out.println(s3.equals(s4));
        System.out.println(s3.equals(s5));

        String s = "This is a string.";
        System.out.println(s.length());
        System.out.println(s.charAt(2));
        System.out.println(s.indexOf('a'));
        System.out.println(s.equalsIgnoreCase("this Is A STRING."));
        System.out.println(s.replace('i', 't'));
        // 기존의 String을 바꾸는 것이 아니라, 변경된 String을 새로 생성해서 출력.
        System.out.println(s);
        System.out.println(s.substring(3, 9)); // 3~8까지로 새로운 String 생성 후 출력
        System.out.println(" wwefw ".trim()); // 양 옆의 공백을 제거해주는 메소드
        System.out.println("*".repeat(10));

        char [] characters = s.toCharArray(); // 새로운 문자 배열을 만들어 반환
        for (char value: characters) {
            System.out.println(value);
        }

    }
}
