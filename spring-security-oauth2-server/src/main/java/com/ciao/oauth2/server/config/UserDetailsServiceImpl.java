package com.ciao.oauth2.server.config;

import com.ciao.oauth2.server.user.entity.PermissionEntity;
import com.ciao.oauth2.server.user.entity.UserEntity;
import com.ciao.oauth2.server.user.service.PermissionService;
import com.ciao.oauth2.server.user.service.UserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-boot-security-oauth2
 * @author: ciao
 * @description:
 * @create: 2019-08-19 18:31
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userService.queryByUsername(s);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
//        String username="";
//        String password="";
        if (userEntity != null) {
//            username = userEntity.getUsername();
//            password = userEntity.getPassword();
            // 获取用户授权
            List<PermissionEntity> permissionEntityList = permissionService.listPermissionByUserId(userEntity.getId());

            // 声明用户授权
            permissionEntityList.forEach(permissionEntity -> {
                if (permissionEntity != null && permissionEntity.getEnname() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permissionEntity.getEnname());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
        }
        // 由框架完成认证工作
        return new User(userEntity.getUsername(), userEntity.getPassword(), grantedAuthorities);

    }
}
