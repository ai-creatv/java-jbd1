package s14.p04;

/**
 * 데몬 스레드 (Daemon thread)
 * - 다른 스레드가 모두 종류될 경우, 스스로 종료되는 스레드 <- 정의
 * - 무한 루프로 대기하면서 동작하는 구현이 많음 <- 활용
 *   - 일정 시간마다 동작, interrupt등에 의해서 동작
 */
class AutoSaver extends Thread {
    public AutoSaver() {
        this.setDaemon(true); // 메인 스레드가 종료되면 스스로 종료되도록 데몬 설정
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Save Something...
            System.out.println("Auto Save Done!");
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        new AutoSaver().start();

        for (int i = 0; i < 15; i++) {
            Thread.sleep(1000);
            System.out.println("Working");
        }
    }
}
