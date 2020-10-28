package s14.p05;


/**
 * Intrinsic Lock (고유 락)과 synchronized 키워드
 * - 자바의 모든 객체 (Object)는 고유 락을 가지고 있음
 *   - 객체의 소유권을 한정하는 내부적인 구현 -> 소유권은 독점적이다.
 * - synchronized를 이용하면 객체의 고유 락의 소유권을 가져올 수 있다.
 *   - 소유권이 이미 점유된 경우에는 Blocking으로 동작
 */

// 1. 멀티스레드 동작에 취약한 구현
class Counter {
    private int count = 0;
    public int increaseCount() {
        return ++count; // 읽고, 수정하고, 쓰는 작업
        // 경쟁적으로 동작하다 보면, 읽고 수정하고 쓰기 전에 다른 쓰레드가 읽는 경우가 발생
    }

    public int getCount() {
        return count;
    }
}
//
//// 2. Object 객체의 Intrinsic Lock을 이용한 구현 - 굳이 이렇게 할 필요 없음
//class Counter {
//    private Object lock = new Object();
//    private int count = 0;
//    public int increaseCount() {
//        synchronized (lock) {
//            return ++count; // 읽고, 수정하고, 쓰는 작업
//        }
//    }
//
//    public int getCount() {
//        return count;
//    }
//}


//// 3. this 객체의 Intrinsic Lock을 이용한 구현
//class Counter {
//    private int count = 0;
//    public int increaseCount() {
//        synchronized (this) {
//            return ++count; // 읽고, 수정하고, 쓰는 작업
//        }
//    }
//
//    public int getCount() {
//        return count;
//    }
//}

//// 4. 메소드에 synchronized 키워드 사용
////  synchronized 키워드가 사용된 메소드를 호출하기 위해서는
//// 해당 객체를 소유해야만 호출이 가능. 소유하지 못하면 Blocking
//class Counter {
//    private int count = 0;
//    public synchronized int increaseCount() {
//        return ++count; // 읽고, 수정하고, 쓰는 작업
//    }
//
//    public int getCount() {
//        return count;
//    }
//}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
//                synchronized (c) { // 이렇게 싱크를 하면 어떻게 될까?
                    // 이렇게 싱크를 하면, 병렬 동작이 전혀 이루어지지 않는다.
                    // 이러면 가장 안전하지만 가장 효율이 떨어지는 코드가 된다.

                    for (int j = 0; j < 100; j++) {
                        // c라는 shared object (공유 객체)가 있을 때
                        // 멀티스레드로부터 안전한 영역을 생성하는 방법
                        synchronized (c) { // c의 고유 락을 획득해야만 동작
                            c.increaseCount();
                        }
                    }
//                }
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(c.getCount());
    }
}
