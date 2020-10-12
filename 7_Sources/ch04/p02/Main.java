package p02;

class Calculator {
    private final ArithmaticOperator op;

    public Calculator(ArithmaticOperator op) {
        this.op = op;
    }

    public int run(int x, int y) {
        return op.operate(x, y);
    }
    public long run(long x, long y) {
        return op.operate(x, y);
    }
    public double run(double x, double y) {
        return op.operate(x, y);
    }

}

class Runner {
    public static void run(ArithmaticOperator op, int x, int y) {
        System.out.println(op.operate(x, y));
    }
}

public class Main {
    public static void main(String[] args) {
        // 다형성의 예(1)
        ArithmaticOperator op;
        op = new Add();
        System.out.println(op.operate(10.0, 20));

        // 다형성의 예(2)
        ArithmaticOperator [] ops;
        ops = new ArithmaticOperator[]{new Add(), new Multiply()};
        for (ArithmaticOperator o: ops) {
            System.out.println(o.operate(5, 2));
        }

        // 다형성의 예(3)
        Calculator add = new Calculator(new Add());
        Calculator sub = new Calculator(new Subtract());

        System.out.println(add.run(10, 20));
        System.out.println(sub.run(20, 15));

        // 다형성의 예(4)
        Runner.run(new Add(), 40, 50);
        Runner.run(new Divide(), 6, 2);
    }
}
