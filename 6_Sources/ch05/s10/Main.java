package ch5.s10;

import java.util.*;

/**
 * Java Collections Framework (JCF)
 * - java.util에 속한 일련의 클래스, 자료구조를 담당
 *   - 자료구조: 자료의 집합 또는 그 집합의 동작을 정의하는 수학적 모델
 * - 제네릭 클래스 되어 있어, 다양한 객체를 요소(Element)로 담을 수 있다.
 *   - 요소: 자료구조를 구성하는 하나하나의 자료
 */

public class Main {
    public static void main(String[] args) {
        // List 인터페이스
        // - Collection 인터페이스 상속
        // - 순서가 있는 데이터의 집합. 데이터 중복 허용
        // - 데이터의 순서(index)가 유일한 데이터의 구분자(identifier)로 사용
        // [1, 4, 2, 5, 6, 2, 1] -> 같은 값이 있으나, index가 다름
        List<String> stringList = new ArrayList<>(); // 가장 많이 쓰이는, 배열 기반의 리스트
        List<String> stringList2 = new LinkedList<>(); // 노드의 연결로 구성된 리스트
        List<String> stringList3 = new Vector<>(); // 멀티스레드 환경에서 안전하게 동작...하나 무지 느리다. (잘 안쓴다)
        List<String> stringList4 = new Stack<>(); // Stack 자료구조 구현 -> 자료구조때 봅시다.

        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            intList.add(i); // List의 맨 뒤에 자료를 추가한다.
        }                   // List는 맨 뒤에 자료 추가(순차처리)가 가장 빠르다.
        System.out.println(intList);
        System.out.println(intList.size());

        // 중간 index에 add할 경우 자료를 뒤로 한칸씩 민다.
        intList.add(2, 678493);
        System.out.println(intList);
        System.out.println(intList.size());

        List<Integer> intList2 = new LinkedList<>();
        for (int i = 5; i < 10; i++) {
            intList2.add(i);
        }
        System.out.println(intList2);

        // 입력된 Collection 내용 전체를 한번에 add하는 메소드
        // index를 입력받아 위치도 지정 가능
        intList.addAll(1, intList2);
        System.out.println(intList);

        System.out.println("ind 3: " + intList.get(3));
        System.out.println(intList.indexOf(9)); // 객체를 찾아 가장 첫번째 인덱스를 반환
        System.out.println(intList.lastIndexOf(9)); // 객체를 찾아 가장 마지막 인덱스를 반환

        // remove()메소드는 index에서 obj를 제거하고 그것을 반환
        // 요소가 제거되면, 그 뒤 요소들은 모두 index가 하나씩 앞으로 당겨짐
        System.out.println("idx 9 was: " + intList.remove(9));
        System.out.println(intList);

        // 배열처럼 index의 값을 value로 대체한다.
        intList.set(1, 100);
        System.out.println(intList);

                                     // inclusive, exclusive
        List<Integer> list3 = intList.subList(2, 5);
        System.out.println(list3);

        // fori를 이용한 접근
        for (int i = 0; i < list3.size(); i++) {
            System.out.println(list3.get(i));
        }

        // foreach를 이용한 접근
        for (int value: list3) {
            System.out.println(value);
        }

        // listIterator를 이용한 접근 - foreach문은 사실 이것을 짧게 쓴 것
        ListIterator<Integer> iter = list3.listIterator();
        while (iter.hasNext()) { // true일 때만 다음 요소가 있음
            Integer integer = iter.next(); // 다음 요소를 반환
            System.out.println(integer);
        }




        // Set 인터페이스
        // - Collection 인터페이스 상속
        // - 순서가 없는 데이터 {집합}을 다루는 인터페이스
        // - 중복되는 데이터를 효율적으로 제거하는데에 사용 가능
        // - 중복을 검사하는 수단 1.hashCode(), 2. equals()
        //  - hash를 빠르게 계산해서 hash만 비교
        //  - 그 다음에 판정이 안나면 equals()로 추가 비교

        Set<String> stringSet1 = new HashSet<>(); // 기본적인 집합
        stringSet1.add("A");
        stringSet1.add("B");
        stringSet1.add("B");
        stringSet1.add("F");
        System.out.println(stringSet1);
        // List -> 중복되는 것을 제거
        // 이중 for문을 이용해서 모두 비교/삭제 O(n^2)
        // List -> Set으로 한번씩만 옮기면 중복이 제거됨
        // 1중 for문을 이용해서 비교할 필요 없이 알아서 삭제됨 O(n)


        NavigableSet<String> stringSet2 = new TreeSet<>(); // 이진 탐색 트리

        class Foo {
            int x, y;

            public Foo(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return x + ", " + y;
            }
        }

        NavigableSet<Foo> set = new TreeSet<>(
                Comparator.comparingInt(o -> o.x));
        set.add(new Foo(1, 100));
        set.add(new Foo(4, 50));
        set.add(new Foo(0, 170));
        set.add(new Foo(-2, 3300));

        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set.lower(new Foo(1, 500)));
        System.out.println(set.floor(new Foo(1, 500)));
        System.out.println(set.higher(new Foo(2, 500)));
        System.out.println(set.ceiling(new Foo(1, 500)));

        // poll -> 셋에서 삭제도 같이 한다.
        System.out.println(set.pollFirst());
        System.out.println(set.pollFirst());
        System.out.println(set.pollFirst());
        System.out.println(set.pollFirst());
        System.out.println(set.pollFirst());


        // Map 인터페이스
        // - Collection 인터페이스를 상속x
        // - Key, Value 쌍으로 구성된 자료의 집합을 다루는 인터페이스
        //   - Map.Entry<K, V>
        // - Key는 중복될 수 없으며, Value는 중복이 가능
        //   - key가 identifier 역할을 한다.

        Map<String, Integer> map = new HashMap<>();


        // put은 기존에 동일 key가 있었으면 기존 value를 반환, 없었으면 null
        System.out.println(map.put("ABCDE", 5));
        System.out.println(map.put("CDEF", 1023));
        System.out.println(map.put("ABCDE", 1023));

        System.out.println(map.get("CDEF")); // query (질의)
        System.out.println(map.getOrDefault("CDEF", 0));
        System.out.println(map.getOrDefault("ZZZZZ", 0)); // key가 없으면 default 값을 반환

        // 이렇게 기존 값이 없을 때 0 등으로 기본 값을 설정하고 싶으면 편리함
        map.put("ABCDE", map.getOrDefault("ABCDE", 0) + 1);

        // keySet 사용
        for (String key: map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

        // entrySet 사용
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        NavigableMap<String, Integer> map2 = new TreeMap<>();
        map2.put("a", 10);
        map2.put("g", 12);
        map2.put("z", 14);
        map2.put("z", 114);
        map2.put("c", 165);

        System.out.println(map2.ceilingKey("b"));
        System.out.println(map2.ceilingEntry("b").getValue());
        System.out.println(map2.pollFirstEntry().getValue());
        System.out.println(map2.pollFirstEntry().getValue());
        System.out.println(map2.pollFirstEntry().getValue());
        System.out.println(map2.pollFirstEntry().getValue());

        System.out.println(map2);


        // 번외
        Map<String, Integer> map3 = new Hashtable<>(); // Vector처럼 옛날 구현 synchronized
        Properties prop = new Properties(); // Hashtable<String, String>을 상속
        prop = System.getProperties(); // System의 property가 이 형식으로 제공됨



    }
}
