package com.waheed.cloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:database-${spring.profiles.active}.yml", ignoreResourceNotFound = true)
public class DatabaseConnection {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "DatabaseConnection{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
