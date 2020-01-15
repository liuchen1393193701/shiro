package com.woniu.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class Myrealm implements Realm {
    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        if(!"giles".equals(userName)){
            throw new UnknownAccountException("没有该账户！");
        }
        if(!"123456".equals(password)){
            throw new IncorrectCredentialsException("密码有误！");
        }
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(userName,password,getName());
        return info;

    }
}
