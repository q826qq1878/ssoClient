
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: transaction 
 * Author: dixingxing
 * Createdate: ����4:50:49
 * Version: 1.0
 *
 */

package com.jjc.ssoClient.common.constraints;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * ����Сд��ע��
 * @project transaction
 * @author dixingxing
 * @version 1.0
 * @date 2013-1-17 ����4:50:49
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckCaseValidator.class)
@Documented
public @interface CheckCase {

    String message() default "{com.hc360.common.constraints.checkcase}";

    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

    CaseMode value();

}
