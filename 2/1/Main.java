import static java.lang.System.out;
import java.lang.reflect.Method;

public class Main {
    @Invoke
    public static void myInvokedMethod() {
        out.println("Метод myInvokedMethod был вызван.");
    }

    public static void myRegularMethod() {
        out.println("Метод myRegularMethod был вызван.");
    }
    
    public static void main(String[] args) throws Exception {
        Method[] methods = Main.class.getDeclaredMethods();// Получаем все методы класса
        for (Method method : methods) {//Проходимся по всем методам и проверяем наличие аннотации
            if (method.isAnnotationPresent(Invoke.class)) {
                out.println("Найдена аннотация @Invoke на методе: " + method.getName());
                 method.invoke(null); // вызов статического метода
            } else {
                out.println("Метод " + method.getName() + " не помечен аннотацией @Invoke");
            }
        }
    }
}
