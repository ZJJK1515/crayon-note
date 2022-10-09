package com.crayon.redis.util;

import com.crayon.redis.CrayonRedisApplication;
import com.crayon.redis.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CrayonRedisApplication.class)
public class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testSet() {
//        redisUtil.testSet(RedisUtil.User.class);
    }

}
