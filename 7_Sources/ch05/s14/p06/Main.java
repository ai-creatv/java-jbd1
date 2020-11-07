package s14.p06;

class WorkObject {
    public synchronized void methodA() {
        System.out.println("methodA() called");
        notify(); // wait()중인 다른 스레드를 하나 동작 상태로 만든다.
        try {
            wait(); // Lock을 반환하고 대기 상태로 들어감.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//
//    public void methodASAME() {
//        synchronized (this) {
//            System.out.println("methodA() called");
//            notify(); // 대기중인 다른 스레드를 하나 동작 상태로 만든다.
//            try {
//                wait(); // 대기 상태로 들어감.
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public synchronized void methodB() {
        System.out.println("methodB() called");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyThread extends Thread {
    private final WorkObject workObject;
    private boolean isA;

    public MyThread(WorkObject workObject, boolean isA) { // Dependency Injection
        this.workObject = workObject;
        this.isA = isA;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (isA) {
                workObject.methodA();
            } else {
                workObject.methodB();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        WorkObject sharedObj = new WorkObject();

        Thread p1 = new MyThread(sharedObj, true);
        Thread p2 = new MyThread(sharedObj, false);

        p1.start();
        p2.start();
    }
}
