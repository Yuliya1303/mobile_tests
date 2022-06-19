package com.yuliya1303.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/device.properties")
public interface DeviceConfig extends Config {
        String device();
}
