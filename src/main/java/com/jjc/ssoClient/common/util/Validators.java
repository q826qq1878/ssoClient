/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: tradedb 
 * Author: dixingxing
 * Createdate: ����6:37:04
 * Version: 1.0
 *
 */

package com.jjc.ssoClient.common.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * <p>
 * ��<a href = "https://github.com/hibernate/hibernate-validator">hibernate validator</a> 
 * ��validator���м򵥷�װ����ʹ�á�
 * <a href="http://docs.jboss.org/hibernate/validator/4.0.1/reference/en/html_single/">�ٷ��ֲ�</a>
 * </p>
 * 
 * @project tradedb
 * @author dixingxing
 * @version 1.0
 * @date 2013-1-16 ����6:37:04
 */

public class Validators {
	private final static Validator validator;

	static {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * ������ĺϷ��ԡ���Ӧ {@link Validator#validate(Object, Class...)}
	 * 
	 * @author dixingxing
	 * @version 1.0
	 * @date 2013-1-16 ����7:13:32
	 * @param obj
	 * @param groups
	 * @return Set<ConstraintViolation<T>>
	 */
	public static <T> Set<ConstraintViolation<T>> validate(T obj, Class<?>... groups) {
		return validator.validate(obj, groups);
	}

}
