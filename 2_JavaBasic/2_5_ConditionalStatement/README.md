# 조건문 (Conditional Statements)

## 조건문의 구성

- 조건식 (Conditional Expression), 실행문 (Execution Statement)

## 다양한 조건문

### if 계열 조건문

#### if 문

```java
if(조건식)
  // 실행문

if(조건식) {
  // 실행문
}
```

#### if ~ else 문

```java
if(조건식) {
  // 조건식이 true일때 실행할 실행문
} else {
  // 조건식이 false일때 실행할 실행문
}
```

#### if ~ else if ~ else 문

```java
if(조건식1) {
  // 조건식1이 true일때 실행할 실행문
} else if(조건식2) {
  // 조건식1이 false이고, 조건식2가 true일때 실행할 실행문
} else {
  // 모든 조건식이 false일 때 실행할 실행문
}
```

#### Nested if 문

```java
if(조건식1) {
  if(조건식2) {
    // 조건식1과 조건식2가 true일때 실행할 실행문
  } else {
    if(조건식3) {
      // 조건식1과 조건식3이 true이고 조건식2가 false일때 실행할 실행문
    }
  }
}
```

### switch ~ case

- 조건식과 비교할 대상이 여럿일 때 사용
  - 조건식의 출력은 정수값, 문자열, 열거형 등 정확한 값을 리턴

```java
switch(조건식) {
  case 비교값1:
    // 실행문1
    break;
  case 비교값2:
    // 실행문2
    break;
  default:
    // 실행문3
}
```

- Fall-through
  - break 문을 사용하지 않고 다음 case문을 실행시키는 방법

```java
switch(조건식) {
  case 비교값1:
    // 실행문1
  case 비교값2:
    // 실행문2
  default:
    // 실행문3
}
// 비교값1에 해당할 경우: 실행문1, 실행문2, 실행문3 실행
// 비교값2에 해당할 경우: 실행문2, 실행문3 실행
// 해당하는 값이 없을 경우: 실행문3 실행
```
