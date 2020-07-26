# 배열 (Arrays)

## 배열의 특성

- 하나의 변수로 여러개의 값을 다룰 수 있다.
- 동일한 자료형의 값만 다룰 수 있다.
- 한번 생성된 배열의 크기는 변하지 않는다.
- 배열에 속한 값은 메모리에 연속적으로 위치한다.

## 배열의 생성

- 배열의 선언

  ```java
  int[] intArray;// 자료형[] 변수명; recommended
  int integerArray[];// 자료형 변수명[]; old c-style
  ```

- 배열의 생성/초기화
  - 생성 후 값 할당

    ```java
    int[] intArray = new int[10];
    intArray[0] = 4;
    intArray[1] = 10;
    ```

    ```java
    int[] intArray;
    intArray = new int[]{4, 5, 1, 2, 5};
    ```

  - 생성과 동시에 값 할당

    ```java
    int[] intArray = {3, 5, 1, 20, 65};
    int[] intArray2 = new int[]{4, 6, 2, 3, 4};
    ```

## 배열과 반복문

- 인덱스를 이용한 배열 접근

  ```java
  float[] floatArray = new float[10];
  for (int i = 0; i < floatArray.length; i++) {
    floatArray[i] = i * 0.5;
  }
  ```

- 향상된 for 문을 이용한 배열 접근

  ```java
  int[] intArray = {4, 5, 1, 2, 7, 5};
  for (int value: intArray) {
    System.out.println(value);
  }
  ```

## 배열의 크기 변경

- 배열의 크기는 변경할 수 없으므로 새로운 배열을 만들고 데이터를 옮겨야 한다.

```java
int[] src = {1, 2, 3, 4, 5};
int[] dst = new int[10];
for(int i = 0; i < source.length; i++) {
  dst[i] = src[i];
}
```

```java
int[] src = {1, 2, 3, 4, 5};
int[] dst = new int[10];
System.arraycopy(src, 0, dst, 0, src.length);
```
