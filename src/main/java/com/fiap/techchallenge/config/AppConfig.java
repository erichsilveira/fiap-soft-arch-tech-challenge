package com.fiap.techchallenge.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Component
@ConfigurationProperties(prefix = "app")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.deere.r3.phoenix.customeruser.repository.aurora")
public class AppConfig {

}
