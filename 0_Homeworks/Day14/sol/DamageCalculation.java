import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntUnaryOperator;

/**
 * 열거형 타입과 함수형 프로그래밍을 이용하여 플레이어의 공격력을 계산하는 알고리즘을 구현하시오.
 *
 * 플레이어 공격력을 계산하는 과정은 아래와 같다.
 * 1. 플레이어의 무기에 따라 공격력이 변화한다. 무기는 최근에 장착한 무기의 공격력 만으로 계산된다.
 *   1-1. BARE_HANDS - 공격력 5
 *   1-2. DAGGER - 공격력 40
 *   1-3. LONG_SWORD - 공격력 100
 *   1-4. DRAGON_SLAYER -  공격력 250
 * 2. 플레이어의 공격력에 영향을 주는 아이템에 따라 공격력 증가 방식이 다르며, 아이템은 중복 적용된다.
 *   2-1. BLACK_POTION - 공격력 10% 증가
 *   2-2. WHITE_POTION - 모든 공격력 계산이 끝난 후에 공격력 + 200
 *   2-3. MUSHROOM - 무기 공격력 + 20
 *
 */

enum Weapon {
    BARE_HANDS(5), DAGGER(40), LONG_SWORD(100), DRAGON_SLAYER(250);

    private final int damage;

    Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}

enum Item implements Comparable<Item> {
    MUSHROOM(value -> value + 20, 0),
    BLACK_POTION(value ->(int)(value * 1.1), 1),
    WHITE_POTION(value -> value + 200, 2);

    private final IntUnaryOperator op;
    private final int priority;

    Item(IntUnaryOperator op, int priority) {
        this.op = op;
        this.priority = priority;
    }

    public IntUnaryOperator getOp() {
        return op;
    }

    public int getPriority() {
        return priority;
    }
}

class Player {
    private Weapon weapon = Weapon.BARE_HANDS;
    private final List<Item> items = new ArrayList<>();

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int getDamage() {
        items.sort(Comparator.comparingInt(Item::getPriority));
        IntUnaryOperator op = value -> value;
        for (Item item: items) {
            op = op.andThen(item.getOp());
        }
        return op.applyAsInt(weapon.getDamage());
    }
}

public class DamageCalculation {
    public static void main(String[] args) {
        Player player = new Player();
        player.setWeapon(Weapon.DAGGER);
        System.out.println(player.getDamage());

        player.setWeapon(Weapon.DRAGON_SLAYER);
        System.out.println(player.getDamage());

        player.addItem(Item.BLACK_POTION);
        player.addItem(Item.WHITE_POTION);
        player.addItem(Item.WHITE_POTION);
        System.out.println(player.getDamage());

        player.removeItem(Item.WHITE_POTION);
        System.out.println(player.getDamage());

        player.addItem(Item.BLACK_POTION);
        player.addItem(Item.BLACK_POTION);
        player.addItem(Item.BLACK_POTION);
        player.addItem(Item.BLACK_POTION);
        System.out.println(player.getDamage());

        player.addItem(Item.MUSHROOM);
        System.out.println(player.getDamage());

        player.setWeapon(Weapon.LONG_SWORD);
        System.out.println(player.getDamage());
    }
}
