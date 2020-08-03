package s02.p01;

/**
 * 클래스 - 객체를 생성하기 위한 설계도 (Class)
 * 객체 - 클래스를 구체화하여 값으로 생성된 것 (Object, instance)
 * 클래스를 객체로 만드는 과정 -> Instanciation
 */

class Car { // 클래스 이름은 보통 PascalCase로 적는다.
    int speed = 0; // 속성, 멤버 변수
    // 속성: attribute, field
    // 멤버 변수: member variable

    void move() { // **메소드 (method)**, (가끔 멤버 함수), (가끔 함수)
        speed = 10; // 행위를 구현, 속성을 변경
    }
}

public class Main {
    public static void main(String[] args) {
        Car carOne = new Car(); // new 키워드로 클래스에서 객체 생성
        System.out.println(carOne.speed); // .으로 속성 접근 가능
        carOne.move(); // 메소드 호출 (method call)
        System.out.println(carOne.speed);

        Car carTwo = new Car();
        System.out.println(carTwo.speed); // 독립적인 객체

        Car carThree = carOne; // 참조형 객체이므로 새 객체를 만들지 않았다.
        System.out.println(carThree.speed);
        carThree.speed = 5;
        System.out.println(carThree.speed);
        System.out.println(carOne.speed);
    }
}
