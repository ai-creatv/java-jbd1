package s14.p08;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Philosopher extends Thread {
    private final int id;
    private final Fork left;
    private final Fork right;

    public Philosopher(int id, Fork left, Fork right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            try {
                left.acquire();
//                System.out.println(id + ": left taken.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                if (!right.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
                    left.release();
                    Thread.yield();
                    continue;
                }
//                System.out.println(id + ": right taken.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                System.out.println(id + " is eating.");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            left.release();
            right.release();
            Thread.yield();
        }
    }
}

class Fork extends Semaphore {

    public Fork() {
        super(1);
    }
}

public class Main {
    public static void main(String[] args) {
        Philosopher[] phils = new Philosopher[5];
        Fork[] forks = new Fork[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < 5 - 1; i++) {
            phils[i] = new Philosopher(i, forks[i], forks[(i + 1) % 5]);
        }
        phils[4] = new Philosopher(4, forks[0], forks[4]);

        for (int i = 0; i < 5; i++) {
            phils[i].start();
        }
    }
}
