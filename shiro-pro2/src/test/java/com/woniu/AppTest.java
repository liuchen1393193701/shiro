package com.woniu;

import static org.junit.Assert.assertTrue;

import com.woniu.realm.Myrealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void test1(){
        //创建SecurityManager对象
        DefaultSecurityManager securityManager= new DefaultSecurityManager();
        //创建一个认证器
        ModularRealmAuthenticator authenticator=new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        securityManager.setAuthenticator(authenticator);
        //创建授权对象
        ModularRealmAuthorizer authorizer=new ModularRealmAuthorizer();
        authorizer.setPermissionResolver(new WildcardPermissionResolver());
        securityManager.setAuthorizer(authorizer);
        //设置Realm
        securityManager.setRealm(new Myrealm());

        //通过SecurtyUtils设置SeucrityManager
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("giles","123456");
        try {
            subject.login(token);
            if(subject.isAuthenticated()){
                System.out.println("登陆成功！");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}
