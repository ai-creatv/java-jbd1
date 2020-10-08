# 자바 컬렉션 프레임워크 (Java Collections Framework; JCF)

## 컬렉션 프레임워크란

- java.utils에 속한 일련의 클래스로, 자료구조를 담당
- 잘 짜여진 인터페이스를 기반으로 다양한 자료구조를 구현
- 제네릭 클래스로 되어 있어, 다양한 객체를 요소로 담을 수 있다.

## JCF 인터페이스

- List 인터페이스
  - Collection 인터페이스를 상속
  - 순서가 있는 데이터의 집합으로, 데이터의 중복을 허용
  - 구현체: ArrayList, LinkedList(, Vector, Stack)
- Set 인터페이스
  - Collection 인터페이스를 상속
  - 순서가 없는 데이터의 집합으로, 데이터의 중복을 허용하지 않음
  - 구현체: HashSet, TreeSet
- Map 인터페이스
  - Key-Value 쌍으로 이루어진 데이터의 집합
  - 구현체: HashMap, TreeMap, Hashtable, Properties

### Collection 인터페이스

- Collection 인터페이스의 주요 메소드

  |메소드|설명|
  |-----|----|
  |`boolean add(E e)`| 요소 e를 컬렉션에 추가한다. |
  |`boolean addAll(Collection<? exteionds E> c)`| 다른 컬렉션 c의 모든 요소를 컬렉션에 추가한다. |
  |`void clear()`| 컬렉션의 모든 요소를 제거한다. |
  |`boolean contains(Object o)`| 컬렉션에 요소 o가 존재하는지 확인한다. |
  |`boolean containsAll(Collection<?> c)` | 컬렉션 c의 모든 요소가 컬렉션에 포함되는지 확인한다. |
  |`boolean equals(Object o)` | 컬렉션 o와 같은 내용을 포함하는지 비교한다. |
  |`boolean isEmpty()` | 컬렉션이 비어있는지 확인한다. |
  |`Iterator<E> iterator()` | 컬렉션의 Iterator를 반환한다.|
  |`boolean remove(Object o)` | 컬렉션에서 요소 o를 제거한다. |
  |`boolean removeAll(Collection<?> c)` | 컬렉션 c에 속한 모든 요소를 컬렉션에서 제거한다. |
  |`boolean retainAll(Collection<?> c)` | 컬렉션 c에 포함된 객체만 남기고 나머지 요소를 제거한다. |
  |`int size()` | 컬렉션에 속한 요소의 개수를 반환한다. |
  |`T[] toArray(T[] a)` | 컬렉션의 요소들을 `T[]` 배열로 반환한다. |

- Iterator
  - `iterator()`로 반환되는 객체로, Collection에 저장된 요소에 접근하기 위해 사용
  
    |메소드| 설명|
    |-----|-----|
    |`boolean hasNext()`|다음 요소가 있는지 확인|
    |`E next()`|다음 요소가 있을 경우 반환|
    |`void remove()`|현재 위치의 요소를 삭제|

  - Iterator의 활용

    ```java
    Iterator<String> iter = collection.iterator();
    while (iter.hasNext()) {
        String string = iter.next();
        System.out.println(string);
    }
    ```

    ```java
    for (String string: collection) {
        System.out.println(string);
    }
    ```

### List 인터페이스

- 순서가 있는 데이터의 집합을 다루는 인터페이스
- List는 인덱스를 이용해 요소를 구분할 수 있어, 데이터의 중복을 허용
- Collection 인터페이스를 상속받았으며, 추가 메소드가 구현되어 있다.

  | 메소드 | 설명 |
  |-------|------|
  |`void add(int index, E element)` | index 위치에 요소 element를 삽입한다. |
  |`boolean addAll(int index, Collection<? extends E> c)` | index위치부터 컬렉션 c의 모든 요소를 추가한다. |
  |`E get(int index)` | index 위치에 저장된 요소를 반환한다. |
  |`int indexOf(Object o)` | 객체 o가 저장된 첫번째 인덱스를 반환한다. 없을 경우 -1을 반환한다. |
  |`int lastIndexOf(Object o)` | 객체 o가 저장된 마지막 인덱스를 반환한다. 없을 경우 -1을 반환한다. |
  |`ListIterator<E> listIterator()` | ListIterator 객체를 반환한다. |
  |`E remove(int index)`| index에 위치한 객체를 제거하고 반환한다. |
  |`E set(int index, E element)` | index에 위치한 요소를 element로 대체한다. |
  |`List<E> subList(int fromIndex, int toIndex)` | fromIndex에 위치한 요소부터 toIndex의 직전에 위치한 요소까지 포함한 List를 반환한다. |

