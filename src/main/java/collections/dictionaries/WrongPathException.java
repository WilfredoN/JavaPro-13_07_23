package collections.dictionaries;

public class WrongPathException extends Throwable {
    String path;

    public String getPath() {
        return path;
    }

    public WrongPathException(String path) {
        super("Шлях до файлу у вигляді " + path + " неправильний");
        this.path = path;
    }
}
