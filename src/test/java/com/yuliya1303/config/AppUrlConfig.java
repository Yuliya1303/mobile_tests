package com.yuliya1303.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/appUrl.properties")
public interface AppUrlConfig extends Config {
        String appUrl();
}
