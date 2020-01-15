package com.woniu;

import static org.junit.Assert.assertTrue;

import com.woniu.realm.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testPro4()
    {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        SecurityUtils.setSecurityManager(securityManager);
        securityManager.setRealm(new MyRealm());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("jerry","0000");
        subject.login(token);
        boolean flag=subject.isAuthenticated();
        if(flag){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
        subject.checkRole("admin");
        subject.checkPermission("user:select");
    }
}
