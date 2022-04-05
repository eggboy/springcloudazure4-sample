package io.jaylee.sca4sample.service;

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

		var cacheValue = redisTemplate.opsForValue().get(value);
		if (cacheValue == null)
			return "null";
		else
			return cacheValue.toString();
	}

}
