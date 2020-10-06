# I/O

## I/O와 스트림

- I/O란 입출력(Input/Output)을 함께 부르는 것
- 자바의 I/O는 스트림을 이용해 데이터를 주고 받는 형식으로 이루어짐
  - 데이터의 소스와 목적지를 노드(node)라 부름
  - 노드는 키보드, 모니터, 파일, 메모리, 데이터베이스, 다른 프로그램 등이 될 수 있음

## 노드 스트림

### InputStream과 Reader

- InputSTream의 주요 메소드 (byte 단위)

  | 메소드 | 설명 |
  |--------|------|
  | `int read()` | byte 하나를 읽어서 int로 반환. 읽을 값이 없으면 -1 |
  | `int read(byte b[])` | 데이터를 읽어 b를 채우고, 읽은 바이트 수를 반환 |
  | `int read(byte b[], int offset, int len)` | 최대 len개의 바이트를 읽어 b의 offset 위치부터 채운다. |
  | `void close()` | 스트림을 종료하고 자원을 반납 |
  | `int available()` | 읽을 수 있는 데이터의 크기를 반납 |
  | `long skip(long n)` | 스트림에서 n만큼 건너 뛴다. |
  | `void mark(int readLimit)` | reset()으로 돌아갈 위치를 표시한다. readLimit은 돌릴 수 있는 최대 바이트 수 |
  | `void reset()` | mark()가 호출된 지점으로 돌아간다. |
  | `boolean markSupported()` | mark, reset 메소드의 지원 여부를 반환 |

  ```java
  try (InputStream input = System.in) {
    int read = -1;
    while ((read = input.read()) != -1) {
      System.out.printf("Integer: %d\nCharacter: %c\n", read, read);
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
  ```

- Reader의 주요 메소드 (char 단위)

  | 메소드 | 설명 |
  |--------|------|
  | `int read()` | char 하나를 읽어서 int로 반환. 읽을 값이 없으면 -1 |
  | `int read(char cbuf[])` | 데이터를 읽어 cbuf를 채우고, 읽은 char 수를 반환 |
  | `int read(char cbuf[], int off, int len)` | 최대 len개의 char를 읽어 cbuf의 offset 위치부터 채운다. |
  | `int read(java.nio.CharBuffer target)` | NIO target에 데이터를 저장한다. |
  | `void close()` | 스트림을 종료하고 자원을 반납 |
  | `int available()` | 읽을 수 있는 데이터의 크기를 반납 |
  | `long skip(long n)` | 스트림에서 n만큼 건너 뛴다. |
  | `void mark(int readAheadLimit)` | reset()으로 돌아갈 위치를 표시한다. readLimit은 돌릴 수 있는 최대 바이트 수 |
  | `void reset()` | mark()가 호출된 지점으로 돌아간다. |
  | `boolean markSupported()` | mark, reset 메소드의 지원 여부를 반환 |

### OutputStream과 Writer

- OutputStream의 주요 메소드 (byte 단위)

  | 메소드 | 설명 |
  |-------|------|
  | `void write(int b)` | b 내용을 byte로 출력 |
  | `void write(byte b[])` | b를 문자열로 변환하여 출력 |
  | `void write(byte b[], int off, int len)` | b의 off부터 (off + len - 1)만큼을 문자열로 변환하여 출력 |
  | `void close()` | 스트림을 종료하고 자원을 반납. `close()` 내부적으로 `flush()` 호출 |
  | `void flush()` | 버퍼 스트림에서 버퍼의 내용을 출력하고 비운다. |
  
- Writer의 주요 메소드 (char 단위)

  | 메소드 | 설명 |
  |-------|------|
  | `void write(int c)` | c 내용을 char로 출력 |
  | `void write(char cbuf[])` | cbuf를 문자열로 변환하여 출력 |
  | `void write(char cbuf[], int off, int len)` | cbuf의 off부터 (off + len - 1)만큼을 문자열로 변환하여 출력 |
  | `void write(String str)` | str을 출력한다. |
  | `void write(String str, int off, int len)` | str의 off부터 (off + len - 1)만큼을 출력 |
  | `Writer append(CharSequence csq)` | csq를 출력하고 Writer 반환 |
  | `Writer append(CharSequence csq, int start, int end)` | csq의 start부터 end까지를 출력하고 Writer 반환 |
  | `Writer append(char c)` | c를 출력하고 Writer 반환 |
  | `void close()` | 스트림을 종료하고 자원을 반납. `close()` 내부적으로 `flush()` 호출 |
  | `void flush()` | 버퍼 스트림에서 버퍼의 내용을 출력하고 비운다. |

