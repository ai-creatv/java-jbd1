package ch5.s13.p01;

import java.util.*;
import java.util.stream.*;


/**
 * Stream API
 * JAVA 8에 추가된 java.util.stream 패키지
 * 컬렉션 요소를 람다식으로 처리할 수 있도록 돕는 함수형 프로그래밍 도구
 * - 간결한 코드로 작성할 수 있다.
 * - 데이터 소스에 대한 공통된 접근 방식 제공.
 *   - Stream으로 변경해주고 나면, List, Set, Map 모두 동일한 방식으로 데이터를 처리
 */

public class Main {
    public static void main(String[] args) {
        // JAVA7
        List<String> list = Arrays.asList("fast", "campus", "rocks");
        List<String> newList = new ArrayList<>();

        for (String s: list) {
            newList.add(s.toUpperCase());
        }

        for (String s: newList) {
            System.out.println(s);
        }

        // JAVA8 - Stream API -> 훨씬 더 간결한 코드로 작성
        List<String> list1 = Arrays.asList("fast", "campus", "rocks");
        Stream<String> stream = list1.stream();
        stream.map(String::toUpperCase)
                .forEach(System.out::println);


        // 스트림 생성 방식1.
        // 컬렉션의 인스턴스 메소드 stream()
        Stream<String> stream1 = list1.stream();

        // 스트림 생성 방식2.
        int[] ints = {4, 6, 2, 19 , 2, 58 ,4 , 6, 5};
        // Arrays 클래스의 클래스 메소드 stream
        IntStream intStream = Arrays.stream(ints);
        // LongStream, DoubleStream 도 있다.

        // 스트림 생성 방식3.
        // Stream 클래스의 클래스 메소드 of
        DoubleStream doubleStream = DoubleStream.of(0.4, 0.6, 0.2, 1.2, 0.94);

        // range를 이용한 스트림 -> fori문 (for(int i = 0 ...))을 대체하는 스트림 작성을 위해 필요
        IntStream intStream1 = IntStream.range(0, 10); // 10은 포함되지 않는다.
        intStream1.forEach(System.out::println);
        IntStream intStream2 = IntStream.rangeClosed(0, 10); // 10은 포함된다.
        intStream2.forEach(System.out::println);
        // LongStream도 range, rangeClosed가 있다.

        // Random 객체를 이용한 스트림
        Random random = new Random();
//        LongStream longStream = random.longs(); // 개수 제한 없이 무한히 출력
//        longStream.forEach(System.out::println);

        // 개수 제한 가능
        LongStream longStream1 = random.longs(100);
        longStream1.forEach(System.out::println);

        // 개수 제한 + 범위 제한 가능
        LongStream longStream2 = random.longs(100, 0, 1000);
        longStream2.forEach(System.out::println);

        Stream<String> stringStream = Stream.of("Java", "Is", "Fun", "Isn't", "It", "?", "Java", "Java");


        // 중간처리 메소드 - 스트림을 반환
        // 필터링 메소드
        // distinct(): 스트림에 같은 요소가 있을 경우 하나만 남기고 삭제하는 메소드
        stringStream.distinct().forEach(System.out::println);
        // filter(): Predicate 계열을 입력으로 받아, true인 요소만 남긴다.
        stringStream = Stream.of("Java", "Is", "Fun", "Isn't", "It", "?");
        stringStream.filter(s -> s.length() >= 3)
                .forEach(System.out::println);

        // 자르기 (Cutting)
        // skip(long n): 스트림의 최초 n개를 생략하는 메소드
        // limit(long maxSize): 스트림의 최대 요소 개수를 maxSize로 제한

        // 정렬 (Sorting)
        // Comparable 인터페이스의 compareTo 메소드로 정렬
        stringStream = Stream.of("abc", "fwf", "twtie", "dnmov", "work");
        stringStream.sorted().forEach(System.out::println);
        System.out.println();
        // Comparator 인터페이스를 람다식으로 구현하여 정렬
        stringStream = Stream.of("abc", "fwf", "twtie", "dnmov", "work");
        stringStream.sorted((o1, o2) -> o1.length() - o2.length()).forEach(System.out::println);
        System.out.println();

        // 매핑 (Mapping) 입력1:1출력
        // Function 계열의 인터페이스를 사용하여 스트림의 각 요소를 매핑
        stringStream = Stream.of("abc", "fwf", "twtie", "dnmov", "work");
        // Function 계열로 String -> Integer로 변환하는 매핑 (Function<String, Integer>)
        Stream<Integer> stream2 =  stringStream.map(s -> s.length());
        stream2.forEach(System.out::println);
        // PStream (기본형 타입의 스트림)은 Operator 계열로 처리 (자료형 변환x)
        IntStream intStream3 = IntStream.of(5, 2, 30, 8, 0, 2 -34);
        IntStream intStream4 =  intStream3.map(value -> value * 10);
        intStream4.forEach(System.out::println);

        System.out.println("");
        // flatMap 계열 매핑 입력1:n출력 (스트림 형태로 출력)
        // s.split("") : "java" -> {"j", "a", "v", "a"}
        List<String> list2 = Arrays.asList("java", "backend", "best", "course");
        list2.stream().flatMap(s -> {
            return Arrays.stream(s.split(""));
        }).forEach(System.out::println);

        // 조회 (Peek) - 중간 결과를 출력해볼 수 있음 (디버깅 가능)
        // peek() -> Consumer 계열을 람다식 입력으로 받아 입력 요소를 소비
        // peek()는 입력받은 스트림과 동일한 스트림을 다시 출력
        System.out.println(list2.stream().flatMap(s -> {
            return Arrays.stream(s.split(""));
        }).peek(s -> System.out.println("flatMap(): " + s))
         .distinct().peek(s -> System.out.println("distinct(): " + s))
         .count());

        
        // 최종처리 메소드 - 스트림을 반환하지 않음 (void일 수도 있고, 무언가 리턴 할 수도..)
        // 매칭 계열 - boolean 타입의 값을 리턴
        // allMatch(), anyMatch(), noneMatch()
        // Predicate 계열 람다식을 입력받아,
        //   allMatch(Predicate<T> predicate) : 모든 요소가 true일 경우 true를 리턴
        //   anyMatch(Predicate<T> predicate) : 하나라도 요소가 true일 경우 true를 리턴
        //   noneMatch(Predicate<T> predicate) : 모든 요소가 false이면 true를 리턴
        Stream<String> st0 = Stream.of("abc", "cde", "efg");
        System.out.println(st0.allMatch(s -> s.equals("abc")));

        st0 = Stream.of("abc", "cde", "efg");
        System.out.println(st0.anyMatch(s -> s.equals("abc")));

        st0 = Stream.of("abc", "cde", "efg");
        System.out.println(st0.noneMatch(s -> s.equals("abce")));

        // 집계 (통계)
        // 기본형 스트림 (Int, Long, Double) - count(), sum(), average(), min(), max()
        // Stream<T>타입 스트림 - count(), min(), max() -> (min과 max는 Comparator 구현 필요) (o1, o2) -> ~~~
        
        // reduce() 메소드 -> 사용자 정의 집계 메소드
        System.out.println(IntStream.range(0, 10). // sum()
                reduce(0, (value1, value2) -> value1 + value2));
        System.out.println(IntStream.range(0, 10). // min()
                reduce(Integer.MAX_VALUE, (value1, value2) -> value1 < value2 ? value1 : value2));

        // 반복 - 소비
        // forEach() -> Consumer 계열의 람다식을 입력받아, 각 요소를 소비
        // forEach()는 void 출력

        // 수집 - Collection으로 변환하는 collect() 메소드
        // Stream API는 JCF -> Stream -> 처리 -> 결과(출력, 값, Collection)

        // Collectors 클래스의 정적 메소드를 이용하는 방법
        // toList() 메소드를 쓸 경우, ArrayList로 collect하는 Collector 반환
        String[] array = {"Collection", "Framework", "is", "so", "cool"};
        Stream<String> stream3 = Arrays.stream(array);
        List<String> collected = stream3.filter(s -> s.length() >= 3)
                                    //   .collect(Collectors.toList()); // ArrayList
                        .collect(Collectors.toCollection(LinkedList::new)); // LinkedList
        System.out.println(collected);


        // toSet() 메소드를 쓸 경우, HashSet으로 collect하는 Collector 반환
        Stream<String> stream4 = Arrays.stream(array);
        Set<String> collected2 = stream4.filter(s -> s.length() >= 3)
//                            .collect(Collectors.toSet()); // HashSet
            .collect(Collectors.toCollection(HashSet::new)); // Same Thing
        System.out.println(collected2);

        // Map<K, V>   Map.Entry<K, V>
        Stream<String> stream5 = Arrays.stream(array);
        Map<String, Integer> collected3 = stream5.filter(s -> s.length() >= 3)
                    .collect(Collectors.toMap(s -> s, String::length)); // HashMap
        System.out.println(collected3);

        // 그룹화/분리 - groupingBy, partitioningBy
        String [] arr = {"Python", "is", "aweful", "lame", "not", "good"};
        Map<Integer, List<String>> map = Arrays.stream(arr)
                .collect(Collectors.groupingBy(String::length));
        System.out.println(map);

        Map<Boolean, List<String>> map2 = Arrays.stream(arr)
                .collect(Collectors.partitioningBy(s -> s.length() < 4));
        System.out.println(map2);

        // 그룹화 + Downstream collector
        // 최종 처리 메소드에서 있던 count(), min()... 등과 유사한
        // Collector중에도 counting(), minBy(), maxBy() ... 등이 있다.
        Map<Integer, Long> map3 = Arrays.stream(arr)
                .collect(Collectors.groupingBy(String::length,
                                               Collectors.counting()));
        System.out.println(map3);

        // 병렬 스트림
        Stream<String> parStream = Arrays.stream(arr).parallel();
        System.out.println(parStream.map(String::length)
                        .count());
        List<String> list4 = List.of("atwe","bff","cqqqw","dtwer");

        // parallelStream을 사용하면 연산 순서가 달라질 수 있다.
        Stream<String> stream6 = list4.parallelStream();
//        Stream<String> stream6 = list4.stream();
        stream6.map(String::length)
                .peek(s -> System.out.println("A:" + s))
                .filter(value -> value > 3)
                .peek(s -> System.out.println("B:" + s))
                .forEach(System.out::println);
    }
}