- List 인터페이스의 구현체
  
  ```java
  List<String> list = new ArrayList<>();
  list = new LinkedList<>(); // 동일 인터페이스로 다른 구현체를 사용 가능
  ```

  - `ArrayList<E>`
    - 제네릭 클래스로 구현된 자료구조
    - 배열을 기반으로 구현된 클래스로, 가장 자주 활용되며 활용도가 높다.
    - ArrayList의 생성자는 세 종류가 주어진다.

      ```java
      public ArrayList()
      public Arraylist(int initialCapacity)
      public ArrayList(Collection<? extends E>)
      ```

  - `LinkedList<E>`
    - 제네릭 클래스로 구현된 자료구조
    - 연결리스트를 기반으로 구현된 클래스로, 배열의 단점을 극복하기 위한 구현체
    - ArrayList vs. LinkedList

      | 구현체 | 순차 추가/수정/삭제 | 비순차 추가/수정/삭제 | 조회 |
      |-------|--------------------|---------------------|-------|
      | `ArrayList` | 빠름 | 느림 | 빠름 |
      | `LinkedList` | 느림 | 빠름 | 느림 |

  - `ArrayList`, `LinkedList`
    - Object를 요소로 가지는 List 구현체 (Java5 이전)

- List의 정렬
  - `Collections` 클래스의 `sort()` 메소드 사용
    - `public static <T extends Comparable<? super T> void sort(List<T> list)`
      - 객체에 선언된 `public int compareTo(T t)` 메소드로 비교하여 정렬
    - `public static <T> void sort(List<T> list, Comparator<? super T> c)`
      - Comparator 객체 c에 정의된 `public int compare(T o1, T o2)` 메소드로 비교하여 정렬

- ListIterator
  - `listIterator()`로 반환되는 객체로, 양방향 사용이 가능
  - Iterator를 상속받은 클래스
  
  |메소드| 설명|
  |-----|-----|
  |`boolean hasPrevious()`|이전 요소가 있는지 확인|
  |`E previous()`|이전 요소가 있을 경우 반환|

### Set 인터페이스

- 순서가 없는 데이터의 집합을 다루는 인터페이스
- 중복되는 데이터를 효율적으로 제거하는 데에 쓸 수 있음
- Collection 인터페이스를 상속받아 메소드를 구현하고 있음
- Set의 구현체
  - `HashSet<E>`
    - Set의 대표적인 구현체로, 기본적인 기능이 구현되어 있다.
  - `TreeSet<E>`
    - `NavigableSet<E>` 인터페이스를 구현하며, 이진 탐색 트리 자료구조이다.
    - 객체를 삽입하는 동시에 정렬되는 특성상 비교가 가능해야 한다.

      ```java
      public TreeSet() // Comparable 구현체의 경우
      public TreeSet(Comparator<? super E> comparator) // 별도로 비교 객체 삽입
      ```

    - TreeSet의 메소드

    |메소드|설명|
    |-----|----|
    |`public E first()`|정렬된 첫 요소를 반환|
    |`public E last()`|정렬된 마지막 요소를 반환|
    |`public E lower(E e)`|e 객체의 바로 이전 객체를 반환|
    |`public E higher(E e)`|e 객체의 바로 다음 객체를 반환|
    |`public E floor(E e)`|e 또는 e 보다 이전 객체를 반환|
    |`public E ceiling(E e)`|e 또는 e 보다 이후 객체를 반환|
    |`public E pollFirst()`|정렬된 첫 요소를 제거하고 반환|
    |`public E pollLast()`|정렬된 마지막 요소를 제거하고 반환|
    |`public NavigableSet<E> descendingSet()`|내림차순으로 정렬하는 객체를 반환|
    |`public NavigableSet<E> headSet(E toElement, boolean inclusive)`|toElement 이전 요소로 구성된 객체 반환|
    |`public NavigableSet<E> tailSet(E fromElement, boolean inclusive)`|fromElement 이후 요소로 구성된 객체 반환|
    |`public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)`|fromElement 이후, toElement 이전 요소로 구성된 객체 반환|

