package com.donggun.eplalarmi.common.config;

import com.donggun.eplalarmi.common.domain.EnglandPremierLeagueTeams;
import com.donggun.eplalarmi.redis.dto.RedisDataDto;
import com.donggun.eplalarmi.redis.service.RedisMessageSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
        return lettuceConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> stringValueRedisTemplate() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDataDto.class));
        return redisTemplate;
    }
//
//    @Bean
//    MessageListenerAdapter messageListenerAdapter() {
//        return new MessageListenerAdapter(new RedisPubSubService());
//    }

    @Bean
    RedisMessageListenerContainer redisContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory());
        container.addMessageListener(messageDtoListener(), topic());
        container.addMessageListener(messageDtoListener(), manCity());
        container.addMessageListener(messageDtoListener(), liverpool());
        container.addMessageListener(messageDtoListener(), chelsea());
        container.addMessageListener(messageDtoListener(), arsenal());
        container.addMessageListener(messageDtoListener(), tottenham());
        container.addMessageListener(messageDtoListener(), westHam());
        container.addMessageListener(messageDtoListener(), manUtd());
        container.addMessageListener(messageDtoListener(), wolves());
        container.addMessageListener(messageDtoListener(), brighton());
        container.addMessageListener(messageDtoListener(), leicester());
        container.addMessageListener(messageDtoListener(), astonVilla());
        container.addMessageListener(messageDtoListener(), crystalPalace());
        container.addMessageListener(messageDtoListener(), brentford());
        container.addMessageListener(messageDtoListener(), southampton());
        container.addMessageListener(messageDtoListener(), everton());
        container.addMessageListener(messageDtoListener(), leeds());
        container.addMessageListener(messageDtoListener(), watford());
        container.addMessageListener(messageDtoListener(), burnley());
        container.addMessageListener(messageDtoListener(), newcastle());
        container.addMessageListener(messageDtoListener(), norwich());
        return container;
    }

    @Bean
    MessageListenerAdapter messageDtoListener() {
        return new MessageListenerAdapter(new RedisMessageSubscriber());
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("Event");
    }

    @Bean
    ChannelTopic manCity() {
        return new ChannelTopic(EnglandPremierLeagueTeams.MANCITY.getTeamAbbr());
    }

    @Bean
    ChannelTopic liverpool() {
        return new ChannelTopic(EnglandPremierLeagueTeams.LIVERPOOL.getTeamAbbr());
    }

    @Bean
    ChannelTopic chelsea() {
        return new ChannelTopic(EnglandPremierLeagueTeams.CHELSEA.getTeamAbbr());
    }

    @Bean
    ChannelTopic arsenal() {
        return new ChannelTopic(EnglandPremierLeagueTeams.ARSENAL.getTeamAbbr());
    }

    @Bean
    ChannelTopic tottenham() {
        return new ChannelTopic(EnglandPremierLeagueTeams.TOTTENHAM.getTeamAbbr());
    }

    @Bean
    ChannelTopic westHam() {
        return new ChannelTopic(EnglandPremierLeagueTeams.WESTHAM.getTeamAbbr());
    }

    @Bean
    ChannelTopic manUtd() {
        return new ChannelTopic(EnglandPremierLeagueTeams.MANUTD.getTeamAbbr());
    }

    @Bean
    ChannelTopic wolves() {
        return new ChannelTopic(EnglandPremierLeagueTeams.WOLVES.getTeamAbbr());
    }

    @Bean
    ChannelTopic brighton() {
        return new ChannelTopic(EnglandPremierLeagueTeams.BRIGHTON.getTeamAbbr());
    }

    @Bean
    ChannelTopic leicester() {
        return new ChannelTopic(EnglandPremierLeagueTeams.LEICESTER.getTeamAbbr());
    }

    @Bean
    ChannelTopic astonVilla() {
        return new ChannelTopic(EnglandPremierLeagueTeams.ASTONVILLA.getTeamAbbr());
    }

    @Bean
    ChannelTopic crystalPalace() {
        return new ChannelTopic(EnglandPremierLeagueTeams.CRYSTALPALACE.getTeamAbbr());
    }

    @Bean
    ChannelTopic brentford() {
        return new ChannelTopic(EnglandPremierLeagueTeams.BRENTFORD.getTeamAbbr());
    }

    @Bean
    ChannelTopic southampton() {
        return new ChannelTopic(EnglandPremierLeagueTeams.SOUTHAMPTON.getTeamAbbr());
    }

    @Bean
    ChannelTopic everton() {
        return new ChannelTopic(EnglandPremierLeagueTeams.EVERTON.getTeamAbbr());
    }

    @Bean
    ChannelTopic watford() {
        return new ChannelTopic(EnglandPremierLeagueTeams.WATFORD.getTeamAbbr());
    }

    @Bean
    ChannelTopic burnley() {
        return new ChannelTopic(EnglandPremierLeagueTeams.BURNLEY.getTeamAbbr());
    }

    @Bean
    ChannelTopic newcastle() {
        return new ChannelTopic(EnglandPremierLeagueTeams.NEWCASTLE.getTeamAbbr());
    }

    @Bean
    ChannelTopic norwich() {
        return new ChannelTopic(EnglandPremierLeagueTeams.NORWICH.getTeamAbbr());
    }

    @Bean
    ChannelTopic leeds() {
        return new ChannelTopic(EnglandPremierLeagueTeams.LEEDS.getTeamAbbr());
    }

}
