package s14.p02;


public class Main {
    public static void main(String[] args) {
        Thread p1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.print("~");
                Thread.yield(); // 다른 스레드로 양보하고 바로 실행 대기
//                try {
//                    Thread.sleep(1); // Running 상태에서 Timed_Waiting 상태로 이동
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });

        Thread p2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.print("*");
                Thread.yield();
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });

        // Priority 기능은 있으나, 보장되지 않는다.
        // 이유는 Starving하는 Thread가 없게 하기 위해서 OS가 조절하기 때문
        System.out.println(p1.getPriority()); // 우선순위 - 값이 높을 수록 우선순위가 높다.

        p1.setPriority(Thread.MAX_PRIORITY);
        p2.setPriority(Thread.MIN_PRIORITY);

        p1.start();
        p2.start();
    }
}
