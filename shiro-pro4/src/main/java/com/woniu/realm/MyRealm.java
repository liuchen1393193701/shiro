package com.woniu.realm;

import com.woniu.service.IUserService;
import com.woniu.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    private IUserService ius;

    public MyRealm() {
        ius = new UserServiceImpl();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String passWord = ius.getPasswordByUserName(userName);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,passWord,getName());

        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       String userName = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roleNames = ius.getRolesByUserName(userName);
        Set<String> permissionNames = ius.getPermissionsByUserName(userName);
        info.addRoles(roleNames);
        info.setStringPermissions(permissionNames);
       return info;
    }

}
