package com.donggun.eplalarmi.redis.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class RedisSampleServiceTest {

    @Autowired
    RedisSampleService redisSampleService;

    @Test
    public void 레디스_키_받아오기() {
        // given
        String key1 = "test key1";
        String key2 = "test key2";
        String value1 = "test value1";
        String value2 = "test value2";
        redisSampleService.setRedisStringValue(key1, value1);
        redisSampleService.setRedisStringValue(key2, value2);

        // when
        String redisStringValue1 = redisSampleService.getRedisStringValue(key1);
        String redisStringValue2 = redisSampleService.getRedisStringValue(key2);

        // then
        assertThat(redisStringValue1).isEqualTo(value1);
        assertThat(redisStringValue2).isEqualTo(value2);
    }

    @Test
    public void 레디스_키_추가() {
        // given
        String key1 = "test key1";
        String key2 = "test key2";
        String value1 = "test value1";
        String value2 = "test value2";

        // when
        redisSampleService.setRedisStringValue(key1, value1);
        redisSampleService.setRedisStringValue(key2, value2);

        // then
        String redisStringValue1 = redisSampleService.getRedisStringValue(key1);
        String redisStringValue2 = redisSampleService.getRedisStringValue(key2);

        assertThat(redisStringValue1).isEqualTo(value1);
        assertThat(redisStringValue2).isEqualTo(value2);
    }

}
