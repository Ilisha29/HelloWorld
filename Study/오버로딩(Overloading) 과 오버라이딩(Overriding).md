# 오버로딩(Overloading) 과 오버라이딩(Overriding)

### 오버로딩

두 메서드가 같은 이름을 가지고 있으나 인자의  수나 자료형이 다른 경우를 말함

ex)

```java
public double computeArea(Circle c){}
public double computeArea(Circle c1, Circle c2){}
public double computeArea(Square c){}
```



### 오버라이딩

상위 클래스의 함수와 변수등을 하위 클래스에 재정의하는 것

- 상속관계에 있는 클래스 사이에서 같은 이름의 메소드를 다시 정의하는것

```java
public abstract class Shape {
  public void printMe() { System.out.println("Shape"); }
  public abstract double computeArea();
}
public class Circle extends Shape {
  private double rad = 5;
  @Override // 개발자의 실수를 방지하기 위해 @Override(annotation) 쓰는 것을 권장
  public void printMe() { System.out.println("Circle"); }
  public double computeArea() { return rad * rad * 3.15; }
}
public class Ambiguous extends Shape {
  private double area = 10;
  public double computeArea() { return area; }
}
https://gmlwjd9405.github.io/2018/08/09/java-overloading-vs-overriding.html
```



```java
public class Main {
  public static void main(String[] args) {
    Shape[] shapes = new Shape[2];
    Circle circle = new Circle();
    Ambiguous ambiguous = new Ambiguous();

    shapes[0] = circle;
    shapes[1] = ambiguous;

    for(Shape s : shapes) {
      s.printMe();
      System.out.println(s.computeArea());
    }
  }
}
https://gmlwjd9405.github.io/2018/08/09/java-overloading-vs-overriding.html
```



```java
public class Main {
  public static void main(String[] args) {
    Shape[] shapes = new Shape[2];
    Circle circle = new Circle();
    Ambiguous ambiguous = new Ambiguous();

    shapes[0] = circle;
    shapes[1] = ambiguous;

    for(Shape s : shapes) {
      s.printMe();
      System.out.println(s.computeArea());
    }
  }
}
https://gmlwjd9405.github.io/2018/08/09/java-overloading-vs-overriding.html
```









