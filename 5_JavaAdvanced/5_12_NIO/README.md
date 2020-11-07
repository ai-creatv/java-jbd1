# NIO (New Intput Output)

## NIO의 특징

- 채널(Channel) 방식을 이용해 입/출력을 모두 처리
- IO와 달리 기본적으로 버퍼를 사용
- NIO는 Blocking 및 Nonblocking을 모두 지원

## 경로와 파일

- java.nio.file.Path
  - Paths::get() 메소드
    - `public static Path get(String first, String... more)`
    - `public static Path get(URI uri)`

        ```java
        Path path1 = Paths.get("D:/temp/test.txt");
        Path path1 = Paths.get("D:", "temp", "test.txt");
        Path path1 = Paths.get(new URI("file:///D:/temp/test.txt");
        ```

  - Path의 주요 메소드

    | 메소드 | 설명 |
    |------|-----|
    | getFileName() | 파일 또는 마지막 디렉토리의 이름을 갖는 Path를 반환 |
    | getNameCount() | 루트 경로 이후의 경로의 개수를 반환 |
    | getName() | 특정 인덱스의 경로의 이름을 반환 |
    | subpath() | beginIndex부터 endIndex로 구성된 Path를 반환 |
    | getParent() | 상위 Path 객체를 반환 |
    | getRoot() | 최상위 Path 객체를 반환 |
    | toAbsolutePath() | 상대경로의 Path를 절대경로의 Path로 반환 |
    | normalize() | 표준화된 경로 표현으로 변환하여 Path로 반환 |
    | toFile() | Path를 File 객체로 반환 |
    | toUri() | URI 객체로 반환 |

- java.nio.files.Files
  - Files의 주요 정적 메소드

    | 메소드 | 설명 |
    |------|-----|
    | newInputStream() | InputStream을 반환 |
    | newOutputStream() | OutputStream을 반환 |
    | newBufferedReader() | BufferedReader를 반환 |
    | newBufferedWriter() | Buffered Writer를 반환 |
    | newDirectoryStream() | DirectoryStream을 반환 |
    | newByteChannel() | SeekableByteChannel을 반환 |
    | createFile() | 빈 파일 생성 |
    | createDirectory() | 빈 디렉토리 생성 |
    | delete() | 디렉토리 또는 파일을 삭제 |
    | copy() | source를 target으로 복사 |
    | move() | source를 target으로 이동 |
    | readAllLines() | 모든 행을 읽어서 `List<String>`으로 반환 |

## Buffers

- Direct Buffer vs. Non-Direct Buffer
  - OS 메모리를 직접 사용 vs. JVM 메모리 (힙 메모리)
  - OS와의 통신에 의해 버퍼 생성이 느림 vs. 빠름
  - 사용 가능 크기가 큼 vs. JVM에 의해 제한된 메모리만 사용 가능
  - 입출력 성능이 좋음 vs. 입출력 성능이 떨어짐

- 버퍼의 생성

  - 정적 메소드 allocate()를 이용한 버퍼의 생성
    - 모든 타입의 non-direct buffer 생성
  - 정적 메소드 wrap()을 이용한 버퍼의 생성
    - 이미 생성된 배열을 이용하여 non-direct buffer 버퍼 객체 생성
  - 정적 메소드 allocateDirect()를 이용한 direct buffer 생성
    - ByteBuffer 정적 메소드를 이용하여 ByteBuffer 생성
    - 생성된 Direct buffer를 asShortBuffer(), asIntBuffer() ...등을 이용해 버퍼 변환

