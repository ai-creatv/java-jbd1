package ch5.s11;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * I/O와 스트림
 * - I/O -> Input/Ouput (입출력)
 * - Java의 I/O방식은 Node - Stream
 *   - Node : 데이터의 소스 또는 데이터의 목적지
 *   - 노드는 키보드(입력), 모니터(출력), 파일(입출력), 메모리(입출력), Database, 다른 프로그램
 *   - Stream : 노드로부터 데이터를 주고 받는 통로 (StreamAPI와는 연관이 없음)
 *     - 입력으로 사용되는 스트림과 출력으로 사용되는 스트림은 별개
 *     - 입출력을 함께 하는 것은 채널(Channel) - NIO (New Input/Output)
 */

public class Main {

    static void copyStream(InputStream input, OutputStream output) throws IOException {
        byte [] buff = new byte[1024];
        int read = 0;
        while ((read = input.read(buff)) > 0) {
            output.write(buff, 0, read);
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        
        // 입력 스트림/리더
        
        // Stream/Reader 등을 사용하는 이유는
        // 노드(입출력 장치/파일/메모리 등)으로부터 데이터를 읽고 쓰는 기본적인 방식
        // 보통은 컴퓨터를 사용하지만, Embedded machine의 경우 Stream을 사용하는 경우가 많다.
        // 그래서 Scanner가 편리하기는 하지만, Stream/Reader 동작을 이해할 필요가 있음

        // Stream - byte 단위로 읽고 쓰는 특징
        // byte 단위로 읽어서 int로 출력함
        // 영어 알파벳은 byte단위로 끊어도 되지만
        // 한글 글자는 byte단위로 끊으면 읽고 쓸 수 없음
//        try (InputStream input = System.in) {
//            int read = -1;
//            while ((read = input.read()) != -1) {
//                System.out.printf("Int: %d Char: %c\n", read, read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try (InputStream input = System.in) {
//            int read = 0;
//            byte [] bytes = new byte[512];
//            while ((read = input.read(bytes)) != 1) {
//                System.out.println(Arrays.toString(bytes));
//                System.out.println(read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Stream과 유사하나, Reader는 char 단위로 읽어서 int로 반환
        // Stream을 이용해서 Reader를 초기화 할 수 있음
//        try (InputStreamReader reader = new InputStreamReader(System.in)) {
//            int read = -1;
//            while ((read = reader.read()) != -1) {
//                System.out.printf("Int: %d Char: %c\n", read, read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (InputStreamReader reader = new InputStreamReader(System.in)) {
//            int read = -1;
//            char [] cbuf = new char[100];
//            while ((read = reader.read(cbuf)) != 1) {
//                System.out.println(Arrays.toString(cbuf));
//                System.out.println(read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Stream의 mark/reset 기능
//        System.out.println(System.in.markSupported()); // mark/reset 가능?
//        try (InputStream input = System.in) {
//            int read = -1;
//            while ((read = input.read()) != 'q') {
//                System.out.printf("Int: %d Char: %c\n", read, read);
//                if ((char)read == 'm') {
//                    input.mark(32);
//                }
//                if ((char)read == 'r') {
//                    input.reset();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 출력 스트림/Writer
        // 메모리를 Node로 하는 입출력
        // 입력 Node: char array,
        // 출력 Node: char array
//        char [] memory = "메모리 입출력 테스트 입력".toCharArray();
//        char [] cbuf = new char[4];
//        int read = 0;
//        try (CharArrayReader reader = new CharArrayReader(memory);
//             CharArrayWriter writer = new CharArrayWriter();) {
//            while ((read = reader.read(cbuf)) > 0) {
//                writer.write(cbuf, 0, read);
////                writer.write(cbuf);
//            }
//            System.out.println(Arrays.toString(writer.toCharArray()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String filePath = "D:" + File.separator + "Temp" + File.separator + "MyTemp";
        System.out.println(filePath);

        File fileOne = new File(filePath); // path만 표현 (not File)
        System.out.println(fileOne.mkdir()); // 가장 하위 폴더만 생성 (상위 폴더가 없으면 실패)
        System.out.println(fileOne.mkdirs()); // 경로에 있는 모든 폴더를 생성

        File fileTwo = new File(filePath, "file2.txt");
        fileTwo.createNewFile();

        File fileThree = new File(fileOne, "file3.txt");
        fileThree.createNewFile();

        File fileFour = new File(new URI("file:///d:/Temp/MyTemp/file4.txt"));
        fileFour.createNewFile();
        fileFour.deleteOnExit(); // Temp 파일을 사용할 때 유용

        System.out.println(fileTwo.getName());
        System.out.println(fileTwo.getParent());
        System.out.println(fileTwo.isAbsolute()); // 절대 경로를 사용 하는지?

        System.out.println(fileTwo.getAbsolutePath());
        System.out.println(fileTwo.getCanonicalPath()); // .. 등을 모두 배제한 표준 표현법 사용

        System.out.println(fileOne.isDirectory());
        System.out.println(fileTwo.isFile());

        System.out.println(Arrays.toString(fileOne.list())); // String Array로 출력
        System.out.println(Arrays.toString(fileOne.listFiles())); // File 객체 Array로 출력

        File srcFile = new File(fileOne, "src.txt");
        File dstFile = new File(fileOne, "dst.txt");
        dstFile.createNewFile();

        // Stream을 이용한 파일의 복사 (byte단위)
//        try (InputStream src = new FileInputStream(srcFile);
//             OutputStream dst = new FileOutputStream(dstFile)) {
//            int read = -1;
//            while((read = src.read()) != -1) {
//                dst.write(read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try (InputStream src = new FileInputStream(srcFile);
//             OutputStream dst = new FileOutputStream(dstFile)) {
//            int read = 0;
//            byte [] buff = new byte[4];
//            while((read = src.read(buff)) > 0) {
//                dst.write(buff, 0, read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Reader를 이용한 파일의 복사 (char단위)
//        try (FileReader src = new FileReader(srcFile);
//             FileWriter dst = new FileWriter(dstFile)) {
//            int read = -1;
//            while((read = src.read()) != -1) {
//                dst.write(read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // append = true로 FileWriter를 생성하면 이어서 작성 (txt, ini, properties, ..)
        // binary파일에는 잘 사용하지 않음
        // binary 파일 - 문자열로 작성된 것이 아닌, decoding이 된 상태의 파일
        // 그림파일, 동영상파일, exe파일 ...
//        try (FileReader src = new FileReader(srcFile);
//             FileWriter dst = new FileWriter(dstFile, true)) {
//            int read = 0;
//            char [] buff = new char[4];
//            while((read = src.read(buff)) > 0) {
//                dst.write(buff, 0, read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 보조스트림
        // Node에 직접 연결되지 않고, 스트림에 부가적으로 사용되는 스트림
        // 보조 스트림을 연쇄적으로 생성 가능 -> Stream Chaining

        // InputStreamReader ┬ byte 스트림 -> char 스트림
        // OuputStreamWriter ┘

        // 반응성이 중요하지 않은 경우 (파일입출력, 네트워크 일부 경우(다운로드, 업로드...) 등등)
        // BufferedReader       ┬ 스트림에 버퍼링 적용하여 스트림 throughput 향상
        // BufferedWriter       ┤  throughput: 평균 전송 속도
        // BufferedInputStream  ┤  delay: 버퍼링을 쓸 경우 오히려 안좋아짐
        // BufferedOutputStream ┘
//
//        File src = new File("C:/Windows/explorer.exe");
//        File dst = new File("D:/Temp/MyTemp/explorer.exe");
//
//        try (FileInputStream in = new FileInputStream(src);
//             FileOutputStream out = new FileOutputStream(dst);
//             BufferedInputStream buffIn = new BufferedInputStream(in);
//             BufferedOutputStream buffOut = new BufferedOutputStream(out);) {
//            long start = System.nanoTime();
//            copyStream(in, out);
//            System.out.println(System.nanoTime() - start);
//
//            start = System.nanoTime();
//            copyStream(buffIn, buffOut);
//            System.out.println(System.nanoTime() - start);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // DataInputStream   ┬ 기본형 데이터 (Primitive Type)을 전송하기 위한 스트림
        // DataOutputStream  ┘   Stream, Reader(Writer)는 byte/char
                              // readBoolean, readByte, readShort ... readUTF(String)
                              // writeBoolean, writeByte, writeShort ... writeUTF(String

//        File src = new File("D:/Temp/MyTemp/data.dat");
//        DataOutputStream out = new DataOutputStream(new FileOutputStream(src));
//        out.writeUTF("자바왕");
//        out.writeInt(128);
//        out.writeFloat(523.411f);
//
//        DataInputStream in = new DataInputStream(new FileInputStream(src));
//        String str = in.readUTF();
//        int integer = in.readInt();
//        float floatVal = in.readFloat();
//
//        System.out.println(str + " " + integer + " " + floatVal);

        // 객체 직렬화를 위한 인터페이스 - Serializable
        //
        class Foo implements Serializable {
            static final long serialVersionUID = 1L; // 클래스 버전 관리
            // 객체를 저장할떄와 불러올 때 같은지 체크하여
            // serialVersionUID가 일치하지 않으면 실패

            String userName;
            int userID;
            transient String passWord;
            // Serialize에 포함하지 않음 (저장/불러오기 대상에서 제외)

            public Foo() {}

            public Foo(String userName, int userID, String passWord) {
                this.userName = userName;
                this.userID = userID;
                this.passWord = passWord;
            }

            @Override
            public String toString() {
                return userName + " " + userID + " " + passWord;
            }
        }

        Foo foo = new Foo("HanSol-The-OutSider",
                1423, "negazeilzalnaga");
        System.out.println(foo);

        File dst = new File("D:/Temp/MyTemp/obj.data");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dst));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(dst))) {
            out.writeObject(foo);
            Object read = in.readObject();
            if (read != null && read instanceof Foo) {
                Foo readFoo = (Foo)read;
                System.out.println(readFoo);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        // 부모클래스는 Serializable하지 않을 때,
        // 자식클래스를 Serializable하게 구현하기
        class ParentFoo {
            int memVarOne;
            double memVarTwo;
        }

        class ChildFoo extends ParentFoo implements Serializable {
            int childMember;

            private void writeObject(ObjectOutputStream out) throws IOException {
                out.writeInt(memVarOne);
//                out.writeDouble(memVarTwo); // transient 대신 그냥 원하는것만 쓰면 된다.
                out.defaultWriteObject();
            }

            private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
                memVarOne = in.readInt();
//                memVarTwo = in.readDouble();
                in.defaultReadObject();
            }
        }


    }
}
