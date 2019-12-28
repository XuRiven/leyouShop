package xuriven.service.client;

import org.springframework.stereotype.Component;
import xuriven.service.pojo.User;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setUsername("服务器正忙，请稍后访问!");
        return user;
    }
}
