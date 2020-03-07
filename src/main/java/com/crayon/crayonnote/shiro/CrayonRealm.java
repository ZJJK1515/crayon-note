package com.crayon.crayonnote.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crayon.crayonnote.entity.SysUser;
import com.crayon.crayonnote.system.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Shiro 中核心的授权、认证功能，需要继承 AuthorizingRealm 类来实现
 */
public class CrayonRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 能进入这里说明用户已经通过验证了
//        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        for (SysRole role : userInfo.getRoles()) {
//            simpleAuthorizationInfo.addRole(role.getName());
//            for (SysPermission permission : role.getPermissions()) {
//                simpleAuthorizationInfo.addStringPermission(permission.getName());
//            }
//        }
        System.out.println("授权ing...");
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户输入的账户
        String username = (String) authenticationToken.getPrincipal();
        // 通过username从数据库中查找 UserInfo 对象
        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser userInfo = userService.getOne(new QueryWrapper<SysUser>().eq("username", username));
        if (null == userInfo) {
            return null;
        }

        return new SimpleAuthenticationInfo(
                userInfo, // 用户名
                userInfo.getPassword(), // 密码
                ByteSource.Util.bytes(userInfo.getSalt()), // salt=username+salt
                getName() // realm name
        );
    }

    public static void main(String[] args) {
        //加密方式
        String hashAlgorithmName = "MD5";
        //盐：为了即使相同的密码不同的盐加密后的结果也不同
        ByteSource byteSalt = ByteSource.Util.bytes("UUID-UUID-UUID-UUID");
        //密码
        Object source = "crayon";
        //加密次数
        int hashIterations = 2;
        SimpleHash result = new SimpleHash(hashAlgorithmName, source, byteSalt, hashIterations);
        System.out.println(result);
    }
}
