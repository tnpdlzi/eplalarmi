package com.donggun.eplalarmi.redis.service;

import com.donggun.eplalarmi.redis.dto.RedisDataDto;
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

    @Test
    public void 레디스_아이템_소스_추가_가져오기() {
        // given
        String key1 = "test key1";
        String key2 = "test key2";
        String item1 = "test item1";
        String item2 = "test item2";
        String source1 = "test source1";
        String source2 = "test source2";

        // when
        redisSampleService.setRedisItemAndSource(key1, item1, source1);
        redisSampleService.setRedisItemAndSource(key2, item2, source2);

        // then
        RedisDataDto redisItemAndSource1 = redisSampleService.getRedisItemAndSource(key1);
        RedisDataDto redisItemAndSource2 = redisSampleService.getRedisItemAndSource(key2);

        assertThat(redisItemAndSource1.getItemId()).isEqualTo(item1);
        assertThat(redisItemAndSource1.getSourceId()).isEqualTo(source1);
        assertThat(redisItemAndSource2.getItemId()).isEqualTo(item2);
        assertThat(redisItemAndSource2.getSourceId()).isEqualTo(source2);
    }
}
