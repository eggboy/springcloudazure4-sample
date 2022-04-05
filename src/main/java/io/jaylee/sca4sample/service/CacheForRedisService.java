package io.jaylee.sca4sample.service;

import com.azure.spring.cloud.autoconfigure.redis.AzureRedisAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CacheForRedisService {

	@Autowired
	RedisTemplate redisTemplate;

	public String testRedis(String value) {
		redisTemplate.opsForValue().set(value, value);

		return redisTemplate.opsForValue().get(value).toString();
	}

}
