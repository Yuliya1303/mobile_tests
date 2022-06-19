package com.yuliya1303.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/osVersion.properties")
public interface OsVersionConfig extends Config {
        String version();
}
