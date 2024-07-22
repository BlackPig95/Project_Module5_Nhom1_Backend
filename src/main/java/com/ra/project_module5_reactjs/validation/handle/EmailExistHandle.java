package com.ra.project_module5_reactjs.validation.handle;


import com.ra.project_module5_reactjs.repository.IUserRepository;
import com.ra.project_module5_reactjs.validation.annotation.EmailExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailExistHandle implements ConstraintValidator<EmailExist,String> {
	private final IUserRepository IUserRepository;
	
	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
		return !IUserRepository.existsByEmail(s);
	}
}
