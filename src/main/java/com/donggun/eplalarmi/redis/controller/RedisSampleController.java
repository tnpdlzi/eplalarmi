package com.donggun.eplalarmi.redis.controller;

import com.donggun.eplalarmi.redis.dto.RedisDataDto;
import com.donggun.eplalarmi.redis.service.RedisSampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class RedisSampleController {
    private final RedisSampleService redisSampleService;

    @GetMapping("/api/v1/redis")
    public RedisDataDto getRedisItemAndSource(@RequestParam(name = "key") String key) {
        return redisSampleService.getRedisItemAndSource(key);
    }

    @PostMapping("/api/v1/redis")
    public String setRedisItemAndSource(@RequestBody String key, String item, String source) {
        redisSampleService.setRedisItemAndSource(key, item, source);
        return key;
    }
}
