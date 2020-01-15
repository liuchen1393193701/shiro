package com.woniu;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class AppTest {

    @Test
    public void testHello() {
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
       SecurityManager securityManager= factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("test","000000");
        try {
            subject.login(token);
            if (subject.isAuthenticated()){
                System.out.println("登录成功");
                if(subject.hasRole("admin")){
                    System.out.println("拥有admin角色");
                }else{
                    System.out.println("不拥有admin角色");
                }
                if(subject.isPermitted("add")){
                    System.out.println("拥有增加的权限");
                }else{
                    System.out.println("不拥有增加的权限");
                }
                if(subject.isPermitted("delete")){
                    System.out.println("拥有删除的权限");
                }else{
                    System.out.println("拥有删除的权限");
                }
                if (subject.isPermittedAll("add","search")){
                    System.out.println("拥有add和search权限");
                }else {
                    System.out.println("不拥有add和search权限");
                }

            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登录失败");
        }
    }
}
