package com.donggun.eplalarmi.redis.service;

import com.donggun.eplalarmi.redis.dto.RedisDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RedisSampleService {
    private final RedisTemplate redisTemplate;

    public void setRedisStringValue(String key, String value) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    public String getRedisStringValue(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

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
