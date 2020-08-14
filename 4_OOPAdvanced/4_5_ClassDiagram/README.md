# 클래스 다이어그램

## Class Diagram

- 클래스의 구성요소 및 클래스 간의 관계를 묘사하는 다이어그램
- 시간에 따라 변하지 않는 정적인 시스템 구조를 표현

## 클래스 다이어그램의 목적

- 문제 해결을 위한 도메인 구조를

## Unified Modeling Language (UML)

- 표준화된 모델링 표기 체계
- 클래스를 구현하기 전에 설계하는 단계에서 사용
  - 클래스 이름, 파라미터, 리턴 타입 등

## IDEA에서 UML 작성하기 (Plant UML)

- Plant UML 플러그인 설치
- Graphviz 설치 <https://graphviz.org/download/>
- Plant UML의 문법
  - 클래스, 추상클래스, 인터페이스

    ```puml
    interface IFoo {
        void method();
    }

    abstract class Bar

    class Foo {
        int [] array;
        int add(int x, int y);
        setArray(int [] array);
        void method();
    }
    ```
  
  - 가시성 (Visibility)
    - public : +
    - protected : #
    - default : ~
    - private : -

  - 클래스 간의 관계
    - Extension `<|-`
    - Aggregation `o--`
    - Composition `*--`

  - 타이틀

    ```puml
    title 클래스 다이어그램 제목
    ```

  - 노트

    ```puml
    note left of Foo
      노트 <b>내용</b> 작성
    end note
    ```

## IDEA에서 UML 자동 생성

<https://www.jetbrains.com/help/idea/class-diagram.html>
