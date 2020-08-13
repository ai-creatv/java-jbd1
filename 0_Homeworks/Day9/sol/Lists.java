
/**
 * List 인터페이스를 구현하여 IntArrayList 클래스를 완성하시오.
 *
 * List는 순서가 있는 연속된 값으로, List 인터페이스에 선언되어 있는 메소드의 기능은 아래와 같다.
 *
 * - append(): List의 마지막에 value를 삽입한다.
 * - prepend(): List의 시작점에 value를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
 * - insert(): index에 value를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
 * - remove(): index의 value를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
 * - get(): index의 value를 반환한다.
 * - length(): List의 길이를 출력한다.
 *
 * IntArrayList는 int []를 이용하여 List를 구현한다.
 * - 생성자에서는 capacity를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */

interface List {
    void append(int value);
    void prepend(int value);
    void insert(int index, int value);
    void remove(int index);
    int get(int index);
    int length();
}

class IntArrayList implements List {
    private int capacity;
    private int length;
    private int [] integers;

    public IntArrayList(int capacity) {
        this.capacity = capacity;
        length = 0;
        integers = new int[capacity];
    }

    private void expandCapacity(int offset) {
        int [] newIntegers = new int[capacity * 2];
        System.arraycopy(integers, 0, newIntegers, offset, capacity);
        integers = newIntegers;
        capacity *= 2;
    }

    private void expandCapacity() {
        expandCapacity(0);
    }

    @Override
    public void append(int value) {
        if (length == capacity) {
            expandCapacity();
        }
        integers[length++] = value;
    }

    @Override
    public void prepend(int value) {
        if (length == capacity) {
            expandCapacity(1);
        } else {
            if (length >= 0) System.arraycopy(integers, 0, integers, 1, length);
        }
        integers[0] = value;
        length++;
    }

    @Override
    public void insert(int index, int value) {
        if (length == capacity) {
            expandCapacity();
        }
        if (index <= length && length >= 0) {
            System.arraycopy(integers, index, integers, index + 1, length - index);
        }
        integers[index] = value;
        length++;
    }

    @Override
    public void remove(int index) {
        if (index < length && length >= 0) {
            System.arraycopy(integers, index + 1, integers, index, length - index - 1);
        }
        length--;
    }

    @Override
    public int get(int index) {
        if (index < length) {
            return integers[index];
        } else {
            return -1;
        }
    }

    @Override
    public int length() {
        return length;
    }
}


public class Lists {
    public static void printList(IntArrayList list) {
        for (int i = 0; i < list.length(); i++) {
            System.out.printf("%d ", list.get(i));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        IntArrayList list = new IntArrayList(10);
        for (int i = 0; i < 20; i++) {
            list.append(i);
        }
        printList(list);

        list.remove(5);
        printList(list);

        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        printList(list);

        list.insert(5, 100);
        printList(list);
    }
}
