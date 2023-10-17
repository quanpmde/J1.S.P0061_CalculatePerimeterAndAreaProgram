package DataAccess;

import common.Validation;
import model.Circle;
import model.Rectangle;
import model.Triangle;

public class ShapeDao {

    private static ShapeDao instance = null;

    public static ShapeDao Instance() {
        if (instance == null) {
            synchronized (ShapeDao.class) {
                if (instance == null) {
                    instance = new ShapeDao();
                }
            }
        }
        return instance;
    }

    public Rectangle calculateRectangle() {
        System.out.println("Please input side width of Rectangle: ");
        double width = Validation.checkInputDouble();
        System.out.println("Please input length of Rectangle: ");
        double length = Validation.checkInputDouble();
        return new Rectangle(width, length);
    }

    public Circle calculateCircle() {
        System.out.println("Please input radius of Circle: ");
        double radius = Validation.checkInputDouble();
        return new Circle(radius);
    }
    
    public Triangle calculateTriangle() {
        while (true) {
            System.out.println("Please input side A of Triangle: ");
            double a = Validation.checkInputDouble();
            System.out.println("Please input side B of Triangle: ");
            double b = Validation.checkInputDouble();
            System.out.println("Please input side C of Triangle: ");
            double c = Validation.checkInputDouble();
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Re-input");
            }
        }
    }
    
    public void display(Rectangle rectangle, Circle circle, Triangle triangle) {
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }
}
