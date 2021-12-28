package com.donggun.eplalarmi.redis.service;

import com.donggun.eplalarmi.redis.dto.RedisDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RedisMessagePublisher {

    private final RedisTemplate redisTemplate;

    public void sendMessage(String message) {
        redisTemplate.convertAndSend("Event", message);
    }

    public void sendDtoMessage(String teamName, String source, String item) {
        RedisDataDto dataDto = new RedisDataDto();
        dataDto.setSourceId(source);
        dataDto.setItemId(item);
        redisTemplate.convertAndSend(teamName, dataDto);
    }
}
