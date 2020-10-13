package s01.p03;

import java.util.ArrayList;
import java.util.List;

/**
 * 옵저버 패턴 (Observer pattern)
 * - Observable 객체의 변화를 Observer에서 알 수 있도록 하는 패턴
 * - GUI에 많이 사용되는 패턴
 * - 게임에도 많이 쓰임
 * - 즉, 보통 Hierarchy가 있는 경우 (계층이 있는 경우) 많이 사용됨
 */

class Subject { // 관찰 대상인 클래스
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }

}

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

class BinaryObserver extends Observer {
    public BinaryObserver (Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        int state = this.subject.getState();
        System.out.println(Integer.toBinaryString(state));
    }
}


class OctalObserver extends Observer {
    public OctalObserver (Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        int state = this.subject.getState();
        System.out.println(Integer.toOctalString(state));
    }
}


class HexObserver extends Observer {
    public HexObserver (Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        int state = this.subject.getState();
        System.out.println(Integer.toHexString(state));
    }
}

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observerOne = new HexObserver(subject);
        Observer observerTwo = new BinaryObserver(subject);
        Observer observerThree = new OctalObserver(subject);

        subject.setState(10);
        subject.setState(20);
        subject.setState(40);
    }
}
