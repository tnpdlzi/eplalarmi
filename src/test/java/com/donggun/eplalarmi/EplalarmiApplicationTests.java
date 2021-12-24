package com.donggun.eplalarmi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class EplalarmiApplicationTests {

	@Autowired
	RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void redisConnectionTest() {
		final String key = "donggun";
		final String data = "hi";

		final ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
		valueOperations.set(key, data);

		final String result = valueOperations.get(key);

		assertThat(result).isEqualTo(data);

	}

}