### 다양한 입출력 처리

- 메모리 기반의 입/출력

  ```java
  char[] memory = "메모리 입출력 테스트".toCharArray();
  char[] buffer = new char[5];
  int read = 0;
  try (CharArrayReader reader = new CharArrayReader(memory);
       CharArrayWriter writer = newCharArrayWriter();) {
    while ((read = reader.read(buffer) > 0)) {
      wrtier.write(buffer, 0, read);
    }
    System.out.println(Arrays.toString(writer.toCharArray()));
  } catch (IOException e) {
    e.printStackTrace();
  }
  ```

- 파일 기반의 입출력
  
  - 생성자 및 생성/삭제 메소드

    | 생성자 및 메소드 | 설명 |
    |-------|------|
    | `File(String pathname)` | pathname에 해당하는 파일 생성. 기본 경로는 애플리케이션의 시작 경로 |
    | `File(String parent, String child)` | parent 경로 아래 child 파일 생성 |
    | `File(File parent, String child)` | parent 경로 아래 child 파일 생성 |
    | `File(URI uri)` | file로 시작하는 URI 객체를 이용해 파일 생성 |
    | `boolean createNewFile()` | 새로운 파일을 생성 |
    | `boolean mkdir()` | 새로운 디렉토리를 생성 |
    | `boolean mkdirs()` | 경로상의 모든 디렉토리를 생성 |
    | `boolean delete()` | 파일/디렉토리 삭제 |
    | `void deleteOnExit()` | 애플리케이션 종료시 자동으로 삭제 |

    ```java
    String filePath = "D:" + File.separator + "Temp" + File.separator + "MyTemp";
  
    File fileOne = new File(filePath);
    fileOne.mkdir();

    File fileTwo = new File(filePath, "file2.txt");
    fileTwo.createNewFile();

    File fileThree = new File(fileOne, "file3.txt");
    fileThree.createNewFile();

    File fileFour = new File(new URI("file:///d:/Temp/MyTemp/file4.txt"));
    fileFour.createNewFile();
    fileFour.deleteOnExit();
    ```

  - File 클래스의 주요 메소드
    - `getName()`, `getParent()`, `getParentFile()`, `getPath()`
    - `isAbsolute()`, `getAbsolutePath()`, `getCanonicalPath()`, `toURI()`
    - `canRead()`, `canWrite()`
    - `isDirectory()`, `isFile()`
    - `length()`, `list()`, `listFiles()`, `lastModified()`, `renameTo()`

  - FileInputStream, FileOutputStream
    - 파일명이나 File 객체를 이용하여 입출력 스트림 생성 가능
    - FileOutputStream에서 `boolean append`를 true로 하면 기존 파일에 이어서 쓴다.

  - FileReader, FileWriter
    - 파일명이나 File 객체를 이용하여 입출력 Reader 생성 가능
    - FileWriter에서 `boolean append`를 true로 하면 기존 파일에 이어서 쓴다.

## 보조 스트림

### 보조 스트림의 특징

- 스트림에 부가적인 기능 제공
- 노드(데이터 소스/목적지)와 직접 연결되지 않고, 다른 스트림과 연결
- Stream Chaining: 스트림을 여러개 연결하여 사용

### 보조 스트림의 종류

  | 보조 스트림 | 기능 |
  |------------|------|
  | `InputStreamReader` | byte 스트림을 char 스트림으로 변환 |
  | `OutputStreamWriter` | byte 스트림을 char 스트림으로 변환 |
  | `BufferedReader` | 버퍼링을 통해 스트림 속도 향상 |
  | `BufferedWriter` | 버퍼링을 통해 스트림 속도 향상 |
  | `BufferedInputStream` | 버퍼링을 통해 스트림 속도 향상 |
  | `BufferedOutputStream` | 버퍼링을 통해 스트림 속도 향상 |
  | `DataInputStream` | 기본 데이터형 전송 |
  | `DataOutputStream` | 기본 데이터형 전송 |
  | `ObjectInputStream` | 객체 전송 |
  | `ObjectOuputStream` | 객체 전송 |
  | `PrintWriter` | 문자열 표현으로 출력 |
  | `PrintStream` | 문자열 표현으로 출력 |

### 스트림 자료형 변경

- 캐릭터셋: `utf-8`, `ms949`, `euc-kr`

  ```java
  InputStreamReader readerOne = new InputStreamReader(System.in);
  InputStreamReader readerTwo = new InputStreamReader(System.in, "utf-8");

  OutputStreamWriter writerOne = new OutputStreamWriter(System.out);
  OutputStreamWriter writerTwo = new OutputStreamWriter(System.out, "ms949");
  ```

