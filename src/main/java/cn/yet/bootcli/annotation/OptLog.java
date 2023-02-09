package cn.yet.bootcli.annotation;

import java.lang.annotation.*;

/**
 * @Author Ekko
 * @Date 2023/2/9
 * @Description OptLog
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptLog {

    String optModule() default "";

    String optType() default "";

    String optDesc() default "";
}