- 버퍼의 사용

  | 속성 | 설명 |
  |-----|-----|
  | capacity | 버퍼의 크기 |
  | limit | 버퍼에 있는 데이터의 한계 (flip으로 설정) |
  | position | 버퍼에서 현재 커서의 위치 |
  | mark | reset()으로 돌아오기 위해 표시한 위치 |

  `0 <= mark <= position <= limit <= capacity`

  | 메소드 | 설명 |
  |------|------|
  | flip() | limit=position, position=0 |
  | mark() | mark=position |
  | reset() | position=mark |
  | rewind() | position=0, mark 삭제 |
  | clear() | position=0, 모든 mark 삭제, limit=capacity |
  | get() | 상대/절대 위치에서 버퍼 읽기 |
  | getP() | P자료형으로 버퍼 읽기 |
  | put() | 상대/절대 위치에서 버퍼 쓰기 |
  | putP() | P자료형으로 버퍼 쓰기 |

- 버퍼의 변환

  - ByteBuffer로의 수동 변환

    ```java
    int [] src = {423, 525, 236, 523};
    IntBuffer iBuff = IntBuffer.wrap(src);
    ByteBuffer bBuff = ByteBuffer.allocate(iBuff.capacity() * 4));
    for (int i = 0; i < iBuff.capacity(); i++) {
      bBuff.putInt(iBuff.get(i));
    }

    // Use bBuff ...

    bBuffer.rewind();
    IntBuffer iBuffer2 = bBuffer.asIntBuffer();
    int [] target = new int[iBUffer2.capacity()];
    iBuffer2.get(target);
    System.out.println(Arrays.toString(target));
    ```

  - java.nio.charset.Charset

    | 메소드 | 설명 |
    |------|-----|
    | forName() | charsetName을 입력받아 Charset 객체 생성 |
    | encode() | String 또는 CharBuffer를 ByteBuffer로 변환하여 반환 |
    | decode() | ByteBuffer를 CharBuffer로 변환하여 반환 |

    ```java
    String str = "문자열 데이터";
    Charset charset = Charset.forName("utf-8");
    ByteBuffer bBuff = charset.encode(str);
    CharBuffer cBuff = charset.decode(bBuff);
    System.out.println(new String(cBuff.array()));
    ```
  
- Channels

  - java.nio.channel.FileChannel
  
    | 메소드 | 설명 |
    |------|-----|
    | open() | FileChannel 객체 생성 |
    | close() | FileChannel의 리소스를 반환 |
    | read() | ByteBuffer에 FileChannel에서 읽은 내용을 저장 |
    | write() | ByteBuffer의 내용을 FileChannel을 이용해 출력 |

  - StandardOpenOption

    | 열거형 상수 | 설명 |
    |----------|------|
    | READ | 읽기용으로 파일 오픈 |
    | WRITE | 쓰기용으로 파일 오픈 |
    | CREATE | 파일이 없으면 새로운 파일 생성, 있으면 기존 파일 사용 |
    | CREATE_NEW | 파일이 없으면 새로운 파일 생성, 있으면 FileAlreadyExistsException 예외 발생 |
    | APPEND | 파일 뒤에 내용 추가 |
    | DELETE_ON_CLOSE | 채널을 닫을 때 파일 삭제 |


    ```java
    Path src = Paths.get("1.txt");
    Charset utf8 = Charset.forName("utf-8");

    try (FileChannel channel = FileChannel.open(src,
            StandardOpenOption.CREATE,
            StandardOpenOption.WRITE)) {
        String data = "파일채널을 읽고 쓰는 방법에 대한 예제입니다.";
        ByteBuffer bBuff = utf8.encode(data);

        int count = channel.write(bBuff);
        System.out.println(count);
    } catch (IOException e) {
        e.printStackTrace();
    }
    ```

    ```java
    Path src = Paths.get("1.txt");
    Path dst = Paths.get("2.txt");
    try (FileChannel rChannel = FileChannel.open(src, StandardOpenOption.READ);
        FileChannel wChannel = FileChannel.open(dst, StandardOpenOption.CREATE,
                                                    StandardOpenOption.WRITE)) {
        int read = -1;
        ByteBuffer readBuffer = ByteBuffer.allocate(20);
        while ((read = rChannel.read(readBuffer)) > 0) {
            readBuffer.flip();
            wChannel.write(readBuffer);
            readBuffer.clear();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    ```

