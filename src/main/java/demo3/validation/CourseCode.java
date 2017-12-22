package demo3.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by maxa on 12/22/2017.
 */
@Constraint(validatedBy=CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    public String[] value() default {"LUV"};
    public String message() default "Must be start of course code";
}
