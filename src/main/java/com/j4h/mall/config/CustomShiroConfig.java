package com.j4h.mall.config;


import com.j4h.mall.shiro.AdminRealm;
import com.j4h.mall.shiro.CustomRealmAuthenticator;
import com.j4h.mall.shiro.WxRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

@Configuration
public class CustomShiroConfig {

    /*shiroFilter*/
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //如果访问url没有通过认证，会重定向到loginUrl
        shiroFilterFactoryBean.setLoginUrl("/");
        //安全控制器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器配置
        //请求的url
        //anon匿名的
        //authc认证
        //perms权限
        HashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/admin/auth/login","anon");
//        filterChainDefinitionMap.put("/admin/auth/info","anon");
//        filterChainDefinitionMap.put("/fail","anon");
        filterChainDefinitionMap.put("/jpg/**","anon");
        filterChainDefinitionMap.put("/admin/**","authc");
        //filterChainDefinitionMap.put("/admin/logout","logout");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("adminRealm") AdminRealm adminRealm,
                                                     @Qualifier("wxRealm") WxRealm wxRealm,
                                                     CustomRealmAuthenticator authenticator,
                                                     CustomSessionManager customSessionManager) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        ArrayList<Realm> realms = new ArrayList<>();
        realms.add(adminRealm);
        realms.add(wxRealm);
        defaultWebSecurityManager.setRealms(realms);
        defaultWebSecurityManager.setAuthenticator(authenticator);
        defaultWebSecurityManager.setSessionManager(customSessionManager);
        return defaultWebSecurityManager;
    }

    @Bean
    public DefaultWebSessionManager sessionManager() {
        CustomSessionManager customSessionManager = new CustomSessionManager();
//        customSessionManager.setSessionIdUrlRewritingEnabled(false);
//        customSessionManager.setSessionValidationSchedulerEnabled(true);
        return customSessionManager;
    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("org.apache.shiro.authz.AuthorizationException","/admin/auth/login");
        simpleMappingExceptionResolver.setExceptionMappings(mappings);
        return simpleMappingExceptionResolver;
    }

    @Bean
    public CustomRealmAuthenticator customRealmAuthenticator(@Qualifier("adminRealm") AdminRealm adminRealm,
                                                             @Qualifier("wxRealm") WxRealm wxRealm){
        CustomRealmAuthenticator customRealmAuthenticator = new CustomRealmAuthenticator();
        ArrayList<Realm> realms = new ArrayList<>();
        realms.add(adminRealm);
        realms.add(wxRealm);
        customRealmAuthenticator.setRealms(realms);
        return customRealmAuthenticator;
    }
}
