import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD}) // Аннотация может быть применена к типам и к полям
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время выполнения
public @interface Default {
    Class<?> value(); // Обязательное свойство value типа Class
}
