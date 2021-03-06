package com.caicai.retry;

import com.caicai.retry.service.AnnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: AnnoTest
 * @Package: com.caicai.retry
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/3 17:01
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class AnnoTest extends RetryApplicationTests {

    @Autowired
    private AnnoService annoService;

    @Test
    public void test1() {
        annoService.retry();
    }

}
