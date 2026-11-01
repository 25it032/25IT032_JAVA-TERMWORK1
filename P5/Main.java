
abstract class Shape {

    abstract double area();
}


class Circle extends Shape {

    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return 3.14 * radius * radius;
    }
}


class Rectangle extends Shape {

    int l, b;

    Rectangle(int l, int b) {
        this.l = l;
        this.b = b;
    }

    @Override
    double area() {
        return l * b;
    }
}


class Triangle extends Shape {

    int l, w;

    Triangle(int l, int w) {
        this.l = l;
        this.w = w;
    }

    @Override
    double area() {
        return 0.5 * l * w;
    }
}


public class Main {

    public static void main(String[] args) {

        Shape[] shapes = {
            new Circle(5),
            new Rectangle(5, 10),
            new Triangle(5, 10)
        };

        double total = 0;
        double largest = 0;

        for (Shape s1 : shapes) {

            double a = s1.area();

            System.out.println("Area = " + a);

            total += a;

            if (a > largest) {
                largest = a;
            }
        }

        System.out.println("Total area = " + total);
        System.out.println("Largest area = " + largest);
    }
}
    
                    
        
    

