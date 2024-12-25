import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD}) // Аннотация может быть применена к типам и к полям
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время выполнения
public @interface ToString {
    String value() default "YES";//Значение свойства по умолчанию: YES

}
