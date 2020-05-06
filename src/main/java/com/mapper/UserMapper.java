package com.mapper;

import com.pojo.Role;
import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User loginUserByUsername(String username);
    List<Role> getUserRolesByUid (Integer id);
    List<User> showAllUser();
    int updateUser(User user);
    int deleteUser(int id);
    User selectById(int id);
}
