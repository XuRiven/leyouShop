package xuriven.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuriven.service.mapper.UserMapper;
import xuriven.service.pojo.User;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

}
