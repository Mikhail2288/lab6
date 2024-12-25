import java.lang.annotation.*;

@Target(ElementType.TYPE)//Аннотация может быть применена к типам
@Retention(RetentionPolicy.RUNTIME)//Аннотация доступна во время выполнения
public @interface Cache {
    String[] value() default {};//Необязательное свойство value типа String[], по умолчанию - пустой массив
}
