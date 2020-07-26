# 다차원 배열 (N-D Arrays)

## 다차원 배열의 정의

- 배열을 담고 있는 배열을 다차원 배열이라고 한다.
- 수학의 선 -> 면 -> 공간 등과 동일한 개념

## 다차원 배열의 생성

- 다차원 배열의 선언

  ```java
  int[] array2D[];
  int[][] array2D;
  int array2D[][];
  ```

- 다차원 배열의 생성

  - 여러 차원의 배열을 동시에 생성

    ```java
    int[][] array2D = new int[5][10];
    ```

  - 상위 차원의 배열부터 생성

    ```java
    int[][] array2D = new int[5][];
    for (int i = 0; i < array2D.length; i++) {
      array2D[i] = new int[10];
    }
    ```

- 다차원 배열의 초기화

  ```java
  int[][] array2D = {{3, 5, 1, 20, 65},
                     {5, 2, 6}, // length may vary
                     {10, 3, 5, 67, 3}};
  ```

## 배열과 반복문

- 인덱스를 이용한 배열 접근

  ```java
  int[][] array2D = new int[10][10];
  for (int i = 0; i < array2D.length; i++) {
    for (int j = 0; j < array2D[i].length; j++) {
      array2D[i][j] = i * j;
    }
  }
  ```
