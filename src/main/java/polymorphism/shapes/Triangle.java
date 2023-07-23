package polymorphism.shapes;

public class Triangle implements shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    public double showArea() {
        return (1.0/2.0) * (base * height);
    }
}
