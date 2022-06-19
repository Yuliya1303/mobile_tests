package com.yuliya1303.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/selenoidCredentials.properties")
public interface SelenoidCredentialsConfig extends Config {
        String login();
        String password();
}
