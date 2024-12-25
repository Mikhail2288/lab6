@Two(first = "Hello", second = 42)
public class Normal {
    private String name;
    private int age;

    public Normal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Normal {name = '" + name + ", age=" + age +'}';
    }
}
