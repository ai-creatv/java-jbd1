# 스트림 API (Stream API)

## 스트림 API란

- Java 8에서 추가된 java.util.stream 패키지
- 컬렉션의 요소를 람다식으로 처리할 수 있도록 하는 함수형 프로그래밍 도구

## 스트림 API의 특징

- 간결한 코드 작성

```java
// JAVA 7
List<String> list = Arrays.asList("fast", "campus", "rocks");
List<String> newList = new ArrayList<>();

for (String s: list) {
    newList.add(s.toUpperCase());
}

for (String s: newList) {
    System.out.println(s);
}
```

```java
// JAVA 8
List<String> list = Arrays.asList("fast", "campus", "rocks");
Stream<String> stream = list.stream();
stream.map(String::toUpperCase).forEach(System.out::println);
```

- 데이터 소스에 대한 공통의 접근 방식 제공
  - List, Set, Array 등 다양한 경우에 대해 표준화된 방식으로 데이터 접근 가능
  - 특히 Stream::sorted() 메소드는 공통된 정렬 방식을 제공

- 중간 처리와 최종 처리를 지원
  - Mapping, Filtering, Sorting 등 중간 처리 지원 (여러개 사용 가능)
  - Iteration, Count, Average, Summation, Reduce 등 최종 처리 지원 (마지막에 하나 사용 가능)

- 데이터 소스와 처리 결과를 분리
  - 원본 데이터를 유지하여 처리에 의한 부작용 방지
  - 처리 결과를 새로운 컬렉션으로 저장 가능

## 스트림 API를 이용한 자료 처리

### 스트림 API의 종류

  | 종류 | 처리 대상|
  |------|---------|
  | `Stream<T>` | 일반적인 객체를 처리 |
  | `IntStream` | 기본 자료형 `int`를 처리 |
  | `LongStream` | 기본 자료형 `long`을 처리 |
  | `DoubleStream` | 기본 자료형 `double`을 처리 |

### 스트림 객체 생성 메소드

- 데이터 소스로부터 스트림 생성

  | 데이터 소스 | 메소드 |
  |------------|--------|
  | `Collection`| `default Stream<E> stream()` |
  | `Collection`| `default Stream<E> parallelStream()` |
  | `Arrays`| `public static <T> Stream<T> stream(T[] array)` |
  | `Arrays`| `public static <T> Stream<T> of(T ... values)` |
  | `Arrays`| `public static IntStream stream(int[] array)` |
  | `Arrays`| `public static IntStream of(int ... values)` |
  | `Arrays`| `public static LongStream stream(long[] array)` |
  | `Arrays`| `public static LongStream of(long ... values)` |
  | `Arrays`| `public static DoubleStream stream(double[] array)` |
  | `Arrays`| `public static DoubleStream of(double ... values)` |

- 정수 범위와 java.util.Random으로부터 생성

  | 구분 | 메소드 |
  |------|--------|
  | `int`형 범위 | `public static IntStream range(int startInclusive, int endExclusive)` |
  | `int`형 범위 | `public static IntStream rangeClosed(int startInclusive, int endInclusive)` |
  | `long`형 범위 | `public static LongStream range(long startInclusive, long endExclusive)` |
  | `long`형 범위 | `public static LongStream rangeClosed(long startInclusive, long endInclusive)` |
  | Random *p*형 값 | `public PStream ps()` |
  | Random *p*형 값 | `public PStream ps(long streamSize)` |
  | Random *p*형 값 | `public PStream ps(long streamSize, p origin, p bound)` |

  ```java
  IntStream integers = IntStream.range(0, 10);
  integers.forEach(System.out::println);

  Random random = new Random();
  LongStream longs = random.longs(100, 1, 10);
  System.out.println(longs.average().getAsDouble());
  ```

### 중간 처리 메소드

  | 동작 | 메소드 |
  |-----|--------|
  |필터링| dinstict(), filter() |
  |자르기| skip(), limit() |
  |정렬| sorted() |
  |매핑 | flatMap(), flatMapToP(), map(), mapToP(), asDoubleStream(), asLongStream() |
  | 조회 | peek() |

#### 필터링

필터링은 스트림의 일부 요소를 제거하는 역할을 한다.

- `Stream<T> distict()` : 스트림 요소의 중복을 제거한 스트림을 반환
- `Stream<T> filter(Predicate<? super T> predicate)` : Predicate에서 true에 해당하는 요소만으로 구성된 스트림을 반환

#### 자르기

자르기는 스트림의 일부 요소를 한번에 생략한다.

- `Stream<T> limit(long maxSize)` : 최대 maxSize까지 구성된 스트림을 반환
- `Stream<T> skip(long n)` : 스트림의 상위 n개 요소를 생략한 스트림을 반환

