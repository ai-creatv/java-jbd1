package s02;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

/**
 * 오류 / 예외
 * 오류 - 메모리 부족 또는 프로그램 실행이 꼬이는 경우.
 *      더이상 어떻게 프로그램을 복구해야 할 지 알 수 없다.
 *      프로그램의 문제를 해결하여 해결
 *
 * 예외 (Exception)
 * - 오류에 비해서 심각도가 낮고, 프로그램의 정상적인 흐름만 방해
 *    -> 파일을 읽으려 했으나, 해당 파일이 없음
 *    -> 네트워크 연결이 유실
 * - 문제 상황을 처리하는 로직을 구현하여, 런타임에서 자연스럽게 해결 가능
 *
 * 예외 처리
 * - 예외가 발생했을 경우에, 이 상황을 '감지'하고 '처리'하는 코드
 * - try ~ catch, throws, throw, finally 키워드들을 이용
 *
 * Throwable 클래스를 상속하는 자식 클래스들로 이러한 문제를 해결
 */

public class Exceptions {
    public static void main(String[] args) {
        // try ~ catch
        try {
            // 예외가 발생할 수 있는 코드
            // 예외가 발생할 경우 예외 객체를 던짐 (throw)
        } catch (Exception e) { // 던져진 예외를 받음 (catch
                 // Exception 클래스 및 그 자식 클래스를 사용
            // 예외상황을 처리하는 코드
        }

        try{
            int [] integers = new int [10];
            integers[20] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
//
//        // 다중 예외 처리
//        try {
//            // 아주아주 예민한 내용이 실행되는 부분
//                // 특정 catch 구문에 선택되는 조건은
//                // 다형성에 의해서 결정된다.
//                // 즉, catch하고 있는 클래스의 자식 클래스의 객체면 catch 가능
//        } catch(ArithmeticException e) { // 첫번째 캐치
//
//        } catch(FileAlreadyExistsException e) { // 첫번째 캐치 후에 두번째 캐치
//
//        } catch(EOFException e) {
//
//        } catch(IOException e) {
//
//        } catch(Exception e) { // 나머지 모든 Exception을 모두 catch
//                               // 모든 Exception 객체의 조상
//                               // 이것을 쓰는 것은 권장하지 않음
//        }

        // try ~ catch ~ finally
        try {
            int [] integers = new int[20];
//            integers[21] = 10;
            System.out.println("던졌다?");
        } catch (Exception e) {
            System.out.println("받았다!");
        } finally { // catch 발생 여부와 무관하게 실행
            System.out.println("마참내!");
            // try에서 생성한 리소스를 회수하기 위해
        }


        FileInputStream file = null;
//        file = new FileInputStream("a.txt");
//        file.read();
        /**
         * 예외의 종류 2가지
         * - Checked Exception
         *   Exception 클래스를 상속하고 있으면 Checked Exception
         *   컴파일러에서 에러 발생 -> try ~ catch를 작성하지 않으면
         *   아예 빌드조차 할 수 없다.
         *
         * - Unchecked Exception
         *   RuntimeException 클래스를 상속하고 있으면 Unchecked Exception
         *   try ~ catch를 작성하지 않더라도 빌드/실행이 가능
         *   ArrayIndexOutOfBoundsException
         *   ArithmaticException
         */

        try {
            file = new FileInputStream("a.txt");
            file.read();
        } catch (IOException e) {
            System.out.println("파일 처리 실패");
        } finally {
            System.out.println("파이날리");
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    System.out.println("앗!.. 아아...");
                }
            }
        }

        // try ~ with ~ resources 구문
        // Java1.7에서 추가된 기능
        // AutoClosable 인터페이스를 구현하는 리소스만 사용 가능
        try (FileInputStream file1 = new FileInputStream("a.txt")){
            file1.read();
        } catch (IOException e) {
            System.out.println("파일처리실패");
        }

        System.out.println("Programm ended normaly");
    }
}

// throws 키워드를 이용하여 예외 처리 위임
class CheckedExceptionThrow {
    void methodA() throws IOException {
        FileInputStream file1 = new FileInputStream("a.txt");
        file1.read();
        file1.close();
    }

    void methodB() {
        try {
            methodA();
        } catch (IOException e) {
            System.out.println("메소드에이실패");
        }
    }
}

// Unchecked Exception의 경우에는 throws 키워드를 사용하지 않아도 된다.
class UncheckedExceptionThrows {
    void methodA() {
        int x = 10/0;
    }

    void methodB() {
        methodA();
    }

    public static void main(String[] args) {
        try {
            new UncheckedExceptionThrows().methodB();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Foo {
    void methodA() throws IOException {} // Checked Exception
}

class BarOne extends Foo {
    void methodA() throws IOException {} // possible
}

class BarTwo extends Foo {
    void methodA() throws FileNotFoundException {} // 더 자식 Exception은 possible
}

class BarThree extends Foo {
    // void methodA() throws Exception {}
    // 부모 클래스의 메소드를 오버라이드 할때는
    // 부모 클래스의 메소드의 예외보다 더 조상인 예외는 던질 수 없다.
    // 오버라이딩할 때 구현하는 내용을 어느정도 제한하고 있는 부분
}