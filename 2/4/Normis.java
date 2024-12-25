import java.util.Arrays;

@Validate(value = {String.class, Integer.class})
public class Normis {
    private String name;
    private int age;

    public Normis(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyClass {name = '" + name + ", age=" + age +'}';
    }
}
