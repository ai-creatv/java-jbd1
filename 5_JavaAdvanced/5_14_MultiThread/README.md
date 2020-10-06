# Multi-Thread Programming

## Process and Thread

- Process: OS로부터 메모리를 할당받아 실행중인 프로그램
- Thread: 프로세스 동작의 최소 단위로, 하나의 프로세스는 여러 스레드로 이루어질 수 있다.

## 멀티스레드 프로그래밍의 장단점

- 장점
  - 여러 동작을 병렬적으로 처리하여 CPU의 사용률 향상
  - 시간이 걸리는 동작을 분리하여 프로그램의 응답성 향상
- 단점
  - Context Switching 오버헤드 발생
  - 스레드 제어의 어려움

## 스레드 구현

- 스레드 생성
  
  ```java
  Thread threadOne = new Thread(new Runnable() {
      public void run() {
          System.out.println("Hello Thread!");
      }
  });

  Thread threadTwo = new Thread(() -> {
      System.out.println("Hello Again, Thread!");
  });

  class MyThread extends Thread {
      public void run() {
          System.out.println("Hello Again Again, Thread!");
      }
  }
  Thread threadThree = new MyThread();
  ```

- 스레드 실행

  ```java
  Thread threadOne = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
          System.out.print("1");
      }
  });

  Thread threadTwo = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
          System.out.print("2");
      }
  });

  threadOne.start();
  threadTwo.start();
  System.out.println("Done!");
  ```

## 스레드의 상태 및 제어

- 스레드의 상태
  - getState() 메소드로 스레드의 상태를 확인할 수 있다.

    | 열거형 상수 | 설명 |
    |------------|------|
    | `NEW` | `start()` 메소드가 아직 호출되지 않음 |
    | `RUNNABLE` | JVM에 의해 실행 가능한 상태 |
    | `BLOCKED` | 객체가 블락된 상태 |
    | `WAITING` | `sleep()`, `wait()`, `join()` 등에 의해 무한히 대기 중인 상태 |
    | `TIMED_WAITING` | `sleep()`, `wait()`, `join()` 등에 의해 정해진 시간 동안 대기 중인 상태 |
    | `TERMINATE` | `run()` 메소드가 종료된 상태 |

- 스레드의 우선순위 제어
  
  ```java
  public final static int MIN_PRIORITY = 1;
  public final static int NORM_PRIORITY = 5;
  public final static int MAX_PRIORITY = 10;
  ```

  | 메소드 | 설명 |
  |-------|------|
  | `void setPriority(int newPriority)` | 새로운 우선순위로 설정한다. |
  | `int getPriority()` | 우선순위를 반환한다. |

- `sleep()`을 이용한 제어

  ```java
  Thread.sleep(1000); // ms
  Thread.sleep(100, 200); // ms + ns
  ```

- `join()`을 이용한 스레드 조인
  - 스레드 동작을 동기화하기 위해 사용
  
  ```java
  Thread t1 = new Thread(() -> System.out.println("A"));
  Thread t2 = new Thread(() -> System.out.println("B"));

  t1.start();
  t2.start();

  t1.join();
  t2.join();

  System.out.println("C");
  ```

- `interrupt()`를 이용한 대기 중지

  ```java
  Thread tSleep = new Thread(() -> {
      try {
          Thread.sleep(1000);
      } catch (InterruptedException e) {
          System.out.println("Interrupted");
      }
  });

  tSleep.start();

  try {
      Thread.sleep(500);
  } catch (InterruptedException e) {
      e.printStackTrace();
  }

  tSleep.interrupt();
  ```

- `yield()`를 이용한 상태 제어
  - `sleep()`과 달리 곧바로 `RUNNABLE` 상태로 변경

  ```java
  new Thread(() -> {
      for (int i = 0; i < 20; i++) {
          if (i % 2 == 0) {
              System.out.print("1");
          } else {
              Thread.yield();
          }
      }
  }).start();

  new Thread(() -> {
      for (int i = 0; i < 20; i++) {
          if (i % 2 == 0) {
              System.out.print("2");
          } else {
              Thread.yield();
          }
      }
  }).start();
  ```

- 스레드의 종료
  - run() 메소드의 종료
  - `stop()` 메소드 호출 (deprecated)

## 데몬 스레드

- 다른 스레드가 종료될 경우 함께 종료되는 보조 스레드
- 보통 대기하며 동작하는 무한 루프로 구현
- `setDaemon()` 메소드로 데몬 스레드로 설정

  ```java
  class DaemonThread extends Thread {
      public DaemonThread() {
          this.setDaemon(true);
      }

      @Override
      public void run() {
          while (true) {
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("Daemon Thread Run");
          }
      }
  }
  ```

## 데이터 공유와 동기화

- 스레드간 데이터 공유 시 신뢰성에 문제가 발생할 수 있음

  ```java
  class Counter {
        int count = 0;
  }

  Counter counter = new Counter();

  for (int i = 0; i < 1000; i++) {
      new Thread(() -> {
          for (int j = 0; j < 1000; j++) {
              counter.count = counter.count + 1;
          }
      }).start();
  }

  try {
      Thread.sleep(1000);
  } catch (InterruptedException e) {
      e.printStackTrace();
  }

  System.out.println(counter.count);
  ```

- `synchronized` 키워드 사용

  ```java
  synchronized void method() {
      // 공유 데이터 사용
  }
  ```

  ```java
  void method() {
      synchronized(sharedObj) {
          // 공유 데이터 사용
      }
  }
  ```

- `wait()`, `notify()`, `notifyAll()`

  ```java
  class WorkObject {
        public synchronized void methodA() {
            System.out.println("ThreadA의 methodA() 작업 실행");
            notify(); // 일시정지 상태에 있는 ThreadB를 실행 대기상태로 만듬 
            try {
                wait(); // ThreadA를 일시 정지 상태로 만듬 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
        public synchronized void methodB() {
            System.out.println("ThreadB의 methodB() 작업 실행");
            notify(); // 일시정지 상태에 있는 ThreadA를 실행 대기상태로 만듬
            try {
                wait(); // ThreadB를 일시 정지 상태로 만듬
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    

    class ThreadA extends Thread {
        private WorkObject workObject;

        ThreadA(WorkObject workObject) {
            this.workObject = workObject;
        }
        
        public void run() {
            for(int i=0; i<10; i++) {
                workObject.methodA(); // 공유객체의 methodA를 반복적으로 호출 
            }
        }
    }

    class ThreadB extends Thread{
        private WorkObject workObject;

        ThreadB(WorkObject workObject) {
            this.workObject = workObject;
        }
        
        public void run() {
            for(int i=0; i<10; i++) {
                workObject.methodB(); // 공유객체의 methodA를 반복적으로 호출 
            }
        }
    }

    class Main {
        public static void main(String[] args) {
            WorkObject sharedObject = new WorkObject();
            
            ThreadA threadA = new ThreadA(sharedObject);
            ThreadB threadB = new ThreadB(sharedObject);
            
            threadA.start();
            threadB.start();
        }
  }
  ```