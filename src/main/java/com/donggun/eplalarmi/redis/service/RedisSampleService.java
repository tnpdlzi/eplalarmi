package com.donggun.eplalarmi.redis.service;

import com.donggun.eplalarmi.redis.dto.RedisDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RedisSampleService {
    private final RedisTemplate redisTemplate;

    public void setRedisItemAndSource(String key, String item, String source) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        RedisDataDto redisDataDto = new RedisDataDto();
        redisDataDto.setItemId(item);
        redisDataDto.setSourceId(source);
        valueOperations.set(key, redisDataDto);
    }

    public RedisDataDto getRedisItemAndSource(String key) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        return (RedisDataDto) valueOperations.get(key);
    }

}
