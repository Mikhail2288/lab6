@Default(value = String.class)
public class MyClass {
    @Default(value = Integer.class)
    private  String testField;
    public String myMethod() {
        return "Метод myMethod был вызван.";
    }
}
