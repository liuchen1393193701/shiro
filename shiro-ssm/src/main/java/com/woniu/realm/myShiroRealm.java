package com.woniu.realm;

import com.woniu.pojo.User;
import com.woniu.service.MenuService;
import com.woniu.service.UserService;
import com.woniu.utils.Contants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


public class myShiroRealm extends AuthorizingRealm {
   @Autowired
   private UserService userService;
   @Autowired
   private MenuService menuService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("*************授权的时候调用********************");
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User sessionUser =(User)session.getAttribute(Contants.SESSION_USER);
        Set<String> promssionList = menuService.getUrlByUserName(sessionUser.getUserName());
        Set<String> all = new HashSet<String>();

        if (promssionList!=null&&!promssionList.isEmpty()){
            for (String url:promssionList){
                if (url.indexOf("/")!=-1){
                    url= url.substring(0,url.lastIndexOf("/"));
                    all.add(url+":*");
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(all);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("*************认证的时候调用********************");
        String userName=(String)authenticationToken.getPrincipal();
        User user=userService.getUserByUserName(userName);
        return new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
    }
}
