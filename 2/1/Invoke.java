import java.lang.annotation.*;

@Target(ElementType.METHOD) // Аннотация может быть применена только к методам
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время выполнения
public @interface Invoke {// Аннотация не имеет никаких свойств
}
    
