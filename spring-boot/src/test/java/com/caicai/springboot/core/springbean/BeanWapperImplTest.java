package com.caicai.springboot.core.springbean;

import com.caicai.springboot.entity.wapper.Car;
import com.caicai.springboot.entity.wapper.Driver;
import com.caicai.springboot.entity.wapper.Wheel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: BeanWapperImplTest
 * @Package: com.caicai.springboot.core.springbean
 * @Description:
 * @author: yujie.wan
 * @date: 2021/1/18 17:52
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class BeanWapperImplTest {

    @Test
    public void test(){
        Wheel wheel = new Wheel();
        BeanWrapper leftWheel = PropertyAccessorFactory.forBeanPropertyAccess(wheel);
        PropertyValue propertyValue = new PropertyValue("position", "左边");
        leftWheel.setPropertyValue(propertyValue);
        System.out.println("leftWheel = " + leftWheel.getWrappedInstance());

        //左边轮子的BeanWrapper
        Wheel rightWheel = new Wheel();
        BeanWrapper beanWrapperOfRightWheel = PropertyAccessorFactory.forBeanPropertyAccess(rightWheel);
        PropertyValue rightPosition = new PropertyValue("position", "右边");
        beanWrapperOfRightWheel.setPropertyValue(rightPosition);
        System.out.println(beanWrapperOfRightWheel.getWrappedInstance());

        // 驾驶员
        Driver driver = new Driver();
        BeanWrapper beanWrapperOfDriver = PropertyAccessorFactory.forBeanPropertyAccess(driver);
        PropertyValue age = new PropertyValue("age", 20);
        beanWrapperOfDriver.setPropertyValue(age);
        System.out.println(beanWrapperOfDriver.getWrappedInstance());


        // 车子
        Car car = new Car();
        BeanWrapper beanWrapperOfCar = PropertyAccessorFactory.forBeanPropertyAccess(car);
        beanWrapperOfCar.setPropertyValue("name", "奔驰"); // 车名
        Wheel[] wheels = {wheel, rightWheel}; //轮子数组
        beanWrapperOfCar.setPropertyValue("wheels", wheels); //轮子
        beanWrapperOfCar.setPropertyValue("driver", driver); //驾驶员
        System.out.println(beanWrapperOfCar.getWrappedInstance());

        // 获取驾驶员的年龄
        int retrievedAge = (Integer) beanWrapperOfCar.getPropertyValue("driver.age");
        System.out.println("driver age : " + retrievedAge);


        // 通过表达式间接设置car的wheel的width
        beanWrapperOfCar.setPropertyValue("wheels[0].position", "修改过的左边");
        System.out.println(beanWrapperOfCar.getWrappedInstance());

    }


}
