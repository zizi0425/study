package com.caicai.springboot;

import com.caicai.springboot.config.PropertiesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        Binder binder = Binder.get(run.getEnvironment());
        PropertiesConfig test = binder.bind("test", Bindable.of(PropertiesConfig.class)).get();
        System.out.println("test.getPartnerIds() = " + test.getPartnerIds());
    }


}
