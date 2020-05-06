package com.service;

import com.mapper.UserMapper;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loginUserByUsername(s);
        if(null == user){
            System.out.print("账户不存在！");
            throw new UsernameNotFoundException("账户不存在");
        }
        user.setRoles(userMapper.getUserRolesByUid(user.getId()));
        System.out.print("rolesLength:" + user.getRoles().size());
        return user;
    }

    public List<User> showAllUser(){
        return userMapper.showAllUser();
    }

    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

    public int deleteUser(int id){
        return userMapper.deleteUser(id);
    }

    public User selectById(int id){
        return userMapper.selectById(id);
    }
}
