# 반복문 (Loops)

## 반복문의 일반적인 구성

- 초기화 (Initialization)
- 조건식 (Conditional Expression)
- 실행문 (Execution Statement)
- 증감식 (Increment and Decrement Statement)

## 다양한 반복문

### for 문

```java
for(초기화; 조건식; 증감식) {
  // 실행문
}
```

### while 문

- while 문의 경우 실행문이 한번도 실행되지 않을 수도 있다.

```java
// 초기화
while(조건식) {
  // 실행문
  // 증감식
}
```

### do ~ while 문

- do ~ while 문의 경우 실행문은 무조건 한번 이상 실행된다.

```java
//초기화
do {
  //실행문
  //증감식
} while(조건식)
```

## 반복문 제어

### break 문

- 반복문을 곧바로 종료한다.

```java
while (조건식) {
  if (종료조건) {
    break;
  }
  //실행문
  //증감식
}
```

### continue 문

- 반복문을 곧바로 다음 반복으로 건너 뛴다.
- while 문의 경우 증감식이 실행되지 않을 수 있다.

```java
while (조건식) {
  if (제어조건) {
    //증감식
    continue;
  }
  //실행문
  //증감식
}
```

### label

- 중첩 반복문에서 어떤 반복문을 제어할지 결정

```java
loop1: for (int i = 0; i < 10; i++) {
   loop2: for (int j = 0; j < 10; j++) {
    if (j == 3) {
      break;
      // break loop1;
      // break loop2;
      // continue;
      // continue loop1;
      // continue loop2;
    }
  }
}
```
