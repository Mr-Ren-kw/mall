package com.j4h.mall.shiro;

import com.j4h.mall.mapper.system.AdminMapper;
import com.j4h.mall.model.admin.Admin;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    AdminMapper adminMapper;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        String passwordFromDb = adminMapper.getPasswordByUsername(principal);
        if(passwordFromDb == null) {
            passwordFromDb = "";
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, passwordFromDb, this.getName());
        return authenticationInfo;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Admin admin = adminMapper.getRoleIdsByUsername(primaryPrincipal);
        int[] roleIds = admin.getRoleIds();
        List<String> permissions = adminMapper.getPermissionByRoleIds(roleIds);
        authorizationInfo.addStringPermissions(permissions);
        List<String> role = adminMapper.getRolesByIds(roleIds);
        authorizationInfo.addRoles(role);
        return authorizationInfo;
    }

}
