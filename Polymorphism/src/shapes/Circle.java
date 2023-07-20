package shapes;

public class Circle implements shape {
    private final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
   // @Override
    public double showArea() {
        return Math.PI * Math.pow(radius, 2.0);
    }
}
