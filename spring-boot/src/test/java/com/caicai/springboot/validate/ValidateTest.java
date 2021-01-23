package com.caicai.springboot.validate;

import com.caicai.springboot.entity.validate.User;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ValidateTest
 * @Package: com.caicai.springboot.validate
 * @Description:
 * @author: yujie.wan
 * @date: 2021/1/12 17:45
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class ValidateTest {

    @Test
    public void validateGroup() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        User user = new User();
        Set<ConstraintViolation<User>> validate = validator.validate(user, User.UpdateValidate.class);
        System.out.println("validate = " + validate);
    }
}
