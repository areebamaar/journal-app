package net.areebamaar.journalApp.ServiceTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisServiceTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Disabled
    @Test
    public void get(){
        redisTemplate.opsForValue().set("email","areebamaar01@gmail.com");

       Object email= redisTemplate.opsForValue().get("email");

       int a=1;
    }
}
