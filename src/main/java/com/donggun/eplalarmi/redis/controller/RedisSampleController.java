package com.donggun.eplalarmi.redis.controller;

import com.donggun.eplalarmi.redis.dto.RedisTestClass;
import com.donggun.eplalarmi.redis.service.RedisSampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class RedisSampleController {
    private final RedisSampleService redisSampleService;

    @GetMapping("/api/v1/redis")
    public String getRedisStringValue(@RequestParam(name = "key") String key) {
        System.out.println("key = " + key);
        return redisSampleService.getRedisStringValue(key);
    }

    @PostMapping("/api/v1/redis")
    public String setRedisStringValue(@RequestBody RedisTestClass redisTestClass) {
        redisSampleService.setRedisStringValue(redisTestClass.getKey(), redisTestClass.getValue());
        return redisTestClass.getKey();
    }
}
