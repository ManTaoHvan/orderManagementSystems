package com.hmttest.springboot.mapper;

import com.hmttest.springboot.entities.Provider;
import com.hmttest.springboot.entities.User;

import java.util.List;

/**
 * @Auther: HMT
 */
//@Mapper 或 @MapperScan("com.hmttest.springboot.mapper")
public interface UserMapper {

    User getUserByUsername(String username);

    List<User> getUsers(User user);

    User getUserById(Integer id);

    int addUser(User user);

    int deleteUserById(Integer id);

    int updateUser(User user);

}
