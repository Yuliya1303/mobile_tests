package com.yuliya1303.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${launch}.properties")
public interface LaunchConfig extends Config {
        String device();
        String osVersion();
        String hostUrl();
}
