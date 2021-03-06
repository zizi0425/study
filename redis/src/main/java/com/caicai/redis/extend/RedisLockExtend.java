package com.caicai.redis.extend;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: RedisLockExtend
 * @Package: com.caicai.redis.extend
 * @Description:
 * @author: yujie.wan
 * @date: 2021/1/29 9:39
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public interface RedisLockExtend {

    void execute();
}
