import java.lang.annotation.*;

@Target(ElementType.TYPE)//Аннотация может быть применена к типам
@Retention(RetentionPolicy.RUNTIME)//Аннотация доступна во время выполнения
public @interface Two {
    String first();//обязательные свойства
    int second();  
}
