package com.example.Controller;

import com.alibaba.fastjson.JSON;
import com.example.mqtt.AjaxResult;
import com.example.mqtt.MqttPushClient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName: index
 * @Description:
 * @Author: Administrator
 * @Date: 2023年01月07日 12:02
 * @Version: 1.0
 **/
@RestController
public class index {
    @Resource
    @Qualifier("mqttPushClient")
    MqttPushClient client;

    @RequestMapping("/mqtt")
    AjaxResult contextLoads(@RequestBody Map<String, Object> map) {
        AjaxResult ard = client.publish(0, true, "ard", JSON.toJSONString(map));
        return ard;
    }
}