#### 정렬

스트림 요소의 `compareTo()` 또는 입력받은 `Comparator`를 이용해 정렬

- `Stream<T> sorted()` : Comparable 객체를 정렬한 스트림 반환
- `Stream<T> sorted(Comparator<? super T> comparator)` : Comparator를 이용하여 정렬된 스트림 반환
  - Comparator의 정적 메소드와 기본 메소드
    - 정적 메소드: naturalOrder(), reverseOrder(), comparing(), comparingP(), nullsFirst(), nullsLast()
    - 기본 메소드: reversed(), thenComparing(), thenComparingP()

#### 매핑

Function 인터페이스를 이용해 요소의 값을 변환한다.

- map 계열
  - `<R> Stream<R> map(Function<? super T, ? extends R> mapper)` : 기존 스트림의 T 타입 요소를 R 타입으로 변환하여 새로운 스트림 반환
  - `PStream mapToP(ToPFunction<? super T> mapper)` : R이 기본형 타입으로 제한된 map()

- flatMap 계열
  - `<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)` : 스트림의 T 타입 요소가 n개의 R 타입 요소로 매핑된 새로운 스트림을 반환
  - `PStream flatMapToP(Function<? super T, ? extends PStream> mapper)` : R이 기본형 타입으로 제한된 flatMap()

  ```java
  List<String> list = Arrays.asList("java", "backend", "best", "course");
  System.out.println(list.stream().flatMap(data -> {
      return Arrays.stream(data.split(""));
  }).distinct().count());
  ```

#### 조회

스트림 처리 과정에 영향을 미치지 않으며, 중간 결과를 확인할 수 있으며 입력받은 스트림과 동일한 스트림을 반환한다.

- `Stream<T> peek(Consumer<? super T> action)`

  ```java
  List<String> list = Arrays.asList("java", "backend", "best", "course");
  System.out.println(list.stream().flatMap(data -> {
      return Arrays.stream(data.split(""));
  }).peek(s -> System.out.println("flatMap:" + s))
    .distinct().peek(s -> System.out.println("distinct:" + s))
    .count());
  ```

### 최종 처리 메소드

  | 동작 | 메소드 |
  |-----|--------|
  | 매칭 | allMatch(), anyMatch(), noneMatch() |
  | 수집 | collect() |
  | 루핑 | forEach() |
  | 집계 | count(), max(), min(), average(), sum(), reduce() |
  | 조사| findFirst(), findAny() |

#### 매칭

Predicate 계열을 이용해 스트림 요소들이 특정 조건에 만족하는지 조사하는 메소드

- `boolean allMatch(Predicate<? super T> predicate)` : 스트림의 모든 요소가 Predicate를 만족하면 true를 반환
- `boolean anyMatch(Predicate<? super T> predicate)` : 스트림의 요소 중 하나라도 Predicate를 만족하면 true를 반환
- `boolean noneMatch(Predicate<? super T> predicate)` : 스트림의 요소 중 하나라도 Predicate를 만족하지 않으면 true를 반환

#### 집계

- 기본 집계 메소드
  - 기본형 스트림의 통계 : count(), sum(), average(), min(), max()
  - T 타입 스트림의 통계 : count(), min(), max() (min, max의 경우 `Comparator` 필요)

- reduce() 메소드
  - `Optional<T> reduce(BinaryOperator<T> accumulator)` : accumulator를 수행하고 `Optional<T>` 타입 반환
  - `T reduce(T identity, BinaryOperator<T> accumulator)` : identity를 초기값으로 하여, accumulator를 이용해 집계 연산
  - `<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)` : combiner를 이용해 병렬 스트림 결합

- `java.util.Optional<T>`
  - T 타입 객체의 null 여부에 따라 다르게 동작하는 Wrapper 클래스
  - Optional 클래스의 정적 메소드를 이용해 Optional 객체 생성
    - `public static <T> Optional<T> of(T value)` : value가 null인 경우 NullPointerException을 발생시키는 Wrapping 메소드
    - `public static <T> Optional<T> ofNullable(T value)` : value가 null인 경우 empty()의 결과를 리턴하는 Wrapping 메소드
    - `public static <T> Optional<T> empty()` : 값이 비어있는 Optional 객체를 리턴
  - Optional 객체를 처리하는 메소드
    - `public T get()` : Optional의 값을 리턴하며, null일 경우 NullPointerException 발생
    - `public void ifPresent(Consumer<? super T> consumer)` : Optional 값이 null이 아닐 경우 consumer를 이용해 소비한다.
    - `public T orElse(T other)` : Optional의 값이 null일 경우 other를 반환한다.
    - `public T orElseGet(Supplier<? extends T> other)` : Optional의 값이 null일 경우 Supplier를 통해 공급받은 값을 반환한다.
    - `public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X` : Optional의 값이 null일 경우 exceptionSupplier에서 공급받은 예외를 throw

