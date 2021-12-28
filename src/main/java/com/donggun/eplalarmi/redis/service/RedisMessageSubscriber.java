package com.donggun.eplalarmi.redis.service;

import com.donggun.eplalarmi.redis.dto.RedisDataDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RedisMessageSubscriber implements MessageListener {
    private static List<RedisDataDto> dataDtos = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onMessage(Message message, byte[] pattern) {

        try {
            RedisDataDto data = mapper.readValue(message.getBody(), RedisDataDto.class);
            dataDtos.add(data);
            log.info("Message received: " + message.toString());
            log.info("Total Message's size: " + dataDtos.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
