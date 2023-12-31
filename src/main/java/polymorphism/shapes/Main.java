package polymorphism.shapes;

public class Main {
    public static void main(String []args) {
        Shape[] Figures = {
                new Circle(1 + Math.random() * 50),
                new Triangle(1 + Math.random() * 50, 1 + Math.random() * 50),
                new Square(1 + Math.random() * 50),
        };
        double total = 0;

        for (Shape figure : Figures) {
            System.out.println(figure.showArea());
            total += figure.showArea();
        }
        System.out.println("Сумарна площа всіх фігур - " + total);
    }
}
