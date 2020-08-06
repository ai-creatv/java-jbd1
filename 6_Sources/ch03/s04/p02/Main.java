package s04.p02;

/**
 * 클래스의 포함 관계 (Class Composition)
 * 상속하고 유사하지만, 한 클래스가 다른 클래스의 객체를 포함하는 관계
 * 내부에 포함하고 있어 'HAS-A' 관계로 표현된다.
 */

// MainMachine 'HAS-A' String
class MainMachine {
    String model;
    boolean isBroken = false;

    public MainMachine(String model) {
        this.model = model;
    }
}

// Developer 'HAS-A' MainMachine
// Developer 클래스는 MainMachine의 객체 하나를 보유한다.
class Developer {
    String name;
    MainMachine mainMachine;

    public Developer(String name, MainMachine machine) {
        this.name = name;
        this.mainMachine = machine;
    }

    public void writeCode() {
        if (mainMachine.isBroken) {
            System.out.println("코딩을 할 수 없습니다.");
        } else {
            System.out.println(mainMachine.model + "(으)로 코딩하기");
        }
        if (Math.random() > 0.9) {
            breakMachine();
        }
    }

    public void breakMachine() {
        mainMachine.isBroken = true;
    }
}

public class Main {
    public static void main(String[] args) {
        MainMachine mac = new MainMachine("MacBook Pro");
        Developer dev = new Developer("너개발", mac);

        for (int i = 0; i < 10; i++) {
            dev.writeCode();
        }
    }
}
