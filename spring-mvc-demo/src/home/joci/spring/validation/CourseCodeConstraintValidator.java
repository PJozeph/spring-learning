package home.joci.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(CourseCode constraintAnnotation) {
		coursePrefix = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
		boolean result = false;
		if (input != null) {
			result = input.startsWith(coursePrefix);
		} else {
			return true;
		}
		return result;
	}

}
