package com.example.sercruitydemo;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Model：
 * Description：
 * Author: 赖允翔
 * created：2020/3/11 8:45
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //这里可以可以通过username（登录时输入的用户名）然后到数据库中找到对应的用户信息，并构建成我们自己的UserInfo来返回。
        //这里可以通过数据库来查找到实际的用户信息，这里我们先模拟下,后续我们用数据库来实现
        if(username.equals("admin")) {
            //假设返回的用户信息如下;
            User userInfo=new User();
            userInfo.setUsername("admin");
            userInfo.setPassword("123456");
            Role role = new Role(1L,"admin");
            List<Role> list = new ArrayList();
            list.add(role);
            userInfo.setRoles(list);
            return userInfo;
        }
        return null;
    }

}
