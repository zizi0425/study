package com.caicai.feign.alert.entity;

import lombok.Data;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: WechatWorkResponse
 * @Package: com.caicai.feign.alert.entity
 * @Description:
 * @author: yujie.wan
 * @date: 2021/4/1 10:42
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Data
public class WeChatWorkResponse {
    private String errcode;

    private String errmsg;
}