### 버퍼를 이용한 스트림

- 기본 버퍼 크기: 8192 bytes

  ```java
  static void copyStream(InputStream input, OutputStream output) throws IOException {
    byte [] buff = new byte[1024];
    int read = -1;
    while ((read = input.read(buff) > 0)) {
      output.write(buff, 0, read);
    }
  }

  public static void main(String[] args) {
    File src = new File("C:/Windows/explorer.exe");
    File dst = new File("C:/temp/explorer.exe");
    try (FileInputStream in = new FileInputStream(src);
         FileOutputStream out = new FileOutputStream(target);
         BufferedInputStream buffIn = new BufferedInputStream(in);
         BufferedOutputStream buffOut = new BufferedOutputStream(out);) {
      long start = System.nanoTime();
      copyStream(in, out);
      System.out.println(System.nanoTime() - start);

      long start = System.nanoTime();
      copyStream(bin, bout);
      System.out.println(System.nanoTime() - start);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  ```

- `BufferedReader는` `readLine()` 메소드를 사용할 수 있다.

  ```java
  File src = new File("./src.txt");
  try (BufferedReader buffReader = new BufferedReader(new FileReader(src));) {
    String line = null;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
  } catch (IOException e) {
    e.printStackTrace();
  }
  ```

### 기본 데이터형 전송 스트림

- byte, char 외에 다른 기본 데이터형도 전송 가능한 스트림
  - 읽은 후에는 자료형을 알 수 없으므로 쓴 순서대로 읽어야 함

  | 클래스 | 메소드 |
  |-------|--------|
  | `DataInputStream` | `boolean readBoolean()` |
  || `byte readByte()` |
  || `short readShort()` |
  || `int readInt()` |
  || `long readLong()` |
  || `float readFloat()` |
  || `double readDouble()` |
  || `char readChar()` |
  || `String readUTF()` |
  | `DataOutputStream` | `void writeBoolean(bool v)` |
  || `void writeByte(byte v)` |
  || `void writeShort(short v)` |
  || `void writeInt(int v)` |
  || `void writeLong(long v)` |
  || `void writeFloat(float v)` |
  || `void writeDouble(double v)` |
  || `void writeChar(char v)` |
  || `void writeUTF(String v)` |

  ```java
  File src = new File("c:/Temp/data.dat");
  try (DataOutputStream out = new DataOutputStream(new FileOutputStream(src))) {
    out.writeUTF("김패캠");
    out.writeInt(15);
    out.writeFloat(14.23);
  }

  try (DataInputStream in = new DataInputStream(new FileInputStream(src))) {
    String string = in.readUTF();
    int integer = in.readInt();
    float floatNum = in.readFloat();
    System.out.println(string + " " + integer + " " + floatNum);
  }
  ```

### 객체 저장을 위한 스트림

- 일반적인 참조형 객체를 저장하기 위한 스트림
- 직렬화(Serialization)와 역직렬화(Deserialization) 사용

  ```java
  class Foo implements Serializable { // has-a 관계의 모든 클래스가 Serializable이어야 함
    static final long serialVersionUID = 1L; // 객체의 버전 관리

    String userName;
    int id;

    transient String passWord;

    @Override
    public String toString() {
      return userName + " " + id + " " + passWord;
    }
  }

  class FooTest {
    public static void main (String [] args) {
      File dst = new File("C:/Temp/obj.data");
      Foo foo = new Foo();
      foo.userName = "김사탕";
      foo.id = 142;
      foo.passWord = "qwer1234";

      try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dst));
          ObjectInputStream in = new ObjectInputStream(new FileInputStream(dst));) {
        out.writeObject(foo);
        Object read = in.readobject();
        if (read != null && read instanceof Foo) {
          Foo readFoo = (Foo)read;
          System.out.println(readFoo);
        }
      } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
      }
    }
  }

  ```

- 부모 클래스가 Serializable이 아닌 경우 자식 클래스에서 직접 처리
  - writeObject(), readObject()를 자식 클래스에서 직접 구현

  ```java
  class ParentFoo {
    int memVarOne;
    double memVarTwo;
  }

  class ChildFoo extends ParentFoo implements Serializable {
    @Override
    private void writeObject(ObjectOutputStream out) throws IOException {
      out.writeInt(memVarOne);
      out.writeDouble(memVarTwo);
      out.defaultWriteObject();
    }
    @Override
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      memVarOne = in.readInt();
      memVarTwo = in.readDouble();
      in.defaultReadObject();
    }
  }
  ```
