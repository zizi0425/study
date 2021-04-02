package com.caicai.feign.alert.datamanager;

import com.caicai.feign.alert.entity.AlertMessage;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AlertDataManager {

    void alert(AlertMessage alertMessage) throws JsonProcessingException;
}
