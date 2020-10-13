package s01.p02;

/**
 * 팩토리 패턴
 * - 구상 클래스 객체(추상 클래스를 구현한 것; Concrete class)
 *   를 전담하여 생성하는 클래스를 구현하는 패턴
 */

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle drawn");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square drawn");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle drawn");
    }
}

class RoundedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("RoundedRectangle drawn");
    }
}

class RoundedSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("RoundedSquare drawn");
    }
}


// 팩토리 메소드 패턴
// 팩토리 클래스가 다른 클래스에서 가지게 될 의존성을 모두 가져옴
class ShapeFactory {
    Shape getShape(String shapeType) {
        Shape shape = null;
        if (shapeType.equals("Circle")) {
            shape =  new Circle();
        } else if (shapeType.equals("Rectangle")) {
            shape = new Rectangle();
        } else if (shapeType.equals("Square")){
            shape = new Square();
        }

        return shape;
    }
}

// 추상 팩토리 패턴 (Abstract factory pattern)
abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
}

class RoundedShapeFactory extends AbstractFactory {

    @Override
    Shape getShape(String shapeType) {
        Shape shape = null;
        if (shapeType.equals("Circle")) {
            shape =  new Circle();
        } else if (shapeType.equals("Rectangle")) {
            shape = new RoundedRectangle();
        } else if (shapeType.equals("Square")){
            shape = new RoundedSquare();
        }

        return shape;
    }
}

class NormalShapeFactory extends AbstractFactory {

    @Override
    Shape getShape(String shapeType) {
        Shape shape = null;
        if (shapeType.equals("Circle")) {
            shape =  new Circle();
        } else if (shapeType.equals("Rectangle")) {
            shape = new Rectangle();
        } else if (shapeType.equals("Square")){
            shape = new Square();
        }

        return shape;
    }
}

class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if (rounded) {
            return new RoundedShapeFactory();
        } else {
            return new NormalShapeFactory();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        String shapeType = "Circle";
        Shape shape;

        // 이렇게 매번 직접 객체를 생성할 경우,
        // 새로운 구상 클래스가 만들어졌을 떄 코드 수정이 불가피
        // 클래스가 구상 클래스에 의존하게 됨
        // 클래스는 추상 클래스(인터페이스)에 의존하는 것이 더 바람직
        if (shapeType.equals("Circle")) {
            shape =  new Circle();
        } else if (shapeType.equals("Rectangle")) {
            shape = new Rectangle();
        } else if (shapeType.equals("Square")){
            shape = new Square();
        } else {
            shape = null;
        }

        if (shape != null) {
            shape.draw();
        }

        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShape("Circle");
        shape1.draw();

        Shape shape2 = FactoryProducer
                .getFactory(true)
                .getShape("Rectangle");
        shape2.draw();

    }
}
