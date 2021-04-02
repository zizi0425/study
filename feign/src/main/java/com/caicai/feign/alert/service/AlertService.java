package com.caicai.feign.alert.service;

import com.caicai.feign.alert.datamanager.AlertDataManager;
import com.caicai.feign.alert.entity.AlertMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: AlertService
 * @Package: com.caicai.feign.alert
 * @Description:
 * @author: yujie.wan
 * @date: 2021/4/1 10:34
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Service
public class AlertService {

    @Autowired
    Collection<AlertDataManager> alertDataManagers;

    public void alert(AlertMessage alertMessage) throws JsonProcessingException {
        for (AlertDataManager alertDataManager : alertDataManagers) {
            alertDataManager.alert(alertMessage);
        }
    }


}
