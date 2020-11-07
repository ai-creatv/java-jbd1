package p02;

// POJO : Plain Old Java Object
// - 이렇게 불러야 사람들이 그럴듯해 보여서 자바 클래스를 쓰더라
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(int value) {
        balance -= value;
    }

    public void deposit(int value) {
        balance += value;
    }

    public boolean isMinus() {
        return balance < 0;
    }

    public void throwExcept() {
        throw new ArithmeticException();
    }
}
