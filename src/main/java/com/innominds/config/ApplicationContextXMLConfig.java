package com.innominds.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import com.innominds.service.AccountService;
import com.innominds.service.BankService;
import com.innominds.service.internal.AccountServiceImpl;
import com.innominds.service.internal.BankServiceImpl;

/**
 *
 * It demonstrates how session scope bean gets injected into singleton bean.<br>
 * if accountService is having interface it uses JDKAutoProxy to create proxy and injects into singleton bean.<br>
 * if accountService is concrete class then it uses CGLIB (use ScopedProxyMode.TARGET_CLASS)
 *
 */
@Configuration
public class ApplicationContextXMLConfig {

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
    AccountService accountService() {
        return new AccountServiceImpl();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    BankService bankService() {
        return new BankServiceImpl();
    }

}
