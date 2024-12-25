import static java.lang.System.out;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    @Invoke
    public static void myInvokedMethod() {
        out.println("Метод myInvokedMethod был вызван.");
    }

    public static void myRegularMethod() {
        out.println("Метод myRegularMethod был вызван.");
    }
    
    public static void main(String[] args) throws Exception {
        
        //2.1
        out.println("2.1");
        Method[] methods = Main.class.getDeclaredMethods();// Получаем все методы класса
        for (Method method : methods) {//Проходимся по всем методам и проверяем наличие аннотации
            if (method.isAnnotationPresent(Invoke.class)) {
                out.println("Найдена аннотация @Invoke на методе: " + method.getName());
                 method.invoke(null); // вызов статического метода
            } else {
                out.println("Метод " + method.getName() + " не помечен аннотацией @Invoke");
            }
        }
        
        //2.2
        out.println("2.2");
        Class<?>[] classes = {MyClass.class, AnotherClass.class};//Создаем массив, в который поместили классы MyClass и AnotherClass
        for (Class<?> clazz : classes) {//Проходимся по всем классам и проверяем наличие аннотации
            if (clazz.isAnnotationPresent(Default.class)) {// Проверка аннотации @Default на классах
                Default annotation = clazz.getAnnotation(Default.class);//Получаем объект аннотации @Default для текущего класса.
                Class<?> defaultValue = annotation.value();//Получаем значение свойства value аннотации
                out.println("Найдена аннотация @Default на классе: " + clazz.getSimpleName());
                out.println("Значение свойства value: " + defaultValue.getName());
            } else {
                out.println("Класс " + clazz.getSimpleName() + " не помечен аннотацией @Default");
            }
        }

        // Проверка аннотации @Default на полях класса MyClass
        Class<?> myClass = MyClass.class;
        Field[] fields = myClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Default.class)) {
                Default annotation = field.getAnnotation(Default.class);
                Class<?> defaultValue = annotation.value();
                out.println("Найдена аннотация @Default на поле: " + field.getName());
                out.println("Значение свойства value: " + defaultValue.getName());
            } else {
                out.println("Поле " + field.getName() + " не помечен аннотацией @Default");
            }
        }
        
        //2.3
        out.println("2.3");
        Class<?> pointsClass = Points.class;
        if (pointsClass.isAnnotationPresent(ToString.class)) {//Проверка на аннотацию ToString
                ToString classAnnotation = pointsClass.getAnnotation(ToString.class);//Получаем аннотацию @ToString для класса Points
                String classValue = classAnnotation.value();//Получаем значение свойства value аннотации для класса
                out.println("Найдена аннотация @ToString на классе: " + pointsClass.getSimpleName());
                out.println("Значение свойства value для класса: " + classValue);
                if (classValue.equals("YES")) {// Если значение свойства value для класса"YES"
                    Method toStringMethod = pointsClass.getMethod("toString");//Получаем метод toString
                    Object instance = pointsClass.getDeclaredConstructor(String.class, int.class).newInstance("9mice", 87);//создает экземпляр класса 
                    out.println("Результат toString для класса: " + (String) toStringMethod.invoke(instance));
                 }
                Field[] fieldz = pointsClass.getDeclaredFields();
                for (Field field : fieldz) {
                   if (field.isAnnotationPresent(ToString.class)) {
                       ToString fieldAnnotation = field.getAnnotation(ToString.class);
                       String fieldValue = fieldAnnotation.value();
                       out.println("Найдена аннотация @ToString на поле: " + field.getName());
                       out.println("Значение свойства value для поля " + field.getName() + ": " + fieldValue);
                   }
                    else out.println("Поле " + field.getName() + " не помечено аннотацией @ToString");
                }
        } else out.println("Класс " + pointsClass.getSimpleName() + " не помечен аннотацией @ToString");
        
        //2.4
        out.println("2.4");
        Class<?> NormisClass = Normis.class;
        if (NormisClass.isAnnotationPresent(Validate.class)) {
            Validate annotation = NormisClass.getAnnotation(Validate.class);//Получаем объект аннотации @Validate
            Class<?>[] value = annotation.value();//Получаем значение свойства value аннотации
            out.println("Найдена аннотация @Validate на классе: " + NormisClass.getSimpleName());
            out.println("Значение свойства value: " + Arrays.toString(value));//преобразуем массив value в строковое представление для вывода.
        } else out.println("Класс " + NormisClass.getSimpleName() + " не помечен аннотацией @Validate");
        
        //2.5
        out.println("2.5");
        Class<?> NormalClass = Normal.class;
        if (NormalClass.isAnnotationPresent(Two.class)) {
            Two annotation = NormalClass.getAnnotation(Two.class);//Получаем объект аннотации @Two
            out.println("Найдена аннотация @Two на классе: " + NormalClass.getSimpleName());
            out.println("Значение свойства first: " + annotation.first());
            out.println("Значение свойства second: " + annotation.second());
        } else out.println("Класс " + NormalClass.getSimpleName() + " не помечен аннотацией @Two");
        
        //2.6
        out.println("2.6");
        if (NormalClass.isAnnotationPresent(Cache.class)) {
            Cache annotation = NormalClass.getAnnotation(Cache.class);//Получаем объект аннотации @Cache
            out.println("Найдена аннотация @Cache на классе: " + NormalClass.getSimpleName());
            out.println("Значение свойства value: " + Arrays.toString(annotation.value()));
        } else out.println("Класс " + NormalClass.getSimpleName() + " не помечен аннотацией @Cache");
    }
}
