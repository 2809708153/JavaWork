package cn.ctbu.edu.jsj;
//abstract class MyShape
abstract class MyShape {
    abstract double calculatePerimeter();
    abstract double calculateArea();
}

//class MyRectangle
class MyRectangle extends MyShape {
    private double length;
    private double width;

    public MyRectangle(double lth, double wth) {
        this.length = lth;
        this.width = wth;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

//class MyCircle
class MyCircle extends MyShape {
    private double radius;
    private final double PI = 3.14;
    public MyCircle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * PI * radius;
    }

    @Override
    double calculateArea() {
        return PI * radius * radius;
    }
}

//class Test
public class Test9 {
    public static void main(String[] args) {
        double radius = 5.0;
        double length = 10.0;
        double width = 5.0;

        MyCircle circle = new MyCircle(radius);
        MyRectangle rectangle = new MyRectangle(length, width);

        System.out.println("The circle perimeter is " + circle.calculatePerimeter());
        System.out.println("The circle area is " + circle.calculateArea());
        System.out.println("The rectangle perimeter is " + rectangle.calculatePerimeter());
        System.out.println("The rectangle area is " + rectangle.calculateArea());
    }
}