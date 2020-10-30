package s14.p10;

import java.util.concurrent.*;

/**
 * Thread Pool
 * - 스레드를 직접 만들어 사용할 경우, 작업을 마친 스레드는 종료됨
 *   -> 멀티스레드 작업을 계속 할 경우, 스레드를 생성/삭제하는 오버헤드가 있다.
 * - 스레드 풀
 *   - 미리 스레드를 생성해 두고, 작업만 스레드에 할당하여 동작
 *   - 미리 생성해 둔 스레드의 집합을 스레드 풀이라고 함
 *   - 배치 작업 (모아두고 한번에 처리하는 작업)에 많이 사용
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 1. 스레드 풀 생성
        ExecutorService pool1 = Executors.newCachedThreadPool();
        /**
         * newCachedThreadPool
         * - 초기 스레드가 0개
         * - 코어 스레드가 0개 - 일하지 않아도 살려두는 스레드
         * - 요청 작업보다 스레드가 부족하면 새 스레드를 생성
         * - 60초동안 일하지 않은 스레드는 제거
         */
        ExecutorService pool2 = Executors.newFixedThreadPool(10);
        /**
         * newFixedThreadPool
         * - 최대 스레드 nThread개
         * - 코어 스레드 nThread개
         * - 작업하지 않는 스레드도 제거하지 않고 동작
         */

        ExecutorService es = new ThreadPoolExecutor(
                10, // 코어 스레드 개수
                100, // 최대 스레드 개수
                120, // 스레드가 이 시간동안 일하지 않으면 제거
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>() // 요청 -> 작업을 쌓아둘 큐 -> 스레드풀
        );

        // 2. 스레드에 할당할 작업 생성
        class Work implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        }

        class CallableWork implements Callable<String> {

            @Override
            public String call() {
                while(true) {
                    int x = 2;
                    System.out.println("test");
                    try {
                        if (x == 1) {
                            break;
                        }
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                return "작업 종료";
            }
        }

        // 3. 스레드에 작업 요청
        Future<String> future;
        future = pool1.submit(new CallableWork());
        for (int i = 0; i < 100; i++) {
            pool1.submit(new Work());
        }

        // 4. 스레드 종료 (동기화)
        // 스레드 풀은 자동 종료가 안되기 때문에, 직접 스레드풀을 종료해 주어야 한다.
        pool1.shutdown(); // Thread.join()과 마찬가지로 작업이 끝나기를 기다려서 종료

        Thread.sleep(1000);


//            System.out.println(future.get()); // get()은 Blocking method
            // -  get()이 영원히 기다릴 수 있으므로 timeout 설정 가능
        future.cancel(true);
        // cancel을 호출하고 나면 get을 호출할 수 없다(CancellationException) 발생
        // mayInterruptIfRunning이 true이면, 스레드에 interrupt도 발생시킨다.
        try {
            future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(future.isCancelled());
//            System.out.println(future.isDone());

    }
}
