package com.caicai.springboot.entity.validate;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: User
 * @Package: com.caicai.springboot.validate.entity
 * @Description:
 * @author: yujie.wan
 * @date: 2021/1/12 14:55
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Data
public class User {

    @NotNull(groups = UpdateValidate.class)
    private Long id;

    @NotBlank(groups = InsertValidate.class)
    private String name;

    @NotNull
    private Integer age;

    public interface InsertValidate extends Default {}
    public interface UpdateValidate extends Default{}

}
