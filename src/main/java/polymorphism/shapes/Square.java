package polymorphism.shapes;

public class Square implements Shape {
    private final double side;
    public Square(double side) {
        this.side = side;
    }
    // @Override
    public double showArea() {
        return side * side;
    }
}
