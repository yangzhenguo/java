package com.yangzg.config;

import com.mongodb.client.MongoCollection;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Sam on 2019/6/24.
 */
@Configuration
public class ShiroConfig {
    @Value("#{mongoClient?.getDatabase('shop')?.getCollection('users')}")
    private Optional<MongoCollection> usersCollection;

    @Bean
    public Realm realm() {
        return new IniRealm("classpath:shiro.ini");
    }

    @Bean
    public Realm myRealm(CredentialsMatcher credentialsMatcher) {
        MyJdbcRealm myJdbcRealm = new MyJdbcRealm();
        myJdbcRealm.setCredentialsMatcher(credentialsMatcher);
        return myJdbcRealm;
    }

    @Bean
    public CredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("Md5");
        credentialsMatcher.setHashIterations(1024);
        return credentialsMatcher;
    }

    /*
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/**", "anon");
        return chainDefinition;
    }
    */

    @Bean
    public CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        // 安全管理器
        shiroFilter.setSecurityManager(securityManager);
        //默认的登陆访问url
        shiroFilter.setLoginUrl("/login");
        //登陆成功后跳转的url
        shiroFilter.setSuccessUrl("/index");
        //没有权限跳转的url
        shiroFilter.setUnauthorizedUrl("/unauth");

        //自定义Filter
//  Map<String, Filter> filters = new LinkedHashMap<>();
//  filters.put("simpleFilter", SimpleFilter());
//  shiroFilter.setFilters(filters);

        //
         // 配置shiro过滤器链，从前往后验证
         // 1、anon  不需要认证
         // 2、authc 需要认证
         // 3、user  验证通过或RememberMe登录的都可以
         // 当应用开启了rememberMe时,用户下次访问时可以是一个user,
         // 但不会是authc,因为authc是需要重新认证的
         // 顺序从上到下,优先级依次降低
         //
        //配置单个filter
//  shiroFilter.setFilterChainDefinitions("/test = authc");

        //要用LinkedHashMap，因为filter必须是有序的
        Map<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("/doLogin", "anon");
        hashMap.put("/captcha.jpg", "anon");
        hashMap.put("/commons/**", "anon");
        hashMap.put("/static/**", "anon");
        hashMap.put("/assets/**", "anon");
        hashMap.put("/login", "anon");//登录不做权限拦截
        hashMap.put("/logout", "logout");
        hashMap.put("/home/array", "roles[admin]");
        hashMap.put("/home/files", "roles[user]");
        hashMap.put("/**", "authc");//全都做权限拦截
        shiroFilter.setFilterChainDefinitionMap(hashMap);
        return shiroFilter;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(Realm myRealm, CacheManager cacheManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //配置realm
        securityManager.setRealm(myRealm);
        securityManager.setCacheManager(cacheManager);
//        ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
//        modularRealmAuthenticator.setRealms(Collections.singleton(myRealm));
//        securityManager.setAuthenticator(modularRealmAuthenticator);
        securityManager.setAuthorizer(new ModularRealmAuthorizer(Collections.singleton(myRealm)));
        return securityManager;
    }

    class MyJdbcRealm extends AuthorizingRealm {

        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
            UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
            final SimpleAuthenticationInfo[] info = {null};
            usersCollection.ifPresent(collection -> {
                Document query = new Document("username", token.getUsername());
                List<Document> users = (List<Document>) StreamSupport.stream(collection.find(query).limit(1).spliterator(), false).collect(Collectors.toList());
                if (!users.isEmpty()) {
                    Document document = users.get(0);
                    info[0] = new SimpleAuthenticationInfo(document.getString("username"), document.getString("password"), getName());
                } else {
                    throw new AuthenticationException();
                }
            });
            return info[0];
        }

        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
            String username = (String)principalCollection.getPrimaryPrincipal();
            final SimpleAuthorizationInfo[] info = {null};
            usersCollection.ifPresent(collection -> {
                Document query = new Document("username", username);
                List<Document> users = (List<Document>) StreamSupport.stream(collection.find(query).limit(1).spliterator(), false).collect(Collectors.toList());
                if (!users.isEmpty()) {
                    Document document = users.get(0);
                    info[0] = new SimpleAuthorizationInfo(new HashSet<String>(){
                        private static final long serialVersionUID = 8202879812754743208L;
                        {
                            String roles = document.getString("roles");
                            if (!StringUtils.isEmpty(roles)) {
                                addAll(Arrays.stream(roles.split(",")).collect(Collectors.toSet()));
                            }
                        }
                    });
                } else {
                    throw new AuthorizationException();
                }
            });
            return info[0];
        }
    }

    public static void main(String[] args) {
        SimpleHash sh = new SimpleHash("Md5", "test", null, 1024);
        System.out.println(sh.toHex());
        System.out.println(sh.toBase64());
        System.out.println(sh.toString());
    }
}
