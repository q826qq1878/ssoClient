package com.jjc.ssoClient.common.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ��Сд��֤��
 * 
 * @project transaction
 * @author dixingxing
 * @version 1.0
 * @date 2013-1-17 ����5:35:03
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

	private CaseMode caseMode;

	public void initialize(CheckCase constraintAnnotation) {
		this.caseMode = constraintAnnotation.value();
	}

	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
		if (object == null){
			return true;
		}

		if (caseMode == CaseMode.UPPER) {
			return object.equals(object.toUpperCase());
		}
		
		return object.equals(object.toLowerCase());
	}

}