package com.caicai.springboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: PropertiesConfig
 * @Package: com.caicai.springboot.config
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/3 19:20
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Data
public class PropertiesConfig {
    private Set<String> partnerIds;
}
