package obstacle;

public class Barrier {
    String type;
    float length;
    float height;

    public Barrier(String type, float length, float height) {
        this.type = type;
        this.length = length;
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }
}
