package cn.yet.bootcli;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class BootCliApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void testRedis() {
        redisTemplate.opsForValue().set("k1", "v1");
    }

    @Test
    void testMysql() {

    }

}
