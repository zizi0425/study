package com.caicai.feign.alert.datamanager;

import com.caicai.feign.alert.client.WechatAlertClient;
import com.caicai.feign.alert.entity.AlertMessage;
import com.caicai.feign.alert.entity.WeChatWorkResponse;
import com.caicai.feign.alert.entity.WechatWorkAlertMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;


/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: WchatAlertDataMager
 * @Package: com.caicai.feign.alert.datamanager
 * @Description:
 * @author: yujie.wan
 * @date: 2021/4/1 10:35
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class WechatWorkAlertDataMager implements AlertDataManager {

    static final String content = " ## <font color=\"warning\">**告警通知**</font> \n " +
            "> 服务: {0} \n" +
            "> tid:  <font color='info'>{1}</font> \n" +
            "> 异常类型 :<font color=\"comment\">{2}</font> \n" +
            "> 异常描述 :<font color=\"comment\">{3}</font> \n " +
            "> 前 {5} 行堆栈信息:<font color=\"comment\"> {4} </font>";


    String key = "e9674b96-d5e7-4a21-a1bb-ceec24794b6b";

    @Autowired
    WechatAlertClient wechatAlertClient;

    @Override
    public void alert(AlertMessage alertMessage) throws JsonProcessingException {
        WechatWorkAlertMessage wechatWorkAlertMessage = convert(alertMessage);
        WeChatWorkResponse alert = wechatAlertClient.alert(key, wechatWorkAlertMessage);
        System.out.println("alert = " + alert);
    }


    private WechatWorkAlertMessage convert(AlertMessage alertMessage) throws JsonProcessingException {
        WechatWorkAlertMessage.MarkDown markDown = new WechatWorkAlertMessage.MarkDown();

        String format = MessageFormat.format(content,
                alertMessage.getAppName(),
                alertMessage.getTrackingNo(),
                alertMessage.getThrowable().getClass().getName(),
                alertMessage.getThrowable().getMessage(),
                stack(alertMessage.getThrowable()),
                4);

        markDown.setContent(format);

        WechatWorkAlertMessage wechatWorkAlertMessage = new WechatWorkAlertMessage();
        wechatWorkAlertMessage.setMarkDown(markDown);
        wechatWorkAlertMessage.setMsgType("markdown");
        return wechatWorkAlertMessage;
    }

    public String stack(Throwable throwable) {
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringBuilder.append(stackTraceElement.toString())
                    .append("\n\r");
            i++;
            if (i >= 4) {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
