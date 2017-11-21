package com.zandolsi.examples.ms.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

import static java.util.Objects.nonNull;

@SpringBootApplication
@EnableConfigServer
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        proxy();
    }

    private static void proxy() {
        Properties properties = System.getProperties();
        ProxyAuthentication passwordAuthentication = new ProxyAuthentication()
                .username(properties.getProperty("https.proxyUser"))
                .password(properties.getProperty("https.proxyPassword"));
        if (nonNull(passwordAuthentication.username()) && nonNull(passwordAuthentication.password())) {
            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(passwordAuthentication.username(), passwordAuthentication.password().toCharArray());
                }
            });
        }
    }

    public static class ProxyAuthentication {

        private String username;
        private String password;

        public String username() {
            return username;
        }

        public ProxyAuthentication username(String username) {
            this.username = username;
            return this;
        }

        public String password() {
            return password;
        }

        public ProxyAuthentication password(String password) {
            this.password = password;
            return this;
        }

        @Override
        public String toString() {
            return "PasswordAuthentication [username=" + username + ", password=" + password + "]";
        }

    }
}
