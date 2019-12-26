package xuriven.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xuriven.service.pojo.User;

@FeignClient(value = "service-provider",fallback = UserClientFallback.class)
public interface UserClient {
    @GetMapping("user")
    public User queryUserById(@RequestParam("id") Long id);
}