### Map 인터페이스

- Key와 Value의 쌍으로 구성된 자료의 집합을 다루는 인터페이스\
  - Key, Value 쌍은 `Map.Entry<K, V>` 객체로 관리
- Key는 중복될 수 없으며, Value는 중복이 가능
- `Map<K, V>`의 구현체
  - `HashMap<K, V>` : 가장 많이 사용되는 Map의 구현체
  - `TreeMap<K, V>` : 정렬 기준이 더해진 NavigableMap을 구현한 구현체
  - `Hashtable<K, V>` : HashMap과 유사하지만 성능이 떨어지는 대신 멀티스레드에 안전한 구현체
  - `Properties` : 속성 파일을 손쉽게 관리하는, `Hashtable<K, V>`의 하위 클래스 구현체

- `Map<K, V>`의 주요 메소드

  | 메소드 | 설명 |
  |-------|------|
  | `void clear()` | Map의 모든 요소를 삭제 |
  | `boolean containsKey(Object key)` | key가 존재하는지 여부를 반환 |
  | `boolean containsValue(Object value)` | value가 존재하는지 여부를 반환 |
  | `Set<Map.Entry<K,V>> entrySet()` | Map의 Entry 요소를 Set에 담아 반환 |
  | `V get(Object key)` | key에 해당하는 value 객체 반환 |
  | `Set<K> keySet()` | key 요소를 Set 형태로 반환 |
  | `V put(K key, V value)` | key와 value 쌍으로 구성된 Entry 추가. 기존에 등록된 key라면 해당 value를, 없으면 null을 반환 |
  | `void putAll(Map<? extends K, ? extends V> m)` | m에 속한 모든 Entry를 추가 |
  | `V remove(Object key)` | key에 해당하는 Entry를 제거하고 반환. 등록되지 않은 key라면 null 반환 |
  | `Collection<V> values` | value 객체들을 Collection에 담아 반환 |
  | `int size()` | Map에 포함된 Entry 객체의 수 반환 |
  | `boolean isEmpty()` | Map에 데이터가 없는지 여부 반환 |

- `TreeMap<K, V>`의 주요 메소드

  |메소드|설명|
  |-----|----|
  |`public Map.Entry<K, V> firstEntry()`|정렬된 첫 Entry 반환|
  |`public Map.Entry<K, V> lastEntry()`|정렬된 마지막 Entry 반환|
  |`public Map.Entry<K, V> lowerEntry(K key)`|key 바로 이전 Entry 반환|
  |`public Map.Entry<K, V> higherEntry(K key)`|key 바로 다음 Entry 반환|
  |`public Map.Entry<K, V> floorEntry(K key)`|key 또는 key 보다 이전 Entry 반환|
  |`public Map.Entry<K, V> ceilingEntry(K key)`|key 또는 key 보다 이후 Entry 반환|
  |`public Map.Entry<K, V> pollFirstEntry()`|정렬된 첫 Entry를 제거하고 반환|
  |`public Map.Entry<K, V> pollLastEntry()`|정렬된 마지막 Entry를 제거하고 반환|
  |`public NavigableSet<E> descendingKeySet()`|내림차순으로 정렬하는 Set 반환|
  |`public NavigableSet<E> descendingKeyMap()`|내림차순으로 정렬하는 Map 반환|
  |`public NavigableMap<K, V> headMap(K toKey, boolean inclusive)`|toKey 이전 Entry로 구성된 객체 반환|
  |`public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive)`|fromKey 이후 Entry로 구성된 객체 반환|
  |`public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)`|fromKey 이후, toKey 이전 Entry로 구성된 객체 반환|

- `Properties`의 주요 메소드

  | 메소드 | 설명 |
  |-------|------|
  | `getProperty()` | key에 해당하는 속성 값을 반환 |
  | `stringPropertyNames()` | key의 목록을 `Set<String>`으로 반환 |
  | `setProperty()` | key로 value를 등록하고 기존 value 값을 반환 |
  | `load()` | reader를 이용해 속성을 읽어온다. (.properties) |
  | `loadFromXML()` | XML 형식으로 저장된 속성을 읽어온다. |
  | `store()` | writer를 이용해 속성을 저장한다. |
  | `storeToXML()` | XML 형식으로 속성 파일을 저장한다. |
