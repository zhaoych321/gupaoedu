package object;

public class ReflectPointer {
    public int x;
    private int y;
    public String str1 = "itcat";
    public String str2 = "basketball";
    public String str3 = "ball";
    public ReflectPointer(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "ReflectPointer{" +
                "str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                ", str3='" + str3 + '\'' +
                '}';
    }
}
