package com.wikipedia.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/browserstackCredentials.properties")
public interface BrowserstackCredentialsConfig extends Config {
        String user();
        String key();
}
