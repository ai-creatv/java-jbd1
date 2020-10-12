# Design Patterns

## 디자인 패턴이란

- 자주 발생하는 문제를 해결하기 위해 설계된 재사용 가능한 해결책
  - Don't reinvent the wheel
- 소프트웨어 설계 문제를 쉽게 해결할 수 있도록 패턴화된 설계 방식
- 팀원들이 공유할 수 있는 공통의 언어가 되어 소통을 원활하게 함

## 디자인 패턴의 구조

- 문맥 (Context)
  - 패턴이 적용될 수 있는 문제 상황을 기술
- 문제 (Problem)
  - 패턴이 적용되어 해결되어야 하는 여러 설계 이슈를 기술
- 해결 (Solution)
  - 문제를 해결하는 설계 구성 요소와 구성 요소 사이의 관계를 기술

## 디자인 패턴의 종류

- Gang of four 패턴
  - 생성 패턴 (Creational patterns)
    - 객체의 생성 방식에 관련된 패턴
    - Abstract Factory, Factory Method, Singleton ...
  - 구조 패턴 (Structural patterns)
    - 클래스/객체를 조합한 구조를 가지는 패턴
    - Composite, Decorator ...
  - 동작 패턴 (Behavioral patterns)
    - 클래스/객체 사이의 동작 분배에 관련된 패턴
    - Observer, State, Strategy, Template Method, Command ...

- 동시성 패턴 (Concurrency patterns)
  - Scheduling, Monitor, Lock ...
- 아키텍처 패턴 (Architecture patterns)
  - Model-View-Controller, Model-View-Presenter, Model-View-ViewModel ...
- 기타 패턴
  - Dependency injection, Lazy loading, Mock object ...

## 대표적인 디자인 패턴

- 싱글톤 패턴
  - 단 하나의 객체만 존재할 수 있는 클래스를 구현하는 패턴

  ```java
  class Singleton {
      private static Singleton instance;

      private Singleton() {}

      public static Singleton getInstance() {
          if(instance == null) {
              instance = new Singleton();
          }
          return instance;
      }
  }
  ```

- 팩토리 패턴
  - 구상 클래스 객체를 전담하여 생성하는 클래스를 구현하는 패턴
  - 팩토리 메소드 패턴 ([ref](https://www.tutorialspoint.com/design_pattern/factory_pattern.htm))

  ![img1](https://www.tutorialspoint.com/design_pattern/images/factory_pattern_uml_diagram.jpg)

    ```java
    interface Shape {
        void draw();
    }

    class Rectangle implements Shape {
      @Override
      public void draw() {
          System.out.println("Inside Rectangle::draw() method.");
        }
    }
    
    class Square implements Shape {
      @Override
      public void draw() {
          System.out.println("Inside Square::draw() method.");
      }
    }
    
    class Circle implements Shape {
      @Override
      public void draw() {
          System.out.println("Inside Circle::draw() method.");
      }
    }

    class ShapeFactory {
	
   
    Shape getShape(String shapeType){
        if(shapeType == null){
          return null;
        }		
        if(shapeType.equalsIgnoreCase("CIRCLE")){
          return new Circle();
          
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
          return new Rectangle();
          
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
          return new Square();
        }
        
        return null;
      }
    }
    class FactoryPatternDemo {
      public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        shape2.draw();

        Shape shape3 = shapeFactory.getShape("SQUARE");

        shape3.draw();
      }
    }
    ```

  - 추상 팩토리 패턴 ([ref](https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm))
    
  ![img2](https://www.tutorialspoint.com/design_pattern/images/abstractfactory_pattern_uml_diagram.jpg)

    ```java
    public interface Shape {
      void draw();
    }
    
    class RoundedRectangle implements Shape {
      @Override
      public void draw() {
          System.out.println("Inside RoundedRectangle::draw() method.");
      }
    }
    
    class RoundedSquare implements Shape {
      @Override
      public void draw() {
          System.out.println("Inside RoundedSquare::draw() method.");
      }
    }
    
    class Rectangle implements Shape {
      @Override
      public void draw() {
          System.out.println("Inside Rectangle::draw() method.");
      }
    }
    
    abstract class AbstractFactory {
      abstract Shape getShape(String shapeType) ;
    }
    
    class ShapeFactory extends AbstractFactory {
      @Override
      public Shape getShape(String shapeType){    
          if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();         
          }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
          }	 
          return null;
      }
    }
    
    class RoundedShapeFactory extends AbstractFactory {
      @Override
      public Shape getShape(String shapeType){    
          if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();         
          }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new RoundedSquare();
          }	 
          return null;
      }
    }
    
    class FactoryProducer {
      public static AbstractFactory getFactory(boolean rounded){   
          if(rounded){
            return new RoundedShapeFactory();         
          }else{
            return new ShapeFactory();
          }
      }
    }
    
    class AbstractFactoryPatternDemo {
      public static void main(String[] args) {
          AbstractFactory shapeFactory = FactoryProducer.getFactory(false);

          Shape shape1 = shapeFactory.getShape("RECTANGLE");
          shape1.draw();
          Shape shape2 = shapeFactory.getShape("SQUARE");
          shape2.draw();

          AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);

          Shape shape3 = shapeFactory1.getShape("RECTANGLE");
          shape3.draw();
          Shape shape4 = shapeFactory1.getShape("SQUARE");
          shape4.draw();
      }
    }
    ```

- 데코레이터 패턴
  - 생성자를 이용해 객체에 일정한 기능을 추가하는 패턴 ([ref](https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm))

  ![img3](https://www.tutorialspoint.com/design_pattern/images/decorator_pattern_uml_diagram.jpg)

  ```java
  interface Shape {
    void draw();
  }
  
  class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
  }
  
  class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
  }
  
  abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }	
  }
  
  class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);		
    }

    @Override
    public void draw() {
        decoratedShape.draw();	       
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
  }
  
  class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
  }
  ```

- 옵저버 패턴
  - Observable 객체의 변화를 Observer에서 알 수 있도록 하는 패턴 [ref](https://www.tutorialspoint.com/design_pattern/observer_pattern.htm)

  ![img4](https://www.tutorialspoint.com/design_pattern/images/observer_pattern_uml_diagram.jpg)

  ```java
  class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);		
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
          observer.update();
        }
    } 	
  }
  
  abstract class Observer {
    protected Subject subject;
    public abstract void update();
  }
  
  class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) ); 
    }
  }
  
  class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
      System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) ); 
    }
  }
  
  class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() ); 
    }
  }
  
  class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");	
        subject.setState(15);
        System.out.println("Second state change: 10");	
        subject.setState(10);
    }
  }
  ```