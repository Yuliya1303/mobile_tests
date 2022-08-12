package com.wikipedia.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${deviceHost}.properties")
public interface DeviceHostConfig extends Config {
        String device();
        String osVersion();
        String hostUrl();
}
