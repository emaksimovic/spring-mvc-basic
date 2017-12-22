package demo3.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by maxa on 12/22/2017.
 */
public class CourseCodeConstraintValidator implements ConstraintValidator <CourseCode, String>{
    private String[] coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Boolean result = false;
        if(value != null) {
            int i = 0;
            while(!result && coursePrefix[i] != null) {
                result = value.startsWith(coursePrefix[i]);
            }
        } else {
            result = false;
        }
        return result;
    }
}
