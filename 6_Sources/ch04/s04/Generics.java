package s04;

/**
 * 제네릭 (Generics)
 * - 대상 객체의 타입을 입력받아서 사용하는 형식
 * - 미리 사용할 수 있는 타입을 명시해서 컴파일 타임에 체크 가능
 *   - 입력을 Object로 할 수도 있으나, 런타임에 instanceof로 객체를 체크해야 함
 *   - 제네릭을 사용할 경우 이러한 과정 없이 간결하게 코드 작성을 할 수 있다.
 */

// 제네릭 클래스

// 일반 클래스
class Foo {

}

// 제네릭 클래스
// 클래스를 선언할때에는 설정되지 않은 타입이 있으며, 이것을 타입 파라미터로 표현
class GenericFoo<T> { // T: 타입 파라미터
    String name;
    T memberVar;

    public GenericFoo(String name, T memberVar) {
        this.name = name;
        this.memberVar = memberVar;
    }
}
interface GenericInterface<T> { //인터페이스도 제네릭이 가능

}
class HashMap<K,V> { // 여러개의 타입 파라미터도 쓸 수 있다.

}

class GenericBar<T> {
    // 문법적으로 문제가 있는 경우
    // static T classVar; // not possible
    // static void method(T var) { } // not possible


    // 문법적으로 문제가 없을 것 같으나, 안정성 문제로 금지
    // T memberVar = new T(); not possible -> 안정성 문제 때문에 불가능
    /*
    {
        Object obj = new Object();
        if (obj instanceof T) { // not possible

        }
    }*/
}

// 제네릭 타입의 상속
class GFoo<T> {

}

interface IGFoo<T> {

}

// 타입 파라미터는 부모 제네릭의 타입 파라미터를 모두 채워 주어야 한다.
// 추가적인 타입 파라미터도 사용할 수 있다.
class GIGFoo<K, T, D> extends GFoo<T> implements IGFoo<D>{

}

// 부모 클래스/인터페이스들에 동일한 타입 파라미터를 넘겨줄 수 있다.
class IGIFooTwo<T> extends GFoo<T> implements IGFoo<T> {

}

// 타입 제한을 하지 않으면 extends Object와 동일하다
class GenericNoTypeLimit<T extends Object> {}

// extends를 이용해서 부모 클래스를 제한할 수 있음
class GenericTypeLimitation<T extends Number & Cloneable> {

}

// 제네릭 메소드
class GenericMethod {

    public static <T> T staticMethod (T t) {
        return t;
    }

    public int method(int x) {
        return x;
    }
    public <T> T method(T x) {
        return x;
    }
}

// 와일드카드
class WildFoo {

}

class WildBar extends WildFoo {

}

class WildGeneric<T> {

}

// 와일드카드?는 메소드의 입력 타입에 제네릭이 쓰일 경우,
// 제네릭의 타입 변수를 결정하지 않거나 제한할 수 있다.
class WildCard {
    public void method1(WildGeneric<?> x) {}
    public void method1_eq(WildGeneric<? extends Object> x) {} // Object가 상한 -> 모든 클래스
    public void method2(WildGeneric<? extends WildFoo> x) {} // WildFoo, WildBar
    public void method3(WildGeneric<? super WildBar> x) {} // Object, WildFoo, WildBar

}


public class Generics {
    public static void main(String[] args) {
        GenericFoo<String> foo = new GenericFoo<String>("name",
                                                        "var");
        GenericFoo<String> foo1 = new GenericFoo<>("name",
                                        "var");


        System.out.println(foo.name);
        System.out.println(foo.memberVar);

        GenericFoo<Integer> foo2 = new GenericFoo<>("name1",
                4);
        System.out.println(foo2.name);
        System.out.println(foo2.memberVar);

        // 동적 바인딩 -> 컴파일타임에는 동작이 완전히 정의가 되지 않음
        // 런타임에 결정이 된다.
        GenericMethod.staticMethod("abcd");
        GenericMethod.staticMethod(12412);
    }
}
