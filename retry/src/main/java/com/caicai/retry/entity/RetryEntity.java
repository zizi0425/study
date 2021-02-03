package com.caicai.retry.entity;

import lombok.Data;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: RetryEntity
 * @Package: com.caicai.retry.entity
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/3 10:35
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Data
public class RetryEntity<T> {

    private String url;

    private T t;
}
