package com.ra.project_module5_reactjs.validation.handle;


import com.ra.project_module5_reactjs.repository.UserRepository;
import com.ra.project_module5_reactjs.validation.annotation.EmailExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailExistHandle implements ConstraintValidator<EmailExist,String> {
	private final UserRepository userRepository;
	
	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
		return !userRepository.existsByEmail(s);
	}
}