#### 반복

forEach() 메소드로 스트림 요소를 순차적으로 `Consumer<T>`를 이용해 소비

- `void forEach(Comsumer<? super T> action)` : 스트림의 각 요소를 action으로 소비

#### 조사

첫번째 요소 또는 아무 요소를 조사하는 최종 처리 메소드. 필터링 등으로 인해 스트림에 요소가 남아있는지 확인할 수 있다.

- `Optional<T> findFirst()` : 스트림의 첫 요소 또는 empty Optional 객체를 반환
- `Optional<T> findAny()` : 스트림의 아무 요소나 가지는 Optional 객체를 반환

#### 수집

필요한 요소를 수집하여 새로운 Collection으로 구성하여 반환하는 메소드

- collect() 메소드
  - `<R, A> R collect(Collector<? super T, A, R> collector)` : collector를 이용해 새로운 Collection R에 담아 반환
    - Collectors의 정적 메소드: `toList()`, `toSet()`, `toCollection()`, `toMap()`, `toConcurrentMap()`
  - `<R, A> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)` : supplier를 통해 공급된 컨테이너 R에 accumulator를 이용해 T값을 저장. 병렬처리 스트림에 사용될 경우 combiner를 이용해 스레드별 컨테이너 R을 통합

    ```java
    String[] array = {"Java", "Is", "Fun", "Isn't", "It", "?"};
    List<String> list = Arrays.stream(array)
            .filter(s -> s.length() >= 3)
            .collect(Collectors.toList()); // ArrayList
            // .collect(Collectors.toCollection(LinkedList::new))
    System.out.println(list.getClass().getName() + ":" + list);
  

    Set<String> set = Arrays.stream(array)
            .filter(s -> s.length() >= 3)
            .collect(Collectors.toSet()); // HashSet
            // .collect(Collectors.toCollection(HashSet::new))
    System.out.println(set.getClass().getName() + ":" + set);

    Map<String, Integer> map = Arrays.stream(array)
            .filter(s -> s.length() >= 3)
            .collect(Collectors.toMap(s -> s, String::length)); // HashMap
            // .collect(Collectors.toCollection(s -> s, String::length, (oldVal, newVal) -> newVal, TreeMap::new))
    System.out.println(map.getClass().getName() + map);
    ```

- Collectors의 정적 메소드를 이용한 그룹화와 분리
  - `public static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(Function<? super T, ? extends K> classifier)` : classifier를 key값으로, 해당하는 값의 목록을 List인 value로 가지는 Map으로 스트림을 수집하는 Collector를 반환
    - `public static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)` : List 대신 downstream collector로 수집
  - `public static <T> Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate)` : predicate 결과를 key로, 해당하는 값의 목록을 List value로 가지는 Map으로 스트림을 수집하는 Collector를 반환
    - `public static <T, A, D> Collector<T, ?, Map<Boolean, D>> partitioningBy(Predicate<? super T> predicate, Collector<? super T, A, D> downstream))` : List 대신 downstream collector로 수집

  ```java
  String[] array = {"Java", "Is", "Fun", "Isn't", "It", "?"};

  Map<Character, List<String>> map1 = Arrays.stream(array)
          .collect(Collectors.groupingBy(s -> s.charAt(0)));
  System.out.println(map1);

  Map<Boolean, List<String>> map2 = Arrays.stream(array)
          .collect(Collectors.partitioningBy(s -> s.length() >= 3));
  System.out.println(map2);
  ```

- 집계를 위한 Collector
  - Downstream collector로 집계를 위한 Collector를 사용할 경우 유용하다.
  - `counting()`, `summingP()`, `averagingP()`, `maxBy()`, `minBy()`, `reducing()`

  ```java
  String[] array = {"Java", "Is", "Fun", "Isn't", "It", "?"};

  Map<Character, Long> map = Arrays.stream(array)
          .collect(Collectors.groupingBy(s -> s.charAt(0),
                                         Collectors.counting()));
  System.out.println(map);
  ```

### 병렬 스트림

- 병렬 스트림의 생성
  - stream() 대신 parallelStream()으로 변경
  - stream 생성 후 parallel()으로 병렬화

- combiner를 이용해 병렬 스트림으로 생성된 컬렉션을 결합
  - `BiConsumer<T, K> combiner` : T 객체에 K 객체를 결합
